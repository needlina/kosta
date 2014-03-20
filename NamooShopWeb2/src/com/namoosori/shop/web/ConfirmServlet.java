package com.namoosori.shop.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.namoosori.namooshop.domain.Order;
import com.namoosori.namooshop.service.facade.ProductService;
import com.namoosori.namooshop.service.factory.NamooShopServiceFactory;


@WebServlet("/confirm.do")
public class ConfirmServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1195923324159485629L;

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
		HttpSession session = req.getSession();
		if (session.getAttribute("loginUser") == null) {
			resp.sendRedirect("login.jsp");
			return;
		}
		
	
		ProductService ps = NamooShopServiceFactory.getInstance().getProductService();
		Order order = new Order();
		if (req.getParameter("books[]") == null) {
			resp.sendRedirect("main.xhtml");
			return;
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("confirm.jsp");
			String[] books = req.getParameterValues("books[]");
			for(int i = 0;i < books.length;i++) {
				int booksNumber = Integer.parseInt(books[i]);
				order.addProduct(ps.getProduct(booksNumber));
			}
			req.setAttribute("products", order.getProducts());
			rd.forward(req, resp);
		}
		
		
		if (req.getParameter("payMethod") == null || req.getParameter("address") == null) {
			resp.sendRedirect("order.do");
			return;
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("confirm.jsp");
			req.setAttribute("payMethod", req.getParameter("payMethod"));
			req.setAttribute("address", req.getParameter("address"));
			rd.forward(req, resp);
			return;
		}
		

		
		
		
	}
	
	

}
