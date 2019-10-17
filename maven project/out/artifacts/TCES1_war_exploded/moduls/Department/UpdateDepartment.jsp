<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
<form action="#" method="post" id="updataDepart" >
<div class="edit-content">
	<ul>
		<c:forEach items="${departments}" var="departments">
		<input style="display: none;" name="Id" value="${departments.id}"/>
		<li>班级名:<input type="text" name="departmentName" value="${departments.departmentName}"/></li>
		</c:forEach>
	</ul>
</div>
</form>
</div>



