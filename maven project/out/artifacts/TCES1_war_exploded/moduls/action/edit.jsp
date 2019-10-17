<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.tes1.evaluate.domain.*,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
<form action="updateActionAction" method="post" id="formadd" >
<div class="edit-content">
	<ul>
		<li><p><input type="hidden" name="id" value="${requestScope.actions.id}" /></p></li>
		<li><p>功能名:<input name="actionName" value="${requestScope.actions.actionName }"  class="inputStyle"/></p></li>
		<li><p>功能地址：<input name="actionUrl"value="${requestScope.actions.actionUrl }" class="inputStyle"/></p></li>
		<li><p>父节点：<select name="parentId" id="parentId" value="${requestScope.actions.parentId }">  
					   <c:if test="${!empty requestScope.actionss}">
							<c:forEach items="${requestScope.actionss}" var="acts">
								<option value="${acts.id}">${acts.actionName}</option>
							</c:forEach>
						</c:if>
				</select></p></li>
	</ul>
</div>
</form>
</div>
