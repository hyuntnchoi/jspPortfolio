package email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendEmailTLS extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, 
	HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String username = System.getenv("PORTFOLIO_GMAIL_ID");
		String password = System.getenv("PORTFOLIO_GMAIL_PW");
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");   
		
		Session session = Session.getInstance(prop,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			}
		);
		
		try {
			String content = request.getParameter("message");
			String sender = request.getParameter("name");
			String email = request.getParameter("email");
			InternetAddress from = new InternetAddress(email, email);
			
			Message message = new MimeMessage(session);
			message.setFrom(from);
			message.setRecipients(
					Message.RecipientType.TO,
					InternetAddress.parse("hyuntn0724@gmail.com")
			);
			
			message.setSubject(sender + "님으로부터 메세지가 왔습니다.");
			message.setContent(content, "text/html; charset=utf-8");

			Transport.send(message);
			
			response.sendRedirect("/portfolio/main");
		} catch(MessagingException e) {
			e.printStackTrace();
		}
	}
}
