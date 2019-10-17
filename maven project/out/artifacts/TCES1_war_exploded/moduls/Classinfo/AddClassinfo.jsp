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

<form action="addClassinfoAction" method="post" id="addClassinfo">
	<div class="addDiv">
				<ul>
					<li>班级名：<input class="inputStyle" type="text" name="className" id="className"/></li>
					<li><input type="button" class="sbre"value="保  存" onclick="saveClass()"/>
						<input class="sbre"type="reset" value="重  置"/>
					</li>
				</ul>
			</div>
</form>
<script type="text/javascript">
function saveClass(){
	 $.ajax({
		 url:'addClassinfoAction',
		 data:$('#addClassinfo').serialize(),
		 type:"post",
		 scriptCharset:'UTF-8',
		 error:function(){
			 if($('#addClassinfo').serialize()==null){
				 
			 }
			 alert("添加一条数据！");
		 },
		 success:function(ress){
			 console.log(ress);
			 $("#dialog_add").dialog('close');
			 $("#dg_class").datagrid('reload');
		 }
		
	 })
}
</script>