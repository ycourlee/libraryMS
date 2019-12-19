<%@ page import="beans.User" %>
<%@ page import="DAO.GetAUser" %>
<%@ page import="DAO.UserBRList" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.UserBR" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    int pageSize = 8;
//    int pageNow = 1;
    int totalLines;
    int totalPages;

    HttpSession ses = request.getSession();
    User userSes = null;
    if (ses.getAttribute("loggingUser") != null)
        userSes = (User) ses.getAttribute("loggingUser");
    GetAUser getAUser = new GetAUser();

    assert userSes != null;
    userSes = getAUser.getAUser(userSes.getStuNo());

    ArrayList<UserBR> ubrList = new UserBRList().getUserBRList(userSes.getStuNo());
    totalLines = ubrList.size();
    totalPages = (int) Math.ceil(totalLines * 1.0 / pageSize);
%>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>个人管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.staticfile.org/twitter-bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/3.4.1/jquery.min.js" type="text/javascript"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.0.0/js/bootstrap.bundle.min.js"
            type="text/javascript"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.0.0/js/bootstrap.min.js"
            type="text/javascript"></script>
    <script src="resources/js/home.js"></script>
</head>
<body>
<%--左边菜单栏--%>
<div class="fixed-top pl-4 col-2 h-100 bg-info float-left">
    <div class="mt-3 mb-3">
        <img class="rounded" src="resources/img/charB.jpg" alt="logo" width="26">
        <span class="">图书个人管理</span>
    </div>
    <div>
        <p id="uName" class="mt-2 mb-0 font-weight-bold"><%=userSes.getUsername()%>
        </p>
        <p class="mt-1 mb-0">
            <small><%=userSes.getStuNo()%>
            </small>
        </p>
        <p class="mt-1 mb-0">
            <a href="logoutServlet" class="text-primary"><small>退出登录</small></a>
        </p>
    </div>
    <div class="btn-group-vertical">
        <p class="mt-3 mb-1">借阅与归还</p>
        <button id="myBBtn" type="button" class="btn btn-info text-dark"><img src="resources/img/icon_source_grey.png"
                                                                              alt="借阅查询" width="24">我借的书
        </button>
        <button id="wyBtn" type="button" class="btn btn-info text-dark"><img src="resources/img/icon_user_grey.png"
                                                                             alt="借阅查询" width="24">违约管理
        </button>
    </div>
    <div class="btn-group-vertical">
        <p class="mt-3 mb-1">信息查询</p>
        <button id="xsBtn" type="button" class="btn btn-info text-dark"><img src="resources/img/icon_card_grey.png"
                                                                             alt="学生信息"
                                                                             width="24">学生信息
        </button>
    </div>
    <div class="btn-group-vertical">
        <p class="mt-3 mb-1">图书管理</p>
        <button id="gcBtn" type="button" class="btn btn-info text-dark"><img src="resources/img/icon_house_grey.png"
                                                                             alt="馆藏信息"
                                                                             width="24">馆藏信息
        </button>
    </div>

    <div class="btn-group-vertical">
        <p class="mt-3 mb-1">设置</p>
        <button id="xxBtn" type="button" class="btn btn-info text-dark"><img src="resources/img/icon_rule_grey.png"
                                                                             alt="信息设置"
                                                                             width="24">信息设置
        </button>
    </div>
</div>
<%--右边内容区--%>
<div class="float-right container col-10 bg-light">
    <div id="myBrDiv" style="display: block">
        <div class="container-fluid mr-0 ml-0">
            <table class="table table-hover row mx-0 mb-0 mt-5">
                <thead class="w-100 thead-light">
                <tr class="row">
                    <th class="col-1">书号</th>
                    <th class="col-2">书名</th>
                    <th class="col-1">作者</th>
                    <th class="col-1">版本</th>
                    <th class="col-1">借阅天数</th>
                    <th class="col-2">截止日期</th>
                    <th class="col-3">书本简评</th>
                    <th class="col-1 text-left">价格</th>
                </tr>
                </thead>
                <tbody class="w-100">
                <%
                    for (int pageNow = 1; pageNow <= totalPages; pageNow++) {
                        for (int i = (pageNow - 1) * pageSize; i < totalLines && i < pageNow * pageSize; i++) {
                            out.println("               <tr style=\"display: none\" id=\"tr" + ubrList.get(i).getBookNo() + "\"  class=\"row page" + pageNow + "\">\n" +
                                    "                   <th class=\"col-1 td1\">" + ubrList.get(i).getBookNo() + "</th>\n" +
                                    "                   <td class=\"col-2 td2\">" + ubrList.get(i).getBookName() + "</td>\n" +
                                    "                   <td class=\"col-1 td3\">" + ubrList.get(i).getAuthor() + "</td>\n" +
                                    "                   <td class=\"col-1 td4\">" + ubrList.get(i).getVersion() + "</td>\n" +
                                    "                   <td class=\"col-1 td5\">" + ubrList.get(i).getBrDays() + "</td>\n" +
                                    "                   <td class=\"col-2 td6\">" + ubrList.get(i).getDeadline() + "</td>\n" +
                                    "                   <td class=\"col-3 td7\">" + ubrList.get(i).getbCmt() + "</td>\n" +
                                    "                   <td class=\"col-1 text-left td8\">" + ubrList.get(i).getPrice() + "</td>\n" +
                                    "               </tr>");
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>


    <%--    学生信息栏目--%>
    <div id="xsDiv" style="display: none">
        <div class="container-fluid mr-0 ml-0">
            <h4 class="mt-5">用户信息</h4>
            <form role="form">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text">你的名字</span>
                    </div>
                    <input id="" class="form-control" type="text">
                </div>

            </form>
        </div>
    </div>
    <%--    馆藏信息栏目--%>
    <div id="bookInfoDiv" style="display: none">
        <div class="container-fluid mr-0 ml-0">
            <table class="table table-hover row mx-0 mb-0">
                <thead class="w-100 thead-light">
                <tr class="row">
                    <th class="col-1">书号</th>
                    <th class="col-2">书名</th>
                    <th class="col-1">作者</th>
                    <th class="col-1">馆藏数目</th>
                    <th class="col-1">版本</th>
                    <th class="col-2">书本简评</th>
                    <th class="col-1 text-right">价格</th>
                    <th class="col-1 text-right">出版日期</th>
                    <th class="col-2">出版社</th>
                </tr>
                </thead>
                <tbody class="w-100">

                </tbody>
            </table>
        </div>
    </div>
</div>
<%--分页组件--%>
<div class="float-right">
    <div class="col align-items-end">
        <ul class="pagination" onselectstart="return false">
            <li id="1" class="page-item"><a id="stPage" class="page-link"><<</a></li>
            <li id="2" class="page-item"><a id="prePage" class="page-link"><</a></li>
            <li id="3" class="page-item active"><a id="curPage" class="page-link">1
            </a></li>
            <li id="4" class="page-item"><a id="nextPage" class="page-link">></a></li>
            <li id="5" class="page-item"><a id="edPage" class="page-link">>>
            </a></li>
            <li class="page-item">
                <button id="pageJump" class="btn page-link" type="button">点我转到:</button>
            </li>
            <li class="page-item">
                <label>
                    <input id="jumpPNo" class="page-link" type="text" size="1" value="1">
                </label>
            </li>
            <li class="page-item"><label class="page-link disabled">页</label></li>
        </ul>
    </div>
</div>

<div class="float-right">
    <div class="col">
        <ul class="pagination">
            <li class="page-item">
                <label class="page-link disabled" onselectstart="return false">
                    显示第<span id="pageNow">1</span>页：
                    <span id="stRd">1</span>-
                    <span id="edRd">
                        <%=pageSize%>
                    </span>条记录，共
                    <span id="totalPages">
                        <%=totalPages%>
                    </span>
                    页<%=totalLines%>条
                </label>
            </li>
        </ul>
    </div>
</div>

</body>
</html>
