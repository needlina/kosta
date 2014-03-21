<%@page import="com.namoosori.namooshop.domain.Product"%>
<%@page import="java.util.List"%>
<%@page
	import="com.namoosori.namooshop.service.factory.NamooShopServiceFactory"%>
<%@page import="com.namoosori.namooshop.service.facade.ProductService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="namoo" uri="/WEB-INF/namoosori.tld"%>
<%@ taglib prefix="my" uri="/WEB-INF/mytag.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet' type='text/css' href='./style.css'/>
<title>상품 목록</title>
</head>
<body>

	<form action='order.do' method='post'>
		<div id='main'>
			<h1>상품 목록</h1>
			<table>
				<thead>
					<tr class='firstRow'>
						<th class='checkbox'>&nbsp;</th>
						<th class='serialNo'>상품번호</th>
						<th class='bookName'>상품명</th>
						<th class='bookPrice'>가격</th>
						<th class='like'>평점</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="product" items="${products}">
						<tr>
							<th class='checkbox'><input type='checkbox' name='books[]'
								value="${product.serialNo}" /></th>
							<td class='serialNo'>${product.serialNo}</td>
							<td class='bookName'>${product.name}</td>
							<td class='bookPrice'><my:currency value="${product.price}"/>원</td>
							<td class='like'><my:circle count="${product.like}"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<input id='button' type='submit' value='주문하기' />
		</div>
	</form>
</body>

</html>