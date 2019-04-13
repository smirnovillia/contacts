<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html>
<html>

    <head>
        <title>Contact App</title>

        <link type="text/css" rel="stylesheet" href="css/style.css">
    </head>

    <body>
        <a onclick="window.location.href = '${pageContext.request.contextPath}/controller?operation=FORM_CONTACT'"
           /> Add contact </a>

    <input type="hidden" name="operation" value="LIST_CONTACT" />

    <form action="${pageContext.request.contextPath}/controller" method="GET">

        <input type="submit" name="operation" value="DELETE_CONTACT" onclick="form.action = '${pageContext.request.contextPath}/controller';">
        
        <input type="submit" name="operation" value="FORM_EMAIL" onclick="form.action = '${pageContext.request.contextPath}/controller';">

        <table border="1">

            <tr>
                <th></th>
                <th>Full name</th>
                <th>Birthday</th>
                <th>Address</th>
                <th>Company</th>
            </tr>
            <tbody>
                <c:forEach items="${contactList}" var="contact" >

                    <tr>
                        <td><input type="checkbox" name="labeled" value="${contact.id}"></td>
                            <c:url var="contactLink" value="/controller">
                                <c:param name="operation" value="FORM_CONTACT"/>
                                <c:param name="contactId" value="${contact.id}"/>
                            </c:url>
                        <td><a href="${contactLink}">${contact.firstName} ${contact.midleName} ${contact.lastName}</td>
                        <td>${contact.birthday}</td> 
                        <td>${contact.zip}, ${contact.country}, ${contact.city}, ${contact.street}, ${contact.houseNumber}, ${contact.apartment}</td> 
                        <td>${contact.company}</td> 
                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </form>
</body>


</html>