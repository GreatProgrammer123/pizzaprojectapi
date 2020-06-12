package pizzaprojectapi.util.mailingsystem.mailsender;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import pizzaprojectapi.util.mailingsystem.mailconf.mailconf;

public class mailsender {
private mailconf mailcnf;

public mailsender(mailconf mconf) {
	super();
	this.mailcnf = mconf;
}


public boolean sendmail(String to,String title,String msg) {
	 Session session = Session.getInstance(mailcnf.getproperties(),
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(mailcnf.getusername(), mailcnf.getpassword());
		   }
	         });

	      try {
		   Message message = new MimeMessage(session);
		   message.setFrom(new InternetAddress(mailcnf.getfrom()));
		   message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
		   message.setSubject(title);
		   message.setText(msg);
		   Transport.send(message);
          } catch (MessagingException e) {
        	  e.printStackTrace();
	        return false;
	      }
	return true;
}

}
