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
	<title>View User</title>
</head>
<body onload="selectCurrentPage('allUsersName');">
	<div class="container" style="text-align: inherit;">
		<%@include file="header.jsp"%>	
		<div id="login" style="top: 15%; padding: 2%; width: 91%; margin: 0px 20px 20px 47px; height: 65%; position: static;">
			
			<div id="existingUsers" onchange="getUserDetails();">
				Select An User: <select id="existingUsersList">
					<c:forEach items="${userDetailsList }" var="userDetail">
						<option value="${userDetail.userId}">${userDetail.name}</option>
					</c:forEach>
				</select>
				<hr style="color: rgb(54, 176, 182); margin-bottom: 1%;">
				<div id="selectedUserDetails">
				</div>
			</div>
			
			<!-- Avatar POP content div -->
			<div class="popup_Div" id="changeAvatarPopup">
				<div class="dummy_div"></div>
				<div class="popup-Content_div" id="changeAvatarPopupInnerDiv" style="overflow: visible;">
					<form id="changeAvatarForm" enctype="multipart/form-data" method="POST" action="/springmvc/services/application/auth/updateAvatar">
						<input type="hidden" id="userName" name="userName" value="${LOGGEDIN_USER.userName}">
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