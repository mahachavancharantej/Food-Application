package com.tap.daoimp;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.Orderitemdao;
import com.tap.module.Orderitem;
import com.tap.utitity.DBconnection;
public class Orderitemdaoimp implements Orderitemdao{
	

	

	

	    private Connection connection;

	    public Orderitemdaoimp() {
	        connection = DBconnection.getconnection();
	    }

	    @Override
	    public void addOrderItem(Orderitem orderItem) {

	        String sql = "INSERT INTO order_items(order_id, product_id, size_id, quantity, price) VALUES(?,?,?,?,?)";

	        try {

	            PreparedStatement pstmt = connection.prepareStatement(sql);

	            pstmt.setInt(1, orderItem.getOrderId());
	            pstmt.setInt(2, orderItem.getProductId());
	            pstmt.setInt(3, orderItem.getSizeId());
	            pstmt.setInt(4, orderItem.getQuantity());
	            pstmt.setDouble(5, orderItem.getPrice());

	            pstmt.executeUpdate();

	            System.out.println("Order Item Added Successfully");

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public Orderitem getOrderItem(int orderItemId) {

	        Orderitem item = null;

	        String sql = "SELECT * FROM order_items WHERE order_item_id=?";

	        try {

	            PreparedStatement pstmt = connection.prepareStatement(sql);

	            pstmt.setInt(1, orderItemId);

	            ResultSet rs = pstmt.executeQuery();

	            if(rs.next()) {

	                item = new Orderitem();

	                item.setOrderItemId(rs.getInt("order_item_id"));
	                item.setOrderId(rs.getInt("order_id"));
	                item.setProductId(rs.getInt("product_id"));
	                item.setSizeId(rs.getInt("size_id"));
	                item.setQuantity(rs.getInt("quantity"));
	                item.setPrice(rs.getDouble("price"));
	            }

	        } catch(SQLException e) {
	            e.printStackTrace();
	        }

	        return item;
	    }

	    @Override
	    public void updateOrderItem(Orderitem orderItem) {

	        String sql = "UPDATE order_items SET order_id=?, product_id=?, size_id=?, quantity=?, price=? WHERE order_item_id=?";

	        try {

	            PreparedStatement pstmt = connection.prepareStatement(sql);

	            pstmt.setInt(1, orderItem.getOrderId());
	            pstmt.setInt(2, orderItem.getProductId());
	            pstmt.setInt(3, orderItem.getSizeId());
	            pstmt.setInt(4, orderItem.getQuantity());
	            pstmt.setDouble(5, orderItem.getPrice());
	            pstmt.setInt(6, orderItem.getOrderItemId());

	            pstmt.executeUpdate();

	            System.out.println("Order Item Updated Successfully");

	        } catch(SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void deleteOrderItem(int orderItemId) {

	        String sql = "DELETE FROM order_items WHERE order_item_id=?";

	        try {

	            PreparedStatement pstmt = connection.prepareStatement(sql);

	            pstmt.setInt(1, orderItemId);

	            pstmt.executeUpdate();

	            System.out.println("Order Item Deleted Successfully");

	        } catch(SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public List<Orderitem> getAllOrderItems() {

	        List<Orderitem> list = new ArrayList<>();

	        String sql = "SELECT * FROM order_items";

	        try {

	            PreparedStatement pstmt = connection.prepareStatement(sql);

	            ResultSet rs = pstmt.executeQuery();

	            while(rs.next()) {

	                Orderitem item = new Orderitem();

	                item.setOrderItemId(rs.getInt("order_item_id"));
	                item.setOrderId(rs.getInt("order_id"));
	                item.setProductId(rs.getInt("product_id"));
	                item.setSizeId(rs.getInt("size_id"));
	                item.setQuantity(rs.getInt("quantity"));
	                item.setPrice(rs.getDouble("price"));

	                list.add(item);
	            }

	        } catch(SQLException e) {
	            e.printStackTrace();
	        }

	        return list;
	    }

	    @Override
	    public List<Orderitem> getOrderItemsByOrder(int orderId) {

	        List<Orderitem> orderItems = new ArrayList<>();

	        String sql = "SELECT * FROM order_items WHERE order_id=?";

	        try {

	            PreparedStatement pstmt = connection.prepareStatement(sql);

	            pstmt.setInt(1, orderId);

	            ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {

	                Orderitem item = new Orderitem();

	                item.setOrderItemId(rs.getInt("order_item_id"));
	                item.setOrderId(rs.getInt("order_id"));
	                item.setProductId(rs.getInt("product_id"));
	                item.setSizeId(rs.getInt("size_id"));
	                item.setQuantity(rs.getInt("quantity"));
	                item.setPrice(rs.getDouble("price"));

	                orderItems.add(item);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return orderItems;
	    }
	}

