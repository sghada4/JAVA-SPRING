<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container">
	<h1>Add a Book to Your Shelf!</h1>
	<a href="/books">back to the shelves</a>
   		<form:form action="/books" method="post" modelAttribute="book">
 	
         <form:errors path="*" class="text-danger"/>     
    <p>
        <form:label path="title">Title</form:label>
        <form:input path="title"/>
    </p>
    <p>
        <form:label path="author">Author</form:label>
        <form:input path="author"/>
    </p>
    
    <p>
        <form:label path="thoughts">My Thoughts</form:label>
        <form:textarea path="thoughts"/>
    </p>    
    <p>
        
        <form:hidden path="postedBy" value="${user.id}"/>
    </p>    
    
    <br />
    <input type="submit" value="Submit" class="btn btn-success"/>
</form:form>    
 	</div>
</body>
</html>