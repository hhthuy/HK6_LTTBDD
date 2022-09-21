<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Tracker App</title>

	<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<link type="text/css" rel="stylesheet" href="./css/style.css">
</head>
<body>
	<div id ="wrapper">
		<div class="container">
			<div class="header pt-3 pb-3 font-weight text-white bg-primary">
				<h1>Football 24University</h1>
			</div>
			
			<div class="control mt-3">
				<button type="button" class="btn btn-primary"
				onclick="window.location.href='add-student-form.jsp';return false;">
				Add Student</button>
			</div>
			
			<div class="show-data mt-3">
				<table class="table table-striped table-hover" >
					<thead class="bg-primary">
						<th>Student Id</th>
						<th>First name</th>
						<th>Last name</th>
						<th>Email</th>
						<th>Avatar</th>
						<th>Action</th>
					</thead>
					</tbody>
					<c:forEach var="tempStudent" items="${STUDENT_LIST}">
						<c:url var="tempLink" value="StudentControllerServlet">
							<c:param name="command" value="LOAD"></c:param>
							<c:param name="studentId" value="${tempStudent.id}"></c:param>
						</c:url>
						<c:url var="deleteLink" value="StudentControllerServlet">
							<c:param name="command" value="DELETE"></c:param>
							<c:param name="studentId" value="${tempStudent.id}"></c:param>
						</c:url>
					
						<!-- xuất thông tin -->
						<tr>
							<td>${tempStudent.id}</td>
							<td>${tempStudent.firstName}</td>
							<td>${tempStudent.lastName}</td>
							<td>${tempStudent.email}</td>
							<td>
								<img src="${tempStudent.imageUrl}" width="50", height="50" class="rounded"/>
							</td>
							<td>
								<a href="${tempLink}">Edit|</a>
								<a href="${deleteLink}"
								onclick="if (!confirm('Are you sure you want to delete this student?')) { return false; }">Delete </a>						
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div><!--show-data-->
		</div><!--container -->
	</div><!-- wrapper -->


</body>
</html>