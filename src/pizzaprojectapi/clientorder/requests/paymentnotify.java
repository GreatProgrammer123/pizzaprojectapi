package pizzaprojectapi.clientorder.requests;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzaprojectapi.clientorder.datamodels.orders.payment;
import pizzaprojectapi.clientorder.dbs.orderdb;
import pizzaprojectapi.clientorder.requests.parsers.parsepaymentnotify;

/**
 * Servlet implementation class paymentnotify
 */
@WebServlet("/paymentnotify")
public class paymentnotify extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private parsepaymentnotify parser;   
    private orderdb odb = new orderdb();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public paymentnotify() {
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
		parser =new parsepaymentnotify(request);
		if(!parser.canparse()) {
			System.out.println("cant parse payment notify");
			return;
		}
		payment p = odb.getpaymentbypayuid(parser.getpaymentid());
		System.out.println("idfrompayu " + p.getIdfrompayu());
		if(parser.iscompleted()) {
			p.setCompleted(true);
			odb.saveobject(p);
			response.setStatus(HttpServletResponse.SC_OK);
			//response.getWriter().write(response.200);
		}
	}

}
