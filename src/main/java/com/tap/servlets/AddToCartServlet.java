package com.tap.servlets;

import java.io.IOException;
import java.sql.Timestamp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.tap.dao.Cartdao;
import com.tap.dao.Cartitemdao;
import com.tap.dao.Productsizedao;
import com.tap.daoimp.Cartdaoimp;
import com.tap.daoimp.Cartitemdaoimp;
import com.tap.daoimp.Productsizedaoimp;
import com.tap.module.Cart;
import com.tap.module.CartItem;
import com.tap.module.Productsize;
import com.tap.module.User;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int productId = Integer.parseInt(request.getParameter("productId"));
        int sizeId = Integer.parseInt(request.getParameter("sizeId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("loggedUser");

        if(user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Cartdao cartDao = new Cartdaoimp();
        Cartitemdao cartItemDao = new Cartitemdaoimp();
        Productsizedao sizeDao = new Productsizedaoimp();

        // Check if user already has a cart
        Cart cart = cartDao.getCartByUser(user.getUserId());

        if(cart == null) {

            Cart newCart = new Cart();

            newCart.setUserId(user.getUserId());
            newCart.setCreatedAt(new Timestamp(System.currentTimeMillis()));

            cartDao.addCart(newCart);

            cart = cartDao.getCartByUser(user.getUserId());
        }

        // Get selected size
        Productsize size = sizeDao.getProductSize(sizeId);

        double totalPrice = size.getPrice() * quantity;

        CartItem item = new CartItem();

        item.setCartId(cart.getCartId());
        item.setProductId(productId);
        item.setSizeId(sizeId);
        item.setQuantity(quantity);
        item.setTotalPrice(totalPrice);

        CartItem existingItem =
        		cartItemDao.getCartItem(
        		        cart.getCartId(),
        		        productId,
        		        sizeId);

        		if(existingItem != null){

        		    int newQuantity =
        		            existingItem.getQuantity() + quantity;

        		    double newTotal =
        		            size.getPrice() * newQuantity;

        		    cartItemDao.updateCartItemQuantity(
        		            existingItem.getCartItemId(),
        		            newQuantity,
        		            newTotal);

        		}
        		else{

        		    cartItemDao.addCartItem(item);

        		}

        response.sendRedirect("cart");
    }
}