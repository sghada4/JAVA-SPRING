<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div>
		<h1>Fruit Store</h1>
		<table>
			<tr>
				<th>Name</th>
				<th>Price</th>
			</tr>
			<c:forEach var="fruit" items="${allFruits}">
				<tr>
					<td><c:out value="${fruit.name}" /></td>
					<td><c:out value="${fruit.price}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>