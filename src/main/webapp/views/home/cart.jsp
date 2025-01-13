<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertDefinition name="baseLayout">
	<!-- TITLE -->
	<tiles:putAttribute name="titlePage" value="cartPage" />

	<!-- CSS -->
	<tiles:putListAttribute name="pageCss">
		<tiles:addAttribute value="shopping_cart" />
		<tiles:addAttribute value="pay" />
		<tiles:addAttribute value="btn" />
	</tiles:putListAttribute>

	<!--SCRIPTS-->
	<tiles:putListAttribute name="pageJs">
		<tiles:addAttribute value="pay" />
		<tiles:addAttribute value="collapse" />
		<tiles:addAttribute value="total_cart" />
	</tiles:putListAttribute>

	<!-- AJAX -->
	<tiles:putListAttribute name="pageAjax">
		<tiles:addAttribute value="voucher" />
	</tiles:putListAttribute>
	<!-- BODY -->
	<tiles:putAttribute name="body">
		<div class="container">
			<div class="row align-items-start px-5 d-flex">
				<div class="container mt-3">
					<div class="row">
						<!-- Cột bên trái: Danh sách sản phẩm trong giỏ hàng -->
						<div class="col-8 d-flex flex-column align-items-center">
							<div class="text-center">
								<h2 id="cart-count" class="text-center">Giỏ hàng của bạn
									[1]</h2>
							</div>
							<div
								class="cart-items d-flex flex-column align-items-center border p-2">
								<c:if test="${not empty cartItems}">
									<div class="cart-items">
										<c:forEach var="cartItem" items="${cartItems}">

											<div class="cart-item border-bottom p-2">
												<div class="cart-item-details d-flex gap-5 p-3">
													<div class="product-image-wrapper">
														<!-- Hiển thị ảnh sản phẩm -->
														<c:forEach items="${cartItem.product.galleries}" var="img">
															<img
																src="${pageContext.request.contextPath}${img.link}"
																alt="${cartItem.product.name}" class="product-image">
														</c:forEach>


													</div>
													<div
														class="product-info-wrapper d-flex flex-column justify-content-between h-100">
														<div
															class="product-info d-flex justify-content-between mb-3">
															<div>
																<h6 class="mb-1">${cartItem.product.name}</h6>
																<p class="text-muted mb-0">Kích thước:
																	${cartItem.product.capacity}ml</p>
															</div>
														</div>
														<div
															class="quantity-controls d-flex align-items-center gap-0">
															<!-- Giảm số lượng -->
															<div class="quantity-btn decrease">
																<i class="bi bi-dash"></i>
															</div>
															<!-- Hiển thị số lượng -->
															<div class="quantity-btn">
																<span class="quantity-display">${cartItem.quantity}</span>
															</div>
															<!-- Tăng số lượng -->
															<div class="quantity-btn increase">
																<i class="bi bi-plus"></i>
															</div>
															<div class="ms-auto">
																<!-- Hiển thị tổng giá -->
																<h5 class="text-danger total-price"
																	data-price="${cartItem.product.price}">${cartItem.product.price}₫</h5>
															</div>
														</div>
													</div>
												</div>
											</div>
										</c:forEach>
									</div>
								</c:if>
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
											<span class="font-weight-bold">Tổng giá trị đơn hàng:</span>
											<span class="font-weight-bold text-danger" id="final-total">4.950.000₫</span>
										</div>
									</div>
								</div>
								<!-- Mã ưu đãi -->
								<div class="card p-3 mb-3 shadow-sm rounded">
									<form action="/voucher" method="POST">
										<div class="col-8">
											<div class="form-floating">
												<input type="text" id="voucher" name="voucher"
													class="form-control" value="" placeholder=" " /> <label
													for="voucher">NHẬP MÃ ƯU ĐÃI</label>
											</div>
										</div>
										<div class="col-4">
											<button type="button"
												class="btn btn-dark primary-color-hover"
												id="checkVoucherbtn">Áp dụng</button>
										</div>
									</form>
									<!-- Thẻ div để hiển thị kết quả hợp lệ hay không -->
									<div id="voucherMessage" class="mt-3" style="display: none;"></div>
								</div>
								<button class="collapse-btn btn btn-dark w-100 link"
									data-href="/WebMyPham/solving">
									<i class="bi bi-caret-down-fill"></i> Tiến hành thanh toán
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>



