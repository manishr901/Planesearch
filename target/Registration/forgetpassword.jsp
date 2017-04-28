<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/lib/bootstrap.min.css">
<script src="./js/lib/jQuery/jquery.min.js"></script>
<script src="./js/lib/bootstrap.min.js"></script>
<script src="forget.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forget password</title>
</head>
<body>
	<h2>Enter email to get password--</h2><form autocomplete="off">
	<div   class="col-xs-4"><input  id="forget" type="text" name="email" class="form-control"></div>
	<input  type="button" id="sendmail" name="submit" value ="submit" onclick="message()" />
	
	</form>	
	
</body>
</html>