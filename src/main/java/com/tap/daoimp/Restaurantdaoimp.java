package com.tap.daoimp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.tap.dao.Restaurantdao;
import com.tap.module.Restaurant;
import com.tap.utitity.DBconnection;

public class Restaurantdaoimp implements Restaurantdao {

    private Connection connection;

    public  Restaurantdaoimp() {
        connection = DBconnection.getconnection();
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {

    	String sql = "INSERT INTO restaurants(restaurant_name, owner_name, phone, email, address, image_url, rating, status, cuisine, delivery_time, price_for_two) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, restaurant.getRestaurantName());
            ps.setString(2, restaurant.getOwnerName());
            ps.setString(3, restaurant.getPhone());
            ps.setString(4, restaurant.getEmail());
            ps.setString(5, restaurant.getAddress());
            ps.setString(6, restaurant.getImageUrl());
            ps.setDouble(7, restaurant.getRating());
            ps.setString(8, restaurant.getStatus());
            ps.setString(9, restaurant.getCuisine());
            ps.setInt(10, restaurant.getDeliveryTime());
            ps.setInt(11, restaurant.getPriceForTwo());

            int rows = ps.executeUpdate();

            if(rows > 0) {
                System.out.println("Restaurant Added Successfully");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Restaurant getRestaurant(int restaurantId) {

        Restaurant restaurant = null;

        String sql = "SELECT * FROM restaurants WHERE restaurant_id=?";

        try {

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, restaurantId);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {

                restaurant = new Restaurant();

                restaurant.setRestaurantId(rs.getInt("restaurant_id"));
                restaurant.setRestaurantName(rs.getString("restaurant_name"));
                restaurant.setOwnerName(rs.getString("owner_name"));
                restaurant.setPhone(rs.getString("phone"));
                restaurant.setEmail(rs.getString("email"));
                restaurant.setAddress(rs.getString("address"));
                restaurant.setImageUrl(rs.getString("image_url"));
                restaurant.setRating(rs.getDouble("rating"));
                restaurant.setStatus(rs.getString("status"));
                restaurant.setCuisine(rs.getString("cuisine"));
                restaurant.setDeliveryTime(rs.getInt("delivery_time"));
                restaurant.setPriceForTwo(rs.getInt("price_for_two"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return restaurant;
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {

    	String sql =
    			"UPDATE restaurants SET restaurant_name=?, owner_name=?, phone=?, email=?, address=?, image_url=?, rating=?, status=?, cuisine=?, delivery_time=?, price_for_two=? WHERE restaurant_id=?";
        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, restaurant.getRestaurantName());
            ps.setString(2, restaurant.getOwnerName());
            ps.setString(3, restaurant.getPhone());
            ps.setString(4, restaurant.getEmail());
            ps.setString(5, restaurant.getAddress());
            ps.setString(6, restaurant.getImageUrl());
            ps.setDouble(7, restaurant.getRating());
            ps.setString(8, restaurant.getStatus());
            ps.setString(9, restaurant.getCuisine());
            ps.setInt(10, restaurant.getDeliveryTime());
            ps.setInt(11, restaurant.getPriceForTwo());
            ps.setInt(12, restaurant.getRestaurantId());

            int rows = ps.executeUpdate();

            if(rows > 0) {
                System.out.println("Restaurant Updated Successfully");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRestaurant(int restaurantId) {

        String sql = "DELETE FROM restaurants WHERE restaurant_id=?";

        try {

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, restaurantId);

            int rows = pstmt.executeUpdate();

            if(rows > 0) {
                System.out.println("Restaurant Deleted Successfully");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Restaurant> getAllRestaurants() {

        List<Restaurant> restaurantList = new ArrayList<>();

        String sql = "SELECT * FROM restaurants";

        try {

            PreparedStatement pstmt = connection.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {

                Restaurant restaurant = new Restaurant();

                restaurant.setRestaurantId(rs.getInt("restaurant_id"));
                restaurant.setRestaurantName(rs.getString("restaurant_name"));
                restaurant.setOwnerName(rs.getString("owner_name"));
                restaurant.setPhone(rs.getString("phone"));
                restaurant.setEmail(rs.getString("email"));
                restaurant.setAddress(rs.getString("address"));
                restaurant.setImageUrl(rs.getString("image_url"));
                restaurant.setRating(rs.getDouble("rating"));
                restaurant.setStatus(rs.getString("status"));
                restaurant.setCuisine(rs.getString("cuisine"));
                restaurant.setDeliveryTime(rs.getInt("delivery_time"));
                restaurant.setPriceForTwo(rs.getInt("price_for_two"));
                restaurantList.add(restaurant);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return restaurantList;
    }

    @Override
    public List<Restaurant> getRestaurantsByStatus(String status) {

        List<Restaurant> restaurantList = new ArrayList<>();

        String sql = "SELECT * FROM restaurants WHERE status=?";

        try {

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, status);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                Restaurant restaurant = new Restaurant();

                restaurant.setRestaurantId(rs.getInt("restaurant_id"));
                restaurant.setRestaurantName(rs.getString("restaurant_name"));
                restaurant.setOwnerName(rs.getString("owner_name"));
                restaurant.setPhone(rs.getString("phone"));
                restaurant.setEmail(rs.getString("email"));
                restaurant.setAddress(rs.getString("address"));
                restaurant.setImageUrl(rs.getString("image_url"));
                restaurant.setRating(rs.getDouble("rating"));
                restaurant.setStatus(rs.getString("status"));
                restaurant.setCuisine(rs.getString("cuisine"));
                restaurant.setDeliveryTime(rs.getInt("delivery_time"));
                restaurant.setPriceForTwo(rs.getInt("price_for_two"));

                restaurantList.add(restaurant);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return restaurantList;
    }
    @Override
    public List<Restaurant> searchRestaurants(String keyword) {

        List<Restaurant> restaurantList = new ArrayList<>();

        String sql = "SELECT * FROM restaurants WHERE restaurant_name LIKE ?";

        try {

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, "%" + keyword + "%");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                Restaurant restaurant = new Restaurant();

                restaurant.setRestaurantId(rs.getInt("restaurant_id"));
                restaurant.setRestaurantName(rs.getString("restaurant_name"));
                restaurant.setOwnerName(rs.getString("owner_name"));
                restaurant.setPhone(rs.getString("phone"));
                restaurant.setEmail(rs.getString("email"));
                restaurant.setAddress(rs.getString("address"));
                restaurant.setImageUrl(rs.getString("image_url"));
                restaurant.setRating(rs.getDouble("rating"));
                restaurant.setStatus(rs.getString("status"));
                restaurant.setCuisine(rs.getString("cuisine"));
                restaurant.setDeliveryTime(rs.getInt("delivery_time"));
                restaurant.setPriceForTwo(rs.getInt("price_for_two"));

                restaurantList.add(restaurant);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return restaurantList;
    }
}