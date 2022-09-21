<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello World - Input Form</title>
</head>
<body>
 <h3>Read HTML Form data</h3>
 
 <h4 color="#0000FF">C1: Mapping to Controller method</h4>
 <form action="processForm" method="post">
 	<input type="text" name="studentName" placeholder="What's your name"/>
 	<input type="submit"/>
 </form>
 
 <h4 color="#0000FF">C2: Passing Model to Controller</h4>
  <form action="processFormVersionTwo" method="post">
 	<input type="text" name="studentName" placeholder="What's your name"/>
 	<input type="submit"/>
 </form>
 
  <h4 color="#0000FF">C3: Read HTML Form data with @RequestParam</h4>
  <form action="processFormVersionThree" method="post">
 	<input type="text" name="studentName" placeholder="What's your name"/>
 	<input type="submit"/>
 </form> 
</body>
</html>