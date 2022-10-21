package vn.edu.nlu.controllers;

import vn.edu.nlu.entity.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Evaluate", urlPatterns = "/evaluate")
public class Evaluate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //todo doPost
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("id");
    String user = request.getParameter("user");
    String email = request.getParameter("email");
    String starEva = request.getParameter("starEva");
    String eva = request.getParameter("eva");
    if (user ==""||email==""||starEva==""||eva==""){
        request.setAttribute("err","Vui lòng nhập đầy đủ thông tin cần đánh giá!");
    }else{
        ProductEntity.insertEvaluate(id,user, starEva, eva );
    }
        request.getRequestDispatcher("/detail?id="+id).forward(request, response);
    }
}
