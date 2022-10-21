package vn.edu.nlu.controller;

import vn.edu.nlu.beans.User;
import vn.edu.nlu.model.FogetPassMD;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ForgetPass_Receive", urlPatterns = "/ForgetPass_Receive")
public class ForgetPass_Receive extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //todo doPost
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");
        FogetPassMD f = new FogetPassMD();

        if (f.checkKey(id)) {
            User u = f.getUserByKey(id);
            response.setContentType("text/html");
            ServletContext context = request.getServletContext();
            context.setAttribute("uname", u.getUsername());
            context.setAttribute("pass", u.getPassword());

            f.UpdateKey(u.getUsername(), null);
            response.sendRedirect("ChangeForgetPass.jsp");
        }
        else{
            request.setAttribute("error","URL đã hêt thời hạn cho phép vui lòng thực hiện lại !");
            request.getRequestDispatcher("forget-pass.jsp").forward(request,response);
        }

    }
}
