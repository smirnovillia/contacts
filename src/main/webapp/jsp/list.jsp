<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

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
                <a href="${pageContext.request.contextPath}/jsp/contact.jsp">Add contact</a>
            </p>

            <form action="${pageContext.request.contextPath}/controller" method="GET">

                <input type="hidden" name="operation" value="LIST_CONTACT" />

                <table border="1">

                    <tr>
                        <th>Full name</th>
                        <th>Birthday</th>
                        <th>Address</th>
                        <th>Company</th>
                    </tr>
                    <tbody>
                        <c:forEach items="${contactList}" var="contact" >
                            <tr> <td>${contact.getFullName()}</td>
                                <td>${contact.birthday}</td> 
                                <td>${contact.getFullAddress()}</td> 
                                <td>${contact.company}</td> 
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </form>
        </div>
    </body>


</html>