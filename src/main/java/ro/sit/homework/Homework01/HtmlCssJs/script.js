function clickMe() {
    readInput();

}

function readInput() {
    var usernameText = document.getElementById("username").value;
    var passwordText = document.getElementById("pass").value;
    var repeatPassText = document.getElementById("passrepeat").value;
    var addressText = document.getElementById("txtarea1").value;
    var emailText = document.getElementById("email").value;

    //username must be shorter than 10 characters
    if((usernameText.length > 14) || (usernameText.length < 4)) {
        alert("The username must be between 4 and 14 characters ");
    }
    //passsword must be longer than 8 characters and must contain at least one uppercase and one lowercase
    if(passwordText.length < 8) {
        alert("The password must be at least 8 characters")
        document.getElementById("pass").style.color="red";
    } else {
        var containsUppercase = false;
        var containsLetters = false;
        var character = ' ';
        for(i = 0; i < passwordText.length; i++) {
            character = passwordText.charAt(i);
            console.log(character);
            if(character == character.toUpperCase()) {
                containsUppercase = true;
            } else if((character >= 'A' && character <= 'Z') || (character >= 'a' && character <= 'z')) {
                containsLetters = true;
            }
        }
        if(containsUppercase == false) {
            alert("The password must contain at least one uppercase letter");
        } else if(containsLetters == false) {
            alert("The password must contain at least one letter");
        }
    }
    //Repeat password should be the same as the password itself
    if(repeatPassText != passwordText) {
        alert("Please insert the same password");
    }
    //Address can not be an empty field
    if(addressText.length == 0) {
        alert("Please insert your address");
    }
    //Email address must contain the "@" symbol
    if(emailText.length == 0) {
        alert("Email field can not be empty")
    }
    for(x = 0; x < emailText.length; x++) {
        var containsAt = false;
        characterAt = emailText.charAt(x);
        if(characterAt == '@') {
            containsAt = true;
        }
    }
    if(containsAt == false) {
        alert("Please insert a valid email address");
    }
}
