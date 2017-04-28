<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="./js/lib/jQuery/jquery.min.js"></script>
<script src="./js/lib/bootstrap.min.js"></script>
<script src="./js/lib/jQuery/jquery.color-2.1.2.js"></script>
<script src="./js/lib/jQuery/jquery.validate.min.js"></script>
<link rel="stylesheet" href="./css/lib/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update plane details</title>
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
            SELECT * from flight where plane=? and time=?;
            <sql:param value="${param.plane}" />
            <sql:param value="${param.time }"/>
		</sql:query>
	</fmt:bundle>
	<form action="updatedb_admin_plane.jsp" method="post">
		<table>
			<tr>
			
				<th>plane</th>
				<th>time</th>
				<th>city</th>
			</tr>
	<c:forEach var="row" items="${result.rows}">
			<tr>
						
				<td><input type="hidden" value="${param.plane }" /> <input type="hidden" value="${param.time }" /> 
				<%-- <input type="text" class="form-control" value="${row.plane}" name="plane" /> --%></td>
				<td><input class="form-control" type="text" value="${row.time}"
					name="time" /></td>
				<td><input class="form-control" type="text" value="${row.city}"
					name="city" /></td>
				<td><input type="submit" value="Update" /></td>
			</tr>
</c:forEach>

		</table>


	</form>
</body>
</html>