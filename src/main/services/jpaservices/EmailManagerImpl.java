package main.services.jpaservices;

import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import main.modelpojos.Idea;
import main.services.serviceinterfaces.EmailManager;

/**
 * Created by Armando on 11/23/2016.
 */
@Service
public class EmailManagerImpl implements EmailManager{

    private JavaMailSender mailSender;

    @Autowired
    public void EmailVerificationManager(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    
    public void verifyEmail(Idea idea) throws MailException{
        String body = "You have sumbitted an idea to (website name here). <br/> <a href=\"http://localhost:8080/ideas/" + idea.getId() + "/" + idea.getVerificationLink() + "\">Click here to verify and display your idea!</a>";
        MimeMessage mailMessage = mailSender.createMimeMessage();
        try {
			mailMessage.addRecipients(Message.RecipientType.TO, idea.getEmail());
			mailMessage.setFrom("sbuwebappclub@gmail.com");
	        mailMessage.setSubject("Verify your Idea");
	        mailMessage.setText(body, "UTF-8", "html");
	        mailMessage.setSentDate(new Date());
		} catch (MessagingException e) {
			e.printStackTrace();
		}
        Runnable run = () -> mailSender.send(mailMessage);
        Thread thread = new Thread(run);
        thread.setName("Email Sending To " + idea.getEmail());
        thread.start();
    }
}
