<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${productViewModel.product != null ? 'Edit Product' : 'Create Product'}</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<h1 class="text-center mb-4">${productViewModel.product != null ? 'Edit Product' : 'Create New Product'}</h1>
		<form action="${pageContext.request.contextPath}/admin/product"
			method="post" class="p-4 shadow rounded"
			enctype="multipart/form-data">
			<input type="hidden" name="id"
				value="${productViewModel.product != null ? productViewModel.product.id : -1}">
			<div class="form-group mb-3">
				<label for="name">Name</label> <input type="text"
					class="form-control" id="name" name="name" required
					placeholder="Enter product name"
					value="${productViewModel.product != null ? productViewModel.product.name : ''}">
			</div>
			<div class="form-group mb-3">
				<label for="price">Price</label> <input type="text"
					class="form-control" id="price" name="price" required
					placeholder="Enter product price"
					value="${productViewModel.product != null ? productViewModel.product.price : ''}">
			</div>
			<div class="form-group mb-3">
				<label for="stock">Stock</label> <input type="number"
					class="form-control" id="stock" name="stock" required
					value="${productViewModel.product != null ? productViewModel.product.stock : ''}">
			</div>
			<div class="form-group mb-3">
				<label for="discount">Discount</label> <input type="number"
					class="form-control" id="discount" name="discount" required
					value="${productViewModel.product != null ? productViewModel.product.discount : ''}">
			</div>
			<div class="form-group mb-3">
				<label for="description">Description</label>
				<textarea class="form-control" id="description" name="description"
					required>${productViewModel.product != null ? productViewModel.product.description : ''}</textarea>
			</div>
			<div class="form-group mb-3">
				<label for="capacity">Capacity</label> <input type="number"
					class="form-control" id="capacity" name="capacity" required
					value="${productViewModel.product != null ? productViewModel.product.capacity : ''}" />
			</div>

			<div class="form-group mb-3">
				<label for="categoryId">Category</label> <select name="categoryId"
					id="categoryId" class="form-select">
					<c:forEach var="category" items="${productViewModel.categories}">
						<option value="${category.id}"
							${productViewModel.product != null && productViewModel.product.category.id == category.id ? 'selected' : ''}>
							${category.name}</option>
					</c:forEach>
				</select>
			</div>

			<div class="form-group mb-3">
				<label for="brandId">Brand</label> <select name="brandId"
					id="brandId" class="form-select">
					<option value="-1">Empty</option>
					<c:forEach var="brand" items="${productViewModel.brands}">
						<option value="${brand.id}"
							${productViewModel.product != null && productViewModel.product.brand.id == brand.id ? 'selected' : ''}>
							${brand.name}</option>
					</c:forEach>
				</select>
			</div>
			<c:forEach var="key" items="${productViewModel.attributeKeys}">
				<div class="form-group mb-3">
					<label for="_${key.id}">${key.name}</label> <select
						name="attributes" id="_${key.id}" class="form-select">
						<c:forEach var="attValue"
							items="${productViewModel.getAttributeValuesByKey(key)}">
							<option value="${key.id},${attValue.id}"
								${productViewModel.product != null && productViewModel.product.sameAttribute(key.id,attValue.id)? 'selected' : ''}>
								${attValue.value}</option>
						</c:forEach>
					</select>
				</div>
			</c:forEach>
			<div class="form-group mb-3">
				<label for="image">Upload Image</label> <input type="file"
					name="images" id="image" class="form-control" multiple>
			</div>
			<button type="submit" class="btn btn-primary w-100">
				${productViewModel.product != null ? 'Update Product' : 'Create Product'}
			</button>
		</form>
	</div>
</body>
</html>