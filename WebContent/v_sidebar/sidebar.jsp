<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
	<link href="https://fonts.googleapis.com/css?family=East+Sea+Dokdo|Gugi|Kirang+Haerang|Noto+Serif+KR|Sunflower:300|Yeon+Sung&display=swap&subset=korean" rel="stylesheet">	
</head>

<body>

<div class="sidebar_wrapper">
	<div id="resume">
		<jsp:include page="resume.jsp" />
	</div>
	<div id="chat">
		<jsp:include page="chat.html" />
	</div>
</div>		
</body>
</html>