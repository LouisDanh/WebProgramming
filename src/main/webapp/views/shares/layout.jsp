<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><tiles:getAsString name="titlePage" /></title>
<jsp:include page="/views/shares/staticlib.jsp"></jsp:include>
<!-- Css -->
<tiles:useAttribute id="cssFiles" name="pageCss"
	classname="java.util.List" />
<c:forEach var="css" items="${cssFiles}">
	<link
		href="${pageContext.request.contextPath}/resources/static/css/${css}.css"
		rel="stylesheet">
</c:forEach>
</head>
<body>
	<tiles:insertAttribute name="header" />
	<main>
		<tiles:insertAttribute name="body" />
	</main>
	<tiles:insertAttribute name="footer" />
	<!-- Js -->

	<tiles:useAttribute id="jsFiles" name="pageJs"
		classname="java.util.List" />
	<c:forEach var="js" items="${jsFiles}">
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/resources/static/js/${js}.js"></script>
	</c:forEach>

	<tiles:useAttribute id="jsAjaxFiles" name="pageAjax"
		classname="java.util.List" />
	<c:forEach var="js_ajax" items="${jsAjaxFiles}">
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/resources/static/js_ajax/${js_ajax}.js"></script>
	</c:forEach>
</body>
</html>