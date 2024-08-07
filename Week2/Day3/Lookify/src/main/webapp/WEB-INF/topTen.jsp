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
		<h1>Top Songs</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Rating</th>
					<th>Name</th>
					<th>Artist</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="oneSong" items="${topTenSongs}">
					<tr>
						<td>${oneSong.rating}</td>
						<td><a href="/songs/${oneSong.id}"> ${oneSong.title}</a></td>
						<td>${oneSong.artist}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/dashboard">Dashboard</a>
	</div>
</body>
</html>