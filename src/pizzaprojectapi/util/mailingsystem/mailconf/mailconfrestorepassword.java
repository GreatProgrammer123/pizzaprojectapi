package pizzaprojectapi.util.mailingsystem.mailconf;

import java.util.Properties;

public class mailconfrestorepassword implements mailconf{
	private final String host = "smtp.gmail.com";
	private  Properties props = new Properties();
	public mailconfrestorepassword() {
		createprops();
	}
	
	@Override
	public String getusername() {
		// TODO Auto-generated method stub
		return "olejnik.nikodem@gmail.com";
	}

	@Override
	public String getpassword() {
		// TODO Auto-generated method stub
		return "BeeinghackerisgayAF";
	}

	@Override
	public String getfrom() {
		// TODO Auto-generated method stub
		return "olejnik.nikodem@gmail.com";
	}
	
	@Override
	public String gethost() {
		// TODO Auto-generated method stub
		return host;
	}

	@Override
	public Properties getproperties() {
		 return props; 
	}

    private void createprops() {
    	 
    	  props.put("mail.smtp.host", host);
    	  props.put("mail.smtp.port", "587");
    	  props.put("mail.smtp.auth", "true");
    	  props.put("mail.smtp.starttls.enable", "true");
    }
   


	
}
