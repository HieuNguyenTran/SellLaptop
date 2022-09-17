package vn.edu.nlu.controllers;

import vn.edu.nlu.beans.Product;
import vn.edu.nlu.entity.ProductListEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

@WebServlet(name = "ProductList", urlPatterns = "/productList")
public class ProductList extends HttpServlet {
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

        String spageid = request.getParameter("page");
        String spageid1 = request.getParameter("page");
        int pageid = Integer.parseInt(spageid);
        int pageid1 = Integer.parseInt(spageid1);
        int total = 24;
        if (pageid == 1) {
        } else {
            pageid = pageid - 1;
            pageid = pageid * total + 1;
        }
        List<Product> list = ProductListEntity.getRecords();
        List<Product> listSend;
        int a = ProductListEntity.getCount();
        if(list!=null||!list.isEmpty()) {
            if (brand != null) {
                request.setAttribute("br", brand[0]);
            } else if (brand == null){
                request.setAttribute("br", "brand");
            }

            if (brand != null) {
                list.retainAll(ProductListEntity.getProductOnBrand(brand));

                a = list.size();
            }
            if (cpu != null) {
                list.retainAll(ProductListEntity.getProductOnCPU(cpu));
                a = list.size();

            }
            if (ram != null) {
                list.retainAll(ProductListEntity.getProductOnRAM(ram));

                a = list.size();
            }
            if (hardDisk != null) {
                list.retainAll(ProductListEntity.getProductOnHardDisk(hardDisk));

                a = list.size();
            }
            if (price != null) {
                StringTokenizer t = new StringTokenizer(price, "-");
                list.retainAll(ProductListEntity.getProductOnPrice(t.nextToken(), t.nextToken()));

                a = list.size();
            }
            if (monitor != null) {
                StringTokenizer t = new StringTokenizer(monitor, "-");
                list.retainAll(ProductListEntity.getProductOnMonitor(t.nextToken(), t.nextToken()));

                a = list.size();
            }
            if (sale != null) {
                boolean sa = Boolean.parseBoolean(sale);
                list.retainAll(ProductListEntity.getProductOnSale(sa));

                a = list.size();
            }
        }
        if (list.isEmpty()||list==null)
            listSend=null;
        else {if (sort!=null)
            listSend = ProductListEntity.pagination(ProductListEntity.sort(list,sort), pageid, total);
        else
            listSend = ProductListEntity.pagination(list, pageid, total);}
        request.setAttribute("listPro", listSend);
        request.setAttribute("pageCurrent", pageid1);
        request.setAttribute("total", a);
        request.setAttribute("path", path);

        request.getRequestDispatcher("product-listing.jsp").forward(request, response);

    }


}
