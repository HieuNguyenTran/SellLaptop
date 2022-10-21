<%@ page import="java.util.StringTokenizer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="vn.edu.nlu.entity.ProductListEntity" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 7]>
<html class="ie ie7"><![endif]-->
<!--[if IE 8]>
<html class="ie ie8"><![endif]-->
<!--[if IE 9]>
<html class="ie ie9"><![endif]-->
<html lang="en">

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="format-detection" content="telephone=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <link href="apple-touch-icon.png" rel="apple-touch-icon">

    <title>LaptopNLU - Product Listing</title>
    <!-- Fonts-->
    <link href="https://fonts.googleapis.com/css?family=Archivo+Narrow:300,400,700%7CMontserrat:300,400,500,600,700,800,900"
          rel="stylesheet">
    <link rel="stylesheet" href="plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="plugins/ps-icon/style.css">
    <!-- CSS Library-->
    <link rel="stylesheet" href="plugins/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="plugins/owl-carousel/assets/owl.carousel.css">
    <link rel="stylesheet" href="plugins/jquery-bar-rating/dist/themes/fontawesome-stars.css">
    <link rel="stylesheet" href="plugins/slick/slick/slick.css">
    <link rel="stylesheet" href="plugins/bootstrap-select/dist/css/bootstrap-select.min.css">
    <link rel="stylesheet" href="plugins/Magnific-Popup/dist/magnific-popup.css">
    <link rel="stylesheet" href="plugins/jquery-ui/jquery-ui.min.css">
    <link rel="stylesheet" href="plugins/revolution/css/settings.css">
    <link rel="stylesheet" href="plugins/revolution/css/layers.css">
    <link rel="stylesheet" href="plugins/revolution/css/navigation.css">
    <!-- Custom-->
    <link rel="stylesheet" href="css/style.css">
    <script src="https://code.jquery.com/jquery-latest.js"></script>
    <script>
        //Phân trang dạng: < ... 1  2  3 ... >
        // Nhấn ... để cập nhật 3 số trang đến 3 trang tiếp theo hay lùi 3 trang
        // Nhấn < lùi 1 trang
        // Nhấn > tiến 1 trang
        $(document).ready(function () {
            //Xử lí btn active cho btn của trang hiện tại
            <% int page1= (int) request.getAttribute("pageCurrent");%>
            var pageCurrent1 =<%=page1%>;

            <% int total1 = (int) request.getAttribute("total");
                int totalPage1 = (total1%24)==0? total1/24: (total1/24)+1;%>
            var quantityPage1 =<%=totalPage1%>;
            //Tìm 3 số trang cần hiển thị ra màn hình

            if ( quantityPage1==2 ){
                $('#loadpage').prop('disable',true);
                $('#unloadpage').prop('disable',true);
                $('#li3').hide();
                $('#next').prop('disable',true);;
            }
            if (quantityPage1==1 ){
                $('#loadpage').hide();
                //$('#unloadpage').hide();
                $('#li3').hide();
                $('#li2').hide();
                $('#next').hide();
            }
            if ( quantityPage1-pageCurrent1<3){
                var a1 = quantityPage1-2;
                var b1 = quantityPage1-1;
                var c1 = quantityPage1;
            }else  if ( pageCurrent1%3==0){
                var a1 = pageCurrent1-2;
                var b1 = pageCurrent1-1;
                var c1 = pageCurrent1;
            } else  if ( pageCurrent1%3==1){
                var a1 = pageCurrent1;
                var b1 = pageCurrent1+1;
                var c1 = pageCurrent1+2;
            }else  if ( pageCurrent1%3==2){
                var a1 = pageCurrent1-1;
                var b1 = pageCurrent1;
                var c1 = pageCurrent1+1;
            }
            $('#btn1').text(a1);
            $('#btn2').text(b1);
            $('#btn3').text(c1);

            if (a1 == pageCurrent1)
                $('#li1').addClass("active")


            if (b1 == pageCurrent1)
                $('#li2').addClass("active")


            if (c1 == pageCurrent1)
                $('#li3').addClass("active")
            <% String p =(String) request.getAttribute("path");
                             String q= ProductListEntity.getQuery(request.getQueryString());
                             if(q!="")q="&"+q;
                            %>

            $('#btn1').attr("href", "<%=p%>?page=" + a1+"<%=request.getQueryString()==null?"":q%>")

            $('#btn2').attr("href", "<%=p%>?page=" + b1+"<%=request.getQueryString()==null?"":q%>")

            $('#btn3').attr("href", "<%=p%>?page=" + c1 +"<%=request.getQueryString()==null?"":q%>")

//Kiểm tra số nút có vượt qua tổng trang ví dụ có 2 trang nhung có 3 nut.
            if ( quantityPage1==2 ){
                $('#loadpage').prop('disable',true);
                $('#unloadpage').prop('disable',true);
                $('#li1').hide();
                $('#next').prop('disable',true);
                $('#pre').prop('disable',true);
            }
            if (quantityPage1==1 ){
                $('#loadpage').prop('disable',true);
                $('#unloadpage').prop('disable',true);
                $('#li1').hide();
                $('#next').prop('disable',true);
                $('#pre').prop('disable',true);
                $('#li2').hide();
            }
            //kiểm tra hiển thị nut ... lúc đầu load trang

            if (a1 == 1&& quantityPage1>2) {//có 2 trang
                $('#loadpage').show();
                $('#unloadpage').hide();
            }

            if (c1 == quantityPage1&& quantityPage1>2) {
                $('#loadpage').hide();
                $('#unloadpage').show()
            }
            if (a1 == 1 && c1 == quantityPage1) {
                $('#loadpage').hide();
                $('#unloadpage').hide();
            }
            $('#loadpage').click(function () {

                var i1 = parseInt($('#btn1').text(), 10);
                var i2 = parseInt($('#btn2').text(), 10);
                var i3 = parseInt($('#btn3').text(), 10);

                var quantityPage =<%=totalPage1%>


                //Ví dụ đang là 28 29 30 và có 31 trang thì nhấn ... -> 29 30 31
                if (quantityPage - i3 == 2 || quantityPage - i3 == 1) {
                    $('#loadpage').show();
                    $('#unloadpage').show();
                    $('#btn1').text(quantityPage - 2);
                    $('#btn1').attr("href", "<%=p%>?page=" + (quantityPage - 2)+"<%=request.getQueryString()==null?"":q%>")
                    $('#btn2').text(quantityPage - 1);
                    $('#btn2').attr("href", "<%=p%>?page=" + (quantityPage - 1)+"<%=request.getQueryString()==null?"":q%>")
                    $('#btn3').text(quantityPage);
                    $('#btn3').attr("href", "<%=p%>?page=" + quantityPage +"<%=request.getQueryString()==null?"":q%>")
                } else {
                    $('#loadpage').show();
                    $('#unloadpage').show();
                    $('#btn1').text(i1 + 3);
                    $('#btn1').attr("href", "<%=p%>?page=" + (i1+3)+"<%=request.getQueryString()==null?"":q%>")
                    $('#btn2').text(i1 + 4);
                    $('#btn2').attr("href","<%=p%>?page=" + (i1+4)+"<%=request.getQueryString()==null?"":q%>")
                    $('#btn3').text(i1 + 5);
                    $('#btn3').attr("href", "<%=p%>?page=" + (i1+5)+"<%=request.getQueryString()==null?"":q%>")
                }
                //lấy giá trị của ô thứ 3 sau thay đỏi dể xét cps hieent thị 3 chấm hay ko
                var i1a = parseInt($('#btn1').text(), 10);
                var i2a = parseInt($('#btn2').text(), 10);
                var i3a = parseInt($('#btn3').text(), 10);
                if (i3a == quantityPage) {
                    $('#loadpage').hide();
                    $('#unloadpage').show();
                }

                //Xóa class active khi di chuyển

                if (i1a == pageCurrent1)
                    $('#li1').addClass("active")
                else
                    $('#li1').removeClass()

                if (i2a == pageCurrent1)
                    $('#li2').addClass("active")
                else
                    $('#li2').removeClass()

                if (i3a == pageCurrent1)
                    $('#li3').addClass("active")
                else
                    $('#li3').removeClass()
            });
            $('#unloadpage').click(function () {

                var ipage = $('#btn1').text();
                var i1 = parseInt(ipage, 10);
                if (i1 - 3 <= 0) {
                    $('#unloadpage').show();
                    $('#loadpage').show();
                    $('#btn1').text(1);
                    $('#btn1').attr("href", "<%=p%>?page=1<%=request.getQueryString()==null?"":q%>")
                    $('#btn2').text(2);
                    $('#btn2').attr("href", "<%=p%>?page=2<%=request.getQueryString()==null?"":q%>")
                    $('#btn3').text(3);
                    $('#btn3').attr("href", "<%=p%>?page=3<%=request.getQueryString()==null?"":q%>")
                } else {
                    $('#unloadpage').show();
                    $('#loadpage').show();
                    $('#btn1').text(i1 - 3);
                    $('#btn1').attr("href", "<%=p%>?page=" + (i1 - 3) +"<%=request.getQueryString()==null?"":q%>")
                    $('#btn2').text(i1 - 2);
                    $('#btn2').attr("href", "<%=p%>?page=" + (i1 - 2) +"<%=request.getQueryString()==null?"":q%>")
                    $('#btn3').text(i1 - 1);
                    $('#btn3').attr("href", "<%=p%>?page=" + (i1 - 1) +"<%=request.getQueryString()==null?"":q%>")
                }

                var i1b = parseInt($('#btn1').text(), 10);
                if (i1b == 1) {
                    $('#unloadpage').hide();
                    $('#loadpage').show();
                }

                var i2a = parseInt($('#btn2').text(), 10);
                var i3a = parseInt($('#btn3').text(), 10);


                //CHọn nut active

                if (i1b == pageCurrent1)
                    $('#li1').addClass("active")
                else
                    $('#li1').removeClass()
                if (i2a == pageCurrent1)
                    $('#li2').addClass("active")
                else
                    $('#li2').removeClass()

                if (i3a == pageCurrent1)
                    $('#li3').addClass("active")
                else
                    $('#li3').removeClass()
            });




        });
    </script>
    <!--HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries-->
    <!--WARNING: Respond.js doesn't work if you view the page via file://-->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script><![endif]-->
</head>
<!--[if IE 7]>
<body class="ie7 lt-ie8 lt-ie9 lt-ie10"><![endif]-->
<!--[if IE 8]>
<body class="ie8 lt-ie9 lt-ie10"><![endif]-->
<!--[if IE 9]>
<body class="ie9 lt-ie10"><![endif]-->

<body class="ps-loading">
<div class="header--sidebar"></div>
<jsp:include page="header.jsp"></jsp:include>
<div class="header-services">
    <div class="ps-services owl-slider" data-owl-auto="true" data-owl-loop="true" data-owl-speed="7000" data-owl-gap="0"
         data-owl-nav="true" data-owl-dots="false" data-owl-item="1" data-owl-item-xs="1" data-owl-item-sm="1"
         data-owl-item-md="1" data-owl-item-lg="1" data-owl-duration="1000" data-owl-mousedrag="on">
        <p class="ps-service"><i class="ps-icon-delivery"></i><strong>Giao hàng miễn phí</strong>: Nhận giao hàng
            miễn phí với mọi đơn hàng tại cửa hàng Laptop NLU</p>
        <p class="ps-service"><i class="ps-icon-delivery"></i><strong>Giao hàng miễn phí</strong>: Nhận giao hàng
            miễn phí với mọi đơn hàng tại cửa hàng Laptop NLU</p>
        <p class="ps-service"><i class="ps-icon-delivery"></i><strong>Giao hàng miễn phí</strong>: Nhận giao hàng
            miễn phí với mọi đơn hàng tại cửa hàng Laptop NLU</p>
    </div>
</div>
<main class="ps-main">
    <% String path, pathRe = "";
        if (request.getQueryString() != null) {
            path = request.getAttribute("path") + "?" + request.getQueryString() + "&";
            pathRe = request.getAttribute("path") + "?" + request.getQueryString();
        } else path = request.getAttribute("path") + "?";%>
    <%
        String query = request.getQueryString();
        StringTokenizer t = new StringTokenizer(query, "&");
        int count = t.countTokens();
        ArrayList<String> para = new ArrayList<>();
        for (int j = 0; j < count; j++) {
            para.add(t.nextToken());
        }
    %>

    <div class="ps-products-wrap pt-80 pb-80">
        <div class="ps-products" data-mh="product-listing">
            <div class="ps-product-action">
                <div class="ps-product__filter">
                    <%
                        String pathSo = "";
                        String pathSort = (String) request.getAttribute("path");
                        ArrayList<String> liS = (ArrayList<String>) para.clone();
                        if (path.contains("sort=2"))
                            liS.remove("sort=2");
                        if (path.contains("sort=3"))
                            liS.remove("sort=3");

                        for (int j = 0; j < liS.size(); j++) {
                            if (j == liS.size() - 1) pathSo += liS.get(j);
                            else pathSo += liS.get(j) + "&";
                        }
                        if (pathSo!="")
                            pathSort += "?" + pathSo + "&";
                    %>
                    <select  class="ps-select selectpicker "  onchange="location = this.value;">
                        <option  >Sắp xếp</option>


                        <option value="<%=pathSort%>sort=2">Giá cao đến thấp</option>
                        <option value="<%=pathSort%>sort=3">Giá thấp đến cao</option>
                    </select>
                </div>
                <div class="ps-pagination">
                    <ul class="pagination">
                        <%
                            int pages = page1;//Button Previous
                            int back = 0;
                            int i = 0;//de load 3 so trang hien tai
                            if (pages == 0 || pages == 1) {
                                back = 1;//Luon la page 1
                            } else {
                                back = pages - 1;//Neu pages tu 2 tro len thi back tru 1
                            }
                            if (pages % 3 == 0 || (pages == totalPage1&&pages<totalPage1)) {//khi page =1-->-4 lỗi
                                i = pages - 2;
                            } else if (pages % 3 == 2) {
                                i = pages - 1;
                            } else if (pages % 3 == 1) {
                                i = pages;
                            }
                        %>
                        <li><a id="pre" href="productList?page=<%=back%>"><i class="fa fa-angle-left"></i></a></li>
                        <li id="unloadpage"><a>...</a></li>
                        <li id="li1"><a id="btn1" href="<%=p%>?page=<%=i%><%=request.getQueryString()==null?"":q%>"><%=i%>
                        </a></li>
                        <li id="li2"><a id="btn2" href="<%=p%>?page=<%=i+1%><%=request.getQueryString()==null?"":q%>"><%=i + 1%>
                        </a></li>
                        <li id="li3"><a id="btn3" href="<%=p%>?page=<%=i+2%><%=request.getQueryString()==null?"":q%>"><%=i + 2%>
                        </a></li>
                        <li id="loadpage"><a>...</a></li>
                        <%
                            //Button Next
                            int total = total1;
                            int next = 0;
                            int totalPage = (total % 3) == 0 ? total / 3 : (total / 3) + 1;
                            if (pages < totalPage) {
                                next = pages + 1;//Khong next
                            } else {
                                next = pages;//Co next
                            }
                        %>
                        <li><a id="next" href="productList?page=<%=next%>"><i class="fa fa-angle-right"></i></a></li>
                    </ul>
                </div>
            </div>
            <!-- Grid sản phẩm -->
            <div style="overflow: auto; margin-bottom: 30px">
                <%
                    for (String pa : para) {
                        if (!pa.contains("page")) {
                %>
                <div style="float: left;overflow: auto">
                    <p style="float: left"><%=pa%>
                    </p>
                    <a style="float: left;margin-right: 15px" href="<%=ProductListEntity.removeSubString(pathRe,"&"+pa)%>"><i class="fas fa-times"></i></a>

                </div>
                <%
                        }
                    }
                %>
            </div>


            <c:if test="${listPro == null}"><h4>Không tìm thấy sản phẩm!</h4></c:if>

            <c class="ps-product__columns">
                <c:if test="${listPro != null}">
                <c:forEach items="${listPro}" var="p">
                <div class="ps-product__column">
                    <div class="ps-shoe mb-30">
                        <div class="ps-shoe__thumbnail">
                            <!-- <div class="ps-badge"><span></span></div> -->

                            <c:if test="${p.priceSale!=0.0}">
                                <div class="ps-badge ps-badge--sale"><span>-${p.phanTramKM*100}%</span></div>
                            </c:if>
                            <img src="${p.img}" alt=""><a class="ps-shoe__overlay"
                                                          href="detail?id=${p.id}"></a>
                        </div>
                        <br>
                        <br>
                        <div class="ps-shoe__content">
                            <div class="ps-shoe__variants">
                                <div class="ps-shoe__variant normal"><img src="${p.img}"
                                                                          alt=""><img
                                        src="${p.img}" alt=""><img
                                        src="${p.img}" alt=""><img
                                        src="${p.img}" alt=""><img
                                        src="${p.img}" alt=""></div>

                                <c:if test="${p.star==4}">
                                    <select class="ps-rating">
                                        <c:if test="${p.star==1}"><option value="1" selected>1</option></c:if>
                                        <c:if test="${p.star!=1}"><option value="1">1</option></c:if>
                                        <c:if test="${p.star==2}"><option value="2" selected>2</option></c:if>
                                        <c:if test="${p.star!=2}"><option value="2">2</option></c:if>
                                        <c:if test="${p.star==3}"><option value="3" selected>3</option></c:if>
                                        <c:if test="${p.star!=3}"><option value="3">3</option></c:if>
                                        <c:if test="${p.star==4}"><option value="4" selected>4</option></c:if>
                                        <c:if test="${p.star!=4}"><option value="4">4</option></c:if>
                                        <c:if test="${p.star==5}"><option value="5" selected>5</option></c:if>
                                        <c:if test="${p.star!=5}"><option value="5">5</option></c:if>

                                    </select>
                                </c:if>

                            </div>
                            <div class="ps-shoe__detail"><a class="ps-shoe__name" href="detail?id=${p.id}">${p.name}</a>
                                <p>RAM: ${p.ram}GB - ${p.oCung}<br/>
                                    <c:if test="${p.priceSale!=0}">
                                    <del>${p.priceToString(p.price)}đ</del>
                                    <strong class="price">${p.priceToString(p.priceSale)}đ</strong></p>
                                </c:if>
                                <c:if test="${p.priceSale==0}">
                                    <strong class="price">${p.priceToString(p.price)}đ</strong></p>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
                </c:forEach>
                </c:if>
        </div>

        <div class="ps-sidebar" data-mh="product-listing">
            <aside class="ps-widget--sidebar ps-widget--category">
                <div class="ps-widget__header">
                    <h3>Hãng</h3>
                </div>
                <div class="ps-widget__content">
                    <ul class="ps-list--checked">
                        <li><a href="<%=path%>brand=Apple">Apple (Macbook)</a></li>
                        <li><a href="<%=path%>brand=Acer">Acer</a></li>
                        <li><a href="<%=path%>brand=Asus">Asus</a></li>
                        <li><a href="<%=path%>brand=Dell">Dell</a></li>
                        <li><a href="<%=path%>brand=Lenovo">Lenovo</a></li>
                        <li><a href="<%=path%>brand=HP">HP</a></li>
                    </ul>

                </div>
            </aside>
            <aside class="ps-widget--sidebar ps-widget--category">
                <div class="ps-widget__header">
                    <h3>Mức giá</h3>
                </div>
                <div class="ps-widget__content">
                    <%
                        String path1 = "";
                        String pathPrice = (String) request.getAttribute("path");
                        ArrayList<String> li = (ArrayList<String>) para.clone();
                        if (path.contains("price=10-15"))
                            li.remove("price=10-15");
                        if (path.contains("price=15-20"))
                            li.remove("price=15-20");
                        if (path.contains("price=20-25"))
                            li.remove("price=20-25");
                        if (path.contains("price=25-100"))
                            li.remove("price=25-100");
                        for (int j = 0; j < li.size(); j++) {
                            if (j == li.size() - 1) path1 += li.get(j);
                            else path1 += li.get(j) + "&";
                        }
                        if (path1!="")
                            pathPrice += "?" + path1 + "&";
                    %>
                    <ul class="ps-list--checked">
                        <li><a href="<%=pathPrice%>price=10-15">10 - 15 triệu</a></li>
                        <li><a href="<%=pathPrice%>price=15-20">15 - 20 triệu</a></li>
                        <li><a href="<%=pathPrice%>price=20-25">20 - 25 triệu</a></li>
                        <li><a href="<%=pathPrice%>price=25-100">Trên 25 triệu</a></li>
                    </ul>

                </div>
            </aside>
            <aside class="ps-widget--sidebar ps-widget--category">
                <div class="ps-widget__header">
                    <h3>Màn hình</h3>
                </div>
                <div class="ps-widget__content">
                    <%
                        String path2 = "";
                        String pathMoni = (String) request.getAttribute("path");
                        ArrayList<String> liM = (ArrayList<String>) para.clone();
                        if (path.contains("monitor=15-20"))
                            liM.remove("monitor=15-20");
                        if (path.contains("monitor=14-15"))
                            liM.remove("monitor=14-15");
                        if (path.contains("monitor=13-14"))
                            liM.remove("monitor=13-14");

                        for (int j = 0; j < liM.size(); j++) {
                            if (j == liM.size() - 1) path2 += liM.get(j);
                            else path2 += liM.get(j) + "&";
                        }
                        if (!path2.equals(""))
                            pathMoni += "?" + path2 + "&";
                        else
                            pathMoni += "?";
                    %>
                    <ul class="ps-list--checked">
                        <li><a href="<%=pathMoni%>monitor=15-20">Trên 15 inch</a></li>
                        <li><a href="<%=pathMoni%>monitor=14-15">Khoảng 14 inch</a></li>
                        <li><a href="<%=pathMoni%>monitor=13-14">Khoảng 13 inch</a></li>
                        <li><a href="<%=pathMoni%>monitor=15-20">Cảm ứng</a></li>
                    </ul>

                </div>
            </aside>
            <aside class="ps-widget--sidebar ps-widget--category">
                <div class="ps-widget__header">
                    <h3>CPU</h3>
                </div>
                <div class="ps-widget__content">
                    <ul class="ps-list--checked">
                        <li><a href="<%=path%>cpu=i7">Intel Core i7</a></li>
                        <li><a href="<%=path%>cpu=i5">Intel Core i5</a></li>
                        <li><a href="<%=path%>cpu=i3">Intel Core i3</a></li>
                        <li><a href="<%=path%>cpu=Pentium">Intel Celeron/ Pentium</a></li>
                        <li><a href="<%=path%>cpu=AMD">AMD</a></li>
                    </ul>

                </div>
            </aside>
            <aside class="ps-widget--sidebar ps-widget--category">
                <div class="ps-widget__header">
                    <h3>RAM</h3>
                </div>
                <div class="ps-widget__content">
                    <ul class="ps-list--checked">
                        <li><a href="<%=path%>ram=16">16 GB</a></li>
                        <li><a href="<%=path%>ram=8">8 GB</a></li>
                        <li><a href="<%=path%>ram=4">4 GB</a></li>
                    </ul>

                </div>
            </aside>


            <aside class="ps-widget--sidebar ps-widget--category">
                <div class="ps-widget__header">
                    <h3>Ổ cứng</h3>
                </div>
                <div class="ps-widget__content">
                    <ul class="ps-list--checked">
                        <li><a href="<%=path%>hardDisk=SSD-1-TB">SSD: 1 TB</a></li>
                        <li><a href="<%=path%>hardDisk=SSD-512-GB">SSD: 512 GB</a></li>
                        <li><a href="<%=path%>hardDisk=SSD-256-GB">SSD: 256 GB</a></li>
                        <li><a href="<%=path%>hardDisk=SSD-128-GB">SSD: 128 GB</a></li>
                        <li><a href="<%=path%>hardDisk=HDD-1-TB">HDD: 1 TB</a></li>
                        <li><a href="<%=path%>hardDisk=HDD-1-TB">HDD dưới 1 TB</a></li>
                    </ul>

                </div>
            </aside>
            <aside class="ps-widget--sidebar ps-widget--category">
                <div class="ps-widget__header">
                    <h3>Khuyến mãi</h3>
                </div>
                <div class="ps-widget__content">
                    <ul class="ps-list--checked">
                        <li><a href="<%=path%>sale=true">Đang giảm giá</a></li>
                    </ul>

                </div>
            </aside>
        </div>
    </div>
    <!-- Footer -->
    <jsp:include page="footer.jsp"></jsp:include>
</main>
<!-- JS Library-->
<script type="text/javascript" src="plugins/jquery/dist/jquery.min.js"></script>
<script type="text/javascript" src="plugins/bootstrap/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="plugins/jquery-bar-rating/dist/jquery.barrating.min.js"></script>
<script type="text/javascript" src="plugins/owl-carousel/owl.carousel.min.js"></script>
<script type="text/javascript" src="plugins/gmap3.min.js"></script>
<script type="text/javascript" src="plugins/imagesloaded.pkgd.js"></script>
<script type="text/javascript" src="plugins/isotope.pkgd.min.js"></script>
<script type="text/javascript" src="plugins/bootstrap-select/dist/js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="plugins/jquery.matchHeight-min.js"></script>
<script type="text/javascript" src="plugins/slick/slick/slick.min.js"></script>
<script type="text/javascript" src="plugins/elevatezoom/jquery.elevatezoom.js"></script>
<script type="text/javascript" src="plugins/Magnific-Popup/dist/jquery.magnific-popup.min.js"></script>
<script type="text/javascript" src="plugins/jquery-ui/jquery-ui.min.js"></script>
<script type="text/javascript"
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAx39JFH5nhxze1ZydH-Kl8xXM3OK4fvcg&amp;region=GB"></script>
<script type="text/javascript" src="plugins/revolution/js/jquery.themepunch.tools.min.js"></script>
<script type="text/javascript" src="plugins/revolution/js/jquery.themepunch.revolution.min.js"></script>
<script type="text/javascript" src="plugins/revolution/js/extensions/revolution.extension.video.min.js"></script>
<script type="text/javascript" src="plugins/revolution/js/extensions/revolution.extension.slideanims.min.js"></script>
<script type="text/javascript"
        src="plugins/revolution/js/extensions/revolution.extension.layeranimation.min.js"></script>
<script type="text/javascript" src="plugins/revolution/js/extensions/revolution.extension.navigation.min.js"></script>
<script type="text/javascript" src="plugins/revolution/js/extensions/revolution.extension.parallax.min.js"></script>
<script type="text/javascript" src="plugins/revolution/js/extensions/revolution.extension.actions.min.js"></script>
<!-- Custom scripts-->
<script type="text/javascript" src="js/main.js"></script>
</body>

</html>
