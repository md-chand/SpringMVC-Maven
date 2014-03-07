<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
<title>Create User Page</title>
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
<%-- <link rel="stylesheet" type="text/css" href="<%=context%>/css/animate-custom.css" /> --%>
</head>
<body>
<body>
	<div class="container" style="text-align: inherit;">
		<div style="padding: 20px 0 25px 45px;">
			<div style="color: rgba(26, 89, 120, 0.9);">
				<table style="width: 100%">
				    <tr>
				        <td style="width: 94.5%; font-size: 35px; font-weight: 400; line-height: 35px; font-family: 'BebasNeueRegular','Arial Narrow',Arial,sans-serif;">Home Page</td>
				        <td><a>Sign out</a></td>
				     </tr>
				</table>
			</div>
		</div>
		<div id="wrapper"  style="margin: 0">
			<div id="login"
				style="padding: 2%; width: 90%; margin: 0px 20px 20px 47px; height: 95%;">
				<form:form action="/springmvc/services/application/auth/createUser" method="post" modelAttribute="userDetails">
					<!-- <h1>Registration Form</h1> -->
					<p>
						<label for="namesignup" class="uname" data-icon="u">Name</label> 
							<!-- <input id="namesignup" name="usernamesignup" required="required" type="text" placeholder="mysuperusername690" /> -->
							<form:input path="name" id="namesignup" name="usernamesignup" required="required" placeholder="mysuperusername690" />
					</p>
					<p>
						<label for="emailsignup" class="youmail" data-icon="e">
							Email Id</label> 
							<!-- <input id="emailsignup" name="emailsignup" required="required" type="email" placeholder="mysupermail@mail.com" /> -->
							<form:input path="email" id="emailsignup" name="emailsignup" required="required" placeholder="mysupermail@mail.com" />
					</p>
					<p>
						<label for="contactnumbersignup" class="uname" data-icon="u">Your
							Contact Number</label> 
							<!-- <input id="contactnumbersignup" name="usernamesignup" required="required" type="text" placeholder="mysuperusername690" /> -->
							<form:input path="contactNumber" id="contactnumbersignup" name="usernamesignup" required="required" placeholder="mysuperusername690" />
					</p>							
					<p>
						<label for="usernamesignup" class="uname" data-icon="u">Your
							username</label> 
							<!-- <input id="usernamesignup" name="usernamesignup" required="required" type="text" placeholder="mysuperusername690" /> -->
							<form:input path="userName" id="usernamesignup" name="usernamesignup" required="required" placeholder="mysuperusername690" />
					</p>
					<p>
						<label for="passwordsignup" class="youpasswd" data-icon="p">Your
							password </label> 
							<!-- <input id="passwordsignup" name="passwordsignup" required="required" type="password" placeholder="eg. X8df!90EO" /> -->
							<form:password path="password" id="passwordsignup" name="passwordsignup" required="required" placeholder="eg. X8df!90EO" />
					</p>
					<p>
						<label for="passwordsignup_confirm" class="youpasswd"
							data-icon="p">Please confirm your password </label> 
							<input id="passwordsignup_confirm" name="passwordsignup_confirm" required="required" type="password" placeholder="eg. X8df!90EO" />
					</p>
					<p class="signin button">
						<input type="submit" value="Sign up" />
					</p>
				</form:form>			
			</div>
		</div>		
	</div>
</body>
</html>