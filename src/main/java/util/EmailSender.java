package util;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.*;

public class EmailSender {

	public EmailSender() {
		// TODO Auto-generated constructor stub
	}
	
	public static void sendWelcomeEmail(String toEmail, String plainPassword) {
        final String fromEmail = "md.rocks284@gmail.com";
        final String host = "smtp.gmail.com";
        final String password = "sqirwgaviexfgdkh"; // Use App Password if 2FA is enabled
//   app password -->    sqir wgav iexf gdkh
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Welcome to the Company");
            message.setText("Dear Employee,\n\nYour account has been created.\nEmail: " + toEmail + "\nPassword: " + plainPassword + "\n\nRegards,\nAdmin");

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
	
	
	
	
	

    public static void sendOtpEmail(String toEmail, String otp) {
        final String fromEmail = "md.rocks284@gmail.com";
        final String host = "smtp.gmail.com";
        final String password = "sqirwgaviexfgdkh"; // Your app password

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Password Reset OTP for Nexus HRMS");
            message.setText("Dear User,\n\nYour OTP for password reset is: " + otp + 
                            "\nThis OTP is valid for 10 minutes.\n\nRegards,\nNexus HRMS Team");

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }	
	
	
}

}
