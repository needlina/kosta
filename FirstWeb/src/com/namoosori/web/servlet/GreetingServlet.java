package com.namoosori.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/greeting/result", "/greet"})
public class GreetingServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 754050809047536637L;


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
		String name = req.getParameter("name");
		System.out.println(name);
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		

		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>인사하기</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("안녕하세요! " + name + "님!");
		writer.println("</body>");
		writer.println("</html>");
		
		
	}

}
