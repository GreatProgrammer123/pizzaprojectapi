package pizzaprojectapi.clientorder.requests;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import pizzaprojectapi.clientorder.datamodels.orders.anorder;
import pizzaprojectapi.clientorder.datamodels.orders.payment;
import pizzaprojectapi.clientorder.dbs.orderdb;
import pizzaprojectapi.clientorder.payment.paymentoperations;
import pizzaprojectapi.clientorder.payment.paymentreqbuilder;
import pizzaprojectapi.clientorder.requests.parsers.parseplaceorder;
import pizzaprojectapi.menu.editmenu.productsdb;
import pizzaprojectapi.util.resgenerator.response;

/**
 * Servlet implementation class placeorder
 */
@WebServlet("/placeorder")
public class placeorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private parseplaceorder parser;  
    private orderdb odb = new orderdb();
    private productsdb pdb = new  productsdb();
    private paymentoperations paymentop  = new paymentoperations();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public placeorder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		parser =new parseplaceorder(request);
		if(!parser.canparse()) {
			response.getWriter().write(new response(false,"wyst¹pi³ b³¹d").buildjson());
			return;
		}
		// zrób payment na completed jeœli zaznaczy³ gotówk¹
		anorder order = parser.parseorder();
	
		order.getPizzas().forEach(p->{
			p.setPizza(pdb.getpizzabyid(p.getPizzaid()));
			System.out.println("pizza id 1 "  + p.getPizzaid());
			System.out.println("pizza id  "+order.getPizzas().get(0).getPizza().getPizzaid());
			p.getTopings().forEach(t->{
				t.setToping(pdb.getpizzatopingbyid(t.getPizzatoppingid()));
			});
		});
		
		order.getOthertopings().forEach(tp->tp.setToping(pdb.getpizzatopingbyid(tp.getPizzatoppingid())));
	
		order.getDrinks().forEach(d->{
			System.out.println("drink id  " + d.getDrinkid());
			d.setDrink(pdb.getdrinkbyid(d.getDrinkid()));
		});
		payment payment =new payment(0,order.calccost(), false, "",order);
		if(parser.ispayingincash()) {
			payment.setCompleted(true);
		}else {
			paymentop.sendpaymentorder(
					paymentop.getauthtoken(), 
					new paymentreqbuilder(order).buildprams(request.getRemoteAddr()));
			payment.setIdfrompayu(paymentop.getpaymentid());
			payment.setUrl(paymentop.geturl());
		}
		order.setPayment(payment);
		order.setState(1);
		odb.saveorder(order);
		if(order.getOrderid()==0||(!parser.ispayingincash()&&order.getPayment().getIdfrompayu()==null)) {
			response.getWriter().write(new response(false,"wyst¹pi³ b³¹d").buildjson());
		}else {
			response.getWriter().write(new response(true,"zapisano",payment.getUrl()).buildjson());
		}		
	}

}
