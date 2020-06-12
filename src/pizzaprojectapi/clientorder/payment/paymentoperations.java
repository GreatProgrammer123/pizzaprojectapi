package pizzaprojectapi.clientorder.payment;

import java.io.IOException;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;



public class paymentoperations {
	private paymentconf pconf = new paymentconf();
	private JSONObject paymentres;
	
	
	
	
	
public String getauthtoken() {
	String res = null;
	 HttpPost post = new HttpPost(pconf.authurl);
	    StringEntity requestEntity = new StringEntity(
	    "grant_type=client_credentials&client_id="+pconf.clientid+"&client_secret="+pconf.clientsecretkey,
	     ContentType.APPLICATION_FORM_URLENCODED);
	   
	    post.setEntity(requestEntity);

	    try (CloseableHttpClient httpClient = HttpClients.createDefault();
	         CloseableHttpResponse response = httpClient.execute(post)) {
             res =    EntityUtils.toString(response.getEntity());
	        System.out.println(res);
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			JSONObject job = new JSONObject(res);
			return job.getString("access_token");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return res;
	    
}
// returns orderId redirectUri
public JSONObject sendpaymentorder(String token,JSONObject params) {
	JSONObject res = null;
    HttpPost post = new HttpPost(pconf.paymentorderurl);
    
    StringEntity requestEntity = new StringEntity(
    		params.toString(),
    	    ContentType.APPLICATION_JSON);

    post.setHeader("Authorization", "Bearer " + token); 	
    post.setEntity(requestEntity);

    try (CloseableHttpClient httpClient = HttpClientBuilder.create()
    	    .disableRedirectHandling()
    	    .build();
    		
         CloseableHttpResponse response = httpClient.execute(post)) {
    	
    	System.out.println("code  " + response.getCode()+ "   " + response.getLocale() + "   " + post.getAuthority() + "   " + post.getRequestUri());
    	   
    	  
    	
          try {
			res = new JSONObject(EntityUtils.toString(response.getEntity()));
			System.out.println(res.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       // System.out.println(res);
    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    paymentres = res;
    return res;
}


public String geturl() {
	try {
        String uri = paymentres.getString("redirectUri");
		System.out.println("uri " + uri );
		return uri;
        //return paymentres.getString("redirectUri");
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}


public String getpaymentid() {
	try {
		return paymentres.getString("orderId");
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
}
