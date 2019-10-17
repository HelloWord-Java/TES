<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
          <%@page import="com.tes1.evaluate.domain.*" %>
         <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
    <%
	if (request.getAttribute("classinfo") == null) {
		Classinfo classinfo = new Classinfo();
		request.setAttribute("classinfo", classinfo);
	}
%>

<form action="addDepartmentAction" method="post" id="addDepartment">
	<div class="addDiv">
				<ul>
					<li>院系名：<input class="inputStyle" type="text" name="departmentName" id="departmentName"/></li>
					<li>父级学院编号：<input class="inputStyle" type="text" name="DeptPid" id="DeptPid"/></li>
					<li><input type="button" class="sbre"value="保  存" onclick="saveDept()"/>
						<input class="sbre"type="reset" value="重  置"/>
					</li>
				</ul>
			</div>
</form>
<script type="text/javascript">
function saveDept(){
	 $.ajax({
		 url:'addDepartmentAction',
		 data:$('#addDepartment').serialize(),
		 type:"post",
		 scriptCharset:'UTF-8',
		 error:function(){
			 if($('#addDepartment').serialize()==null){
                 alert("添加一条数据！");
			 }

		 },
		 success:function(ress){
			 console.log(ress);
			 $("#dialog_add").dialog('close');
			 $("#dg_dept").datagrid('reload');
		 }
		
	 })
}
</script>