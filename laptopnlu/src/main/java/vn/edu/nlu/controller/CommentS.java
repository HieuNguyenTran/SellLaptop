package vn.edu.nlu.controllers;

import vn.edu.nlu.entity.ProductEntity;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CommentS", urlPatterns = "/comment")
public class CommentS extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //todo doPost
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        //User user = (User)request.getSession().getAttribute("USER");
        String username = "Ti";//user.name;
        String content = request.getParameter("content");
        if (username ==""||content==""){
            request.setAttribute("err","Vui lòng nhập đầy đủ thông tin cần đánh giá!");
        }else{
            ProductEntity.insertComment(id,username, content );
        }
        request.getRequestDispatcher("/detail?id="+id).forward(request, response);

    }
}
