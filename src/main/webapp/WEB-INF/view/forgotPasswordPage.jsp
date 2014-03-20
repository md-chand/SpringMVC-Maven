<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<title>Forgot Password Page</title>
	<%@include file="stylesAndScripts.jsp" %>
	<script type="text/javascript" src="<%=context%>/script/validation.js"></script>
	<script type="text/javascript" src="<%=context%>/script/jQuery-1.10.1.min.js"></script>
</head>	
<body>
	<div class="container">
		<header>
			<h1>Password recovery page</h1>
		</header>
		<section>
			<div id="container_demo">
				<div id="wrapper">
					<div id="login" class="animate form" style="height: 46%">
						<form:form name='resetPasswordForm' action='/springmvc/services/application/generateResetPasswordToken' method='POST' modelAttribute="userLogin">
							<div>
								<p style="margin-bottom: 6px;">Changing your password is simple.</p>
								<p>Please enter your Username or registered email address to get instructions.</p>
							</div>
							<p>
								<label for="username" class="uname" data-icon="u">
									Username </label>
								<form:input path="userName" id="userName" type="text" placeholder="username" />
							</p>
							<p align="center" style="margin-bottom: 0px;">OR</p>
							<p>
								<label for="emailsignup" class="youmail" data-icon="e"> Email Id</label>
								<form:input path="email" id="email" name="emailsignup" placeholder="mysupermail@mail.com" />
							</p>
							<p class="login button">
								<input type="submit" value="Login" onclick="return validateUserNameOrPasswordEntered();" />
							</p>
						</form:form>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>