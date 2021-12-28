<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>注册</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap.main.css" rel="stylesheet">

</head>
<body background="images/1.jpg">

	<div align="center">
		<!---提交页面--->
		<div class="col-md-5"style="margin-top: 50px; margin-left: 500px; background-color: rgb(250, 250, 250); padding: 100px 20px;">
			<h1>注册</h1>
			<form  style="margin-top: 30px;" method="post" action="/blog/RegisterServlet">								   
			  <div class="form-group">
			    <label>账号:</label>
			    <input type="text" name="UserName" class="form-control">
			  </div>
			  <div class="form-group">
			    <label>密码:</label>
			    <input type="password" name="Password" class="form-control">
			  </div>
			 <a href="http://localhost:8080/blog/agreement.jsp">《点击查看本站协议》</a><br><br><hr>
				<button type="submit" class="btn btn-success btn-lg">提交</button>			
				</form>
          </div>
	   </div>

	
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script src="js/jquery.min.js"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script src="js/bootstrap.min.js"></script>
</body>

</html>