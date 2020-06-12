package pizzaprojectapi.util.mailingsystem.mailconf;

import java.util.Properties;

public interface mailconf {
	public	String getusername();
	public String getpassword();
	public String getfrom();
	public String gethost();
	public Properties getproperties();

}
