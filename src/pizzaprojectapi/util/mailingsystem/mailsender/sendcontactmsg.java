package pizzaprojectapi.util.mailingsystem.mailsender;

import pizzaprojectapi.other.contactmsg;
import pizzaprojectapi.util.mailingsystem.mailconf.mailconf;

public class sendcontactmsg  extends mailsender{

	public sendcontactmsg(mailconf mconf) {
		super(mconf);
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean sendcontactmsg(contactmsg msg) {
		StringBuilder sb = new StringBuilder("");
		sb.append("pytanie: ")
		.append(msg.title)
		.append(" treœæ ")
		.append(msg.content)
		.append("adres e-mail: ")
		.append(msg.email)
		.append("numer telefonu: ")
		.append(msg.phonenumber);
		
		return sendmail("olejnik.nikodem@gmail.com","Zapytanie z formularze",sb.toString());
	}

}
