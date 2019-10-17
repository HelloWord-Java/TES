<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@page import="com.tes1.evaluate.domain.*" %>
         <%@page import="java.util.ArrayList"%>
         <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课程管理</title>
<script language="javascript">
function deleteRecord(url) {
	if (window.confirm("确定要删除选中的记录吗？")) {
		window.location=url;
	}
	}
function addCourse(url){
	window.location=url;
}
</script>
</head>
<body>
<div id="banner">
<p><font style="font-size: 10pt;">课程管理界面</font></p>
<form:form action="/TCES1/coursesAction" method="post" modelAttribute="course">
	<table border="0" cellpadding="1" cellspacing="1" width="95%">
		<tr>
			<td align="right" width="10%">课程名称</td>
			<td width="20%"><form:input path="courseName" cssClass="TextInput"></form:input></td>
		</tr>
		<tr>
			<td align="right" width="10%">&nbsp;</td>
			<td width="20%">&nbsp;</td>
			<td width="70%" colspan="5">&nbsp;</td>
		</tr>
	</table>

	<p></p>
	<div style="margin-left: 30px; margin-right: 0px">
	<table border="0" cellpadding="0" cellspacing="0" width="95%">
		<tr>
			<td width="10%"><input type="submit" value="查找"
				class="BtnAction" />
			</td>
			<td width="10%">
			<input type="button" value="新增" class="BtnAction" onclick="addCourse('./moduls/course/AddCourse.jsp')"/>
			</td>
			<td width="10%"><input type="reset" value="重置" class="BtnAction" /></td>
			<td width="60%">&nbsp;</td>
		</tr>
	</table>
	</div>

	<p></p>

	<div style="margin-left: 30px; margin-right: 0px">
	<table width="50%" border="1" cellpadding="0" cellspacing="0" id="form" style="text-align:center;">
		<tr>
			<td width="5%" class="td_title">课程id</td>
			<td width="8%" class="td_title">课程名称</td>
			<td width="5%" class="td_title">删除</td>
			<td width="5%" class="td_title">修改</td>
	
		</tr>
		<c:if test="${!empty requestScope.courses}">
			<c:forEach items="${requestScope.courses}" var="cou">
				<tr>
					<td class="td_border">${cou.getId()}</td>
					<td class="td_border">${cou.getCourseName()}</td>
					<td class="td_border" align="center">
						<a href="javascript:deleteRecord('/TCES1/deleteCourseByIdAction?Id=${cou.getId()}')">
							<img src="/TCES1/images/wrong.gif" border="0"/>
						</a>
					</td>
					<td class="td_border" align="center">
						<a href="/TCES1/selectByPrimaryKey?Id=${cou.getId()}">
							<img src="/TCES1/images/edit.gif" border="0"/>
						</a>
					</td>				
				
				</tr>
			</c:forEach>
		</c:if>
	</table>

	</div>
</form:form>
</div>

</body>
</html>