<%@ page pageEncoding="UTF-8" language="java" contentType="text/html charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
	First Name: <form:input path="firstName"/>
	<br> <br>
	Last Name: <form:input path="lastName"/>
	<br> <br>
	<form:button name="submit">Submit</form:button>
	</form:form>
</body>
</html>