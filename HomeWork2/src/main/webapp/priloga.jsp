<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.*, java.text.*" %>

<html>
<head>
    <title>Proga</title>
    <meta charset="utf-8">
</head>
<body>
<jsp:useBean id="user" class="by.it_academy.jd2.web.servlets.chat.User" scope="application"/>
<form action="proga" method="post">
    Введите ваши сообщение, <%= user.getUser()%><br>
    Для просмотра сообщений введите "exit"<br>
    <input type="text" name="name" required><br><br>
    <br>

    <button type="submit">Submit</button>
</form>
</body>
</html>