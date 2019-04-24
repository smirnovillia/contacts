var attachmentService = {

    saveAttach: function () {
        var form = document.getElementById("attachmentForm");

        var table = window.opener.document.getElementById("attachTable");

        var row = table.insertRow(-1);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);

        var fileName = document.getElementById("fileUpload").value;

        var today = new Date();
        var dd = today.getDate();
        var MM = today.getMonth() + 1;
        var yyyy = today.getFullYear();
        
        var uploadDate = dd+'-'+ MM + '-'+yyyy;

        cell1.innerHTML = '<input type="checkbox" name="attachments">';
        cell2.innerHTML = '<input type="text" name="fileName" value="' + fileName + '">';
        cell3.innerHTML = '<input type="text" name="comment" value="' + form.comment + '" readonly>';

        form.submit();
        window.close();
    },

    deleteAttach: function () {
        var table = document.getElementById("attachTable");
        var checkboxes = document.getElementsByName("attachments"), length = checkboxes.length;

        for (var i = length - 1; i >= 0; i--) {
            if (checkboxes[i].type == "checkbox" && checkboxes[i].checked) {
                table.deleteRow(i);
            }
        }
    },

    addAttach: function () {
        openAttachPopUp();
    },

    cancelAttach: function () {
        document.getElementById("attachmentForm").reset();
        window.close();
    }
};

function countChecked(checkboxes) {
    count = 0;
    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].type == "checkbox" && checkboxes[i].checked == true) {
            count++;
        }
    }
    return count;
}

function openAttachPopUp() {
    let height = 300;
    let width = 600;
    let left = (screen.width / 2) - (width / 2);
    let top = (screen.height / 2) - (height / 2);
    let param = "height=" + height + ",width=" + width + ",left=" + left + ",top=" + top + "," + "resizable=yes,scrollbars=yes,toolbar=yes,status=yes";
    let newWindow = window.open("jsp/attachment.jsp", "attachmentPage", param);
    newWindow.focus();

}





