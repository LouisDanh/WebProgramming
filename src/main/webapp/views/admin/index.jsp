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
							<li class="tool" data-target="UserManagement"><i
								class="bi bi-person-circle"></i><span> User Management</span></li>
							<li class="tool" data-target="ProductManagement"><i
								class="bi bi-box"></i><span> Product Management</span></li>
							<li class="tool" data-target="BrandManagement"><i
								class="bi bi-map"></i><span> Brand Management</span></li>
							<li class="tool" data-target="VoucherManagement"><i
								class="bi bi-book"></i><span> Voucher Management</span></li>
							<li class="tool" data-target="PendingOrders"><i
								class="bi bi-heart"></i><span> Solving Order</span></li>
							<li class="tool" data-target="logout"><i
								class="bi bi-box-arrow-right"></i><span> Logout</span></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- Main Content Area -->
			<div class="col">
				<!-- User Management Section -->
				<div class="main" data-section="UserManagement" id="UserManagement">
					<h1 class="text-center">User Management</h1>
					<div class="container-fluid p-2">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th><input type="checkbox" id="select-all-users"></th>
									<th>Full Name</th>
									<th>Phone Number</th>
									<th>Email</th>
									<th>Ban Status</th>
									<th>Role</th>
									<th>Points</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tbody id="userTableBody">
								<c:forEach items="${users}" var="user">
									<tr>
										<td><input type="checkbox" class="user-select"></td>
										<td>${user.fullName}</td>
										<td>${user.phone}</td>
										<td>${user.email}</td>
										<td>${user.banned}</td>
										<td>${user.role}</td>
										<td>${user.points}</td>
										<td>
											<button class="btn btn-warning edit-user"
												data-id="${user.id}">
												<i class="bi bi-pencil"></i>
											</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

				<!-- Product Management Section -->
				<div class="main" data-section="ProductManagement" id="ProductManagement">
					<h1 class="text-center">Product Management</h1>
					<div class="container-fluid p-2">
						<div class="d-flex justify-content-end mb-3">
							<button class="btn btn-primary" id="addProductBtn">
								<i class="bi bi-plus"></i> Add Product
							</button>
						</div>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>ID</th>
									<th>Name</th>
									<th>Description</th>
									<th>Price</th>
									<th>Stock</th>
									<th>Image</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tbody id="productTableBody">
								<c:forEach items="${products}" var="product">
									<tr>
										<td>${product.id}</td>
										<td>${product.name}</td>
										<td>${product.description}</td>
										<td>${product.price}</td>
										<td>${product.stock}</td>
										<td><img src="${product.imageUrl}" alt="${product.name}"
											style="width: 50px; height: 50px;"></td>
										<td>
											<button class="btn btn-warning edit-product"
												data-id="${product.id}">
												<i class="bi bi-pencil"></i>
											</button>
											<button class="btn btn-danger delete-product"
												data-id="${product.id}">
												<i class="bi bi-trash"></i>
											</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

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
				<div class="main" data-section="VoucherManagement" id="VoucherManagement">
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
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/static/js/adminscript.js"></script>
</body>
</html>