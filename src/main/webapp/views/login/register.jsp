<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Create an AP Account</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/css/hiddenEye.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/css/btn.css">
</head>

<body>
	<jsp:include page="/views/shares/header.jsp"></jsp:include>
	<main>
		<div class="container mt-5">
			<div class="row justify-content-center">
				<div class="col-md-8 col-lg-6">
					<div class="card shadow-sm">
						<div class="card-body">
							<h2 class="text-center mb-4">Create an AP Account</h2>
							<p class="text-center mb-4">Create an account to access
								exclusive features and check your products in.</p>
							<!-- Account Registration Form -->
							<form id="registerForm" action="/WebMyPham/LoginServlet"
								method="Post" accept-charset="UTF-8">
								<div class="mb-3">
									<label for="fullName" class="form-label">Full Name</label> <input
										type="text" class="form-control" id="fullName" name="fullName"
										placeholder="Enter your full name" required>
								</div>
								<div class="mb-3">
									<label for="phone" class="form-label">Phone number</label> <input
										type="tel" class="form-control" id="phone" name="phone"
										pattern="[0-9]{10,15}"
										title="Please enter a valid phone number (10 to 15 digits)"
										placeholder="Enter your phone number" required>
								</div>
								<div class="mb-3">
									<label for="email" class="form-label">Email</label> <input
										type="email" class="form-control" id="email" name="email"
										placeholder="Enter your email address" required>
									<c:if test="${ not empty emailError }">
										<p class="text-danger d-none">${emailError}/p>
									</c:if>
								</div>
								<!-- Password and Confirm Password -->
								<div class="row mb-3">
									<div class="col-md-6">
										<label for="password" class="form-label">Create a
											Password</label>
										<div class="input-group">
											<input type="password" class="form-control" id="password"
												placeholder="Enter your password" name="password" required>
											<button id="toggle-password"
												class=" position-absolute top-50 end-5 translate-middle-y p-0">
												<i class="bi-eye-slash"></i>
											</button>
										</div>
									</div>
									<div class="col-md-6">
										<label for="confirmPassword" class="form-label">Confirm
											Password</label>
										<div class="input-group">
											<input type="password" class="form-control"
												id="confirmPassword" placeholder="Confirm your password"
												required>
											<button id="toggle-password" type="button"
												class=" position-absolute top-50 end-5 translate-middle-y p-0">
												<i class="bi-eye-slash"></i>
											</button>
										</div>
									</div>
									<p class="text-danger d-none" id="text-error-pass">Password
										and Confirm Password do not match!</p>
								</div>

								<!-- Privacy Policy -->
								<div class="form-check mb-3">
									<input class="form-check-input" type="checkbox"
										id="privacyCheck" required> <label
										class="form-check-label" for="privacyCheck"> I
										acknowledge that my personal data will be processed in
										accordance with Hishaku Privacy Notice. </label>
								</div>
								<!-- Submit Button -->
								<button type="submit" class="btn btn-dark w-100" name="action"
									value="create">Create an Account</button>
							</form>

							<!-- Login Link -->
							<p class="text-center mt-3">
								Already have an account? <a
									href="${pageContext.request.contextPath}/views/login/login.jsp">Log
									in</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<script
		src="${pageContext.request.contextPath}/resources/static/js/hiddenEye.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		$(function() {
			$('input[name="action"]').on('submit', function() {
				const password = $("#password").val();
				const confirmPassword = $("#confirmPassword").val();
				if (password !== confirmPassword) {
					$('#text-error-pass').removeClass('d-none');
					event.preventDefault();
				} else
					$('#text-error-pass').addClass('d-none');
			})
		})
	</script>
</body>

</html>
