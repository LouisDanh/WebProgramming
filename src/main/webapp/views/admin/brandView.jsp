<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Manage Brand Key</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<h1 class="text-center">${brand != null ? "Edit Brand" : "Add New Brand "}</h1>

		<form action="${pageContext.request.contextPath}/admin/brand"
			method="post" class="mt-4">
			<input type="hidden" name="id" value="${brand!=null?brand.id:-1}">
			<div class="mb-3">
				<label for="name" class="form-label">Brand Name</label> <input
					type="text" id="name" name="name" class="form-control"
					placeholder="Enter Brand Name"
					value="${brand != null ? brand.name : ''}" required>
			</div>
			<!-- Submit Button -->
			<div class="d-flex justify-content-end">
				<button type="submit" class="btn btn-primary">${brand != null ? "Update" : "Add"}</button>
			</div>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
