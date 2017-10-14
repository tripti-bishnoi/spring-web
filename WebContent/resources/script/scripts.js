const confirmPassText = document.querySelector("#confirmPass");
const passText = document.querySelector("#password");
const messageDiv = document.querySelector("#passwordMessage");

confirmPassText.addEventListener("keyup", spellCheck, false);

function spellCheck() {
	var confirmPassValue = confirmPassText.value;
	var passTextValue = passText.value;
	var subPassValue = passTextValue.substring(0, confirmPassValue.length);

	if (passTextValue == confirmPassValue){
		confirmPassText.style.borderColor="green";
		passText.style.borderColor="green";
		messageDiv.innerHTML="<fmt:message key='MatchedPassword.loginDetails.password'/>";
		messageDiv.style.color="green";
	}
	else if (subPassValue == confirmPassValue){
		confirmPassText.style.borderColor="yellow";
		passText.style.borderColor="yellow";
		messageDiv.innerHTML="<fmt:message key='UntilMatchedPassword.loginDetails.password'/>";
		messageDiv.style.color="yellow";
	}
	else{
		confirmPassText.style.borderColor="red";
		passText.style.borderColor="red";
		messageDiv.innerHTML="<fmt:message key='NotMatchedPassword.loginDetails.password'/>";
		messageDiv.style.color="red";
	}
}