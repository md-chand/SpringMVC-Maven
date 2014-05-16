<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div id="wrapper" style="margin: 0">
	<div id="login"
		style="padding: 2%; width: 90%; height: auto;">
		<form:form action="/springmvc/services/application/auth/createUser"
			method="post" modelAttribute="userDetails"
			enctype="multipart/form-data">
			<form:hidden path="userId" value="${userDetails.userId }" />
			<p>
				<label for="namesignup" class="uname" data-icon="u">Name</label>
				<form:input path="name" id="namesignup" name="usernamesignup"
					required="required" placeholder="mysuperusername690" value="${userDetails.name }" />
			</p>
			<p>
				<label for="emailsignup" class="youmail" data-icon="e"> Email
					Id</label>
				<form:input path="email" id="emailsignup" name="emailsignup"
					required="required" placeholder="mysupermail@mail.com"
					onblur="checkForEmailExistence();" value="${userDetails.email }"/>
			<div id="emailError" style="color: red; display: none;"></div>
			</p>
			<p>
				<label for="contactnumbersignup" class="uname" data-icon="u">Contact
					Number</label>
				<form:input path="contactNumber" id="contactnumbersignup"
					name="usernamesignup" required="required"
					placeholder="mysuperusername690" value="${userDetails.contactNumber }" />
			</p>
			<p>
				<label style="padding-right: 10px;">Gender</label> <span
					style="padding-right: 5px;"><form:radiobutton path="gender"
						value="Male" required="required" />Male</span> <span
					style="padding-right: 5px;"><form:radiobutton path="gender"
						value="Female" required="required" />Female</span>
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
				<form:input path="userName" id="usernamesignup" name="usernamesignup"
					required="required" placeholder="mysuperusername690"
					onchange="checkUserNameAvailability();"  value="${userDetails.userName }"/>
				<div id="userNameAvailable" style="color: red; display: none;"></div>
			</p>
			</form:form>
			<p class="signin button">
				<input type="submit" value="Delete" style="float: left;"/>
				<input type="submit" value="Update" />
			</p>
		<%-- </form:form> --%>
	</div>
</div>