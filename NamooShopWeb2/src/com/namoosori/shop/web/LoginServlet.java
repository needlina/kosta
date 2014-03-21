package com.namoosori.shop.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.namoosori.namooshop.service.facade.CustomerService;
import com.namoosori.namooshop.service.factory.NamooShopServiceFactory;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3726843598739947134L;

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
		
		CustomerService cs = NamooShopServiceFactory.getInstance().getCustomerService();
		
		if(cs.login(req.getParameter("loginID"), req.getParameter("loginPW")) == true) {
			// 로그인 성공
			
			session.setAttribute("loginUser", cs.getCustomer(req.getParameter("loginID")));
			RequestDispatcher rd = req.getRequestDispatcher("main.xhtml");
			rd.forward(req,resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			String msg = "로그인 정보가 잘못되었습니다.";
			req.setAttribute("error", msg);
			req.setAttribute("loginID", req.getParameter("loginID"));
			req.setAttribute("loginPW", req.getParameter("loginPW"));
			rd.forward(req,resp);
		}
		
	}
	
	

}
