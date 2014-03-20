<%@page import="com.namoosori.namooshop.domain.Order"%>
<%@page import="com.namoosori.namooshop.service.facade.CustomerService"%>
<%@page import="com.namoosori.namooshop.domain.Product"%>
<%@page import="java.util.List"%>
<%@page
	import="com.namoosori.namooshop.service.factory.NamooShopServiceFactory"%>
<%@page import="com.namoosori.namooshop.service.facade.ProductService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function checkForm() {
	var payment = document.getElementsByName("payMethod");
	var address = document.getElementById("addressText");
	for (var i=0;i < payment.length;i++) {
		if (payment[i].checked && address.value.length > 0){
			return true;
		}
	}
			alert("모두 입력하세요");
			return false;
}




</script>


</head>
<body>
	<h2>${loginUser.name}님로그인 되었습니다.</h2>
	<form action='confirm.do' method='post'>
		<div id='first'>
			<h1>주문상품</h1>
			<table id='table1'>
				<thead>
					<tr>
						<th class='columnName'>상품번호</th>
						<th class='columnName'>상품명</th>
						<th class='columnName'>가격</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="product" items="${products}">
						<tr>
							<td class='serialNo'>${product.serialNo}</td>
							<td class='bookName'>${product.name}</td>
							<td class='bookPrice'>${product.price}<input type="hidden"
								value="${product.serialNo}" name="books[]" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div id='second'>
			<h1>주문정보 입력</h1>
			<table id='table2'>
				<thead>
					<tr>
						<td class='rowName'>결제방법</td>
						<td><input name='payMethod' type='radio' value='신용카드' />신용카드<input
							name='payMethod' type='radio' value='실시간이체' />실시간이체</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class='rowName'>배송지 주소</td>
						<td><input id='addressText' type='text' name='address' /></td>
					</tr>
				</tbody>
			</table>
			<input onclick="return checkForm();" id='button' type='submit'
				value='주문하기' />
		</div>
	</form>
</body>

</html>