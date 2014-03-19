package com.namoosori.shop.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginFormServlet extends HttpServlet {

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

		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = resp.getWriter();

		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title></title>");
		writer.println("<link rel='stylesheet' type='text/css' href='./css/loginstyle.css'/>");
/*		writer.println("<style type='text/css'>");
		writer.println("#form {border: 1px solid #000000;}");
		writer.println(".loginID {border-bottom: 1px solid #000000;}");
		writer.println("#form td {border-left: 1px solid #000000;}");
		writer.println("div {width: 245px;height: 300px}");
		writer.println("div #button {float: right;}");
		writer.println("</style>");*/
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>로그인</h1>");
		writer.println("<form action='login.do' method='post'>");
		writer.println("<div>");
		writer.println("<table id='form'>");
		writer.println("<tr>");
		writer.println("<th class='loginID'><label>로그인 ID</label></th>");
		writer.println("<td class='loginID'><input type='text' name='loginId' /></td>");
		writer.println("</tr>");
		writer.println("<tr>");
		writer.println("<th><label>패스워드</label></th>");
		writer.println("<td><input type='password' name='loginPW'/></td>");
		writer.println("</tr>");
		writer.println("</tbody>");
		writer.println("</table>");
		writer.println("<input id='button' type='submit' value='로그인'/>");
		writer.println("</div>");
		writer.println("</form>");
		writer.println("</body>");
		writer.println("</html>");

	}

}
