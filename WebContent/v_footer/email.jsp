<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<p>EMAIL 문의</p>

<div class="email_container">
	<form action="/portfolio/contact" id="contact-form" method="post" role="form">
		<label for="name">성함</label>
		<input id="name" name="name" type="text" placeholder="성함" required="required"><br>
		
		<label for="email">이메일</label>
		<input id="email" name="email" type="text" placeholder="이메일" required="required"><br>
		
		<label for="message">메시지</label>
		<textarea id="message" name="message" placeholder="메시지를 입력해주세요" rows="3" required="required"></textarea><br>
		
		<input type="submit" value="전송">
	</form>
</div>

</body>
</html>