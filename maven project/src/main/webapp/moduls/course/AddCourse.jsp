<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@page import="com.tes1.evaluate.domain.*"%>
         <%@page import="java.util.ArrayList"%>
         <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
 <%
	if (request.getAttribute("course") == null) {
		Course course = new Course();
		request.setAttribute("course", course);
	}
%>
<html>
<style>
.courseName{
   height: 40px;
   width: 100px;}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课程增加页面</title>
</head>
<body>
<form:form action="insertSelective" method="post"  id="myformtt2" >  
	<div style="margin-left: 50px; margin-top: 50px;font-size:24px">
	 课程名：&nbsp;&nbsp;<input type="text" name="courseName" >
	</div>
</form:form>
</body>
</html>