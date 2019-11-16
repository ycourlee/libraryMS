<%@ page import="beans.User" %>
<%@ page import="DAO.GetAUser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    HttpSession ses=request.getSession();
    User userSes=(User)ses.getAttribute("loggingUser");
    GetAUser getAUser=new GetAUser();
    userSes = getAUser.getAUser(userSes.getStuNo());
%>
<html>
<head>
    <title>后台</title>
</head>
<body>
<h3>welcome friend</h3>
<%=userSes.getStuNo()%>
<%=userSes.getUsername()%>
<%=userSes.getPassword()%>
</body>
</html>
