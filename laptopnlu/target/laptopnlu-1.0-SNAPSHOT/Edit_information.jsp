<%@ page import="vn.edu.nlu.beans.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<!--[if IE 7]><html class="ie ie7"><![endif]-->
<!--[if IE 8]><html class="ie ie8"><![endif]-->
<!--[if IE 9]><html class="ie ie9"><![endif]-->
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="format-detection" content="telephone=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <link href="apple-touch-icon.png" rel="apple-touch-icon">

    <title>LaptopNLU-EditInformation</title>
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
    <!--HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries-->
    <!--WARNING: Respond.js doesn't work if you view the page via file://-->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script><![endif]-->
    <!-- Fontfaces CSS-->
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <!-- Vendor CSS-->
    <link href="vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">
    <!-- Main CSS-->
    <link href="login/main.css" rel="stylesheet" media="all">
    <style>
        .page-wrapper {
            background-position: center center;
            background-size: cover;
            background-color: gray;
        }

        .edit-info-conten {
            border: 2px solid gray;
        }

        .page-content--bge5 {

        }


    </style>
</head>
<!--[if IE 7]>
<body class="ie7 lt-ie8 lt-ie9 lt-ie10"><![endif]-->
<!--[if IE 8]>
<body class="ie8 lt-ie9 lt-ie10"><![endif]-->
<!--[if IE 9]>
<body class="ie9 lt-ie10"><![endif]-->
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="page-wrapper" style="height: 900px !important">
    <div class="page-content--bge5">
        <div class="container">
            <div class="login-wrap edit-info-wap ">
                <div class="login-content edit-info-conten">
                    <div class="login-logo title-edit-info">
                        <h2>Thay đổi thông tin</h2>
                    </div>
                    <div class="login-form title-edit-info">
                        <form action="Edit_InformationUser" method="post">
                            <div class="form-group">
                                <label>Tên người dùng:</label>
                                <%ServletContext context1 = request.getServletContext();%>
                                <input name="name" value="<%=context1.getAttribute("name")%>"
                                       class="au-input au-input--full" type="name" placeholder="Nhập tên thay đổi mới">
                            </div>
                            <div class="form-group">
                                <label>Số điện thoại:</label>
                                <%ServletContext context2 = request.getServletContext();%>
                                <input name="phone" value="<%=context2.getAttribute("phone")%>"
                                       class="au-input au-input--full" type="phone"
                                       placeholder="Nhập số điện thoại mới">
                            </div>
                            <div class="form-group">
                                <label>Email:</label>
                                <%ServletContext context3 = request.getServletContext();%>
                                <input name="email" value="<%=context3.getAttribute("email")%>"
                                       class="au-input au-input--full" type="email" placeholder="Nhập Email mới">
                            </div>
                            <div class="form-group">
                                <label>Địa chỉ:</label>
                                <%ServletContext context4 = request.getServletContext();%>
                                <input name="address" value="<%=context4.getAttribute("address")%>"
                                       class="au-input au-input--full" type="address" placeholder="Nhập địa chỉ mới">
                            </div>
                            <div class="input">
                                <label style="float: left; padding-right: 10px">Ngày sinh:</label>
                                <%ServletContext context5 = request.getServletContext();%>
                                <input name="dob" value="<%=context5.getAttribute("dob")%>" type="date"
                                       class="au-input au-input--full" type="date" id="datepicker">
                            </div>
                            <div class="form-group" style="padding-top: 15px;">
                                <label style="float: left; padding-right: 10px; ">Giới tính:</label>
                                <%
                                    ServletContext context8 = request.getServletContext();
                                    String sex = (String) context8.getAttribute("sex");
                                %>
                                <input name="gioitinh" checked="<%=sex.equalsIgnoreCase("nam")?"checked":""%>"
                                       type="radio" value="Nam"/> Nam
                                <input name="gioitinh" checked="<%=sex.equalsIgnoreCase("nữ")?"checked":""%>"
                                       type="radio" value="Nữ"/> Nữ
                            </div>

                            <input type="submit" class="au-btn au-btn--block au-btn--green m-b-20"  style="font-weight: bold;" value="Lưu thay đổi">


                            <input type="reset" class="au-btn au-btn--block  m-b-20 btn-danger" style="font-weight: bold;" value="Hoàn tác">


                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>


<div class="ps-footer bg--cover">
    <div class="ps-footer__content">
        <div class="ps-container">
            <div class="row" style="margin: auto">
                <aside class="col-lg-12 ">
                    <img src="images/logolap1.png" alt="" style="width: 1800px;height: 80px">
                </aside>
                <div class="col-lg-2 ">
                </div>

                <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12 ">

                    <aside class="ps-widget--footer ps-widget--info">
                        <header>
                            <h3 class="ps-widget__title">Địa chỉ:</h3>
                        </header>
                        <footer>
                            <p><strong>Số 996 QL1A, Khu Phố 1, Dĩ An, Bình Dương</strong></p>
                            <p>Email: <a href='mailto:support@store.com'>laptopnlu@gmail.com</a></p>
                            <p>Phone: 09999999999</p>
                            <p>Fax: 123456789</p>
                        </footer>
                    </aside>
                </div>

                <div class="col-lg-3 col-md-2 col-sm-4 col-xs-12 ">
                    <aside class="ps-widget--footer ps-widget--link">
                        <header>
                            <h3 class="ps-widget__title">LIÊN KẾT</h3>
                        </header>
                        <footer>
                            <ul class="ps-list--link">
                                <li><a href="#">TRANG CHỦ</a></li>
                                <li><a href="#">GIỚI THIỆU</a></li>
                                <li><a href="#">SẢN PHẨM</a></li>
                                <li><a href="#">LIÊN HỆ</a></li>
                            </ul>
                        </footer>
                    </aside>
                </div>
                <div class="col-lg-3 col-md-2 col-sm-4 col-xs-12 ">
                    <aside class="ps-widget--footer ps-widget--link">
                        <header>
                            <h3 class="ps-widget__title">KẾT NỐI VỚI CHÚNG TÔI</h3>
                        </header>
                        <footer>
                            <ul class="ps-list--line">
                                <li><a href="#"><i class="fa fa-facebook"></i> Kết nối Facebook</a></li>
                                <li><a href="#"><i class="fa fa-google-plus"></i> Kết nối G+</a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i> Trao đổi Twitter</a></li>
                                <li><a href="#"><i class="fa fa-instagram"></i> Kết nối Instagram</a></li>
                            </ul>
                        </footer>
                    </aside>
                </div>
                <aside class="col-lg-12 row thanhtoan">

                    <p class="col-lg-3">Các hình thức thanh toán hỗ trợ:</p>
                    <img class="col-lg-9" src="images/thanhtoan2.png" alt="" style="width: 1000px;height: 50px">
                </aside>
            </div>
        </div>
    </div>
    <div class="ps-footer__copyright">
        <div class="ps-container">
            <div class="row">
                <div class="col-lg-12 col-md-6 col-sm-6 col-xs-12 ">
                    <p style="text-align: center">&copy; <a href="#">LAPTOPNLU</a>. Design by <a href="#"> Group
                        02-LTWEB</a></p>
                </div>

            </div>
        </div>
    </div>
</div>
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
<script type="text/javascript" src="plugins/revolution/js/extensions/revolution.extension.kenburn.min.js"></script>
<script type="text/javascript" src="plugins/revolution/js/extensions/revolution.extension.migration.min.js"></script>
<script type="text/javascript" src="./register/register.js"></script>
</body>
</html>
