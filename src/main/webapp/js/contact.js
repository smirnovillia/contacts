var phonePopup = document.getElementById('phonePopup');
var filePopup = document.getElementById('filePopup');
const realInput = document.getElementById('real-input');
const uploadButton = document.getElementById('browse-btn');
var phonePopupCount = 0;
var filePopupCount = 0;

var phoneFormClose = document.getElementsByClassName("close")[0];
var fileFormClose = document.getElementsByClassName("close")[1];

window.onclick = function (event) {
    if (event.target == phonePopup) {
        phonePopup.style.display = 'none';
    }
    if (event.target == filePopup) {
        filePopup.style.display = 'none';
    }
}

phoneFormClose.onclick = function () {
    phonePopup.style.display = 'none';
}

fileFormClose.onclick = function () {
    filePopup.style.display = 'none';
}

function savePhone() {
//    var codeRegex = new RegExp("^[0-9]{1,4}$");
//    var numberRegex = new RegExp("^[0-9]{7,10}$");

    var countryCode = document.getElementById('countryCode').value;
    var operatorCode = document.getElementById('operatorCode').value;
    var phoneNumber = document.getElementById('phoneNumber').value;
    var phoneType = document.getElementById('phoneType').value;
    var phoneComment = document.getElementById('phoneComment').value;

//    if (!codeRegex.test(countryCode) || !codeRegex.test(operatorCode) || !numberRegex.test(phoneNumber)) {
//        var countryCodeInput = document.getElementById('countryCode');
//        var operatorCodeInput = document.getElementById('operatorCode');
//        var phoneNumberInput = document.getElementById('phoneNumber');
//
//        if (!codeRegex.test(countryCode)) {
//            countryCodeInput.setAttribute("color", "margin-right: 2%;width:15%;color:red;");
//        }
//        if (!codeRegex.test(operatorCode)) {
//            operatorCodeInput.setAttribute("color", "margin-right: 2%;width:15%;color:red;")
//        }
//        if (!numberRegex.test(phoneNumber)) {
//            phoneNumberInput.setAttribute("color", "margin-right: 2%;width:15%;color:red;")
//        }
//        return;
//    }

    var table = document.getElementById("phoneTable").getElementsByTagName("tbody")[0];

    var row = table.insertRow(-1);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);
    var cell6 = row.insertCell(5);
    var cell7 = row.insertCell(6);

    cell1.innerHTML = '<input type="checkbox" name="phoneId" value="' + phonePopupCount + '" id="phone' + phonePopupCount + '">';

    var fullPhone = "+" + countryCode + " " + operatorCode + " " + phoneNumber;

    cell2.innerHTML = '<input type="text" name="fullPhone" value="' + fullPhone + '" readonly>';
    cell3.innerHTML = '<input type="text" name="phoneType' + phonePopupCount + '" value="' + phoneType + '" readonly>';
    cell4.innerHTML = '<input type="text" name="phoneComment' + phonePopupCount + '" value="' + phoneComment + '" readonly>';
    cell5.innerHTML = '<input type="hidden" name="countryCode' + phonePopupCount + '" value="' + countryCode + '">';
    cell6.innerHTML = '<input type="hidden" name="operatorCode' + phonePopupCount + '" value="' + operatorCode + '">';
    cell7.innerHTML = '<input type="hidden" name="phoneNumber' + phonePopupCount + '" value="' + phoneNumber + '">';


    phonePopup.style.display = 'none';
}

function deletePhone() {
    var table = document.getElementById("phoneTable").getElementsByTagName("tbody")[0];
    var checkboxes = document.getElementsByName("phones"), length = checkboxes.length;

    for (var i = length - 1; i >= 0; i--) {
        if (checkboxes[i].type == "checkbox" && checkboxes[i].checked) {
            table.deleteRow(i);
        }
    }
}

function addPhone() {
    if (phonePopupCount != 0) {
        clearFields(phonePopup);
    }
    phonePopup.style.display = 'block';
    phonePopupCount++;

}


function countChecked(checkboxes) {
    count = 0;
    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].type == "checkbox" && checkboxes[i].checked == true) {
            count++;
        }
    }
    return count;
}

var fileForm = document.getElementById('fileForm');

function addFile() {
    if (filePopupCount != 0) {
        clearFields(filePopup);
        document.getElementById("file-name").remove();
    }

    filePopup.style.display = 'block';
    filePopupCount++;
}

uploadButton.addEventListener('click', () => {
    realInput.click();
});

function saveFile() {
    var fullpath = document.getElementById('real-input').value;
    var backslash = fullpath.lastIndexOf("\\");
    var fileName = fullpath.substr(backslash + 1);
    var fileComment = document.getElementById('fileComment').value;
    var upload = new Date();



    var table = document.getElementById("fileTable").getElementsByTagName("tbody")[0];

    var row = table.insertRow(-1);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);

    cell1.innerHTML = '<input type="checkbox" name="fileId" value="' + filePopupCount + '" id="file' + filePopupCount + '">';

    cell2.innerHTML = '<input type="text" name="fileName' + filePopupCount + '" value="' + fileName + '" readonly>';
    cell3.innerHTML = '<input type="text" name="upload' + filePopupCount + '" value="' + upload + '" readonly>';
    cell4.innerHTML = '<input type="text" name="fileComment' + filePopupCount + '" value="' + fileComment + '" readonly>';
    cell5.innerHTML = '<input type="hidden" name="file' + filePopupCount + '" value="' + realInput + '">';

    filePopup.style.display = 'none';



}

function clearFields(container) {

    var fields = container.getElementsByTagName('input');
    for (var i = 0, len = fields.length; i < len; i++) {
        var field = fields[i];
        switch (field.type)
        {
            case 'text':
            case 'file':
            case 'hidden':
                field.value = ''
        }
    }

    var fields = container.getElementsByTagName('textarea');
    for (var i = 0, len = fields.length; i < len; i++) {
        fields[i].value = ''
    }
}

function getFileName() {

    var fullpath = document.getElementById('real-input').value;
    var backslash = fullpath.lastIndexOf("\\");
    var fileName = fullpath.substr(backslash + 1);
    var divFileName = document.createElement('div');

    divFileName.setAttribute('class', 'form-group');
    divFileName.setAttribute('id', 'file-name');
    fileForm.insertBefore(divFileName, fileForm.children[2]);

    var fileInput = document.createElement('input');
    fileInput.setAttribute('type', 'text');
    fileInput.setAttribute('name', 'fileName');
    fileInput.setAttribute('id', 'fileName');
    fileInput.setAttribute('value', fileName);
    fileInput.setAttribute('readonly', '');
    divFileName.appendChild(fileInput);

    var label = document.createElement('label');
    label.setAttribute('class', 'control-label');
    label.setAttribute('for', 'fileName');
    label.innerHTML = "File name";
    divFileName.appendChild(label);
}






