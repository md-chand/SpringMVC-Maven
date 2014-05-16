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
<body onload="selectCurrentPage('createUser');">
	<div class="container" style="text-align: inherit;">
		<%@include file="header.jsp"%>	
		<div id="login" style="top: 15%; padding: 2%; width: 91%; margin: 0px 20px 20px 47px; height: 65%; position: static;">
		
		<div id="wrapper" style="margin: 0">
		<div id="login" style="padding: 2%; width: 90%; height: auto;">
		
				<form:form action="/springmvc/services/application/auth/createUser"
					method="post" modelAttribute="userDetails"
					enctype="multipart/form-data">
					<p>
						<label for="namesignup" class="uname" data-icon="u">Name</label>
						<form:input path="name" id="namesignup" name="usernamesignup"
							required="required" placeholder="" />
					</p>
					<p>
						<label for="emailsignup" class="youmail" data-icon="e">
							Email Id</label>
						<form:input path="email" id="emailsignup" name="emailsignup"
							required="required" placeholder="mysupermail@mail.com"
							 />
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
						<span style="padding-right: 5px;"><form:radiobutton path="gender" value="Male" required="required" />Male</span> 
						<span style="padding-right: 5px;"><form:radiobutton path="gender" value="Female" required="required" />Female</span>
							<!-- User Role -->
						<label style="padding-left: 30%;">User Role </label>
						<form:select path="role">
							<option value="USER">User</option>
							<option value="ADMIN">Admin</option>
							<option Value="MASTER">Master</option>
						</form:select>					
					</p>
					
					<p>
						<label for="usernamesignup" class="uname" data-icon="u">Login
							User Name</label>
						<form:input path="userName" id="usernamesignup"
							name="usernamesignup" required="required"
							placeholder="mysuperusername690"
							 />
					<div id="userNameAvailable" style="color: red; display: none;"></div>
					</p>					
					<p class="signin button">
						<input type="submit" value="Create" />
					</p>
				</form:form>
			</div>
		</div>
		</div>
		</div>
</body>
</html>