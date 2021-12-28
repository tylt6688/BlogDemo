<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<style type="text/css">
.topic {
	width: 100%;
	height: 50px;
	line-height: 50px;
	float: left;
	padding-left: 40px;
	font-size: 14px;
	font-weight: bold;
	color: rgb(100, 100, 100);
}

.topic:hover {
	background-color: rgb(201, 32, 39);
	color: white;
}

.topicSelect {
	background-color: rgb(201, 32, 39);
	color: white;
}

.blogger {
	padding: 10px;
	border-bottom: 1px solid rgb(240, 240, 240);
	position: relative;
	height: 80px;
}

.bloggerShow {
	height: 80px;
	width: 250px;
	float: left;
}

.bloggerTitle {
	font-size: 18px;
	padding: 10px 0px;
	width: 250px;
	float: left;
}

.bloggerCreateTime {
	font-size: 12px;
	color: rgb(220, 220, 220);
	width: 250px;
	float: left;
}

.bloggerOperate {
	width: 200px;
	float: right;
	margin-top: 25px;
}

.top {
	width: 100%;
	height: 50px;
	line-height: 50px;
	color: rgb(220, 220, 220);
	float: left;
	padding-left: 10px;
}
</style>
<script type="text/javascript">
    	function topicManage(){
    		window.location.href = "/blog/TopicListServlet";
    	};
      	function bloggerAdd(){
    		window.location.href = "/blog/BloggerToAddServlet";
    	};
    	function login(){
    		window.location.href = "/blog/login.jsp";
    	};
    	function index(){
    		window.location.href = "/blog/index.jsp";
    	};
       	function bloggerDelete(id){
    		window.location.href = "/blog/BloggerDeleteServlet?id="+id+"&searchType=${searchType}&searchPage=${searchPage}&topicId=${topicId}";
    	};
       	function bloggerUpdate(id){
    		window.location.href = "/blog/BloggerToUpdateServlet?id="+id+"&searchType=${searchType}&searchPage=${searchPage}&topicId=${topicId}";
    	};
     	function bloggerShow(id){
    		window.open("/blog/BloggerShowServlet?id="+id+"&searchType=${searchType}&searchPage=${searchPage}&topicId=${topicId}") ;
    	};
    </script>
</head>
<body background="images/2.jpg">



	<div class="container" style="width: 1200px;">
		<div class="row"
			style="height: 50px; background-color: rgb(255, 255, 255); margin-top: 5px;">
			<div class="col-md-12">
				<button type="button" onclick="index()" class="btn btn-info"
					style="float: left; margin: 10px;">主页</button>
				<button type="button" onclick="login()" class="btn btn-info"
					style="float: left; margin: 10px;">账户切换</button>
				<button type="button" onclick="bloggerAdd()" class="btn btn-info"
					style="float: right; margin: 10px 0px;">添加博文</button>
				<button type="button" onclick="topicManage()" class="btn btn-info"
					style="float: right; margin: 10px;">主题管理</button>

			</div>
		</div>
	</div>

	<div class="container" style="width: 1200px;">
		<div class="row">
			<div class="col-md-2"
				style="background-color: rgb(250, 250, 250); margin-top: 5px; padding: 0px;">

				<div class="top">
					<center>
						<b style="color: black">主题</b>
					</center>
				</div>

				<c:forEach var="topic" items="${topicList}">

					<c:if test="${topic.id == topicId }">
						<a href="/blog/TopicServlet?topicId=${topic.id}"><div
								class="topic topicSelect">${topic.name}</div></a>
					</c:if>
					<c:if test="${topic.id != topicId }">
						<a href="/blog/TopicServlet?topicId=${topic.id}"><div
								class="topic">${topic.name}</div></a>
					</c:if>

				</c:forEach>

			</div>
			<div class="col-md-10">

				<c:forEach var="blogger" items="${bloggerList}">

					<div class="blogger">

						<div class="bloggerShow">
							<div class="bloggerTitle">${blogger.bloggerTitle}</div>
							<div class="bloggerCreateTime" style="color: black">${blogger.createTimeStr}</div>
						</div>
						<div class="bloggerOperate">
							<button type="button" class="btn btn-danger"
								onclick="bloggerDelete(${blogger.id})">删除</button>
							<button type="button" class="btn btn-warning"
								onclick="bloggerUpdate(${blogger.id})">修改</button>
							<button type="button" class="btn btn-info"
								onclick="bloggerShow(${blogger.id})">查看</button>
						</div>
					</div>
				</c:forEach>

				<nav>
				<ul class="pager">
					<c:if test="${searchPage != 1 }">
						<li><a
							href="/blog/${searchType }?searchPage=${searchPage-1}&topicId=${topicId}">Previous</a></li>
					</c:if>
					<c:if test="${searchPage < totalPage }">
						<li><a
							href="/blog/${searchType }?searchPage=${searchPage+1}&topicId=${topicId}">Next</a></li>
					</c:if>

				</ul>
				</nav>

			</div>
		</div>
	</div>

	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script src="js/jquery.min.js"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script src="js/bootstrap.min.js"></script>

</body>
</html>