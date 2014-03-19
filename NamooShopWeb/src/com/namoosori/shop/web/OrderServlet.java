package com.namoosori.shop.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.namoosori.namooshop.domain.Customer;
import com.namoosori.namooshop.domain.Order;
import com.namoosori.namooshop.domain.Product;
import com.namoosori.namooshop.service.facade.ProductService;
import com.namoosori.namooshop.service.factory.NamooShopServiceFactory;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

	private static final long serialVersionUID = -1588822978316313012L;

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
		if (session.getAttribute("loginUser") == null) {
			resp.sendRedirect("login");
			return;
		}
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		Customer person = (Customer) session.getAttribute("loginUser");
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title></title>");
		writer.println("<link rel='stylesheet' type='text/css' href='./css/orderstyle.css'/>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h2>[" + person.getName() + "님] 로그인 되었습니다.</h2>");
		writer.println("<form action='confirm' method='post'>");
		writer.println("<h1>주문상품</h1>");
		writer.println("<div id='first'>");
		writer.println("<table id='table1'>");
		writer.println("<thead>");
		writer.println("<tr>");
		writer.println("<th class='columnName'>상품번호</th>");
		writer.println("<th class='columnName'>상품명</th>");
		writer.println("<th class='columnName'>가격</th>");
		writer.println("</tr>");
		writer.println("</thead>");
		writer.println("<tbody>");
		ProductService ps = NamooShopServiceFactory.getInstance().getProductService();
		Order order = new Order();
		String[] books = req.getParameterValues("books");
		for(int i = 0;i < books.length;i++) {
			int bookNumber = Integer.parseInt(books[i]);
			Product product = ps.getProduct(bookNumber);
			writer.println("<tr>");
			writer.println("<td class='serialNo'>" + product.getSerialNo() + "</td>");
			writer.println("<td class='bookName'>" + product.getName() + "</td>");
			writer.println("<td class='bookPrice'>" + product.getPrice() + "</td>");
			writer.println("<input type='hidden' name='books[]' value='" + product.getSerialNo() + "'/>");
			order.addProduct(product);
			writer.println("</tr>");
		}
		
		
		
		
		writer.println("</tbody>");
		writer.println("</table>");
		writer.println("<label id='lable'>주문금액 : " + order.getTotalPrice() + "</label>");
		writer.println("</div>");
		writer.println("<div id='second'>");
		writer.println("<h1>주문정보 입력</h1>");
		writer.println("<table id='table2'>");
		writer.println("<thead>");
		writer.println("<tr>");
		writer.println("<td class='rowName'>결제방법</td>");
		writer.println("<td><input name='payMethod' type='radio' value='신용카드'/>신용카드<input name='payMethod' type='radio' value='실시간이체'/>실시간이체</td>");
		writer.println("</tr>");
		writer.println("</thead>");
		writer.println("<tbody>");
		writer.println("<tr>");
		writer.println("<td class='rowName'>배송지 주소</td>");
		writer.println("<td><input id='addressText' type='text' name='address'/></td>");
		writer.println("</tr>");
		writer.println("</tbody>");
		writer.println("</table>");
		writer.println("<input id='button' type='submit' value='주문하기'/>");
		writer.println("</div>");
		writer.println("</form>");
		writer.println("</body>");
		writer.println("</html>");
	}
}
