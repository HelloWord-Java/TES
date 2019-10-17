<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>系统登录</title>
 <link rel="stylesheet" href="css/logl.css">
 <script type="text/javascript" src="/TCES1/jquery-easyui-1.5.3/jquery.min.js"></script>
<script type="text/javascript">
function loginCheck(){
	var username = document.getElementById("username");
	var password = document.getElementById("password");
	if(username.value==""&& password.value==""){
			alert("密码和用户名不能为空");
			return false;
		}
	if(username.value==""){
			alert("用户名不能为空");
			return false;
		}
	if(password.value==""){
			alert("密码不能为空");
			return false;
		}
	return true;
}
</script>
</head>
<body>
<div class="hei"></div>
<d--iv class="lunbo"><ul class="lunbo_ul">
    <li class="lunbo_li"><img src="images/timg.jpg" height="950px" width="1900px"/></li>
    <li class="lunbo_li"><img src="images/timg (1).jpg"height="950px" width="1900px"/></li>
    <li class="lunbo_li"><img src="images/timg (2).jpg" height="950px" width="1900px"/></li>
    <li class="lunbo_li"><img src="images/timg (3).jpg" height="950px" width="1900px"/></li></ul></d--iv>
<div class="denglu">
    <div class="denglu_1"><b>教师评教系统</b></div>
    <div class="denglu_2">Teachers Comprehensive Evaluation System</div>
    <form action="/TCES1/login" method="post">
    <div style="margin-top: 50px;margin-left: 150px"><input style="width: 500px;height: 30px;font-size: 24px;font-family: 方正舒体;" type="text" name="username" placeholder="学号/工号"></div>
    <div style="margin-top: 50px;margin-left: 150px"><input style="width: 500px;height: 30px;font-size: 24px;font-family: 方正舒体;" type="password" name="password" placeholder="密码"></div>
    <input type="checkbox" style="margin-left: 150px;">记住密码<input style="margin-top: 14px;"type="submit" value="登  录"class="denglu_3" onclick="return loginCheck()"  /><button  style="margin-left: 100px;">重置密码</button>
    </form>
</div>
</body>
<script>
    var num=0;
    $(".lunbo_li").hide();
    $(".lunbo_li").eq(num%4).fadeIn(3000);
    function lun() {
        $(".lunbo_li").eq(num%4).fadeOut(1000);
        num++;
        $(".lunbo_li").eq(num%4).fadeIn(3000);
    }
    setInterval(lun,4000);
</script>
</body>
</html>
