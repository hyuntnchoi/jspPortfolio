<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>포트폴리오 - 일상</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
	<link href="https://fonts.googleapis.com/css?family=East+Sea+Dokdo|Gugi|Kirang+Haerang|Noto+Serif+KR|Sunflower:300|Yeon+Sung&display=swap&subset=korean" rel="stylesheet">
</head>
<body>
	<div class="wrapper">
		<div class="header">
			<jsp:include page="../v_header/header.jsp" />
		</div>
		<div class="content">
			<c:forEach items="${allPhoto}" var="allPhoto">
				<div class="photolist">
					<div>
						<img src="data:image/jpg;base64, ${allPhoto.base64Image}" />
					</div>
					<div>
						<b>${allPhoto.date2}</b> ${allPhoto.content}
					</div>
					<div>
						
					</div>
					<div>
					
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="sidebar">
			<jsp:include page="../v_sidebar/sidebar.jsp" />
		</div>
		<div class="footer">
			<jsp:include page="../v_footer/email.jsp" />
		</div>
	</div>
</body>
</html>