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
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet("/updateBook.do")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		BookDao dao=new BookDao();
		request.setCharacterEncoding("UTF-8");
		Book book=new Book(request.getParameter("bookName"),Integer.valueOf(request.getParameter("price")));
		
		book.setIsbn(Integer.valueOf(request.getParameter("isbn")));
		//dao.save(book);
		
		dao.update(book);
		//request.getRequestDispatcher("bookList.do").forward(request, response);
		
		response.sendRedirect("bookList.do");
	}

}
