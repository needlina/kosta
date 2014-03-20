<%@page
	import="com.namoosori.namooshop.service.factory.NamooShopServiceFactory"%>
<%@page import="com.namoosori.namooshop.service.facade.CustomerService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
div {
	width: 600px;
	height: 400px;
}

div h1 {
	margin-left: 180px;
	text-align: center;
}

div table {
	width: 250px;
	margin-left: 45%;
	margin-right: 45%;
}

table,td,th {
	border: 1px solid #D1B2FF;
	border-radius: 5px 5px 5px 5px;
}

div #button {
	float: right;
	margin-top: 20px;
	margin-right: 80px;
}

th {
	background-color: #D1B2FF;
	color: white;
}
</style>
</head>
<body>
	<form action='login.do' method='post'>
		<div>
			<h1>로그인</h1>
			<table id='form'>
				<tr>
					<th class='loginID'><label>로그인 ID</label></th>
					<td class='loginID'><input type='text' name='loginID' /></td>
				</tr>
				<tr>
					<th><label>패스워드</label></th>
					<td><input type='password' name='loginPW' /></td>
				</tr>
				</tbody>
			</table>
			<input id='button' type='submit' value='로그인' />
		</div>
	</form>
</body>

</html>