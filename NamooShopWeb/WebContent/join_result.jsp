<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>이것은 회원가입 결과페이지입니다. </p>
<% request.setCharacterEncoding("UTF-8"); %>
이름 : ${param.name}<br/>
이메일 : ${param.email}<br/>
패스워드 : ${param.password}<br/>
</body>
</html>