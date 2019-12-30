<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" 
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<header class="header_image">
	<div class="header_setting">
			<img src="${pageContext.request.contextPath}/css/images/icon_setting.jpg" id="mySetting" alt="setting" width="38" height="38">
	</div>
	<div class="header_home">
		<a href="${pageContext.request.contextPath}/main">
			<img src="${pageContext.request.contextPath}/css/images/icon_home.png" alt="home" width="38" height="38">
		</a>
	</div>
	
	<script>
		// 세팅 아이콘, 비밀번호 설정
		var img = document.getElementById("mySetting");
		img.onclick = function() {
			var pw1 = "160724"
			var pw2 = prompt("관리자 전용입니다.\n비밀번호를 입력해주세요.");
			if(pw1 == pw2) {
				window.location.href='${pageContext.request.contextPath}/admin.jsp';
			} else {
				alert("잘못된 비밀번호를 입력했습니다.")
			}
		}
	</script>
	
</header>

</body>
</html>