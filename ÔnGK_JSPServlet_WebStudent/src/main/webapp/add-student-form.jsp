<!DOCTYPE html>
<html>

	<head>
		<title>Add Student</title>
		<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
		<link type="text/css" rel="stylesheet" href="css/style.css">
	</head>

<body>
	<div id="container">
		<div class="pt-2 pb-2 font-weight-bold text-success text-center">
			<h1>Add Student Form</h1>
		</div>
		<form action="StudentControllerServlet" method="GET">
			<input type="hidden" name="command" value="ADD"/>
			<table>
				<tbody>
					<tr>
						<td><label>First Name: </label></td>
						<td><input type="text" name="firstName"/></td>
					</tr>
					<tr>
						<td><label>Last Name: </label></td>
						<td><input type="text" name="lastName"/></td>
					</tr>
					<tr>
						<td><label>Email: </label></td>
						<td><input type="email" name="email"/></td>
					</tr>
					<tr>
						<td><label for="imageUrl">Url image</label></td>
						<td><input type="text" name="imageUrl" class="form-control" id="imageUrl"
									placeholder="Link avatar" onchange="imageUrlChanged();" />
						</td>
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
	
</body>

</html>