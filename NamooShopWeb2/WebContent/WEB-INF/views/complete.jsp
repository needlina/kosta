<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet' type='text/css' href='./style.css'/>
<title>주문 완료</title>
<!-- <style type="text/css">
#complete {
margin-left: 70px;
width: 700px;
height: 150px;
border: 3px solid #D1B2FF;
border-radius: 5px 5px 5px 5px;
background-color: white;
	color: #D1B2FF;
}
#complete h1 {
text-align: center;
}

#complete #button {
width: 100px;
height: 30px;
margin-top: 3%;
margin-left: 40%;
margin-right: 40%
}




</style> -->



</head>
<body>
	<form action="main.xhtml" method="post">
		<div id='complete'>
			<h1>상품 주문이 완료되었습니다.</h1>
			<input type="submit" id="button" value="확인">
		</div>
	</form>
</body>
</html>