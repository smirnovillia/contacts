<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>



<link type="text/css" rel="stylesheet" href="css/list.css">

<input type="hidden" name="operation" value="LIST_CONTACT" />

<form action="${pageContext.request.contextPath}/controller" method="GET">

    <div class="button-container">
        <button type="button" class="button" onclick="window.location.href = '${pageContext.request.contextPath}/controller?operation=FORM_CONTACT'"><span>Add</span> </button>

        <button class="button" type="submit" name="operation" value="DELETE_CONTACT" onclick="form.action = '${pageContext.request.contextPath}/controller';"><span>Delete</span></button>

        <button class="button" type="submit" name="operation" value="FORM_EMAIL" onclick="form.action = '${pageContext.request.contextPath}/controller';"><span>Email</span></button>

    </div>

    <table class="list">

        <thead>
            <tr class="contact-row">
                <td></th>
                <td>Full name</th>
                <td>Birthday</th>
                <td>Address</th>
                <td>Company</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${contactList}" var="contact" >

                <tr class="contact-row">
                    <td><input type="checkbox" name="labeled" value="${contact.id}"></td>
                        <c:url var="contactLink" value="/controller">
                            <c:param name="operation" value="FORM_CONTACT"/>
                            <c:param name="contactId" value="${contact.id}"/>
                        </c:url>
                    <td><a href="${contactLink}">${contact.firstName} ${contact.midleName} ${contact.lastName}</td>
                    <td>${contact.birthday}</td> 
                    <td>   <c:choose>
                            <c:when test="${contact.apartment eq '0'}">
                                Postcode:${contact.zip}, Country:${contact.country}, City:${contact.city}, Street:${contact.street}, House:${contact.houseNumber}
                            </c:when>    
                            <c:otherwise>
                                Postcode:${contact.zip}, Country:${contact.country}, City:${contact.city}, Street:${contact.street}, House:${contact.houseNumber}, Apartment:${contact.apartment}
                            </c:otherwise>
                        </c:choose>
                    </td> 
                    <td>${contact.company}</td> 
                </tr>
            </c:forEach>

        </tbody>
    </table>
</form>