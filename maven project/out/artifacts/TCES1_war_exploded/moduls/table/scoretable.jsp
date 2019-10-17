<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@page import="com.tes1.evaluate.domain.*,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    /*jsp页面获取session的值*/
//String userId = request.getSession().getAttribute("userId").toString();

%>
<script>
    $(document).ready(function(){
        $("#score").datagrid({
            title: '成绩查询',  //表格名称
            iconCls: 'icon-save',  //图标
            width:1080,   //表格宽度
            height:'auto',   //表格高度，可指定高度，可自动
            border:true,  //表格是否显示边框
            url:'/TCES1/findscoretable',
            columns:[[
                {field:'username',title:'授课教师（按成绩排名）',width:200,align:'center'},
                {field:'courseName',title:'所授课程',width:200,align:'center'},
                {field:'avgScore',title:'综合成绩',width:200,align:'center'},
                {field:'id',title:'操作',width:200,align:'center',
                    formatter : function(value,row,index) {
                        return '<button onclick="kkk('+row.teacherid+')">详细</button>'
                    },}

            ]],
            pagination:true,//如果表格需要支持分页，必须设置该选项为true
            pageSize:20,   //表格中每页显示的行数
            pageList:[10,20,30],
            fit:true,//自动补全
            fitColumns:true,
            singleSelect:false,
            rownumbers:true,   //是否显示行号
            nowrap: false,
            striped: true,  //奇偶行是否使用不同的颜色
            method:'POST',   //表格数据获取方式,请求地址是上面定义的url
            sortName: 'ID',  //按照ID列的值排序
            sortOrder: 'desc',  //使用倒序排序
            idField: 'id',
            loadMsg:'数据正在努力加载，请稍后...',   //加载数据时显示提示信息
            frozenColumns: [[  //固定在表格左侧的栏
                {field: 'ck', checkbox: true},
            ]],
            toolbar: [{
                text: '课程名：<input type="text" id="coursename" name="coursename"/>'
            },{
                iconCls: 'icon-search',
                handler: function(){
                    var coursename=$("#coursename").val();
                    $.ajax({
                        url : "/TCES1/searchSocrelist?coursename="+coursename,
                        success : function(data){
                            console.log(data);
                            $('score').datagrid('loadData', JSON.parse(data));
                        }
                    });
                }
            }],
        })
    });
    function kkk(uid){
        var url = "/TCES1/ScoreData?teacherid="+uid;
        console.log(uid);
        var tab = $('#tt').tabs('getSelected');
           content= '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
            $('#tt').tabs('add',{
                title:'用户详情',
                content:content,
                closable:true,
                tools:[{
                    iconCls:'icon-mini-refresh',
                    handler:function(){
                        //alert('refresh');
                    }
                }]
            });
            //}

    }
    function createModalDialog(id, _title, _width, _height, _icon){
        $("body").append("<div id='"+id+"' class='easyui-window'></div>");
        if (_width == null)
            _width = 800;
        if (_height == null)
            _height = 500;

        $("#"+id).dialog({
            title: _title,
            width: _width,
            height: _height,
            cache: false,
            iconCls: _icon,

            collapsible: false,
            minimizable:false,
            maximizable: true,
            resizable: true,
            modal: true,
            closed: true,
            //buttons: _buttons
        });
    }

</script>
<tabel id="score"></tabel>
<div id=""></div>