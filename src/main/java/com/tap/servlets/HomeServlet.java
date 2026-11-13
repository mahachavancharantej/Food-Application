package com.tap.servlets;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.tap.dao.Restaurantdao;
import com.tap.daoimp.Restaurantdaoimp;
import com.tap.daoimp.Restaurantdaoimp;
import com.tap.module.Restaurant;


@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Restaurantdao dao = new Restaurantdaoimp();

        List<Restaurant> restaurants = dao.getAllRestaurants();

        request.setAttribute("restaurants", restaurants);

        request.getRequestDispatcher("home.jsp")
               .forward(request, response);

    }

}