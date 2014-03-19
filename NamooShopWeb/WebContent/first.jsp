<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@
	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 이것은 HTML 주석입니다. 아래는 설명입니다. -->
	<%-- 이것은 JSP주석입니다. HTML로 변환되면 보이지 않습니다. --%>
	<h1>성공</h1>
	<%
		pageContext.setAttribute("name", "홍길동");
	%>
	<%@ include file="number_table.jsp"%>
	<%-- <jsp:include page="number_table.jsp" /> --%>

	<%!int number = 10;%>
	<%
		request.setAttribute("myName", "이현진");
	%>
	이것은 EL로 출력한 숫자 : ${myName}

	<%=request.getAttribute("myName")%><br />
	<%=request.getParameter("dan")%>
	${param.dan}
	<%-- 스크립틀릿 --%>
 	<c:choose>
 	
 		<c:when test="${param.dan == As}">
			<c:forEach var="num" begin="1" end="9" step="1">
			${param.dan} * ${num} = ${num*param.dan} <br />
			</c:forEach>
		</c:when>
		
		<c:when test="${param.dan >= 2 && param.dan <= 9}">
			<c:forEach var="num" begin="1" end="9" step="1">
			${param.dan} * ${num} = ${num*param.dan} <br />
			</c:forEach>
		</c:when>
		
		
		<c:otherwise>
	올바른 숫자를 입력하세요!
	</c:otherwise>
	</c:choose>


</body>
</html>