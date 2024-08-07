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
	<h1>Here's Your Omikuji!</h1>
	<p>
		In
		<c:out value="${number}" />
		years, you will live in
		<c:out value="${city}" />
		with
		<c:out value="${person}" />
		as your roommate,
		<c:out value="${hobby}" />
		for a living. The next time you see a
		<c:out value="${livingThing}" />
		, you will have good luck. Also,
		<c:out value="${message}" />
	</p>
	<br>
	<a href="http://localhost:8080/omikuji">Go Back</a>
</body>
</html>