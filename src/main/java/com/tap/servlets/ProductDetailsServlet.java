package com.tap.servlets;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.tap.dao.Menudao;
import com.tap.dao.Productsizedao;
import com.tap.daoimp.Menudaoimp;
import com.tap.daoimp.Productsizedaoimp;
import com.tap.module.Menu;
import com.tap.module.Productsize;

@WebServlet("/productDetails")
public class ProductDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int productId =
                Integer.parseInt(request.getParameter("productId"));

        Menudao menuDao = new Menudaoimp();
        Productsizedao sizeDao = new Productsizedaoimp();

        Menu product = menuDao.getMenu(productId);

        List<Productsize> sizeList =
                sizeDao.getSizesByProduct(productId);

        request.setAttribute("product", product);
        request.setAttribute("sizes", sizeList);

        request.getRequestDispatcher("productDetails.jsp")
               .forward(request, response);

    }

}