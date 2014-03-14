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

function checkUserNameAvailability()
{
	var userName = $("#usernamesignup").val();
	if(userName.length != 0)
	{
		$.ajax({
			url : "/springmvc/services/application/userNameAvailable?userName="+userName,
			type: "GET",
			success: function(response){
				if(response == 'invalid')
				{
					$("#usernamesignup").val('');
					$("#userNameAvailable").html(userName +" username already used. Plz select other one");
					$("#userNameAvailable").show();
				}								
			},
			failure : function(response){
				alert(" 1: "+response.responseText);
				$("#userNameAvailable").hide();
			},
			error : function(response){
				alert(" 2: "+response.responseText);
				$("#userNameAvailable").hide();
			}
		});
	}
}

function checkForEmailExistence()
{
	var emailId = $("#emailsignup").val();
	if(emailId.length != 0)
	{
		$.ajax({
			url : "/springmvc/services/application/emailExistence?emailId="+emailId,
			type: "GET",
			success: function(response){
				if(response == 'existed')
				{
					$("#emailsignup").val('');
					$("#emailError").html(emailId +" already registerd with us. Plz use another one");
					$("#emailError").show();
				}								
			},
			failure : function(response){
				$("#emailsignup").val('');
				$("#emailError").hide();
			},
			error : function(response){
				$("#emailsignup").val('');
				$("#emailError").hide();
			}
		});
	}
}

function hideDiv(divId)
{
	$("#"+divId).hide();
}