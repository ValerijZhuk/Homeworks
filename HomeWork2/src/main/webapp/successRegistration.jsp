<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Страница подтверждения успешной регистрации посетителя</title>
</head>
    <body>
        <h1>Регистрация успешно завершена</h1>
        <jsp:useBean id="user" class="master.User" scope="application"/>
            Логин: <%= user.getUser()%><br>
            ФИО: <%= user.getFio()%><br>
            Дата рождения: <%= user.getDate()%><br>
            Зарегистрирован.<br><br>
        <a href="login.jsp">Войти в систему</a>
        <a href="priloga.jsp">Давай пообщаемся</a>
    </body>
</html>
