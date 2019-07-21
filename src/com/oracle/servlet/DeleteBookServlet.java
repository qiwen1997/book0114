package com.oracle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.BookDao;

/**
 * Servlet implementation class DeleteBookServlet
 */
@WebServlet("/deleteBook.do")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BookDao dao=new BookDao();
		
		
		String[] ids=request.getParameterValues("isbn");
		Integer[] isbns=new Integer[ids.length];
		
		for(int i=0;i<isbns.length;i++) {
			isbns[i]=Integer.valueOf(ids[i]);
		}
		
		dao.delete(isbns);
		
		//request.getRequestDispatcher("bookList.do").forward(request, response);
		
		response.sendRedirect("bookList.do");
		
	}

}
