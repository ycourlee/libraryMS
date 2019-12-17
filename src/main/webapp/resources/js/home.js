$(document).ready(function () {
    var wyBtn$ = $("#wyBtn");
    var xsBtn$ = $("#xsBtn");
    var gcBtn$ = $("#gcBtn");
    var xxBtn$ = $("#xxBtn");

    /**
     * 清空为菜单按钮设置的右边框style
     */
    function emp() {
        //border-right: 2px solid rgb(0, 0, 0); border-bottom-right-radius: 0px; border-top-right-radius: 0px;
        $("button.btn-info").removeAttr("style");
        // $("button").removeAttr("style");//这句话会让 修改 按钮显示
    }

    //页面刚被加载
    alert("欢迎你"+$("#uName").text());

    xsBtn$.click(function () {
        emp();
        xsBtn$.css({
            "border-right": "2px solid #000",
            "border-bottom-right-radius": "0",
            "border-top-right-radius": "0"
        });
    });
    gcBtn$.click(function () {
        emp();
        gcBtn$.css({
            "border-right": "2px solid #000",
            "border-bottom-right-radius": "0",
            "border-top-right-radius": "0"
        });
    });
    xxBtn$.click(function () {
        emp();
        xxBtn$.css({
            "border-right": "2px solid #000",
            "border-bottom-right-radius": "0",
            "border-top-right-radius": "0"
        });
    });
    wyBtn$.click(function () {
        emp();
        wyBtn$.css({
            "border-right": "2px solid #000",
            "border-bottom-right-radius": "0",
            "border-top-right-radius": "0"
        });
    });


    /**
     * 表格处理部分
     * 通过class选择器控制页面的显隐
     * @param pno 为页号
     */
    function pageHide(pno) {
        $(".page" + pno).hide();
    }

    function pageShow(pno) {
        $(".page" + pno).show();
    }

    //初始化
    pageShow(1);

    /**
     * 分页组件处理
     */
    var stPage$ = $("#stPage");
    var curPage$ = $("#curPage");
    var edPage$ = $("#edPage");

    //显示当前页、第几条至第几条
    var pageNow$ = $("#pageNow");
    var stRd$ = $("#stRd");
    var edRd$ = $("#edRd");
    var jumpNo$ = $("#jumpPNo");

    var pageSize = parseInt(edRd$.text());
    var totalPages = parseInt($("#totalPages").text());//不转整型的话，是串，有空格、回车什么的

    //点击前一页
    $("#prePage").click(function () {
        var v = parseInt(curPage$.text());
        totalPages = parseInt($("#totalPages").text());
        if (v != totalPages) {
            edPage$.removeClass("disabled");
        }
        if (parseInt(curPage$.text()) > 1) {

            pageHide(v);
            pageShow(v - 1);
            curPage$.text(v - 1);
            jumpNo$.val(v - 1);

            pageNow$.text(v - 1);
            stRd$.text((v - 1 - 1) * pageSize + 1);
            edRd$.text((v - 1) * pageSize);

            if (parseInt(curPage$.text()) == 1) {
                stPage$.addClass("disabled");
            }
        }
    });

    //点击后一页
    $("#nextPage").click(function () {
        var v = parseInt(curPage$.text());
        if (v != 1) {
            stPage$.removeClass("disabled");
        }
        totalPages = parseInt($("#totalPages").text());
        if (v < totalPages) {
            pageHide(v);
            pageShow(v + 1);
            curPage$.text(v + 1);
            jumpNo$.val(v + 1)

            pageNow$.text(v + 1);
            stRd$.text((v + 1 - 1) * pageSize + 1);
            edRd$.text((v + 1) * pageSize);

            if (parseInt(curPage$.text()) == totalPages) {
                edPage$.addClass("disabled");
            }
        }
    });

    /**
     * 当点击回到首页、尾页时
     */
    //回首页
    stPage$.click(function () {
        var v = parseInt(curPage$.text());
        if (v != 1) {
            stPage$.removeClass("disabled");
        }
        pageHide(parseInt(curPage$.text()));
        pageShow(1);
        curPage$.text(1);
        jumpNo$.val(1);

        pageNow$.text(1);
        stRd$.text((1 - 1) * pageSize + 1);
        edRd$.text(1 * pageSize);

        stPage$.addClass("disabled");
    });
    //回尾页
    edPage$.click(function () {
        var v = parseInt(curPage$.text());
        totalPages = parseInt($("#totalPages").text());
        if (v != totalPages) {
            edPage$.removeClass("disabled");
        }
        totalPages = parseInt($("#totalPages").text());
        pageHide(parseInt(curPage$.text()));
        pageShow(totalPages);
        curPage$.text(totalPages);
        jumpNo$.val(totalPages);

        pageNow$.text(totalPages);
        stRd$.text((totalPages - 1) * pageSize + 1);
        edRd$.text(totalPages * pageSize);

        edPage$.addClass("disabled");
    });

    /**
     * 修改分页组件是否可以被禁用
     */
    // edPage$.text(">>");//为了方便，在页面加载进来时，它的值是totalPages，在此修改
    $("#prePage").click();
    if (parseInt(curPage$.text()) == 1) {
        stPage$.addClass("disabled");
    }
    if (parseInt(curPage$.text()) == totalPages) {
        edPage$.addClass("disabled");
    }

    /**
     * 增加点击跳转的功能
     */
    $("#pageJump").click(function () {
        totalPages = parseInt($("#totalPages").text());
        var str = jumpNo$.val();
        var v = parseInt(str);
        var reg = /\D/;
        if (reg.test(str)) {
            alert("页码不正确，请重新输入！");
        } else if (v > totalPages) {
            alert("共有" + totalPages + "，输入的页码过大！");
        } else if (v < 1) {
            alert("请输入不小1的页码！");
        } else {
            pageHide(parseInt(curPage$.text()));
            pageShow(v);
            curPage$.text(v);
            jumpNo$.val(v);

            pageNow$.text(v);
            stRd$.text((v - 1) * pageSize + 1);
            edRd$.text(v * pageSize);
        }
    });

    /*由于修改按钮很多，这里采用触发的方式，每个按钮的点击都会触发总按钮，就只需要一个模态框了*/
    $("#mainBtn").click(function (event,id) {
        var str="#tr"+id;
        // alert($(str).children(".td1").text());
        var sel$=$(str);
        $("#recordId").val(sel$.children(".td1").text());
        $("#upBookName").val(sel$.children(".td2").text());
        $("#bPStuNo").val(sel$.children(".td3").text());
        $("#bPName").val(sel$.children(".td4").text());
        $("#newBrDays").val(sel$.children(".td5").text());
    });

});

function deleteFn(obj) {

    var b = confirm("一经删除不可撤销，您确定要删除吗？");
    if (b) {
        $.ajax({
            url: "/deleteServlet",
            data: {"id": obj},
            success: function (data) {
                $("#tr" + obj).remove();
                location.href = "/backHome.jsp";
                alert(data);
            },
            dataType: "text"
        });
    } else {
        alert("您已取消删除！");
    }
}

function insertFn(form) {
    var stuNo = document.forms[form]["stuNo"].value;
    var brDays = document.forms[form]["brDays"].value;
    var bookNo = document.forms[form]["bookNo"].value;
    $.ajax({
        method: "post",
        url: "/InsertBrServlet",
        data: {"stuNo": stuNo, "brDays": brDays, "bookNo": bookNo},
        success: function (data) {
            alert(data);
            location.href = "/backHome.jsp";
        },
        dataType: "text"
    });

}

function updateFn(form) {
    var key=document.forms[form]["recordId"].value;
    var newBrDays = document.forms[form]["newBrDays"].value;
    $.ajax({
        method: "post",
        url: "/UpdateBrServlet",
        data: {"newBrDays": newBrDays, "key": key},
        success: function (data) {
            alert(data);
            location.href = "/backHome.jsp";
        },
        dataType: "text"
    });

}

//每个修改按钮都要执行
function updateBtn(id) {
    // alert(id);
    $("#mainBtn").trigger("click",id);
}