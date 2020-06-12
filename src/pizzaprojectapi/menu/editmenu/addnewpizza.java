package pizzaprojectapi.menu.editmenu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzaprojectapi.menu.datamodels.pizza;
import pizzaprojectapi.menu.editmenu.requestparsers.parsepostpizza;
import pizzaprojectapi.util.resgenerator.response;

/**
 * Servlet implementation class addnewpizza
 */
@WebServlet("/addnewpizza")
public class addnewpizza extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private parsepostpizza parsepizza;   
    private productsdb proddb;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addnewpizza() {
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
		System.out.println("adding new pizza!!!!!!!!!!!!");
		proddb = new productsdb();
		parsepizza = new parsepostpizza(request);
		if(!parsepizza.canparse()) {
			response.getWriter().write(new response(false,"wyst¹pi³ b³¹d").buildjson());
			return;
		}
		pizza newpizza = parsepizza.parsepizza();
		proddb.saveobject(newpizza);
		if(newpizza.getPizzaid()!=0) {
			response.getWriter().write(new response(true,"zapisano",newpizza).buildjson());
		}else {
			response.getWriter().write(new response(true,"wyst¹pi³ b³¹d").buildjson());
		}
		
	}

}
