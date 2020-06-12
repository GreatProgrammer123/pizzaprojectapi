package pizzaprojectapi.util.requestparser;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class parsefromobject extends parseprimitivetypes{

	public parsefromobject(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	
	protected JSONObject getobject(String name) {
		try {
			return req.getJSONObject(name);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new JSONObject();
		}
	}
	
	
	protected JSONObject getobjectfromobj(String name,JSONObject obj) {
		try {
			return obj.getJSONObject(name);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new JSONObject();
		}
	}
	
	protected JSONArray getarray(String name){
		try {
			return req.getJSONArray(name);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new JSONArray();
	}
	
	protected JSONArray getarray(String name,JSONObject job){
		try {
			return job.getJSONArray(name);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new JSONArray();
	}
	

}
