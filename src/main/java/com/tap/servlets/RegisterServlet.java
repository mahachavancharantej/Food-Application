package com.tap.servlets;


import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.tap.dao.Userdao;
import com.tap.daoimp.userdaoimp;
import com.tap.module.User;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	    private static final long serialVersionUID = 1L;

	    protected void doPost(HttpServletRequest request,
	                          HttpServletResponse response)
	            throws ServletException, IOException {

	        String username = request.getParameter("username");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        String phone = request.getParameter("phone");
	        String address = request.getParameter("address");
	        String role = request.getParameter("role");

	        User user = new User();

	        user.setUsername(username);
	        user.setEmail(email);
	        user.setPassword(password);
	        user.setPhone(phone);
	        user.setAddress(address);
	        user.setRole(role);

	        Timestamp current = new Timestamp(System.currentTimeMillis());

	        user.setCreateDate(current);
	        user.setLastLoginDate(current);

	        Userdao dao = new userdaoimp();

	        dao.addUser(user);

	        response.sendRedirect("login.jsp");
	    }
	}

