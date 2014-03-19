package com.namoosori.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookList.xhtml")
public class BookListServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8251267884006262011L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>주문한 책 목록</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>주문 도서 목록</h1>");
		writer.println("<ul>");
		String[] books = req.getParameterValues("books");
		for(String bookName : books) {
			writer.println("<li>" + bookName + "</li>");
		}
		writer.println("</ul>");
		writer.println("</body>");
		writer.println("</html>");

	}
	
	

}
