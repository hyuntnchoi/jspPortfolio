package photo;

// class for uploading photos to db

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
 
@WebServlet("/uploadServlet")
// intended to upload file's size up to 16mb but only to 4mb, need to check
@MultipartConfig(maxFileSize = 16177215)
public class FileUploadDBServlet extends HttpServlet {
     
	private static final long serialVersionUID = 1L;
	
	// database connection settings
    private String dbURL = "jdbc:mysql://localhost:3306/portfolio";
    private String dbUser = "pf_admin";
    private String dbPass = System.getenv("PORTFOLIO_PW");
     
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	
    	request.setCharacterEncoding("UTF-8");
    	
        // gets values of text fields
        String content = request.getParameter("content");
        // gets timestamp ref val?
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        // input stream of the upload file
        InputStream inputStream = null; 
         
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("photo");
        if (filePart != null) {
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
                 
        Connection conn = null; // connection to the database
        String message = null;  // message will be sent back to client
         
        try {
            // connects to the database
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
 
            // constructs SQL statement
            String sql = "INSERT INTO photos (content, photo, date) values (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, content);
            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                statement.setBlob(2, inputStream);
            }
            statement.setTimestamp(3, timestamp);
 
            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
            }
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                // closes the database connection
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            // sets the message in request scope
            request.setAttribute("message", message);
            // forwards to the message page
            getServletContext().getRequestDispatcher("/v_photo/fileUploadSuccess.jsp").forward(request, response);
        }
    }
}