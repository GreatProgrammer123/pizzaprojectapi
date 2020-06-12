package pizzaprojectapi.user.loginregister.register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzaprojectapi.user.datamodels.admin;
import pizzaprojectapi.user.datamodels.normaluser;
import pizzaprojectapi.user.datamodels.usertypes;
import pizzaprojectapi.user.db.userdb;
import pizzaprojectapi.user.loginregister.util.hashpas.hashpas;
import pizzaprojectapi.user.loginregister.util.parser.parsepostusers;
import pizzaprojectapi.util.resgenerator.response;

/**
 * Servlet implementation class registeradmin
 */
@WebServlet("/registeradmin")
public class registeradmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private userdb udb = new userdb();
	private parsepostusers parser;
	private hashpas hpas = new hashpas();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registeradmin() {
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
		if(!parser.canparse()) {
			response.getWriter().write(new response(false,"wyst¹pi³ b³¹d").buildjson());
			return;
		}
		admin user = parser.parseadmin();
		if(udb.userexists(user.getEmail())) {
			response.getWriter().write(new response(false,"uzytkownik o takim adresie e-mail ju¿ istnieje").buildjson());
			return;
		}
		user.setPassword(hpas.hashpassword(user.getPassword()));
		udb.saveobject(user);
		if(user.getUserid()!=0) {
			response.getWriter().write(new response(true,"zarejestrowano").buildjson());
		}else {
			response.getWriter().write(new response(false,"uzytkownik o takim adresie e-mail ju¿ istnieje").buildjson());
		}
	
	}

}
