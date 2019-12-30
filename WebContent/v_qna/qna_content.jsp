<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import = "java.sql.DriverManager" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "java.sql.Statement" %>
<%@ page import = "java.sql.ResultSet" %>
<%@ page import = "java.sql.SQLException" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ page import = "java.util.Date" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>포트폴리오</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

<% String PORTFOLIO_PW = System.getenv("PORTFOLIO_PW"); %>
	
	<div class="wrapper">
		<div class="header">
			<jsp:include page="../v_header/header.jsp" />
		</div>
		<div class="content">
			<%
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				
				String num = request.getParameter("no");
				
				try {
					String jdbcDriver = "jdbc:mysql://localhost:3306/portfolio?" +
										"useUnicode=true&characterEncoding=utf8";
					String dbUser = "pf_admin";
					String dbPass = PORTFOLIO_PW;
					String query = "select * from qanda where article_no='"+num+"'";
					
					conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
					stmt = conn.createStatement();
					rs = stmt.executeQuery(query);
			
					if(rs.next()) {
			%>			
						<div class="qna_content">
							<div class="qna_title">
								<span>
									<%= rs.getString("title") %>
								</span>
								<span class="qna_date"> <!-- 시간표시, 스파게티.. 수정필 -->
									<% 	
										SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
										Date date = new Date(rs.getTimestamp("date").getTime());
										String date_f1 = sdFormat.format(date);
									%>
									<%= date_f1 %>
								</span>
							</div>
							<div class="qna_text">
								<%= rs.getString("content") %>
							</div>
							<div class="noName"> <!-- 이 부분 css를 위한 클래스는 해당 파일로. -->
								<jsp:include page="comment_list.jsp" />
							</div>
							<div class="noName">
								<jsp:include page="comment.jsp" />
							</div>
						</div>
			<%
					} else {
						
					}
				} finally {
					if(rs!=null) try {rs.close();} catch(SQLException ex) {}
					if(stmt!=null) try {stmt.close();} catch(SQLException ex) {}
					if(conn!=null) try {conn.close();} catch(SQLException ex) {}
				}
			%>
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