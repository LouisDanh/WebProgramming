<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container my-5">
		<!-- content lễ hội -->
		<div class="mb-5">
			<h2 class="h2 text-center fs-1">Mua sắm lễ hội</h2>
			<p class="text-center">Nội dung cần chỉnh sửa</p>

			<!-- thể loại sản phẩm -->
			<ul
				class="list-unstyled d-flex gap-3 justify-content-center align-items-center">
				<li class="tabled-products fw-bold">Phiên bản giới hạn</li>
				<li>|</li>
				<li class="tabled-products">Dưỡng da</li>
				<li>|</li>
				<li class="tabled-products">Trang điểm</li>
				<li>|</li>
				<li class="tabled-products">Nước hoa</li>
			</ul>

			<!-- sản phẩm -->
			<div class="container carousel slide position-relative"
				id="carousel-tabled-products" data-bs-wrap="true">
				<div class="carousel-inner">
					<!-- list 1 -->
					<div class="tabled-product-detail">
						<div class="carousel-item active ">
							<!-- 5 sản phẩm đc hiển thị -->
							<div class="d-flex flex-row gap-3">
									<div class="card border-0 w-25 btn-link">
										<img
											src="https://www.esteelauder.com.vn/media/export/cms/products/308x424/el_sku_G1VI01_308x424_0.jpg"
											alt="ảnh sản phẩm" class="card-img-top">
										<div class="card-body">
											<h5 class="card-title">Tên sản phẩm</h5>
											<h6 class="card-subtitle">Mô tả thêm sự kiện (có hoặc
												không)</h6>
											<p class="fw-bold card-text">3.900.000đ</p>
										</div>
									</div>
									<div class="card border-0 w-25 btn-link">
										<img
											src="https://www.esteelauder.com.vn/media/export/cms/products/308x424/el_sku_G1V901_308x424_0.jpg"
											alt="ảnh sản phẩm" class="card-img-top">
										<div class="card-body">
											<h5 class="card-title">Tên sản phẩm</h5>
											<h6 class="card-subtitle">Mô tả thêm sự kiện (có hoặc
												không)</h6>
											<p class="fw-bold card-text">3.900.000đ</p>
										</div>
									</div>
							</div>
						</div>
						<div class="carousel-item">
							<!-- 5 sản phẩm đc hiển thị -->
							<div class="d-flex flex-row gap-3"></div>
						</div>
						<!-- list 2 -->
					</div>
					<div class="tabled-product-detail d-none"></div>
				</div>
				<button class="text-dark carousel-control-prev l-out" type="button"
					data-bs-target="#carousel-tabled-products" data-bs-slide="prev">
					<span class="display-4">&lt;</span>
				</button>
				<button class="text-dark carousel-control-next r-out" type="button"
					data-bs-target="#carousel-tabled-products" data-bs-slide="next">
					<span class="display-4">&gt;</span>
				</button>
			</div>
		</div>
		<!-- content món quà -->
		<div class="mb-5">
			<h2 class="h2 text-center mb-4 fs-1">Món quà từ phép màu</h2>
			<p class="text-center mb-4">Nội dung cần chỉnh sửa</p>
			<div class="d-flex flex-row gap-3">
				<div class="card border-0">
					<img
						src="https://www.esteelauder.com.vn/media/export/cms/special-offers/glo_hol001_110224_hp_3up_holiday_bestsellers_skincare_1366x1366.avif"
						alt="Dưỡng Da" class="card-img-top img-fluid">
					<div class="card-body">
						<h5 class="card-title">Dưỡng Da</h5>
						<a href="" class="text-uppercase  fw-bold">Mua ngay</a>
					</div>
				</div>
				<div class="card border-0">
					<img
						src="https://www.esteelauder.com.vn/media/export/cms/special-offers/glo_hol001_110224_hp_3up_holiday_bestsellers_makeup_1366x1366.avif"
						alt="Nước hoa" class="card-img-top img-fluid">
					<div class="card-body">
						<h5 class="card-title">Nước hoa</h5>
						<a href="" class="text-uppercase fw-bold">Mua ngay</a>
					</div>
				</div>
				<div class="card border-0">
					<img
						src="https://www.esteelauder.com.vn/media/export/cms/special-offers/glo_hol001_110224_hp_3up_holiday_bestsellers_fragrance_1366x1366.avif"
						alt="Trang Điểm" class="card-img-top img-fluid">
					<div class="card-body">
						<h5 class="card-title">Trang Điểm</h5>
						<a href="" class="text-uppercase fw-bold">Mua ngay</a>
					</div>
				</div>
			</div>
		</div>
		<!-- content chu trình -->
		<div class="mb-5">
			<h2 class="h2 text-center mb-4 fs-1">Hoàn thiện chu trình dưỡng
				da hàng ngày</h2>
			<p class="text-center mb-0">Làn da đẹp bắt đầu ngay hôm nay.</p>
			<p class="text-center mb-4">Hãy khám phá những sản phẩm cần thiết
				để bổ sung những dưỡng chất cũng như tối ưu hóa chu trình để mang
				lại một làn da khỏe mạnh.</p>
			<div class="container my-5">
				<div class="row justify-content-center gap-4">
					<div
						class="col-12 col-md-2 d-flex flex-column align-items-center mb-4 position-relative">
						<img
							src="https://www.esteelauder.com.vn/media/boutiques/skincare-regimen/SkincareRegimenModule_PC1.jpg"
							class="img-fluid w-100   mb-2" alt="Sữa rửa mặt">
						<div class="position-absolute top-50 text-center">
							<h5 class="fs-4">Sữa rửa mặt</h5>
							<p class="small">Làm sạch da bằng sữa rửa mặt dịu nhẹ, đã tác
								dụng.</p>
							<p class="small">Massage khắp mặt bằng chuyển động tròn. Rửa
								sạch lại với nước.</p>
						</div>
					</div>
					<div
						class="col-12 col-md-2 d-flex flex-column align-items-center mb-4 position-relative">
						<img
							src="https://www.esteelauder.com.vn/media/boutiques/skincare-regimen/SkincareRegimenModule_PC2.jpg"
							class="img-fluid w-100  mb-2" alt="Nước dưỡng">
						<div class="position-absolute top-50 text-center">
							<h5 class="fs-4 ">Nước dưỡng</h5>
							<p class="small">Bước đầu giúp làn da được làm dịu và cấp ẩm
								đầy đủ.</p>
							<p class="small">Đổ nước dưỡng vào lòng bàn tay. Xoa đều hai
								bàn tay với nhau. Sau đó vỗ nhẹ lên má, cằm và trán. Hoặc, có
								thể sử dụng miếng bông thay thế.</p>
						</div>
					</div>
					<div
						class="col-12 col-md-2 d-flex flex-column align-items-center mb-4 position-relative">
						<img
							src="https://www.esteelauder.com.vn/media/boutiques/skincare-regimen/SkincareRegimenModule_PC3.jpg"
							class="img-fluid w-100  mb-2" alt="Tinh chất phục hồi">
						<div class="position-absolute top-50 text-center ">
							<h5 class="fs-4">Tinh chất phục hồi</h5>
							<p class="small">Điều trị chống lão hóa chuyên sâu.</p>
							<p class="small">Massage lên mặt theo hình trái tim, bắt đầu
								từ giữa mặt & xuống cằm.</p>
						</div>
					</div>
					<div
						class="col-12 col-md-2 d-flex flex-column align-items-center mb-4 position-relative">
						<img
							src="https://www.esteelauder.com.vn/media/boutiques/skincare-regimen/SkincareRegimenModule_PC4.jpg"
							class="img-fluid w-100  mb-2" alt="Kem dưỡng ẩm">
						<div class="position-absolute top-50 text-center">
							<h5 class="fs-4">Kem dưỡng ẩm</h5>
							<p class="small">Được thiết kế chuyên biệt với từng nhu cầu
								của làn da</p>
							<p class="small">Thoa kem trên đầu ngón tay giúp làm nóng nhẹ
								kem. Sau đó nhẹ nhàng thoa lên mặt từ trung tâm ra ngoài. Ấn cả
								hai tay lên má, trán và cằm.</p>
						</div>
					</div>
					<div
						class="col-12 col-md-2 d-flex flex-column align-items-center mb-4 position-relative">
						<img
							src="https://www.esteelauder.com.vn/media/boutiques/skincare-regimen/SkincareRegimenModule_PC5.jpg"
							class="w-100 mb-2 img-fluid" alt="Chăm sóc mắt">
						<div class="position-absolute top-50 text-center">
							<h5 class="fs-4">Chăm sóc mắt</h5>
							<p class="small">Điều trị nhắm mục tiêu. Dưỡng ẩm phong phú,
								hiệu quả cao và nhẹ nhàng.</p>
							<p class="small">Dùng ngón áp út chấm 3 chấm. 1 ở góc ngoài,
								1 ở giữa dưới mắt & 1 ở góc trong mắt. Vỗ nhẹ để thẩm thấu vào
								da.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- content lão hóa -->
		<div class="mb-5">
			<h2 class="h2 text-center mb-4 fs-1">Chống lại các dấu hiệu lão
				hóa</h2>
			<p class="text-center mb-4">Nội dung cần chỉnh sửa</p>
			<div class="d-flex flex-row gap-3">
				<div class="card border-0">
					<video
						src="https://www.esteelauder.com.vn/media/export/cms/homepage/SP22_Supreme_Power_Demo_2.mp4"
						playsinline preload="none" autoplay="true"
						controlslist="nodownload" muted loop>
					</video>
				</div>
				<div class="card border-0">
					<video
						src="https://www.esteelauder.com.vn/media/export/cms/homepage/SP22_ME_Power_Demo-CORE_Barrier_Strength_Challenge_Square_SUPER.mp4"
						playsinline preload="none" autoplay="true"
						controlslist="nodownload" muted loop>
					</video>
				</div>
				<div class="card border-0">
					<video
						src="https://www.esteelauder.com.vn/media/export/cms/homepage/FL20_ANR_X5_Power_Demo_Anti_Oxidant_22s_1080x1080_Supers_Global.mp4"
						playsinline preload="none" autoplay="true"
						controlslist="nodownload" muted loop>
					</video>
				</div>
			</div>
		</div>
	</div>
	
</body>

</html>