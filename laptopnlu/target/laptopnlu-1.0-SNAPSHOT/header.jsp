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

    <style>
        .page-wrapper {
            background:  url('a/tc.png') ;
            background-position: center center;
            background-size: cover;

        }
        #eye{
            position: relative;
            transform: translate(450px,-32px);
        }

        #mylocation .proImg{
            width: 50px;
            height: 50px;padding-left: 20px;
        }
        .header__top .navigation .navigation__column.left{
            width: 300px;
        }
        .header__top .navigation .navigation__column.center{
            width: 600px;
        }
        .header__top .navigation .navigation__column.left{
            width: 450px;
        }
    </style>
    <script>
        var request=new XMLHttpRequest();
        function searchInfo(){
            var name=document.searchProduct.search.value;
            var url="searchaa.jsp?val="+name;

            try{
                request.onreadystatechange=function(){
                    if(request.readyState==4){
                        var val=request.responseText;
                        document.getElementById('mylocation').innerHTML=val;
                    }
                }//end of function
                request.open("GET",url,true);
                request.send();
            }catch(e){alert("Unable to connect to server");}
        }
    </script>

    <script>
        $(function() {
            $('#search').blur(function () {
                $('#mylocation').delay(500).fadeOut('fast');

            });
            $('#search').focus(function () {
                $('#mylocation').show();
            });
        });
    </script>
</head>
<!--[if IE 7]><body class="ie7 lt-ie8 lt-ie9 lt-ie10"><![endif]-->
<!--[if IE 8]><body class="ie8 lt-ie9 lt-ie10"><![endif]-->
<!--[if IE 9]><body class="ie9 lt-ie10"><![endif]-->

<body class="ps-loading animsition">
<header class="header">
    <div class="header__top">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-6 col-md-8 col-sm-6 col-xs-12 ">
                    <p>6 QL1A, Khu phố 1, Dĩ An, Bình Dương-  Hotline: 0385190234 </p>
                </div>
                <div class="col-lg-6 col-md-4 col-sm-6 col-xs-12 ">
                    <div class="header__actions"><a href="register.jsp">Đăng ký</a>
                        <div class="header__actions"><a href="login.jsp">Đăng nhập</a>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <nav class="navigation">
            <div class="container-fluid">
                <div class="navigation__column left">
                    <div class="header__logo"><a class="ps-logo" href="index.jsp"><img src="images/logo1.png" alt=""></a></div>
                </div>
                <div class="navigation__column center">
                    <ul class="main-menu menu">
                        <li class="menu-item">
                            <i class="fas fa-home"></i>
                            <a href="index.jsp">TRANG CHỦ</a>
                        </li>
                        <li class="menu-item"><a href="about.html">GIỚI THIỆU</a> </li>

                        <li class="menu-item menu-item-has-children dropdown"><a href="productList?page=1">SẢN PHẨM</a>
                            <ul class="sub-menu">
                                <li class="menu-item"><a href="productList?page=1&brand=Acer">Acer</a></li>
                                <li class="menu-item"><a href="productList?page=1&brand=Asus">Asus</a></li>
                                <li class="menu-item"><a href="productList?page=1&brand=Lenovo">Lenovo</a></li>
                                <li class="menu-item"><a href="productList?page=1&brand=Dell">Dell</a></li>
                                <li class="menu-item"><a href="productList?page=1&brand=HP">HP</a></li>
                                <li class="menu-item"><a href="productList?page=1&brand=Apple">Macbook</a></li>
                            </ul>
                        </li>
                        <li class="menu-item"><a href="contact-us.html">Liên Hệ</a></li>
                    </ul>
                </div>
                <div class="navigation__column right">
                    <form class="ps-search--header" action="seach" method="get" name="searchProduct" style="width: 260px">
                        <input class="form-control" type="search" id="search"  name="search" placeholder="Tìm kiếm sản phẩm..." onkeyup="searchInfo()">
                        <button type="submit"><i class="ps-icon-search" ></i></button>
                        <div class="clearfix"></div>
                        <span style="position: absolute; z-index: 1000; display: none; width: 350px; text-align: left; background-color: #f8f8f8;" id="mylocation"></span>
                    </form>

                    <div class="ps-cart"><a class="ps-cart__toggle" href="#"><i class="ps-icon-shopping-cart"></i></a>
                        <div class="ps-cart__listing">
                            <div class="ps-cart__content">
                                <div class="ps-cart-item"><a class="ps-cart-item__close" href="#"></a>
                                    <div class="ps-cart-item__thumbnail"><a href="product-detail.html"></a><img src="images/cart-preview/1.jpg" alt=""></div>
                                    <div class="ps-cart-item__content"><a class="ps-cart-item__title" href="product-detail.html">Asus vivobook A412FA
                                    </a>
                                        <p style="color: white; font-weight: bold;" ><span>SL:<i>1</i></span><span>Giá:<i>4 000 000đ</i></span></p>
                                    </div>
                                </div>
                                <div class="ps-cart-item"><a class="ps-cart-item__close" href="#"></a>
                                    <div class="ps-cart-item__thumbnail"><a href="product-detail.html"></a><img src="images/cart-preview/2.jpg" alt=""></div>
                                    <div class="ps-cart-item__content"><a class="ps-cart-item__title" href="product-detail.html">Dell Inspiron 5584 I5 8265U</a>
                                        <p style="color: white; font-weight: bold;"><span>SL:<i>1</i></span><span>Giá:<i>2 000 000đ</i></span></p>
                                    </div>
                                </div>
                                <div class="ps-cart-item"><a class="ps-cart-item__close" href="#"></a>
                                    <div class="ps-cart-item__thumbnail"><a href="product-detail.html"></a><img src="images/cart-preview/3.jpg" alt=""></div>
                                    <div class="ps-cart-item__content"><a class="ps-cart-item__title" href="product-detail.html">Dell Vostro 3590 I7 10510U</a>
                                        <p style="color: white; font-weight: bold;"><span>SL:<i>1</i></span><span>Giá:<i>3 000 000đ</i></span></p>
                                    </div>
                                </div>
                            </div>
                            <div class="ps-cart__total">
                                <p style="color: white; font-weight: bold;">Tổng SL:<span>3</span></p>
                                <p style="color: white; font-weight: bold;">Tổng tiền:<span>9 000 000đ</span></p>
                            </div>
                            <div class="ps-cart__footer"><a class="ps-btn" href="cart.html">Thanh toán ngay<i class="ps-icon-arrow-left"></i></a></div>
                        </div>
                    </div>
                    <div class="menu-toggle"><span></span></div>
                </div>
            </div>
        </nav>
    </div>
</header>
<!-- JS Library-->
</body>

</html>