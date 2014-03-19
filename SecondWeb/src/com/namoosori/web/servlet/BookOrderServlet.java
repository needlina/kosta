package com.namoosori.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/order.do")
public class BookOrderServlet extends HttpServlet{

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
		req.setCharacterEncoding("UTF-8");
		String[] books = req.getParameterValues("books");

		if(books != null && books.length > 0) {
			// 주문한 책이 있는 경우 주문목록 화면으로 포워딩
			RequestDispatcher dispatcher = req.getRequestDispatcher("bookList.xhtml");
			dispatcher.forward(req, resp);
			
		} else {
			resp.sendRedirect("special.xhtml");
		}
		

	}
	
	

}
