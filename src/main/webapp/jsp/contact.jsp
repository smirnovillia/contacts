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

                <div>
                    <label>First name:</label>
                    <input type="text" name="firstName" value="${contact.firstName}"/>
                </div>
                <div>
                    <label>Midle name:</label>
                    <input type="text" name="midleName" value="${contact.midleName}" />
                </div>
                <div>
                    <label>Last name:</label>
                    <input type="text" name="lastName" value="${contact.lastName}"/>
                </div>
                <div>
                    <label>Birthday:</label>
                    <input type="date" name="birthday" value="${contact.birthday}"/>
                </div>
                <div>
                    <label>Gender:</label>
                    <input type="radio" name="gender" value="MALE" ${contact.gender == 'MALE' ? 'checked' : ''} />Male
                    <input type="radio" name="gender" value="FEMALE" ${contact.gender == 'FEMALE' ? 'checked' : ''}/>Female
                </div>
                <div>
                    <label>Citizenship:</label>
                    <input type="text" name="citizenship" value="${contact.citizenship}"/>
                </div>
                <div>
                    <label>Marital Status:</label>
                    <select name="maritalStatus">
                        <option value ="MARRIED" ${contact.maritalStatus == 'MARRIED' ? 'selected' : ''}>Married</option>
                        <option value ="SINGLE" ${contact.maritalStatus == 'SINGLE' ? 'selected' : ''}>Single</option>
                        <option value ="DIVORCED" ${contact.maritalStatus == 'DIVORCED' ? 'selected' : ''}>Divorced</option>
                        <option value ="WIDOWED" ${contact.maritalStatus == 'WIDOWED' ? 'selected' : ''}>Widowed</option>
                    </select>
                </div>
                <div>
                    <label>Website:</label>
                    <input type="text" name="website" value="${contact.website}" />
                </div>
                <div>
                    <label>Email:</label>
                    <input type="email" name="email" value="${contact.email}"/>
                </div>
                <div>
                    <label>Company:</label>
                    <input type="text" name="company" value="${contact.company}"/>
                </div>
                <div>
                    <label>Country:</label>
                    <input type="text" name="country" value="${contact.country}"/>
                </div>
                <div>
                    <label>City:</label>
                    <input type="text" name="city" value="${contact.city}"/>
                </div>
                <div>
                    <label>Street:</label>
                    <input type="text" name="street" value="${contact.street}"/>
                </div>
                <div>
                    <label>House Number:</label>
                    <input type="text" name="houseNumber" value="${contact.houseNumber}"/>
                </div>
                <div>
                    <label>Apartment:</label>
                    <input type="number" name="apartment" value="${contact.apartment}"/>
                </div>
                <div>
                    <label>Zip:</label>
                    <input type="text" name="zip" value="${contact.zip}"/>
                </div>
                <div>
                    <label></label>
                    <input type="submit" value="Save" class="save" />
                </div>
            </form>
            <div> 
                
                <a onclick="addPhone()"/>
                
                <table>
                    <thead>
                        <tr>
                            <td>
                            </td>
                            <td>
                                <label>Phone number</label>
                            </td>
                            <td>
                                <label>Phone type</label>
                            </td>
                            <td>
                                <label>Comment</label>
                            </td>
                            
                        </tr>

                    </thead>
                    <tbody id="phoneTable">
                        <tr>
                            <td><input type ="checkbox" name="labeledPhone" value="${phone.id}"></td>
                            <td><input type="text" name="phoneNumber" value="${phone.countryCode}${phone.operatorCode}${phone.phoneNumber}"></td>
                            <td><input type="text" name="phoneType" value="${phone.phoneType}"></td>
                            <td><input type="text" name="comment" value="${phone.comment}"></td>
                        </tr>
                    </tbody>
                </table>
            </div>

            <div>
                <table id="attachmentTable">
                    <thead>

                    </thead>
                    <tbody>

                    </tbody>

                </table>
            </div>

        <p>
            <a href="${pageContext.request.contextPath}/controller?operation=LIST_CONTACT">Back to List</a>
        </p>
    </div>

</body>
</html>