<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Contact Form</title>
<link type="text/css" rel="stylesheet" href="css/save-style.css">
</head>
<body>

	<div id="container">
		<h3>Add Contact</h3>

		<form action="${pageContext.request.contextPath}/controller" method="POST">

			<input type="hidden" name="operation" value="SAVE_CONTACT" />
                        
                        <input type="hidden" name="contactId" value="${contact.id}"/>

			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><input type="text" name="firstName" value="${contact.firstName}"/></td>
					</tr>

					<tr>
						<td><label>Midle name:</label></td>
						<td><input type="text" name="midleName" value="${contact.midleName}" /></td>
					</tr>

					<tr>
						<td><label>Last name:</label></td>
						<td><input type="text" name="lastName" value="${contact.lastName}"/></td>
					</tr>

					<tr>
						<td><label>Birthday:</label></td>
						<td><input type="date" name="birthday" value="${contact.birthday}"/></td>
					</tr>

					<tr>
						<td><label>Gender:</label></td>
						<td><input type="radio" name="gender" value="MALE" ${contact.gender == 'MALE' ? 'checked' : ''} />Male</td>
						<td><input type="radio" name="gender" value="FEMALE" ${contact.gender == 'FEMALE' ? 'checked' : ''}/>Female</td>
					</tr>

					<tr>
						<td><label>Citizenship:</label></td>
						<td><input type="text" name="citizenship" value="${contact.citizenship}"/></td>
					</tr>

					<tr>
						<td><label>Marital Status:</label></td>
						<td><select name="maritalStatus">
								<option value ="MARRIED" ${contact.maritalStatus == 'MARRIED' ? 'selected' : ''}>Married</option>
								<option value ="SINGLE" ${contact.maritalStatus == 'SINGLE' ? 'selected' : ''}>Single</option>
								<option value ="DIVORCED" ${contact.maritalStatus == 'DIVORCED' ? 'selected' : ''}>Divorced</option>
								<option value ="WIDOWED" ${contact.maritalStatus == 'WIDOWED' ? 'selected' : ''}>Widowed</option>
						</select></td>
					</tr>

					<tr>
						<td><label>Website:</label></td>
						<td><input type="text" name="website" value="${contact.website}" /></td>
					</tr>
                                        
                                        <tr>
						<td><label>Email:</label></td>
						<td><input type="email" name="email" value="${contact.email}"/></td>
					</tr>

					<tr>
						<td><label>Company:</label></td>
						<td><input type="text" name="company" value="${contact.company}"/></td>
					</tr>

					<tr>
						<td><label>Country:</label></td>
						<td><input type="text" name="country" value="${contact.country}"/></td>
					</tr>

					<tr>
						<td><label>City:</label></td>
						<td><input type="text" name="city" value="${contact.city}"/></td>
					</tr>

					<tr>
						<td><label>Street:</label></td>
						<td><input type="text" name="street" value="${contact.street}"/></td>
					</tr>

					<tr>
						<td><label>House Number:</label></td>
						<td><input type="text" name="houseNumber" value="${contact.houseNumber}"/></td>
					</tr>

					<tr>
						<td><label>Apartment:</label></td>
						<td><input type="number" name="apartment" value="${contact.apartment}"/></td>
					</tr>

					<tr>
						<td><label>Zip:</label></td>
						<td><input type="text" name="zip" value="${contact.zip}"/></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				</tbody>
			</table>
		</form>


		<p>
			<a href="${pageContext.request.contextPath}/controller?operation=LIST_CONTACT">Back to List</a>
		</p>
	</div>

</body>
</html>