<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.btn {
	left: 50%;
	position: relative;
}
</style>
<title>用户协议</title>
</head>
<body background="images/1.jpg">
	<div class="jumbotron">
		<h1>用户协议</h1>
		<p>1.用户注册成功后，博客将给予每个用户一个用户帐号及相应的密码，该用户帐号和密码由用户负责保管；用户应当对以其用户帐号进行的所有活动和事件负法律责任。</p>
		<p>2.用户须对在博客的注册信息的真实性、合法性、有效性承担全部责任，用户不得冒充他人；不得利用他人的名义发布任何信息；不得恶意使用注册帐号导致其他用户误认；否则博客有权立即停止提供服务，收回其帐号并由用户独自承担由此而产生的一切法律责任。</p>
		<p>3.用户直接或通过各类方式（如 RSS 源和站外 API
			引用等）间接使用博客服务和数据的行为，都将被视作已无条件接受本协议全部内容；若用户对本协议的任何条款存在异议，请停止使用博客所提供的全部服务。</p>
		<p>4.博客是一个信息分享、传播及获取的平台，用户通过博客发表的信息为公开的信息，其他第三方均可以通过博客获取用户发表的信息，用户对任何信息的发表即认可该信息为公开的信息，并单独对此行为承担法律责任；任何用户不愿被其他第三人获知的信息都不应该在博客上进行发表。</p>
		<p>5.用户承诺不得以任何方式利用博客直接或间接从事违反中国法律以及社会公德的行为，博客有权对违反上述承诺的内容予以删除。</p>
		<p>6.所有用户同意遵守博客社区管理规定（试行）和知乎视频服务协议（试行）。</p>
		<p>7.博客有权对用户使用博客的情况进行审查和监督，如用户在使用博客时违反任何上述规定，博客或其授权的人有权要求用户改正或直接采取一切必要的措施（包括但不限于更改或删除用户张贴的内容、暂停或终止用户使用知乎的权利）以减轻用户不当行为造成的影响。</p>

	</div>
	<p id="demo"></p>
	<p id="demo1"></p>
	<button class="btn" onclick="myFunction()" type="button"
		class="btn btn-success">同意</button>
	<script>
		function myFunction() {
			var x;
			var r = confirm("是否同意协议");
			if (r == true) {
				x = "你按下了\"确定\"按钮!";
			} else {
				x = "你按下了\"取消\"按钮!";
			}
			document.getElementById("demo").innerHTML = x;
		}
	</script>
</body>
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/jquery.touchSwipe.min.js"></script>
<script type="text/javascript"></script>

</html>
