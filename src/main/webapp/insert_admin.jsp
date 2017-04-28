<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="./js/lib/jQuery/jquery.min.js"></script>
<script src="./js/lib/bootstrap.min.js"></script>
<script src="./js/lib/jQuery/jquery.color-2.1.2.js"></script>
<script src="./js/lib/jQuery/jquery.validate.min.js"></script>
<link rel="stylesheet" href="./css/lib/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<c:if test="${sessionScope.userName == null}">
	<c:redirect url="Login.jsp"></c:redirect>
</c:if>
</head>
<body>
	<form action="insert_admin" method="post">
		<table border="1" cellspacing="2" cellpadding="5">
			<thead>
				<tr>
					<th colspan="2">PLane details</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><label>Plane name</label></td>
					<td><input type="text" name="plane" /></td>
				</tr>
				<tr>
					<td><label>Stoppage Name</label></td>
					<td><select name="city"><option value="PAT">PAT</option>
							<option value="BLR">BLR</option>
							<option value="MUM">MUM</option>
							<option value="KOL">KOL</option>
							<option value="HYD">HYD</option></select></td>
				</tr>
				<tr>
					<td><label>time</label></td>
					<td><input type="text" name="time" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Save" /></td>
					<td><input type="reset" value="reset" /></td>
				</tr>
			</tbody>
		</table>
	</form>
	
			
 	
	<font color="green"><c:if test="${result==1}">
			Success
			<a href="plane_view_details.jsp">Go Back</a>
			 <a href="logout?name=${name}">Logout</a>
		</c:if></font>
 
</body>
</html>