<%@ page import="beans.User" %>
<%@ page import="DAO.GetAUser" %>
<%@ page import="beans.BorrowRecord" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    int pageSize = 8;
    int totalLines = 20;
    int pageNow = 2;
    int totalPages;

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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="resources/bootstrap-4.0.0-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="resources/bootstrap-4.0.0-dist/js/jquery-3.4.1.min.js" type="text/javascript"></script>
    <script src="resources/bootstrap-4.0.0-dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    <script src="resources/bootstrap-4.0.0-dist/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<%--左边菜单栏--%>
<div class="fixed-top pl-4 col-2 h-100 bg-info float-left">
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
        <button type="button" class="btn btn-info text-dark"><img src="resources/img/icon_house_grey.png" alt="馆藏信息"
                                                                  width="24">
            馆藏信息
        </button>
        <button type="button" class="btn btn-info text-dark"><img src="resources/img/icon_user_grey.png" alt="添加图书"
                                                                  width="24">
            添加图书
        </button>
    </div>

    <div class="btn-group-vertical">
        <p class="mt-3 mb-1">设置</p>
        <button type="button" class="btn btn-info text-dark"><img src="resources/img/icon_rule_grey.png" alt="信息设置"
                                                                  width="24">
            信息设置
        </button>
    </div>
</div>
<%--右边内容区--%>
<div class="float-right container col-10 bg-light">
    <%--    借阅管理--%>
    <button class="btn btn-outline-warning mt-3 mb-3" type="button" data-toggle="modal" data-target="#addModal">添加记录
    </button>
    <%--        添加借阅记录模态框--%>
    <div class="modal fade" id="addModal">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- 模态框头部 -->
                <div class="modal-header">
                    <h4 class="modal-title">请输入借阅记录信息：</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- 模态框主体 -->
                <div class="modal-body">
                    <form id="insert" role="form" action="#" method="get">
                        <div class="input-group pb-3">
                            <div class="input-group-prepend">
                                <label class="input-group-text" for="stuNo">借阅人学号：</label>
                            </div>
                            <input type="text" class="form-control" name="stuNo" id="stuNo" placeholder="1000111000"
                                   required>
                        </div>
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <label class="input-group-text" for="bookNo">借阅书籍号：</label>
                            </div>
                            <input type="password" class="form-control" name="text" id="bookNo" placeholder="password"
                                   required>
                        </div>
                    </form>
                </div>

                <!-- 模态框底部 -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                    <button type="submit" form="insert" class="btn btn-success">插入</button>
                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid mr-0 ml-0">
        <table class="table table-hover row mx-0 mb-0">
            <thead class="w-100 thead-light">
            <tr class="row">
                <th class="col-1">记录号</th>
                <th class="col-2">书名</th>
                <th class="col-2">借阅人学号</th>
                <th class="col-2">借阅人姓名</th>
                <th class="col-1">借阅天数</th>
                <th class="col-2 text-right">借阅期限</th>
                <th class="col-2 text-right">操作</th>
            </tr>
            </thead>
            <tbody class="w-100">
            <%
                ArrayList<BorrowRecord> brs = new ArrayList<>();

                BorrowRecord br;
                for (int i = 1; i <= totalLines; i++) {
                    br = new BorrowRecord();
                    brs.add(br);
                }
                totalPages = (int) Math.ceil(totalLines * 1.0 / pageSize);
                System.out.println(totalPages);
                if (pageNow == totalPages) {
                    for (int i = (pageNow - 1) * pageSize + 1; i <= totalLines; i++) {
                        out.println("<tr class=\"row\">\n" +
                                "                <th class=\"col-1\">" + brs.get(i).getRecordId() + "</th>\n" +
                                "                <td class=\"col-2\">" + brs.get(i).getBookName() + "</td>\n" +
                                "                <td class=\"col-2\">" + brs.get(i).getStuNo() + "</td>\n" +
                                "                <td class=\"col-2\">" + brs.get(i).getUsername() + "</td>\n" +
                                "                <td class=\"col-1\">" + brs.get(i).getBorrowDays() + "</td>\n" +
                                "                <td class=\"col-2 text-right\">" + brs.get(i).getDeadline() + "</td>\n" +
                                "                <td class=\"col-2 text-right\">\n" +
                                "                    <button class=\"btn btn-success btn-sm\" type=\"button\">修改</button>\n" +
                                "                    <button class=\"btn btn-danger btn-sm\" type=\"button\" data-toggle=\"modal\" data-target=\"#deleteModal\">删除</button>\n" +
                                "                </td>\n" +
                                "            </tr>");
                    }
                } else {
                    for (int i = (pageNow - 1) * pageSize + 1; i <= pageNow * pageSize; i++) {
                        out.println("<tr class=\"row\">\n" +
                                "                <th class=\"col-1\">" + brs.get(i).getRecordId() + "</th>\n" +
                                "                <td class=\"col-2\">" + brs.get(i).getBookName() + "</td>\n" +
                                "                <td class=\"col-2\">" + brs.get(i).getStuNo() + "</td>\n" +
                                "                <td class=\"col-2\">" + brs.get(i).getUsername() + "</td>\n" +
                                "                <td class=\"col-1\">" + brs.get(i).getBorrowDays() + "</td>\n" +
                                "                <td class=\"col-2 text-right\">" + brs.get(i).getDeadline() + "</td>\n" +
                                "                <td class=\"col-2 text-right\">\n" +
                                "                    <button class=\"btn btn-success btn-sm\" type=\"button\">修改</button>\n" +
                                "                    <button class=\"btn btn-danger btn-sm\" type=\"button\" data-toggle=\"modal\" data-target=\"#deleteModal\">删除</button>\n" +
                                "                </td>\n" +
                                "            </tr>");
                    }
                }

            %>

            </tbody>
        </table>
    </div>

</div>
<div class="float-right">
    <div class="col align-items-end">
        <ul class="pagination">
            <li class="page-item"><a id="prePage" class="page-link"><</a></li>
            <li class="page-item"><a id="topPage" class="page-link">首页</a></li>
            <%

                if (totalPages == 1) {
                    out.println("<li class=\"page-item active\"><a id=\"pageDis1\" class=\"page-link\">1</a></li>");
                } else if (totalPages == 2) {
                    out.println("<li class=\"page-item active\"><a id=\"pageDis1\" class=\"page-link\">1</a></li>");
                    out.println("<li class=\"page-item\"><a id=\"pageDis2\" class=\"page-link\">2</a></li>");
                } else {
                    out.println("<li class=\"page-item active\"><a id=\"pageDis1\" class=\"page-link\">1</a></li>");
                    out.println("<li class=\"page-item\"><a id=\"pageDis2\" class=\"page-link\">2</a></li>");
                    out.println("<li class=\"page-item\"><a id=\"pageDis3\" class=\"page-link\">...</a></li>");
                }
            %>
            <li class="page-item"><a class="page-link">尾页</a></li>
            <li class="page-item"><a class="page-link">></a></li>
            <li class="page-item">
                <button class="btn page-link" type="button">转到:</button>
            </li>
            <li class="page-item"><label>
                <input class="page-link" type="text" size="1" value="<%=pageNow%>">
            </label></li>
            <li class="page-item"><label class="page-link disabled">页</label></li>
        </ul>
    </div>

    <%--    删除操作模态框--%>
    <div class="modal fade" id="deleteModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <!-- 模态框头部 -->
                <div class="modal-header">
                    <h4 class="modal-title">confirm!</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- 模态框主体 -->
                <div class="modal-body">
                    <p class="text-danger">一经删除不可撤销！您确认删除吗？</p>
                </div>
                <!-- 模态框底部 -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-danger">删除</button>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
