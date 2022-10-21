package vn.edu.nlu.controller;

import vn.edu.nlu.model.FogetPassMD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ForgetPass_Change", urlPatterns = "/ForgetPass_Change")
public class ForgetPass_Change extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String uname = request.getParameter("uname");
        String newpass = request.getParameter("newpass");
        String repass = request.getParameter("renewpass");

        FogetPassMD f = new FogetPassMD();
        if (f.samePass(newpass, repass)) {
            f.changePass(newpass, uname);
            response.sendRedirect("Success.jsp");
        } else {
            request.setAttribute("error", "Pass thay đổi và pass nhập lại chưa khớp!");
            request.getRequestDispatcher("ChangeForgetPass.jsp").forward(request, response);
        }
    }
}
