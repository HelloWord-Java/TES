<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.tes1.evaluate.domain.*" %>
         <%@page import="java.util.ArrayList"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <div>
<form:form action="#" method="post" id="updateCourseForm" >
<div class="edit-content">
	<ul>
		<c:forEach items="${courses}" var="courses">
		<input style="display: none;" name="Id" value="${courses.id }"/>
		<li>课程名:<input type="text" name="courseName" value="${courses.courseName}"/></li>
		</c:forEach>
	</ul>
</div>
</form:form>
</div>
