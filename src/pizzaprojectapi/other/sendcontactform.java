package pizzaprojectapi.other;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzaprojectapi.util.mailingsystem.mailconf.mailconfrestorepassword;
import pizzaprojectapi.util.mailingsystem.mailsender.sendcontactmsg;
import pizzaprojectapi.util.resgenerator.response;

/**
 * Servlet implementation class sendcontactform
 */
@WebServlet("/sendcontactform")
public class sendcontactform extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private contactmsgparser parser;  
    private sendcontactmsg sender = new sendcontactmsg(new mailconfrestorepassword());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendcontactform() {
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
		parser = new contactmsgparser(request);
		if(sender.sendcontactmsg(parser.parsecontactmsg())) {
			response.getWriter().write(new response(true,"wys³ano wiadomoœæ").buildjson());
		}else {
			response.getWriter().write(new response(true,"wyst¹pi³ b³¹d").buildjson());
		}
	}

}
