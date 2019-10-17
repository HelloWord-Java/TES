<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
<form action="#" method="post" id="updataClass" >
<div class="edit-content">
	<ul>
		<c:forEach items="${classinfos}" var="classinfos">
		<input style="display: none;" name="Id" value="${classinfos.id}"/>
		<li>班级名:<input type="text" name="className" value="${classinfos.className}"/></li>
		</c:forEach>
	</ul>
</div>
</form>
</div>



