<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/phone.js"></script>
    </head>
    <body>
           <div id="phonePopUp">
            <div id="tt">
                <div class="container">
                    <form id="phoneForm">

                        <div>
                            <label  for="countryCode">Country code:</label>
                            <div >
                                <input  type="text" id="countryCode"
                                        name="countryCode" placeholder="Country code">
                            </div>
                        </div>

                        <div >
                            <label for="operatorCode">Operator code:</label>
                            <div >
                                <input type="text" id="operatorCode" name="operatorCode"
                                       placeholder="Operator code" required>
                            </div>
                        </div>

                        <div>
                            <label for="phoneNumber">Phone number:</label>
                            <div>
                                <input type="text" id="phone" name="phoneNumber" placeholder="Phone number" required>
                            </div>
                        </div>

                        <div>
                            <label for="phoneType">Phone type:</label>
                            <div>
                                <select name="phoneType" id="phoneType">
                                    <option>Home</option>
                                    <option>Mobile</option>
                                    <option>Work</option>
                                </select>
                            </div>
                        </div>

                        <div>
                            <label for="comment">Comment:</label>
                            <div>
                                <textarea  rows="5" name="comment" id="comment"
                                           maxlength="60"  placeholder="Type your comment..."></textarea>
                            </div>
                        </div>
                    </form>

                    <button  onclick="phoneService.savePhone()" >Save</button>
                    <button onclick="phoneService.cancelPhone()" >Cancel</button>
                </div>
            </div>
        </div>
    </body>
</html>
