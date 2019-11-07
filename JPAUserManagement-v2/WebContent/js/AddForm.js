function validateUser(){
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var firstname = document.getElementById("firstname").value;
    var lastname = document.getElementById("lastname").value;
    var mobilenumber = document.getElementById("mobilenumber").value;
    
    if(username == ""){
        alert("Username can not be blank.");
        return false;
    }else if(password == ""){
        alert("Password can not be blank.");
        return false;
    }else{
        var form = document.getElementById("frm");
        form.action = "add.do";
        form.submit();
    }
}

function validateUpdateUser(){
    var username = document.getElementById("username").value;
    var firstname = document.getElementById("firstname").value;
    var lastname = document.getElementById("lastname").value;
    var mobilenumber = document.getElementById("mobilenumber").value;
    
    if(username == ""){
        alert("Username can not be blank.");
        return false;
    }
    else{
        var form = document.getElementById("frm");
        form.action = "update.do";
        form.submit();
    }
}