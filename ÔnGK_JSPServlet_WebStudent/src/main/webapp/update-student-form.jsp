<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Edit Student Info Form</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<link type="text/css" rel="stylesheet" href="./css/style.css">
</head>
<body>
	<div id="wrapper">
		<div class="container">
			<div class="font-weight-bold text-success text-center">
				<h1>Edit Student Info Form</h1>
			</div>
			<form action="StudentControllerServlet" method="POST">
				<input type="hidden" name="command" value="UPDATE">
				<table>
				<tbody>
					<tr>
						<td><label>Student Id</label> </td>
						<td><input type="text" name="studentId" 
						value="${THE_STUDENT_NEW.id}" readonly /></td>
					</tr>
						<td><label>First Name:</label></td>
						<td><input type="text" name="firstName" value="${THE_STUDENT_NEW.firstName}"/></td>
					</tr>
					<tr>
						<td><label>Last Name:</label></td>
						<td><input type="text" name="lastName" value="${THE_STUDENT_NEW.lastName}" /></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><input type="text" name="email" value="${THE_STUDENT_NEW.email}"/></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="btn btn-success"/></td>
					</tr>
				</tbody>
			</table>
				
			</form>	
			<div style="clear: both;"></div>
			<p><a href="StudentControllerServlet">Back to List</a></p>
		</div>
	</div>

	<script type="text/javascript">
		var imgAvatar = document.getElementById("img-avatar");
		var imageUrl = document.getElementById("imageUrl");

		function imageUrlChanged() {
			var imageUrlLink = imageUrl.value;
			if (imageUrlLink) {
				imgAvatar.hidden = false;
			} else {
				imgAvatar.hidden = true;
			}
			imgAvatar.src = imageUrlLink;
		}
	</script>
</body>

</html>