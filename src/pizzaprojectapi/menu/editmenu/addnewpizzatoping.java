package pizzaprojectapi.menu.editmenu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzaprojectapi.menu.datamodels.pizzatopping;
import pizzaprojectapi.menu.editmenu.requestparsers.parsposttoping;
import pizzaprojectapi.util.resgenerator.response;

/**
 * Servlet implementation class addnewpizzatoping
 */
@WebServlet("/addnewpizzatoping")
public class addnewpizzatoping extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private parsposttoping parser;
	private productsdb proddb = new productsdb();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addnewpizzatoping() {
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
		parser = new parsposttoping(request);
		if(!parser.canparse()) {
			response.getWriter().write(new response(true,"wyst¹pi³ b³¹d").buildjson());
			return;
		}
		pizzatopping ptop = parser.parsetoping();
		proddb.saveobject(ptop);
		if(ptop.getPizzatoppingid()!=0) {
			response.getWriter().write(new response(true,"zapizano",ptop).buildjson());
		}else {
			response.getWriter().write(new response(true,"wyst¹pi³ b³¹d").buildjson());
		}		
	}

}
