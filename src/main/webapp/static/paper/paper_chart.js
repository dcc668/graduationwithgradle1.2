$(function(){
    //-----------------------------------------------------------------统计图----------------------------------
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
            alert("--1--"+data);
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
                categories: [
                    '2005',
                    '2006',
                    '2007',
                    '2008',
                    '2009',
                    '2010',
                    '2011',
                    '2012',
                    '2013',
                    '2014',
                    '2015',
                    '2016'
                ],
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
            series: [{
                name: 'SCI',
                data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4]

            }, {
                name: 'EI',
                data: [83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3]

            }, {
                name: 'ISTP',
                data: [48.9, 38.8, 39.3, 41.4, 47.0, 48.3, 59.0, 59.6, 52.4, 65.2, 59.3, 51.2]

            }, {
                name: 'SSCI',
                data: [48.9, 38.8, 39.3, 41.4, 47.0, 48.3, 59.0, 59.6, 52.4, 65.2, 59.3, 51.2]

            }, {
                name: 'CSCD',
                data: [42.4, 33.2, 34.5, 39.7, 52.6, 75.5, 57.4, 60.4, 47.6, 39.1, 46.8, 51.1]

            }, {
                name: '其他',
                data: [42.4, 33.2, 34.5, 39.7, 52.6, 75.5, 57.4, 60.4, 47.6, 39.1, 46.8, 51.1]

            }]
    });

});


