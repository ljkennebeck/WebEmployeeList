<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Existing Employee</title>
</head>
<body>
	<form action="editEmployeeServlet" method="post">
		First Name: <input type="text" name="fName" value="${empToEdit.fName }">
	 	Last Name: <input type="text" name="lName" value="${empToEdit.lName }">
	 	<input type="hidden" name="id" value="${empToEdit.id }">
	 	<input type="submit" value="Save Edited Employee">
	</form>
</body>
</html>