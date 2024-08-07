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
    <title>Burger Tracker</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   <div class="container">
   <h1>Burger Tracker</h1>
   <table class="table">
   	<thead>
   		<tr>
   			<th>Burger Name</th>
   			<th>Restaurant Name</th>
   			<th>Rating (out of 5)</th>
   			<th>Action</th>
   		</tr>
   	</thead>
   	<tbody>
   	<c:forEach var="oneburger" items="${allBurgers}">
   	<tr>
   		<td>${oneburger.name}</td>
   		<td>${oneburger.restaurant}</td>
   		<td>${oneburger.rating}</td>
   		<td> <a href="/burgers/edit/${oneburger.id}" class="btn btn-secondary">Edit</a> </td>
   	</tr>
   	</c:forEach>
   	</tbody>
   </table>
   <br>
   <br>
   <br>
   <h1>Add a Burger</h1>
    <form:form action="/burgers" method="post" modelAttribute="burger">
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