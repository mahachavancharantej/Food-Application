package com.tap.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.Orderdao;
import com.tap.module.Order;
import com.tap.utitity.DBconnection;
public class Orderdaoimp implements Orderdao{
	    private Connection connection;

	    public Orderdaoimp() {
	        connection = DBconnection.getconnection();
	    }

	    @Override
	    public void addOrder(Order order) {

	        String sql =
	        "INSERT INTO orders(user_id,restaurant_id,total_amount,order_status,payment_method,payment_status,delivery_address,order_date) VALUES(?,?,?,?,?,?,?,?)";

	        try{

	            PreparedStatement pstmt =
	                    connection.prepareStatement(
	                            sql,
	                            Statement.RETURN_GENERATED_KEYS);

	            pstmt.setInt(1, order.getUserId());
	            pstmt.setInt(2, order.getRestaurantId());
	            pstmt.setDouble(3, order.getTotalAmount());
	            pstmt.setString(4, order.getOrderStatus());
	            pstmt.setString(5, order.getPaymentMethod());
	            pstmt.setString(6, order.getPaymentStatus());
	            pstmt.setString(7, order.getDeliveryAddress());
	            pstmt.setTimestamp(8, order.getOrderDate());

	            pstmt.executeUpdate();

	            ResultSet rs = pstmt.getGeneratedKeys();

	            if(rs.next()){

	                order.setOrderId(rs.getInt(1));

	            }

	        }
	        catch(Exception e){

	            e.printStackTrace();

	        }
	    }

	    @Override
	    public Order getOrder(int orderId) {

	        Order order = null;

	        String sql = "SELECT * FROM orders WHERE order_id=?";

	        try {

	            PreparedStatement pstmt = connection.prepareStatement(sql);
	            pstmt.setInt(1, orderId);

	            ResultSet rs = pstmt.executeQuery();

	            if (rs.next()) {

	                order = new Order();

	                order.setOrderId(rs.getInt("order_id"));
	                order.setUserId(rs.getInt("user_id"));
	                order.setRestaurantId(rs.getInt("restaurant_id"));
	                order.setTotalAmount(rs.getDouble("total_amount"));
	                order.setOrderStatus(rs.getString("order_status"));
	                order.setPaymentMethod(rs.getString("payment_method"));
	                order.setPaymentStatus(rs.getString("payment_status"));
	                order.setDeliveryAddress(rs.getString("delivery_address"));
	                order.setOrderDate(rs.getTimestamp("order_date"));
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return order;
	    }

	    @Override
	    public void updateOrder(Order order) {

	        String sql = "UPDATE orders SET user_id=?, restaurant_id=?, total_amount=?, order_status=?, payment_method=?, payment_status=?, delivery_address=?, order_date=? WHERE order_id=?";

	        try {

	            PreparedStatement pstmt = connection.prepareStatement(sql);

	            pstmt.setInt(1, order.getUserId());
	            pstmt.setInt(2, order.getRestaurantId());
	            pstmt.setDouble(3, order.getTotalAmount());
	            pstmt.setString(4, order.getOrderStatus());
	            pstmt.setString(5, order.getPaymentMethod());
	            pstmt.setString(6, order.getPaymentStatus());
	            pstmt.setString(7, order.getDeliveryAddress());
	            pstmt.setTimestamp(8, order.getOrderDate());
	            pstmt.setInt(9, order.getOrderId());

	            int rows = pstmt.executeUpdate();

	            if (rows > 0) {
	                System.out.println("Order Updated Successfully");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void deleteOrder(int orderId) {

	        String sql = "DELETE FROM orders WHERE order_id=?";

	        try {

	            PreparedStatement pstmt = connection.prepareStatement(sql);

	            pstmt.setInt(1, orderId);

	            int rows = pstmt.executeUpdate();

	            if (rows > 0) {
	                System.out.println("Order Deleted Successfully");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public List<Order> getAllOrders() {

	        List<Order> orderList = new ArrayList<>();

	        String sql = "SELECT * FROM orders";

	        try {

	            PreparedStatement pstmt = connection.prepareStatement(sql);

	            ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {

	                Order order = new Order();

	                order.setOrderId(rs.getInt("order_id"));
	                order.setUserId(rs.getInt("user_id"));
	                order.setRestaurantId(rs.getInt("restaurant_id"));
	                order.setTotalAmount(rs.getDouble("total_amount"));
	                order.setOrderStatus(rs.getString("order_status"));
	                order.setPaymentMethod(rs.getString("payment_method"));
	                order.setPaymentStatus(rs.getString("payment_status"));
	                order.setDeliveryAddress(rs.getString("delivery_address"));
	                order.setOrderDate(rs.getTimestamp("order_date"));

	                orderList.add(order);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return orderList;
	    }

	    @Override
	    public List<Order> getOrdersByUser(int userId) {

	        List<Order> orderList = new ArrayList<>();

	        String sql = "SELECT o.*,\r\n"
	        		+ "       r.restaurant_name\r\n"
	        		+ "FROM orders o\r\n"
	        		+ "JOIN restaurants r\r\n"
	        		+ "ON o.restaurant_id=r.restaurant_id\r\n"
	        		+ "WHERE o.user_id=?\r\n"
	        		+ "ORDER BY o.order_date DESC;";

	        try {

	            PreparedStatement pstmt = connection.prepareStatement(sql);

	            pstmt.setInt(1, userId);

	            ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {

	                Order order = new Order();

	                order.setOrderId(rs.getInt("order_id"));
	                order.setUserId(rs.getInt("user_id"));
	                order.setRestaurantId(rs.getInt("restaurant_id"));
	                order.setRestaurantName(
	                        rs.getString("restaurant_name"));
	                order.setTotalAmount(rs.getDouble("total_amount"));
	                order.setOrderStatus(rs.getString("order_status"));
	                order.setPaymentMethod(rs.getString("payment_method"));
	                order.setPaymentStatus(rs.getString("payment_status"));
	                order.setDeliveryAddress(rs.getString("delivery_address"));
	                order.setOrderDate(rs.getTimestamp("order_date"));

	                orderList.add(order);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return orderList;
	    }

	    @Override
	    public List<Order> getOrdersByRestaurant(int restaurantId) {

	        List<Order> orderList = new ArrayList<>();

	        String sql = "SELECT * FROM orders WHERE restaurant_id=?";

	        try {

	            PreparedStatement pstmt = connection.prepareStatement(sql);

	            pstmt.setInt(1, restaurantId);

	            ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {

	                Order order = new Order();

	                order.setOrderId(rs.getInt("order_id"));
	                order.setUserId(rs.getInt("user_id"));
	                order.setRestaurantId(rs.getInt("restaurant_id"));
	                order.setTotalAmount(rs.getDouble("total_amount"));
	                order.setOrderStatus(rs.getString("order_status"));
	                order.setPaymentMethod(rs.getString("payment_method"));
	                order.setPaymentStatus(rs.getString("payment_status"));
	                order.setDeliveryAddress(rs.getString("delivery_address"));
	                order.setOrderDate(rs.getTimestamp("order_date"));

	                orderList.add(order);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return orderList;
	    }

	    @Override
	    public void updateOrderStatus(int orderId, String status) {

	        String sql = "UPDATE orders SET order_status=? WHERE order_id=?";

	        try {

	            PreparedStatement pstmt = connection.prepareStatement(sql);

	            pstmt.setString(1, status);
	            pstmt.setInt(2, orderId);

	            int rows = pstmt.executeUpdate();

	            if (rows > 0) {
	                System.out.println("Order Status Updated Successfully");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    @Override
	    public void updatePaymentStatus(int orderId, String paymentStatus) {

	        String sql = "UPDATE orders SET payment_status=? WHERE order_id=?";

	        try {

	            PreparedStatement pstmt = connection.prepareStatement(sql);

	            pstmt.setString(1, paymentStatus);
	            pstmt.setInt(2, orderId);

	            pstmt.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

