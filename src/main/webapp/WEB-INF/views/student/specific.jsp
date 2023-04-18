<%--
  Created by IntelliJ IDEA.
  User: michalszyba
  Date: 17/04/2023
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<br>
Imie: ${student.firstName}<br/>
Nazwisko: ${student.lastName}<br/>
Wiek: ${age}<br/>
Data urodzenia: ${student.dateOfBirth}
<a href="update/${student.id}"> Zmień dane </a>
</body>
</html>
