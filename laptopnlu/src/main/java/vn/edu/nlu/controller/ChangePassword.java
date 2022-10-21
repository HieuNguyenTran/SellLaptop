package vn.edu.nlu.controller;

import vn.edu.nlu.beans.User;
import vn.edu.nlu.model.Edit_InfomationMD;
import vn.edu.nlu.model.PasswordMD;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "ChangePassword", urlPatterns = "/ChangePassword")
public class ChangePassword extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("USER");

        String oldpass = request.getParameter("password");
        String newpassword = request.getParameter("newpassword");
        String renewpassword = request.getParameter("renewpassword");
        // kiem tra : new pass = config pass  , pass cu co bi nhap lai hay khong
        if (new PasswordMD().samePass(newpassword, renewpassword) && new PasswordMD().samePass(oldpass, u.getPassword())) {

            new PasswordMD().changePass(newpassword, u.getUsername());
            response.sendRedirect("Success.jsp");

        } else {

            request.setAttribute("error", "Mật khẩu nhập lại chưa khớp!");
            request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("USER");

        response.setContentType("text/html");
        ServletContext context = request.getServletContext();
        context.setAttribute("username", u.getUsername());
        context.setAttribute("oldpassword", u.getPassword());


        response.sendRedirect("ChangePassword.jsp");
    }
}
