<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
<title>Create User Page</title>
</head>

<body>
<body>
	<div class="container" style="text-align: inherit;">
		<%@include file="header.jsp"%>
		<div id='cssmenu'>
			<ul>
				<li><a href='/springmvc/services/application/auth/userHomePage'><span>Home</span></a></li>
				<li class='active'><a href='#'><span>Create New User</span></a></li>
				<li><a href='#'><span>About</span></a></li>
				<li style="float: right;"><a href='#'><span>Contact</span></a></li>
			</ul>
		</div>

		<div id="wrapper" style="margin: 0">
			<div id="login"
				style="padding: 2%; width: 90%; margin: 0px 20px 20px 47px; height: auto;">
				<form:form action="/springmvc/services/application/auth/createUser"
					method="post" modelAttribute="userDetails"
					enctype="multipart/form-data">
					<p>
						<label for="namesignup" class="uname" data-icon="u">Name</label>
						<form:input path="name" id="namesignup" name="usernamesignup"
							required="required" placeholder="mysuperusername690" />
					</p>
					<p>
						<label for="emailsignup" class="youmail" data-icon="e">
							Email Id</label>
						<form:input path="email" id="emailsignup" name="emailsignup"
							required="required" placeholder="mysupermail@mail.com"
							onblur="checkForEmailExistence();" />
					<div id="emailError" style="color: red; display: none;"></div>
					</p>
					<p>
						<label for="contactnumbersignup" class="uname" data-icon="u">Contact
							Number</label>
						<form:input path="contactNumber" id="contactnumbersignup"
							name="usernamesignup" required="required"
							placeholder="mysuperusername690" />
					</p>
					<p>
						<label style="padding-right: 10px;">Gender</label>
						<span style="padding-right: 5px;"><form:radiobutton path="gender" value="Male" required="required"/>Male</span>
						<span style="padding-right: 5px;"><form:radiobutton path="gender" value="Female" required="required"/>Female</span>
					</p>
					<p>
						<label for="usernamesignup" class="uname" data-icon="u">Login
							User Name</label>
						<form:input path="userName" id="usernamesignup"
							name="usernamesignup" required="required"
							placeholder="mysuperusername690"
							onblur="checkUserNameAvailability();" />
					<div id="userNameAvailable" style="color: red; display: none;"></div>
					</p>
					<p>
						<label for="passwordsignup" class="youpasswd" data-icon="p">Login
							Password </label>
						<form:password path="password" id="passwordsignup"
							name="passwordsignup" required="required"
							placeholder="eg. X8df!90EO" />
					</p>
					<p>
						<label for="passwordsignup_confirm" class="youpasswd"
							data-icon="p">Please confirm your password </label> <input
							id="passwordsignup_confirm" name="passwordsignup_confirm"
							required="required" type="password" placeholder="eg. X8df!90EO" />
					</p>
					<p>
						<label for="passwordsignup_confirm" class="youpasswd"
							data-icon="p">Upload Profile Picture</label> <input type="file"
							id="avatarImg" name="avatarImg" />
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