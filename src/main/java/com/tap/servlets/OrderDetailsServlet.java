package com.tap.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.dao.Orderdao;
import com.tap.dao.Orderitemdao;
import com.tap.dao.Restaurantdao;
import com.tap.dao.Menudao;
import com.tap.dao.Productsizedao;
import com.tap.daoimp.Orderdaoimp;
import com.tap.daoimp.Orderitemdaoimp;
import com.tap.daoimp.Restaurantdaoimp;
import com.tap.daoimp.Menudaoimp;
import com.tap.daoimp.Productsizedaoimp;
import com.tap.module.Order;
import com.tap.module.Orderitem;
import com.tap.module.Restaurant;
import com.tap.module.Menu;
import com.tap.module.Productsize;
import com.tap.module.User;

@WebServlet("/orderDetails")
public class OrderDetailsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loggedUser");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String orderIdStr = request.getParameter("orderId");
        if (orderIdStr == null || orderIdStr.trim().isEmpty()) {
            response.sendRedirect("myOrders");
            return;
        }

        try {
            int orderId = Integer.parseInt(orderIdStr);

            Orderdao orderDao = new Orderdaoimp();
            Order order = orderDao.getOrder(orderId);

            if (order == null || order.getUserId() != user.getUserId()) {
                response.sendRedirect("myOrders");
                return;
            }

            Restaurantdao restaurantDao = new Restaurantdaoimp();
            Restaurant restaurant = restaurantDao.getRestaurant(order.getRestaurantId());

            Orderitemdao orderItemDao = new Orderitemdaoimp();
            List<Orderitem> items = orderItemDao.getOrderItemsByOrder(orderId);

            Menudao menuDao = new Menudaoimp();
            Productsizedao sizeDao = new Productsizedaoimp();

            List<Map<String, Object>> detailedItems = new ArrayList<>();
            for (Orderitem item : items) {
                Map<String, Object> map = new HashMap<>();
                map.put("quantity", item.getQuantity());
                map.put("totalPrice", item.getPrice());
                
                Menu menu = menuDao.getMenu(item.getProductId());
                if (menu != null) {
                    map.put("productName", menu.getProductName());
                    map.put("imageUrl", menu.getImageUrl());
                } else {
                    map.put("productName", "Unknown Product");
                    map.put("imageUrl", "");
                }

                Productsize size = sizeDao.getProductSize(item.getSizeId());
                if (size != null) {
                    map.put("sizeName", size.getSizeName());
                    map.put("unitPrice", size.getPrice());
                } else {
                    map.put("sizeName", "Standard");
                    map.put("unitPrice", item.getPrice() / item.getQuantity());
                }

                detailedItems.add(map);
            }

            request.setAttribute("order", order);
            request.setAttribute("restaurant", restaurant);
            request.setAttribute("detailedItems", detailedItems);

            request.getRequestDispatcher("orderDetails.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            response.sendRedirect("myOrders");
        }
    }
}
