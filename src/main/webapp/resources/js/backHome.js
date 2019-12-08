$(document).ready(function () {
    var brBtn$ = $("#brBtn"), brDiv$ = $("#brDiv");
    var wyBtn$ = $("#wyBtn");
    var tjBtn$ = $("#tjBtn");
    var xsBtn$ = $("#xsBtn");
    var gcBtn$ = $("#gcBtn");
    var tjTsBtn$ = $("#tjTsBtn");
    var xxBtn$ = $("#xxBtn");

    /**
     * 清空为菜单按钮设置的右边框style
     */
    function emp() {
        /*brBtn$.removeAttr("style");
        wyBtn$.removeAttr("style");
        tjBtn$.removeAttr("style");
        xsBtn$.removeAttr("style");
        gcBtn$.removeAttr("style");
        tjTsBtn$.removeAttr("style");
        xxBtn$.removeAttr("style");*/
        // $("button[style='border-right: 2px solid #000;border-bottom-right-radius: 0;border-top-right-radius: 0']").removeAttr("style");
        $("button").removeAttr("style");
    }


    brBtn$.click(function () {
        //都先清空所有，
        emp();
        brBtn$.css({
            "border-right": "2px solid #000",
            "border-bottom-right-radius": "0",
            "border-top-right-radius": "0"
        });
        brDiv$.css("display", "block");
    });

    //页面刚被加载
    brBtn$.click();

    wyBtn$.click(function () {
        emp();
        wyBtn$.css({
            "border-right": "2px solid #000",
            "border-bottom-right-radius": "0",
            "border-top-right-radius": "0"
        });
    });
    tjBtn$.click(function () {
        emp();
        tjBtn$.css({
            "border-right": "2px solid #000",
            "border-bottom-right-radius": "0",
            "border-top-right-radius": "0"
        });
    });
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
    tjTsBtn$.click(function () {
        emp();
        tjTsBtn$.css({
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

    var totalPages = parseInt($("#totalPages").text());//不转整型的话，是串，有空格、回车什么的

    $("#prePage").click(function () {
        if (parseInt(curPage$.text()) != totalPages) {
            edPage$.removeClass("disabled");
        }
        if (parseInt(curPage$.text()) > 1) {
            pageHide(parseInt(curPage$.text()));
            pageShow(parseInt(curPage$.text()) - 1);
            curPage$.text(parseInt(curPage$.text()) - 1);
            if (parseInt(curPage$.text()) == 1) {
                stPage$.addClass("disabled");
            }
        }
    });

    $("#nextPage").click(function () {
        if (parseInt(curPage$.text()) != 1) {
            stPage$.removeClass("disabled");
        }
        if (parseInt(curPage$.text()) < totalPages) {
            pageHide(parseInt(curPage$.text()));
            pageShow(parseInt(curPage$.text()) + 1);
            curPage$.text(parseInt(curPage$.text()) + 1);
            if (parseInt(curPage$.text()) == totalPages) {
                edPage$.addClass("disabled");
            }
        }
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
        var v = $("#jumpPNo").val();
        var val = parseInt(v);
        var reg = /\D/;
        if (reg.test(v)) {
            alert("页码不正确，请重新输入！");
        } else if (val > totalPages) {
            alert("共有"+totalPages+"，输入的页码过大！");
        } else if (val < 1) {
            alert("请输入不小1的页码！");
        } else {
            pageHide(parseInt(curPage$.text()));
            pageShow(parseInt(v));
            curPage$.text(v);
        }
    })

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
