package com.oracle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.UserDao;
import com.oracle.vo.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserDao dao=new UserDao();
		
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		
		User user=dao.getUser(userName,password);
		
		if(user!=null) {
			request.getSession().setAttribute("user", user);
			dao.userLoginon(user.getUserid());
			response.sendRedirect("bookList.do");
			
		}else {
			response.sendRedirect("login.jsp");
		}
		
	}

}
