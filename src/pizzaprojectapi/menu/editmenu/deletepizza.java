package pizzaprojectapi.menu.editmenu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzaprojectapi.util.database.querybuilder;
import pizzaprojectapi.util.requestparser.parseprimitivetypes;
import pizzaprojectapi.util.resgenerator.response;

/**
 * Servlet implementation class deletepizza
 */
@WebServlet("/deletepizza")
public class deletepizza extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private productsdb pdb = new productsdb();   
    private parseprimitivetypes parser;
    private querybuilder queryb = new querybuilder();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletepizza() {
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
		parser = new parseprimitivetypes(request);
		if(!parser.canparse()) {
			response.getWriter().write(new response(false,"wyst¹pi³ b³¹d").buildjson());
			return;
		}
		
		pdb.execupdateordelete(queryb.setprefix("piz").addupdatequerystart("pizza").addbooleanequlksto("active", false).addwhere().addnumequlksto("pizzaid", parser.getInt("id")).buildquery());
		response.getWriter().write(new response(true,"ok").buildjson());		
	}

}
