function selectedItems() {
    var selchbox = [];
    var inpfields = document.getElementsByName('labeled');
    for (var i = 0; i < inpfields.length; i++) {
        if (inpfields[i].type == 'checkbox' && inpfields[i].checked == true)
            selchbox.push(inpfields[i].value);
    }
    return selchbox;
}

function deleteContact(){
    
}

