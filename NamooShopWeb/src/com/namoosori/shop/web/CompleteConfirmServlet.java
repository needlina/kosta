package com.namoosori.shop.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/complete.do")
public class CompleteConfirmServlet extends HttpServlet{

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
		String complete = "complete";
		if (complete.equals(req.getParameter("complete")) == true) {
			resp.sendRedirect("main");
		}
	}
	

}
