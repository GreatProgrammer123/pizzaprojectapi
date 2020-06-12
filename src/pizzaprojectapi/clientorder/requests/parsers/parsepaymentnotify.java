package pizzaprojectapi.clientorder.requests.parsers;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import pizzaprojectapi.util.requestparser.parsefromobject;

public class parsepaymentnotify extends parsefromobject{

	public parsepaymentnotify(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	
	public String getpaymentid(){
		JSONObject prop = getobject("properties");
		return getStringfromobj("value",prop);
	}
	
	public boolean iscompleted() {
		String status = getString("status");
		System.out.println("status " + status);
		if(status.equals("COMPLETED"))return true;
		return false;
	}

}
