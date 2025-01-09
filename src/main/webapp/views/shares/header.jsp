<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link
	href="${pageContext.request.contextPath}/resources/static/css/header.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/static/css/category.css"
	rel="stylesheet">
<header>
	<div
		class="container d-flex justify-content-between align-items-center">
		<!-- Logo -->
		<div class="logo link ml-2"
			data-href="${pageContext.request.contextPath}/home">
			HISHAKU</div>
		<!-- Menu Navigation -->
		<nav class="navbar navbar-expand-lg navbar-light">
			<div class="navbar-nav">
				<c:forEach var="category" items="${categories}">
					<a class="nav-link"
						onclick="toggleSubCategory('${category.id}')">
						<strong>${category.name}</strong>
					</a>
				</c:forEach>
			</div>
		</nav>
		<!-- Tools Section -->
		<div class="d-flex justify-content-between align-items-center">
			<div id="headerContainer">
				<div id="hamburgerIcon">
					<i class="fas fa-bars"></i>
				</div>
				<div id="extraIcons" class="mt-2">
					<!-- Personal Profile Icon -->
					<div class="link" id="profileIcon"
						data-href="${pageContext.request.contextPath}/">
						<i class="fas fa-user"></i> Hồ sơ
					</div>
					<!-- Tìm kiếm Text (Search) -->
					<div class="link" id="profileIcon"
						data-href="${pageContext.request.contextPath}/views/home/listProductSearch.jsp">
						<i class="fas fa-search"></i> Tìm kiếm
					</div>
					<!-- Cart Icon -->
					<div class="link" id="profileIcon"
						data-href="${pageContext.request.contextPath}/views/home/cart.jsp">
						<i class="fas fa-shopping-cart"></i> Giỏ hàng
					</div>
					<!-- Logout Icon -->
					<div class="link" id="logoutIcon" id="profileIcon"
						data-href="${pageContext.request.contextPath}/login">
						<i class="fas fa-sign-out-alt"></i> Đăng xuất
					</div>
				</div>
			</div>
		</div>
	</div>
</header>
<div class="danhMuc cursor-pointer">
	<c:forEach var="category" items="${categories}">
		<div id="${category.id}" class="sub-category">
			<div class="d-flex row">
				<div class="col-1"></div>
				<div class="d-flex flex-column col-2">
					<c:forEach var="child" items="${category.children}">
						<div class="link"
							data-href="views/home/listProductCategory?idType=${child.id}">
							<h5>${child.name}</h5>
						</div>
						<br>
						<c:forEach var="subChild" items="${child.children}">
							<div class="link"
								data-href="views/home/listProductCategory?idType=${subChild.id}">
								<span>${subChild.name}</span>
							</div>
						</c:forEach>
					</c:forEach>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/static/js/category.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/static/js/hiddenTools.js"></script>