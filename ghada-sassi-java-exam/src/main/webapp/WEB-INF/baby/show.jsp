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
<title>Show ${baby.babyname }</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container" style="margin-top: 50px">
	<div class="card" style="width: 400px; padding: 10px">
		<h1>${baby.babyname }</h1>
  <div class="card-body">
    <h5 class="card-title">(added by ${baby.postedBy.userName })</h5>
    <h6 class="card-subtitle mb-2 text-muted">Gender:
			<c:if test="${baby.gender == 0 }">
						Neutral
						</c:if>
			<c:if test="${baby.gender == 1 }">
						Male
						</c:if>
			<c:if test="${baby.gender == 2 }">
						Female
						</c:if></h6>
    <p class="card-text">Origin: ${baby.origin }</p>
    <c:if test="${baby.votedUsers.contains(currentUser)}">
			<h5 class="card-subtitle mb-2 " style="color: #AD32FF;">You voted for this name.</h5>
		</c:if>
		<c:if test="${baby.votedUsers.contains(currentUser) eq false}">
			<c:if
								test="${baby.votedUsers.contains(currentUser) eq false }">
								<a href="/addToVoteList/${baby.id }"
									class="card-link btn btn-secondary">Upvote</a>
							</c:if> 
		</c:if>
    <p class="card-text">Meaning: ${baby.meaning }</p>
    <a href="/home" class="card-link btn btn-outline-danger" style="margin-right: 60px;">Home</a>
		<c:if test="${baby.postedBy.id eq userID }"> 
							<a href="/names/${baby.id }/edit" class="card-link btn btn-success">> Edit</a>
		
		</c:if>

  </div>
</div>
		
	</div>
</body>
</html>