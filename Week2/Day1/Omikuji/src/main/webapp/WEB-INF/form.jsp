<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form</title>
</head>
<body>
<h1>Send an Omikuji!</h1>
<form action="/processForm" method="post">
<label>Pick any number from 5 to 25</label>
<br>
<input type="number" name="number">
<br>
<label>Enter the name of any city.</label>
<br>
<input name="city">
<br>
<label>Enter the name of any real person</label>
<br>
<input name="person">
<br>

<label>Enter professional endeavor or hobby:</label>
<br>
<input name="hobby">
<br>
<label>Enter any type of living thing.</label>
<br>
<input name="livingThing">
<br>
<label>Say something nice to someone:</label>
<br>
<textarea rows="4" cols="40" name="message"></textarea>
<br>
<p>Send and show a friend</p>
<br>
<button>Send</button>
</form>
</body>
</html>