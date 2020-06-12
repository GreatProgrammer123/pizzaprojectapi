package pizzaprojectapi.clientorder.requests;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzaprojectapi.clientorder.datamodels.orders.anorder;
import pizzaprojectapi.clientorder.dbs.orderdb;
import pizzaprojectapi.util.resgenerator.response;

/**
 * Servlet implementation class readorderbyid
 */
@WebServlet("/readorderbyid")
public class readorderbyid extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private orderdb ordb = new orderdb();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public readorderbyid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		anorder order = ordb.getorderbyid(Integer.parseInt(request.getParameter("orderid")));
	      
		order.getPayment().setAnorder(null);
		response.getWriter().write(new response(true,order).buildjson());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
