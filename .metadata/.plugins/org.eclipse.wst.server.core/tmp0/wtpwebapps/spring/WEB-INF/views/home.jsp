<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  My Spring Project </P>

<a href="/member/signup"><button type="button" >회원가입</button></a>
<script type="text/javascript">
	const msg_home = '<c:out value="${msg_home}"/>';
	console.log(msg_home);
	if(msg_home==1){
		alter('welcom');
	}
</script>
</body>
</html>