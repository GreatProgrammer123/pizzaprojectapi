package pizzaprojectapi.util.requestparser.parsersformodels;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import pizzaprojectapi.user.datamodels.address;
import pizzaprojectapi.util.requestparser.parsefromobject;

public class parseadress extends parsefromobject{

	public parseadress(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	
	public address parseaddress(String objname) {
		JSONObject elem = getobject(objname);
		address adr = new address(getIntfromobj("addressid",elem), getStringfromobj("street",elem), getStringfromobj("postcode",elem), getStringfromobj("city",elem));
		return adr;
	}

}
