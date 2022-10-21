package vn.edu.nlu.controller;

import vn.edu.nlu.beans.User;
import vn.edu.nlu.model.Edit_InfomationMD;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "Edit_InformationUser", urlPatterns = "/Edit_InformationUser")
public class Edit_InformationUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String nameChange = request.getParameter("name");
        String phoneChange = request.getParameter("phone");
        String addressChange = request.getParameter("address");
        String dobChange = request.getParameter("dob");
        String emailChange = request.getParameter("email");
        String sexChange = request.getParameter("gioitinh");


        Date dob = new Edit_InfomationMD().date(dobChange);

        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("USER");

        String username = u.getUsername();

        User user = new User(nameChange, phoneChange, emailChange, addressChange, dob, sexChange);
        new Edit_InfomationMD().UpdateUser(user, username);

        u.setName(user.getName());
        u.setPhone(user.getPhone());
        u.setEmail(user.getEmail());
        u.setAddress(user.getAddress());
        u.setDob(user.getDob());
        u.setSex(user.getSex());

        response.sendRedirect("Success.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("USER");

        response.setContentType("text/html");
        ServletContext context = request.getServletContext();
        context.setAttribute("name", u.getName());
        context.setAttribute("phone", u.getPhone());
        context.setAttribute("email", u.getEmail());
        context.setAttribute("address", u.getAddress());
        context.setAttribute("dob", u.getDob()+"");
        context.setAttribute("sex", u.getSex());


        response.sendRedirect("Edit_information.jsp");
    }
}
