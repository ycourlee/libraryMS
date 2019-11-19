var altDiv="<div class=\" alert alert-warning col-md-9 m-auto mb-3\" style=\"max-width: 78%;padding: .35rem .75rem\" id=\"alertDiv\">\n"+
                "用户名只能包含数字。\n"+
            "</div>";

var altDiv2="<div class=\" alert alert-warning col-md-9 m-auto mb-3\" style=\"max-width: 78%;padding: .35rem .75rem\" id=\"alertDiv2\">\n"+
                "该密码不符合要求。\n"+
            "</div>";
var altDiv3="<div class=\" alert alert-warning col-md-9 m-auto mb-3\" style=\"max-width: 78%;padding: .35rem .75rem\" id=\"alertDiv3\">\n"+
                "两次密码不一致。\n"+
            "</div>";
var altDiv4="<div class=\" alert alert-warning col-md-9 m-auto mb-3\" style=\"max-width: 78%;padding: .35rem .75rem\" id=\"alertDiv4\">\n"+
                "请选择学院。\n"+
            "</div>";

/**    select元素之间的联动，由于班级设置为固定的5个班，它是最容易操作的    */
$(document).ready(function () {
    $("option[class]").hide();
    $("option.init-show").show();
    $("select").val("non");

    $("input[type='text']").val("");
    $("#stuNo").focus(function () {
        $("#alertDiv").remove();
    });
    $("#password").focus(function () {
        $("#alertDiv2").remove();
    });
    $("#password2").focus(function () {
        $("#alertDiv3").remove();
    });
    $("#academy").focus(function () {
        $("#alertDiv4").remove();
    });
});

//更改学院时专业变化并重置, 班级选项重置
function lianDong() {
    if($("option:selected").val()==="经济管理学院"){
        $("#major option[class]").hide();
        $("#major option[value='non']").show();
        $("#major").val("non");
        $("#major option.jg-academy").show();
    }else if($("#academy option:selected").val()==="外国语学院"){
        $("#major option[class]").hide();
        $("#major option[value='non']").show();
        $("#major").val("non");
        $("#majorClass").val("non");
        $("#major option.wy-academy").show();
    }else if($("#academy option:selected").val()==="文法学院"){
        $("#major option[class]").hide();
        $("#major option[value='non']").show();
        $("#major").val("non");
        $("#majorClass").val("non");
        $("#major option.wf-academy").show();
    }else if($("#academy option:selected").val()==="信息与计算机工程学院"){
        $("#major option[class]").hide();
        $("#major option[value='non']").show();
        $("#major").val("non");
        $("#majorClass").val("non");
        $("#major option.xx-academy").show();
    }else if($("#academy option:selected").val()==="园林学院"){
        $("#major option[class]").hide();
        $("#major option[value='non']").show();
        $("#major").val("non");
        $("#majorClass").val("non");
        $("#major option.yl-academy").show();
    }else if($("#academy option:selected").val()==="non"){
        $("option[class]").hide();
        $("option.init-show").show();
        $("select").val("non");
    }
}
//更改专业时班级重置
function lianDong2() {
    $("#majorClass").val("non");
}
//在选择班级时，学院、专业要已选
function lianDong3() {
    if(!($("#academy option:selected").val()!=="non"&&$("#major option:selected").val()!=="non")){
        $("#majorClass").val("non");
    }
}

function stuNoCheck() {
    //非数字字符
    var sno=document.forms["sign"]["stuNo"];
    var re=new RegExp("\\D");
    if(re.test(sno.value)===true){
        $("#stuNoDiv").after(altDiv);
    }
}

function psCheck() {
    var ps=document.forms["sign"]["password"];

    var pattern=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$/;

    if (pattern.test(ps.value) !== true) {
        $("#psDiv").after(altDiv2);
    }
}

function ps2Check() {
    var ps=document.forms["sign"]["password"];
    var ps2=document.forms["sign"]["password2"];
    if(ps2!==ps){
        $("#ps2Div").after(altDiv3);
    }
}
function academyCheck() {
    if($("#academy").val()==="non"){
        $("#academyDiv").after(altDiv4);
    }
}
function checkForm() {
    var ps=document.forms["sign"]["password"];
    var ps2=document.forms["sign"]["password2"];
    if(ps2!==ps){
        $("#ps2Div").after(altDiv3);
        return false;
    }else if($("#academy").val()==="non"){
        $("#academyDiv").after(altDiv4);
        return false;
    }else{
        return true;
    }
}