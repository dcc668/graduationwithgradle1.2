$(function(){
    //-----------------------------------------------------------------统计图----------------------------------
    var years=null;
    var idxs=null;
    var url="/paper/paperStatistcsAjax";
    $.ajax({
        //要用post方式
        type: "GET",
        //方法所在页面和方法名
        url: url,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(data) {
            //返回的数据用data.d获取内容
            years=eval("("+data.years+")");
            idxs=eval("("+data.idxs+")");
        },
        error: function(err) {
            alert("--2--"+err);
        }
    });

    Highcharts.chart('container', {
            chart: {
                type: 'column'
            },
            title: {
                text: '计通学院历年教师论文统计图'
            },
            subtitle: {
                text: '来源: www.lut.cn'
            },
            xAxis: {
                categories: years,          //x坐标
                crosshair: true
            },
            yAxis: {
                min: 0,
                title: {
                    text: '数量 (篇)'
                }
            },
            tooltip: {
                headerFormat: '<span style="font-size:8px">{point.key}</span><table>',
                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f}</b></td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0
                }
            },
            series: idxs    //数据[{name:"",date:[1,3,4]},{name:"",date:[1,3,4]}]
    });

});


