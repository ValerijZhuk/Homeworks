<%@ page import="by.it_academy.jd2.NameView" %>

<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Proga</title>
    <meta charset="utf-8">
</head>
<jsp:useBean id="user" class="by.it_academy.jd2.web.servlets.chat.User" scope="application"/>
<body>

<%= user.getUser()%> написал следущие сообщения:<br>
Для возврата нажмите кнопку назад вашего браузера<br>

<%=(String)request.getSession().getAttribute("list")%>

</body>
</html>