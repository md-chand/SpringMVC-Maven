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


function hideDiv(divId)
{
	$("#"+divId).hide();
}


function uploadFile()
{
	formData = $("");
}

function openPopup()
{
	$("#changeAvatarPopup").show();
	$("#changeAvatarPopupInnerDiv").css({
        "top": (((($('#changeAvatarPopup').height() / 2) - ($('#changeAvatarPopupInnerDiv').height()/2))/($('#changeAvatarPopup').height())) * 98 +"%"),
        "left": (((($('#changeAvatarPopup').width() / 2) - ($('#changeAvatarPopupInnerDiv').width()/2))/($('#changeAvatarPopup').width())) * 96 +"%")
	});
}

function selectCurrentPage(pageName)
{	
	if (pageName == 'userHome') 
	{
		$("#homeMenuButton").addClass("active");
		$("#homeMenuLink").attr('href','#');
	}
	else if (pageName == 'createUser')
	{
		$("#createUserMenuButton").addClass("active");
		$("#createUserMenuLink").attr('href','#');
	}
	else if(pageName = 'allUsersName')
	{
		$("#existingUserMenuButton").addClass("active");
		$("#existingUserMenuLink").attr('href','#');
	}
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

function changeAvatar() {
	var userName = $("#userName").val();
	if (userName.length != 0) {
		var formData = new FormData(document.getElementById("changeAvatarForm"));
		$.ajax({
			url : "/springmvc/services/application/auth/updateAvatar",
			type : 'POST',
            data: formData,
            processData: false,
            contentType: false,
			success : function(response) {
				var date = new Date().getTime();
				document.getElementById('avatarId').src = '/springmvc/services/application/auth/getAvatar/admin/'+date;
				jQuery('#avatarImg').val ='';
				jQuery('#changeAvatarPopup').hide();
			},
			failure : function(response) {
				alert(" 1: " + response.responseText);
				$("#userNameAvailable").hide();
			},
			error : function(response) {
				alert(" 2: " + response.responseText);
				$("#userNameAvailable").hide();
			}
		});
	}
	else
	{
		alert("Invalid Username");
	}
}

function getUserDetails() {
	var selectedUserId = $("#existingUsersList").val();
	$.ajax({
		url : '/springmvc/services/application/auth/getUserDetails/'+selectedUserId,
		type : 'GET',
		success : function(response) {
			jQuery("#selectedUserDetails").html(response);
		},
		failure : function(response) {
			alert(" Failure: " + response.responseText);
		},
		error : function(response) {
			alert(" Error: " + response.responseText);
		}
	});
}