package com.namoosori.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.xhtml")
public class LoginFormServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6737978632833768209L;

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
		// 로그인된 경우 로그인 사용자 페이지로 바로 이동
		if (session.getAttribute("loginId") != null) {
			resp.sendRedirect("special.xhtml");
			return;
		}
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>로그인</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<form action=\"login.do\" method=\"post\">");
		writer.println("로그인 ID : <input type='text' name='loginId'/><br/>");
		writer.println("Password : <input type='password' name='loginPW'/><br/>");
		writer.println("<input type='submit' value='로그인'/>");
		writer.println("</form>");
		writer.println("</body>");
		writer.println("</html>");
	}
}


