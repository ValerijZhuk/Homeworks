<!DOCTYPE html>

<%@ page import="by.it_academy.jd2.core.view.User" %>
<%@ page import="by.it_academy.jd2.core.tool.DataMessage" %>
<%@ page import="by.it_academy.jd2.core.Constants" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="by.it_academy.jd2.data.DaoFactory" %>
<%@ page import="by.it_academy.jd2.data.DatabaseName" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Chat</title>
    <meta charset="utf-8">
</head>
<body>

<% User userSender = (User) request.getSession().getAttribute("userSender");%>
<p><span style='color: red;'> Получатель <%=userSender.getName()%> </span></p>

<%
    String print = (String) request.getAttribute("printMSG");
    out.write(print);
%>

<br><br>
<hr>
<form action="message" method="get">
    <button type="submit">Отправить сообщение</button>
    <br><br>
</form>
<form action="menu" method="get">
    <br>
    <button type="submit">Выход в меню</button>
    <br><br>
</form>
<form action="signIn">
    <button type="submit">Выйти из приложения</button>
    <br><br>
</form>
<hr>

</body>
</html>
