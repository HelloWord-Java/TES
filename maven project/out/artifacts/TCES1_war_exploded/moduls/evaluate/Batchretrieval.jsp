<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.tes1.evaluate.domain.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<input id="classid" style="display: none;" uid="<%=((User)session.getAttribute("user")).getId()%>"  value="<%=((User)session.getAttribute("user")).getClassId()%>"></input>
<table id="dg_teachs"></table>
<div id=""></div>
<script type="text/javascript">
$(document).ready(function(){
	aa();
})
function aa(classid,batchid,teacherid){
	$('#dg_teachs').datagrid({
		iconCls: 'icon-save',  //图标
		 width:1080,   //表格宽度
		 height:'auto',   //表格高度，可指定高度，可自动
		 border:true,  //表格是否显示边框
		url:'searchteaching?classid='+classid+'&&batchid='+batchid+'&&teacherid='+teacherid,
	    columns:[[
	    	/* {field:'id',title:'用户id',width:200}, */
	    	{field:'batchName',title:'批次',width:200,align:'center'},
	    	{field:'className',title:'班级',width:200,align:'center'},
	        {field:'courseName',title:'课程',width:200,align:'center'},
	        {field:'username',title:'授课教师',width:200,align:'center'},
	        {field:'departmentName',title:'所属院系',width:200,align:'center'},
	       {field : 'id',
				title : '操作',
				width : 200,
				align : 'left',
				formatter : function(value, row, index) {
						return '<button  onclick="aaa('+<%=((User)session.getAttribute("user")).getId()%>+','+row.id+')">评教</button>'
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
	            toolbar:[
	            	{ text:'<select name="Id" id="batchid"><c:forEach items="${ batchs}" var="batchs"><option value="${batchs.id}" state="${batchs.state}">${batchs.batchName}</option></c:forEach></select>',},{
	            		 iconCls: 'icon-search',
	            		 handler:function(){
	            			 var cid=$("#classid").val();
	            			 var batchid=$("#batchid").val();
	            			 var batchstate=$("#batchid").find("option:selected").attr("state");
	            			 var userid=$("#classid").attr("uid");
	            			
	            			 if(batchstate==1){
	            				 if(cid==0){
	            					 by(0,batchid,userid);
	            				 }else{
	            					 aa(cid,batchid,0);
	            				 }
	            				 
	            			 }else{
	            				 alert("该学期评教未开启！");
	            				 aa();
	            			 }
	            			 
	            		 }
	            	}
	            ]
	})
};
function by(classid,batchid,teacherid){
	$('#dg_teachs').datagrid({
		iconCls: 'icon-save',  //图标
		 width:1080,   //表格宽度
		 height:'auto',   //表格高度，可指定高度，可自动
		 border:true,  //表格是否显示边框
		url:'searchteachingby?classid='+classid+'&&batchid='+batchid+'&&teacherid='+teacherid,
	    columns:[[
	    	/* {field:'id',title:'用户id',width:200}, */
	    	{field:'batchName',title:'批次',width:200,align:'center'},
	        {field:'courseName',title:'课程',width:200,align:'center'},
	        {field:'username',title:'授课教师',width:200,align:'center'},
	        {field:'departmentName',title:'所属院系',width:200,align:'center'},
	       {field : 'id',
				title : '操作',
				width : 200,
				align : 'left',
				formatter : function(value, row, index) {
						return '<button id="pj"  onclick="aaa('+<%=((User)session.getAttribute("user")).getId()%>+','+row.id+')">评教</button>'
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
	            toolbar:[
	            	{ text:'<select name="Id" id="batchid"><c:forEach items="${ batchs}" var="batchs"><option value="${batchs.id}" state="${batchs.state}">${batchs.batchName}</option></c:forEach></select>',},{
	            		 iconCls: 'icon-search',
	            		 handler:function(){
	            			 var cid=$("#classid").val();
	            			 var batchid=$("#batchid").val();
	            			 var batchstate=$("#batchid").find("option:selected").attr("state");
	            			 var userid=$("#classid").attr("uid");
	            		
	            			 if(batchstate==1){
	            				 if(cid==0){
	            					 by(0,batchid,userid);
	            				 }else{
	            					 aa(cid,batchid,0);
	            				 }
	            				 
	            			 }else{
	            				 alert("该学期评教未开启！");
	            				 aa();
	            			 }
	            			 
	            		 }
	            	}
	            ]
	})
}
function aaa(studentId,teachingId){
	var classid=$("#classid").val();
    $("#pj").val("已评");
	if(classid!=0){
		
		$("#dialog_OnlineEvaluate").remove();//或 $("body").remove("#dialog_edit");
		/**先根据div的id删除，但界面元素还是会存在dialog div，还需执行dialog的销毁操作**/
		$("#dialog_OnlineEvaluate").dialog('destroy');
		createModalDialog("dialog_OnlineEvaluate","CreateQuestionnaire?id=2&&weight=0.3&&levelWeight=0.3&&studentId="+studentId+"&&teachingId="+teachingId+"","在线评教", '80%', '80%');
		$("#dialog_OnlineEvaluate").dialog('open');
        $("#pj").val("已评");
	}else{
		
		$("#dialog_teacheva").remove();//或 $("body").remove("#dialog_edit");
		/**先根据div的id删除，但界面元素还是会存在dialog div，还需执行dialog的销毁操作**/
		$("#dialog_teacheva").dialog('destroy');
		createModalDialog("dialog_teacheva","CreateQuestionnaire?id=3&&weight=0.7&&levelWeight=0.7&&studentId="+studentId+"&&teachingId="+teachingId+"","在线评教", '80%', '80%');
		$("#dialog_teacheva").dialog('open');
        $("#pj").val("已评");
	}
}
function createModalDialog(id, _url, _title, _width, _height, _icon){
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
        href: _url,
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