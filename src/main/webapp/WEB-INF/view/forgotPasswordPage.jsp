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

<%
	String context = request.getContextPath();
	String server = request.getServerName();
%>

<head>
<meta charset="UTF-8" />
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
<title>Login Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Login and Registration Form with HTML5 and CSS3" />
<meta name="keywords"
	content="html5, css3, form, switch, animation, :target, pseudo-class" />
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="<%=context%>/css/demo.css" />
<link rel="stylesheet" type="text/css"
	href="<%=context%>/css/style3.css" />
<link rel="stylesheet" type="text/css"
	href="<%=context%>/css/animate-custom.css" />
</head>

<script type="text/javascript" src="<%=context%>/script/validation.js"></script>
<script type="text/javascript" src="<%=context%>/script/jQuery-1.10.1.min.js"></script>

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