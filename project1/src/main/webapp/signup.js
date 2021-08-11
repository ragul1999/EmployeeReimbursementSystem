
var myInput = document.getElementById("psw");
var myInputRepeat = document.getElementById("psw-repeat");
var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");

// When the user clicks on the password field, show the message box
myInput.onfocus = function() {
  document.getElementById("message").style.display = "block";
  
}

// When the user clicks outside of the password field, hide the message box
myInput.onblur = function() {
  document.getElementById("message").style.display = "none";
}

// When the user starts to type something inside the password field
myInput.onkeyup = function() {
  // Validate lowercase letters
  var lowerCaseLetters = /[a-z]/g;
  if(myInput.value.match(lowerCaseLetters)) {
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
}

  // Validate capital letters
  var upperCaseLetters = /[A-Z]/g;
  if(myInput.value.match(upperCaseLetters)) {
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }

  // Validate numbers
  var numbers = /[0-9]/g;
  if(myInput.value.match(numbers)) {
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }

  // Validate length
  if(myInput.value.length >= 8) {
    length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }
  //check pass and repeat pass
  if(myInput.value!=myInputRepeat.value){
    check.classList.remove("success");
    check.classList.add("failure");
    document.getElementById("check").innerHTML="Password and Repeat password should be same";
    document.getElementById("myBtn").disabled = true;
  }
  else{
    check.classList.remove("failure");
    check.classList.add("success");
    document.getElementById("check").innerHTML="Password and Repeat password are same";
    document.getElementById("myBtn").disabled = false;
  }
 

}

//repeat pass match
// When the user clicks on the repeat password field, show the message box
myInputRepeat.onfocus = function() {
  document.getElementById("pass-match").style.display = "block";
  
}

// When the user clicks outside of the repeat password field, hide the message box
myInputRepeat.onblur = function() {
  document.getElementById("pass-match").style.display = "none";
}
myInputRepeat.onkeyup=function(){
 
  if(myInput.value!=myInputRepeat.value){
    check.classList.remove("success");
    check.classList.add("failure");
    document.getElementById("myBtn").disabled = true;
    document.getElementById("check").innerHTML="Password and Repeat password should be same";
    
  }
  else{
   check.classList.remove("failure");
   check.classList.add("success");
   document.getElementById("myBtn").disabled = false;
   document.getElementById("check").innerHTML="Password and Repeat password are same";
  }

}

myInputRepeat.onblur=function(){
  if(myInput.value!=myInputRepeat.value){
    check.classList.remove("success");
    check.classList.add("failure");
    document.getElementById("check").innerHTML="Password and Repeat password should be same";
  }
  else{
   check.classList.remove("failure");
   check.classList.add("success");
   document.getElementById("check").innerHTML="Password and Repeat password are same";

}
}



