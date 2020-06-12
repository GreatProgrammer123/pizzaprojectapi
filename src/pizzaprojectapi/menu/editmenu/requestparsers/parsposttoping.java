package pizzaprojectapi.menu.editmenu.requestparsers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import pizzaprojectapi.menu.datamodels.pizzatopping;
import pizzaprojectapi.util.requestparser.parsefromobject;
import pizzaprojectapi.util.requestparser.parseprimitivetypes;

public class parsposttoping extends parseprimitivetypes{

	public parsposttoping(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	
	
	public pizzatopping parsetoping() {
		try {
			return new pizzatopping(getInt("pizzatoppingid"), 
					URLDecoder.decode(getString("name"), "UTF-8" ),
					URLDecoder.decode(getString("description"), "UTF-8" ),getDouble("price"),getBoolean("notpizzaintegrated"),true);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
