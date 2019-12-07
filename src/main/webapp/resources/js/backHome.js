$(document).ready(function () {
    

});

function deleteFn(obj) {

    var b = confirm("您确定要删除吗？");
    if(b){
        $.ajax({
            url: "/deleteServlet",
            data: {"id": obj},
            success: function (data) {
                $("#tr"+obj).remove();
                alert(data);
            },
            dataType: "text"
        });
    }
    else{
        alert("您已取消！");
    }
}