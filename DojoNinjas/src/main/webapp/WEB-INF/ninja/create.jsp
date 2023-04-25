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
<title>Title</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container">
		<h1>Add Ninja</h1>
		<a href="/ninjas" class="btn btn-secondary">Back</a>
		<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
			<form:errors path="*" style="color:red;" />
			<div class="form-group mx-sm-3 mb-2">
				<form:label path="firstName">First Name</form:label>
				<form:input path="firstName" class="form-control" />
			</div>
			<div class="form-group mx-sm-3 mb-2">
				<form:label path="lastName">Last Name</form:label>
				<form:input path="lastName" class="form-control" />
			</div>
			<div class="form-group mx-sm-3 mb-2">
				<form:label path="age">Age</form:label>
				<form:input type="number" path="age" class="form-control" />
			</div>

			<div class="form-group mx-sm-3 mb-2">
				<form:select path="dojo">
					<c:forEach items="${allDojos}" var="dojo">
						<form:option value="${dojo.id }">${dojo.name }</form:option>
					</c:forEach>
				</form:select>
			</div>
			<input type="submit" value="Add" class="btn btn-primary" />
		</form:form>
		
	</div>
</body>
</html>