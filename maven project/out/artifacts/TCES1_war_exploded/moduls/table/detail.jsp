<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="com.tes1.evaluate.domain.*,java.util.*"%>
<%@ page import="org.springframework.web.bind.annotation.SessionAttributes" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript" src="/TCES1/jquery-easyui-1.5.3/jquery.min.js"></script>
<script type="text/javascript" src="/TCES1/js/echarts.min.js"></script>
<div id="main_2" style="width: 900px;height:600px;float: left"></div>

<script type="text/javascript">

    var myChart = echarts.init(document.getElementById('main_2'));

    var option = {
        title: {
            text: '教师班级评分统计',
            x:'center'
        },
        tooltip: {},
        legend: {
            orient: 'vertical',
            left: 'right',
            data:['班级','总分']
        },

        xAxis: {
            data: [<c:forEach items="${requestScope.bar}" var="b" varStatus="index">
                "${b.className}"
                <c:if test="${index.last==false}">
                ,
                </c:if>
                </c:forEach>]
        },
        yAxis: {},
        series: [{
            name: '班级',
            type: 'bar',//直方图形势
            barGap: 0,
            data: [<c:forEach items="${requestScope.bar}" var="b" varStatus="index">
                "${b.avgscore}"
                <c:if test="${index.last==false}">
                ,
                </c:if>
                </c:forEach>]
        },{
            name: '总分',
            type: 'line',//折线形式
            data: [<c:forEach items="${requestScope.bar}" var="b" varStatus="index">
                "${b.avgscore}"
                <c:if test="${index.last==false}">
                ,
                </c:if>
                </c:forEach>]
        }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>

<div id="main_3" style="width: 900px;height:600px;float: left"></div>

<script>
    var anumber="${requestScope.anumber}";
    var pnumber="${requestScope.pnumber}";
    var cnumber=anumber-pnumber;
    var myChart = echarts.init(document.getElementById('main_3'));
    option = {
        title : {
            text: '参评率',
            subtext: '',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'right',
            data: ['60以下','60~70','70~80','80~90','90以上']
        },
        series : [
            {
                name: '人员',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                    {value:pnumber, name:'参评人员'},
                    {value:cnumber, name:'未参评人员'},

                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    myChart.setOption(option);
</script>
