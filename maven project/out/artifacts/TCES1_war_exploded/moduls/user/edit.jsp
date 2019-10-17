<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.tes1.evaluate.domain.*,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
<form:form action="updateUserAndScaleAction" method="post" modelAttribute="user" id="formadd">
<div class="edit-content">
	<ul>
		<li><p><form:hidden path="id" /></p></li>
		<li><p>用户名:<form:input path="username" cssClass="inputStyle"/></p></li>
		<li><p>密&nbsp;&nbsp;&nbsp;码:<form:input path="password" cssClass="inputStyle"/></p></li>
		<li><p>班级:<form:input path="classId" cssClass="inputStyle"/></p></li>
		<li><p>院系:<form:input path="depId" cssClass="inputStyle"/></p></li>
		
			<c:forEach items="" var="usca">
				 <form:checkbox path="scaleId" checked="checked" value="${usca.scaleId}"/>
			</c:forEach>
			<c:if test="${!empty requestScope.scales}">
				<c:forEach items="${requestScope.scales}" var="sca">
					<input type="checkbox" name="ListSca" value="${sca.id}"/>${sca.scaleName}
				</c:forEach>
			</c:if>
		</li>
		<!--  <li><p><input type="button" value="保存"class="sbre" onclick="UpdateUser()"/>
		<input type="button" class="sbre" value="返回" id="close"/></p></li>-->
	</ul>
</div>
</form:form>
</div>
 </script>