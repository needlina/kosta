<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>두번째 JSP입니다.</h1>
	<p>설명 ㄹㅇㄹㅇㄹㅇㅇㅁㄹㅇㄻㅇㄹㄴ</p>
	<% request.setCharacterEncoding("UTF-8"); %>
	
<% pageContext.setAttribute("name", "홍길동2"); %>	
<%-- <%@ include file="number_table.jsp" %> --%>
<jsp:include page="number_table.jsp">
<jsp:param value="파라미터로 전달한 홍길동2" name="name"/>
</jsp:include>
</body>
</html>