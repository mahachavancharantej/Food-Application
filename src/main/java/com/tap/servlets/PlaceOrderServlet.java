package com.tap.servlets;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.tap.dao.Cartdao;
import com.tap.dao.Cartitemdao;
import com.tap.dao.Orderdao;
import com.tap.dao.Orderitemdao;
import com.tap.daoimp.Cartdaoimp;
import com.tap.daoimp.Cartitemdaoimp;
import com.tap.daoimp.Orderdaoimp;
import com.tap.daoimp.Orderitemdaoimp;
import com.tap.module.Cart;
import com.tap.module.CartItem;
import com.tap.module.Order;
import com.tap.module.Orderitem;
import com.tap.module.User;

@WebServlet("/placeOrder")
public class PlaceOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("loggedUser");

        if(user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        System.out.println("Logged User ID: " + user.getUserId());

        String address = request.getParameter("address");
        String paymentMethod = request.getParameter("payment");

        Cartdao cartDao = new Cartdaoimp();

        Cart cart = cartDao.getCartByUser(user.getUserId());

        if(cart == null) {
            response.sendRedirect("cart");
            return;
        }

        Cartitemdao cartItemDao = new Cartitemdaoimp();

        List<CartItem> cartItems =
                cartItemDao.getCartItemsByCart(cart.getCartId());

        double total =
                cartItemDao.getCartTotal(cart.getCartId());

        if(cartItems.isEmpty()) {
            response.sendRedirect("cart");
            return;
        }

        // Restaurant ID (all items should belong to one restaurant)
        int restaurantId = cartItems.get(0).getRestaurantId();
        Order order = new Order();

        order.setUserId(user.getUserId());

        order.setRestaurantId(restaurantId);

        order.setTotalAmount(total);

        order.setOrderStatus("Pending");

        order.setPaymentMethod(paymentMethod);

        if(paymentMethod.equals("Cash"))
            order.setPaymentStatus("Pending");
        else
            order.setPaymentStatus("Paid");

        order.setDeliveryAddress(address);
        order.setOrderDate(
                new java.sql.Timestamp(System.currentTimeMillis()));

        Orderdao orderDao = new Orderdaoimp();

        orderDao.addOrder(order);
        System.out.println("Generated Order ID: " + order.getOrderId());

        int orderId = order.getOrderId();

        Orderitemdao orderItemDao =
                new Orderitemdaoimp();

        for(CartItem item : cartItems){

            Orderitem oi = new Orderitem();

            oi.setOrderId(orderId);
            oi.setProductId(item.getProductId());
            oi.setSizeId(item.getSizeId());
            oi.setQuantity(item.getQuantity());
            oi.setPrice(item.getTotalPrice());

            orderItemDao.addOrderItem(oi);
        }

        cartItemDao.clearCartItems(cart.getCartId());

        response.sendRedirect("orderSuccess.jsp");
    }
}