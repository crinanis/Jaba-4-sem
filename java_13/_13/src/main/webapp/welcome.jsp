<%--
  Created by IntelliJ IDEA.
  User: ksu
  Date: 30.05.2022
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Войдите</title>
</head>
<body>
<div align="center">
    <h4>${result}</h4><br>
    <section class="container">
        <div class="form">
            <h0>Войти</h0>
            <form method="post" action="${pageContext.request.contextPath}/controller?command=login">
                <input name="login" type="text" placeholder="Username"><br>
                <input name="password" type="password" placeholder="Password"><br><br>
                <input class="button" type="submit" value="Войти"><br>
            </form>
        </div>
    </section>
    <a href="register.jsp">Зарегистрироваться</a>
</div>
</body>
</html>