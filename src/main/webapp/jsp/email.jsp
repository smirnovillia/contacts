

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>


        <h3>Email</h3>

        <form action="${pageContext.request.contextPath}/controller" method="GET">
            <input type="hidden" name="operation" value="SEND_EMAIL" />

            <table>
                <tbody>
                    <tr>
                        <td><label>Send to:</label></td>
                        <td><input type="text" name="recipient" value="${recipient}"/></td>
                    </tr>

                    <tr>
                        <td><label>Subject:</label></td>
                        <td><input type="text" name="subject" /></td>
                    </tr>

                    <tr>
                        <td><label>Text:</label></td>
                        <td><input type="text" name="message"/></td>
                    </tr>

                    <tr>
                        <td><label></label></td>
                        <td><input type="submit" value="Send"/></td>
                    </tr>

                    <tr>
                        <td><label></label></td>
                        <td><input type="reset" value="Cancel" /></td>
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
