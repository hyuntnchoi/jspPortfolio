<%@ page language="java" contentType="text/html; charset=utf-8" %>

<%@ page import = "java.sql.DriverManager" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "java.sql.Statement" %>
<%@ page import = "java.sql.ResultSet" %>
<%@ page import = "java.sql.SQLException" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<% String PORTFOLIO_PW = System.getenv("PORTFOLIO_PW"); %>

<div class="content_top">
	<div>
		<p>무엇이든 물어보세요 (Q&amp;A)</p>
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/list?pageNo=1">
			<img src="${pageContext.request.contextPath}/css/images/icon_more.png" alt="more" width="38" height="38">
		</a>
	</div>
</div>

<%	Class.forName("com.mysql.jdbc.Driver");

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try {
		String jdbcDriver = "jdbc:mysql://localhost:3306/portfolio?" +
							"useUnicode=true&characterEncoding=utf8";
		String dbUser = "pf_admin";
		String dbPass = PORTFOLIO_PW;
		String query = "SELECT * FROM qanda ORDER BY article_no DESC LIMIT 0, 5";
		
		conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		stmt = conn.createStatement();
		
		rs = stmt.executeQuery(query);
%>

<div>
	<table class="qna">
		<thead>
			<tr class="qna_columns">
				<th scope="col">번호</th>
				<th scope="col">제목</th>
				<th scope="col">날짜</th>
			</tr>
		</thead>
		<tbody>
<%		while(rs.next()) {
			int num = rs.getInt("article_no");
			String numb = String.valueOf(num);
%>		
			<tr>
				<td scope="row"><%= rs.getInt("article_no") %></td>
				<td scope="row"><a href="${pageContext.request.contextPath}/v_qna/qna_content.jsp?no=<%= numb %>"><%= rs.getString("title") %></a></td>
				<td scope="row"><%= rs.getDate("date") %></td> <!-- 따로 변환안해줘도.. getTiemstamp 대신 getDate만 하니 yyyy-MM-dd로 나오네.. -->
			</tr>
<%
		}
	} finally {
		if(rs!=null) try {rs.close();} catch(SQLException ex) {}
		if(stmt!=null) try {stmt.close();} catch(SQLException ex) {}
		if(conn!=null) try {conn.close();} catch(SQLException ex) {}
	}
%>
		</tbody>
	</table>
</div>

</body>
</html>