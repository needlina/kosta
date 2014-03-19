package com.namoosori.web.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {

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
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		
		ServletContext context = getServletContext();
		String userId = context.getInitParameter("adminId");
		String password = context.getInitParameter("password");
		
		String paramLoginId = req.getParameter("loginId");
		String paramLoginPW = req.getParameter("loginPW");
		
		
		if(userId.equals(paramLoginId) && password.equals(paramLoginPW)) {
			// 로그인 성공!
			
			session.setAttribute("loginId", userId);
			
			resp.sendRedirect("special.xhtml");
		} else {
			// 로그인 실패
			session.removeAttribute("loginId");
			resp.sendRedirect("login.xhtml");
		}
	}
	
	

}
