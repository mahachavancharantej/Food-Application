package com.tap.daoimp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.tap.dao.Userdao;
import com.tap.module.User;
import com.tap.utitity.*;

public class userdaoimp implements Userdao{
	Connection con = DBconnection.getconnection();
	    public void addUser(User user) {
	    	    String sql = "INSERT INTO users(username,password,email,phone,address,role,created_at,last_login_date) VALUES(?,?,?,?,?,?,?,?)";
	    	    try {
	    	        PreparedStatement ps = con.prepareStatement(sql);
	    	        ps.setString(1, user.getUsername());
	    	        ps.setString(2, user.getPassword());
	    	        ps.setString(3, user.getEmail());
	    	        ps.setString(4, user.getPhone());
	    	        ps.setString(5, user.getAddress());
	    	        ps.setString(6, user.getRole());
	    	        ps.setTimestamp(7, user.getCreateDate());
	    	        ps.setTimestamp(8, user.getLastLoginDate());
	    	        ps.executeUpdate();
	    	    } catch (SQLException e) {
	    	        e.printStackTrace();
	    	    }
	    	}
	    @Override
	    public User getUser(int userId) {
	    	    User user = null;
	    	    String sql = "SELECT * FROM users WHERE user_id=?";
	    	    try {
	    	        PreparedStatement ps = con.prepareStatement(sql);
	    	        ps.setInt(1, userId);
	    	        ResultSet rs = ps.executeQuery();
	    	        if(rs.next()) {
	    	            user = new User();
	    	            user.setUserId(rs.getInt("user_id"));
	    	            user.setUsername(rs.getString("username"));
	    	            user.setPassword(rs.getString("password"));
	    	            user.setEmail(rs.getString("email"));
	    	            user.setPhone(rs.getString("phone"));
	    	            user.setAddress(rs.getString("address"));
	    	            user.setRole(rs.getString("role"));
	    	            user.setCreateDate(rs.getTimestamp("created_at"));
	    	            user.setLastLoginDate(rs.getTimestamp("last_login_date"));
	    	        }

	    	    } catch (SQLException e) {
	    	        e.printStackTrace();
	    	    }

	    	    return user;
	    	}
	    public void updateUser(User user) {
	    	    String sql = "UPDATE users SET username=?,password=?,email=?,phone=?,address=?,role=?,last_login_date=? WHERE user_id=?";
	    	    try {
	    	        PreparedStatement ps = con.prepareStatement(sql);
	    	        ps.setString(1, user.getUsername());
	    	        ps.setString(2, user.getPassword());
	    	        ps.setString(3, user.getEmail());
	    	        ps.setString(4, user.getPhone());
	    	        ps.setString(5, user.getAddress());
	    	        ps.setString(6, user.getRole());
	    	        ps.setDate(7, new java.sql.Date(user.getLastLoginDate().getTime()));
	    	        ps.setInt(8, user.getUserId());
	    	        ps.executeUpdate();
	    	    } catch(SQLException e) {
	    	        e.printStackTrace();
	    	    }
	    	}
	    public void deleteUser(int userId) {
	    	    String sql = "DELETE FROM users WHERE user_id=?";
	    	    try {
	    	        PreparedStatement ps = con.prepareStatement(sql);
	    	        ps.setInt(1, userId);
	    	        ps.executeUpdate();
	    	    } catch(SQLException e) {
	    	        e.printStackTrace();
	    	    }
	    	}
	    public List<User> getAllUsers() {
	    	    List<User> users = new ArrayList<>();
	    	    String sql = "SELECT * FROM users";
	    	    try {
	    	        PreparedStatement ps = con.prepareStatement(sql);
	    	        ResultSet rs = ps.executeQuery();
	    	        while(rs.next()) {
	    	            User user = new User();
	    	            user.setUserId(rs.getInt("user_id"));
	    	            user.setUsername(rs.getString("username"));
	    	            user.setPassword(rs.getString("password"));
	    	            user.setEmail(rs.getString("email"));
	    	            user.setPhone(rs.getString("phone"));
	    	            user.setAddress(rs.getString("address"));
	    	            user.setRole(rs.getString("role"));
	    	            user.setCreateDate(rs.getTimestamp("created_at"));
	    	            user.setLastLoginDate(rs.getTimestamp("last_login_date"));
	    	            users.add(user);
	    	        }
	    	    } catch(SQLException e) {
	    	        e.printStackTrace();
	    	    }
	    	    return users;
	    	}
		@Override
		
			public User getUserByEmail(String email) {

			    User user = null;

			    String sql = "SELECT * FROM users WHERE email=?";

			    try {

			        PreparedStatement pstmt = con.prepareStatement(sql);

			        pstmt.setString(1, email);

			        ResultSet rs = pstmt.executeQuery();

			        if (rs.next()) {

			            user = new User();

			            user.setUserId(rs.getInt("user_id"));
			            user.setUsername(rs.getString("username"));
			            user.setEmail(rs.getString("email"));
			            user.setPassword(rs.getString("password"));
			            user.setPhone(rs.getString("phone"));
			            user.setAddress(rs.getString("address"));
			            user.setRole(rs.getString("role"));
			            user.setCreateDate(rs.getTimestamp("created_at"));
			            user.setLastLoginDate(rs.getTimestamp("last_login_date"));
			        }

			    } catch (SQLException e) {
			        e.printStackTrace();
			    }

			    return user;
			}
			
		
		@Override
		public User validateUser(String email, String password) {

		    User user = null;

		    String sql = "SELECT * FROM users WHERE email=? AND password=?";

		    try {

		        PreparedStatement pstmt = con.prepareStatement(sql);

		        pstmt.setString(1, email);
		        pstmt.setString(2, password);

		        ResultSet rs = pstmt.executeQuery();

		        if (rs.next()) {

		            user = new User();

		            user.setUserId(rs.getInt("user_id"));
		            user.setUsername(rs.getString("username"));
		            user.setEmail(rs.getString("email"));
		            user.setPassword(rs.getString("password"));
		            user.setPhone(rs.getString("phone"));
		            user.setAddress(rs.getString("address"));
		            user.setRole(rs.getString("role"));
		            user.setCreateDate(rs.getTimestamp("created_at"));
		            user.setLastLoginDate(rs.getTimestamp("last_login_date"));
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return user;
		}
	
	

}

