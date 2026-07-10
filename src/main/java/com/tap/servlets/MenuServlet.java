package com.tap.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.tap.daoimp.Menudaoimp;
import com.tap.module.Menu;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int restaurantId =
                Integer.parseInt(request.getParameter("restaurantId"));

        Menudaoimp menuDao = new Menudaoimp();

        List<Menu> menuList =
                menuDao.getMenusByRestaurant(restaurantId);

        request.setAttribute("menuList", menuList);

        request.getRequestDispatcher("menu.jsp")
               .forward(request, response);
    }
}