package qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.SQLException;

public class Write extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");	

		String title = request.getParameter("title");
		String content = request.getParameter("content");

		// jdbc driver loading
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String jdbcDriver = "jdbc:mysql://localhost:3306/portfolio?" +
					"useUnicode=true&characterEncoding=utf8";
			String dbUser = "pf_admin";
			String dbPass = System.getenv("PORTFOLIO_PW");
			
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			pstmt = conn.prepareStatement("insert into qanda (title, content, date) values (?,?,?)");
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setTimestamp(3, timestamp);
			
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.getMessage();
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if(conn != null) try { conn.close(); } catch(SQLException ex) {}
		}

		response.sendRedirect("/portfolio/main");
	}
}