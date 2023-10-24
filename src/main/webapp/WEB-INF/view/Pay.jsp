<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment</title>
    <style>
        /* CSS cho biểu mẫu */
        .payment-form {
            max-width: 100%;
            margin: 0 auto;
            padding: 30px;
        }

        .form-title {
            font-size: 24px;
            margin-bottom: 20px;
        }

        .form-group {
            margin-bottom: 10px;
            max-width: 500%;
        }

        .form-group input[type="text"],
        .form-group select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 10px;
        }

        .radio-group {
            padding: 10px 0;
        }

        .form-actions {
            text-align: center;
        }

        .form-actions button {
            padding: 0;
            font-size: 15px;
            border-radius: 8px;
            width: 80px; /* Kích thước chiều rộng 100% */
            height: 50px; /* Kích thước chiều cao 50px */
        }
        .return-button {
            margin-top: 10px;
        }

        /* CSS để hiển thị số điện thoại và email trên cùng một dòng */
        .flex-container {
            display: flex;
            flex-direction: row;
        }

     .flex-container .form-group {
    flex: 1;
    margin-right: 10px; /* Thêm khoảng cách 10px về phía bên phải của mỗi ô nhập trong flex container */
}


        .flex-container .form-group + .form-group {
            margin-left: 20px; /* Khoảng cách 10px giữa các ô */
        }

        .cart-container {
            border: 1px solid #ccc;
            padding: 10px;
            max-width: 70%;
            margin: 20px auto;
            border-radius: 10px;
        }

        .cart-container table {
            width: 100%;
            border-collapse: collapse;
        }

        .cart-container table th,
        .cart-container table td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: left;
        }

        .cart-container table th:first-child,
        .cart-container table td:first-child {
            padding-left: 50px; /* Khoảng cách bên trái của cột "Sản Phẩm" */
        }

        .cart-container table th:nth-child(2),
        .cart-container table td:nth-child(2) {
            padding-left: 50px; /* Khoảng cách bên trái của cột "Đơn Giá" */
        }

        .cart-container table th:nth-child(3),
        .cart-container table td:nth-child(3) {
            padding-left: 50px; /* Khoảng cách bên trái của cột "Số Lượng" */
        }
    </style>
</head>
<body>
    <div class="payment-form">
        <h2 class="form-title">THÔNG TIN ĐƠN HÀNG</h2>
        <form action="payment" method="post">
            <div class="form-group">
                <input type="text" id="fullname" name="fullname" required placeholder="Họ và Tên">
            </div>
            <div class="flex-container">
                <div class="form-group">
                    <input type="text" id="phone" name="phone" required placeholder="Số Điện Thoại">
                </div>
                <div class="form-group">
                    <input type="text" id="email" name="email" required placeholder="Email">
                </div>
            </div>
            <div class="form-group">
                <input type="text" id="address" name "address" required placeholder="Địa chỉ nhận hàng">
            </div>
            <div class="radio-group">
                <p>Chọn phương thức thanh toán:</p>
                <input type="radio" id="cod" name="payment-method" value="COD" required>
                <label for="cod">COD (Thanh toán khi nhận hàng)</label><br>
                <input type="radio" id="online" name="payment-method" value="online" required>
                <label for="online">Thanh toán online</label><br>
                <input type="radio" id="momo" name="payment-method" value="momo" required>
                <label for="momo">Ví Momo</label><br>
            </div>
            <!-- Thêm sản phẩm vào giỏ hàng -->
            <div class="cart-container">
                <table>
                    <thead>
                        <tr>
                            <th>Sản Phẩm</th>
                            <th>Đơn Giá</th>
                            <th>Số Lượng</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="totalPrice" value="0" />
                        <c:forEach items="${cart}" var="cartItem">
                            <tr>
                                <td>${cartItem.p.name}</td>
                                <td>${cartItem.p.price}</td>
                                <td>${cartItem.quantity}</td>
                            </tr>
                            <c:set var="totalPrice" value="${totalPrice + (cartItem.p.price * cartItem.quantity)}" />
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <!-- Kết thúc khung giỏ hàng -->
   <div>
    <c:set var="totalPrice" value="0" />
    <c:forEach items="${cart}" var="cartItem">
        <c:set var="productPrice" value="${cartItem.p.price}" />
        <c:set var="productQuantity" value="${cartItem.quantity}" />
        <c:set var="subtotal" value="${productPrice * productQuantity}" />
        <c:set var="totalPrice" value="${totalPrice + subtotal}" />
    </c:forEach>
    
             <strong class="text-muted">Tổng thanh toán:</strong>
              <strong class="text-muted">Tổng thanh toán:</strong>
               <c:out value="${totalPrice *1.05}" />


            <div class="form-actions">
                <button type="submit">Hoàn Tất</button>
            </div>
        </form>
        <div class="return-button">
            <a href="GioHangServlet">Trở về Giỏ Hàng</a>
        </div>
    </div>
</body>
</html>
