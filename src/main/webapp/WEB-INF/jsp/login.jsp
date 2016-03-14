<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>登陆</title>

<link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">

<link href="resources/css/login.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script src="resources/js/login.js"></script>
<script src="resources/js/bootstrap.js"></script>
<script src="resources/js/tip.js"></script>

</head>

<body>
	<div class="container">
		<div class="row" style="margin: 100px 0px">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div class="form-signin">
					<h2 class="form-signin-heading" style="text-align: center">登陆</h2>
					<input type="email" id="inputEmail" class="form-control"
						placeholder="邮箱账号" required autofocus> <input
						type="password" id="inputPassword" class="form-control"
						placeholder="密码" required>
					<div class="row">
						<div class="col-md-8">
							<input type="text" id="inputVerifyCode" class="form-control"
								placeholder="输入验证码" required>
						</div>
						<div class="col-md-4">
							<img id="img" class="form-control"
								onclick="javascript:refresh(this);" src="VerifyCodeServlet"
								data-toggle="popover">
						</div>
					</div>
					<button id="btnLogin" class="btn btn-lg btn-primary btn-block"
						type="button" onclick="login()">登陆</button>
				</div>

			</div>
			<div class="col-md-4" style="margin-top: 200px">
				<strong id="tip"></strong>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function refresh(obj) {
			obj.src = "VerifyCodeServlet?" + Math.random();
		}
	</script>
</body>
</html>