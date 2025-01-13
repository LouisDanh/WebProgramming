<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Topic Detail Management</title>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.7.2/font/bootstrap-icons.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
		<!-- Topic Info Header -->
		<div class="row my-3">
			<div class="col">
				<h2>${topic.title}</h2>
				<p class="text-muted">${topic.description}</p>
			</div>
		</div>
		<!-- Categories Section -->
		<div class="row mb-4">
			<div class="col">
				<div class="card">
					<div
						class="card-header d-flex justify-content-between align-items-center">
						<h4 class="mb-0">Categories</h4>
						<button class="btn btn-primary btn-sm" data-bs-toggle="modal"
							data-bs-target="#addCategoryModal">
							<i class="bi bi-plus"></i> Add Category
						</button>
					</div>
					<div class="card-body">
						<c:forEach var="category" items="${topic.categories}">
							<div class="category-section mb-4">
								<!-- Category Header -->
								<div
									class="d-flex justify-content-between align-items-center border-bottom pb-2 mb-3">
									<h5>${category.name}</h5>
									<div class="btn-group">
										<button class="btn btn-warning btn-sm"
											onclick="editCategory(${category.id})">
											<i class="bi bi-pencil"></i>
										</button>
										<button class="btn btn-danger btn-sm"
											onclick="deleteCategory(${category.id})">
											<i class="bi bi-trash"></i>
										</button>
										<button class="btn btn-success btn-sm" data-bs-toggle="modal"
											data-bs-target="#addProductModal"
											data-category-id="${category.id}">
											<i class="bi bi-plus"></i> Add Product
										</button>
									</div>
								</div>
								<!-- Products Table -->
								<div class="table-responsive">
									<table class="table table-hover">
										<thead>
											<tr>
												<th>Product Name</th>
												<th>Price</th>
												<th>Actions</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="product"
												items="${topic.mappingProduct[category]}">
												<tr>
													<td>${product.productName}</td>
													<td>${product.productPrice}</td>
													<td>
														<div class="btn-group">
															<button class="btn btn-danger btn-sm"
																onclick="deleteProduct(${category.id}, ${product.productId})">
																<i class="bi bi-trash"></i>
															</button>
														</div>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>

		<!-- Add Category Modal -->
		<div class="modal fade" id="addCategoryModal" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Add Category to Topic</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
					</div>
					<form
						action="${pageContext.request.contextPath}/admin/topic/topic-detail?action=addCategory"
						method="POST">
						<div class="modal-body">
							<input type="hidden" name="topicId" value="${topic.id}">
							<div class="mb-3">
								<label class="form-label">Select Category</label> <select
									name="categoryId" class="form-select" required>
									<c:forEach var="category" items="${availableCategories}">
										<option value="${category.id}">${category.name}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Cancel</button>
							<button type="submit" class="btn btn-primary">Add
								Category</button>
						</div>
					</form>
				</div>
			</div>
		</div>

		<!-- Add Product Modal -->
		<div class="modal fade" id="addProductModal" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Add Product to Category</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
					</div>
					<form
						action="${pageContext.request.contextPath}/admin/topic-detail?action=addProduct"
						method="POST">
						<div class="modal-body">
							<input type="hidden" name="topicId" value="${topic.id}">
							<input type="hidden" name="categoryId" id="modalCategoryId">
							<div class="mb-3">
								<label class="form-label">Select Product</label> <select
									name="productId" class="form-select" required>
									<c:forEach var="product" items="${availableProducts}">
										<option class="product-option" value="${product.id}"
											data-target="${product.category.id}">${product.name}-
											$${product.price}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Cancel</button>
							<button type="submit" class="btn btn-primary">Add
								Product</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
	<script>
        // Set category ID when opening Add Product modal
        const addProductModal = document.getElementById('addProductModal');
        addProductModal.addEventListener('show.bs.modal', event => {
            const button = event.relatedTarget;
            const categoryId = button.getAttribute('data-category-id');
            document.getElementById('modalCategoryId').value = categoryId;
			})

        // Delete category function
        function deleteCategory(categoryId) {
            if (confirm('Are you sure you want to delete this category?')) {
                window.location.href = `${pageContext.request.contextPath}/admin/topic-category/delete?topicId=${topic.id}&categoryId=${categoryId}`;
            }
        }

        // Delete product function
        function deleteProduct(categoryId, productId) {
            if (confirm('Are you sure you want to remove this product?')) {
                window.location.href = `${pageContext.request.contextPath}/admin/topic-product/delete?topicId=${topic.id}&categoryId=${categoryId}&productId=${productId}`;
            }
        }

        // Edit category function
        function editCategory(categoryId) {
            window.location.href = `${pageContext.request.contextPath}/admin/topic-category/edit?topicId=${topic.id}&categoryId=${categoryId}`;
        }
    </script>
</body>
</html>