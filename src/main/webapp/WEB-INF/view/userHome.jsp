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
<meta charset="UTF-8" />
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
	<title>Login Page</title>
</head>
<body>
	<div class="container" style="text-align: inherit;">		
	<%@include file="header.jsp" %>
		<div id='cssmenu'>
			<ul>
			   <li class='active'><a href='#'><span>Home</span></a></li>
			   <li><a href='/springmvc/services/application/auth/getCreateUserPage'><span>Create New User</span></a></li>
			   <li><a href='#'><span>About</span></a></li>			   
			   <li style="float: right;"><a href='#'><span>Contact</span></a></li>
			</ul>
		</div>
		<div id="login" style="top: 15%; padding: 2%; width: 91%; margin: 0px 20px 20px 47px; height: 60%;">
			You have logged in successfully!
			
		<div style="float:right">
    		<img width="100px" height="100px" src="">
		</div>
						
		</div>
	</div>
</body>
</html>