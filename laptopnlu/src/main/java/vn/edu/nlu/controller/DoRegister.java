package vn.edu.nlu.controller;

import vn.edu.nlu.beans.User;
import vn.edu.nlu.entity.RegisterEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;

@WebServlet(name = "DoRegister", urlPatterns = "/DoRegister")
public class DoRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //todo doPost
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameLogin = request.getParameter("nameLogin");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("rePassword");
        String yourName = request.getParameter("yourName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String sex = request.getParameter("gender");
        String dateOfBirth = request.getParameter("dateOfBirth");
        StringTokenizer tokenizer = new StringTokenizer(dateOfBirth, "-");

        if (!RegisterEntity.isExist(nameLogin)) {
            User user = new User(nameLogin, password, address, yourName, phone,
                    email, sex, new Date(Integer.parseInt(tokenizer.nextToken()) - 1900,
                    Integer.parseInt(tokenizer.nextToken()) - 1, Integer.parseInt(tokenizer.nextToken())));

//            HttpSession session = request.getSession();
//            session.setAttribute("User", user);
            RegisterEntity.insertCustomer(user);
            response.sendRedirect("/ProjectGroup02/login.jsp");
        } else
            request.getRequestDispatcher("/ProjectGroup02/register.jsp").forward(request, response);


    }
}