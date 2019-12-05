<%@ page import="beans.User" %>
<%@ page import="DAO.GetAUser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    HttpSession ses=request.getSession();
    User userSes=null;
    if(ses.getAttribute("loggingUser")!=null)
        userSes=(User)ses.getAttribute("loggingUser");
    GetAUser getAUser=new GetAUser();

    assert userSes != null;
    userSes = getAUser.getAUser(userSes.getStuNo());
%>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>后台管理</title>
    <link rel="stylesheet" href="resources/css/basicUi.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="resources/bootstrap-4.0.0-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="resources/bootstrap-4.0.0-dist/js/jquery-3.4.1.min.js" type="text/javascript"></script>
    <script src="resources/bootstrap-4.0.0-dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    <script src="resources/bootstrap-4.0.0-dist/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<div id="wrap">
    <div id="menu_zone">
        <div id="logo_zone">
            <img class="TBCenter" id="logo_Img" src="resources/img/charB.jpg" alt="logo">
            <span class="TBCenter">图书后台管理</span>
        </div>
        <div id="userInfo_zone">
            <p id="user"><%=userSes.getUsername()%></p>
            <p id="stuNo">
                <span><%=userSes.getStuNo()%></span>
            </p>
            <p>
                <a href="#" id="logout">退出登录</a>
            </p>

        </div>
        <div class="menu_title">
            <p>
                <span>借阅与归还</span>
            </p>
        </div>
        <div class="menu_item">
            <img src="resources/img/icon_source_grey.png" alt="借阅记录">
            借阅管理
        </div>
        <div class="menu_item">
            <img src="resources/img/icon_user_grey.png" alt="借阅查询">
            违约管理
        </div>
        <div class="menu_title">
            <p>
                <span>信息查询</span>
            </p>
        </div>
        <div class="menu_item">
            <img src="resources/img/icon_change_grey.png" alt="条件查询">
            条件查询
        </div>
        <div class="menu_item">
            <img src="resources/img/icon_card_grey.png" alt="学生信息">
            学生信息
        </div>
        <div class="menu_title">
            <p>
                <span>图书管理</span>
            </p>
        </div>
        <div class="menu_item">
            <img src="resources/img/icon_house_grey.png" alt="馆藏信息">
            馆藏信息
        </div>
        <div class="menu_item">
            <img src="resources/img/icon_user_grey.png" alt="添加图书">
            添加图书
        </div>
        <div class="menu_title">
            <p>
                <span>设置</span>
            </p>
        </div>
        <div class="menu_item">
            <img src="resources/img/icon_rule_grey.png" alt="信息设置">
            信息设置
        </div>
    </div>
    <div id="show_zone">
        <div id="borrowManege">
            <button class="btn btn-outline-warning mt-3 mb-3" type="button">添加记录</button>
            <div id="tables">

            </div>
        </div>

    </div>
</div>
</body>
</html>
