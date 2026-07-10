package com.tap.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.tap.dao.Cartdao;
import com.tap.dao.Cartitemdao;
import com.tap.daoimp.Cartdaoimp;
import com.tap.daoimp.Cartitemdaoimp;
import com.tap.module.Cart;
import com.tap.module.CartItem;
import com.tap.module.User;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("loggedUser");

        if(user == null) {

            response.sendRedirect("login.jsp");

            return;
        }

        Cartdao cartDao = new Cartdaoimp();

        Cart cart = cartDao.getCartByUser(user.getUserId());

        if(cart == null) {

            response.sendRedirect("home");

            return;
        }

        Cartitemdao cartItemDao = new Cartitemdaoimp();

        List<CartItem> cartItems =
                cartItemDao.getCartItemsByCart(cart.getCartId());

        double total =
                cartItemDao.getCartTotal(cart.getCartId());

        request.setAttribute("cartItems", cartItems);

        request.setAttribute("total", total);

        request.getRequestDispatcher("Cart.jsp")
               .forward(request, response);
    }

}