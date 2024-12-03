<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/css/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/css/search_bar.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/css/category.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/css/share.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/css/btn.css">

</head>
<body>
	<jsp:include page="/views/shares/staticlib.jsp"></jsp:include>
	<header>
		<div
			class="container d-flex justify-content-between align-items-center">
			<!-- Logo -->
			<div class="logo btn-link"
				data-href="${pageContext.request.contextPath}/views/home/home.jsp">
				HISHAKU</div>

			<!-- Menu Navigation -->
			<nav class="navbar navbar-expand-lg navbar-light">
				<div class="navbar-nav">
					<a class="nav-link" href="#" onclick="toggleSubCategory('brand')"><strong>NƯỚC
							HOA</strong> </a> <a class="nav-link" href="#"
						onclick="toggleSubCategory('skincare')"><strong>DƯỠNG
							DA</strong></a> <a class="nav-link" href="#"
						onclick="toggleSubCategory('makeup')"><strong>TRANG
							ĐIỂM</strong></a> <a class="nav-link" href="#"
						onclick="toggleSubCategory('haircare')"><strong>CHĂM
							SÓC NHUỘM TÓC</strong></a>
				</div>
			</nav>
			<!-- Tools Section -->
			<div class="d-flex justify-content-between align-items-center">
				<!-- Tìm kiếm Text (Search) -->
				<div>
					<a id="finding" class="btn-link"
						href="${pageContext.request.contextPath}/views/home/listProductSearch.jsp">
						Tìm kiếm </a>
				</div>
				<div id="headerContainer">
					<div id="hamburgerIcon">
						<i class="fas fa-bars"></i>
					</div>
					<div id="extraIcons">
						<!-- Cart Icon -->
						<div class="btn-link"
							data-href="${pageContext.request.contextPath}/views/home/cart.jsp">
							<i class="fas fa-shopping-cart"></i> Giỏ hàng
						</div>
						<!-- Logout Icon -->
						<div class="btn-link" id="logoutIcon"
							data-href="${pageContext.request.contextPath}/views/login/login.jsp">
							<i class="fas fa-sign-out-alt"></i> Đăng xuất
						</div>
						<!-- Personal Profile Icon -->
						<div class="btn-link" id="profileIcon"
							data-href="${pageContext.request.contextPath}/views/profile/profile.jsp">
							<i class="fas fa-user"></i> Hồ sơ
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<div class="danhMuc cursor-pointer">
		<!-- danh mục nước hoa -->
		<div id="brand" class="sub-category">
			<div class="d-flex row">
				<div class="col-1"></div>
				<div class="d-flex flex-column col-2">
					<div>
						<h5>Nhãn hàng Nước hoa</h5>
					</div>
					<br>
					<div>
						<span>Câu chuyện các nhãn hàng nước hoa</span>
					</div>
					<div>
						<span>Lịch sử các nhãn hàng nước hoa</span>
					</div>
					<div>
						<span>Đại sứ nhãn hàng nước hoa</span>
					</div>
				</div>
				<div class="d-flex flex-column col-2">
					<div>
						<h5>Cam kết của chúng tôi</h5>
					</div>
					<br>
					<div>
						<span>Làm đẹp bền vững trong ngành nước hoa</span>
					</div>
				</div>
				<div class="d-flex flex-column col-2">
					<div>
						<h5>Khoa học Nước hoa</h5>
					</div>
					<br>
					<div>
						<span>Nghiên cứu các thành phần trong nước hoa</span>
					</div>
					<div>
						<span>Trải nghiệm dịch vụ thử nước hoa thực tế ảo</span>
					</div>
				</div>
				<div class="d-flex flex-column col-2">
					<div>
						<h5>Thư viện thành phần</h5>
					</div>
					<br>
					<div>
						<span>Hương hoa hồng</span>
					</div>
					<div>
						<span>Hương gỗ</span>
					</div>
					<div>
						<span>Hương vani</span>
					</div>
					<div>
						<span>Hương cam quýt</span>
					</div>
					<div>
						<span>Hương xạ hương</span>
					</div>
				</div>
				<div class="d-flex flex-column col-2">
					<div>
						<h5>Các loại nước hoa</h5>
					</div>
					<br>
					<div>
						<span>Nước hoa Eau de Parfum (EDP)</span>
					</div>
					<div>
						<span>Nước hoa Eau de Toilette (EDT)</span>
					</div>
					<div>
						<span>Nước hoa Eau de Cologne (EDC)</span>
					</div>
					<div>
						<span>Nước hoa Unisex</span>
					</div>
				</div>
			</div>
		</div>
		<!-- danh mục dưỡng da -->
		<div id="skincare" class="sub-category">
			<div class="d-flex container">

				<div class="d-flex flex-column col-3">
					<div>
						<h5>Chăm sóc da mặt</h5>
					</div>
					<br>
					<div>
						<span>Tinh chất dưỡng da</span>
					</div>
					<div>
						<span>Sữa rửa mặt</span>
					</div>
					<div>
						<span>Kem dưỡng da ban đêm</span>
					</div>
					<div>
						<span>Nước cân bằng da</span>
					</div>
					<div>
						<span>Mặt nạ</span>
					</div>
					<div>
						<span class="sub-category-allProduct">Xem toàn bộ sản phẩm
							chăm sóc da mặt</span>
					</div>
				</div>
				<div class="d-flex flex-column col-3">
					<div>
						<h5>Tẩy trang và làm sạch</h5>
					</div>
					<br>
					<div>
						<span>Micellar Water</span>
					</div>
					<div>
						<span>Sửa rửa mặt Aura perfect</span>
					</div>
					<div>
						<span class="sub-category-allProduct">Xem tất cả sản phẩm
							tẩy trang và làm sạch</span>
					</div>
				</div>
				<div class="d-flex flex-column col-3 ">

					<div>
						<h5>Kem chống nắng</h5>
					</div>
					<br>
					<div>
						<span>Kem chống nắng UV Defender</span>
					</div>
					<div>
						<span>Kem chống nắng UV Perfect</span>
					</div>
					<div>
						<span class="sub-category-allProduct">Xem tất cả kem chống
							nắng</span>
					</div>
				</div>
				<div class="border"></div>
				<div class="p-3"></div>
				<div class="d-flex flex-column col-3">
					<div>
						<h5>Các dòng sản phẩm dưỡng da</h5>
					</div>
					<br>
					<div class="row">
						<div class="col-6">
							<div>
								<span>La Roche-Posay</span>
							</div>
							<div>
								<span>CeraVe Hydrating</span>
							</div>
							<div>
								<span>The Ordinary Niacinamide</span>
							</div>
						</div>
						<div class="col-6">
							<div>
								<span>Neutrogena Hydro Boost</span>
							</div>
							<div>
								<span>Clinique Moisture Surge</span>
							</div>
							<div>
								<span>Paula's Choice Skin Recovery</span>
							</div>
							<div>
								<span>Estée Lauder Advanced Night Repair</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- danh mục trang điểm -->
		<div id="makeup" class="sub-category">
			<div class="d-flex container">
				<div class="d-flex flex-column col-3">
					<div>
						<h5>Sản phẩm trang điểm mặt</h5>
					</div>
					<br>
					<div>
						<span>Kem nền</span>
					</div>
					<div>
						<span>Phấn phủ</span>
					</div>
					<div>
						<span>Kem che khuyết điểm</span>
					</div>
					<div>
						<span>Phấn má hổng</span>
					</div>
					<div>
						<span class="sub-category-allProduct">Xem tất cả sản phẩm
							trang điểm mặt</span>
					</div>
				</div>
				<div class="d-flex flex-column col-3">
					<div>
						<h5>Sản phẩm trang điểm môi</h5>
					</div>
					<br>
					<div>
						<span>Son thỏi</span>
					</div>
					<div>
						<span class="sub-category-allProduct">Xem tất cả sản phẩm
							trang điểm môi</span>
					</div>
				</div>
				<div class="d-flex flex-column col-3 ">
					<!-- Add a border-right here -->
					<div>
						<h5>Trang điểm mắt</h5>
					</div>
					<br>
					<div>
						<span>Mascara</span>
					</div>
					<div>
						<span>Kẻ mắt</span>
					</div>
					<div>
						<span>Chì kẻ mày</span>
					</div>
					<div>
						<span class="sub-category-allProduct">Xem tất cả sản phẩm
							trang điểm môi</span>
					</div>
				</div>
				<div class="border"></div>
				<div class="p-3"></div>
				<div class="d-flex flex-column col-3">
					<div>
						<h5>Các dòng sản phẩm trang điểm</h5>
					</div>
					<br>
					<div class="row">
						<div class="col-6">
							<div>
								<span>Fenty Beauty Foundation</span>
							</div>
							<div>
								<span>Maybelline Matte Ink</span>
							</div>
							<div>
								<span>MAC Studio Fix</span>
							</div>
						</div>
						<div class="col-6">
							<div>
								<span>Too Faced Mascara</span>
							</div>
							<div>
								<span>Urban Decay Palette</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- danh mục chăm sóc nhuộm tóc -->
		<div id="haircare" class="sub-category">
			<div class="d-flex container">
				<div class="d-flex flex-column col-3">
					<div>
						<h5>Chăm sóc tóc</h5>
					</div>
					<br>
					<div>
						<span>Dầu gội</span>
					</div>
					<div>
						<span>Dầu xả</span>
					</div>
					<div>
						<span>Kem dưỡng tóc</span>
					</div>
					<div>
						<span>Mặt nạ dưỡng tóc</span>
					</div>
					<div>
						<span>Tinh chất dưỡng tóc</span>
					</div>
					<div>
						<span class="sub-category-allProduct">Xem tất cả sản phẩm
							dưỡng tóc</span>
					</div>
				</div>
				<div class="d-flex flex-column col-4">
					<div>
						<h5>Thuốc nhuộm tóc</h5>
					</div>
					<br>
					<div>
						<span>Nhuộm tóc chuẩn thời trang</span>
					</div>
					<div>
						<span class="sub-category-allProduct">Xem tất cả sản phẩm
							nhuộm tóc</span>
					</div>
				</div>
				<div class="border"></div>
				<div class="p-4"></div>
				<div class="d-flex flex-column col-4">
					<div>
						<h5>Các dòng sản phẩm tóc</h5>
					</div>
					<br>
					<div class="row">
						<div class="col-6">
							<div>
								<span>L'Oréal Paris Elvive Dream Lengths</span>
							</div>
							<div>
								<span>Olaplex No. 3 Hair Perfector</span>
							</div>
							<div>
								<span>Moroccanoil Treatment</span>
							</div>
							<div>
								<span>Redken Extreme Shampoo</span>
							</div>
							<div>
								<span>Pureology Hydrate Shampoo</span>
							</div>
						</div>
						<div class="col-6">
							<div>
								<span>John Frieda Frizz Ease Serum</span>
							</div>
							<div>
								<span>Schwarzkopf Professional BlondMe</span>
							</div>
							<div>
								<span>Wella Professionals Color Charm</span>
							</div>
							<div>
								<span>Garnier Nutrisse Nourishing Color Creme</span>
							</div>
							<div>
								<span>Clairol Nice'n Easy</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<script
		src="${pageContext.request.contextPath}/resources/static/js/category.js"
		type="text/javascript" defer></script>
	<script
		src="${pageContext.request.contextPath}/resources/static/js/search_bar.js"
		type="text/javascript">
		
	</script>
	<script
		src="${pageContext.request.contextPath}/resources/static/js/hiddenTools.js"
		type="text/javascript">
		
	</script>
</body>
</html>