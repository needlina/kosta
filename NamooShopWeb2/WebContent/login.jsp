<%@page
	import="com.namoosori.namooshop.service.factory.NamooShopServiceFactory"%>
<%@page import="com.namoosori.namooshop.service.facade.CustomerService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet' type='text/css' href='./style.css'/>
<title>로그인</title>
<!-- <style type="text/css">
#login {
	width: 600px;
	height: 400px;
}

#login h1 {
	margin-left: 180px;
	text-align: center;
}

#login table {
	width: 250px;
	margin-left: 45%;
	margin-right: 45%;
}

#login table,td,th {
	border: 1px solid #D1B2FF;
	border-radius: 5px 5px 5px 5px;
}

#login #button {
	float: right;
	margin-top: 20px;
	margin-right: 80px;
}

#login th {
	background-color: #D1B2FF;
	color: white;
}
</style> -->
</head>
<body>
	<form action='login.do' method='post'>
		<div id="login">
			<h1>로그인</h1>
			<table id='form'>
				<tr>
					<th class='loginID'><label>로그인 ID</label></th>
					<td class='loginID'><input type='text' name='loginID' value="${loginID}"/></td>
				</tr>
				<tr>
					<th><label>패스워드</label></th>
					<td><input type='password' name='loginPW' value="${loginPW}"/></td>
				</tr>
				</tbody>
			</table>
			<input id='button' type='submit' value='로그인' />
			<label id='error'>${error}</label>
		</div>
	</form>
</body>

</html>