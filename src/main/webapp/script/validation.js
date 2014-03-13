function validateUserNameOrPasswordEntered() 
{
	var userName = $("#userName").val();
	var email = $("#email").val();
	if (userName.length == 0 && email.length == 0) {
		alert("Please enter UserName or email.");
		return false;
	}
	return true;
}

function validateResetPassword() 
{
	var password = $("#password").val();
	var repeatPassword = $("#repeatPassword").val();	
	if (password != repeatPassword) {
		alert("Re entered password not matching with first one");
		return false;
	}
	return true;
}
