<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Giỏ Hàng</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/css/shopping_cart.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/css/pay.css">
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/css/btn.css">
</head>

<body>
	<jsp:include page="/views/shares/header.jsp"></jsp:include>
	<div class="container mt-5">
		<div class="row align-items-start px-5 d-flex">
			<div class="container mt-5">
				<div class="row">
					<!-- Cột bên trái: Danh sách sản phẩm trong giỏ hàng -->
					<div class="col-8 d-flex flex-column align-items-center">
						<div class="text-center">
							<h2 id="cart-count" class="text-center">Giỏ hàng của bạn [1]</h2>
						</div>
						<div
							class="cart-items d-flex flex-column align-items-center border p-2">
							<!-- sp1 -->
							<div class="cart-item border-bottom p-2" data-price="4200000">
								<div class="cart-item-details d-flex gap-5 p-3">
									<div class="product-image-wrapper">
										<img src="${pageContext.request.contextPath}/resources/static/img/tiktok-icon.png"
											class="product-image">
									</div>
									<div
										class="product-info-wrapper d-flex flex-column justify-content-between h-100">
										<div class="product-info d-flex justify-content-between mb-3">
											<div>
												<h6 class="mb-1">Synchronized Multi-Recovery Complex</h6>
												<p class="text-muted mb-0">Kích thước: 75ml</p>
											</div>
										</div>
										<div class="quantity-controls d-flex align-items-center gap-0">
											<!-- Giảm số lượng -->
											<div class="quantity-btn">
												<i class="bi bi-dash decrease"></i>
											</div>
											<!-- Hiển thị số lượng -->
											<div class="quantity-btn">
												<span class="quantity-display">1</span>
											</div>
											<!-- Tăng số lượng -->
											<div class="quantity-btn">
												<i class="bi bi-plus increase"></i>
											</div>
											<div class="ms-auto">
												<h5 class="text-danger total-price" data-price="4200000"
													id="price-1">4.200.000₫</h5>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- sp2 -->
							<div class="cart-item border-bottom p-2" data-price="4200000">
								<div class="cart-item-details d-flex gap-5 p-3">
									<div class="product-image-wrapper">
										<img src="/el_sku_GXGP01_640x640_0.avif" class="product-image">
									</div>
									<div
										class="product-info-wrapper d-flex flex-column justify-content-between h-100">
										<div class="product-info d-flex justify-content-between mb-3">
											<div>
												<h6 class="mb-1">Synchronized Multi-Recovery Complex</h6>
												<p class="text-muted mb-0">Kích thước: 75ml</p>
											</div>
										</div>
										<div class="quantity-controls d-flex align-items-center gap-0">
											<!-- Giảm số lượng -->
											<div class="quantity-btn">
												<i class="bi bi-dash decrease"></i>
											</div>
											<!-- Hiển thị số lượng -->
											<div class="quantity-btn">
												<span class="quantity-display">1</span>
											</div>
											<!-- Tăng số lượng -->
											<div class="quantity-btn">
												<i class="bi bi-plus increase"></i>
											</div>
											<div class="ms-auto">
												<h5 class="text-danger total-price" data-price="3600000"
													id="price-2">3.600.000₫</h5>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- Cột bên phải: Thông tin thanh toán -->
					<div class="col">
						<div class="container mb-4">
							<!-- Thẻ thanh toán -->
							<div class="collapse-item mb-4">
								<button class="collapse-btn btn btn-dark w-100">
									<i class="bi bi-caret-down-fill"></i> Tiến hành thanh toán
								</button>
								<div class="collapse-content mt-3">
									<!--         <h5>Chọn phương thức thanh toán</h5> -->
									<div class="payment-methods">
										<button class="payment-method btn btn-dark w-100 mb-2">Thẻ
											tín dụng</button>
										<button class="payment-method btn btn-dark w-100 mb-2">PayPal</button>
										<button class="payment-method btn btn-dark w-100 mb-2">Chuyển
											khoản ngân hàng</button>
										<button class="payment-method btn btn-dark w-100 mb-2">Thanh
											toán khi nhận hàng</button>
									</div>
								</div>
							</div>


							<!-- Tóm tắt đơn hàng -->
							<div class="card shadow-sm mb-3">
								<div class="card-body">
									<h3 class="card-title text-center mb-4">Tóm tắt đơn hàng</h3>
									<div
										class="d-flex justify-content-between align-items-center border-bottom pb-3 mb-3">
										<span class="font-weight-bold">Tạm tính:</span> <span
											id="total-amount" class="font-weight-bold text-success">4.950.000₫</span>
									</div>
									<div
										class="d-flex justify-content-between align-items-center border-bottom pb-3 mb-3">
										<span class="font-weight-bold">Giao hàng:</span> <span
											class="text-muted">Giao hàng tiêu chuẩn (Miễn phí)</span>
									</div>
									<div
										class="d-flex justify-content-between align-items-center border-top pt-3">
										<span class="font-weight-bold">Tổng giá trị đơn hàng:</span> <span
											class="font-weight-bold text-danger" id="final-total">4.950.000₫</span>
									</div>
								</div>
							</div>
							<!-- Mã ưu đãi -->
							<div class="card p-3 mb-3 shadow-sm rounded">
								<div class="row g-2 align-items-center">
									<div class="col-8">
										<div class="form-floating">
											<input type="text" id="voucher" class="form-control"
												placeholder=" " /> <label for="voucher">NHẬP MÃ ƯU
												ĐÃI</label>
										</div>
									</div>
									<div class="col-4">
										<button type="button" class="btn btn-dark primary-color-hover">Áp
											dụng</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/static/js/total_cart.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/static/js/collapse.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/static/js/pay.js"></script>
</body>
</html>
