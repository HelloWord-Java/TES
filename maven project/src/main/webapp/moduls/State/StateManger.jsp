<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table id="items"></table>
<script>
	$(function(){
		dginit();
	})
	function dginit(){
	$("#items").datagrid(
			{
				url : "/TCES1/allbatch",
				title : "评教管理",
				singleSelect : true,
				columns : [ [
						{
							field : 'batchName',
							title : '批次名',
							width : 300
						},
						{
							
							field : 'state',
							title : '评教状态',
							width : 300,
							formatter : function(value, row, index) {
								var state = row.state;
								if (state == 0) {
									return '未开启';
								} else if (state == 1) {
									return '正在评教';
								}
							}
						},
						{
							field : 'id',
							title : '操作',
							width : 430,
							align : 'left',
							formatter : function(value, row, index) {
								var state = row.state;
								
								if (row.state == 1) {
									return '<button  onclick="aaa('+row.id+',0,'+row.id+')">关闭</button>'
								} else if (row.state == 0) {
									return '<button  onclick="aaa('+row.id+',1,'+row.id+')">开启</button>'
								} 
							},
						}

				] ],
				pagination : true,//如果表格需要支持分页，必须设置该选项为true
				method : 'POST', //表格数据获取方式,请求地址是上面定义的url
				sortName : 'id', //按照ID列的值排序
			})
	}
			function aaa(id,state,batchid){
				$.ajax({
					type:"post",
					url:"/TCES1/modbatch",
					data:{id:id,state:state,batchid:batchid},
					async: false,
					success:function(){
						 $("#items").datagrid('reload');
					}
				})
	}
</script>
<table id="items"></table>