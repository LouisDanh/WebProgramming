<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:insertDefinition name="baseLayout">
	<tiles:insertAttribute name="titlePage" value="Product Category" />
	<tiles:putListAttribute name="pageCss">
		<tiles:addAttribute value="list_product_category" />
	</tiles:putListAttribute>
	<tiles:putListAttribute name="pageJs">
		<tiles:addAttribute value="filter_category" />
		<tiles:addAttribute value="collapse" />
	</tiles:putListAttribute>
	<tiles:putAttribute name="body">
		<c:set var="category"
			value="${category.parent==null?currentType:currentType.parent}" />
		<div class="container-fluid">
			<div class="p-5 w-100 h-50"></div>
			<div class="container">
				<h2 class="title-category">${currentType.name}</h2>
				<p class="fs-15rem fw-light">${currentType.description}</p>
			</div>
			<div class="py-5 w-75 m-auto h-50">
				<div
					class="d-flex justify-content-between align-items-center shadow fs-4 fw-bold collapse-btn">
					<p class="p-4 m-0">
						<span>(${currentType.products.size()})</span> Kết quả
					</p>
					<div id="filter-product"
						class="px-5 py-4 bg-dark text-white cursor-pointer ">
						<span class="me-2">Nhu cau cua toi</span> <i
							class="fa-solid fa-filter"></i>
					</div>
				</div>
				<div class="collapse-content bg-dark text-white p-5 shadow">
					<div>
						<div class="p-4">
							<h3 class="mb-4">Loai san pham</h3>
							<div class="d-flex flex-wrap gap-4 cursor-pointer">
								<c:forEach var="child" items="${typeParent.children}">
									<div class="filter-item">
										<p class="p-3  m-0">
											${child.name} <span>${child.products.size()}</span>
										</p>
									</div>
								</c:forEach>
							</div>
						</div>
						<c:forEach var="child" items="${typeParent.purposes.entrySet()}">
							<c:set var="type" value="${child.getKey()}" />
							<c:set var="mapPurposeProduct" value="${child.getValue()}" />
							<div class="p-4">
								<h3 class="mb-4">${type.name}</h3>
								<div class="d-flex flex-wrap gap-4 cursor-pointer">
									<c:forEach var="purpose" items="${mapPurposeProduct}">
										<c:set var="key" value="${purpose.getKey()}" />
										<c:set var="value" value="${purpose.getValue()}" />
										<div class="filter-item">
											<p class="p-3  m-0">
												${key.name} <span>${value.size()}</span>
											</p>
										</div>
									</c:forEach>
								</div>
							</div>
						</c:forEach>
					</div>

					<div class="d-flex align-items-center p-4">
						<p class="fs-4 m-0">Dong san pham</p>
						<div class="dropdown w-50 ms-3 cursor-default">
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
								<c:forEach var="entry" items="${typeParent.brands.entrySet()}">
									<c:set var="brand" value="${entry.getKey()}" />
									<c:set var="listProduct" value="${entry.getValue()}" />
									<div class="dropdown-item dropdown-brand-item">
										${brand.name} <span>${listProduct.size()}</span>
									</div>
								</c:forEach>
							</div>
						</div>

					</div>
					<!-- button filter -->
					<div class="p-4 d-flex align-items-center justify-content-end">
						<button id="filter-remove-button">
							<span class="me-2">Xoa toan bo</span> <i
								class="fa-solid fa-xmark"></i>
						</button>
						<button id="filter-submit-button" class="collapse-btn">Xong</button>
					</div>
				</div>
			</div>
			<div class="container">
				<div class="row p-4">
					<c:if test="${products not empty }">
						<c:forEach var="product" items="${products}">
							<div class="col-3 hover-dark btn-link mb-4"
								data-href="${pageContext.request.contextPath}/views/home/descript.jsp?id=${product.id}">
								<div class="card border-0 text-center">
									<img
										src="https://www.lorealparisusa.com/-/media/project/loreal/brand-sites/oap/americas/us/products/makeup/lip-color/lipstick/les-nus-intense-lipstick-intensely-pigmented/nu-impertinent/les-nus-impertinent-173-071249421758-primary.png?rev=b599fdaa54c046b58c6f5f54041e78c5&w=200&hash=37DCDDDD3E18F314410CE9365B2CECAF1A136492"
										alt="" class="img-card-top img-300px">
									<div class="card-body">
										<h6 class="subtitle">${product.name}</h6>
										<h4 class="title">Cool Blonde Fade-Defying Shine
											Permanent Hair Color</h4>
									</div>
									<div class="card-footer border-0 bg-transparent">
										<p class="card-text">${product.price}</p>
										<div class="d-flex gap-1 justify-content-center">
											<span class="text-dark"><i class="fa-solid fa-star"></i></span>
											<span class="text-dark"><i class="fa-solid fa-star"></i></span>
											<span class="text-dark"><i class="fa-solid fa-star"></i></span>
											<span class="text-dark"><i class="fa-solid fa-star"></i></span>
											<span class="text-secondary"><i
												class="fa-solid fa-star"></i></span> <span class="ms-2">4/5</span>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:if>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
</body>

</html>