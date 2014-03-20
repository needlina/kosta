package com.namoosori.shop.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoosori.namooshop.domain.Order;
import com.namoosori.namooshop.service.facade.OrderService;
import com.namoosori.namooshop.service.factory.NamooShopServiceFactory;

@WebServlet("/complete.do")
public class CompleteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6255426892927710640L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrderService os = NamooShopServiceFactory.getInstance().getOrderService();
		Order order = new Order();
		os.order(order);
		if (os.order(order)) {
			resp.sendRedirect("complete.jsp");
		}
	}
	

}
