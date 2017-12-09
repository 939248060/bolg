<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/utilpage/styletop.jsp"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理</title>
<link rel="stylesheet" href="${cxt }/css/Admin_Main.css">
</head>
<body>
	<%@include file="top.jsp"%>
    <div class="container">
		<div class="meun_left">
			<ul>
				<li><a href="#">用户管理</a></li>
				<li><a href="#">文章管理</a></li>
				<li><a href="#">相册管理</a></li>
			</ul>
		</div>
		<div class="meun_right">

        </div>
	</div>
    

	<%@include file="/WEB-INF/view/buttom.jsp"%>
	<%@include file="/utilpage/stylebutton.jsp"%>
</body>
</html>