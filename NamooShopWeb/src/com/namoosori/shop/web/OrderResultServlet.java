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

@WebServlet("/confirm")
public class OrderResultServlet extends HttpServlet {

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
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h2>[" + person.getName() + "님] 로그인 되었습니다.</h2>");
		writer.println("<form action='complete' method='post'>");
		
		writer.println("<h1>주문상품</h1>");
		writer.println("<table>");
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
		order.setPayment(req.getParameter("payMethod"));
		order.setShipAddress(req.getParameter("address"));
		System.out.println(order.getPayment());
		String[] books = req.getParameterValues("books[]");
		for(int i = 0;i < books.length;i++) {
			int bookNumber = Integer.parseInt(books[i]);
			Product product = ps.getProduct(bookNumber);
			writer.println("<tr>");
			writer.println("<td>" + product.getSerialNo() + "</td>");
			writer.println("<td>" + product.getName() + "</td>");
			writer.println("<td>" + product.getPrice() + "</td>");
			order.addProduct(product);
			
			writer.println("</tr>");
		}
		
		writer.println("</tbody>");
		writer.println("</table>");
		writer.println("주문금액 : " + order.getTotalPrice());
		writer.println("<h1>주문정보 입력</h1>");
		writer.println("<table>");
		writer.println("<thead>");
		writer.println("<tr>");
		writer.println("<td>결제방법</td>");
		writer.println("<td><input name='payMethod' type='text' value='" + order.getPayment() + "'/>");
		writer.println("</tr>");
		writer.println("</thead>");
		writer.println("<tbody>");
		writer.println("<tr>");
		writer.println("<td>배송지 주소</td>");
		writer.println("<td><input type='text' name='address' value='"+  order.getShipAddress() +"'/></td>");
		writer.println("</tr>");
		writer.println("</tbody>");
		writer.println("</table>");
		writer.println("<input type='button' onclick='history.back();' value='수정'/>");
		writer.println("<input type='hidden' name='complete' value='true' />");
		writer.println("<input type='submit' value='신청완료'/>");
		writer.println("</form>");
		writer.println("</body>");
		writer.println("</html>");
	}
}
