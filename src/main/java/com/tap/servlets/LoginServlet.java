package com.tap.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.tap.dao.Userdao;
import com.tap.daoimp.userdaoimp;
import com.tap.module.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Userdao dao = new userdaoimp();

        User user = dao.validateUser(email, password);

        if(user != null) {

            HttpSession session = request.getSession();

            session.setAttribute("loggedUser", user);

            response.sendRedirect("home");

        }
        else {

            response.sendRedirect("login.jsp?error=1");

        }

    }

}