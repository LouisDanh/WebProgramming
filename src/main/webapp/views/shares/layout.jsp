<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${titlePage}</title>
<jsp:include page="/views/shares/staticlib.jsp"></jsp:include>
<c:forEach var="css" items="${pageCss}">
	<link
		href="${pageContext.request.contextPath}/resources/static/css/${css}"
		rel="stylesheet">
</c:forEach>
</head>
<body>
	<c:if test="${containHeader}">
		<jsp:include page="/views/shares/header.jsp" />
	</c:if>
	<main>
		<c:choose>
			<c:when test="${not empty contentPage}">
				<jsp:include page="${contentPage}" />
			</c:when>
			<c:otherwise>
				<p>Content not found</p>
			</c:otherwise>
		</c:choose>
	</main>

	<c:if test="${containFooter}">
		<jsp:include page="/views/shares/footer.jsp" />
	</c:if>
	<c:forEach var="js" items="${pageJs}">
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/resources/static/js/${js}"></script>
	</c:forEach>
</body>
</html>