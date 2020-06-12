package pizzaprojectapi.util.requestparser;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;

import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

public class requesttojson {
	
	public JSONObject parseparamspost(HttpServletRequest request) {
		StringBuffer jb = new StringBuffer();
		  String line = null;
		  try {
		    BufferedReader reader = request.getReader();
		    while ((line = reader.readLine()) != null)jb.append(line);
		 
		  } catch (Exception e){ /*report an error*/
			  e.printStackTrace();
			  return null;
		  }

		  try{
			  JSONObject job =  HTTP.toJSONObject(jb.toString());
			  System.out.println("req  " + job.toString());
			  JSONObject method = new JSONObject(job.getString("Method"));
			  return method;
			  //req = job.getJSONObject("Method");
		  }catch (JSONException e){
		    // crash and burn
		  //  throw new IOException("Error parsing JSON request string");
		 // e.printStackTrace();
		
		  }
		  
		  return new JSONObject();
	}
	
}
