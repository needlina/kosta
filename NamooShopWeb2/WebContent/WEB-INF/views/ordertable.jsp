<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" uri="/WEB-INF/mytag.tld"%>
		<div id='order1'>
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
						<td class='bookPrice'><my:currency value="${product.price}"/>원<input type="hidden" value="${product.serialNo}" name="books[]"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<label id='totalPrice'>주문금액 : <my:currency value="${total}"/>원</label><br/><br/>
		</div>