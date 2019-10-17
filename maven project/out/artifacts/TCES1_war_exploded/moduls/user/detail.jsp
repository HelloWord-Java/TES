<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.tes1.evaluate.domain.*,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
.edit-content{
    border: 1px solid #2196F3;
    width: 500px;
    height: 300px;
    margin-left: auto;
    margin-right: auto;
    margin-top: 6%;
}
.content{
    margin-left: 11%;
    margin-top: 12%;
}
.sbre{
    width: 63px;
    height: 31px;
    margin-left: 54px;
    background: #95b8e7;
    border: 3px solid #95b8e7;
    color: #fdfdfd;
    border-radius: 7px;
    position: absolute;
    left: 61%;
    top: 62%;
}
</style>

<div class="edit-content">
	<div class="content">
	<p>用户名：<span style="color:blue;">${requestScope.user.username}</span></p>
	<p>权限：<span style="color:blue;"><c:if test="${!empty requestScope.scales}">
				<c:forEach items="${requestScope.scales}" var="sca">
					${sca.scaleName}&nbsp;&nbsp;
				</c:forEach>
			</c:if>
	</span></p>
	</div>
	<input type="button" class="sbre" value="返回" id="close"/>

</div>

<script type="text/javascript">
$(function () {
    $("#close").click(function () {
        //window.parent.tabsClose();
        var tab=$('#tt').tabs('getSelected');//获取当前选中tabs  
    var index = $('#tt').tabs('getTabIndex',tab);//获取当前选中tabs的index  
    $('#tt').tabs('close',index);//关闭对应index的tabs
    });
});
</script>
