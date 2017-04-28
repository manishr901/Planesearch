<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<script src="./js/lib/jQuery/jquery.min.js"></script>
<script src="./js/lib/bootstrap.min.js"></script>
<script src="./js/lib/jQuery/jquery.color-2.1.2.js"></script>
<script src="./js/lib/jQuery/jquery.validate.min.js"></script>
<link rel="stylesheet" href="./css/lib/bootstrap.min.css">
<script src="knockout-3.4.1.js"></script>
<script src="registration.js" type="text/javascript"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<c:if test="${sessionScope.userName == null}">
	<c:redirect url="Login.jsp"></c:redirect>
</c:if>
</head>
<body>

	<fmt:bundle basename="app">
		<fmt:message key="db.username" var="username">
		</fmt:message>
		<fmt:message key="db.url" var="url">
		</fmt:message>
		<fmt:message key="db.pwd" var="pwd">
		</fmt:message>
		<fmt:message key="db.driver" var="driver">
		</fmt:message>
		<sql:setDataSource var="dbsource" driver="${driver }" url="${url }"
			user="${username }" password="${pwd }" />


		<sql:query dataSource="${dbsource}" var="result">
            SELECT * from registration where email=?;
            <sql:param value="${param.email}" />
		</sql:query>
		<form action="updatedb_admin.jsp" method="post">
			<table border="0" width="40%" cellspacing="1">
				<caption>Update User</caption>
				<tr>
					<th>Name</th>

					<th>password</th>
				</tr>
				<c:forEach var="row" items="${result.rows}">
					<tr>
						<td><input type="hidden" value="${param.email}"
							name="email_param" /> <input class="form-control" type="text"
							value="${row.name}" name="user" /></td>
						<td><input class="form-control" type="text"
							value="${row.password}" name="password" /></td>
						<td><select id="country" name="country" class="form-control"
							data-bind="value: country, options:countriesList, optionsText: 'value',optionsValue:'id', selectedIndexes:0">
						
						</select></td>
						<tr>
						<td><select id="city" name="city" class="form-control"
							data-bind="value:city, options:statesList">
								<option value="${row.city }">Select</option></select></td>
					<td><select id="blood_group" name="bloodgroup" class="form-control"
						data-bind="value: bloodgroup">
						<option value="">Select</option>
						<option value="A+">A+</option>
						<option value="B+">B+</option>
						<option value="AB+">AB+</option>
						<option value="O+">O+</option>
						<option value="A-">A-</option>
						<option value="B-">B-</option>
						<option value="AB-">AB-</option>
						<option value="O-">O-</option>
					</select>
					</td>	
					<td><input type="text"  name="street" class="form-control" value="${row.street }"/></td>
					<td><input type="text" name="area" class="form-control" value="${row.area }"/></td>
					<td><input type="text"  name="contact" class="form-control" value="${row.contact }" /></td>
					<td><input type="text" name="district" class="form-control" value="${row.district }"/></td>
					<td><input type="submit" value="Update" /></td>
					</tr>
				</c:forEach>
			</table>
			<a href="display_user_details.jsp">Go Home</a> <a
				href="logout?name=${name}">Logout</a>
		</form>
	</fmt:bundle>
</body>