package vn.edu.nlu.controller;

import vn.edu.nlu.beans.User;
import vn.edu.nlu.entity.RegisterEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DoRegisterForAdmin", urlPatterns = "/Admin-master/DoRegisterForAdmin")
public class DoRegisterForAdmin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //todo doPost
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameLogin = request.getParameter("nameLogin");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String chon = request.getParameter("chon");
        String avatar = request.getParameter("avatar");
        if(!RegisterEntity.isExist(nameLogin)){
            User u= new User( nameLogin,  password,  address,  phone,  email,  chon, "http://localhost:8080/ProjectGroup02/images/user/"+nameLogin+"/"+avatar);
            RegisterEntity.insertAdmin(u);
            response.sendRedirect("login.jsp");
        }
        else {
            request.getRequestDispatcher("Add_User.jsp").forward(request, response);
        }

    }
}
