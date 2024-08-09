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
<title>Home Page</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container">
		<h1 style="text-align: center; color: #009E0F">Hello,
			${currentUser.userName}. Here are some name suggestions</h1>
		<a href="/logout" class="btn btn-outline-success">logout</a>

		<hr />
		<h3>Baby Names</h3>

		<c:if test="${success.length() > 0 }">
			<p class="badge bg-success">
				<c:out value="${success }" />
			</p>
		</c:if>

		<table class="table">
			<thead>
				<tr>
					<th>Vote?</th>
					<th>Name</th>
					<th>Gender</th>
					<th>Origin</th>
					<th style="color: #AD32FF;">Votes</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allBabys}" var="oneBaby">
					<tr>

						<td><c:if
								test="${oneBaby.votedUsers.contains(currentUser) eq false }">
								<a href="/addToVoteList/${oneBaby.id }"
									class="btn btn-secondary">Upvote</a>
							</c:if> <c:if test="${oneBaby.votedUsers.contains(currentUser)  }">
								<a href="/removeFromVoteList/${oneBaby.id }"
									class="btn btn-secondary">Remove</a>
							</c:if></td>
						<td><a href="/names/${oneBaby.id }"> <c:out
									value="${oneBaby.babyname }" /></a></td>
						<td>
						<c:if test="${oneBaby.gender == 0 }">
						Neutral
						</c:if>
						<c:if test="${oneBaby.gender == 1 }">
						Male
						</c:if>
						<c:if test="${oneBaby.gender == 2 }">
						Female
						</c:if>
						</td>
						<td><c:out value="${oneBaby.origin }"></c:out></td>
						<td style="color: #AD32FF;"><c:out value="${oneBaby.votedUsers.size() }"></c:out></td>


					</tr>
				</c:forEach>
			</tbody>
		</table>
<br>
<br>
		<a href="/names/new" class="btn btn-success">> new name</a>

	</div>
</body>
</html>