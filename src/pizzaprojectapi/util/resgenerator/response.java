package pizzaprojectapi.util.resgenerator;

import com.google.gson.Gson;

public class response {
private exactres res;
private Gson gson = new Gson();
private StringBuilder resbud;
public response(boolean success, String msg, Object data) {
	super();
	res = new exactres(success,msg,data);
	
}
public response(boolean success, String msg) {
	super();
	res = new exactres(success,msg,null);
}
public response(boolean success, Object data) {
	super();
	res = new exactres(success,null,data);
}
public String buildjson(){
	return gson.toJson(res);
}

}

 class exactres{
	private boolean success;
	private String msg;
	private Object data = null;
	public exactres(boolean success, String msg, Object data) {
		super();
		this.success = success;
		this.msg = msg;
		this.data = data;
	}
	
}
