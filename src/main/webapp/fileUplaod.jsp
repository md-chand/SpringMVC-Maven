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
	<title>Forgot Password Page</title>
	<%@include file="WEB-INF/view/stylesAndScripts.jsp" %>
	<script type="text/javascript" src="<%=context%>/script/validation.js"></script>
	<script type="text/javascript" src="<%=context%>/script/jQuery-1.10.1.min.js"></script>
	
	<script>
		$(document).ready(function() {
			$("#uploadButton").click(function() {
				var fileName = $("#exportFile").val();
				alert(fileName.match(/.csv$/) != '.csv');
				if(fileName.match(/.csv$/) != '.csv')
				{
					alert('Inside If	');
					return false;
				}				
			});
		});
	</script>
	
</head>	
<body>
	<div>
		<h3>Choose File to Upload in Server</h3>
		<form action='/springmvc/services/FileUplaod/fileUplaod' method="post" enctype="multipart/form-data">
			<input type="file" name="file" id="exportFile" /> <input type="submit" value="upload" id="uploadButton"/>
		</form>
	</div>
</body>
</html>