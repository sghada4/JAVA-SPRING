<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold Game</title>
</head>
<body>
	<p>Your Gold: <span style="font-size: x-large; font-weight: bold;"> <c:out value="${gold}"/> </span> </p>
<table style="width: 800px">
    <tbody>
        <tr>
            <td>
                <h3>Farm</h3>
                <p>(earns 10-20 gold)</p>
                <form action="/" method="post">
                	<input class="button" type="submit" name="farm" value="Find Gold!"/>
                </form>
            </td>
            <td>
                <h3>Cave</h3>
                <p>(earns 5-10 gold)</p>
                <form action="/" method="post">
                	<input class="button" type="submit" name="cave" value="Find Gold!"/>
                </form>
            </td>
            <td>
                <h3>House</h3>
                <p>(earns 2-5 gold)</p>
                <form action="/" method="post">
                	<input class="button" type="submit" name="house" value="Find Gold!"/>
                </form>
            </td>
            <td>
                <h3>Quest</h3>
                <p>(earns/takes 0-50 gold)</p>
                <form action="/" method="post">
                	<input class="button" type="submit" name="quest" value="Find Gold!"/>
                </form>
            </td>
        </tr>
    </tbody>
</table>
<h3>Activities:</h3>
<iframe src="/activities" title="Activities Iframe" style="width: 700px"></iframe>
</body>
</html>