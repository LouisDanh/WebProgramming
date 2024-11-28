<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Page</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/css/hiddenEye.css">

</head>
<body>
	<jsp:include page="/views/shares/header.jsp"></jsp:include>

	<main>
		<div class="container my-5 pt-5">
			<div class="row justify-content-center">
				<!-- Login part -->
				<div class="col-md-5 text-center">
					<h1 class="text-center">Log in</h1>
					<form id="loginForm" method="post" enctype="multipart/form-data">
						<!--  Email -->
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="email" name="email"
								placeholder="EMAIL" required> <label for="email">Enter your email address</label>
						</div>
						<!-- Password -->
						<div class="form-floating mb-3 position-relative">
							<input type="password" class="form-control" id="password"
								name="password" placeholder="Password"> <label
								for="password">Enter your password</label>
							<button type="button" id="toggle-password"
								class="btn position-absolute top-50 end-7 translate-middle-y p-0">
								<i class="bi-eye-slash"></i>
							</button>
						</div>
						<!--Forgot password -->
						<a
							href="${pageContext.request.contextPath}/views/login/forgotPass.jsp">Forgot
							password</a>
						<button type="submit" class="btn btn-dark mt-3 w-100"
							id="submitLoginForm">Log in</button>
					</form>
				</div>

				<!--  Register part -->
				<div class="col-md-5 text-center">
					<h1>Create an AP account</h1>
					<p>Your personal account enables you to check your products in
						and benefit from additional exclusive features.</p>
					<a class="btn btn-dark btn-block mt-3"
						href="${pageContext.request.contextPath}/views/login/register.jsp">Create
						an account</a>
				</div>
			</div>
		</div>
	</main>

	<!-- Horizontal line to separate footer -->
	<!--     <hr class="my-8">  -->

	<script
		src="${pageContext.request.contextPath}/resources/static/js/hiddenEye.js"
		type="text/javascript"></script>
	<%--     <jsp:include page="/views/shares/footer.jsp"></jsp:include> --%>

</body>
</html>
