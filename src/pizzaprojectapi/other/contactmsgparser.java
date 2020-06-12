package pizzaprojectapi.other;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import pizzaprojectapi.util.requestparser.parseprimitivetypes;

public class contactmsgparser extends parseprimitivetypes{

	
	public contactmsgparser(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

	public contactmsg parsecontactmsg() {
		//URLDecoder.decode(getString("date"), "UTF-8" )
		try {
			return new contactmsg(URLDecoder.decode(getString("email"), "UTF-8" ), 
					URLDecoder.decode(getString("phonenumber"), "UTF-8" ),
					URLDecoder.decode(getString("title"), "UTF-8" ),
					URLDecoder.decode(getString("content"), "UTF-8" ));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
