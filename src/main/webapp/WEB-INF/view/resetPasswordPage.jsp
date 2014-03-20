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
	<title>Reset Password Page</title>
	<%@include file="stylesAndScripts.jsp" %>
</head>

<script type="text/javascript" src="<%=context%>/script/validation.js"></script>
<script type="text/javascript" src="<%=context%>/script/jQuery-1.10.1.min.js"></script>

<body>
	<div class="container">
		<header>
			<h1>Reset your log in password</h1>
		</header>
		<section>
			<div id="container_demo">
				<div id="wrapper">
					<div id="login" class="animate form" style="height: 42%">
						<form:form name='resetPasswordForm' action='/springmvc/services/application/resetPassword' method='POST' 
								modelAttribute="userDetails">
						<form:hidden path="userId"/>
							<p>
								<label for="username" class="uname" data-icon="u">
									Username </label>
								<form:input path="" id="userName" type="text" value="${userDetails.userName }" readonly="true" />
							</p>
							<p>
								<label for="password" class="youpasswd" data-icon="p">New password </label>
								<form:password path="password" id="password" required="required" placeholder="eg. X8df!90EO" />
							</p>
							<p>
								<label for="password" class="youpasswd" data-icon="p">Re enter new password </label>
								<form:password path="" id="repeatPassword" required="required" placeholder="eg. X8df!90EO" />
							</p>
							<p class="login button">
								<input type="submit" value="Submit" onclick="return validateResetPassword();"/>
							</p>
						</form:form>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>