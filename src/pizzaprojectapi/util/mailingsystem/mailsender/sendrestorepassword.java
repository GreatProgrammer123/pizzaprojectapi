package pizzaprojectapi.util.mailingsystem.mailsender;

import pizzaprojectapi.util.mailingsystem.mailconf.mailconf;

public class sendrestorepassword extends mailsender{

	public sendrestorepassword(mailconf mconf) {
		super(mconf);
		// TODO Auto-generated constructor stub
	}
	
	public boolean sendmail(String to,String npas) {
		StringBuilder sb = new StringBuilder("Twoje nowe has�o to: ");
		sb.append(npas);
		return sendmail(to,"Odzyskiwanie has�a pizzaproject",sb.toString());
	}

}
