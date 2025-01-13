<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Account</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<h1 class="text-center mb-4">Create New Account</h1>
		<form action="${pageContext.request.contextPath}/admin/account"
			method="post" class="p-4 shadow rounded">
			<div class="form-group mb-3">
				<label for="email">Email</label> <input type="email"
					class="form-control" id="email" name="email" required
					placeholder="Enter email">
			</div>
			<div class="form-group mb-3">
				<label for="password">Password</label> <input type="password"
					class="form-control" id="password" name="password" required
					placeholder="Enter password">
			</div>
			<div class="form-group mb-3">
				<label for="fullName">Full Name</label> <input type="text"
					class="form-control" id="fullName" name="fullName" required
					placeholder="Enter full name">
			</div>
			<div class="form-group mb-3">
				<label for="phone">Phone</label> <input type="text"
					class="form-control" id="phone" name="phone" required
					placeholder="Enter phone number">
			</div>
			<div class="form-group mb-3">
				<label for="role">Role</label> <select name="role" id="role"
					class="form-select">
					<option value="1">Administrator (Admin)</option>
					<option value="4">Order Manager</option>
					<option value="2">Account Manager</option>
					<option value="3">Product Manager</option>
					<option value="5" selected>Regular User</option>
				</select>
			</div>
			<button type="submit" class="btn btn-primary w-100">Create
				Account</button>
		</form>
	</div>
</body>
</html>
