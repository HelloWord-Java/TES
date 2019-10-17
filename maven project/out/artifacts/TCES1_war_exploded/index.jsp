<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%> 
    <%@page import="com.tes1.evaluate.domain.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>在线综合评教系统</title>  
<link rel="stylesheet" type="text/css"  
    href="jquery-easyui-1.5.3/themes/default/easyui.css">  
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.3/themes/icon.css">
<link rel="stylesheet" href="/TCES1/css/biao_2.css">
<script type="text/javascript" src="/TCES1/jquery-easyui-1.5.3/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.5.3/jquery.easyui.min.js"></script>  
<script type="text/javascript" src="jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/TCES1/js/echarts.min.js"></script>
    <script type="text/javascript" src="/TCES1/js/require.js"></script>
<script>  
$(function(){

	function convert(rows){
		function exists(rows, parentId){
			for(var i=0; i<rows.length; i++){
				if (rows[i].id == parentId) return true;
			}
			return false;
		}
		
		var nodes = [];
		// get the top level nodes
		for(var i=0; i<rows.length; i++){
			var row = rows[i];
			if (!exists(rows, row.parentId)){
				nodes.push({
					id:row.id,
					text:row.actionName,
					iocnCls:'icon-filter',
					attributes:{
						url: row.actionUrl,
						name:row.actionName,
						parentId: row.parentId
					}
				});
			}
		}
		
		var toDo = [];
		for(var i=0; i<nodes.length; i++){
			toDo.push(nodes[i]);
		}
		while(toDo.length){
			var node = toDo.shift();	// the parent node
			// get the children nodes
			for(var i=0; i<rows.length; i++){
				var row = rows[i];
				if (row.parentId == node.id){
					var child = {
						id:row.id,
						text:row.actionName,
						attributes:{
							url: row.actionUrl,
							name:row.actionName,
							parentId: row.parentId
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

	$('#menu_list').tree({
		data: <%=session.getAttribute("action")%>,
		dataType:"json",
		loadFilter: function(rows){
			return convert(rows);
		},
		animate: true,
		onClick: function(node){
			if(node!=null && node!=undefined && node.attributes!=null && node.attributes!=undefined){
				var url = node.attributes.url;
				console.log(url);
				if(url!=null && url!=undefined && url!=""){
					var name = node.attributes.name;
					console.log(name);
					//window.parent.mainFrame.location.href=url;
					if ($('#tt').tabs('exists', name)){
				        $('#tt').tabs('select', name);
				    } else {
						$('#tt').tabs('add',{
						    title:name,
						    href:url,
						    closable:true,
						    tools:[{
								iconCls:'icon-mini-refresh',
								handler:function(){
									alert('refresh');
								}
						    }]
						});
				    }
				}
			}
		}
	});
	 $('#tt').tabs('add',{  
	        title:'首页',  
	        href:'main.jsp',  
	        closable:false  
	    }); 

});
</script> 
<style>
.top{
    width: 100%;
    height: 100px;
    float: left;
    font-family: 方正舒体;
    background:url("images/banner.gif") ;
    background-attachment: fixed;
    text-align: center;
    font-size:60px;
    line-height: 100px;
}
</style> 
</head>  
<body class="easyui-layout">  
    <div data-options="region:'north',noheader:true,split:false" style="height:104px;">  
       <div class="top">
    <div style="float: left;margin-top: 10px;margin-left: 30px"><img src="images/CG_log.gif" height="80px" width="400px" /></div>
    <div style="float: left;margin-left: 300px">在线评教系统 </div>
    <div style="float: left"><a href="#" style="text-decoration:underline;font-size: 20px;color: red">退出</a></div>用户名：<%=((User)session.getAttribute("user")).getUsername()%>
</div>
    </div>  
    <div data-options="region:'south',noheader:true,split:false" style="height:50px;"></div>  
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:210px;">
		<div>
         	<ul id="menu_list" class="easyui-accordion"></ul>
       	</div> 
    </div>  
    <div data-options="region:'center'," style="padding:1px;">  
   <div id="tt" class="easyui-tabs" data-options="fit:true,border:false">
	    
	</div>
    </div>

</body>  
</html>  