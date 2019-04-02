<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="container">
		<h3>Add Contact</h3>

		<form action="CommonServlet" method="GET">

			<input type="hidden" name="operation" value="AddContactOperation" />

			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><input type="text" name="firstName" /></td>
					</tr>

					<tr>
						<td><label>Midle name:</label></td>
						<td><input type="text" name="midleName" /></td>
					</tr>

					<tr>
						<td><label>Last name:</label></td>
						<td><input type="text" name="lastName" /></td>
					</tr>

					<tr>
						<td><label>Birthday:</label></td>
						<td><input type="date" name="birthday" /></td>
					</tr>

					<tr>
						<td><label>Birthday:</label></td>
						<td><input type="radio" name="gender" /></td>
					</tr>
					
					<tr>
						<td><label>Citizenship:</label></td>
						<td><input type="text" name="citizenship" /></td>
					</tr>
					
					<tr>
						<td><label>Website:</label></td>
						<td><input type="text" name="website" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				</tbody>
			</table>
		</form>


		<p>
			<a href="/contact/list.jsp">Back to List</a>
		</p>
	</div>

</body>
</html>