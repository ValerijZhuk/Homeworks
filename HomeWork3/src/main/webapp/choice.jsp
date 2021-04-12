<!DOCTYPE html>

<%@ page import="core.dto.AllAirports" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Choice</title>
</head>
<body>
<h1>Поиск  рейса</h1>

<form method="post" action="choice">
    <%--<form method="get" action="print">--%>


    Дата вылета: <input type="date" name="scheduledDeparture" value="2017-01-01"/>
    Аэропорт отправления:
    <select name="departureAirport" required>
        <c:forEach var="airports" items="${listB}">
            <option value="${airports.getAirport_code()}">${airports.getCity()} (${airports.getAirport_code()}) </option>
        </c:forEach>
    </select>

    Время прилета: <input type="date"  name="scheduledArrival" value="2017-01-01"/>
    Аэропорт прибытия:
    <select name="arrivalAirport" required>
        <c:forEach var="airports" items="${listB}">
            <option value="${airports.getAirport_code()}">${airports.getCity()} (${airports.getAirport_code()})  </option>
        </c:forEach>
    </select>
    <button onclick="myFunction()">Поиск</button>

    <hr>
    <script>
        function myFunction() {
            document.getElementById("scheduledDeparture").defaultValue = "2017-01-01";
            document.getElementById("scheduledArrival").defaultValue = "2017-01-01";
        }
    </script>
</form>

</body>
</html>