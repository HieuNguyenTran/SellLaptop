<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LaptopNLU - Checkout</title>
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
    <div class="ps-checkout pt-80 pb-80">
        <div class="ps-container">
            <form class="ps-checkout__form" action="do_action" method="post">
                <div class="row">
                    <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12 ">
                        <div class="ps-checkout__billing">
                            <h3>CHI TIẾT HÓA ĐƠN</h3>
                            <div class="form-group form-group--inline">
                                <label>Tên<span>*</span>
                                </label>
                                <input class="form-control" type="text" placeholder="Nhập tên">
                            </div>
                            <div class="form-group form-group--inline">
                                <label>Email<span>*</span>
                                </label>
                                <input class="form-control" type="email" placeholder="Nhập email">
                            </div>
                            <div class="form-group form-group--inline">
                                <label>Số điện thoại<span>*</span>
                                </label>
                                <input class="form-control" type="text" placeholder="Nhập số điện thoại">
                            </div>
                            <div class="form-group form-group--inline">
                                <label>Địa chỉ<span>*</span>
                                </label>
                                <textarea class="form-control" type="text" placeholder="Nhập địa chỉ"> </textarea>
                            </div>
                            <h3 class="mt-40"> Thông tin bổ sung</h3>
                            <div class="form-group form-group--inline textarea">
                                <label>Ghi chú đơn hàng</label>
                                <textarea class="form-control" rows="5"
                                          placeholder="Ghi chú về đơn đặt hàng của bạn ở đây."></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                        <div class="ps-checkout__order">
                            <header>
                                <h3>ĐƠN HÀNG CỦA BẠN</h3>
                            </header>
                            <div class="content">
                                <table class="table ps-checkout__products">
                                    <thead>
                                    <tr>
                                        <th class="text-uppercase">SẢN PHẨM</th>
                                        <th class="text-uppercase">Giá</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>Asus vivobook<br/>A412FA I5</td>
                                        <td>4 000000đ</td>
                                    </tr>
                                    <tr>
                                        <td>Dell Inspiron 5584 I5 8265U</td>
                                        <td>2 000000đ</td>
                                    </tr>
                                    <tr>
                                        <td>Dell Vostro<br/> 3590 I7 10510U</td>
                                        <td>3 000000đ</td>
                                    </tr>
                                    <td>TỔNG</td>
                                    <td>9 000000đ</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <footer>
                                <h3>PHƯƠNG THỨC THANH TOÁN</h3>
                                <div class="form-group cheque">
                                    <div class="ps-radio">
                                        <input class="form-control" type="radio" id="rdo01" name="payment" checked>
                                        <label for="rdo01">Thanh toán bằng chi phiếu:</label>
                                        <p>Vui lòng gửi chi phiếu của bạn theo địa chỉ : tên cửa hàng, đường,
                                            quận/huyện, thành phố/tỉnh, quốc gia, mã bưu điện</p>
                                    </div>
                                </div>
                                <div class="form-group paypal">
                                    <div class="ps-radio ps-radio--inline">
                                        <input class="form-control" type="radio" name="payment" id="rdo02">
                                        <label for="rdo02">Ví điện tử:</label>
                                    </div>
                                    <ul class="ps-payment-method">
                                        <li><a href="#"><img src="images/payment/1.png" alt=""></a></li>
                                        <li><a href="#"><img src="images/payment/2.png" alt=""></a></li>
                                        <li><a href="#"><img src="images/payment/3.png" alt=""></a></li>
                                    </ul>
                                    <button class="ps-btn ps-btn--fullwidth">ĐẶT HÀNG<i class="ps-icon-next"></i>
                                    </button>
                                </div>
                            </footer>
                        </div>
                        <div class="ps-shipping">
                            <h3>MIỄN PHÍ VẬN CHUYỂN</h3>
                            <p>ĐƠN HÀNG CỦA BẠN ĐƯỢC MIỄN PHÍ VẬN CHUYỂN.</p>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!-- Footer -->
    <jsp:include page="footer.jsp"></jsp:include>
</main>
</body>
</html>