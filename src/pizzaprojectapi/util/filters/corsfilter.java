package pizzaprojectapi.util.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class corsfilter
 */
@WebFilter("/*")
public class corsfilter implements Filter {

    /**
     * Default constructor. 
     */
    public corsfilter() {
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
		HttpServletResponse  res = (HttpServletResponse)response;
		String origin = req.getHeader("origin");
		System.out.println(" Orgigin  " + origin);
		res.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");//http://hwsrv-352882.hostwindsdns.com:8080
		res.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS,  DELETE");
		res.setHeader("Access-Control-Allow-Headers", "Authorization,Content-Type, x-requested-with");
		res.setHeader("Access-Control-Max-Age", "3600");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		chain.doFilter(req, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
