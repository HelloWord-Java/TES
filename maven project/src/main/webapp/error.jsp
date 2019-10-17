<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>system error</title>
<link rel="stylesheet" href="css/main.css" type="text/css" />

</head>
<body>
<br></br>
<br></br>
<br></br>
<div align="center"><font color="red"> 系统异常请联系管理员!<span
	onClick="history.back();" style="cursor: hand; COLOR: #0000a0;">点击返回</span>

</body>
</html>