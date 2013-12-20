
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="utf-8">
<title>Welcome</title>
</head>
<body>
	<c:url value="/services/auth/login" var="messageUrl" />
	<a href="${messageUrl}">Click to Login</a>

	<%-- <form:form action="/SpringMavenMVC/services/auth/login" method="GET">
		<input type="submit"  value="Submit">
	</form:form> --%>
</body>
</html>
