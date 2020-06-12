package pizzaprojectapi.menu.editmenu.requestparsers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import pizzaprojectapi.menu.datamodels.pizza;
import pizzaprojectapi.menu.datamodels.sizeprice;
import pizzaprojectapi.util.requestparser.parsefromobject;

public class parsepostpizza extends parsefromobject{

	public parsepostpizza(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	
	public pizza parsepizza() {
		pizza p = null;
		try {
			p = new pizza(getInt("pizzaid"), URLDecoder.decode(getString("name"), "UTF-8" ),
					URLDecoder.decode(getString("description"), "UTF-8" )
					,URLDecoder.decode( getString("ingredients"), "UTF-8" ),null,true);
			p.setAvailablesizes(parsesizeprices());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	
	
	private List<sizeprice> parsesizeprices(){
		List<sizeprice> sizeprices = new ArrayList<>();
		JSONArray jar = getarray("availablesizes");
		for(int i=0;i<jar.length();i++) {
			JSONObject elem;
			try {
				elem = (JSONObject) jar.get(i);
			} catch (JSONException e) {
				return sizeprices;
			}
			try {
				sizeprices.add(new sizeprice( 
						getIntfromobj("sizepriceid",elem),
						URLDecoder.decode(getStringfromobj("name",elem), "UTF-8" ),
						getIntfromobj("size",elem),
						getDoublefromobj("price",elem))
				 );
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return sizeprices;
	}

}
