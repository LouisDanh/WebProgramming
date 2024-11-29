<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Forgot Password</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/css/btn.css">
</head>
<body>
	<jsp:include page="/views/shares/header.jsp"></jsp:include>

	<div class="container d-flex justify-content-center mt-5">
		<div class="card custom-card">
			<div class="card-body">
				<h5 class="card-title text-center mb-4">Forgot your password?</h5>
				<p class="card-text text-center mb-4">Enter the email address
					associated with your account and we will send you a link to reset
					your password.</p>

				<form action="#" method="POST">
					<div class="mb-3">
						<label for="email" class="form-label">Email</label> <input
							type="email" class="form-control" id="email"
							placeholder="Enter your email" required>
					</div>
					<button type="submit" class="btn btn-dark w-100">Reset my
						password</button>
				</form>
				<p class="text-center mt-3">I remember the password? <a
						href="${pageContext.request.contextPath}/views/login/login.jsp">Log
						in</a>
				</p>
			</div>
		</div>
	</div>


</body>
</html>
