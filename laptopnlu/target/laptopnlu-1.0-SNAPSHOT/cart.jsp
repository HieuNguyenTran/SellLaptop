<%@ page import="vn.edu.nlu.model.Cart" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LaptopNLU - Cart</title>
    <style>
        .btn-update{
            display: inline-block;
            height: 40px;
            width: 80px;
            border: none;
            background-color: #000;
            font-family: "Montserrat", sans-serif;
            color: #fff;
            font-size: 14px;
            -webkit-transition: all 0.4s ease;
            -moz-transition: all 0.4s ease;
            transition: all 0.4s ease;
        }
        .btn-update:hover{
            background-color: #50CF96;
        }
    </style>
</head>
<body class="ps-loading">
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
    <div class="ps-content pt-80 pb-80">
        <div class="ps-container">
            <div class="ps-cart-listing">
                <table class="table ps-cart__table">
                    <thead>
                    <tr>
                        <th>Tất cả sản phẩm</th>
                        <th>Giá</th>
                        <th>Số lượng</th>
                        <th>Thành tiền</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <% Cart cart = Cart.getCart(session); %>
                    <% request.setAttribute("listCart", cart.list());%>
                    <%--                    Start Single Product--%>
                    <c:forEach items="${listCart}" var="p">
                        <tr>
                            <td>
                                <a class="ps-product__preview" href="detail?id=${p.id}">
                                    <img class="mr-15" src="${p.mainImg}" alt="" style="width: 100px; height: 100px">
                                        ${p.ten}
                                </a>
                            </td>
                            <td >${p.pricesale}</td>
                            <td>
                                <form method="post" action="UpdateCart">
                                    <div class="form-group--number">
                                        <button class="minus"><span>-</span></button>
                                        <input type="hidden" name="id" value="${p.id}">
                                        <input class="form-control input" type="text" name="SL" value="${p.quantityInCart}">
                                        <button class="plus"><span>+</span></button>
                                    </div>
                                    <button class="btn-update">Cập nhật</button>
                                </form>
                            </td>
                            <td class="price">${p.thanhTien()}</td>
                            <td>
                                <a href="RemoveCart?id=${p.id}"><div class="ps-remove"></div></a>
                            </td>
                        </tr>
                    </c:forEach>
                    <%--                    End Single Product--%>
                    </tbody>
                </table>
                <div class="ps-cart__actions">
                    <div class="ps-cart__promotion">
                        <div class="form-group">
                            <button onclick="window.location.href='productList?page=1'" class="ps-btn ps-btn--gray">
                                Tiếp tục mua sắm
                            </button>
                        </div>
                    </div>
                    <div class="ps-cart__total">
                        <h3>Tổng cộng: <span id="total"><%=cart.total()%></span></h3><a class="ps-btn" href="checkout.jsp">Thanh
                        toán<i class="ps-icon-next"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Footer -->
    <jsp:include page="footer.jsp"></jsp:include>
</main>
<!-- quantity -->
<script>
    function formatNumber(nStr, decSeperate, groupSeperate) {
        nStr += '';
        x = nStr.split(decSeperate);
        x1 = x[0];
        x2 = x.length > 1 ? '.' + x[1] : '';
        var rgx = /(\d+)(\d{3})/;
        while (rgx.test(x1)) {
            x1 = x1.replace(rgx, '$1' + groupSeperate + '$2');
        }
        return x1 + x2;
    }
    function totalPrice(){
        var totalPrice = document.getElementsByClassName("price")
        var total =0;
        for (var i=0;i<totalPrice.length;i+=1){
            var price = parseInt(totalPrice[i].innerHTML, 10)
            total+=price
        }
        document.getElementById("total").innerHTML=formatNumber(total,'.',',')
    }
</script>
<script>
    $(document).ready(function() {
        $('.plus').click(function() {
            var i = $(this).parent().find('.input').val()
            var c = parseInt(i, 10)
            $(this).parent().find('.input').val(c + 1)
            var u = $(this).parent().parent().parent().find('.price1').text()
            var u1 = parseInt(u, 10)
            $(this).parent().parent().parent().find('.price').text(u1*(c+1))
            totalPrice()
        });
        $('.minus').on('click', function() {
            var i = $(this).parent().find('.input').val()
            var count = parseInt(i, 10)
            if (count - 1 >= 1) $(this).parent().find('.input').val(count - 1)
            var u = $(this).parent().parent().parent().find('.price1').text()
            var price1 = parseInt(u, 10)
            if (count - 1 >= 1) $(this).parent().parent().parent().find('.price').text( price1*(count-1))
            totalPrice()
        });
    });
</script>
<!--quantity-->
</body>
</html>