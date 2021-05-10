<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${Boolean.parseBoolean(invalidUserLogin)}">
    <h4><span style='color: red;'>Пользователь с таким логином уже существует!<br>
        Попробуйте снова!
    </span></h4>
</c:if>
<%request.setAttribute("invalidUserLogin", false);%>
<html>

<head>
    <title>SignUp</title>
    <meta charset="utf-8">
</head>
<body>

<form method="post" action="signUp">
    <h1>Регистрация</h1>
    <p>Пожалуйста, введите ваши данные.</p>
    <hr>

    <table style="with: 50%">
        <tr>
            <td>Логин:</td>
            <td><input type="text" name="login" size="20" /></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type="password" name="psw" size="20" /></td>
        </tr>
        <tr>
            <td>ФИО:</td>
            <td><input type="text" name="name" size="20" /></td>
        </tr>
        <td>Дата рождения:</td>
        <td><input type="date" name="birthday" size="20" /></td>
        </tr>
    </table>

    <hr>
    <button type="submit">Зарегистрироваться</button><br><br>

</form>
<form action="signIn" method="get">
    <hr>
    Если уже зарегистрированы <br><br>
    <button type="submit">Авторизация</button>
    <br><br>
</form>
</body>
</html>