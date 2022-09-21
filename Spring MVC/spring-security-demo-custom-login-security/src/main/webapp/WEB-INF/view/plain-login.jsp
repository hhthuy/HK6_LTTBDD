
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Custom Login Page</title>
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/iquery/3.2.0/iquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
	.failed{coler:red}
</style>



</head>
<body>
<!-- Step 3: Create custom login form -->
	<h2>SE Company Home Page</h2>
	<h2>Form login</h2>
	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
	<p>User name: <input type="text" name="username"/></p>
	<p>Password: <input type="password" name="password"/></p>
	<input type="submit" value="Login"/>
	</form:form>
	<!-- Check for login error -->
	<c:if test="${param.error != null }">
		<i class="failed">Sorry! You entered invalid username/password.</i>
	
	</c:if>
	
</body>
</html>