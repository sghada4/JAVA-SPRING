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
   <h1>Edit Burger</h1>
   <a href="/">Go back</a>
    <form:form action="/burgers/${burger.id}" method="post" modelAttribute="burger">
    <input type="hidden" name="_method" value="put">
         <form:errors path="*" style="color:red;"/>     
    <div class="form-group mx-sm-3 mb-2">
        <form:label path="name">Burger Name</form:label>
        <form:input path="name" class="form-control"/>
    </div>
    <div class="form-group mx-sm-3 mb-2">
        <form:label path="restaurant">Restaurant Name</form:label>
        <form:input path="restaurant" class="form-control"/>
    </div>
    <div class="form-group mx-sm-3 mb-2">
        <form:label path="rating">Rating</form:label>
        <form:input type="number" path="rating" class="form-control"/>
    </div>  
    <div class="form-group mx-sm-3 mb-2">
        <form:label path="notes">Notes</form:label>
        <form:textarea path="notes" class="form-control"/>
    </div>  
    <input type="submit" value="Submit" class="btn btn-primary"/>
</form:form>
</div>    
</body>
</html>