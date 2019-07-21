package com.oracle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.BookDao;
import com.oracle.util.PageInfo;
import com.oracle.vo.Book;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet("/bookList.do")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BookDao dao=new BookDao();
		
		PageInfo pageInfo=new PageInfo(request);
		
		dao.getBooksForPage(pageInfo);
		//List<Book> list=dao.getAll();
		
		//request.setAttribute("list", list);
		request.getRequestDispatcher("bookList.jsp").forward(request,response);
		
		
	}

}
