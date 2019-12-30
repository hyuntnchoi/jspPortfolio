<%@ page language="java" contentType="text/html; charset=utf-8" %>

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
</head>
<body>

<% String PORTFOLIO_PW = System.getenv("PORTFOLIO_PW"); %>

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
		String query = "select * from comment where comment_no='"+num+"'";
		
		conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(query);
		
		while(rs.next()) {
%>			
			<div class="qna_commentList">
				<span><b><%= rs.getString("writer_c") %></b></span>
				<span>
					<% 	
						SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
						Date date = new Date(rs.getTimestamp("date").getTime());
						String date_f1 = sdFormat.format(date);
					%>
					<%= date_f1 %>
				</span>
				<div><%= rs.getString("comment_content") %></div>
			</div>
<%
		}
	} finally {
		if(rs!=null) try {rs.close();} catch(SQLException ex) {}
		if(stmt!=null) try {stmt.close();} catch(SQLException ex) {}
		if(conn!=null) try {conn.close();} catch(SQLException ex) {}
	}
%>

</body>
</html>