<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new crew</title>
</head>
<body>
	<form action="createNewCrewServlet" method="post">
		Crew Department: <input type="text" name="crewDepartment"><br>
		Last Modified: <input type="text" name ="month" placeholder="mm" size="4">
		<input type="text" name ="day" placeholder="dd" size="4">
		<input type="text" name ="year" placeholder="yyyy" size="4"><br>
		Manager Name: <input type="text" name="managerName"><br>
		
		Available Employees:<br>
		<select name="allEmployeesToAdd" multiple size="6">
			<c:forEach items="${requestScope.allEmployees }" var="currentemployee">
				<option value="${currentemployee.id }">${currentemployee.fName } | ${currentemployee.lName }</option>
			</c:forEach>
		</select><br>
		<input type="submit" value="Create Crew and Add Employees">
	</form>
	<a href="index.html">Go add new employees instead</a>
</body>
</html>