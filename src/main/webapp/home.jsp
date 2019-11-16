<%@ page import="beans.User" %>
<%@ page import="DAO.GetAUser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    HttpSession ses=request.getSession();
    User userSes=(User)ses.getAttribute("loggingUser");
    GetAUser getAUser=new GetAUser();
    userSes = getAUser.getAUser(userSes.getStuNo());
%>

<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>后台</title>
</head>
<body>

</body>
</html>