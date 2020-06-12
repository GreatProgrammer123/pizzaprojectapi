package pizzaprojectapi.admin.openhours;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzaprojectapi.util.resgenerator.response;

/**
 * Servlet implementation class saveopenhours
 */
@WebServlet("/saveopenhours")
public class saveopenhours extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private parsepostopenhours parser;
    private openhoursdb ophdb =new openhoursdb();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveopenhours() {
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
		parser =new parsepostopenhours(request);
		if(!parser.canparse()) {
			response.getWriter().write(new response(false,"wyst¹pi³ b³¹d").buildjson());
			return;
		}
		openhours oph = parser.parseopenhours();
		ophdb.saveobject(oph);
		
		if(oph.getOpenhoursid()!=0) {
			response.getWriter().write(new response(true,"zapisano",oph).buildjson());
		}else {
			response.getWriter().write(new response(false,"wyst¹pi³ b³¹d").buildjson());
		}
		
	}

}
