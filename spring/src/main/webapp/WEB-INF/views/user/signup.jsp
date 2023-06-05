<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>SignUp Page</h1>
 <form action="/member/signup" method="post">
 	id : <input type="text" name="id">
 	pw : <input type="password" name="pw">
 	name : <input type="text" name="name">
 	email :<input type="text" name="email">
 	home :<input type="text" name="home">
 	age:<input type="text" name="age">
 	<button>회원가입</button>  	
</form>
</body>
</html>