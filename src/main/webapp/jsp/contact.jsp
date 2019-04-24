<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<title>Contact Form</title>
<link type="text/css" rel="stylesheet" href="css/contact.css">
<link type="text/css" rel="stylesheet" href="css/modal.css">


<div class="container">
    <h2>Contact</h2>

    <form id="form" action="${pageContext.request.contextPath}/controller" method="POST">

        <input type="hidden" name="operation" value="SAVE_CONTACT">

        <input type="hidden" name="contactId" value="${contact.id}">

        <div class="form-group">
            <label class="control-label" for="firstName">First name</label>
            <input type="text" pattern = "^[a-zA-Z]+" name="firstName" value="${contact.firstName}" >
        </div>
        <div class="form-group">
            <label class="control-label" for="midleName">Midle name</label>
            <input type="text" pattern = "^[a-zA-Z]+" name="midleName" value="${contact.midleName}">
        </div>
        <div class="form-group">
            <label class="control-label" for="lastName">Last name</label>
            <input type="text" pattern = "^[a-zA-Z]+" name="lastName" value="${contact.lastName}" >
        </div>
        <div class="form-group">
            <label class="control-label" for="birthday">Birthday</label>
            <input type="date" name="birthday" value="${contact.birthday}" >
        </div>
        <div  class="form-radio gend">
            <div class="radio" id="gender">
                <label>
                    <input type="radio" name="gender" value="MALE" ${contact.gender == 'MALE' ? 'checked' : ''}><i class="helper"></i>Male
                </label>
                <label>
                    <input type="radio" name="gender" value="FEMALE" ${contact.gender == 'FEMALE' ? 'checked' : ''}><i class="helper"></i>Female
                </label>
            </div>
            <label class="control-label" for="gender">Gender</label>
        </div>
        <div class="form-group">
            <label class="control-label" for="citizenship">Citizenship</label>
            <input type="text" pattern="[a-zA-Z]+" name="citizenship" value="${contact.citizenship}" >
        </div>
        <div class="form-group">
            <select id="select" name="maritalStatus">
                <option value ="MARRIED" ${contact.maritalStatus == 'MARRIED' ? 'selected' : ''}>Married</option>
                <option value ="SINGLE" ${contact.maritalStatus == 'SINGLE' ? 'selected' : ''}>Single</option>
                <option value ="DIVORCED" ${contact.maritalStatus == 'DIVORCED' ? 'selected' : ''}>Divorced</option>
                <option value ="WIDOWED" ${contact.maritalStatus == 'WIDOWED' ? 'selected' : ''}>Widowed</option>
            </select>
            <label class="control-label" for="select">Marital status</label>
        </div>
        <div class="form-group">
            <label class="control-label" for="website">Website</label>
            <input type="text" pattern="^(?:http(s)?:\/\/)?[\w.-]+(?:\.[\w\.-]+)+[\w\-\._~:/?#[\]@!\$&'\(\)\*\+,;=.]+$" name="website" value="${contact.website}">
        </div>
        <div class="form-group">
            <label class="control-label" for="email">Email</label>
            <input type="email" pattern="(\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,6})" name="email" value="${contact.email}" >
        </div>
        <div class="form-group">
            <label class="control-label" for="company">Company</label>
            <input type="text" pattern = "([0-9A-Za-z])+" name="company" value="${contact.company}">
        </div>
        <div class="form-group">
            <label class="control-label" for="country">Country</label>
            <input type="text" pattern = "[a-zA-Z]+" name="country" value="${contact.country}" >
        </div>
        <div class="form-group">
            <label class="control-label" for="city">City</label>
            <input type="text" pattern="^[a-zA-Z]+(?:[\s-][a-zA-Z]+)*$" name="city" value="${contact.city}" >
        </div>
        <div class="form-group">
            <label class="control-label" for="street">Street</label>
            <input type="text" pattern="^[0-9a-zA-Z]+(?:[\s-][0-9a-zA-Z]+)*$" name="street" value="${contact.street}" >
        </div>
        <div class="form-group">
            <label class="control-label" for="houseNumber">House number</label>
            <input type="text" pattern="^\d+[a-zA-Z]*$" name="houseNumber" value="${contact.houseNumber}" >
        </div>
        <div class="form-group">
            <label class="control-label" for="apartment">Apartment</label>
            <input type="number" pattern="[\d]+" name="apartment" value="${contact.apartment}">
        </div>
        <div class="form-group">
            <label class="control-label" for="zip">Zip</label>
            <input type="text" pattern="\d{6}" name="zip" value="${contact.zip}" >
        </div>

        <div>

            <h2>Phones</h2>

            <div style="float:right;">
                <button type="button" class="button" onclick="addPhone()" ><span>Add</span></button>
                <button type="button" class="button" onclick="deletePhone()" ><span>Delete</span></button>
            </div>

            <div> 
                <table class="list" id="phoneTable">
                    <thead>
                        <tr>
                            <td></td>
                            <td>Phone number</td>
                            <td>Phone type</td>
                            <td>Comment</td>
                        </tr>

                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>



        <br><br>

        <div>
            <h2>Files</h2>

            <div style="float:right;">
                <button type="button" class="button" onclick="addFile()" ><span>Add</span></button>
                <button type="button" class="button" onclick="deleteFile()" ><span>Delete</span></button>
            </div>

            <div> 
                <table class="list" id="fileTable">
                    <thead>
                        <tr>
                            <td></td>
                            <td>File name</td>
                            <td>File upload</td>
                            <td>Comment</td>
                        </tr>

                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>




        <div>
            <a class="button" href="${pageContext.request.contextPath}/controller?operation=LIST_CONTACT"><span>Back to List</span></a>
            <button class="button" form="form" type="submit" id="submitForm"/><span>Save</span></button>
        </div>


    </form>
</div>


<div id="phonePopup" class="overlay">
    <div class="popup">
        <div>
            <span class="close">&times;</span>
            <h2>Phone form</h2>
        </div>

        <div class="form-group">
            <label class="control-label" for="countryCode">Country code</label>
            <input  type="text" id="countryCode" name="countryCode" required>
        </div>

        <div class="form-group">
            <label class="control-label" for="operatorCode">Operator code</label>
            <input type="text" id="operatorCode" name="operatorCode" required>
        </div>

        <div class="form-group">
            <label class="control-label" for="phoneNumber">Phone number</label>
            <input type="text" id="phoneNumber" name="phoneNumber" required>
        </div>

        <div class="form-group">
            <label class="control-label" for="phoneType">Phone type</label>
            <select name="phoneType" id="phoneType">
                <option value="HOME">Home</option>
                <option value="MOBILE">Mobile</option>
                <option value="WORK">Work</option>
            </select>
        </div>

        <div class="form-group">
            <label class="control-label" for="phoneComment">Comment</label>
            <textarea  rows="5" name="phoneComment" id="phoneComment"
                       maxlength="60"></textarea>
        </div>

        <button class="button" onclick="savePhone()" ><span>Save</span></button>

    </div>
</div>

<div id="filePopup" class="overlay">
    <div class="popup" id="fileForm">
        <div>
            <span class="close">&times;</span>
            <h2>File form</h2>
        </div>

        <div class="form-group" id="file-container">
            <label class="control-label" for="real-input">Upload file</label>
            <div class="input-container">
                <input type="file" id="real-input" onchange="getFileName()" required>
                <button class="browse-button" id="browse-btn"><span>Browse Files</span></button>
            </div>

        </div>


        <div class="form-group" id="file-comment">
            <label class="control-label" for="fileComment">Comment</label>
            <textarea  rows="5" name="fileComment" id="fileComment"
                       maxlength="60"></textarea>
        </div>

        <button class="button" onclick="saveFile()" ><span>Save</span></button>

    </div>
</div>       

<script type="text/javascript" charset="utf-8" src="js/contact.js"></script>



