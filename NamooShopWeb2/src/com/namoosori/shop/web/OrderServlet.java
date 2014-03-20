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
@WebServlet("/order.do")
public class OrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1588822978316313012L;

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
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("order.jsp");
			String[] books = req.getParameterValues("books[]");
			for(int i = 0;i < books.length;i++) {
				int booksNumber = Integer.parseInt(books[i]);
				order.addProduct(ps.getProduct(booksNumber));
			}
			req.setAttribute("products", order.getProducts());
			req.setAttribute("total", order.getTotalPrice());
			rd.forward(req, resp);
		}
	}

}
