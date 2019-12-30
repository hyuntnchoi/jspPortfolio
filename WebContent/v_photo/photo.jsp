<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.bxslider.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  	<script src="${pageContext.request.contextPath}/js/jquery.bxslider.min.js"></script>
	
	<script>
	    $(document).ready(function(){
	      $('.slider').bxSlider({
	    	  auto:true,
	    	  pause:1250,
	    	  autoHover:true,
	    	  autoControls:true,
	    	  autoControlsCombine:true,
	    	  mode:'fade',
	    	  slideWidth:640
	      });
	    });
  	</script>
</head>
<body>
	<div class="content_top">
		<div>
			<p>일상 생활</p>
		</div>
		<div>
			<a href="/portfolio/viewmorephotos">
				<img src="${pageContext.request.contextPath}/css/images/icon_more.png" alt="more" width="38" height="38">
			</a>
		</div>
	</div>
	
	<div class="slider">
		<c:forEach items="${threePhotos}" var="threePhotos">
		<div>
			<div>
				<img src="data:image/jpg;base64, ${threePhotos.base64Image}" height="300" />
			</div>
			<div class="text">
				<b>${threePhotos.date1}</b>	${threePhotos.content}
			</div>
		</div>
		</c:forEach>
	</div>
</body>
</html>