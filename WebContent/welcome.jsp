<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎注册</title>
<script type="text/javascript">
	onload = function() {
		//在进入网页的时候加载该方法 
		setTimeout(go, 3000); /*在js中是ms的单位*/
	};
	function go() {
		location.href = "http://localhost:8080/blog/home.jsp";
	}
</script>
</head>
<body background="images/3.jpg">
	<center>
		<p style="align-content: center; font-family: '微软雅黑'; font-size: 100px;color:white;">欢迎来到WeBlog!</p>
	</center>
	<center><p style="font-style: italic; margin-left: 50px;color:white;">三秒钟后跳转到文章页</p></center>
	<a style="color:white;" target="_self" href="home.jsp">网页没反应？点这里</a>

</body>
</html>