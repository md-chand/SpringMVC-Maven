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
	<div class="container">
		<header>
			<h1>Log in</h1>
		</header>
		<section>
			<div id="container_demo">
				<!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
				<a class="hiddenanchor" id="toregister"></a> <a class="hiddenanchor"
					id="tologin"></a>
				<div id="wrapper">
					<div id="login" class="animate form" style="height: 40%">
						<form:form name='loginForm' action='/springmvc/services/application/doLogin' method='POST' modelAttribute="userLogin">
							<!-- <h1>Log in</h1> -->
							<p>
								<label for="username" class="uname" data-icon="u">
									Username </label>
								<form:input path="userName" id="userName" required="required"
									type="text" placeholder="username" />
							</p>
							<p>
								<label for="password" class="youpasswd" data-icon="p">
									Your password </label>
								<form:password path="password" id="password" required="required" placeholder="eg. X8df!90EO" />
							</p>
							<p class="keeplogin">
								<input type="checkbox" name="loginkeeping" id="loginkeeping"
									value="loginkeeping" /> <label for="loginkeeping">Keep
									me logged in</label>
							</p>
							<c:if test="${not empty error}">
								<p style="color: red">
									<c:out value="*${ error}"></c:out>
								</p>
							</c:if>
							<p class="login button" style="margin-bottom: 0px;">
								<input type="submit" value="Login" />
							</p>
							<a href="/springmvc/services/application/forgotPassword">Forgot your password?</a>
							<!-- <p class="change_link">
								Not a member yet ? <a href="#toregister" class="to_register">Join
									us</a>
							</p> -->
						</form:form>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>