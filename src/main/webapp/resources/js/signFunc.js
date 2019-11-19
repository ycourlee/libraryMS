/**    select元素之间的联动，由于班级设置为固定的5个班，它是最容易操作的    */
$(document).ready(function () {

    $("option[class]").hide();
    $("option.init-show").show();
    $("select").val("non");
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