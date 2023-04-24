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
<title>Save Travels</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container">
		<h1>Save Travels</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="oneExpense" items="${allExpenses}">
					<tr>
						<td> <a href="/expenses/${oneExpense.id}"> ${oneExpense.name}</a></td>
						<td>${oneExpense.vendor}</td>
						<td>$ ${oneExpense.amount}</td>
						<td><a href="/expenses/edit/${oneExpense.id}"
							class="btn btn-secondary">Edit</a>
							<form action="/expenses/${oneExpense.id}" method="post">
								<input type="hidden" name="_method" value="delete"> <input
									type="submit" value="Delete" class="btn btn-danger">
							</form></td>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br> <br> <br>
		<h1>Add an Expense</h1>
		<form:form action="/expenses" method="post" modelAttribute="expense">
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