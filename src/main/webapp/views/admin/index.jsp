<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/css/adminstyle.css" />
<jsp:include page="/views/shares/staticlib.jsp"></jsp:include>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<!-- Sidebar -->
			<div class="col-2">
				<div class="container body-card mt-4">
					<div class="mb-4 text-center">
						<h2>ADMIN PAGE</h2>
					</div>
					<div class="text-center">
						<ul class="new-list">
							<li class="tool" data-target="dashboard"><i
								class="bi bi-house-door"></i><span> Dashboard</span></li>
							<c:if test="${sessionScope.role==1||sessionScope.role==2}">
								<li class="tool" data-target="AccountManagement"><i
									class="bi bi-person-circle"></i><span> Account
										Management</span></li>
							</c:if>
							<c:if test="${sessionScope.role==1||sessionScope.role==3}">
								<li class="tool" data-target="ProductManagement"><i
									class="bi bi-box"></i><span> Product Management</span></li>
								<li class="tool" data-target="BrandManagement"><i
									class="bi bi-map"></i><span> Brand Management</span></li>
								<li class="tool" data-target="CategoryManagement"><i
									class="bi bi-map"></i><span> Category Management</span></li>
								<li class="tool" data-target="AttributeManagement"><i
									class="bi bi-map"></i><span> Attribute Management</span></li>
							</c:if>
							<c:if test="${sessionScope.role==1||sessionScope.role==4}">
								<li class="tool" data-target="VoucherManagement"><i
									class="bi bi-book"></i><span> Voucher Management</span></li>
								<li class="tool" data-target="PendingOrders"><i
									class="bi bi-heart"></i><span> Solving Order</span></li>
							</c:if>
							<li class="tool link"
								data-href="${pageContext.request.contextPath}/login"><i
								class="bi bi-box-arrow-right"></i><span>Logout</span></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- Main Content Area -->
			<div class="col">
				<!-- User Management Section -->
				<c:if test="${sessionScope.role==1||sessionScope.role==2}">
					<div class="main" data-section="AccountManagement"
						id="AccountManagement">
						<h1 class="text-center">Account Management</h1>
						<div class="container-fluid p-2">
							<div class="d-flex justify-content-end mb-3">
								<button class="btn btn-primary link"
									data-href="${pageContext.request.contextPath}/views/admin/accountView.jsp">
									<i class="bi bi-plus"></i> Add Account
								</button>
							</div>
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>Full Name</th>
										<th>Phone Number</th>
										<th>Email</th>
										<th>Ban Status</th>
										<th>Role</th>
									</tr>
								</thead>
								<tbody id="userTableBody">
									<c:forEach items="${accounts}" var="acc">
										<tr>
											<td>${acc.customer.fullName}</td>
											<td>${acc.customer.phone}</td>
											<td>${acc.email}</td>
											<td><input type="checkbox" class="ban-checkbox link"
												${acc.ban ? 'checked' : ''}
												data-href="${pageContext.request.contextPath}/admin/account?id=${acc.id}&ban=${acc.ban ? 'false' : 'true'}"></td>
											<td>${acc.role}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</c:if>
				<c:if test="${sessionScope.role==1||sessionScope.role==3}">
					<!-- Product Management Section -->
					<div class="main" data-section="ProductManagement"
						id="ProductManagement">
						<h1 class="text-center">Product Management</h1>
						<div class="container-fluid p-2">
							<div class="d-flex justify-content-end mb-3">
								<button class="btn btn-primary link"
									data-href="${pageContext.request.contextPath}/admin/product">
									<i class="bi bi-plus"></i> Add Product
								</button>
							</div>
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>Name</th>
										<th>Price</th>
										<th>Stock</th>
										<th>Image</th>
										<th>Actions</th>
									</tr>
								</thead>
								<tbody id="productTableBody">
									<c:forEach items="${products}" var="product">
										<tr>
											<td>${product.name}</td>
											<td>${product.price}</td>
											<td>${product.stock}</td>
											<td><img src="${product.galleries.get(0).link}"
												alt="${product.name}" style="width: 50px; height: 50px;"></td>
											<td>
												<button class="btn btn-warning edit-product link"
													data-href="${pageContext.request.contextPath}/admin/product?id=${product.id}">
													<i class="bi bi-pencil"></i>
												</button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<!-- Brand Management Section -->
					<div class="main" data-section="BrandManagement"
						id="BrandManagement">
						<h1 class="text-center">Brand Management</h1>
						<div class="container-fluid p-2">
							<div class="d-flex justify-content-end mb-3">
								<button class="btn btn-primary link"
									data-href="${pageContext.request.contextPath}/admin/brand">
									<i class="bi bi-plus"></i> Add Brand
								</button>
							</div>
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>Name</th>
										<th>Actions</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${brands}" var="brand">
										<tr>
											<td>${brand.name}</td>
											<td>
												<button class="btn btn-warning edit-product link"
													data-href="${pageContext.request.contextPath}/admin/brand?id=${brand.id}">
													<i class="bi bi-pencil"></i>
												</button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<!-- Category Management Section -->
					<div class="main" data-section="CategoryManagement"
						id="CategoryManagement">
						<h1 class="text-center mb-4">Category Management</h1>
						<div class="container">
							<div class="d-flex justify-content-end mb-3">
								<button class="btn btn-primary link"
									data-href="${pageContext.request.contextPath}/admin/category">
									<i class="bi bi-plus"></i> Add New Category
								</button>
							</div>
							<!-- Category Accordion -->
							<div class="accordion category-accordion" id="categoryAccordion">
								<c:forEach var="category" items="${categories}">
									<c:if test="${category.parent == null}">
										<div class="accordion-item border rounded-3 mb-3">
											<h2 class="accordion-header" id="heading${category.id}">
												<button class="accordion-button collapsed" type="button"
													data-bs-toggle="collapse"
													data-bs-target="#collapse${category.id}"
													aria-expanded="false"
													aria-controls="collapse${category.id}">
													<span class="category-name">${category.name}</span>
												</button>
											</h2>
											<div id="collapse${category.id}"
												class="accordion-collapse collapse"
												aria-labelledby="heading${category.id}"
												data-bs-parent="#categoryAccordion">
												<div class="accordion-body">
													<!-- Parent Category Actions -->
													<div class="d-flex justify-content-end mb-4">
														<a
															href="${pageContext.request.contextPath}/admin/category?id=${category.id}"
															class="edit-btn"> <i class="bi bi-pencil"></i> Edit
															Category
														</a>
													</div>
													<!-- Child Categories -->
													<div class="ps-4">
														<c:forEach var="child" items="${category.children}">
															<div
																class="child-category d-flex justify-content-between align-items-center">
																<span class="category-name"> <i
																	class="bi bi-chevron-right me-2 text-muted"></i>
																	${child.name}
																</span> <a
																	href="${pageContext.request.contextPath}/admin/category?id=${child.id}"
																	class="edit-btn"> <i class="bi bi-pencil"></i> Edit
																</a>
															</div>
														</c:forEach>
													</div>
												</div>
											</div>
										</div>
									</c:if>
								</c:forEach>
							</div>
						</div>
					</div>
					<!-- Attribute Management Section -->
					<div class="main" data-section="AttributeManagement"
						id="AttributeManagement">
						<h1 class="text-center">Attribute Management</h1>
						<div class="container-fluid p-2">
							<div class="d-flex justify-content-end mb-3">
								<button class="btn btn-primary link me-3"
									data-href="${pageContext.request.contextPath}/admin/attribute-key">
									<i class="bi bi-plus"></i> Add Attribute Key
								</button>
								<button class="btn btn-primary link"
									data-href="${pageContext.request.contextPath}/admin/attribute-value">
									<i class="bi bi-plus"></i> Add Attribute Value
								</button>
							</div>
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>Name</th>
										<th>Edit</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${attributes}" var="attribute">
										<tr>
											<td><strong>Key:</strong> ${attribute.key.name}</td>
											<td>
												<button class="btn btn-warning edit-product link"
													data-href="${pageContext.request.contextPath}/admin/attribute-key?id=${attribute.key.id}">
													<i class="bi bi-pencil"></i>
												</button>
											</td>
										</tr>
										<c:forEach var="attributeValue" items="${attribute.value}">
											<tr>
												<td>${attributeValue.value}</td>
												<td><button class="btn btn-warning edit-product link"
														data-href="${pageContext.request.contextPath}/admin/attribute-value?id=${attributeValue.id}">
														<i class="bi bi-pencil"></i>
													</button></td>
											</tr>
										</c:forEach>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</c:if>
				<c:if test="${sessionScope.role==1||sessionScope.role==4}">
					<!-- Order Management Section -->
					<div class="main" data-section="PendingOrders" id="PendingOrders">
						<h1 class="text-center">Pending Orders</h1>
						<div class="container-fluid p-2">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>Order ID</th>
										<th>Customer</th>
										<th>Email</th>
										<th>Products</th>
										<th>Total Amount</th>
										<th>Order Date</th>
										<th>Actions</th>
									</tr>
								</thead>
								<tbody id="orderTableBody">
									<c:forEach items="${orders}" var="order">
										<tr>
											<td>${order.orderId}</td>
											<td>${order.customerName}</td>
											<td>${order.customerEmail}</td>
											<td>
												<button class="btn btn-primary btn-sm view-items-btn"
													data-id="${order.orderId}">View Items
													(${order.itemCount})</button>
											</td>
											<td>${order.totalAmount}</td>
											<td>${order.orderDate}</td>
											<td>
												<button class="btn btn-success confirm-order"
													data-id="${order.orderId}">
													<i class="bi bi-check-circle"></i>
												</button>
												<button class="btn btn-danger cancel-order"
													data-id="${order.orderId}">
													<i class="bi bi-x-circle"></i>
												</button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<!-- Voucher Management Section -->
					<div class="main" data-section="VoucherManagement"
						id="VoucherManagement">
						<h1 class="text-center">Voucher Management</h1>
						<div class="container-fluid p-2">
							<div class="d-flex justify-content-end mb-3">
								<button class="btn btn-primary" id="addVoucherBtn">
									<i class="bi bi-plus"></i> Add Voucher
								</button>
							</div>
							<table class="table table-bordered">
								<thead>
									<tr>
										<th><input type="checkbox" id="select-all-vouchers"></th>
										<th>ID</th>
										<th>Name</th>
										<th>Description</th>
										<th>Discount (%)</th>
										<th>Max Discount</th>
										<th>Actions</th>
									</tr>
								</thead>
								<tbody id="voucherTableBody">
									<c:forEach items="${vouchers}" var="voucher">
										<tr>
											<td><input type="checkbox" class="voucher-select"></td>
											<td>${voucher.id}</td>
											<td>${voucher.name}</td>
											<td>${voucher.description}</td>
											<td>${voucher.percentage}</td>
											<td>${voucher.maxDiscount}</td>
											<td>
												<button class="btn btn-danger delete-voucher"
													data-id="${voucher.id}">
													<i class="bi bi-trash"></i>
												</button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/static/js/adminscript.js"></script>
</body>
</html>