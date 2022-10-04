<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crew Lists</title>
</head>
<body>
	<form method="post" action="crewNavigationServlet">
		<table>
			<c:forEach items="${requestScope.allEmployees }" var="currentemployee">
				<tr>
					<td><input type="radio" name="id" value="${currentemployee.id }"></td>
					<td><h2>${currentemployee.department }</h2></td>
				</tr>
				<tr>
					<td colspan="3">Last Modified: ${currentemployee.lastModified }</td>
				</tr>
				<tr>
					<td colspan="3">Manager: ${currentemployee.manager.managerName }</td>
				</tr>
				<c:forEach var="listVal" items="${currentemployee.listOfEmployees }">
					<tr>
						<td></td>
						<td colspan="3">
							${listVal.fName }, ${listVal.lName }
						</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToCrew">
		<input type="submit" value="delete" name="doThisToCrew">
		<input type="submit" value="add" name="doThisToCrew">
	</form>
	<a href="index.html">Add more employees</a><br>
</body>
</html>