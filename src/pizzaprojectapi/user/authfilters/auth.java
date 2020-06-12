package pizzaprojectapi.user.authfilters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzaprojectapi.util.filters.requestwrapper;
import pizzaprojectapi.util.requestparser.parseprimitivetypes;
import pizzaprojectapi.util.resgenerator.response;

/**
 * Servlet Filter implementation class auth
 */
@WebFilter("/*")
public class auth implements Filter {
private parseprimitivetypes parser;
    /**
     * Default constructor. 
     */
    public auth() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest  req = new requestwrapper((HttpServletRequest)request);
		parser = new parseprimitivetypes(req);
		
		String url =req.getRequestURL().toString();
		 String queryString = req.getQueryString();
		 System.out.println("request url   " +  url + "?" + queryString);
		 permissioncheck pch = new authfactory().permissonbuilder(url);
		 System.out.println("auth passed1");
		 if(pch!=null&&!pch.haspermission(gettoken(req))) {
			 RequestDispatcher rd=request.getRequestDispatcher("/plizlogin");  
			 chain.doFilter(req, response);
				rd.forward(req, response);
			 return;					
			 //response.getWriter().write(new response(false,"nie masz uprawnieñ").buildjson());
		
		 }else {
			 System.out.println("auth passed2");
				chain.doFilter(req, response);
		 }
		 
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	private String gettoken(HttpServletRequest req) {
		String token = req.getParameter("token");
		if(token!=null)return token;
		if(parser.canparse())return parser.getString("token");
		return  null;
	}
	

}
