<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit an Existing Crew</title>
</head>
<body>
	<form action="editCrewDetailsServlet" method="post">
		<input type="hidden" name="id" value="${crewToEdit.id }">
		Department: <input type="text" name="departmentName" value = "${crewToEdit.department }"><br>
		Last Modified: <input type="text" name="month" placeholder="mm" size="4" value="${month }">
		<input type="text" name="day" placeholder="dd" size="4" value="${day }">
		<input type="text" name="year" placeholder="yyyy" size="4" value="${year }">
		
		Manager Name: <input type="text" name="managerName" value="${crewToEdit.manager.managerName }"><br>
		
		Available Employees:<br>
		
		<select name="allEmployeesToAdd" multiple size="6">
			<c:forEach items="${requestScope.allEmployees }" var="currentemployee">
			<option value="${currentemployee.id }">${currentemployee.fName } | ${currentemployee.lName }</option>
			</c:forEach>
		</select><br>
		<input type="submit" value="Edit Crew and Add Employees">
	</form>
	<a href = "index.html">Go add new employees instead</a>
</body>
</html>