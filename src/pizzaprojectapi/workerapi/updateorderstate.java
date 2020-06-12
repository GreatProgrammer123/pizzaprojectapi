package pizzaprojectapi.workerapi;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzaprojectapi.clientorder.datamodels.orders.anorder;
import pizzaprojectapi.clientorder.dbs.orderdb;
import pizzaprojectapi.util.requestparser.parseprimitivetypes;
import pizzaprojectapi.util.resgenerator.response;

/**
 * Servlet implementation class updateorderstate
 */
@WebServlet("/updateorderstate")
public class updateorderstate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private orderdb odb = new orderdb();
    private parseprimitivetypes parser;
    private DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateorderstate() {
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
		parser =new parseprimitivetypes(request);
		if(!parser.canparse()) {
			response.getWriter().write(new response(false,"wyst¹pi³ b³¹d").buildjson());
			return;
		}
		int newstate = parser.getInt("newstate");
		anorder order = odb.getorderbyid(parser.getInt("orderid"));
		if(newstate-1!=order.getState()) {
			response.getWriter().write(new response(false,"to zamówienie zosta³o ju¿ wczeœniej zaktualizowane").buildjson());
			return;
		}
		odb.updateorderstate(newstate,  dateformatter.format(LocalDateTime.now()), order.getOrderid());
		
		response.getWriter().write(new response(true,"zaktualizowano").buildjson());
	}

}
