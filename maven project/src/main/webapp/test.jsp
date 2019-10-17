<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="jquery-easyui-1.5.3/jquery.min.js"></script>
<script type="text/javascript">
        $(function () {
            var parentNode = {
                id : "",
                weight :"",
                levelWeight:"",
                parentId : 1
            };

            $("#btnStudent").click(function () {
                parentNode.id = "2";
                parentNode.weight = 0.3;
                parentNode.levelWeight = 0.3;
                getQuestionnaire(parentNode)
            })
            
            $("#btnTeacher").click(function () {
                alert("aaaa");
                parentNode.id = "3";
                parentNode.weight = 0.7;
                parentNode.levelWeight = 0.7;
                getQuestionnaire(parentNode)
            })

            function getQuestionnaire(parentNode) {
                $.ajax({
                    url:"/TCES1/CreateQuestionnaire",
                    method:"POST",
                    data:parentNode,
                    success:function (data) {
                        console.log(data)
                    }
                })
            }
        })
    </script>
</head>
<body>
    <input type="button" value="生成学生问卷" id="btnStudent" />
    <input type="button" value="生成教师问卷" id="btnTeacher"/>
</body>
</html>