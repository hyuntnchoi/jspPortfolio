package photo;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/viewmorephotos")
public class ViewMorePhotoHandler extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private PhotoDAO photoDao = new PhotoDAO();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		List<Photo> allPhoto = null;
		try {
			allPhoto = photoDao.select();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("allPhoto", allPhoto);
		req.getRequestDispatcher("v_photo/photo_list.jsp").forward(req, res);
	}
}
