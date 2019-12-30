package photo;

// ���� ȭ�鿡�� ���� 3���� �����ִ� ��� ����

import javax.servlet.http.HttpServlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.ResultSet;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class ImageServlet2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private String dbURL = "jdbc:mysql://localhost:3306/portfolio";
    private String dbUser = "pf_admin";
    private String dbPass = System.getenv("PORTFOLIO_PW");
	
    public List<Photo> selectById() throws SQLException, IOException {
		Statement stmt = null;
		ResultSet rs = null;
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		try(Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass)) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM photos ORDER BY photo_id DESC LIMIT 0, 3");
			
			List<Photo> threePhotos = new ArrayList<>();
			while(rs.next()) {
				threePhotos.add(convertPhoto(rs));
			}
			return threePhotos;
		} catch(SQLException ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
    
    private Photo convertPhoto(ResultSet rs) throws SQLException, IOException {
		return new Photo(
				rs.getString("content"),
				toStr(rs.getBlob("photo")),
				toDate(rs.getTimestamp("date")),
				toDate(rs.getTimestamp("date"))
		);
	}
	
	private String toStr(Blob blob) throws IOException, SQLException {
		try {
			InputStream inpStrm = blob.getBinaryStream();
			ByteArrayOutputStream outpStrm = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			
			while((bytesRead = inpStrm.read(buffer)) != -1) {
				outpStrm.write(buffer, 0, bytesRead);
			}
			
			byte[] imageBytes = outpStrm.toByteArray();
			String base64Image = Base64.getEncoder().encodeToString(imageBytes);
			
			return base64Image;
		} catch(SQLException | IOException ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	
	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
}