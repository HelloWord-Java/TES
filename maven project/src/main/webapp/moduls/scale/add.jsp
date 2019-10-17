<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.tes1.evaluate.domain.*,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
#actionul li{
	float:left;
	font-size: 14px;
}
#actionul{
     width: 480px;
    height: 77px;
    width: 115px;
}
</style>

<div>
	<form action="#" id="formadd" method="post">
		<div class="addDiv">
			<ul>
				<li>角色名：<input class="inputStyle" type="text" name="scaleName" id="scaleName"/></li>
				<li>
					<ul id="actionul">
						<c:if test="${!empty requestScope.actions}">
						<c:forEach items="${requestScope.actions}" var="act">
							<li><input type="checkbox" name="actList" value="${act.id}"/>${act.actionName}&nbsp;&nbsp;&nbsp;</li>
						</c:forEach>
					</c:if>
					</ul>
					
				</li>
				<li><input type="button" class="sbre" id="save" value="保  存"  onclick="addScale()"/><input class="sbre"type="reset" value="重  置"/></li>
			</ul>
		</div>
	</form>
</div>
<script type="text/javascript">
 function addScale(){
	 $.ajax({
		 url:'addScaleAction',
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
			 $("#dg_scale").datagrid('reload');
		 }
		
	 })
 }
 </script>
