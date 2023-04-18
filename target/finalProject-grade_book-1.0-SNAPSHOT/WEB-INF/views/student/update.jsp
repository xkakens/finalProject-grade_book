<%--
  Created by IntelliJ IDEA.
  User: michalszyba
  Date: 18/04/2023
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Zmień dane</h1>
<form action="/student/update" method="post">
  <input type="text" placeholder="Imię" value="${student.firstName}"name="firstName"/><br>
  <input type="text" placeholder="Nazwisko" value="${student.lastName}" name="lastName"></br>
  Numer telefonu rodzica 1<input type="number" value="0" name="parentOnePhoneNumber"/><br>
  Numer telefonu rodzica 2<input type="number" value="0" name="parentTwoPhoneNumber"/><br>
  <input type="date" name="dateOfBirth"/><br>
  <input type="submit" value="Zapisz">
</form>
</body>
</html>
