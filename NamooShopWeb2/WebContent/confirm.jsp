<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${loginUser.name}님 로그인되었습니다.</h2>
	<form action='confirm.do' method='post'>
		<h1>주문상품</h1>
		<div id='first'>
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
							<td class='bookPrice'>${product.price}</td>
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
						<td><input name='payMethod' type='text' value='' />
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class='rowName'>배송지 주소</td>
						<td><input id='addressText' type='text' name='address' value=''/></td>
					</tr>
				</tbody>
			</table>
			<input id='button' type='submit' value='수정하기' />
			<input id='button' type='submit' value='주문하기' />
		</div>
	</form>
</body>
</html>