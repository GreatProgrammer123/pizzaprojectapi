package pizzaprojectapi.util.filters;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class requestwrapper extends HttpServletRequestWrapper{
	private byte bites[];
	public requestwrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
		readrequestbody(request);
	}
	
	
	public BufferedReader getReader(){
		System.out.println("using custom requestwrapper reader!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(" read bites " + bites.length);			
		return new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bites.clone())));
        // return reader;
	}
		
	private void readrequestbody(HttpServletRequest request) {
		StringBuffer jb = new StringBuffer();
		  String line = null;
		  try {
		    BufferedReader reader = request.getReader();
		  
		    while ((line = reader.readLine()) != null)jb.append(line);
		   
		   bites = jb.toString().getBytes();
		  } catch (Exception e) { /*report an error*/
			  e.printStackTrace();
			
		  }
	}

}
