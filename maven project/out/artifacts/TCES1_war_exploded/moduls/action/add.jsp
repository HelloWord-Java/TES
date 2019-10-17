<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.tes1.evaluate.domain.*,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/public.css">
<title>功能增加</title>
<style type="text/css">
</style>
</head>
<body>
<div>
	<form action="#" id="formadd" method="post">
		<div class="addDiv">
			<ul>
				<li>功能名：&nbsp;&nbsp;<input class="inputStyle" type="text" name="actionName" id="actionName"/></li>
				<li>功能地址：<input class="inputStyle" type="actionUrl" name="actionUrl"id="actionUrl"/></li>
				<li><span>父节点：&nbsp;&nbsp;</span>
				<select name="parentId" id="parentId">  
					   <option>--请选择功能父节点--</option>
					   <c:if test="${!empty requestScope.actions}">
							<c:forEach items="${requestScope.actions}" var="act">
								<option value="${act.id}">${act.actionName}</option>
							</c:forEach>
						</c:if>
				</select></li>
				<li><input type="button" class="sbre"value="保  存"  onclick="addAction()"/><input class="sbre"type="reset" value="重  置"/></li>
			</ul>
		</div>
	</form>
</div>
<script type="text/javascript">
 function addAction(){
	 $.ajax({
		 url:'addActionAction',
		 data:$('#formadd').serialize(),
		 type:"post",
		 scriptCharset:'UTF-8',
		 error:function(){
			 if($('#formadd').serialize()==null){
				 
			 }
			 alert("添加一条数据！");
		 },
		 success:function(ress){
			 console.log(ress);
			 $("#dialog_add").dialog('close');
			 $("#dg_action").datagrid('reload');
		 }
		
	 })
 }
 </script>
</body>
</html>