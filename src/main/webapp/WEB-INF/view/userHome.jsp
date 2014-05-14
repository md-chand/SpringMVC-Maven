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
	<title>Home Page</title>
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
		<div id="login" style="top: 15%; padding: 2%; width: 91%; margin: 0px 20px 20px 47px; height: 60%; position: static;">
			<c:if test="${message ne '' }">
				<c:out value="${message }" />
			</c:if>			
			<div style="float:right" id="userAvatar">
	    		<img id="avatarId" width="100px" height="100px" src='/springmvc/services/application/auth/getAvatar/${LOGGEDIN_USER.userName}/${LOGGEDIN_USER.userId}'>
	    		<a href="#" onclick="openPopup();">Change It</a>
			</div>
			<!-- Avatar POP content div -->
			<div class="popup_Div" id="changeAvatarPopup">
				<div class="dummy_div"></div>
				<div class="popup-Content_div" id="changeAvatarPopupInnerDiv" style="overflow: visible;">
					<form id="changeAvatarForm" enctype="multipart/form-data" method="POST" action="/springmvc/services/application/auth/updateAvatar">
						<input type="text" id="userName" name="userName" value="${LOGGEDIN_USER.userName}">
						<label style="font-size: 11pt; float: left;"> Please select your profile picture</label><br/>
						<input type="file" name="avatarImg" id="avatarImg" style="padding-top: 10px;">
						<div style="padding-top: 10%;">
							<span>
								<input type="button" name="Close" value="Close" title="Close" onclick="jQuery('#changeAvatarPopup').hide();">
							</span>
							<span  style="float: right;">
								<input type="button" name="UPdate" value="Update" title="Update" onclick="changeAvatar();">
							</span>
						</div>
					</form>
				</div>
			</div>
		</div>				
	</div>	
</body>
</html>