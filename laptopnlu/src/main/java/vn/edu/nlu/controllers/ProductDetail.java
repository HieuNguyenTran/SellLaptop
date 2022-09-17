package vn.edu.nlu.controllers;

import vn.edu.nlu.beans.Product;
import vn.edu.nlu.entity.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "Detail", urlPatterns = "/detail")
public class ProductDetail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //todo doPost
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idpro = request.getParameter("id");
        //String user = request.getP

        Product pro = ProductEntity.getById(idpro);
        if (pro!=null)
        request.setAttribute("product", pro);
        else  request.setAttribute("product", "pro");
        request.getRequestDispatcher("product-detail.jsp").forward(request, response);
    }

}
