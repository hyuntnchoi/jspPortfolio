package qna;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/list")
public class ListArticleHandler extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ListArticleService listService = new ListArticleService();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		ArticlePage articlePage = null;
		try {
			articlePage = listService.getArticlePage(pageNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("articlePage", articlePage);
		req.getRequestDispatcher("v_qna/qna_list.jsp").forward(req, res);
	}
	
}
