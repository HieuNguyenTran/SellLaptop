package vn.edu.nlu.controller;

import vn.edu.nlu.beans.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ViewInfo", urlPatterns = "/ViewInfo")
public class ViewInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("USER");

        response.setContentType("text/html");
        ServletContext context = request.getServletContext();
        context.setAttribute("username", u.getUsername());
        context.setAttribute("password",u.getPassword());
        context.setAttribute("name", u.getName());
        context.setAttribute("phone", u.getPhone());
        context.setAttribute("email", u.getEmail());
        context.setAttribute("address", u.getAddress());
        context.setAttribute("dob", u.getDob()+"");
        context.setAttribute("sex", u.getSex());

        response.sendRedirect("ViewInfo.jsp");
    }
}
