<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="./js/lib/jQuery/jquery.min.js"></script>
<script src="./js/lib/bootstrap.min.js"></script>
<script src="./js/lib/jQuery/jquery.color-2.1.2.js"></script>
<script src="./js/lib/jQuery/jquery.validate.min.js"></script>
<link rel="stylesheet" href="./css/lib/bootstrap.min.css">
<script>
	function confirmGo(m, u) {
		if (confirm(m)) {
			window.location = u;
		}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Total users</title>
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
            SELECT * from registration;
        </sql:query>
		<center>
			<form>
				<table border="1" width="40%">
					<caption>User List</caption>
					<tr>
						<th>Username</th>
						<th>Email</th>
						<th>password</th>
						<th>contact</th>
						<th>BloodGroup</th>
						<th>city</th>
						<th>street</th>
						<th>area</th>
						<th>district</th>
						<th>update</th>
						<th>delete</th>
					</tr>
					<c:forEach var="row" items="${result.rows}">
						<tr>
							<td><c:out value="${row.name}" /></td>
							<td><c:out value="${row.email}" /></td>
							<td><c:out value="${row.password}" /></td>
							<td><c:out value="${row.contact }"></c:out></td>
							<td><c:out value="${row.bloodgroup }"/></td>
							<td><c:out value="${row.city }"></c:out></td>
							<td><c:out value="${row.street }"></c:out></td>
							<td><c:out value="${row.area }"></c:out></td>
							<td><c:out value="${row.district }"></c:out></td>
							<td><a
								href="update_admin.jsp?email=<c:out value="${row.email}"/>">Update</a></td>
							<td><a
								href="javascript:confirmGo('Sure to delete this record?','deletedb_admin.jsp?email=<c:out value="${row.email}"/>')">Delete</a></td>


						</tr>
					</c:forEach>
				</table>
			</form>
			<a href="home_admin.jsp">Go Home</a> <a
				href="logout?name=${name}">Logout</a>
		</center>
	</fmt:bundle>


</body>
</html>