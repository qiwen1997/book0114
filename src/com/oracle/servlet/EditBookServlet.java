package com.oracle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.BookDao;
import com.oracle.vo.Book;

/**
 * Servlet implementation class EditBookServlet
 */
@WebServlet("/editBook.do")
public class EditBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookDao dao=new BookDao();
		
		Integer isbn=Integer.valueOf(request.getParameter("isbn"));
		
		Book book=dao.getBookById(isbn);
		
		request.setAttribute("book", book);
		
		request.getRequestDispatcher("editBook.jsp").forward(request, response);
		
	}

}
