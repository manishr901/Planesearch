package com.cgi.learning.sendmail;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMailTLS {
	private static final Logger log = Logger.getLogger(SendMailTLS.class.getName());
	public void sendMail(String email,String user_password,String name) {

		final String username = "manishr901@gmail.com";
		final String password = "Manish_13101994";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

		
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("manishr901@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			message.setSubject("your password");
			message.setText("Dear "+ name +","
				+ "your password is "+ user_password +"");

		
			Transport.send(message);
			
		log.log(Level.INFO,"forget password email sent for "+email);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}

}