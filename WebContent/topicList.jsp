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
       .topic{
       		width:100%;height:50px;line-height:50px;float:left;padding-left:40px;font-size:14px;font-weight:bold;color:rgb(100,100,100);
       }
       .topic:hover{
            background-color:rgb(201,32,39);
            color:white;
       }
       .topicSelect{
            background-color:rgb(201,32,39);
            color:white;
       }
       .blogger{
       		padding:10px;
       		border-bottom:1px solid rgb(240,240,240);
       }
       .bloggerTitle{
       		font-size:18px;padding:10px 0px;
       }
       .bloggerCreateTime{
       		font-size:12px;color:rgb(220,220,220);	
       }
    </style>
    <script type="text/javascript">
    	function home(){
    		window.location.href = "/blog/HomeServlet";
    	};
    	function topicAdd(){
    		window.location.href = "/blog/TopicToAddServlet";
    	};
    	
       	function topicUpdate(id){
    		window.location.href = "/blog/TopicToUpdateServlet?id="+id;
    	};

    	function topicDelete(id){
    		window.location.href = "/blog/TopicToDeleteServlet?id="+id;
    	};
    </script>
  </head>
<body background="images/2.jpg">
    
    
    
    <div class="container" style="width:1200px;">
	    <div class="row" style="height:50px;background-color:rgb(250,250,250);margin-top:5px;">
		      <div class="col-md-12">
		      <button type="button" onclick="topicAdd()" class="btn btn-info" style="float:right;margin:10px 0px;">添加主题</button>
		      <button type="button" onclick="home()" class="btn btn-info" style="float:right;margin:10px;">返回首页</button>
				
		      
		      </div>
	      </div>
    </div>
    
    <div class="container" style="width:1200px;">
	   <div class="row">
	      <div class="col-md-12" style="background-color:rgb(250,250,250);margin-top:5px;padding:20px;">
	      	
				
			 <table class="table table-bordered" style="padding:0px;">
				<tr>
				<td>名称</td>
				<td>排序</td>
				<td>是否禁用</td>
				<td>操作</td>
				</tr>
				
				<c:forEach var="topic" items="${topicList}">
				
			    <tr>
				<td>${topic.name }</td>
				<td>${topic.indexed }</td>
				<td>${topic.deletedStr }</td>
				<td><button type="button" onclick="topicUpdate(${topic.id })" class="btn btn-info">修改</button>
				<button type="button" onclick="topicDelete(${topic.id })" class="btn btn-info">删除</button></td>
				</tr>
					
				</c:forEach>
			 </table>
				      	
	      </div>
         
	   </div>
	</div>

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>

  </body>
</html>