<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login </title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="./css/lib/bootstrap.min.css">
<script src="./js/lib/jQuery/jquery.min.js"></script>
<script src="./js/lib/bootstrap.min.js"></script>
<script src="login.js" type="text/javascript"></script>
</head>
<body>
	<div class="container">
		<%
			String error = request.getParameter("error");
		
			String userName = request.getParameter("userName");
			if (null == userName) {
				userName = "";
			}
		%>
		<h2>Vertical (basic) form</h2>
		<form id="form" method="post" action="login">
			<p id="403" class="hidden error text-danger">Sorry wrong usrename
				or password</p>
			<p id="500" class="hidden error text-danger">Some internal error
				occured, Please contact Admin</p>
			<p id="404" class="hidden error text-danger">Server isn't
				available at this time, try again after sometime</p>
			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" name="email" placeholder="Enter email"
					value="<%=userName%>">
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" name="pwd" placeholder="Enter password">

			</div>
			<div class="checkbox">
				<label><input type="checkbox"> Remember me</label>
			</div>
			<input type="submit" class="btn btn-INFO">
			<a href="forgetpassword.jsp">Forgetpassword</a>
		</form>
		<h2>New User ?<a href="Registration.html" >Sign up  </a></h2>
		
	</div>

</body>
<script type="text/javascript">
	var error =
<%=error %>
	;
	if (null != error) {
		var $errorElement = $("#" + error);
		$errorElement.removeClass("hidden");
	}
</script>

</html>
