package pizzaprojectapi.user.loginregister.register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzaprojectapi.user.datamodels.normaluser;
import pizzaprojectapi.user.datamodels.user;
import pizzaprojectapi.user.db.userdb;
import pizzaprojectapi.user.loginregister.util.hashpas.hashpas;
import pizzaprojectapi.user.loginregister.util.parser.parsepostusers;
import pizzaprojectapi.util.resgenerator.response;

/**
 * Servlet implementation class updatenormaluser
 */
@WebServlet("/updatenormaluser")
public class updatenormaluser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private parsepostusers parser;
    private userdb udb = new userdb();
    private hashpas hpas = new hashpas();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatenormaluser() {
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
		parser = new parsepostusers(request);
		normaluser nuser =parser.parsenormaluser(); 
		normaluser olduser = udb.readuserbyid(nuser.getUserid());
		if(nuser.getPassword().equals(""))nuser.setPassword(olduser.getPassword()); else nuser.setPassword(hpas.hashpassword(nuser.getPassword()));
		udb.savenormaluser(nuser);
		response.getWriter().write(new response(true,"zapisano").buildjson());
	}

}
