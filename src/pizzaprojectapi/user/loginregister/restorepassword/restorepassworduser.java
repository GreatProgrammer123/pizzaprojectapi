package pizzaprojectapi.user.loginregister.restorepassword;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzaprojectapi.util.mailingsystem.mailconf.mailconfrestorepassword;
import pizzaprojectapi.util.mailingsystem.mailsender.sendrestorepassword;
import pizzaprojectapi.util.requestparser.parseprimitivetypes;
import pizzaprojectapi.util.resgenerator.response;

/**
 * Servlet implementation class restorepassworduser
 */
@WebServlet("/restorepassworduser")
public class restorepassworduser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private parseprimitivetypes parser;
    private passwordgenerator pasgenerator = new passwordgenerator();
    private sendrestorepassword mailsender = new sendrestorepassword(new mailconfrestorepassword());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public restorepassworduser() {
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
		String email = URLDecoder.decode(parser.getString("email"), "UTF-8" );
		String npas= pasgenerator.restorepassword(email);
		if(npas==null) {
			response.getWriter().write(new response(false,"podaj prawid³owy adres e-mail").buildjson());
			return;
		}
		
		if(mailsender.sendmail(email, npas)) {
			response.getWriter().write(new response(true,"Wys³ano nowe has³o na twoj¹ skrzynkê odbiorcz¹").buildjson());
		}else {
			response.getWriter().write(new response(false,"wyst¹pi³ b³¹d").buildjson());
		}
		
	}

}
