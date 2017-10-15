<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/utilpage/styletop.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>
    <%@include file="/WEB-INF/view/top.jsp" %>
	<div class="container">
		<form class="form-horizontal" role="form" action="weixin_addUser_main" method="post" >
			<div class="form-group">
				<label for="username" class="col-sm-2 control-label">用户名</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="user.username"
						placeholder="请输入用户名">
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">密码</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" name="user.password"
						placeholder="请输入密码">
				</div>
			</div>
			<div class="form-group">
				<label for="sex" class="col-sm-2 control-label">性别</label>
				<div class="col-sm-10">
					<input type="radio" class="" name="user.sex"
						placeholder="请选择性别" value="1" checked="checked">男 <input type="radio"
						class="" name="user.sex" placeholder="请选择性别" value="2">女
				</div>
			</div>
			<div class="form-group">
				<label for="inetName" class="col-sm-2 control-label">网名</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="user.inetName"
						placeholder="请输入网名">
				</div>
			</div>
			<div class="form-group">
				<label for="address" class="col-sm-2 control-label">籍贯</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="user.address"
						placeholder="请输入籍贯">
				</div>
			</div>
			<div class="form-group">
				<label for="tel" class="col-sm-2 control-label">电话</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="user.tel"
						placeholder="请输入电话">
				</div>
			</div>
			<div class="form-group">
				<label for="mail" class="col-sm-2 control-label">邮箱</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="user.mail"
						placeholder="请输入邮箱">
				</div>
			</div>
			<div class="form-group">
				<label for="job" class="col-sm-2 control-label">职业</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="user.job"
						placeholder="请输入职业">
				</div>
			</div>
			<div class="form-group">
				<label for="motto" class="col-sm-2 control-label">座右铭</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="user.motto"
						placeholder="请输入座右铭">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">注册</button>
					<button type="reset" class="btn btn-default">重置</button>
				</div>
			</div>
		</form>
	</div>
	<%@include file="/utilpage/stylebutton.jsp"%>
</body>
</html>