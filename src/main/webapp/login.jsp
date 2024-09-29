<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String msg = (String)request.getAttribute("msg");
	%>
	<form action="loginController" method="post">
	
	<%if(msg!=null){%> <h4><%=msg%></h4><%}%>
	
		<label>UserName : </label><br> 
		<input type="text"placeholder="enter username" name="username"><br> 
		
		<label>Password: </label><br> 
		<input type="password" placeholder="enter password" name="password"><br>
		
		<input type="submit" value="submit">
		
	</form>
</body>
</html>