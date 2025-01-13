<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="baseLayout">
	<tiles:putAttribute name="titlePage" value="Login Page" />
	<tiles:putListAttribute name="pageCss">
		<tiles:addAttribute value="hiddenEye" />
		<tiles:addAttribute value="btn" />
	</tiles:putListAttribute>
	<tiles:putListAttribute name="pageJs">
		<tiles:addAttribute value="hiddenEye" />
	</tiles:putListAttribute>
	<tiles:putAttribute name="body">
		<div class="container my-5 pt-5">
			<div class="row justify-content-center">
				<!-- Login part -->
				<div class="col-md-5 text-center">
					<h1 class="text-center">Log in</h1>
					<form id="loginForm" method="post" action="/WebMyPham/login">
						<!--  Email -->
						<div class="form-floating mb-3">
							<input type="email" class="form-control" id="email" name="email"
								placeholder="EMAIL" required><label for="email">Enter
								your email address</label>
						</div>
						<!-- Password -->
						<div class="form-floating mb-3 position-relative">
							<input type="password" class="form-control" id="password"
								name="password" placeholder="Password" required><label
								for="password">Enter your password</label>
							<button id="toggle-password" type="button"
								class="position-absolute top-50 end-7 translate-middle-y p-0">
								<i class="bi-eye-slash"></i>
							</button>
						</div>
						<!-- Error -->
						<c:if test="${not empty loginFail}">
							<p class="text-danger text-start">${loginFail}</p>
						</c:if>
						<!--Forgot password -->
						<a
							href="${pageContext.request.contextPath}/views/login/forgotPass.jsp">Forgot
							password</a> <input type="submit" class="btn btn-dark mt-3 w-100"
							id="submitLoginForm" name="action" value="Log in">
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
	</tiles:putAttribute>
</tiles:insertDefinition>
