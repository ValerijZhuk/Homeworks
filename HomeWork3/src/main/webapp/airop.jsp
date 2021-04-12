<!DOCTYPE html>
<%@ page import="core.dto.AllAirports" %>
<%@ page import="core.dto.Airports" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Airports</title>
</head>
<body>
<h1>Список аэропортов отсотрированные по названию города</h1>
</form>
<table border="2">
    <body>
    <form action="airports" method="post">
        <tr>
            <td>${title.getCity()}</td>
            <td>${title.getAirport_name()}</td>
            <td>${title.getAirport_code()}</td>
            <td>${title.getCoordinates()}</td>
            <td>${title.getTimesone()}</td>

        </tr>

        <c:forEach items="${list}" var="airport">
            <tr>
                <td>${airport.getCity()}</td>
                <td>${airport.getAirport_name()}</td>
                <td>${airport.getAirport_code()}</td>
                <td>${airport.getCoordinates()}</td>
                <td>${airport.getTimesone()}</td>

            </tr>
        </c:forEach>
    </form>
    </body>
</table>
</body>
</html>