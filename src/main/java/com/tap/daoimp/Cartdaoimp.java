package com.tap.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.Cartdao;
import com.tap.module.Cart;
import com.tap.utitity.DBconnection;

public class Cartdaoimp implements Cartdao {

    private Connection con = DBconnection.getconnection();

    @Override
    public void addCart(Cart cart) {

        String sql = "INSERT INTO cart(user_id, created_at) VALUES(?,?)";

        try {

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, cart.getUserId());
            pstmt.setTimestamp(2, cart.getCreatedAt());

            int rows = pstmt.executeUpdate();

            if(rows > 0) {
                System.out.println("Cart Created Successfully");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cart getCart(int cartId) {

        Cart cart = null;

        String sql = "SELECT * FROM cart WHERE cart_id=?";

        try {

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, cartId);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {

                cart = new Cart();

                cart.setCartId(rs.getInt("cart_id"));
                cart.setUserId(rs.getInt("user_id"));
                cart.setCreatedAt(rs.getTimestamp("created_at"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cart;
    }

    @Override
    public void updateCart(Cart cart) {

        String sql = "UPDATE cart SET user_id=?, created_at=? WHERE cart_id=?";

        try {

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, cart.getUserId());
            pstmt.setTimestamp(2, cart.getCreatedAt());
            pstmt.setInt(3, cart.getCartId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCart(int cartId) {

        String sql = "DELETE FROM cart WHERE cart_id=?";

        try {

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, cartId);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cart> getAllCarts() {

        List<Cart> cartList = new ArrayList<>();

        String sql = "SELECT * FROM cart";

        try {

            PreparedStatement pstmt = con.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {

                Cart cart = new Cart();

                cart.setCartId(rs.getInt("cart_id"));
                cart.setUserId(rs.getInt("user_id"));
                cart.setCreatedAt(rs.getTimestamp("created_at"));

                cartList.add(cart);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cartList;
    }

    @Override
    public Cart getCartByUser(int userId) {

        Cart cart = null;

        String sql = "SELECT * FROM cart WHERE user_id=?";

        try {

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {

                cart = new Cart();

                cart.setCartId(rs.getInt("cart_id"));
                cart.setUserId(rs.getInt("user_id"));
                cart.setCreatedAt(rs.getTimestamp("created_at"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cart;
    }

    @Override
    public void clearCart(int cartId) {

        String sql = "DELETE FROM cart_items WHERE cart_id=?";

        try {

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, cartId);

            pstmt.executeUpdate();

            System.out.println("Cart Cleared Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}