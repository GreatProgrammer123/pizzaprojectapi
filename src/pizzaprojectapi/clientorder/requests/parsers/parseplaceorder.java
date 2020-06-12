package pizzaprojectapi.clientorder.requests.parsers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import pizzaprojectapi.clientorder.datamodels.orders.anorder;
import pizzaprojectapi.clientorder.datamodels.product.drinkorder;
import pizzaprojectapi.clientorder.datamodels.product.pizzaorder;
import pizzaprojectapi.clientorder.datamodels.product.topingorder;
import pizzaprojectapi.menu.datamodels.sizeprice;
import pizzaprojectapi.util.requestparser.parsefromobject;
import pizzaprojectapi.util.requestparser.parsersformodels.parseadress;

public class parseplaceorder  extends parsefromobject{
	private DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	private parseadress parseadr;
	public parseplaceorder(HttpServletRequest request) {
		super(request);
		parseadr = new parseadress(request);
		// TODO Auto-generated constructor stub
	}
	
	public anorder parseorder() {
		anorder order = null;
		try {
			order = new anorder(0,getInt("state"), 
					LocalDateTime.parse(URLDecoder.decode(getString("date"), "UTF-8" ), dateformatter),
					LocalDateTime.parse(URLDecoder.decode(getString("updatedate"), "UTF-8" ), dateformatter),getInt("userid"),getBoolean("eathere"));
			order.setPizzas(parsepizzas());
			order.setOthertopings(parsetopings(getarray("othertopings")));
			order.setDrinks(parsedrinks());
			order.setDeliveryaddres(parseadr.parseaddress("deliveryaddres"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return order;
	}

	private List<pizzaorder> parsepizzas(){
		List<pizzaorder> list = new ArrayList<>();
		JSONArray jar = getarray("pizzas");
		JSONObject elem;
		for(int i =0;i<jar.length();i++){
			try {
				elem = (JSONObject) jar.get(i);
			} catch (JSONException e) {
				return list;
			}
			list.add(new pizzaorder(0,getIntfromobj("count",elem),parsetopings(getarray("topings",elem)),parsesizep(getobjectfromobj("sizep",elem)),getIntfromobj("pizzaid",elem)));
		}		
		return list;
	}
	
	private sizeprice parsesizep(JSONObject elem){
	    try {
			return  new sizeprice(0, URLDecoder.decode(getStringfromobj("name",elem), "UTF-8" ), getIntfromobj("size",elem), getDoublefromobj("price",elem));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}
	
	private List<topingorder> parsetopings(JSONArray jar){
		 List<topingorder> list = new ArrayList<>();
		 JSONObject elem;
		 for(int i =0;i<jar.length();i++){
				try {
				elem = (JSONObject) jar.get(i);
				} catch (JSONException e) {
					return list;
				}
				list.add(new topingorder(0, getIntfromobj("count",elem) , getDoublefromobj("price",elem) ,getIntfromobj("pizzatoppingid",elem)));
				
			}	
		 return list;
	}
	
	
	private List<drinkorder> parsedrinks(){
		List<drinkorder>  list = new ArrayList<>();
		JSONArray jar =  getarray("drinks");
		JSONObject elem;
		for(int i=0;i<jar.length();i++) {
			try {
				elem = (JSONObject) jar.get(i);
			} catch (JSONException e) {
					return list;
			}
			  list.add(new drinkorder(0,getIntfromobj("count",elem),getIntfromobj("drinkid",elem),getDoublefromobj("price",elem)));
			}
		 
		return list;
	}
	
	public boolean ispayingincash() {
		return getBoolean("ispayingincash");
	}
	
	
	
	
}
