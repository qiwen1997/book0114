package com.oracle.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.vo.User;

/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter("/*")
public class SessionFilter implements Filter {

	List<String> list=new ArrayList();
    /**
     * Default constructor. 
     */
    public SessionFilter() {
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
		// TODO Auto-generated method stub
		// place your code here

		HttpServletRequest req=(HttpServletRequest)request;
		
		String path=req.getServletPath();
		
		if(list.contains(path)) {
			chain.doFilter(request, response);
		}else {
			HttpSession session=req.getSession();
			
			User user=(User) session.getAttribute("user");
			if(user!=null) {
				chain.doFilter(request,response);
			}else {
				HttpServletResponse res=(HttpServletResponse)response;
				String context=req.getServletContext().getContextPath();
				System.out.println(context);
				res.sendRedirect(context+"/login.jsp");
			}
		}
		
		// pass the request along the filter chain
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		list.add("/login.jsp");
		list.add("/login.do");
	}

}
