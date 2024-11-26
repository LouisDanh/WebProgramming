<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Thêm Font Awesome cho các biểu tượng mạng xã hội -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <style>
        footer {
            background-color: #f8f9fa;
            padding: 40px 0;
        }
        footer h5 {
            font-weight: bold;
            color: #343a40;
        }
        footer a {
            color: #6c757d;
            text-decoration: none;
        }
        footer a:hover {
            color: #007bff;
            text-decoration: underline;
        }
        .social-icons i {
            transition: transform 0.3s ease;
        }
        .social-icons i:hover {
            transform: scale(1.2);
        }
        .input-group .form-control {
            border-radius: 30px;
        }
        .input-group .btn {
            border-radius: 30px;
        }
        .copyright {
            font-size: 0.9rem;
            color: #6c757d;
        }
    </style>
</head>
<body>
	<footer>
		<div class="container">
			<div class="row">

				<!-- Thông tin công ty -->
				<div class="col-md-3">
					<h5>Thông tin công ty</h5>
					<p>Địa chỉ: 123 Đường ABC, Quận 1, TP.HCM</p>
					<p>Số điện thoại: 0901234567</p>
					<p>Email: info@mypham.com</p>
					<p>Giờ làm việc: 8:00 - 18:00</p>
				</div>

				<!-- Liên kết nhanh -->
				<div class="col-md-3">
					<h5>Liên kết nhanh</h5>
					<ul class="list-unstyled">
						<li><a href="#">Trang chủ</a></li>
						<li><a href="#">Sản phẩm</a></li>
						<li><a href="#">Giới thiệu</a></li>
						<li><a href="#">Chính sách bảo mật</a></li>
						<li><a href="#">Liên hệ</a></li>
					</ul>
				</div>

				<!-- Dịch vụ -->
				<div class="col-md-3">
					<h5>Dịch vụ</h5>
					<ul class="list-unstyled">
						<li><a href="#">Giao hàng nhanh</a></li>
						<li><a href="#">Đổi trả miễn phí</a></li>
						<li><a href="#">Thanh toán khi nhận hàng</a></li>
						<li><a href="#">Chăm sóc khách hàng</a></li>
					</ul>
				</div>

				<!-- Hỗ trợ khách hàng -->
				<div class="col-md-3">
					<h5>Hỗ trợ khách hàng</h5>
					<ul class="list-unstyled">
						<li><a href="#">FAQ</a></li>
						<li><a href="#">Chính sách đổi trả</a></li>
						<li><a href="#">Bảo hành sản phẩm</a></li>
						<li><a href="#">Hướng dẫn mua hàng</a></li>
					</ul>
				</div>
			</div>
			<div class="row">
				<!-- Mạng xã hội -->
				<div class="col-md-12 text-center">
					<h5>Kết nối với chúng tôi</h5>
					<ul
						class="list-unstyled d-flex justify-content-center social-icons">
						<!-- Facebook Icon -->
						<li class="mx-3"><a href="#" target="_blank"> <i
								class="fab fa-facebook fa-3x"></i>
						</a></li>
						<!-- Instagram Icon -->
						<li class="mx-3"><a href="#" target="_blank"> <i
								class="fab fa-instagram fa-3x"></i>
						</a></li>
						<!-- TikTok Icon -->
						<li class="mx-3"><a href="#" target="_blank"> <i
								class="fab fa-tiktok fa-3x"></i>
						</a></li>
					</ul>
				</div>
			</div>
			<!-- Đăng ký nhận tin -->
			<div class="text-center mt-4">
				<h5>Đăng ký nhận bản tin</h5>
				<form action="#">
					<div class="input-group mx-auto" style="max-width: 350px;">
						<input type="email" class="form-control"
							placeholder="Nhập email của bạn" required>
						<button class="btn btn-primary" type="submit">Đăng ký</button>
					</div>
				</form>
			</div>

			<!-- Bản quyền -->
			<div class="text-center mt-4 copyright">
				<p>© 2024 HISHAKU. Tất cả quyền được bảo lưu.</p>
			</div>
		</div>
	</footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>