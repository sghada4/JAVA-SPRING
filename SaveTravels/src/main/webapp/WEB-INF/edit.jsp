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
		<h1 style="color: green;">Edit Expense</h1>
		<a href="/">Go back</a>

		<form:form action="/expenses/${expense.id}" method="post"
			modelAttribute="expense">
			<input type="hidden" name="_method" value="put">
			<form:errors path="*" style="color:red;" />
			<div class="form-group mx-sm-3 mb-2">
				<form:label path="name">Expense Name</form:label>
				<form:input path="name" class="form-control" />
			</div>
			<div class="form-group mx-sm-3 mb-2">
				<form:label path="vendor">Vendor</form:label>
				<form:input path="vendor" class="form-control" />
			</div>
			<div class="form-group mx-sm-3 mb-2">
				<form:label path="amount">Amount</form:label>
				<form:input type="number" path="amount" step="0.01"
					class="form-control" />
			</div>
			<div class="form-group mx-sm-3 mb-2">
				<form:label path="description">Description</form:label>
				<form:textarea path="description" class="form-control" />
			</div>
			<input type="submit" value="Submit" class="btn btn-primary" />
		</form:form>
	</div>
</body>
</html>