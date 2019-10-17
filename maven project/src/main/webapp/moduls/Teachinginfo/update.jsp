<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.tes1.evaluate.domain.*,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改授课关系</title>
</head>
<body>
<form action="#" id="myformtt1" method="post">
<div class="edit-content">
	<ul> 
	    <li><p><input type="hidden" name="id" value="${requestScope.TeachingInfo.id}" /></p></li>
		<li><p>批次：<select name="batchId" id="batchId" value="${requestScope.TeachingInfo.batchId}">  
					   <c:if test="${!empty requestScope.batchs}">
							<c:forEach items="${requestScope.batchs}" var="bats">
								<c:choose>  
								   <c:when test="${bats.id==requestScope.TeachingInfo.batchId}">   
								   	    <option value="${bats.id}" selected="selected">${bats.batchName}</option>
								   </c:when>  
								   <c:otherwise>  
								   	    <option value="${bats.id}">${bats.batchName}</option>
								   </c:otherwise>  
								</c:choose>
							</c:forEach>
						</c:if>
				</select></p>
		</li>
				<li><p>班级：<select name="classId" id="classId" value="${requestScope.TeachingInfo.classId}">  
					   <c:if test="${!empty requestScope.classinfos}">
							<c:forEach items="${requestScope.classinfos}" var="clas">								
								<c:choose>  
								   <c:when test="${clas.id==requestScope.TeachingInfo.classId}">   
								   	    <option value="${clas.id}" selected="selected">${clas.className}</option>
								   </c:when> 
								   <c:otherwise>  
										<option value="${clas.id}">${clas.className}</option>
								   </c:otherwise>  
								</c:choose> 
							</c:forEach>
						</c:if>
				</select></p>
		</li>
				<li><p>课程：<select name="courseId" id="courseId" value="${requestScope.TeachingInfo.courseId}">  
					   <c:if test="${!empty requestScope.courses}">
							<c:forEach items="${requestScope.courses}" var="cours">
								<c:choose>  
								   <c:when test="${cours.id==requestScope.TeachingInfo.courseId}">   
								   		<option value="${cours.id}" selected="selected">${cours.courseName}</option>
								   </c:when>  								     
								   <c:otherwise>  
										<option value="${cours.id}">${cours.courseName}</option>
								   </c:otherwise>  
								</c:choose> 								
							</c:forEach>
						</c:if>
				</select></p>
		</li>
				<li><p>授课教师：<select name="teacherId" id="teacherId" value="${requestScope.TeachingInfo.teacherId}">  
					   <c:if test="${!empty requestScope.teachers}">
							<c:forEach items="${requestScope.teachers}" var="teach">								
								<c:choose>  
								   <c:when test="${teach.id==requestScope.TeachingInfo.teacherId}"> 
								   		<option value="${teach.id}" selected="selected">${teach.username}</option>  
								   </c:when>  								     
								   <c:otherwise>  
								   		<option value="${teach.id}">${teach.username}</option>
								   </c:otherwise>  
								</c:choose> 
							</c:forEach>
						</c:if>
				</select></p>
		</li>
		<!-- <li><p><input type="button" value="保存"class="sbre" onclick="save()" />
		<input type="button" class="sbre" value="返回" onclick="close()"/></p></li> -->
	</ul>
</div>
</form>
</body>
</html>