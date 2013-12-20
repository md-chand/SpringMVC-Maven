<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Login Page</title>
</head>
<body onload='document.f.j_username.focus();'>
	<h3>Login with Username and Password</h3>
	<form:form name='f' action='/SpringMavenMVC/services/auth/doLogin' method='POST' modelAttribute="userLogin">
		<table>
			<tr>
				<td>User:</td>
				<td><form:input path="userName" id="userName" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:password path="password" id="password" /></td>
			</tr>
			<tr>
				<td colspan='2'><input type="submit" value="login" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>