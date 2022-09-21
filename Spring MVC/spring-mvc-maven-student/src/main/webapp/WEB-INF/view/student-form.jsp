<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student - Input Form</title>
</head>
<body>
 	<form:form action="processForm" modelAttribute="student"><!-- theModel.addAttribute("student", theStudent); -->
 		First Name: <form:input path="firstName"/><br><br><!--class Student: firstName -gọi- student.getFistName() -->
 		Last Name: <form:input path="lastName"/><br><br>
 		
 	<form:select path="country">
 		<form:option value="Brazil" label="Brazil"/>
    	<form:option value="France" label="France"/>
    	<form:option value="Germany" label="Germany"/>
    	<form:option value="VietNam" label="VietNam"/>
    </form:select>
     <br><br>
    Favorite Language:
    Java<form:radiobutton path="favoriteLanguage" value="Java"/>
    Csharp<form:radiobutton path="favoriteLanguage" value="Csharp"/>
    PHP<form:radiobutton path="favoriteLanguage" value="PHP"/>
    Python<form:radiobutton path="favoriteLanguage" value="Python"/>
    Ruby<form:radiobutton path="favoriteLanguage" value="Ruby"/>
    
    <br><br>
    Operating Systems:
    Linux <form:checkbox path="operatingSystems" value="Linux"/>
    Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
    MS Windows<form:checkbox path="operatingSystems" value="MS Windows"/>
   <br><br>
    <input type="submit" value="submit"/>
    </form:form>
</body>
</html>