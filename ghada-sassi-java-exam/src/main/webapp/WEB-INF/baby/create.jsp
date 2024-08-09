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
    <title>Create New Name</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container">
   		<h1>Add a name!</h1>

   <hr />
   <div class="col-5" >
 <form:form action="/babies" method="post" modelAttribute="baby">
 	
         <form:errors path="*" class="text-danger"/>
         <form:hidden path="postedBy" value="${user.id}"/>     
    <div class="mb-3">
        <form:label class="form-label" path="babyname">New Name: </form:label>
        <form:input class="form-control" path="babyname"/>
    </div>
    <div class="mb-3">
    <form:label class="form-label" path="gender">Typical Gender: </form:label>
    <form:select path="gender" class="form-select" >
    
    <form:option value="0">Neutral</form:option>
    <form:option value="1">Male</form:option>
    <form:option value="2">Female</form:option>
    </form:select>
    </div>
    <div class="mb-3">
        <form:label class="form-label" path="origin">Origin: </form:label>
        <form:input class="form-control" path="origin"/>
<%-- <form:hidden path="author" value="${userID }"/> --%>
    </div>
    <div class="mb-3">
        <form:label class="form-label" path="meaning">Meaning: </form:label>
        <form:textarea class="form-control" path="meaning"/>
    </div>    
    
    <br />
    <input type="submit" value="Submit" class="btn btn-success"/>
    <a href="/home" class="btn btn-danger" style="margin-left: 380px;">Cancel</a>
</form:form>    
</div>
 	</div>
</body>
</html>