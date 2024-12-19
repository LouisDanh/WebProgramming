<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Mô tả sản phẩm</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/css/product_description.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/css/btn.css">
</head>

<body>
	<jsp:include page="/views/shares/header.jsp"></jsp:include>
	<div class="container my-5">
		<div class="row">
			<!-- Phần hiển thị ảnh sản phẩm, chiếm 2 cột -->
			<div
				class="col-2 d-flex justify-content-start align-items-center flex-column px-2 gap-3">
				<c:forEach var="gallery" items="${product.galleries}">
					<img src="${pageContext.request.contextPath+gallery}"
						class="img-60px "
						data-large-image="${pageContext.request.contextPath+gallery}">
				</c:forEach>
			</div>
			<!-- Phần chi tiết sản phẩm, chiếm phần còn lại -->
			<div class="col">
				<div class="row">
					<!-- Chi tiết thành phần sản phẩm -->
					<div class="col">
						<div
							class="container d-flex justify-content-center align-items-center mb-4">
							<div
								class="image-container d-flex justify-content-center align-items-center"
								style="width: 526px; height: 526px;">
								<img id="mainImage" src="" class="img-60px" alt="Product Detail"
									class="img-fluid">
							</div>
						</div>
						<!-- Phần thành phần sản phẩm -->
						<div class="border-bottom">
							<div class="d-flex justify-content-between align-items-center">
								<h2 class="fw-bold">Thành phần</h2>
								<!-- Sử dụng fw-bold để làm đậm tiêu đề -->
								<div class="tang-kich-thuoc-plus">
									<i class="bi bi-plus" id="toggleIcon"></i>
								</div>
							</div>
							<!-- Thông tin chi tiết thành phần sản phẩm, mặc định ẩn -->
							<div id="ingredientsContent" class="d-none">
								<p class="text-muted">${product.description}</p>
								<p class="text-muted">Xin lưu ý rằng danh sách thành phần có
									thể thay đổi hoặc thay đổi theo thời gian. Vui lòng tham khảo
									danh sách thành phần trên gói sản phẩm bạn nhận được để biết
									danh sách thành phần cập nhật nhất.</p>
							</div>
						</div>
					</div>
					<!-- Phần thông tin và mua sản phẩm -->
					<div class="col">
						<div class="text-center mt-5">
							<!-- Tên sản phẩm (sử dụng h1 cho tiêu đề chính) -->
							<h3>${product.name}</h3>
							<h4 class="text-center fw-bold prices">${product.price}</h4>
							<div
								class="d-flex justify-content-center align-items-center gap-3 mb-3">
								<p class="mb-0 fw-bold">SLG</p>
								<!-- Sử dụng fw-bold để làm đậm từ SLG -->
								<!-- Container for quantity controls (minus, quantity, plus) -->
								<div class="d-flex align-items-center gap-0">
									<!-- Ô vuông chứa dấu trừ (giảm số lượng) -->
									<div class="border p-0" style="width: 40px; height: 40px;">
										<i id="decrease"
											class="bi bi-dash w-100 h-100 d-flex justify-content-center align-items-center"></i>
									</div>
									<!-- Ô vuông chứa số lượng -->
									<div class="border p-0" style="width: 40px; height: 40px;">
										<span
											class="text-center w-100 h-100 d-flex justify-content-center align-items-center"
											id="quantity">1</span>
									</div>
									<!-- Ô vuông chứa dấu cộng (tăng số lượng) -->
									<div class="border p-0" style="width: 40px; height: 40px;">
										<i id="increase"
											class="bi bi-plus w-100 h-100 d-flex justify-content-center align-items-center"></i>
									</div>
								</div>
								<!-- Nút thêm vào giỏ hàng với khoảng cách -->
								<button class="btn btn-dark ms-3">Thêm vào giỏ hàng</button>
							</div>
						</div>
						<!-- Thông tin giao hàng miễn phí -->
						<div class="text-center">
							<p class="mb-0 text-muted">Giao hàng tiêu chuẩn miễn phí và
								trả lại</p>
							<!-- Sử dụng text-muted để làm nhạt màu chữ cho thông tin phụ -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/static/js/descript.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/static/js/format_prices.js"></script>

</body>

</html>
