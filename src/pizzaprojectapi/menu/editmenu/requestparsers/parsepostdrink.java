package pizzaprojectapi.menu.editmenu.requestparsers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import pizzaprojectapi.menu.datamodels.drink;
import pizzaprojectapi.util.requestparser.parseprimitivetypes;

public class parsepostdrink extends parseprimitivetypes{

	public parsepostdrink(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	
	public drink parsedrink() {
		try {
			return new drink(getInt("drinkid"), URLDecoder.decode(getString("name"), "UTF-8" ),getInt("volume"),getDouble("price"),true);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
