
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
 <%@page import="com.tes1.evaluate.domain.*,java.util.*"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<style type="text/css">



ul,li,ol {
	list-style: none;
}

.clear {
	height: 0px;
	line-height: 0px;
	font-size: 0px;
	overflow: hidden;
	clear: both;
}
body{
	overflow:scroll;
	overflow-x:hidden;
	padding: 0;
    margin: 0;
}
a {
	text-decoration: none;
}
.addDiv{
    margin-top: 6%;
    margin-left: 20%;
    font-size: 18px;
}
.inputStyle{
	height: 24px;
    background: white;
    text-indent: 5px;
}
.addDiv ul li{
	margin-top: 15px;
}
.sbre{
	width: 63px;
    height: 31px;
    margin-left: 54px;
    background: #95b8e7;
    border: 3px solid #95b8e7;
    color: #fdfdfd;
    border-radius: 7px;
}
.edit-content{
    margin-top: 6%;
    margin-left: 20%;
    font-size: 18px;
}
.edit-content ul li{
	margin-top: 15px;
}
</style>
<script language="javascript">
/**
 * 创建一个模态 Dialog
 * 
 * @param id divId
 * @param _url Div链接
 * @param _title 标题
 * @param _width 宽度
 * @param _height 高度
 * @param _icon ICON图标
 */
$(document).ready(function(){
	$('#dg_dept').datagrid({
		 title: '院系信息管理',  //表格名称
		 iconCls: 'icon-save',  //图标
		 width:1080,   //表格宽度
		 height:'auto',   //表格高度，可指定高度，可自动
		 border:true,  //表格是否显示边框
		url:'departmentAction',
		
	    columns:[[
	    	{field:'id',title:'院系Id',width:200},
	        {field:'departmentName',title:'院系名',width:200},
            {field:'deptPid',title:'pid',width:200},
	    ]],   
	    pagination:true,//如果表格需要支持分页，必须设置该选项为true
	    pageSize:17,   //表格中每页显示的行数
	    pageList:[10,17,20,30],
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
            text: '添加',
            iconCls: 'icon-add',
            handler: function() {
               //移除存在的Dialog
            	$("#dialog_add").remove();//或 $("body").remove("#dialog_add");
            	/**先根据div的id删除，但界面元素还是会存在dialog div，还需执行dialog的销毁操作**/
            	$("#dialog_add").dialog('destroy');
            	
            	/*var _buttons = [{
    				 text:'Save',
    				handler:function(){
    					//保存数据 
					}
    			},{
    				text:'Close',
    				handler:function(){
    					 // 关闭窗口
    					$("#dialog_add").dialog('close'); 
					} 
    			}];*/
            	//创建窗口


                createModalDialog("dialog_add","/TCES1/moduls/Department/AddDepartment.jsp","添加院系", 500, 300);
            	$("#dialog_add").dialog('open');//打开窗口 
            }
        }, '-', {
            text: '修改',
            iconCls: 'icon-edit',
            handler: function() {
            	var rows =  $("#dg_dept").datagrid("getSelections");
            	if(rows.length<=0)  
                {  
                    $.messager.alert('警告','您没有选择','error');  
                }  
                else if(rows.length>1)  
                {  
                    $.messager.alert('警告','请选择一条待处理数据','error');  
                }
                else  
                {  
                	var rowId = rows[0].id;
	            	//移除存在的Dialog
	            	$("#dialog_edit").remove();//或 $("body").remove("#dialog_edit");
	            	/**先根据div的id删除，但界面元素还是会存在dialog div，还需执行dialog的销毁操作**/
	            	$("#dialog_edit").dialog('destroy');
	            	var _buttons = [{
	    				text:'保存',
	    				handler:function(){
	    					// 保存数据
	    					 $.ajax({
									 url:'updateDepartmentAction',
									 data:$('#updataDepart').serialize(),
									 type:"post",
									 scriptCharset:'UTF-8',
									 error:function(){
										 if($('#updataDepart').serialize()==null){
											 
										 }
										 alert("修改一条数据！");
									 },
									 success:function(ress){
										 console.log(ress);
										 $("#dialog_edit").dialog('close');
										 $("#dg_dept").datagrid('reload');
									 }
									
								 });
						}
	    			},{
	    				text:'返回',
	    				handler:function(){
	    					// 关闭窗口
	    					$("#dialog_edit").dialog('close');
						}
	    			}];
	            	//创建窗口


                    createModalDialog("dialog_edit","findDepartmentByIdAction?Id="+rowId+"","修改功能", 500, 300,'icon-modify',_buttons);
	            	$("#dialog_edit").dialog('open');
                }
            }
        }, '-', {
            text: '删除',
            iconCls: 'icon-remove',
            handler: function() {
            	var  rows  =  $("#dg_dept").datagrid("getSelections");
            	if(rows.length<=0)  
                {  
                    $.messager.alert('警告','您没有选择','error');  
                }   
                else  
                {  
                	var ids = "";
                	for(var i=0;i<rows.length;i++){
                		if(i>0)
                			ids = ids + ",";
                		ids = ids + rows[i].id;
                	}
                	if(ids!=''){
                		$.messager.confirm('确定','您确定要删除吗',function(t){  
                         if(t)  
                         {  
                             $.ajax({  
                                 url : 'deleteDepartmentByIdAction',  
                                 data : {'ids': ids},
                                 dataType : 'json',  
                                 success : function(r) {  
                                 	console.log(r);
                                     if (r.success && r.success>0) {  
                                     	$('#dg_dept').datagrid('acceptChanges');  
                                         $.messager.show({  
                                             msg : r.msg,  
                                             title : '成功'  
                                         });  
                                         $("#dg_dept").datagrid('reload');  
                                     } else {  
                                         /*datagrid.datagrid('rejectChanges');*/  
                                         /* datagrid.datagrid('beginEdit', editRow);  */ 
                                         $.messager.alert('错误', r.msg, 'error');  
                                     }  
                                     /* datagrid.datagrid('unselectAll');   */
                                 }  
                             });
                         }  
                     });  
                } else {
                	$.messager.alert('警告','您没有选择','error');   
                }	                        
          	 }  
          }
       },'-',{
    	   text: '<input type="text" id="filter" name="filter"/>',
	   },{
	   iconCls: 'icon-search',
	   handler: function() {
		   var filter = $("#filter").val();
		   $.ajax({  
               url : "/TCES1/departmentAction?filter="+filter+"",
               success : function(data){
            	   $('#dg_dept').datagrid('loadData', JSON.parse(data));
               }
           });
	   }
   }]
	});


	function createModalDialog(id, _url, _title, _width, _height, _icon,_buttons){
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
	        buttons: _buttons
	    });
	}
});

function convert(rows){
    function exists(rows, deptPid){
        for(var i=0; i<rows.length; i++){
            if (rows[i].id == deptPid) return true;
        }
        return false;
    }
    var toDo = [];
    var nodes = [];
    // get the top level nodes
    for(var i=0; i<rows.length; i++){
        var row = rows[i];
        if (!exists(rows, row.deptPid)){
            nodes.push({
                id:row.id,
                text:row.departmentName,
                iocnCls:'icon-filter',
                attributes:{
                    id:row.id,
                    name: row.departmentName,
                    parentId: row.deptPid
                }
            });
        }
    }
    for(var i=0; i<nodes.length; i++){
        toDo.push(nodes[i]);
    }

    while(toDo.length){
        var node = toDo.shift();	// the parent node
        // get the children nodes
        for(var i=0; i<rows.length; i++){
            var row = rows[i];
            if (row.deptPid == node.id){
                var child = {
                    id:row.id,
                    text:row.departmentName,
                    attributes:{
                        id:row.id,
                        name: row.departmentName,
                        parentId: row.deptPid
                    }
                };
                if (node.children){
                    node.children.push(child);
                } else {
                    node.children = [child];
                }
                toDo.push(child);
            }
        }
    }
    return nodes;
}
</script>

    <ul id="dept_list" class="easyui-tree" data-options="url:'getDeptTree',loadFilter:convert,dataType:'json',animate:true"></ul>


    <table id="dg_dept"></table>
    <div id=""></div>


