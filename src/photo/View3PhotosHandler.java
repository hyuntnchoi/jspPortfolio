package photo;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

//@WebServlet(urlPatterns ="/main") **잘안되서 web.xml에서 매핑
public class View3PhotosHandler extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ImageServlet2 imgServlet = new ImageServlet2();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		List<Photo> threePhotos = null;
		try {
			threePhotos = imgServlet.selectById();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("threePhotos", threePhotos);
		req.getRequestDispatcher("index.jsp").forward(req, res);
	}
}