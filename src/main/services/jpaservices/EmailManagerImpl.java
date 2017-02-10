package main.services.jpaservices;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import main.modelpojos.Idea;
import main.services.serviceinterfaces.EmailManager;

/**
 * Created by Armando on 11/23/2016.
 */
@Component
public class EmailManagerImpl implements EmailManager {
	
	@Value("${spring.mail.username}")
	private String username;
	@Value("${spring.mail.password}")
	private String password;
	@Value("${spring.mail.port}")
	private int port;

	public void verifyEmail(Idea idea){
		// String body = "You have sumbitted an idea to (website name here).
		// <br/> <a href=\"http://localhost:8080/ideas/" + idea.getId() + "/" +
		// idea.getVerificationLink() + "\">Click here to verify and display
		// your idea!</a>";
		// MimeMessage mailMessage = mailSender.createMimeMessage();
		// try {
		// mailMessage.addRecipients(Message.RecipientType.TO, idea.getEmail());
		// mailMessage.setFrom("sbuwebappclub@gmail.com");
		// mailMessage.setSubject("Verify your Idea");
		// mailMessage.setText(body, "UTF-8", "html");
		// mailMessage.setSentDate(new Date());
		// } catch (MessagingException e) {
		// e.printStackTrace();
		// }
		// Runnable run = () -> mailSender.send(mailMessage);
		// Thread thread = new Thread(run);
		// thread.setName("Email Sending To " + idea.getEmail());
		// thread.start();
		HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(port);
		email.setAuthenticator(new DefaultAuthenticator(username, password));
		email.setSSLOnConnect(true);
		try {
			email.setFrom("sbuwebappclub@gmail.com");
			email.setSubject("TestEmail");
			email.setMsg("Test Message from Armando Xhimanki. ");
			email.addTo(idea.getEmail());
			// image
			/*StringBuffer msg = new StringBuffer();
			msg.append("<html><body>");
			msg.append("<p>You have sumbitted an idea to (website name here).</p>");
			msg.append("<a href = http://localhost:8080/idea/").append(idea.getId()).append("/")
					.append(idea.getVerificationLink()).append(">");
			msg.append("Click here to verify your email").append("</a>");*/
			// email.setMsg(msg.toString());
			String url = "http://localhost:8080/idea/" + idea.getId() + "/" + idea.getVerificationLink() + "/";
			HashMap<String, String> mappings = new HashMap<String, String>();
			mappings.put("$url", url);
			String htmail = readTextFile(mappings);
			email.setHtmlMsg(htmail);
			email.setSubject("Validate your idea");
			// fallback
			email.setTextMsg("Your email client does not support html");
			Runnable run = () -> {
				try {
					email.send();
				} catch (EmailException e) {
					e.printStackTrace();
					
					e.getCause().toString();
				}
			};
			Thread thread = new Thread(run);
			thread.setName("Email Sending To " + idea.getEmail());
			thread.start();
		} catch (EmailException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Value(value = "classpath:templates/email_validation.html")
	private Resource emailHTMLResource;
	private String emailHtml;
	
	private String readTextFile(HashMap<String, String> mappings) throws IOException {
		Path path = Paths.get(emailHTMLResource.getURI());
		String s;
		if(emailHtml == null){
			s = "";
			try (Scanner scanner = new Scanner(path)) {
				while (scanner.hasNextLine()) {
					s += scanner.nextLine() + "\n";
				}
				scanner.close();
			}
			emailHtml = s;
		}else{
			s = emailHtml;
		}
		for(String keys : mappings.keySet()){
			s = s.replace(keys, mappings.get(keys));
		}
		return s;
	}
}