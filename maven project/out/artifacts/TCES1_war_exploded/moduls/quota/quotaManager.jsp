<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%> 
    
<script>
	function convert(rows){
		function exists(rows, parentId){
			for(var i=0; i<rows.length; i++){
				if (rows[i].id == parentId) return true;
			}
			return false;
		}
		var toDo = [];
		var nodes = [];
		// get the top level nodes
		for(var i=0; i<rows.length; i++){
			var row = rows[i];
			if (!exists(rows, row.parentId)){
				nodes.push({
					id:row.id,
					text:row.quotaName,
					iocnCls:'icon-filter',
					attributes:{
						id:row.id,
						name: row.quotaName,
						weight:row.weight,
						parentId: row.parentId
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
				if (row.parentId == node.id){
					var child = {
						id:row.id,
						text:row.quotaName+'('+row.weight+')',
						attributes:{
							id:row.id,
							name: row.quotaName,
							weight:row.weight,
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

	function onTreeClicked(node){
		if(node!=null && node!=undefined && node.attributes!=null && node.attributes!=undefined){
			var name = node.attributes.name;
			var weight = node.attributes.weight;
			var id = node.attributes.id;
			var parentId = node.attributes.parentId;
			var options = node.attributes.options;
			 if(options==null||options==undefined){
				 $.ajax({
					 url : 'selectOptions',  
                     data : {'quotaId': id},
                     dataType : 'json',  
                     type : "post",
                     scriptCharset: 'UTF-8',
                     success : function(ress) { 
                    	console.log(ress);
                    	var options = JSON.parse(ress);
                    	 if(options.length==0){
                    		 $(".optionsName").empty();
                    		 
                    	 }else{
                    		 $(".optionsName").empty();
                    		 var character = new Array("A","B","C","D","E","F","G","H","I","J");
                    		 for(i=0;i<options.length;i++){
                   				$("<span/>").appendTo(".optionsName").html("选项"+character[i]+":"); 
                           		$(".optionsName").append($('<input type="text" name="a'+i+'" value="'+options[i].optionsName+'" />'));
                           		$(".optionsName").append($('<input type="text" id="aascore" value="'+options[i].score+'" />'));
                   			}
                   			 $(".optionsName").append($('<input id="sub" type="submit" value="提交" />'));
                   			 $(".optionsName").append($('<input id="sub" type="reset" value="重置" />'));
                    	 }
                     },
                     error: function(ress){
                    	 alert("失败！");
                     }
				 });
			}
			$("#quotaName").val(name);
			$("#weight").val(weight);
			$("#parentId").val(id);
			$("#idd").val(id);
		}
	}

function createDialog1(){
	
	$("#addParent").dialog('open');
}
function createDialog2(){
	$("#addChild").dialog('open');
}
function createDialog3(){
	$("#addTitle").dialog('open');
}
function createDialog4(){
	$("#quotaId").val($("#idd").val());
	
	if($("#idd").val()==null||$("#idd").val()==undefined||$("#idd").val()==""){
		alert("请选择需要维护的指标！");
	}else{
		$("#upquotaName").val($("#quotaName").val());
		$("#upweight").val($("#weight").val());
		$("#quotaoptions").dialog('open');
	}
	
}
function closeDialog1(){
	$("#addParent").dialog('close');
}
function closeDialog2(){
	$("#addChild").dialog('close');
}
function closeDialog3(){
	$("#addTitle").dialog('close');
}
function closeDialog4(){
	$("#quotaoptions").dialog('close');
}
function upQuotaInfo(){
	
	var quotaId=$("#quotaId").val();
	var upquotaName=$("#upquotaName").val();
	var upweight=$("#upweight").val();
	alert("quotaId"+quotaId+"upquotaName"+upquotaName+"upweight"+upweight);
	$.ajax({
		url:'upQuotaiInfo',
		data:{'id':quotaId,'quotaName':upquotaName,'weight':upweight},
		dataType:'json',
		type:'post',
		async:false,
		scriptCharset: 'UTF-8',
		success:function(ress){
			closeDialog4();
        	$("#quota_list").tree("reload");
			alert("修改成功");
		}
	})
}
function delquota(){
	var id=$("#idd").val();
	$.ajax({
		url:'delquota',
		data :{'id':id},
		dataType : 'json', 
		type:'post',
		async: false,
		scriptCharset: 'UTF-8',
		success:function(ress){
			$("#quota_list").tree("reload");
			alert("删除成功！");
		}
	})
}

	function saveQuotaInfo(){
		var name = $("#addquotaName").val();
		var weight = $("#addweight").val();
		var parentId = $("#parentId").val();
		var parentNode = $("#quota_list").tree("getParent");
		$.ajax({
			 url : 'AddChildQuota',  
            data : {'quotaName': name, 'weight': weight, 'parentId':parentId},
            dataType : 'json',  
            type : "post",
            scriptCharset: 'UTF-8',
            async: false,
            success : function(ress) { 
            	closeDialog2();
            	$("#quota_list").tree("reload");//,parentNode.target
           		if(ress>0){
           			var tab = $('#tt').tabs('getSelected');  // get selected panel
           			$('#tt').tabs('update', {
           				tab: tab,
						type: 'all'
           			});
           		} else{
           			alert("失败！");
           		}
            },
            error: function(ress){
           		alert("失败！");
            }
		 });
	}
    function aaddAllQuota() {
        var formData= new FormData($("#quotaExcel_form")[0]);
        $.ajax({
            url:"addAllQuota",
            type:"post",
            data:formData,
            contentType:false, //- 必须false才会自动加上正确的Content-Type
            processData: false,
            success:function (data) {
                console.log("导入成功")
                if(data){
                    alert("导入成功！");
                }else {
                    alert("导入失败！");
                }
            }
        })
    }
</script>  

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
.page_left{
    width: 20%;
    height: 100%;
    background: #ffffff;
    float: left;
    color: black;
    overflow: auto;
    border: 1px dashed #cec3c3;
    border-left: none;
    border-bottom: none;
    border-top: none;
}
.page_right{
    width: 67%;
    height: 100%;
    background: #ffffff;
    float: left;
    color: black;
}
.optionsName{
	width:360px;
	height:100%;
	margin: 0 auto;
}
.optionsName input{
    float: left;
    width: 266px;
    margin-top: 12px;
    height: 24px;
}
.optionsTitle{
    margin-top: 3%;
    margin-left: 15%;
    font-size: 16px;
    color: blue;
}
.optionInput{
    margin-left: 39%;
    margin-top: 16px;
}
.optionInput input{
    height: 25px;
    margin-left: 17px;
}
.optionsAdd{
    padding-left: 11%;
    padding-top: 18px;
}
.optionsAdd input{
	height:25px;
	width:133px;
    margin-left: 16px;
}
.optionsP{
    margin-top: 42px;
    font-size: 16px;
    margin-left: 12px;
    color: #0303ff;
}
.optionsName span{
    float: left;
    padding-top: 17px;
}
#sub{
    width: 68px;
    margin-left: 62px;
    margin-top: 53px;
 	font-size: 14px;
}
#aascore{
	width: 20px;
    margin-left: 10px;
    text-align: center;
}
.AddContent{
	width: 300px;
    height: 100%;
    text-align: center;
    margin-left: auto;
    margin-right: auto;
    margin-top: 45px;
}
.AddContent p{
	font-size:14px;
	margin-top: 15px;
}
</style>


<div>
	<div class="easyui-layout page_left">
		<ul id="quota_list" class="easyui-tree" data-options="url:'getQuotaTree',loadFilter:convert,onClick:onTreeClicked,dataType:'json',animate:true"></ul>  
	</div>
	<div class="easyui-layout page_right">
		<div class="optionsTitle">指标名称：<input type="text" id="quotaName"/>指标权重：<input type="text" id="weight"/><input style="display: none;" type="text" id="idd"/></div>
		<div class="optionInput">
			
		</div>
		<div class="optionsAdd">
			<input type="button" onclick="createDialog2()" value="增加下级指标"/>
			<input type="button" onclick="createDialog4()" value="指标维护"/>
			<input type="button" onclick="delquota()" value="删除指标"/>
			<form id="quotaExcel_form"  method="post" enctype="multipart/form-data">
				<input type="file" name="quotaExcel">
				<input type="button" onclick="addAllQuota()" value="导入">
			</form>
		</div>
		<p class="optionsP">指标选项维护</p>
		<hr>
		<form>
		<div class="optionsName"></div>
		</form>
	</div>
		
	<!-- 增加下级指标dialog -->
	<div id="addChild" class="easyui-dialog" style="width:500px;height:300px;"
		data-options="title:'增加下级指标',modal:true,closed:true,buttons:'#bb'">
			<div class="AddContent">
				<p>本级ID：<input name="parentId" id="parentId" type="text"/></p>
				<p>指标名：<input name="quotaName" id="addquotaName" type="text"/></p>
				<p>权重值：<input name="weight" id="addweight" type="text"/></p>
			</div>
	</div>
	<div id="bb">
		<a onclick="saveQuotaInfo()" class="easyui-linkbutton">提交</a>
		<a href="#" onclick="closeDialog2()" class="easyui-linkbutton">关闭</a>
	</div>
	<!-- 增加下级指标dialog end-->
	<!-- 指标维护 dialog-->
	<div id="quotaoptions" class="easyui-dialog" style="width:500px;height:300px;text-align: center;"
	data-options="title:'指标维护',modal:true,closed:true,buttons:'#bb'">
	<div>
	<p>本级ID：<input name="quotaId" id="quotaId" type="text"/></p>
	<p>指标名：<input name="quotaName" id="upquotaName" type="text"/></p>
	<p>权重值：<input name="weight" id="upweight" type="text"/></p>
	</div>
	</div>
	<div id="bb">
		<a onclick="upQuotaInfo()" class="easyui-linkbutton">提交</a>
		<a href="#" onclick="closeDialog4()" class="easyui-linkbutton">关闭</a>
	</div>
	<!-- 指标维护 dialog end-->
	
	<!-- 增加题目指标dialog -->
	<div id="addTitle" class="easyui-dialog" style="width:500px;height:300px;"
		data-options="title:'增加题目指标',buttons:'#cc',modal:true,closed:true">
		<form action="AddTitleQuota">
			<div class="AddContent">
				<p>本级ID：<input name="parentId" id="parentId" type="text"/></p>
				<p>指标名：<input name="quotaName" id="quotaName" type="text"/></p>
				<p>权重值：<input name="weight" id="weight" type="text"/></p>
			</div>
		</form>	
	</div>
	<div id="cc">
		<a href="#" onclick="" class="easyui-linkbutton">Save</a>
		<a href="#" onclick="closeDialog3()" class="easyui-linkbutton">Close</a>
	</div>
	<!-- 增加题目指标dialog end -->
</div>

