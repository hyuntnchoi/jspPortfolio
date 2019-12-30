<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>포트폴리오 - QnA</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
	<link href="https://fonts.googleapis.com/css?family=East+Sea+Dokdo|Gugi|Kirang+Haerang|Noto+Serif+KR|Sunflower:300|Yeon+Sung&display=swap&subset=korean" rel="stylesheet">
</head>

<body>
	
	<div class="wrapper">
		<div class="header">
			<jsp:include page="../v_header/header.jsp" />
		</div>
		<div class="content">
			<table class="qna">
				<tr class="qna_columns">
					<th>번호</th>
					<th>제목</th>
					<th>날짜</th>
				</tr>
			<c:if test="${articlePage.hasNoArticles()}">
				<tr class="qna_bottom">
					<td colspan="2">
						게시글이 없습니다.
					</td>
					<td>
						<a href="/portfolio/v_qna/qna_write.jsp">[글쓰기]</a>
					</td>
				</tr>
			</c:if>
			<c:forEach var="article" items="${articlePage.article}">
				<tr>
					<td>${article.articleNo}</td>
					<td>
						<a href="${pageContext.request.contextPath}/v_qna/qna_content.jsp?no=${article.articleNo}&pageNo=${articlePage.currentPage}">
							<c:out value="${article.title}"/>
						</a>
					</td>
					<td>${article.date1}</td>
				</tr>
			</c:forEach>
			<c:if test="${articlePage.hasArticles()}">
				<tr class="qna_bottom">
					<td colspan="2">
						<c:if test="${articlePage.startPage > 5}">
						<a href="list?pageNo=${articlePage.startPage - 5}">[이전]</a>
						</c:if>
						<c:forEach var="pNo"
								begin="${articlePage.startPage}"
								end="${articlePage.endPage}">
							<a href="list?pageNo=${pNo}">[${pNo}]</a>
						</c:forEach>
						<c:if test="${articlePage.endPage < articlePage.totalPages}">
						<a href="${pageContext.request.contextPath}/list?pageNo=${articlePage.startPage + 5}">[다음]</a>
						</c:if>
					</td>
					<td>
						<a href="/portfolio/v_qna/qna_write.jsp">[글쓰기]</a>
					</td>
				</tr>
			</c:if>
			</table>
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