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

                            <c:if test="${p.priceSale!=0}">
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
                            <div class="ps-shoe__detail"><a class="ps-shoe__name" href="#">${p.name}</a>
                                <p>RAM: ${p.ram}GB - ${p.oCung}<br/>
                                    <c:if test="${p.priceSale!=0}">
                                        <del>${p.priceToString(p.priceSale)}đ</del>
                                    </c:if>

                                    <strong class="price">${p.priceToString(p.price)}đ</strong></p>
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
