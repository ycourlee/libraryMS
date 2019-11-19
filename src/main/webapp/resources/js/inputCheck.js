//错误警告框元素
var altDiv="<div class=\" alert alert-warning col-md-9 m-auto\" id=\"alertDiv\">\n" +
    "                <strong>警告!</strong> 验证码错误\n" +
    "            </div>";
//不能为空
var altDiv2="<div class=\" alert alert-warning col-md-9 m-auto\" id=\"alertDiv2\">\n" +
    "                <strong>警告!</strong> 验证码不能为空\n" +
    "            </div>";

var x=parseInt(1000+Math.floor(Math.random()*9000),10);
var elem =document.getElementById("checkId");

elem.innerText=x.toString();

function newOne(){
    x=parseInt(1000+Math.floor(Math.random()*9000),10);
    elem.innerText=x.toString();
}
$(document).ready(function () {
    newOne();
    $("#iptId").val("");
    $("#iptId").focus(function () {
        $("#alertDiv").remove();
    });
    $("#iptId").focus(function () {
        $("#alertDiv2").remove();
    });
});

$("#checkId").click(function () {
    newOne();
});

function check() {

    var ipt=document.getElementById("iptId");
    // console.log(ipt.value.toString()+" "+x.toString());
    if(ipt.value===""){
        $("#check-group").after(altDiv2);
        return false;
    }
    else if(ipt.value.toString()!==x.toString()){
        $("#check-group").after(altDiv);
        return false;
    }else{
        return true;
    }
}
