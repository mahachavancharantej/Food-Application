package com.tap.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

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