<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="baseLayout">
	<tiles:putAttribute name="titlePage" value="Forgot Password" />
	<tiles:putListAttribute name="pageCss">
		<tiles:addAttribute value="btn" />
	</tiles:putListAttribute>
	<tiles:putAttribute name="body">
		<div class="container d-flex justify-content-center mt-5">
			<div class="card custom-card">
				<div class="card-body">
					<h5 class="card-title text-center mb-4">Forgot your password?</h5>
					<p class="card-text text-center mb-4">Enter the email address
						associated with your account and we will send you a link to reset
						your password.</p>
					<form action="/WebMyPham/ForgotPasswordServlet" method="post">
						<div class="mb-3">
							<label for="email" class="form-label">Email</label> <input name="email" 
								type="email" class="form-control" id="email"
								placeholder="Enter your email" required>
						</div>
						<button type="submit" class="btn btn-dark w-100">Reset my
							password</button>
					</form>
					<p class="text-center mt-3">
						I remember the password? <a
							href="${pageContext.request.contextPath}/views/login/login.jsp">Log
							in</a>
					</p>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>

