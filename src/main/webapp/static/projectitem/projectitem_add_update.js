//tag:数字文本标记  2存数字，1money，0文本
//i:对象下表  i==-1时，自动填充小计汇总表
function insertValue(dom,tag,i){
    //获取费用名称
    var td=$(dom).parent().prevAll().first();
    var tdVal=td.text();
    if(tdVal.contains(">")||tdVal.contains("<")){
        tdVal=tdVal.split(">")[1];
    }
    //填充textarea
    var val=$(dom).attr("value");
    $("textarea").attr("value",val);
    //填充title
    $("div#modal-title").text(tdVal);
    $('#modal-content').modal({
        closeHTML: "<a href='#' title='Close' class='modal-close'>x</a>",
        position: [0,],
        overlayId: 'modal-overlay',
        containerId: 'modal-content',
        onShow: function (dialog) {
            var modal = this;
            // if the user clicks "yes"
            $('.simplemodal-sure', dialog.data[0]).click(function () {
                var text=$("textarea").attr("value");
                if(text==""||text==null||text.trim()==""){
                    alert("请输入后再点确定");
                    return false;
                }
                if(tag==1) {
                    //整数或者小数：
                    var reg = /^[0-9]+\.{0,1}[0-9]{0,2}$/;
                    if(!reg.test(text)){
                        alert("只能输入整数或者小数！且小数点后最多两位");
                        return false;
                    }
                }
                if(tag==2) {
                    //整数
                    var reg = /^[0-9]+$/;
                    if(!reg.test(text)){
                        alert("只能输入整数！");
                        return false;
                    }
                }
                $(dom).attr("value",text);
                //自动填充小计汇总表
                if(i==-1){
                    insertValToTab2(tdVal, text);
                }else {
                    //自动填充tab1
                    var arr=new Array;
                    arr.push(1,2,8,7,17,0,25,15);
                    var count=-1;
                    //自动填充材料费1
                    var arrcl = new Array;
                    arrcl.push(1, 4);
                    if(exists(arrcl,i)){
                        count=1;
                    }
                    //自动填充固定资产          2
                    var arrgd = new Array;
                    arrgd.push(2);
                    if(exists(arrgd,i)){
                        count=2;
                    }
                    //自动填充管理费       3
                    var arrgl = new Array;
                    arrgl.push(8,11);
                    if(exists(arrgl,i)){
                        count=3;
                    }
                    //自动填充外协费4
                    var arrwx = new Array;
                    arrwx.push(7,10,13);
                    if(exists(arrwx,i)){
                        count=4;
                    }
                    //自动填充专用费5
                    var arrzy = new Array;
                    arrzy.push(17,20);
                    if(exists(arrzy,i)){
                        count=5;
                    }
                    //自动填充设计费   6
                    var arrsj = new Array;
                    arrsj.push(0, 3, 5, 6, 9, 12, 14, 16, 19, 22, 24);
                    if(exists(arrsj,i)){
                        count=6;
                    }
                    //自动填充试验费7
                    var arrsy = new Array;
                    arrsy.push(25);
                    if(exists(arrsy,i)){
                        count=7;
                    }
                    //自动填充工资8
                    var arrgz = new Array;
                    arrgz.push(15,18,21,23);
                    if(exists(arrgz,i)){
                        count=8;
                    }
                    switch(count){
                        case 1:
                            //自动填充材料费1
                            var arrcl2=dealArray(arrcl);
                            fillTab1(arrcl,arrcl2,i,count);
                            break;
                        case 2:
                            //自动填充固定资产          2
                            var arrgd2=dealArray(arrgd);
                            fillTab1(arrgd,arrgd2,i,count);
                            break;
                        case 3:
                            //自动填充管理费       3
                            var arrgl2=dealArray(arrgl);
                            fillTab1(arrgl,arrgl2,i,count);
                            break;
                        case 4:
                            //自动填充外协费4
                            var arrwx2=dealArray(arrwx);
                            fillTab1(arrwx,arrwx2,i,count);
                            break;
                        case 5:
                            //自动填充专用费5
                            var arrzy2=dealArray(arrzy);
                            fillTab1(arrzy,arrzy2,i,count);
                            break;
                        case 6:
                            //自动填充设计费   6
                            var arrsj2=dealArray(arrsj);
                            fillTab1(arrsj,arrsj2,i,count);
                            break;
                        case 7:
                            //自动填充试验费7
                            var arrsy2=dealArray(arrsy);
                            fillTab1(arrsy,arrsy2,i,count);
                            break;
                        case 8:
                            //自动填充工资8
                            var arrgz2=dealArray(arrgz);
                            fillTab1(arrgz,arrgz2,i,count);
                            break;
                    }
                    var design = $(".col_3 input#money"+count);
                    var name=design.parent().prev().html();
                    var subSum=design.attr("value");
                    //自动填充表2
                    insertValToTab2(name, subSum);
                }
                modal.close(); // or $.modal.close();
            });
        }
    });
}
function subWorkData(){
    var $form=$("form[name='work_form']");
    $form.submit();
}

/**
 * 自动填充小计汇总表
 * @param tdVal 表一  列文本
 * @param val  填充的值
 */
function insertValToTab2(tdVal,val){
    if(tdVal!=null&&tdVal.contains("小计")){
        var strs=tdVal.split("小计");
        var name=strs[0];
        //遍历表2 第一行每列的文本。
        var td=$(".table_read tr:first td");
        var index=null;
        $.each(td,function(idx,obj){
            if(idx!=0&&idx!=1&&idx!=10){
                var str=$(obj).text();
                if(str==name){
                    index=idx;
                    return false;
                }
            }
        });
        if(index!=null){
            var td2=$(".table_read tr:nth-child(2) td");
            $.each(td2,function(idx,obj){
                var ind=idx+1;
                if(ind==index){
                    $(obj).html(val);
                    return false;
                }
            });
            var lastTd=$(".table_read tr:nth-child(2) td:last");
            var sum=sumMoney();
            lastTd.html(sum);
            //最后一行总计
            var $span=$(".table_read tr:last-child span");
            $span.html(sum);
            var lastInput=$(".table_read tr:last-child input");
            lastInput.attr("value",sum);


        }
    }
}
//合计
function sumMoney(){
    var td2=$(".table_read tr:nth-child(2) td");
    var sum=0;
    $.each(td2,function(idx,obj){
        if(idx!=0&&idx!=9){
            var str=$(obj).text();
            if(str!=null&&str.trim()!="") {
                sum = sum + parseFloat(str.trim());
            }
        }
    });
    return sum;
}

$(function(){
    for(var i=0;i<26;i++) {
        //自动填充tab1
        var arr = new Array;
        arr.push(1, 2, 8, 7, 17, 0, 25, 15);
        var count = -1;
        //自动填充材料费1
        var arrcl = new Array;
        arrcl.push(1, 4);
        if (exists(arrcl, i)) {
            count = 1;
        }
        //自动填充固定资产          2
        var arrgd = new Array;
        arrgd.push(2);
        if (exists(arrgd, i)) {
            count = 2;
        }
        //自动填充管理费       3
        var arrgl = new Array;
        arrgl.push(8, 11);
        if (exists(arrgl, i)) {
            count = 3;
        }
        //自动填充外协费4
        var arrwx = new Array;
        arrwx.push(7, 10, 13);
        if (exists(arrwx, i)) {
            count = 4;
        }
        //自动填充专用费5
        var arrzy = new Array;
        arrzy.push(17, 20);
        if (exists(arrzy, i)) {
            count = 5;
        }
        //自动填充设计费   6
        var arrsj = new Array;
        arrsj.push(0, 3, 5, 6, 9, 12, 14, 16, 19, 22, 24);
        if (exists(arrsj, i)) {
            count = 6;
        }
        //自动填充试验费7
        var arrsy = new Array;
        arrsy.push(25);
        if (exists(arrsy, i)) {
            count = 7;
        }
        //自动填充工资8
        var arrgz = new Array;
        arrgz.push(15, 18, 21, 23);
        if (exists(arrgz, i)) {
            count = 8;
        }
        switch (count) {
            case 1:
                //自动填充材料费1
                var arrcl2 = dealArray(arrcl);
                fillTab1(arrcl, arrcl2, i, count);
                break;
            case 2:
                //自动填充固定资产          2
                var arrgd2 = dealArray(arrgd);
                fillTab1(arrgd, arrgd2, i, count);
                break;
            case 3:
                //自动填充管理费       3
                var arrgl2 = dealArray(arrgl);
                fillTab1(arrgl, arrgl2, i, count);
                break;
            case 4:
                //自动填充外协费4
                var arrwx2 = dealArray(arrwx);
                fillTab1(arrwx, arrwx2, i, count);
                break;
            case 5:
                //自动填充专用费5
                var arrzy2 = dealArray(arrzy);
                fillTab1(arrzy, arrzy2, i, count);
                break;
            case 6:
                //自动填充设计费   6
                var arrsj2 = dealArray(arrsj);
                fillTab1(arrsj, arrsj2, i, count);
                break;
            case 7:
                //自动填充试验费7
                var arrsy2 = dealArray(arrsy);
                fillTab1(arrsy, arrsy2, i, count);
                break;
            case 8:
                //自动填充工资8
                var arrgz2 = dealArray(arrgz);
                fillTab1(arrgz, arrgz2, i, count);
                break;
        }
        var design = $(".col_3 input#money" + count);
        var name = design.parent().prev().html();
        var subSum = design.attr("value");
        //自动填充表2
        insertValToTab2(name, subSum);
    }

});

function dealArray(arr1){
    var arr2 = new Array;
    for (var k = 0; k < arr1.length; k++) {
        var name = "items[" + arr1[k] + "].sumMoney";
        arr2.push(name);
    }
    return arr2;
}
//判断数组中是否存在i
function  exists(arr1,i){
    var ar = $.grep(arr1, function (value) {
        return value == i;
    });
    if(ar.length > 0){
        return true;
    }
    return false;
}

//自动填充tab1 //count:第几个小计
function fillTab1(arr1,arr2,i,count){
    if (exists(arr1,i)) {
        var subSum = 0;
        var inps = $(".col_3 input");
        $.each(inps, function (i, obj) {
            var name = $(obj).attr("name");
            var val = null;
            if (exists(arr2, name)) {
                val = obj.value;
            }
            if (val != null && parseFloat(val) > 0) {
                subSum = subSum + parseFloat(val);
            }
        });
        var design = $(".col_3 input#money"+count);
        design.attr("value", subSum);
    }
}


