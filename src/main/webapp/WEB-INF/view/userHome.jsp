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
	<title>Login Page</title>
	<%@include file="stylesAndScripts.jsp" %>
</head>
<body>
	<div class="container" style="text-align: inherit;">		
	<%@include file="header.jsp" %>
		<div id="login" style="top: 10%; padding: 2%; width: 91%; margin: 0px 20px 20px 47px; height: 60%;">
			You have logged in successfully!
			<p>
				<a href="/springmvc/services/application/auth/getCreateUserPage">Create New
					User</a>
			</p>
		</div>
	</div>
</body>
</html>