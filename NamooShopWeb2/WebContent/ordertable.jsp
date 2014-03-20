<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
						<td class='bookPrice'>${product.price}원<input type="hidden" value="${product.serialNo}" name="books[]"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<label id='totalPrice'>주문금액 : ${total}원</label><br/><br/>
		</div>