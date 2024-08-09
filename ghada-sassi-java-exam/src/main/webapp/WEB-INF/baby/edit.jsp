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
    <title>Edit ${baby.babyname }</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container">
   	<h1>Change ${baby.babyname }</h1>

   <hr />
   <div class="col-5" >
 <form:form action="/babies/${baby.id }" method="post" modelAttribute="baby">
 	<input type="hidden" name="_method" value="put">
         <form:errors path="*" class="text-danger"/>
         <form:hidden path="postedBy" value="${baby.postedBy.id}"/>     
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
    <a href="/home" class="btn btn-outline-danger" style="margin-left: 380px;">Cancel</a>
    
</form:form>   

<c:if test="${baby.postedBy.id eq userID }"> 
<div style="margin-top: 20px;">
						<form action="/babies/${baby.id}" method="post">
							<input type="hidden" name="_method" value="delete"> <input
								type="submit" value="Delete" class="btn btn-danger">
						</form>
						</div>
		</c:if> 
</div>
 	</div>
</body>
</html>