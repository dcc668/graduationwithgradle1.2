function subWorkData() {
    if(checkForm()) {
        var $form = $("form[name='work_form']");
        $form.attr("action", "/project/submitProjectInfo");
        $form.attr("enctype", "application/x-www-form-urlencoded");
        $form.submit();
    }
    //$form.ajaxSubmit({
    //    method : "POST",
    //    success : function(data){
    //        alertify.alert("提交成功");
    //        ////成功
    //        //var json=eval("(" + data + ")");
    //        //if(json.res == 1){
    //        //    alertify.alert("上传成功");
    //        //}else{
    //        //    alertify.alert("上传失败"+json.msg);
    //        //}
    //    },
    //    error : function(){
    //        alertify.alert("网络错误，请稍后重新尝试！");
    //    }
    //});
}

function deleteRowByNum(num) {
    for (var i = 0; i < num; i++) {
        $(".fixWidth:eq(1)").remove();
    }
}
function checkForm() {
    var row = $("div .row ");
    var isRight=true;
    var coNames=new Array;
    $.each(row, function (idx,obj) {
        if(idx!=0){  //
            //var term = $(this).children(".row_1").find("input");
            /*项目名称*/
            var name = $(this).children(".row_1").find("input");
            /*负责人(工号)*/
            var pubNo = $(this).children(".row_3").find("input");
            /*项目成员(逗号隔开)*/
            var time = $(this).children(".row_4").find("input");
            /*课题总额(万)*/
            var people = $(this).children(".row_8").find("input");
            console.info("name:"+name.val()+"-pubNo:"+pubNo.val()+"-time:"+time.val());
            if (name.val() == "" || name.val() ==null) {
                alertify.alert("请输入项目名称！");
                isRight=false;
                return false;
            }
            if (pubNo.val() == "" || pubNo.val() == null) {
                alertify.alert("请输入负责人(工号)！");
                isRight=false;
                return false;
            }
            if (time.val() == "" || time.val() == null) {
                alertify.alert("请输入项目成员(逗号隔开)！");
                isRight=false;
                return false;
            }
            if (people.val() == "" || people.val() == null) {
                alertify.alert("请输入课题总额(万)！");
                isRight=false;
                return false;
            }else{

            }
        }
    });
    return isRight;
}



var index=1;
//添加行
function addRow() {
    if ($(".add").length < 10) {
        $(".row:eq(0)").clone().insertAfter(".row:last");//插入到第二个表格的第一行后面
        $(".row:last").css("display", "block");
        $(".row:last").attr('id','div_'+new Date().getTime());
        index++;
        $(".row:last input:first").attr("name","tc["+index+"].prId");
        $(".row:last input:first").attr("value",-1);
        $(".row:last .row_1 input").attr("name","tc["+index+"].prName");
        $(".row:last .row_2 select").attr("name","tc["+index+"].prSource");
        $(".row:last .row_3 input").attr("name","tc["+index+"].teId");
        $(".row:last .row_4 input").attr("name","tc["+index+"].members");
        $(".row:last .row_5 input").attr("name","tc["+index+"].prStartTime");
        $(".row:last .row_6 input").attr("name","tc["+index+"].prEndTime");
        $(".row:last .row_7 input").attr("name","tc["+index+"].prDate");
        $(".row:last .row_8 input").attr("name","tc["+index+"].prUsefulMoney");
        $(".row:last .row_9 input").attr("name","tc["+index+"].prPreMoney");
        $(".row:last .row_10 input").attr("name","tc["+index+"].prMoney");
        $(".row:last .row_11 input").attr("name","tc["+index+"].prResultInfo");
        $(".row:last .row_12 select").attr("name","tc["+index+"].prState");
    } else {
        alertify.alert("抱歉，一次性只能添加9条");
    }
}
function removeRow(dom) {
    if ($(".delete").length >= 2) {
        alertify.confirm("你确定删除这条数据？", function (data) {
            if(data) {
                var row = $(dom).parent().parent().parent();
                var paId = row.find("input:first").val();
                if (paId != "-1" && paId != "0") {
                    var url = "/project/delProject";
                    var args = {"prId": paId};
                    $.post(url, args, function (data) {
                        var json = eval("(" + data + ")");
                        if (json.res == 1) {
                            alertify.success("操作成功");
                        } else {
                            alertify.error("操作失败");
                        }
                    });
                }
                row.remove();
                index--;
            }
        });
    }
};

//更新分页跳转
function goNextPaper(currentPage){
    var url="/project/projectInfoUpdateView";
    window.location.href=url+"?currentPage="+currentPage;
}

//异步验证教师是否存在(问题未解决)
function checkIsExists(dom){
    var val=$(dom).attr("value");
    console.log("------------->"+val)
    //if(val!=null||val!=""){
    //    var ids=val.split(",");
    //    $.each(ids,function(idx,obj){
    //        if(val!=null||val!=""){
    //            var url="/teacher/isExist/{"+parseInt(val)+"}";
    //            $.ajax({
    //                type: "POST",
    //                url: url,
    //                data: "",
    //                success: function(data){
    //                    alert( "Data Saved: " + msg );
    //                    var json=eval("("+data+")");
    //                    alert(json.exists);
    //                    if(!json.exists){
    //                        alertify.alert("工号："+val+" 不存在！");
    //                    }
    //                }
    //            });
    //        }
    //    });
    //}
}
