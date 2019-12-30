package comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.SQLException;

public class Comment extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");	

		String writer_c = request.getParameter("writer_c");
		String comment_content = request.getParameter("comment_content");
		String num = request.getParameter("num");
		
		// jdbc driver loading
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection conn = null;
		Statement stmt = null;
		
		try {
			String jdbcDriver = "jdbc:mysql://localhost:3306/portfolio?" +
					"useUnicode=true&characterEncoding=utf8";
			String dbUser = "pf_admin";
			String dbPass = System.getenv("PORTFOLIO_PW");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			stmt = conn.createStatement();

			// �����ϴ� preparedstatement�� ��ġ�� ���߿�.
			stmt.executeUpdate("insert into comment (comment_no, writer_c, comment_content, date) "
					+ "values ('"+num+"', '"+writer_c+"', '"+comment_content+"', '"+timestamp+"')");  
		} catch (SQLException ex) {
			ex.getMessage();
		} finally {
			if(stmt != null) try { stmt.close(); } catch(SQLException ex) {}
			if(conn != null) try { conn.close(); } catch(SQLException ex) {}
		}

		response.sendRedirect("v_qna/qna_content.jsp?no="+num+"");
	}
}