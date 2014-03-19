package com.namoosori.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/special.xhtml")
public class SpecialServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3748589311070143740L;

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
		if (session.getAttribute("loginId") == null) {
			resp.sendRedirect("login.xhtml");
			return;
		}

		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>로그인 사용자를 위한 특별서비스</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>로그인 사용자 전용 서비스입니다.</h1>");
		writer.println("Wow! JSP/Servlet 무제한 수강권<br/>");
		writer.println("<a href='logout.do'>로그아웃</a>");

		writer.println("<p>원하는 서비스를 선택하세요.</p>");
		writer.println("<form action='order.do' method='post'>");
		writer.println("<input name='books' type='checkbox' value='1'/> Java 기초 <br/>");
		writer.println("<input name='books' type='checkbox' value='JavaScript 따라잡기'/> JavaScript 따라잡기 <br/>");
		writer.println("<input name='books' type='checkbox' value='JSP/Servlet 벼락치기'/> JSP/Servlet 벼락치기 <br/>");
		writer.println("<input type='submit' value='신청하기'/>");
		writer.println("</body>");
		writer.println("</html>");
	}

}
