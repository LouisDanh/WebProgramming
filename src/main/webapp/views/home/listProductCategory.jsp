<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:insertDefinition name="baseLayout">
	<tiles:putAttribute name="titlePage" value="Product Category" />
	<tiles:putListAttribute name="pageCss">
		<tiles:addAttribute value="list_product_category" />
	</tiles:putListAttribute>
	<tiles:putListAttribute name="pageJs">
		<tiles:addAttribute value="filter_category" />
		<tiles:addAttribute value="collapse" />
	</tiles:putListAttribute>
	<tiles:putAttribute name="body">
		<div class="container-fluid">
			<div class="p-5 w-100 h-50"></div>
			<div class="container text-center">
				<h2 class="title-category">${filter.category.name}</h2>
				<p class="fs-15rem fw-light">${filter.category.description}</p>
			</div>
			<div class="py-5 w-75 m-auto h-50">
				<div
					class="d-flex justify-content-between align-items-center shadow fs-4 fw-bold collapse-btn">
					<p class="p-4 m-0">
						<span class="quantiy-product" data-target="main">(${filter.totalQuantity})</span>
						Kết quả
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
								<c:forEach var="child" items="${filter.childrenCategory}">
									<div
										class="filter-item filter-category ${child.id==filter.category.id?'filter-item__active':''}"
										data-id="${child.id}" data-target="category">
										<p class="p-3  m-0">${child.name}</p>
									</div>
								</c:forEach>
							</div>
						</div>
						<c:forEach var="entry" items="${mappingAttributes.entrySet()}">
							<c:set var="key" value="${entry.key}" />
							<c:set var="mapValue" value="${entry.value}" />
							<div class="p-4">
								<h3 class="mb-4">${key.name}</h3>
								<div class="d-flex flex-wrap gap-4 cursor-pointer">
									<c:forEach var="entryAttribute" items="${mapValue.entrySet()}">
										<c:set var="attribute" value="${entryAttribute.key}" />
										<div
											class="filter-item ${filter.isAttributeSelected(attribute.id)?'filter-item__active':''}"
											data-id="${attribute.id}" data-target="attributes">
											<p class="p-3  m-0">${attribute.value}
												<span>(${filter.getQuantity(key.id,attribute.id)})</span>
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
									<span class="me-2">Brand</span> <span id="dropdown-text-brand">${filter.brandSelected!=null?filter.brandSelected.name:''}</span>
								</div>
							</div>
							<div
								class="dropdown-menu w-100 shadow-lg fs-5 p-0 border-radius-1">
								<div
									class="dropdown-item disabled text-muted dropdown-brand-item">
									Brand</div>
								<c:forEach var="brand" items="${filter.brands}">
									<div class="dropdown-item dropdown-brand-item"
										data-id="${brand.id}">${brand.name}</div>
								</c:forEach>
							</div>
						</div>
					</div>
					<!-- button filter -->
					<form action="category" method="post">
						<div class="p-4 d-flex align-items-center justify-content-end">
							<button id="filter-remove-button" class="link" type="button"
								data-href="${pageContext.request.contextPath}/home/product/category">
								<span class="me-2">Xoa toan bo</span> <i
									class="fa-solid fa-xmark"></i>
							</button>
							<button id="filter-submit-button" type="submit"
								class="collapse-btn">Xong</button>
						</div>
						<input type="hidden" name="brandId"> <input type="hidden"
							name="categoryId" value="${filter.category.id}"> <input
							type="hidden" name="attributesId" value="${filter.attributesSelected}">
					</form>
				</div>
			</div>
			<div class="container">
				<div class="row p-4">
					<c:if test="${ not empty  filter.products}">
						<c:forEach var="product" items="${filter.products}">
							<div class="col-3 hover-dark link mb-4"
								data-href="${pageContext.request.contextPath}/home/product/descript?id=${product.id}">
								<div class="card border-0 text-center">
									<img
										src="${pageContext.request.contextPath}${product.galleries[0].link}"
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