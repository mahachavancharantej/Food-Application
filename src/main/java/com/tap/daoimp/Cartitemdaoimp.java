package com.tap.daoimp;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.Cartitemdao;
import com.tap.module.CartItem;
import com.tap.utitity.DBconnection;

public class Cartitemdaoimp implements Cartitemdao{
	
	    private Connection connection;
	    public Cartitemdaoimp() {
	        connection = DBconnection.getconnection();
	    }

	    @Override
	    public void addCartItem(CartItem cartItem) {

	        String sql = "INSERT INTO cart_items(cart_id, product_id, size_id, quantity, total_price) VALUES(?,?,?,?,?)";

	        try {

	            PreparedStatement pstmt = connection.prepareStatement(sql);

	            pstmt.setInt(1, cartItem.getCartId());
	            pstmt.setInt(2, cartItem.getProductId());
	            pstmt.setInt(3, cartItem.getSizeId());
	            pstmt.setInt(4, cartItem.getQuantity());
	            pstmt.setDouble(5, cartItem.getTotalPrice());

	            pstmt.executeUpdate();

	            System.out.println("Cart Item Added Successfully");

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public CartItem getCartItem(int cartItemId) {

	        CartItem item = null;

	        String sql = "SELECT * FROM cart_items WHERE cart_item_id=?";

	        try {

	            PreparedStatement pstmt =
	                    connection.prepareStatement(sql);

	            pstmt.setInt(1, cartItemId);

	            ResultSet rs = pstmt.executeQuery();

	            if(rs.next()) {

	                item = new CartItem();

	                item.setCartItemId(rs.getInt("cart_item_id"));
	                item.setCartId(rs.getInt("cart_id"));
	                item.setProductId(rs.getInt("product_id"));
	                item.setSizeId(rs.getInt("size_id"));
	                item.setQuantity(rs.getInt("quantity"));
	                item.setTotalPrice(rs.getDouble("total_price"));
	            }

	        }
	        catch(Exception e) {

	            e.printStackTrace();

	        }

	        return item;
	    }

	    @Override
	    public void updateCartItem(CartItem cartItem) {

	        String sql = "UPDATE cart_items SET cart_id=?, product_id=?, size_id=?, quantity=?, total_price=? WHERE cart_item_id=?";

	        try {

	            PreparedStatement pstmt = connection.prepareStatement(sql);

	            pstmt.setInt(1, cartItem.getCartId());
	            pstmt.setInt(2, cartItem.getProductId());
	            pstmt.setInt(3, cartItem.getSizeId());
	            pstmt.setInt(4, cartItem.getQuantity());
	            pstmt.setDouble(5, cartItem.getTotalPrice());
	            pstmt.setInt(6, cartItem.getCartItemId());

	            pstmt.executeUpdate();

	            System.out.println("Cart Item Updated Successfully");

	        } catch(SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void deleteCartItem(int cartItemId) {

	        String sql = "DELETE FROM cart_items WHERE cart_item_id=?";

	        try {

	            PreparedStatement pstmt = connection.prepareStatement(sql);

	            pstmt.setInt(1, cartItemId);

	            pstmt.executeUpdate();

	            System.out.println("Cart Item Deleted Successfully");

	        } catch(SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public List<CartItem> getAllCartItems() {

	        List<CartItem> list = new ArrayList<>();

	        String sql = "SELECT * FROM cart_items";

	        try {

	            PreparedStatement pstmt = connection.prepareStatement(sql);

	            ResultSet rs = pstmt.executeQuery();

	            while(rs.next()) {

	                CartItem item = new CartItem();

	                item.setCartItemId(rs.getInt("cart_item_id"));
	                item.setCartId(rs.getInt("cart_id"));
	                item.setProductId(rs.getInt("product_id"));
	                item.setSizeId(rs.getInt("size_id"));
	                item.setQuantity(rs.getInt("quantity"));
	                item.setTotalPrice(rs.getDouble("total_price"));

	                list.add(item);
	            }

	        } catch(SQLException e) {
	            e.printStackTrace();
	        }

	        return list;
	    }

	    @Override
	    public List<CartItem> getCartItemsByCart(int cartId) {

	        List<CartItem> list = new ArrayList<>();

	        String sql =
	        		"SELECT c.cart_item_id, " +
	        		"c.cart_id, " +
	        		"c.product_id, " +
	        		"c.size_id, " +
	        		"c.quantity, " +
	        		"c.total_price, " +
	        		"p.product_name, " +
	        		"p.restaurant_id, "+
	        		"ps.size_name " +
	        		"FROM cart_items c " +
	        		"JOIN products p ON c.product_id = p.product_id " +
	        		"JOIN product_sizes ps ON c.size_id = ps.size_id " +
	        		"WHERE c.cart_id=?";

	        try {

	            PreparedStatement pstmt = connection.prepareStatement(sql);
	            pstmt.setInt(1, cartId);

	            ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {

	                CartItem item = new CartItem();

	                item.setCartItemId(rs.getInt("cart_item_id"));
	                item.setCartId(rs.getInt("cart_id"));
	                item.setProductId(rs.getInt("product_id"));
	                item.setSizeId(rs.getInt("size_id"));
	                item.setQuantity(rs.getInt("quantity"));
	                item.setTotalPrice(rs.getDouble("total_price"));
	                item.setProductName(rs.getString("product_name"));
	                item.setSizeName(rs.getString("size_name"));
	                item.setRestaurantId(rs.getInt("restaurant_id"));

	                list.add(item);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return list;
	    }

	    @Override
	    public boolean updateQuantity(int cartItemId, int quantity) {

	        String sql = "UPDATE cart_items SET quantity=? WHERE cart_item_id=?";

	        try {

	            PreparedStatement pstmt = connection.prepareStatement(sql);

	            pstmt.setInt(1, quantity);
	            pstmt.setInt(2, cartItemId);

	            return pstmt.executeUpdate() > 0;

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return false;
	    }

	    @Override
	    public boolean deleteCartItemByProduct(int cartId, int productId) {

	        String sql = "DELETE FROM cart_items WHERE cart_id=? AND product_id=?";

	        try {

	            PreparedStatement pstmt = connection.prepareStatement(sql);

	            pstmt.setInt(1, cartId);
	            pstmt.setInt(2, productId);

	            return pstmt.executeUpdate() > 0;

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return false;
	    }

	    @Override
	    public double getCartTotal(int cartId) {

	        double total = 0;

	        String sql = "SELECT SUM(total_price) AS total FROM cart_items WHERE cart_id=?";

	        try {

	            PreparedStatement pstmt = connection.prepareStatement(sql);

	            pstmt.setInt(1, cartId);

	            ResultSet rs = pstmt.executeQuery();

	            if (rs.next()) {
	                total = rs.getDouble("total");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return total;
	    }

	    @Override
	    public boolean clearCartItems(int cartId) {

	        String sql = "DELETE FROM cart_items WHERE cart_id=?";

	        try {

	            PreparedStatement pstmt = connection.prepareStatement(sql);

	            pstmt.setInt(1, cartId);

	            return pstmt.executeUpdate() > 0;

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return false;
	    }

		
		public CartItem getCartItem(int cartId,
		                            int productId,
		                            int sizeId) {

		    CartItem item = null;

		    String sql =
		    "SELECT * FROM cart_items WHERE cart_id=? AND product_id=? AND size_id=?";

		    try {

		        PreparedStatement pstmt =
		                connection.prepareStatement(sql);

		        pstmt.setInt(1, cartId);
		        pstmt.setInt(2, productId);
		        pstmt.setInt(3, sizeId);

		        ResultSet rs = pstmt.executeQuery();

		        if(rs.next()) {

		            item = new CartItem();

		            item.setCartItemId(rs.getInt("cart_item_id"));
		            item.setCartId(rs.getInt("cart_id"));
		            item.setProductId(rs.getInt("product_id"));
		            item.setSizeId(rs.getInt("size_id"));
		            item.setQuantity(rs.getInt("quantity"));
		            item.setTotalPrice(rs.getDouble("total_price"));
		        }

		    }
		    catch(Exception e) {

		        e.printStackTrace();

		    }

		    return item;
		}

		@Override
		public void updateCartItemQuantity(int cartItemId,
		                                   int quantity,
		                                   double totalPrice) {

		    String sql =
		    "UPDATE cart_items SET quantity=?, total_price=? WHERE cart_item_id=?";

		    try {

		        PreparedStatement pstmt =
		                connection.prepareStatement(sql);

		        pstmt.setInt(1, quantity);

		        pstmt.setDouble(2, totalPrice);

		        pstmt.setInt(3, cartItemId);

		        pstmt.executeUpdate();

		    }
		    catch(Exception e) {

		        e.printStackTrace();

		    }

		}
	}

