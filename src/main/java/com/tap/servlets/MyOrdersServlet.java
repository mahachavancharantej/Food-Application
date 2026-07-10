package com.tap.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.dao.Orderdao;
import com.tap.daoimp.Orderdaoimp;
import com.tap.module.Order;
import com.tap.module.User;

@WebServlet("/myOrders")
public class MyOrdersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("loggedUser");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Orderdao orderDao = new Orderdaoimp();

        List<Order> orders =
                orderDao.getOrdersByUser(user.getUserId());

        request.setAttribute("orders", orders);

        request.getRequestDispatcher("myOrder.jsp")
               .forward(request, response);
    
        
    }
}
