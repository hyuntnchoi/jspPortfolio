<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
	<link href="https://fonts.googleapis.com/css?family=East+Sea+Dokdo|Gugi|Kirang+Haerang|Noto+Serif+KR|Sunflower:300|Yeon+Sung&display=swap&subset=korean" rel="stylesheet">

	<title>관리자 페이지</title>
</head>
<body>

	<div class="wrapper">
		<div class="header">
			<jsp:include page="v_header/header.jsp" />
		</div>
		<div class="content">
			<div class="admin_header">
				<p style="font-size:35px;">관리자 페이지</p>
			</div>
	
			<div class="admin_main">
				<!-- 일상생활 사진 올리기 -->
				<jsp:include page="v_photo/photo_upload.jsp" />
			</div>
		</div>
		
	</div>
</body>
</html>