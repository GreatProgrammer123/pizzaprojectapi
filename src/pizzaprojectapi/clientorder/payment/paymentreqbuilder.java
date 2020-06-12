package pizzaprojectapi.clientorder.payment;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import pizzaprojectapi.clientorder.datamodels.orders.anorder;



public class paymentreqbuilder {
	private paymentconf pconf = new paymentconf();
	private anorder order;
	public paymentreqbuilder(anorder order){
		this.order = order;
	}
	
	
	public JSONObject buildprams(String customerip) {
		JSONObject req = new JSONObject();
		try {
			req.put("notifyUrl", pconf.notifyurl);
			req.put("customerIp", customerip);
			req.put("merchantPosId", pconf.posid);
			req.put("description", "pizza");
			req.put("currencyCode", "PLN");
			req.put("totalAmount", order.calccost()*100);
			
			JSONObject buyer = new JSONObject();
			/*buyer.put("email", orders.get(0).getBuyer().getEmail());
			buyer.put("phone",  orders.get(0).getBuyer().getPhone());
			buyer.put("firstName",  orders.get(0).getBuyer().getFirstname());
			buyer.put("lastName",  orders.get(0).getBuyer().getLastname());*/
			buyer.put("language", "pl");
			req.put("buyer", buyer);
			
			JSONObject settings = new JSONObject();
			settings.put("invoiceDisabled",true);
			req.put("settings", settings);
			
			JSONArray ar = new JSONArray();
			order.getPizzas().forEach(pz->{
				ar.put(createproduct(pz.getPizza().getName(),pz.calccost(),pz.getCount()));
				pz.getTopings().forEach(tp->ar.put(createproduct(tp.getToping().getName(),tp.calccost(),tp.getCount())));
			});	
			order.getDrinks().forEach(d->ar.put(createproduct(d.getDrink().getName(),d.calccost(),d.getCount())));
		    order.getOthertopings().forEach(tp->ar.put(createproduct(tp.getToping().getName(),tp.calccost(),tp.getCount())));
			req.put("products", ar);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return req;
	}
	
	
	private JSONObject createproduct(String name,double cost,int quantity) {
		JSONObject product = new JSONObject();
		try {
			product.put("name", name);
			product.put("unitPrice", cost*100);
			product.put("quantity", quantity);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}
	
	
	
}
