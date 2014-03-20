package com.namoosori.shop.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoosori.namooshop.domain.Product;
import com.namoosori.namooshop.service.facade.ProductService;
import com.namoosori.namooshop.service.factory.NamooShopServiceFactory;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4297113391260453210L;

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
		ProductService ps = NamooShopServiceFactory.getInstance().getProductService();
		List<Product> productList = ps.getAllProducts();

		/*resp.setContentType("text/html; charset=UTF-8");*/
		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title></title>");
		writer.println("<link rel='stylesheet' type='text/css' href='./css/mainstyle.css'/>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>상품 목록</h1>");
		writer.println("<form action='order' method='post'>");
		writer.println("<div id='table'>");
		writer.println("<table>");
		writer.println("<thead>");
		writer.println("<tr class='firstRow'>");
		writer.println("<th class='checkbox'>&nbsp;</th>");
		writer.println("<th class='serialNo'>상품번호</th>");
		writer.println("<th class='bookName'>상품명</th>");
		writer.println("<th class='serialNo'>가격</th>");
		writer.println("<th class='like'>평점</th>");
		writer.println("</tr>");
		writer.println("</thead>");
		writer.println("<tbody>");
		
		
		for(int i = 0; i < productList.size(); i++) {
			Product pr = productList.get(i);
			writer.println("<tr>");
			writer.println("<th class='checkbox'><input type='checkbox' name='books' value='"+(i+1)+"'/></th>");
			writer.println("<td class='serialNo'>" + pr.getSerialNo() + "</td>");
			writer.println("<td class='bookName'>" + pr.getName() + "</td>");
			writer.println("<td class='bookPrice'>" + pr.getPrice() + "</td>");
			writer.println("<td class='like'>" + pr.getStar() + "</td>");
			writer.println("</tr>");
		}
		
		writer.println("</tbody>");
		
		
		writer.println("</table>");
		writer.println("<input id='button' type='submit' value='주문하기'/>");
		writer.println("</div>");
		writer.println("</form>");
		writer.println("</body>");
		writer.println("</html>");
	}
}
