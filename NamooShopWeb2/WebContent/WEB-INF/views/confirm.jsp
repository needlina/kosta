<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet' type='text/css' href='./style.css'/>
<title>주문 확인</title>
<!-- <style type="text/css">
#full {
	width: 600px;
}

#order1 h1 {
	margin-left: 200px;
	text-align: center;
}

#order2 h2 {
	margin-left: 200px;
	text-align: center;
}

#order1 table {
	width: 400px;
	margin-left: 35%;
	margin-right: 35%;
}

#order1 table,td,th {
	border: 1px solid #D1B2FF;
	border-radius: 5px 5px 5px 5px;
}

#order2 table,td,th {
	border: 1px solid #D1B2FF;
	border-radius: 5px 5px 5px 5px;
}

#order2 table {
	width: 400px;
	margin-left: 35%;
	margin-right: 35%;
}

#order2 #button {
	float: right;
	margin-top: 20px;
	margin-right: -10px;
}

#order1 th {
	background-color: #D1B2FF;
	color: white;
}

#order1 tbody .serialNo {
	width: 60px;
	text-align: center;
}

#order1 tbody .bookName {
	width: 180px;
	padding-left: 10px;
}

#order1 tbody .bookPrice {
	width: 60px;
	text-align: right;
	padding-right: 10px;
}

.rowName {
	background-color: #D1B2FF;
	color: white;
	font-weight: bold
}

#order1 label {
float: right;
	margin-top: 20px;
}

#order2 #button {
	float: right;
	margin-top: 20px;
	margin-right: -10px;
}

#order2 #modify {
	margin-top: 20px;
	margin-left: 465px;
}

#payMethodButton, #addressText {
border: 0px;
background: transparent;
}

</style> -->

<script type="text/javascript">
function back() {
	
	window.history.back();
}
</script>

</head>
<body>
	<h2>[${loginUser.name}님] 로그인 되었습니다.</h2>
	<form action='complete.do' method='post'>
	<div id="full">
	<%@ include file="/WEB-INF/views/ordertable.jsp" %>

		<div id='order2'>
			<h2>주문정보 입력</h2>
			<table id='table2'>
				<thead>
					<tr>
						<td class='rowName'>결제방법</td>
						<td><input id='payMethodButton' name='payMethod' disabled type='text' value='${payMethod}'/>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class='rowName'>배송지 주소</td>
						<td><input id='addressText' type='text' name='address' disabled value='${address}'/></td>
					</tr>
				</tbody>
			</table>
			<input id='modify' onclick='back();' type='button' value='수정하기' />
			<input id='button' type='submit' value='신청완료' />
		</div>
		</div>
	</form>
</body>
</html>