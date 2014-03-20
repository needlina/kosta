<%@page import="com.namoosori.namooshop.service.factory.NamooShopServiceFactory"%>
<%@page import="com.namoosori.namooshop.service.facade.CustomerService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<form action='login.do' method='post'>
		<div>
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