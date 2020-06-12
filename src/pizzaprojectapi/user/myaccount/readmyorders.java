package pizzaprojectapi.user.myaccount;

import java.io.IOException;
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
 * Servlet implementation class readmyorders
 */
@WebServlet("/readmyorders")
public class readmyorders extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private orderdb odb = new orderdb();
    private querybuilder query = new querybuilder();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public readmyorders() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dbquery = query
				.setprefix("ord")
				.addgetquerystart("anorder")
			    .addnumequlksto("userid", Double.parseDouble(request.getParameter("userid")))
				.buildquery();
		List<anorder>orders = odb.readorders(dbquery);
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
