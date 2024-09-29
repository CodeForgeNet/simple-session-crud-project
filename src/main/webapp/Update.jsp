<%@page import="simple_session_crud_assignment.dto.Customer"%>
<%@page import="simple_session_crud_assignment.dao.CustomerDao"%>
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
		int id = Integer.parseInt(request.getParameter("id"));
		Customer customer = new CustomerDao().getCustomerByIdDao(id);
	%>
	
	<form action="customerUpdate" method = "post">
		<label>Id : </label><br>
		<input type = "number" name = "id" value ="<%=customer.getId()%>" ><br><br>
		
		<label>Name : </label><br>
		<input type = "text" name = "name" value ="<%=customer.getName()%>" ><br><br>
		
		<label>Email : </label><br>
		<input type = "text" name = "email" value ="<%=customer.getEmail()%>" ><br><br>
		
		<label>Password : </label><br>
		<input type = "text" name = "password" value ="<%=customer.getPassword()%>" ><br><br>
		
		<label>Mobile : </label><br>
		<input type = "number" name = "phone" value ="<%=customer.getPhone()%>" ><br><br>
		
		<label>DOB : </label><br>
		<input type = "date" name = "dob" value ="<%=customer.getDob()%>" ><br><br>
		
		<input type="submit" value = "update">
		
	</form>
	
</body>
</html>