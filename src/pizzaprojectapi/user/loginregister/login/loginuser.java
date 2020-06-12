package pizzaprojectapi.user.loginregister.login;

import java.io.IOException;
import java.net.URLDecoder;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzaprojectapi.user.datamodels.admin;
import pizzaprojectapi.user.datamodels.logintoken;
import pizzaprojectapi.user.datamodels.normaluser;
import pizzaprojectapi.user.datamodels.usertypes;
import pizzaprojectapi.user.db.userdb;
import pizzaprojectapi.user.loginregister.util.hashpas.hashpas;
import pizzaprojectapi.util.requestparser.parseprimitivetypes;
import pizzaprojectapi.util.resgenerator.response;

/**
 * Servlet implementation class loginuser
 */
@WebServlet("/loginuser")
public class loginuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private userdb udb = new userdb();
	private parseprimitivetypes parser;
	  private hashpas hpas = new hashpas(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginuser() {
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
		
		normaluser user = udb.loginnormaluser(URLDecoder.decode(parser.getString("email"), "UTF-8" ), hpas.hashpassword( URLDecoder.decode(parser.getString("password"), "UTF-8" )));
		if(user==null) {
			response.getWriter().write(new response(false,"b³êdyny email lub has³o").buildjson());
			return;
		}
		
		logintoken lt = new logintoken(0, null, String.valueOf(usertypes.normaluser),LocalDateTime.now().plusHours(2),user.getUserid());
		lt.generatetoken();
		udb.savelogintoken(lt);
		user.setPassword(lt.getToken());
		
		
		user.setMyorders(null);
		response.getWriter().write(new response(true,"zalogowano",user).buildjson());
	}

}
