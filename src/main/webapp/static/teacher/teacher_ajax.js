var type;

function subWorkData() {
    if (checkForm()) {
        var $form = $("form[name='work_form']");
        $form.submit();
    }
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
        if(idx!=0){
            //var term = $(this).children(".row_1").find("input");
            var type = $(this).children(".row_2").find("select");
            var coName = $(this).children(".row_3").find("select");
            var houseNum = $(this).children(".row_6").find("input");
            console.info("type:"+type.val()+"-coName:"+coName.val()+"-houseNum:"+houseNum.val());
            //if (term.checked!=true&&term.checked!=true) {
            //    alert("请选择学期！");
            //    isRight=false;
            //    return false;
            //}
            if (type.val() == "" || type.val() ==null) {
                alert("请选择课程类型！");
                isRight=false;
                return false;
            }
            if (coName.val() == "" || coName.val() == null) {
                alert("请选择课程！");
                isRight=false;
                return false;
            }
            if (houseNum.val() == "" || houseNum.val() == null || houseNum.val()< 1) {
                alert("请输入班级批次！");
                isRight=false;
                return false;
            }
            //不能提交两条相同课程的记录
            var have=$.inArray(coName.val(), coNames);
            if(have!=-1){  //no 返回 -1
                alert("不能提交两条相同课程的记录！");
                isRight=false;
                return false;
            }else{
                coNames.push(coName.val());
            }
        }
    });
    return isRight;

}

function coNameChanged(dom) {
    var index = $(dom).parent().parent().find("input").first().val();
    var coNO = $(dom).val();  //获取选中的项
    var url = "/teacher/getCourseInfo";
    var args = {"coNO": coNO, "time": new Date()};
    $.post(url, args, function (data) {
        var json = eval("(" + data + ")");
        var coTimeObj = $(dom).parent().parent().find(".row_5 input");
        coTimeObj.val(json.coTime);
        var stuNumObj = $(dom).parent().parent().find(".row_4 input");
        stuNumObj.val(json.stuNum);
        var coScoreObj = $(dom).parent().parent().find(".row_8 input");
        coScoreObj.val(json.coScore);
        var notPassNumObj = $(dom).parent().parent().find(".row_7 input");
        notPassNumObj.val(json.notPassNum);
        var co2LanguageObj = $(dom).parent().parent().find(".row_9 input");
        if (json.co2Language) {
            co2LanguageObj[0].checked = true;
        } else {
            co2LanguageObj[1].checked = true;
        }
    });
};

//分页跳转
function go(currentPage){
    var url="/teacher/teaTeachInfoUpdateView";
     window.location.href=url+"?currentPage="+currentPage;
}
var index=1;
//添加行
function addRow() {
    if ($(".add").length < 10) {
        $(".row:eq(0)").clone().insertAfter(".row:last");//插入到第二个表格的第一行后面
        $(".row:last").css("display", "block");
        $(".row:last").attr('id','div_'+new Date().getTime());
        index++;
        $(".row:last input:first").attr("name","tc["+index+"].tcId");
        $(".row:last input:first").attr("value",-1);
        $(".row:last .row_1 input").attr("name","tc["+index+"].term");
        $(".row:last .row_2 select").attr("name","tc["+index+"].type");
        $(".row:last .row_3 select").attr("name","tc["+index+"].coName");
        $(".row:last .row_4 input").attr("name","tc["+index+"].stuNum");
        $(".row:last .row_5 input").attr("name","tc["+index+"].coTime");
        $(".row:last .row_6 input").attr("name","tc["+index+"].houseNum");
        $(".row:last .row_7 input").attr("name","tc["+index+"].notPassNum");
        $(".row:last .row_8 input").attr("name","tc["+index+"].coScore");
        $(".row:last .row_9 input").attr("name","tc["+index+"].co2Language");
        $(".row:last .row_10 input").attr("name","tc["+index+"].mark");
    } else {
        alert("抱歉，一次性只能添加9条");
    }
}
function removeRow(dom) {
    alert($(".delete").length);
    if ($(".delete").length >= 2) {
        alertify.confirm("你确定删除这条数据？", function (data) {
            if(data) {
                var row = $(dom).parent().parent().parent();
                var tcId = row.find("input:first").val();
                if (tcId != "-1" && tcId != "0") {
                    var url = "/teacher/delTeacherCourse";
                    var args = {"tcId": tcId};
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
