package com.tap.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.tap.dao.Cartitemdao;
import com.tap.daoimp.Cartitemdaoimp;

@WebServlet("/removeCartItem")
public class RemoveCartItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int cartItemId =
                Integer.parseInt(request.getParameter("cartItemId"));

        Cartitemdao dao =
                new Cartitemdaoimp();

        dao.deleteCartItem(cartItemId);

        response.sendRedirect("cart");
    }
}