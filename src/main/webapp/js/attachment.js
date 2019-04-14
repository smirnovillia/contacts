var attachService = {
    popUp: 'attachPopUp',

    saveAttach: function () {
        "use strict";
        var input_file = document.getElementById("b_attach");
        var form = document.getElementById("form");


        var file = form.attach.files[0];
        if (file != undefined && file.size > 1024 * 1024 * 10) {
            alert("Too much size of file!Maximum size of file is 10 MB");
            return false;
        }
        if (input_file.style.display == "initial" && form.attach.value == "") {
            alert("Choose file, please");
            return false;
        }
        openbox(this.popUp);
        form.command.value = 'setattach';
        form.submit();
    },

    deleteAttach: function () {
        "use strict";
        var form = document.getElementById("form");
        var checkboxes = document.getElementsByName('attaches');
        var length = document.getElementsByName('attaches').length;
        var flag = false;
        for (var i = length - 1; i >= 0; i--) {
            if (checkboxes[i].checked) {
                flag = true;
                break;
            }
        }
        if (flag === false) {
            return false;
        }
        form.command.value = 'setattach';
        form.attachMode.value = 'delete';
        form.submit();
    },

    editAttach: function () {
        "use strict";
        var comment = document.getElementById("attachComment");
        var table = document.getElementById("attachTable");
        var checkboxes = document.getElementsByName('attaches'), length = checkboxes.length;

        document.getElementById("form").attachMode.value = "edit";

        var input_file = document.getElementById("b_attach");
        var file_name = document.getElementById("b_file_name");
        input_file.style.display = "none";
        file_name.style.display = "initial";

        for (var i = 0; i < length; i++) {
            if (checkboxes[i].checked) {
                var row = table.rows[i];
                document.getElementById("file_name").value = row.cells[4].firstElementChild.value;
                comment.value = row.cells[3].firstElementChild.value;
                openbox(this.popUp);
                break;
            }
        }

    },

    addAttach: function () {
        "use strict";
        var input_file = document.getElementById("b_attach");
        var file_name = document.getElementById("b_file_name");
        input_file.style.display = "initial";
        file_name.style.display = "none";
        document.getElementById("form").attachMode.value = "add";
        openbox(this.popUp);
    },

    cancelAttach: function () {
        "use strict";
        var comment = document.getElementById("attachComment");
        comment.value = '';
        openbox(this.popUp);
    }
};








