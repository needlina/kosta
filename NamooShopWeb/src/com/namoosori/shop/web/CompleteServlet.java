package com.namoosori.shop.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoosori.namooshop.domain.Order;
import com.namoosori.namooshop.service.facade.OrderService;
import com.namoosori.namooshop.service.factory.NamooShopServiceFactory;

@WebServlet("/complete")
public class CompleteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6255426892927710640L;

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

		OrderService os = NamooShopServiceFactory.getInstance().getOrderService();
		Order order = new Order();
		
		boolean complete = os.order(order);
		if (complete == true) {
			writer.println("<h1>상품 주문이 완료되었습니다.</h1>");
			writer.println("<form action='complete.do' method='post'>");
			writer.println("<input type='hidden' name='complete' value='complete'/>");
			writer.println("<input type='submit' value='확인'/>");
			writer.println("</form>");
		}
	}

}
