<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/utilpage/styletop.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="gb2312">
<title></title>
<meta name="keywords" content="个人博客模板,博客模板,响应式" />
<meta name="description" content="如影随形主题的个人博客模板，神秘、俏皮。" />
<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
</head>
<body>
	<div class="container">
		<nav class="navbar navsbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="weixin_selectUser_main">花开花落博客 </a>
			</div>
			<ul class="nav navbar-nav navbar-right">
			<c:if test="${empty sessionScope.user}">
				<li><a href="register.jsp"><span
						class="glyphicon glyphicon-user"></span> 注册</a></li>
				<li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span>
						登录</a></li>
			</c:if>
			<c:if test="${!empty sessionScope.user}">
				<li><a href="register.jsp"><span
						class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;&nbsp;欢迎&nbsp;${sessionScope.user.username }&nbsp;回来</a></li>
				<li><a href="weixin_outloginUser_main"><span class="glyphicon glyphicon-log-in"></span>
						推出登录</a></li>
			</c:if>
			</ul>
		</div>
		</nav>
	</div>
	<%@include file="/utilpage/stylebutton.jsp"%>
</body>
</html>
