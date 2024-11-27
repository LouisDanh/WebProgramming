<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/css/list_product_category.css">
</head>
<body>
	<jsp:include page="/views/shares/header.jsp"></jsp:include>
	<main>
		<div class="container-fluid">
			<div class="p-5 w-100 h-50"></div>
			<div class="container">
				<h1 class="title-category">Category Name</h1>
				<p class="fs-15rem fw-light">Decription</p>
			</div>
			<div class="py-5 w-75 m-auto h-50">
				<div
					class="d-flex justify-content-between align-items-center shadow fs-4 fw-bold">
					<p class="p-4 m-0">
						<span>(25)</span> Kết quả
					</p>
					<div id="filter-product"
						class="px-5 py-4 bg-dark text-white cursor-pointer "
						data-bs-toggle="collapse" data-bs-target="#filter-content"
						aria-expanded="false" aria-controls="filter-content">
						<span class="me-2">Nhu cau cua toi</span> <i
							class="fa-solid fa-filter"></i>
					</div>
				</div>
				<div class="collapse bg-dark text-white p-5 no-transition shadow"
					id="filter-content">
					<div class="p-4">
						<h3 class="mb-4">Loai san pham</h3>
						<div class="d-flex flex-wrap gap-4 cursor-pointer">
							<div class="filter-item">
								<p class="p-3  m-0">
									Ná»i dung bÃªn trong <span>(Sá» lÆ°á»£ng)</span>
								</p>
							</div>
						</div>
					</div>
					<div class="d-flex align-items-center p-4">
						<p class="fs-4 m-0">DÃ²ng sáº£n pháº©m</p>
						<div class="dropdown w-50 ms-3 cursor-default ">
							<div
								class="d-flex justify-content-between align-items-center border-bottom py-2 px-3 dropdown-toggle"
								data-bs-toggle="dropdown" aria-expanded="false">
								<div class="fw-bold fs-5 m-0 text-wrap d-flex">
									<span class="me-2">Brand</span> <span id="dropdown-text-brand"></span>
								</div>
							</div>
							<div
								class="dropdown-menu w-100 shadow-lg fs-5 p-0 border-radius-1">
								<div
									class="dropdown-item disabled text-muted dropdown-brand-item">
									Brand</div>
								<div class="dropdown-item dropdown-brand-item">
									Glycolic Bright <span>(Sá» lÆ°á»£ng)</span>
								</div>
								<div class="dropdown-item dropdown-brand-item">
									DÆ°á»¡ng tráº¯ng da Aura Perfect <span>(Sá» lÆ°á»£ng)</span>
								</div>
								<div class="dropdown-item dropdown-brand-item">
									Revitalift <span>(Sá» lÆ°á»£ng)</span>
								</div>
								<div class="dropdown-item dropdown-brand-item">
									Youth Code <span>(Sá» lÆ°á»£ng)</span>
								</div>
								<div
									class="dropdown-item dropdown-brand-item pb-1 border-radius-1">
									Giáº£m thÃ¢m nÃ¡m Aura Perfect Clinical <span>(Sá»
										lÆ°á»£ng)</span>
								</div>
							</div>
						</div>
					</div>
					<!-- button filter -->
					<div class="p-4 d-flex align-items-center justify-content-end">
						<button id="filter-remove-button">
							<span class="me-2">XÃ³a toÃ n bá»</span> <i
								class="fa-solid fa-xmark"></i>
						</button>
						<button id="filter-submit-button" data-bs-toggle="collapse"
							data-bs-target="#filter-content" aria-expanded="false"
							aria-controls="filter-content">Xong</button>
					</div>
				</div>
			</div>
			<div class="container">
				<div class="row p-4">
					<div class="col-3 hover-zoom btn-link mb-4"
						data-href="https://www.w3schools.com/">
						<div class="card border-0 text-center">
							<img
								src="https://www.lorealparisusa.com/-/media/project/loreal/brand-sites/oap/americas/us/products/makeup/lip-color/lipstick/les-nus-intense-lipstick-intensely-pigmented/nu-impertinent/les-nus-impertinent-173-071249421758-primary.png?rev=b599fdaa54c046b58c6f5f54041e78c5&w=200&hash=37DCDDDD3E18F314410CE9365B2CECAF1A136492"
								alt="" class="img-card-top img-300px">
							<div class="card-body">
								<h6 class="subtitle">Superior Preference</h6>
								<h4 class="title">Cool Blonde Fade-Defying Shine Permanent
									Hair Color</h4>
							</div>
							<div class="card-footer border-0 bg-transparent">
								<p class="card-text">11.99</p>
								<div class="d-flex gap-1 justify-content-center">
									<span class="text-dark"><i class="fa-solid fa-star"></i></span>
									<span class="text-dark"><i class="fa-solid fa-star"></i></span>
									<span class="text-dark"><i class="fa-solid fa-star"></i></span>
									<span class="text-dark"><i class="fa-solid fa-star"></i></span>
									<span class="text-secondary"><i class="fa-solid fa-star"></i></span>
									<span class="ms-2">4/5</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<jsp:include page="/views/shares/footer.jsp"></jsp:include>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/static/js/filter_category.js"></script>
</body>

</html>