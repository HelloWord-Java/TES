<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.tes1.evaluate.domain.*,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
<form:form action="updateScaleAndActionAction" method="post" modelAttribute="scale" id="formadd">
<div class="edit-content">
	<ul>
		<li><p><form:hidden path="id" /></p></li>
		<li><p>角色名:<form:input path="scaleName" cssClass="inputStyle"/></p></li>
			<c:forEach items="" var="acti">
				 <form:checkbox path="actionId" checked="checked" value="${acti.actionId}"/>
			</c:forEach>
			<c:if test="${!empty requestScope.actions}">
				<c:forEach items="${requestScope.actions}" var="actii">
					<input type="checkbox" name="ListAct" value="${actii.id}"/>${actii.actionName}
				</c:forEach>
			</c:if>
		</li>
		<!--  <li><p><input type="button" value="保存"class="sbre" onclick="UpdateScale()"/>
		<input type="button" class="sbre" value="返回" onclick="editScale()"/></p></li>-->
	</ul>
</div>
</form:form>
</div>
