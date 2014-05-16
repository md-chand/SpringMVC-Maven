<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->

<head>
<meta charset="UTF-8" />
<title>Change Password</title>
</head>
<body>
	<div class="container" style="text-align: inherit;">
		<%@include file="header.jsp"%>
		<div id="login"
			style="top: 15%; padding: 2%; width: 91%; margin: 0px 20px 20px 47px; height: 65%; position: static;">
			Change your login password
			<hr style="color: rgb(54, 176, 182); margin-bottom: 1%;">
			<div id="wrapper" style="margin: 0">
				<div id="login" style="padding: 2%; width: 90%; height: auto;">
				
				<form:form action="/springmvc/services/application/auth/createUser" method="post" modelAttribute="userDetails" 
					enctype="multipart/form-data">			
			<form:hidden path="userId" value="${LOGGEDIN_USER.userId }" />			
			<p>
				<label for="namesignup" class="uname" data-icon="u">Name</label>
				<input id="namesignup" name="usernamesignup" readonly="readonly" value="${LOGGEDIN_USER.name }"
				 style="background: none repeat scroll 0px 0px #BDBDBD;"/>
			</p>
			<p>
				<label for="namesignup" class="uname" data-icon="p">Current Password</label>
				<input type="password" id="passwordsignup" name="passwordsignup" required="required" />
			</p>
			<p>
				<label for="passwordsignup" class="youpasswd" data-icon="p">New Password </label>
				<form:password path="password" id="passwordsignup" name="passwordsignup" required="required" />
			</p>
			<p>
				<label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Please confirm new password </label> 
				<input id="passwordsignup_confirm" name="passwordsignup_confirm" required="required" type="password" />
			</p>
			
			</form:form>
			<p class="signin button">
				<input type="submit" value="Cancel" style="float: left;"/>
				<input type="submit" value="Update" />
			</p>

				</div>
			</div>
		</div>
	</div>
</body>
</html>