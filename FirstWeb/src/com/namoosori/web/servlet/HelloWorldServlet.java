package com.namoosori.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = 5742628710116017048L;

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
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		

		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Hello World</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1> Hello~ Servlet!</h1>");
		writer.println("</body>");
		writer.println("</html>");

	}

}
