package qna;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import qna.ArticleDAO;
import qna.Article;

public class ListArticleService {
	
	private String dbURL = "jdbc:mysql://localhost:3306/portfolio";
	private String dbUser = "pf_admin";
	private String dbPass = System.getenv("PORTFOLIO_PW");
	
	private ArticleDAO articleDao = new ArticleDAO();
	private int size = 10;
	
	public ArticlePage getArticlePage(int pageNum) throws IOException, SQLException {
		
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		try (Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass)) {
			int total = articleDao.selectCount();
			List<Article> article = articleDao.select((pageNum-1)*size, size);
			return new ArticlePage(total, pageNum, size, article);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
