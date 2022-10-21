package vn.edu.nlu.controller;

import vn.edu.nlu.beans.User;
import vn.edu.nlu.entity.LoginEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DoLogin", urlPatterns = "/DoLogin")
public class DoLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //todo doPost
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = LoginEntity.getInformationOfUser(username);
        if (LoginEntity.checkLogin(username, password) && user.getState().equalsIgnoreCase("active")) {

            if (user.getType().equalsIgnoreCase("Customer")) {
                HttpSession session = request.getSession();
                session.setAttribute("USER", user);
                response.sendRedirect("index.jsp");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("USER", user);

                response.sendRedirect("Admin/index.jsp");
            }

        } else {
            request.setAttribute("loi","Sai thông tin vui lòng nhập lại!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}
