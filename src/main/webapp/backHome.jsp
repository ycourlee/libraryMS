<%@ page import="beans.User" %>
<%@ page import="DAO.GetAUser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    HttpSession ses = request.getSession();
    User userSes = null;
    if (ses.getAttribute("loggingUser") != null)
        userSes = (User) ses.getAttribute("loggingUser");
    GetAUser getAUser = new GetAUser();

    assert userSes != null;
    userSes = getAUser.getAUser(userSes.getStuNo());
%>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>后台管理</title>
    <%--    <link rel="stylesheet" href="resources/css/basicUi.css"/>--%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="resources/bootstrap-4.0.0-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="resources/bootstrap-4.0.0-dist/js/jquery-3.4.1.min.js" type="text/javascript"></script>
    <script src="resources/bootstrap-4.0.0-dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    <script src="resources/bootstrap-4.0.0-dist/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<%--<div class="">--%>
<%--<div id="menu_zone">
    <div id="logo_zone">
        <img class="TBCenter" id="logo_Img" src="resources/img/charB.jpg" alt="logo">
        <span class="TBCenter">图书后台管理</span>
    </div>
    <div id="userInfo_zone">
        <p id="user"><%=userSes.getUsername()%>
        </p>
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
</div>--%>

<div class="pl-4 col-2 h-100 bg-info float-left">
    <div class="mt-3 mb-3">
        <img class="rounded" src="resources/img/charB.jpg" alt="logo" width="26">
        <span class="">图书后台管理</span>
    </div>
    <div>
        <p class="mt-2 mb-0 font-weight-bold">
            <%=userSes.getUsername()%>
        </p>
        <p class="mt-1 mb-0">
            <small><%=userSes.getStuNo()%>
            </small>
        </p>
        <p class="mt-1 mb-0">
            <a href="#" class="text-primary"><small>退出登录</small></a>
        </p>

    </div>
    <div class="btn-group-vertical">
        <p class="mt-3 mb-1">借阅与归还</p>

        <button type="button" class="btn btn-info text-dark"><img src="resources/img/icon_source_grey.png"
                                                                  alt="借阅记录" width="24">借阅管理
        </button>
        <button type="button" class="btn btn-info text-dark"><img src="resources/img/icon_user_grey.png" alt="借阅查询"
                                                                  width="24">违约管理
        </button>
    </div>
    <div class="btn-group-vertical">
        <p class="mt-3 mb-1">信息查询</p>
        <button type="button" class="btn btn-info text-dark"><img src="resources/img/icon_change_grey.png" alt="条件查询"
                                                                  width="24">条件查询
        </button>
        <button type="button" class="btn btn-info text-dark"><img src="resources/img/icon_card_grey.png" alt="学生信息"
                                                                  width="24">
            学生信息
        </button>
    </div>
    <div class="btn-group-vertical">
        <p class="mt-3 mb-1">图书管理</p>
        <button type="button" class="btn btn-info text-dark"><img src="resources/img/icon_house_grey.png" alt="馆藏信息" width="24">
            馆藏信息
        </button>
        <button type="button" class="btn btn-info text-dark"><img src="resources/img/icon_user_grey.png" alt="添加图书" width="24">
            添加图书
        </button>
    </div>

    <div class="btn-group-vertical">
        <p class="mt-3 mb-1">设置</p>
        <button type="button" class="btn btn-info text-dark"><img src="resources/img/icon_rule_grey.png" alt="信息设置" width="24">
            信息设置
        </button>
    </div>
</div>
<div class="float-left container col-10 h-100 bg-light">
    <%--        借阅管理--%>
    <div>
        <button class="btn btn-outline-warning mt-3 mb-3" type="button">添加记录</button>
        <div class="">
            <table class="table table-hover">
                <thead class="w-75 thead-light">
                <tr>
                    <th>记录号</th>
                    <th>书名</th>
                    <th>借阅人学号</th>
                    <th>借阅人姓名</th>
                    <th>借阅天数</th>
                    <th>借阅期限</th>
                </tr>
                </thead>
                <tbody class="w-100">
                <tr>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>2</td>
                    <td>2</td>
                    <td>2</td>
                    <td>2</td>
                    <td>2</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>3</td>
                    <td>3</td>
                    <td>3</td>
                    <td>3</td>
                    <td>3</td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>4</td>
                    <td>4</td>
                    <td>4</td>
                    <td>4</td>
                    <td>4</td>
                </tr>
                <tr>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                </tr>
                <tr>
                    <td>6</td>
                    <td>6</td>
                    <td>6</td>
                    <td>6</td>
                    <td>6</td>
                    <td>6</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%--</div>--%>
</body>
</html>
