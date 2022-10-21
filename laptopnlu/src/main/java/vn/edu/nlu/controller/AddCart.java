package vn.edu.nlu.controller;

import vn.edu.nlu.beans.Product;
import vn.edu.nlu.entity.ProductEntity;
import vn.edu.nlu.model.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AddCart", urlPatterns = "/AddCart")
public class AddCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        // TODO doPost
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      /*  HttpSession session = request.getSession();
        Cart c = Cart.getCart(session);
        if(c.getUname().equals("NULL")){
            response.sendRedirect("login.jsp");
            return;
        }

        String id = request.getParameter("id");
        int SL = Integer.parseInt(request.getParameter("SL"));
        Product p = ProductEntity.getById(id);
        if(p == null){ response.sendRedirect("index.jsp"); return;}
        //p.setQuantityInCart(SL);

        c.add(p);
        c.commit(session);
        response.sendRedirect("cart.jsp");

       */
    }
}