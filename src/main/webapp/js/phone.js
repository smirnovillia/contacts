var phoneService = {
    pos: 0,
    mode: 0,

    savePhone: function () {
        var form = document.getElementById("phoneForm");
        if (!(form.operatorCode.value && form.phone.value)) {
            alert("Please, fill required fields");
            return false;
        }

        var table = window.opener.document.getElementById("phoneTable");

        var i, row, cell1, cell2, cell3, cell4, cell5, cell6, cell7;

        if (this.mode == 0) {
            i = table.rows.length;
            row = table.insertRow(i);
            cell1 = row.insertCell(0);
            cell2 = row.insertCell(1);
            cell3 = row.insertCell(2);
            cell4 = row.insertCell(3);
            cell5 = row.insertCell(4);
            cell6 = row.insertCell(5);
            cell7 = row.insertCell(6);
        } else {
            i = this.pos;
            row = table.rows[i];
            cell1 = row.cells[0];
            cell2 = row.cells[1];
            cell3 = row.cells[2];
            cell4 = row.cells[3];
            cell5 = row.cells[4];
            cell6 = row.cells[5];
            cell7 = row.cells[6];
        }

        cell1.innerHTML = "<input type='checkbox'  name='phones'/>";

        var fullPhone = form.countryCode.value + " " + form.operatorCode.value + " " + form.phoneNumber.value;

        cell2.innerHTML = "<input type='text' form='form' value='" + fullPhone + "' readonly/>";
        cell3.innerHTML = "<input type='text' form='form' name='phoneType" + i + "' value='" + form.phoneType.value + "' readonly/>";
        cell4.innerHTML = "<input type='text' form='form' name='comment" + i + "' value='" + form.comment.value + "' readonly/>";
        cell5.innerHTML = "<input type='hidden' form='form' name='countryCode" + i + "' value='" + form.countryCode.value + "' />";
        cell6.innerHTML = "<input type='hidden' form='form' name='operatorCode" + i + "' value='" + form.operatorCode.value + "' />";
        cell7.innerHTML = "<input type='hidden' form='form' name='phoneNumber" + i + "' value='" + form.phoneNumber.value + "' />";
        window.close();
    },

    deletePhone: function () {
        var table = document.getElementById("phoneTable");
        var checkboxes = document.getElementsByName('phones'), length = checkboxes.length;

        for (var i = length - 1; i >= 0; i--) {
            if (checkboxes[i].type == "checkbox" && checkboxes[i].checked) {
                table.deleteRow(i);
            }
        }
    },

    editPhone: function () {

        var form = document.getElementById("phoneForm");
        var table = document.getElementById("phoneTable");
        var checkboxes = document.getElementsByName('phones');
        if (countChecked(checkboxes) == 1) {
            window.open('jsp/phone.jsp', 'phonePage', 'width=1000, height=1000');
            for (var i = 0; i < checkboxes.length; i++) {
                if (checkboxes[i].type == "checkbox" && checkboxes[i].checked) {
                    var row = table.rows[i];
                    form.phoneType.value = row.cells[3].childNodes[0].value;
                    form.comment.value = row.cells[4].childNodes[0].value;
                    form.countryCode.value = row.cells[5].childNodes[0].value;
                    form.operatorCode.value = row.cells[6].childNodes[0].value;
                    form.phoneNumber.value = row.cells[7].childNodes[0].value;
                    this.pos = i;
                    this.mode = 1;
                    
                }
            }
        } else if (countChecked(checkboxes) == 0) {
            alert("There is no selected phone");
        } else {
            alert("Please, choose one")
        }

        window.close();
    },

    addPhone: function () {
        window.open('jsp/phone.jsp', 'phonePage', 'width=1000, height=1000');
        this.mode = 0;
    },

    cancelPhone: function () {
        document.getElementById("phoneForm").reset();
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



