<%--
  Created by IntelliJ IDEA.
  User: timbe
  Date: 2022-02-14
  Time: 6:28 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="EmployeeServlet" method="GET">
    <input hidden value="create" name="checkVar"/>
    UserName: <input type="text" name="txtUserNameEdit"/>
    Password: <input type="text" name="txtUserNameEdit"/>
    First Name: <input type="text" name="txtUserNameEdit"/>
    Last Name: <input type="text" name="txtUserNameEdit"/>
    Email: <input type="text" name="txtUserNameEdit"/>
    Hire Date: <input type="text" name="txtUserNameEdit" placeholder="YYYY/MM/DD"/>
    <input type="submit">
</form>
</body>
</html>
