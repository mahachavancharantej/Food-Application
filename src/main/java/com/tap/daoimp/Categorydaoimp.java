package com.tap.daoimp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.tap.dao.Categorydao;
import com.tap.module.Category;
import com.tap.utitity.DBconnection;

public class Categorydaoimp implements Categorydao{


	    private Connection connection;

	    public Categorydaoimp() {
	        connection = DBconnection.getconnection();
	    }

	    @Override
	    public void addCategory(Category category) {

	        String sql = "INSERT INTO categories(category_name) VALUES(?)";

	        try {

	            PreparedStatement pstmt = connection.prepareStatement(sql);

	            pstmt.setString(1, category.getCategoryName());

	            int rows = pstmt.executeUpdate();

	            if(rows > 0) {
	                System.out.println("Category Added Successfully");
	            }

	        } catch(SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public Category getCategory(int categoryId) {

	        Category category = null;

	        String sql = "SELECT * FROM categories WHERE category_id=?";

	        try {

	            PreparedStatement pstmt = connection.prepareStatement(sql);

	            pstmt.setInt(1, categoryId);

	            ResultSet rs = pstmt.executeQuery();

	            if(rs.next()) {

	                category = new Category();

	                category.setCategoryId(rs.getInt("category_id"));
	                category.setCategoryName(rs.getString("category_name"));
	            }

	        } catch(SQLException e) {
	            e.printStackTrace();
	        }

	        return category;
	    }

	    @Override
	    public void updateCategory(Category category) {

	        String sql = "UPDATE categories SET category_name=? WHERE category_id=?";

	        try {

	            PreparedStatement pstmt = connection.prepareStatement(sql);

	            pstmt.setString(1, category.getCategoryName());
	            pstmt.setInt(2, category.getCategoryId());

	            int rows = pstmt.executeUpdate();

	            if(rows > 0) {
	                System.out.println("Category Updated Successfully");
	            }

	        } catch(SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void deleteCategory(int categoryId) {

	        String sql = "DELETE FROM categories WHERE category_id=?";

	        try {

	            PreparedStatement pstmt = connection.prepareStatement(sql);

	            pstmt.setInt(1, categoryId);

	            int rows = pstmt.executeUpdate();

	            if(rows > 0) {
	                System.out.println("Category Deleted Successfully");
	            }

	        } catch(SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public List<Category> getAllCategories() {

	        List<Category> categoryList = new ArrayList<>();

	        String sql = "SELECT * FROM categories";

	        try {

	            PreparedStatement pstmt = connection.prepareStatement(sql);

	            ResultSet rs = pstmt.executeQuery();

	            while(rs.next()) {

	                Category category = new Category();

	                category.setCategoryId(rs.getInt("category_id"));
	                category.setCategoryName(rs.getString("category_name"));

	                categoryList.add(category);
	            }

	        } catch(SQLException e) {
	            e.printStackTrace();
	        }

	        return categoryList;
	    }
	}

