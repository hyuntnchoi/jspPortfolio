package qna;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class ArticleDAO {

	private String dbURL = "jdbc:mysql://localhost:3306/portfolio";
	private String dbUser = "pf_admin";
	private String dbPass = System.getenv("PORTFOLIO_PW");
	Connection conn = null;
	
	
	// ��ü �Խñ� ���� �������� �޼���	
	public int selectCount() throws SQLException {
		
		Statement stmt = null;
		ResultSet rs = null;
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				
		try (Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass)){
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from qanda");
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			if(stmt != null) try { stmt.close(); } catch(SQLException ex) {}
			if(rs != null) try { rs.close(); } catch(SQLException ex) {}
		}
	}
	
	// ���� �� �������� �޼���
	public List<Article> select(int startRow, int size) throws SQLException, IOException {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());

		try(Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass)) {
			pstmt = conn.prepareStatement("SELECT * FROM qanda ORDER BY article_no DESC LIMIT ?, ?");
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, size);
			rs = pstmt.executeQuery();
			List<Article> listArticle = new ArrayList<>();
			while(rs.next()) {
				listArticle.add(convertArticle(rs));
			}
			return listArticle;
		} catch(SQLException ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if(rs != null) try { rs.close(); } catch(SQLException ex) {}
		}
	}
	
	private Article convertArticle(ResultSet rs) throws SQLException {
		return new Article(
				rs.getInt("article_no"),
				rs.getString("title"),
				rs.getString("content"),
				toDate(rs.getTimestamp("date")),
				toDate(rs.getTimestamp("date")));
	}
	
	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
	
}
