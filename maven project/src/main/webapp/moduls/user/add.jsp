<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.tes1.evaluate.domain.*,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<form action="addUserAction" id="formadd" method="post">
		<div class="addDiv">
			<ul>
				<li>用户名：<input class="inputStyle" type="text" name="username" id="username"/></li>
				<li>密&nbsp;&nbsp;&nbsp;码：<input class="inputStyle" type="password" name="password"id="password"/></li>
				<li>班&nbsp;&nbsp;&nbsp;级：<select name="classId" id="classId" style="width: 160px">
                    <option value="0">---教师---</option>
					<c:forEach items="${requestScope.classlist}" var="item">
						<option value="${item.id}">${item.className}</option>
					</c:forEach>
				</select></li>
				<li>院&nbsp;&nbsp;&nbsp;系：<input class="inputStyle" type="text" name="depId" id="depId"/></li>
				<li>
					<c:if test="${!empty requestScope.scales}">
						<c:forEach items="${requestScope.scales}" var="sca">
							<input type="checkbox" name="scaList" value="${sca.id}"/>${sca.scaleName}
						</c:forEach>
					</c:if>
				</li>
				<li><input type="button" id="save" onclick="addUser()" class="sbre"  value="保  存" /><input class="sbre"type="reset" value="重  置"/></li>
			</ul>
		</div>
	</form>
</div>
<script type="text/javascript">
function addUser(){
	 $.ajax({
		 url:'addUserAction',
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
			 $("#dg_user").datagrid('reload');
		 }
		
	 })
}
 </script>