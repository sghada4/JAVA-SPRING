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
		<h1>${book.title}</h1>
		<a href="/books">back to the shelves</a>
		<c:if test="${user.id == book.postedBy.id}">
			<p>You read ${book.title} by ${book.author}</p>
			<p>Here are your thoughts:</p>
		</c:if>
		<c:if test="${user.id != book.postedBy.id}">
			<p>${book.postedBy.userName} read ${book.title} by ${book.author}
			</p>
			<p>Here are ${book.postedBy.userName}'s thoughts:</p>
		</c:if>
		<hr>
		<p>
			<c:out value="${book.thoughts}" />
		</p>
		<hr>
		
		<c:if test="${user.id == book.postedBy.id}">
			<a href="/books/${book.id }/edit" class="btn btn-outline-primary">Edit</a>
			<form action="/books/${book.id}" method="post"
				style="display: inline;">
				<input type="hidden" name="_method" value="delete"> <input
					type="submit" value="Delete" class="btn btn-danger">
			</form>
		</c:if>
	</div>
</body>
</html>