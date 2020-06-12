package pizzaprojectapi.menu.readmenu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzaprojectapi.menu.editmenu.productsdb;
import pizzaprojectapi.util.resgenerator.response;

/**
 * Servlet implementation class readmenu
 */
@WebServlet("/readmenu")
public class readmenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private productsdb proddb = new productsdb();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public readmenu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		menu m = proddb.readmenu();
		m.getPizzas().forEach(p->System.out.println("reading pizza " + p.getPizzaid()));
		response.getWriter().write(new response(true,m).buildjson());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
