<%@page import="com.namoosori.namooshop.domain.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.namoosori.namooshop.service.factory.NamooShopServiceFactory"%>
<%@page import="com.namoosori.namooshop.service.facade.ProductService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	ProductService service = NamooShopServiceFactory.getInstance().getProductService();
	List<Product> products = service.getAllProducts();
	request.setAttribute("products", products);
%>
<c:set target="${products[0]}" property="price" value="100" />
<c:forEach var="product" items="${products}">
	상품명 : ${product.name} / 가격 : ${product.price}<br/>
</c:forEach>

<a href="<c:url value="/first.jsp"/>">first.jsp 열기</a>


</body>
</html>