package pizzaprojectapi.admin.openhours;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzaprojectapi.util.resgenerator.response;

/**
 * Servlet implementation class readopenhours
 */
@WebServlet("/readopenhours")
public class readopenhours extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private openhoursdb ophdb = new openhoursdb();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public readopenhours() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write(new response(true,ophdb.readopenhours()).buildjson());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
