<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Send Email</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/email.css">



<div class="container">

    <h2>Email</h2>

    <form action="${pageContext.request.contextPath}/controller" method="GET">
        <input type="hidden" name="operation" value="SEND_EMAIL" />
        <div class="form-group">
            <label class="control-label" for="recipient">Send to</label>
            <input type="text" name="recipient" id="recipient" value="${recipient}">
        </div>
        <div class="form-group">
            <label class="control-label" for="subject">Subject</label>
            <input type="text" id="subject" name="subject">
        </div>
        <div class="form-group">
            <label class="control-label" for="message">Text</label>
            <textarea  rows="5" name="message" id="message"
                       maxlength="60"></textarea>
        </div>
        <div>
            <a class="button" href="${pageContext.request.contextPath}/controller?operation=LIST_CONTACT"><span>Back</span></a>
            <button class="button" type="reset"><span>Clear</span></button>
            <button class="button" type="submit"><span>Send</span></button>
        </div>
    </form>



</div>
</div>
