<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>
<html>
<body>
<FORM action="testform" method=POST>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Страница переписки</title>
    </head>
    <h1>Давай пообщаемся</h1>
    <jsp:useBean id="user" class="master.User" scope="application"/>
    Твой логин: <%= user.getUser()%><br>
    Твое ФИО: <%= user.getFio()%><br>
    <table style="with: 50%">
        <hr> <textarea name="body" type="text" rows=5 cols=45>
Добрый день!</textarea>
        <br>
        <tr>
            <th><small>
                <input type="submit" name="cancel" value="Отправить сообщение">
            </small>
    </table>
</body>
</html>