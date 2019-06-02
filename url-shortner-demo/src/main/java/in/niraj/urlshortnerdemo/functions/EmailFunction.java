package in.niraj.urlshortnerdemo.functions;

import in.niraj.urlshortnerdemo.functiontypes.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component("email")
public class EmailFunction implements Function<EmailDetails, Boolean>{
	@Autowired
	private MailSender mailSender;
	
	@Override
	public Boolean apply(EmailDetails emailDetails) {
		
		SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailDetails.getFromEmailAddress());
        message.setTo(emailDetails.getToEmailAddress());
        message.setSubject(emailDetails.getSubject());
        
        StringBuilder emailBody = new StringBuilder();
        emailBody.append("Hi,\n\nYou have successfully created a short code based on this URL: ")
        .append(emailDetails.getLongURL()).append("\n")
        .append("Your short code is: ")
        .append(emailDetails.getShortCode()).append("\n\n")
        .append("Thank you\n")
        .append("Niraj");
        message.setText(emailBody.toString());
        
        try {
        	mailSender.send(message);
        	
        	return true;
        } catch (MailException e) {
        	// Handle this properly
        	System.out.println(e);
        	return false;
        }
	}
}
