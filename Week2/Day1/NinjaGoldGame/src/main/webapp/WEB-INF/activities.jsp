<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>
<c:forEach var="activity" items="${activities}">
    <c:if test="${activity.contains('earned')}">
        <p style="color: #4AB954;">
        	<c:out value="${activity}"/>
        </p>
    </c:if>
    <c:if test="${activity.contains('lost')}">
        <p style="color: #DD5A5A;">
        	<c:out value="${activity}"/>
        </p>
    </c:if>
</c:forEach>
</body>
</html>