package com.tap.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.tap.dao.Cartitemdao;
import com.tap.dao.Productsizedao;
import com.tap.daoimp.Cartitemdaoimp;
import com.tap.daoimp.Productsizedaoimp;
import com.tap.module.CartItem;
import com.tap.module.Productsize;

@WebServlet("/updateCart")
public class UpdateCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int cartItemId =
                Integer.parseInt(request.getParameter("cartItemId"));

        String action =
                request.getParameter("action");

        Cartitemdao cartDao =
                new Cartitemdaoimp();

        CartItem item =
                cartDao.getCartItem(cartItemId);

        Productsizedao sizeDao =
                new Productsizedaoimp();

        Productsize size =
                sizeDao.getProductSize(item.getSizeId());

        int quantity = item.getQuantity();

        if(action.equals("plus")) {

            quantity++;

        }
        else if(action.equals("minus")) {

            quantity--;

        }

        if(quantity <= 0) {

            cartDao.deleteCartItem(cartItemId);

        }
        else {

            double total =
                    quantity * size.getPrice();

            cartDao.updateCartItemQuantity(
                    cartItemId,
                    quantity,
                    total);

        }

        response.sendRedirect("cart");
    }
}