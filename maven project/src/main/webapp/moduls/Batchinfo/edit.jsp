<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改批次</title>
</head>
<body>
<div>
<form action="#" method="post" id="updataBatch" >
<div class="edit-content">
	<ul>
		
		<c:forEach items="${batchs}" var="batchs">
		<input style="display: none;" name="Id" value="${batchs.id}"/>
		<li>批次名:<input type="text" name="batchName" value="${batchs.batchName}"/></li>
		</c:forEach>
		<!-- <li><p><input type="submit" value="保存"class="sbre"/>
		<input type="button" class="sbre" value="返回" onclick="javascrtpt:window.location.href='/TCES1/moduls/user/BatchManager.jsp'"/></p></li>
		 -->
	</ul>
</div>
</form>
</div>
</body>
</html>