<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Manage Attribute Value</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<h1 class="text-center">${attributeValue != null ? "Edit Attribute Value" : "Add New Attribute Value"}</h1>

		<!-- Form to Add/Edit Attribute Value -->
		<form action="${pageContext.request.contextPath}/admin/attribute-value"
			method="post" class="mt-4">
			<input type="hidden" name="id" value="${attributeValue!=null?attributeValue.id:-1}">

			<!-- Attribute Value -->
			<div class="mb-3">
				<label for="value" class="form-label">Attribute Value</label> <input
					type="text" id="value" name="value" class="form-control"
					placeholder="Enter Attribute Value"
					value="${attributeValue != null ? attributeValue.value : ''}"
					required>
			</div>

			<!-- Submit Button -->
			<div class="d-flex justify-content-end">
				<button type="submit" class="btn btn-primary">
					${attributeValue != null ? "Update" : "Add"}</button>
			</div>
		</form>

		<!-- Back to List -->
		<div class="mt-3 text-end">
			<a href="${pageContext.request.contextPath}/attribute-values"
				class="btn btn-secondary">Back to List</a>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
