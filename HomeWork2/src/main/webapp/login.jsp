<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>


<html>
<head>
    <title>Форма входа в систему</title>
    <meta charset="utf-8">
</head>
<body>
<br>
<h1>Вход в систему</h1>
<form action="Registration" method="post">
    <table style="with: 50%">

        <tr>
            <td>Логин:</td>
            <td><input type="text" name="user" size="10" /></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type="password" name="password" size="10" /></td>
        </tr>
    </table>
    <table style="with: 50%">
        <tr>
            <th><small>
                <input type="submit" name="login" value="Войти в систему">
            </small>
            <th><small>
                <input type="submit" name="registration" value="Зарегистрироваться">
            </small>
    </table>
</form>
<br>
</body>
</html>