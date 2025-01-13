<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Manage Attribute Key</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<h1 class="text-center">${attributeKey != null ? "Edit Attribute Key" : "Add New Attribute Key"}</h1>

		<!-- Form to Add/Edit Attribute Key -->
		<form action="${pageContext.request.contextPath}/admin/attribute-key"
			method="post" class="mt-4">
			<input type="hidden" name="id"
				value="${attributeKey!=null?attributeKey.id:-1}">
			<!-- Attribute Key Name -->
			<div class="mb-3">
				<label for="name" class="form-label">Attribute Key Name</label> <input
					type="text" id="name" name="name" class="form-control"
					placeholder="Enter Attribute Key Name"
					value="${attributeKey != null ? attributeKey.name : ''}" required>
			</div>

			<!-- Submit Button -->
			<div class="d-flex justify-content-end">
				<button type="submit" class="btn btn-primary">
					${attributeKey != null ? "Update" : "Add"}</button>
			</div>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
