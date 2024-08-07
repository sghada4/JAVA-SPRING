<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninjas</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container">
		<a href="/ninjas/create" class="btn btn-secondary">Add New</a>
		<a href="/" class="btn btn-info">Home</a>
		<table class="table">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="oneNinja" items="${allNinjas}">
					<tr>
						<td><a href="/ninjas/${oneNinja.id}"> ${oneNinja.firstName}</a></td>
						<td>${oneNinja.lastName}</td>
						<td>${oneNinja.age}</td>

						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>