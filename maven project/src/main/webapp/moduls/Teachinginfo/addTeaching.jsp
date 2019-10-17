<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.tes1.evaluate.domain.*,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>增加授课关系</title>
<script type="text/javascript" src="/TCES1/jquery-easyui-1.5.3/jquery.min.js"></script>
<script type="text/javascript" src="../../js/jquery-1.9.1.min.js"></script>   

</head>
<body>
<form action="#" id="myformtt" method="post">
		<div class="addDiv" id="addDiv">
			<ul>
				<li><span>批次：&nbsp;&nbsp;</span>
					<select name="batchId" id="batchId">
					<option>--批次--</option>
						<c:if test="${!empty requestScope.batchs}">
							<c:forEach items="${requestScope.batchs}" var="bat">
							<option value="${bat.id}">${bat.batchName}</option>
							</c:forEach>
						</c:if>
					</select>
				</li>
			    <li><span>班级：&nbsp;&nbsp;</span>
					<select name="classId" id="classId">
					<option>--班级--</option>
						<c:if test="${!empty requestScope.classinfos}">
							<c:forEach items="${requestScope.classinfos}" var="cla">
							<option value="${cla.id}">${cla.className}</option>
							</c:forEach>
						</c:if>
					</select>
				</li>
				<li><span>课程：&nbsp;&nbsp;</span>
					<select name="courseId" id="courseId">
					<option>--课程--</option>
						<c:if test="${!empty requestScope.courses}">
							<c:forEach items="${requestScope.courses}" var="cour">
							<option value="${cour.id}">${cour.courseName}</option>
							</c:forEach>
						</c:if>
					</select>
				</li>
				<li><span>教师：&nbsp;&nbsp;</span>
					<select name="teacherId" id="teacherId">
					<option>--教师--</option>
						<c:if test="${!empty requestScope.teachers}">
							<c:forEach items="${requestScope.teachers}" var="teac">
							<option value="${teac.id}">${teac.username}</option>
							</c:forEach>
						</c:if>
					</select>
				</li>
			</ul>
		</div>
	</form>
</body>
</html>