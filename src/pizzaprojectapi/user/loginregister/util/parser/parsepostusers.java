package pizzaprojectapi.user.loginregister.util.parser;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import pizzaprojectapi.user.datamodels.address;
import pizzaprojectapi.user.datamodels.admin;
import pizzaprojectapi.user.datamodels.normaluser;
import pizzaprojectapi.user.datamodels.worker;
import pizzaprojectapi.util.requestparser.parsefromobject;
import pizzaprojectapi.util.requestparser.parseprimitivetypes;
import pizzaprojectapi.util.requestparser.parsersformodels.parseadress;

public class parsepostusers extends parsefromobject{
	private parseadress parseadr;
	public parsepostusers(HttpServletRequest request) {
		super(request);
		parseadr = new parseadress(request);
		// TODO Auto-generated constructor stub
		
	}
	
	public normaluser parsenormaluser() {
		try {
			return new normaluser(getInt("userid"),
					URLDecoder.decode(getString("email"), "UTF-8" ),
					URLDecoder.decode(getString("password"), "UTF-8" ) ,
					parseadr.parseaddress("address"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public worker parseworker() {
		try {
			return new worker(getInt("userid"),
					URLDecoder.decode(getString("email"), "UTF-8" ),
					URLDecoder.decode(getString("password"), "UTF-8" ),
					URLDecoder.decode(getString("name"), "UTF-8" ),
					URLDecoder.decode(getString("surname"), "UTF-8" ));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public admin parseadmin() {
		try {
			return new admin(getInt("userid"),
					URLDecoder.decode(getString("email"), "UTF-8" ),
					URLDecoder.decode(getString("password"), "UTF-8" ),
					URLDecoder.decode(getString("name"), "UTF-8" ),
					URLDecoder.decode(getString("surname"), "UTF-8" ));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
