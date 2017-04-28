<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Plane details</title>
<c:if test="${sessionScope.userName == null}">
	<c:redirect url="Login.jsp"></c:redirect>
</c:if>
<script>
	function confirmGo(m, u) {
		if (confirm(m)) {
			window.location = u;
		}
	}
</script>
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
            SELECT * from flight;
        </sql:query>
		<center>
			<form>
				<table border="1" width="40%">
					<caption>User List</caption>
					<tr>
						<th>CITY</th>
						<th>flight</th>
						<th>time</th>
						
						<th>update</th>
						<th>delete</th>
					</tr>
					<c:forEach var="row" items="${result.rows}">
						<tr>
							<td><c:out value="${row.city}" /></td>
							<td><c:out value="${row.plane}" /></td>
							<td><c:out value="${row.time}" /></td>
							
							
							<td><a
								href="update_admin_plane.jsp?plane=<c:out value="${row.plane}"/>&time=<c:out value="${row.time}"/>">Update</a></td>
							<td><a
								href="javascript:confirmGo('Sure to delete this record?','deletedb_admin_plane.jsp?plane=<c:out value="${row.plane}"/>&time=<c:out value="${row.time}"/>')">Delete</a></td>


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