var type;

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

/* 文件上传*/
function fileUpload(dom){
    var $form = $("form[name='work_form']");
    $form.attr("action","/main/fileUploadDownload/fileUpload");
    $form.attr("enctype","multipart/form-data");
    $form.ajaxSubmit({
        method : "POST",
        success : function(data){
            //成功
            var json=eval("(" + data + ")");
            if(json.res == 1){
                var path=json.filePath;
                var obj=$(dom).parent().find("input:first");
                obj.attr("value",path);
                obj.attr("type","text");
                $(dom).remove();
                alertify.alert("上传成功");
            }else{
                alertify.alert("上传失败"+json.msg);
            }
        },
        error : function(){
            alertify.alert("网络错误，请稍后重新尝试！");
        }
    });
}

//function fileUpload(dom){
//    alert($(dom).attr("id"));
//    $.ajaxFileUpload({
//            type            : 'POST',
//            url             : '/main/fileUploadDownload/fileUpload', //需要链接到服务器地址
//            secureuri       : false,
//            fileElementId   : $(dom).attr("id"), //文件选择框的id属性
//            dataType        : 'JSON', //服务器返回的格式
//            success     : function(data,status) //相当于java中try语句块的用法
//            {
//                alert(data);
//            },
//            error : function(data, status, e) //相当于java中catch语句块的用法
//            {
//                alert(data);
//            }
//        }
//    );
//}

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
                    var url = "/paper/delPaper";
                    var args = {"paId": paId};
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


function selectPaId(i,paId){
    var obj=$(".row_11 input")[i+1];
    var value=$(obj).attr("value")+"";
    var newPaId="-"+paId;
    if(value==newPaId){
        $(obj).attr("value",paId);
    }else{
        $(obj).attr("value",newPaId);
    }
}
//汇总分页跳转
function goNextAllPaper(currentPage){
    var url="/paper/execute"+"?currentPage="+currentPage;
    var $form=$("form[name='exportForm']");
    $form.attr("action",url);
    $form.submit();

    //var url="/paper/exportToExcelView"+"?currentPage="+currentPage;
    //window.location.href=url;
}
//导出
function exportToExcel() {
    var url = "/paper/submitExportToExcel";
    var $form = $("form[name='exportForm']");
    $form.attr("action", url);
    $form.submit();
}
//全论文导出
function exportAllToExcel() {
    var url = "/paper/submitAllExportToExcel";
    var $form = $("form[name='exportForm']");
    $form.attr("action", url);
    $form.submit();
}

//全选
var isAllChecked=true;
function checkedAll(){
    var box=$(".row_11 input");
    $.each(box,function(idx,obj){
        if(idx!=0){
            var value=$(obj).attr("value");
            if(!isAllChecked){
                $(obj).prop("checked",false);
                $(obj).attr("value","-"+value);
            }else{
                $(obj).prop("checked", true);
                var val=value.substring(1,value.length);
                $(obj).attr("value",val);
            }
        }
    });
    if(isAllChecked){
        isAllChecked=false;
    }else{
        isAllChecked=true;
    }
}

/*判断是否在全选上打勾*/
$(function(){
    var allPaIds=$("input#allPaIds").attr("value");
    var arrs=JSON.parse(allPaIds);
    var nowPaIds=$(".row_11 input:not(:first)");
    var count=0;/*判断是否全选*/
    $.each(arrs,function(idx1,paId1){
        $.each(nowPaIds,function(idx2,paId2){
            var nowVal=$(paId2).attr("value");
            var val = nowVal.substring(1, nowVal.length);
            if(paId1==val) {
                $(paId2).attr("value", val);
                $(paId2).attr("checked", true);
                count++;
            }
        });
    });
    /*全选*/
    if(nowPaIds.size()==count){
        $(".row_11 input:first").attr("checked",true);
        isAllChecked=false;
    };
});


