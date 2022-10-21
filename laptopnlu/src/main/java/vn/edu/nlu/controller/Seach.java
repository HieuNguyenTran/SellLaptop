package vn.edu.nlu.controllers;

import vn.edu.nlu.beans.Product;
import vn.edu.nlu.entity.ProductEntity;
import vn.edu.nlu.entity.ProductListEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

@WebServlet(name = "Seach", urlPatterns = "/seach")
public class Seach extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //todo doPost
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "";
        path = request.getRequestURI();

        String[] brand = request.getParameterValues("brand");
        String[] cpu = request.getParameterValues("cpu");
        String[] ram = request.getParameterValues("ram");
        String[] hardDisk = request.getParameterValues("hardDisk");
        String price = request.getParameter("price");
        String monitor = request.getParameter("monitor");
        String sale = request.getParameter("sale");
        String sort = request.getParameter("sort");


        String search =request.getParameter("search");
        search=search.toLowerCase();
        String name;
        List<Product> values = new ProductListEntity().getRecords();
        List<Product>  list = new LinkedList<>();
        for (Product p:values ) {
            name = p.getName().toLowerCase();
            if (name.contains(search)){
                list.add(p);

            }
        }

        List<Product> listSend;

            if (brand != null) {
                list.retainAll(ProductListEntity.getProductOnBrand(brand));
            }
            if (cpu != null) {
                list.retainAll(ProductListEntity.getProductOnCPU(cpu));
            }
            if (ram != null) {
                list.retainAll(ProductListEntity.getProductOnRAM(ram));

            }
            if (hardDisk != null) {
                list.retainAll(ProductListEntity.getProductOnHardDisk(hardDisk));
            }
            if (price != null) {
                StringTokenizer t = new StringTokenizer(price, "-");
                list.retainAll(ProductListEntity.getProductOnPrice(t.nextToken(), t.nextToken()));
            }
            if (monitor != null) {
                StringTokenizer t = new StringTokenizer(monitor, "-");
                list.retainAll(ProductListEntity.getProductOnMonitor(t.nextToken(), t.nextToken()));

            }
            if (sale != null) {
                boolean sa = Boolean.parseBoolean(sale);
                list.retainAll(ProductListEntity.getProductOnSale(sa));

            }

        if (list.isEmpty()||list==null)
            listSend=null;
        else {
            if (sort != null)
                listSend = ProductListEntity.sort(list, sort);
            else
                listSend = list;
        }
        request.setAttribute("listPro", listSend);

        request.setAttribute("path", path);

        request.getRequestDispatcher("proListSearch.jsp").forward(request,response);
    }
}
