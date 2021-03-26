<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>

<html>
<head>
    <title>Форма регистрации</title>
    <meta charset="utf-8">
</head>
<body>
<h1>Регистрация</h1>
<form action="AddUser" method="post">
    <table style="with: 50%">
        <tr>
            <td>Логин:</td>
            <td><input type="text" name="user" size="20" /></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type="password" name="password" size="20" /></td>
        </tr>
        <tr>
            <td>ФИО:</td>
            <td><input type="text" name="fio" size="20" /></td>
        </tr>
        <td>Дата рождения:</td>
        <td><input type="date" name="calendar" size="20" /></td>
        </tr>
    </table>
    <tr>
        <th><small>
            <input type="submit" name="save" value="Сохранить">
        </small>
        <th><small>
            <input type="submit" name="cancel" value="Выйти">
        </small>
            </table>
</form>
</body>
</html>