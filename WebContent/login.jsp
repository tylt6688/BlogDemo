<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>博客登陆页面</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript">
function index(){
	window.location.href = "/blog/index.jsp";
};
</script>
</head>
<body>
<button type="button" onclick="index()" class="btn btn-info"
					style="float: right; margin: 10px;">返回首页</button>
	<div class="container" style="width: 1200px;">
		<div class="row">
			<div class="col-md-7">
				<img src="images/login.jpg" class="img-rounded" style="width: 80%; display: block; margin: 100px auto;" />
			</div>
			<div class="col-md-5" style="margin-top: 50px; background-color: rgb(240, 240, 240); padding: 100px 20px;">
				<div style="font-size: 18px; font-family: Microsoft Yahei; font-weight: bold;">用户登陆：</div>
				<form style="margin-top: 30px;" method="post" action="/blog/LoginServlet">
					<div class="form-group">
						<label>账号:</label>
						<input type="text" name="userName" class="form-control">
					</div>
					<div class="form-group">
						<label>密码:</label> <input type="password" name="password" class="form-control">
						<br>
						<div class="form-group">
							<label style="color: black">验证码:</label> 
							<input type="text" name="image"> 
							<img id="change" src="/blog/VerifyCodeServlet" /> 
							<input type="button" value="看不清? 换一张." id="btn" ><br>
							<font color="red">${requestScope.imageMess}</font>
						</div>
					</div>
					<div class="form-group" style="color: red;">${error}</div>
					<center>
						<button type="submit" class="btn btn-info">登陆</button>
					</center>
				</form>
				<p>没有账户？</p>
				<center>
					<a href="register.jsp">注册</a>
				</center>
			</div>
		</div>
	</div>
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script src="js/jquery.min.js"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script src="js/bootstrap.min.js"></script>
	
<script type="text/javascript">
	document.getElementById("btn").onclick = function() {
	// 获取img元素为了让浏览器发送请求到servlet, 所以一定要改变src
	document.getElementsByTagName("img")[1].src = "/blog/VerifyCodeServlet?time="
			+ new Date().getTime();
};
</script>
</body>

</html>