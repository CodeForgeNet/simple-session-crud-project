<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h5>Registration - Form</h5>
	<div class="cont" >
		<form  id="myForm" action="registerForm" method="get" >
		
			<label for="id" >Id : </label><br>
			<input type="number" id="id" name="id" placeholder="enter id" ><br><br>
			
			<label for="name" >Name : </label><br>
			<input  id= "name" type="text" placeholder="enter name"  name="name" ><br><br>
			
			<label for="email" >Email : </label><br>
			<input id="email" type="email" placeholder="enter email"  name="email" ><br><br>
			
			<label for="password" >Password : </label><br>
			<input  id="password" type="password" placeholder="enter password"  name="password" ><br><br>
			
			
			<label>Mobile : </label><br>
			<input type="number" placeholder="enter mobile no"  name="phone" ><br><br>
			
			<label for="dob" >Date of Birth : </label><br>
			<input  id="dob" type="date"   name="dob" ><br><br>
			
			<input type="submit" value="register">

		</form>
		<br>
		<a href="Display.jsp">Display all student</a>

	</div>
</body>
</html>