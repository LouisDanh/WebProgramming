<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setAttribute("pageCss", new String[] { "header", "category" });
request.setAttribute("pageJs", new String[] { "category", "hiddenTools" });
%>
<header>
	<div
		class="container d-flex justify-content-between align-items-center">
		<!-- Logo -->
		<div class="logo btn-link ml-2"
			data-href="${pageContext.request.contextPath}/views/home/home.jsp">
			HISHAKU</div>
		<!-- Menu Navigation -->
		<nav class="navbar navbar-expand-lg navbar-light">
			<div class="navbar-nav">
				<c:forEach var="type" items="${parentTypes}">
					<a class="nav-link" href="#"
						onclick="toggleSubCategory('${type.id}')"><strong>${type.name}</strong>
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
					<div class="btn-link" id="profileIcon"
						data-href="${pageContext.request.contextPath}/">
						<i class="fas fa-user"></i> Hồ sơ
					</div>
					<!-- Tìm kiếm Text (Search) -->
					<div class="btn-link" id="profileIcon"
						data-href="${pageContext.request.contextPath}/views/home/listProductSearch.jsp">
						<i class="fas fa-search"></i> Tìm kiếm
					</div>
					<!-- Cart Icon -->
					<div class="btn-link" id="profileIcon"
						data-href="${pageContext.request.contextPath}/views/home/cart.jsp">
						<i class="fas fa-shopping-cart"></i> Giỏ hàng
					</div>
					<!-- Logout Icon -->
					<div class="btn-link" id="logoutIcon" id="profileIcon"
						data-href="${pageContext.request.contextPath}/views/login/login.jsp">
						<i class="fas fa-sign-out-alt"></i> Đăng xuất
					</div>
				</div>
			</div>
		</div>
	</div>
</header>
<div class="danhMuc cursor-pointer">
	<c:forEach var="parentType" items="${parentTypes}">
		<div id="${parentType.id}" class="sub-category">
			<div class="d-flex row">
				<div class="col-1"></div>
				<div class="d-flex flex-column col-2">
					<c:forEach var="child" items="${parentType.child}">
						<div class="link"
							data-href="views/home/listProductCategory?idType=${subChild.id}">
							<h5>${child.name}</h5>
						</div>
						<br>
						<c:forEach var="subChild" items="${parentType}">
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