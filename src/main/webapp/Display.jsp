<%@page import="simple_session_crud_assignment.dao.CustomerDao"%>
<%@page import="java.util.List"%>
<%@page import="simple_session_crud_assignment.dto.Customer"%>
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
	List<Customer> customers = new CustomerDao().getAllCustomerDataDao();
	%>

	<div>
		<table border="2">
			<tr>
				<th>id</th>
				<th>Name</th>
				<th>email</th>
				<th>password</th>
				<th>mobile</th>
				<th>dob</th>
				<th colspan="2">Action</th>
			</tr>
			<%
			for (Customer customer : customers) {
			%>
			<tr>
				<td><%=customer.getId()%></td>
				<td><%=customer.getName()%></td>
				<td><%=customer.getEmail()%></td>
				<td>********</td>
				<td><%=customer.getDob()%></td>
				<td><%=customer.getPhone()%></td>
				<td><a href="Update.jsp?id=<%=customer.getId()%>"><button
							style="background-color: yellow">Update</button></a></td>
				<td><a href="delete?id=<%=customer.getId()%>"><button style="background-color: red">Delete</button></a></td>

			</tr>
			<%}%>
		</table>
	</div>
	<br>

	<a href="Register.jsp">Add more student</a><br><br>
	
	<a href="logout">Logout</a>
</body>
</html>