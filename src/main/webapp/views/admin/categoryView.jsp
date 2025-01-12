<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${param.id != null ? "Edit" : "Add"}Category</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-4">
		<h1 class="text-center">${param.id != null ? "Edit" : "Add"}
			Category</h1>
		<form action="${pageContext.request.contextPath}/admin/category" method="post" class="p-4 shadow rounded">
			<input type="hidden" name="id"
				value="${category!=null?category.id:-1}">
			<div class="form-group mb-3">
				<label for="name">Category Name</label> <input type="text"
					class="form-control" id="name" name="name"
					value="${category != null ? category.name : ''}" required>
			</div>

			<div class="form-group mb-3">
				<label for="description">Description</label>
				<textarea class="form-control" id="description" name="description">${category != null ? category.description : ''}</textarea>
			</div>

			<div class="form-group mb-3">
				<label for="parent">Parent Category (Optional)</label> <select
					class="form-control" id="parent" name="parentId">
					<option value="">-- No Parent Category --</option>
					<c:forEach var="parentCategory" items="${categories}">
						<option value="${parentCategory.id}"
							<c:if test="${category != null && category.parent != null && category.parent.id == parentCategory.id}">
                                    selected
                                </c:if>>
							${parentCategory.name}</option>
					</c:forEach>
				</select>
			</div>

			<button type="submit" class="btn btn-primary w-100">${param.id != null ? "Update" : "Add"}</button>
		</form>
	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</html>
