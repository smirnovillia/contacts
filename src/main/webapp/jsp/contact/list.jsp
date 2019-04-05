<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<title>Contact App</title>

<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="container">
		<h3>List Contact</h3>
		
		<p>
			<a href="form.jsp">Add contact</a>
		</p>

		<form action="CommonServlet" method="GET">

			<input type="hidden" name="operation" value="ListContactOperation" />

			<table border="1">

				<tr>
					<th>Full name</th>
					<th>Birthday</th>
					<th>Address</th>
					<th>Company</th>
				</tr>
				<tbody>
				<%-- <c:forEach items="${contactList}" var="contact" >
					<tr> <td>${contact.firstName}</td> </tr>
					<tr> <td>${contact.birthday}</td> </tr>
					<tr> <td>${contact.country}</td> </tr>
					<tr> <td>${contact.company}</td> </tr>
				 </c:forEach> --%>

				</tbody>
			</table>
		</form>
	</div>
</body>


</html>