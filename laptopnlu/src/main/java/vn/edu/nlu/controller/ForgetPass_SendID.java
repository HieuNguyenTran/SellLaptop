package vn.edu.nlu.controller;


import vn.edu.nlu.beans.User;
import vn.edu.nlu.mail.Mail;
import vn.edu.nlu.model.FogetPassMD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet(name = "ForgetPass_SendID", urlPatterns = "/ForgetPass_SendID")
public class ForgetPass_SendID extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //todo doPost
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String email= request.getParameter("email");
        FogetPassMD model= new FogetPassMD();

        if(model.checkEmail(email)){
            User u= model.getUser(email);
            String username= u.getUsername();
            String pass= u.getPassword();
            String id="";
            try {
                 id= model.encrypt(username+pass);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

            model.insertMd5(id,email);
            Mail.sendMail(email,id);
            model.insertKeyTime(email);
            response.sendRedirect("Success.jsp");
        }
        else {
            request.setAttribute("error", "Mail chưa được đăng ký!");
            request.getRequestDispatcher("forget-pass.jsp").forward(request,response);

        }



    }
}
