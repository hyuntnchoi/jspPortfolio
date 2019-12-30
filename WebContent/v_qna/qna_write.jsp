<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>
	포트폴리오 - QnA
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	
	<div class="wrapper">
		<div class="header">
			<jsp:include page="../v_header/header.jsp" />
		</div>
		<div class="content">
			<form action="../write" method="post" id="qna_write">
				제목: <input type="text" name="title" />
				<br>
				내용: <textarea rows="15" cols="50" name="content" form="qna_write"></textarea>
				<input type="submit" value="작성 완료">
			</form>
			
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