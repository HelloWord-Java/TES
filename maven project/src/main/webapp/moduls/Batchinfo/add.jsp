<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.tes1.evaluate.domain.*,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<form action="#" method="post" id="addBatch">
	<div class="addDiv">
				<ul>
					<li>批次名：<input class="inputStyle" type="text" name="batchName" id="batchName"/></li>
					<li><input type="button" class="sbre"value="保  存" onclick="saveBatch()"/>
						<input class="sbre"type="reset" value="重  置"/>
					</li>
				</ul>
			</div>
	</form>
<!--  -->
<script type="text/javascript">
function saveBatch(){
	 $.ajax({
		 url:'TCES1/addbatch',
		 data:$('#addBatch').serialize(),
		 type:"post",
		 scriptCharset:'UTF-8',
		 error:function(){
			 if($('#addBatch').serialize()==null){
				 
			 }
			 alert("添加一条数据！");
		 },
		 success:function(ress){
			 console.log(ress);
			 $("#dialog_add").dialog('close');
			 $("#dg_batch").datagrid('reload');
		 }
		
	 })
}
</script>

