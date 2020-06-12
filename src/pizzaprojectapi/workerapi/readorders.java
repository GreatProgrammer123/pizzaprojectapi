package pizzaprojectapi.workerapi;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzaprojectapi.clientorder.datamodels.orders.anorder;
import pizzaprojectapi.clientorder.dbs.orderdb;
import pizzaprojectapi.util.database.querybuilder;
import pizzaprojectapi.util.resgenerator.response;

/**
 * Servlet implementation class readorders
 */
@WebServlet("/readorders")
public class readorders extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private orderdb odb =new orderdb();
    private querybuilder query = new querybuilder();
    private DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public readorders() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LocalDateTime date;
		if(request.getParameter("lastupdatedate")==null||request.getParameter("lastupdatedate").equals("null")) {
			date = LocalDateTime.now().with(LocalTime.of(0,0));
		}else {
			date = LocalDateTime.parse(request.getParameter("lastupdatedate"),dateformatter);
		}
				
		String dbquery = query
				.setprefix("ord")
				.addgetquerystart("anorder")
				.addnumequlksto("state", Double.parseDouble(request.getParameter("state")))
				.addbooleanequlksto("payment.completed", true)
				.adddatelaterthan("updatedate", dateformatter.format(date))
				.buildquery();
		//dodaj jeszcze sprawdzanie czy p³atnoœæ ukoñczona
		
		List<anorder> orders = odb.readorders(dbquery);
		System.out.println("orders " + orders.size());
		orders.forEach(ord->{
			ord.setDrinks(null);
			ord.setOthertopings(null);
			ord.setDeliveryaddres(null);
			ord.setPayment(null);
            ord.getPizzas().forEach(piza->{
            	piza.setTopings(null);
            	//piza.setSizep(null);
            });		
		});
		
		
		response.getWriter().write(new response(true,orders).buildjson());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
