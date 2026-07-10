package com.tap.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.tap.dao.*;
import com.tap.daoimp.*;
import com.tap.module.*;

@WebServlet("/orderDetails")
public class OrderDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int orderId = Integer.parseInt(request.getParameter("orderId"));

        // Fetch Order
        Orderdao orderDao = new Orderdaoimp();
        Order order = orderDao.getOrder(orderId);

        if (order == null) {
            response.sendRedirect("myOrders");
            return;
        }

        // Fetch Restaurant
        Restaurantdao restaurantDao = new Restaurantdaoimp();
        Restaurant restaurant =
                restaurantDao.getRestaurant(order.getRestaurantId());

        // Fetch Order Items
        Orderitemdao orderItemDao = new Orderitemdaoimp();
        List<Orderitem> orderItems =
                orderItemDao.getOrderItemsByOrder(orderId);

        Menudao menuDao = new Menudaoimp();
        Productsizedao sizeDao = new Productsizedaoimp();

        List<Map<String, Object>> detailedItems = new ArrayList<>();

        for (Orderitem item : orderItems) {

            Menu menu = menuDao.getMenu(item.getProductId());

            Productsize size =
                    sizeDao.getProductSize(item.getSizeId());

            Map<String, Object> map = new HashMap<>();

            map.put("productName",
                    menu != null ? menu.getProductName() : "Unknown Product");

            map.put("sizeName",
                    size != null ? size.getSizeName() : "-");

            map.put("quantity", item.getQuantity());

            map.put("unitPrice", item.getPrice());

            map.put("totalPrice",
                    item.getPrice() * item.getQuantity());

            detailedItems.add(map);
        }

        request.setAttribute("order", order);
        request.setAttribute("restaurant", restaurant);
        request.setAttribute("detailedItems", detailedItems);

        request.getRequestDispatcher("orderDetails.jsp")
               .forward(request, response);
    }
}