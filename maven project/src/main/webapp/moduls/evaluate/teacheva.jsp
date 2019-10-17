<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
$(document).ready(function(){

	$("#sum").click(function(){
        $("#dialog_teacheva").dialog('close');
		var studentId="<%=request.getParameter("studentId")%>"; 
		var teachingId="<%=request.getParameter("teachingId")%>"; 
		var sum = parseFloat(0);
		var readio=$("input[type='radio']");
		var readiocked=$("input[type='radio']:checked");
	 	if(readio.length/4!=readiocked.length){
			var a=readio.length/4-readiocked.length;
			alert("你有"+a+"题未答!请完善后再次提交");
		}else{
	 	    console.log("提交成功");
            $("#dialog_OnlineEvaluate").dialog('close');
			readiocked.each(function(){
				sum += parseFloat($(this).val());
				$.ajax({
					type:"post",
					url:"/TCES1/addgrade",
					data:{studentId:studentId,teachingId:teachingId,score:sum},
					async: false,
					success:function(){

						$("#dialog_teacheva").dialog('close');
						$("#pj").val("已评");
						},
					error:function(){
						alert("提交失败！");
					}
				})
			})
		}
	})
})
</script>
<style>

li{
            list-style-type:none;
            float: left;
        }
.table_2{
    width: 99%;
    background: rgba(185, 239, 194, 0.08);
}
.table_2 tbody tr:nth-child(odd) td {
    background: #90c1a7;
    padding-left: 20px;
}
.table_2 td{
    height: 50px;
}

</style>
<div style="width: 80%;margin: auto;">
<form>
    <div>
        <table class="table_2" style="">

<c:forEach items="${quotas}" var="quotas">
    <tr><td colspan="4">${quotas.getNumber()}&nbsp;${quotas.getQuotaName()}</td></tr>
    <tr>
<c:forEach items="${quotas.quotaoptions}" var="quotaoptions">
<td><input type="radio" name="${quotas.id}" value="${quotaoptions.optionScore}">${quotaoptions.optionsName}</input></td>
</c:forEach>
    </tr>
</c:forEach>
<div style="buttom:2%;position: relative;left: 50%">
<input class="sum" id="sum" type="button" value="提交">
</div>
        </table>
    </div>
</form>
</div>
