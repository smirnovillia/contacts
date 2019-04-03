<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Contact App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="container">
	
		<div id="content">
		
			<input type="hidden" name="operation" value="ListContactOperation" />
			
			<table>
			
				<tr>
					<th>Full name</th>
					<th>Birthday</th>
					<th>Address</th>
					<th>Company</th>
				</tr>
				
				<c:forEach var="tempContact" items="${contactList}">
					
																		
					<tr>
						<td> ${tempContact.firstName} </td>
						<td> ${tempContact.birthday} </td>
						<td> ${tempContact.company} </td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>