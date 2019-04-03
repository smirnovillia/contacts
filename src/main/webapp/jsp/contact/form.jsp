<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Contact Form</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>

	<div id="container">
		<h3>Add Contact</h3>

		<form action="CommonServlet" method="POST">

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
						<td><label>Gender:</label></td>
						<td><input type="radio" name="gender" value="MALE" />Male</td>
						<td><input type="radio" name="gender" value="FEMALE" />Female</td>
					</tr>

					<tr>
						<td><label>Citizenship:</label></td>
						<td><input type="text" name="citizenship" /></td>
					</tr>

					<tr>
						<td><label>Marital Status:</label></td>
						<td><select name="maritalStatus">
								<option value="MARRIED">Married</option>
								<option value="SINGLE">Single</option>
								<option value="DIVORCED">Divorced</option>
								<option value="WIDOWED">Widowed</option>
						</select></td>
					</tr>

					<tr>
						<td><label>Website:</label></td>
						<td><input type="text" name="website" /></td>
					</tr>

					<tr>
						<td><label>Company:</label></td>
						<td><input type="text" name="company" /></td>
					</tr>

					<tr>
						<td><label>Country:</label></td>
						<td><input type="text" name="country" /></td>
					</tr>

					<tr>
						<td><label>City:</label></td>
						<td><input type="text" name="city" /></td>
					</tr>

					<tr>
						<td><label>Street:</label></td>
						<td><input type="text" name="street" /></td>
					</tr>

					<tr>
						<td><label>House Number:</label></td>
						<td><input type="text" name="houseNumber" /></td>
					</tr>

					<tr>
						<td><label>Apartment:</label></td>
						<td><input type="number" name="apartment" /></td>
					</tr>

					<tr>
						<td><label>Zip:</label></td>
						<td><input type="text" name="zip" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				</tbody>
			</table>
		</form>


		<p>
			<a href="list">Back to List</a>
		</p>
	</div>

</body>
</html>