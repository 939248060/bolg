<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/utilpage/styletop.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户详细信息</title>
<script type="text/javascript" src="${cxt }/js/UserInfos.js"></script>
<meta name="keywords" content="个人博客模板,博客模板,响应式" />
<meta name="description" content="如影随形主题的个人博客模板，神秘、俏皮。" />
<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
</head>
<body>
	<%@include file="top.jsp"%>
	<div class="container">
	<form action="userAction_updateUser_UserInfos" method="post" enctype="multipart/form-data">
		<div class="col-sm-12 col-md-2" id="headUrl">
			<img alt="头像" src="${user.headUrl }"
				class="img-responsive touxiang img-rounded">
			<input type="hidden" name="user.headUrl" value="${user.headUrl }">
			<h2 style="font-size: 18px; text-align: center; width: 100%;">${user.inetName }</h2>
		</div>
		<div class="col-sm-12 col-md-10">
			<input type="hidden" name="user.id" value="${user.id }"/>
			<table class="table table-striped table-responsive">
				<tr>
					<td>用户名</td>
					<td>${user.username }</td>
				</tr>
				<tr>
					<td>职业</td>
					<td id="job">${user.job }</td>
				</tr>
				<tr>
					<td>性别</td>
					<td id="sex">${user.sex == 1?'男':'女' }</td>
				</tr>
				<tr>
					<td>邮箱</td>
					<td  id="mail">${user.mail }</td>
				</tr>
				<tr>
					<td>用户类型</td>
					<td>${user.jurisdiction == 0? '普通用户':'管理员' }</td>
				</tr>
				<tr>
					<td>积分</td>
					<td>${user.integral }</td>
				</tr>
				<tr>
					<td>电话</td>
					<td id="tel">${user.tel }</td>
				</tr>
				<tr>
					<td>地址</td>
					<td id="address">${user.address }</td>
				</tr>
				<tr>
					<td>座右铭</td>
					<td id="motto">${user.motto }</td>
				</tr>
			</table>
			<div style="width: 200px; margin: 10px auto;" class="center-block" id="xiugai">
				<button type="button" onclick="history.back()"
					class="btn btn-default" value="">返回</button> 
					<button type="button" class="btn btn-default" value="" onclick="edit();">修改</button>
			</div>
			
		</div>
		</form>
	</div>
	<%@include file="/WEB-INF/view/buttom.jsp"%>
	<%@include file="/utilpage/stylebutton.jsp"%>
</body>
</html>