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
    
    <link rel="stylesheet" href="./kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="./kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="./kindeditor/kindeditor-all.js"></script>
	<script charset="utf-8" src="./kindeditor/lang/zh-CN.js"></script>
	<script charset="utf-8" src="./kindeditor/plugins/code/prettify.js"></script>
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
    	function topicManage(){
    		window.location.href = "/blog/TopicListServlet";
    	};
    </script>
    		<script>
			var editor;
			KindEditor.ready(function(K) {
				editor = K.create('textarea[name="bloggerContent"]', {
					resizeType : 1,
					allowPreviewEmoticons : false,
					allowImageUpload : true,
					uploadJson : '/blog/FileUploadServlet',
					items : [
						'source','fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
						'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
						'insertunorderedlist', '|', 'emoticons', 'image', 'link']
				});
			});
		</script>
  </head>
  <body background="images/1.jpg">
    
    
    
    <div class="container" style="width:1200px;">
	    <div class="row" style="height:50px;background-color:rgb(250,250,250);margin-top:5px;">
		      <div class="col-md-12">
		      
		     
		      <button type="button" onclick="home()" class="btn btn-info" style="float:right;margin:10px;">返回首页</button>
	
		      
		      </div>
	      </div>
    </div>
    
    <div class="container" style="width:1200px;">
	   <div class="row">
	      <div class="col-md-12" style="background-color:rgb(250,250,250);margin-top:5px;padding:20px;">
	      	
				
			 <form class="form-horizontal" action="/blog/BloggerUpdateServlet" method="post">
			  
			  <input type="hidden" name="searchType" value="${searchType}">
			  <input type="hidden" name="searchPage" value="${searchPage}">
			  <input type="hidden" name="oldTopicId" value="${topicId}">
			  <input type="hidden" name="id" value="${blogger.id}">
			  <div class="form-group">
			    <label class="col-sm-2 control-label">博文标题</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" name="bloggerTitle" value="${blogger.bloggerTitle }">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">博文主题</label>
			    <div class="col-sm-2">
			      <select name="topicId" class="form-control">

						<c:forEach var="topic" items="${topicList}">			
							<option value ="${topic.id }"
							
							<c:if test="${topic.id == blogger.topicId }">
							selected = "selected" 
							</c:if>
							
							>${topic.name }</option>	
						</c:forEach>
					 
					</select>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">博客内容</label>
			    <div class="col-sm-10">
			     <textarea name="bloggerContent" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;">
			     ${blogger.bloggerContent }
			     </textarea>
			    </div>
			  </div>

			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-info">提交</button>
			    </div>
			  </div>
			</form>
				      	
	      </div>
         
	   </div>
	</div>

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>

  </body>
</html>