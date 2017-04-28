<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="./js/lib/jQuery/jquery.min.js"></script>
<script src="./js/lib/bootstrap.min.js"></script>
<script src="./js/lib/jQuery/jquery.color-2.1.2.js"></script>
<script src="./js/lib/jQuery/jquery.validate.min.js"></script>
<link rel="stylesheet" href="./css/lib/bootstrap.min.css">
<title>ADMIN PANEL</title>
<c:if test="${sessionScope.userName == null}">
	<c:redirect url="Login.jsp"></c:redirect>
</c:if>
</head>
<body>
	<h1>Choose Option</h1>
	        

	<p></p>
	        
	<a href="display_user_details.jsp">Display  and update Record</a>  
	<h1>Welcome ADmins</h1>
	<br>
	<a href="plane_insert.jsp">Plane insert</a>
	<a href="plane_view_details.jsp">Plane view</a>
	<br><a href="logout?name=${name}">Logout</a>
</body>
</html>