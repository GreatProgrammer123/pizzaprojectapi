package pizzaprojectapi.util.requestparser;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class parseprimitivetypes {
private requesttojson reqtoj = new requesttojson();
JSONObject req;
public parseprimitivetypes(HttpServletRequest request) {
	req = reqtoj.parseparamspost(request);
}

public boolean canparse() {
	if(req==null)return false;
	return true;
}


public String getString(String name) {
	try {
		return req.getString(name);
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("json exception");
	}
	return null;
}

protected double getDouble(String name) {
	try {
		
		return req.getDouble(name);
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("json exception");
	}
	return 0;
}

public int getInt(String name) {
	try {
		
		return req.getInt(name);
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("json exception");
	}
	return 0;
}

protected boolean getBoolean(String name) {
	try {
		return req.getBoolean(name);
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("json exception");
	}
	return false;
}


protected String getStringfromobj(String name,JSONObject obj) {
	try {
		return obj.getString(name);
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("json exception");
	}
	return null;
}

protected int getIntfromobj(String name,JSONObject obj) {
	try {
		return obj.getInt(name);
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("json exception");
	}
	return 0;
}

protected double getDoublefromobj(String name,JSONObject obj) {
	try {
		
		return obj.getDouble(name);
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("json exception");
	}
	return 0;
}

protected boolean getBooleanfromobj(String name,JSONObject obj) {
	try {
		return obj.getBoolean(name);
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("json exception");
	}
	return false;
}

}
