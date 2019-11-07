function validate(){
    //alert("Inside validate.");
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    if(username == ""){
        alert("Username can not be blank.");
        return false;
    }else if(password == ""){
        alert("Password can not be blank.");
        return false;
    }else{
        var form = document.getElementById("frm");
        form.action = "login.do";
        form.submit();
    }
}