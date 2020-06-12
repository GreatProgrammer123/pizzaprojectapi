package pizzaprojectapi.menu.editmenu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzaprojectapi.menu.datamodels.drink;
import pizzaprojectapi.menu.editmenu.requestparsers.parsepostdrink;
import pizzaprojectapi.menu.editmenu.requestparsers.parsposttoping;
import pizzaprojectapi.util.resgenerator.response;

/**
 * Servlet implementation class addnewdrink
 */
@WebServlet("/addnewdrink")
public class addnewdrink extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private productsdb proddb = new productsdb();
	 private parsepostdrink parser;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addnewdrink() {
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
		parser = new parsepostdrink(request);
		if(!parser.canparse()) {
			response.getWriter().write(new response(true,"wyst¹pi³ b³¹d").buildjson());
			return;
		}
		drink ndrink = parser.parsedrink();
		proddb.saveobject(ndrink);
		if(ndrink.getDrinkid()!=0) {
			response.getWriter().write(new response(true,"zapisano", ndrink).buildjson());
		}else {
			response.getWriter().write(new response(true,"wyst¹pi³ b³¹d").buildjson());
		}
	}

}
