package com.namoosori.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/stop")
public class StopServlet extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7553384645563067398L;

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
		
		String juminNo = req.getParameter("juminNo");

		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>해지센터</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>해지 서비스 입니다.</h1>");
		writer.println("<p>" + juminNo + "</p>");
		writer.println("</body>");
		writer.println("</html>");
	}

}
