package com.tap.daoimp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.tap.dao.Menudao;
import com.tap.module.Menu;
import com.tap.utitity.DBconnection;
public class Menudaoimp implements Menudao{
	
	    private Connection connection;
	    public Menudaoimp() {
	        connection = DBconnection.getconnection();
	    }
	        @Override
	        public void addMenu(Menu menu) {

	            String sql = "INSERT INTO products(restaurant_id, category_id, product_name, description, image_url, base_price, is_available) VALUES(?,?,?,?,?,?,?)";

	            try {

	                PreparedStatement pstmt = connection.prepareStatement(sql);

	                pstmt.setInt(1, menu.getRestaurantId());
	                pstmt.setInt(2, menu.getCategoryId());
	                pstmt.setString(3, menu.getProductName());
	                pstmt.setString(4, menu.getDescription());
	                pstmt.setString(5, menu.getImageUrl());
	                pstmt.setDouble(6, menu.getBasePrice());
	                pstmt.setBoolean(7, menu.isAvailable());

	                int rows = pstmt.executeUpdate();

	                if(rows > 0) {
	                    System.out.println("Menu Item Added Successfully");
	                }

	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

	        @Override
	        public Menu getMenu(int productId) {

	            Menu menu = null;

	            String sql = "SELECT * FROM products WHERE product_id=?";

	            try {

	                PreparedStatement pstmt = connection.prepareStatement(sql);
	                pstmt.setInt(1, productId);

	                ResultSet rs = pstmt.executeQuery();

	                if(rs.next()) {

	                    menu = new Menu();

	                    menu.setProductId(rs.getInt("product_id"));
	                    menu.setRestaurantId(rs.getInt("restaurant_id"));
	                    menu.setCategoryId(rs.getInt("category_id"));
	                    menu.setProductName(rs.getString("product_name"));
	                    menu.setDescription(rs.getString("description"));
	                    menu.setImageUrl(rs.getString("image_url"));
	                    menu.setBasePrice(rs.getDouble("base_price"));
	                    menu.setAvailable(rs.getBoolean("is_available"));
	                }

	            } catch (Exception e) {
	                e.printStackTrace();
	            }

	            return menu;
	        }

	        @Override
	        public void updateMenu(Menu menu) {

	            String sql = "UPDATE products SET restaurant_id=?, category_id=?, product_name=?, description=?, image_url=?, base_price=?, is_available=? WHERE product_id=?";

	            try {

	                PreparedStatement pstmt = connection.prepareStatement(sql);

	                pstmt.setInt(1, menu.getRestaurantId());
	                pstmt.setInt(2, menu.getCategoryId());
	                pstmt.setString(3, menu.getProductName());
	                pstmt.setString(4, menu.getDescription());
	                pstmt.setString(5, menu.getImageUrl());
	                pstmt.setDouble(6, menu.getBasePrice());
	                pstmt.setBoolean(7, menu.isAvailable());
	                pstmt.setInt(8, menu.getProductId());

	                int rows = pstmt.executeUpdate();

	                if(rows > 0) {
	                    System.out.println("Menu Updated Successfully");
	                }

	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

	        @Override
	        public void deleteMenu(int productId) {

	            String sql = "DELETE FROM products WHERE product_id=?";

	            try {

	                PreparedStatement pstmt = connection.prepareStatement(sql);

	                pstmt.setInt(1, productId);

	                int rows = pstmt.executeUpdate();

	                if(rows > 0) {
	                    System.out.println("Menu Deleted Successfully");
	                }

	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

	        @Override
	        public List<Menu> getAllMenus() {

	            List<Menu> menuList = new ArrayList<>();

	            String sql = "SELECT * FROM products";

	            try {

	                PreparedStatement pstmt = connection.prepareStatement(sql);

	                ResultSet rs = pstmt.executeQuery();

	                while(rs.next()) {

	                    Menu menu = new Menu();

	                    menu.setProductId(rs.getInt("product_id"));
	                    menu.setRestaurantId(rs.getInt("restaurant_id"));
	                    menu.setCategoryId(rs.getInt("category_id"));
	                    menu.setProductName(rs.getString("product_name"));
	                    menu.setDescription(rs.getString("description"));
	                    menu.setImageUrl(rs.getString("image_url"));
	                    menu.setBasePrice(rs.getDouble("base_price"));
	                    menu.setAvailable(rs.getBoolean("is_available"));

	                    menuList.add(menu);
	                }

	            } catch (Exception e) {
	                e.printStackTrace();
	            }

	            return menuList;
	        }

	        @Override
	        public List<Menu> getMenusByRestaurant(int restaurantId) {

	            List<Menu> menuList = new ArrayList<>();

	            String sql = "SELECT * FROM products WHERE restaurant_id=?";

	            try {

	                PreparedStatement pstmt = connection.prepareStatement(sql);

	                pstmt.setInt(1, restaurantId);

	                ResultSet rs = pstmt.executeQuery();

	                while(rs.next()) {

	                    Menu menu = new Menu();

	                    menu.setProductId(rs.getInt("product_id"));
	                    menu.setRestaurantId(rs.getInt("restaurant_id"));
	                    menu.setCategoryId(rs.getInt("category_id"));
	                    menu.setProductName(rs.getString("product_name"));
	                    menu.setDescription(rs.getString("description"));
	                    menu.setImageUrl(rs.getString("image_url"));
	                    menu.setBasePrice(rs.getDouble("base_price"));
	                    menu.setAvailable(rs.getBoolean("is_available"));

	                    menuList.add(menu);
	                }

	            } catch(SQLException e) {
	                e.printStackTrace();
	            }

	            return menuList;
	        }

	        @Override
	        public List<Menu> getMenusByCategory(int categoryId) {

	            List<Menu> menuList = new ArrayList<>();

	            String sql = "SELECT * FROM products WHERE category_id=?";

	            try {

	                PreparedStatement pstmt = connection.prepareStatement(sql);

	                pstmt.setInt(1, categoryId);

	                ResultSet rs = pstmt.executeQuery();

	                while (rs.next()) {

	                    Menu menu = new Menu();

	                    menu.setProductId(rs.getInt("product_id"));
	                    menu.setRestaurantId(rs.getInt("restaurant_id"));
	                    menu.setCategoryId(rs.getInt("category_id"));
	                    menu.setProductName(rs.getString("product_name"));
	                    menu.setDescription(rs.getString("description"));
	                    menu.setImageUrl(rs.getString("image_url"));
	                    menu.setBasePrice(rs.getDouble("base_price"));
	                    menu.setAvailable(rs.getBoolean("is_available"));

	                    menuList.add(menu);
	                }

	            } catch (SQLException e) {
	                e.printStackTrace();
	            }

	            return menuList;
	        }

	        @Override
	        public List<Menu> searchMenus(String keyword) {

	            List<Menu> menuList = new ArrayList<>();

	            String sql = "SELECT * FROM products WHERE product_name LIKE ?";

	            try {

	                PreparedStatement pstmt = connection.prepareStatement(sql);

	                pstmt.setString(1, "%" + keyword + "%");

	                ResultSet rs = pstmt.executeQuery();

	                while (rs.next()) {

	                    Menu menu = new Menu();

	                    menu.setProductId(rs.getInt("product_id"));
	                    menu.setRestaurantId(rs.getInt("restaurant_id"));
	                    menu.setCategoryId(rs.getInt("category_id"));
	                    menu.setProductName(rs.getString("product_name"));
	                    menu.setDescription(rs.getString("description"));
	                    menu.setImageUrl(rs.getString("image_url"));
	                    menu.setBasePrice(rs.getDouble("base_price"));
	                    menu.setAvailable(rs.getBoolean("is_available"));

	                    menuList.add(menu);
	                }

	            } catch (SQLException e) {
	                e.printStackTrace();
	            }

	            return menuList;
	        }
	    }

