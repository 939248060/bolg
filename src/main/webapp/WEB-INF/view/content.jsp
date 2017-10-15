<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/utilpage/styletop.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="gb2312">
<title>花开花落</title>
<meta name="keywords" content="个人博客模板,博客模板,响应式" />
<meta name="description" content="如影随形主题的个人博客模板，神秘、俏皮。" />
<link href="/css/main.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
</head>
<body>
    <div class="container content">
	<h2><span class="label label-default">最新文章</span></h2>
	<hr style="height: 5px;"/>
	<c:forEach items="${articleList }" var="a">
	<h3><a href="#">${a.tilie }</a></h3>
	<p>${a.content }</p>
	<hr style="height: 5px;"/>
	</c:forEach>
	</div>
    <%@include file="/utilpage/stylebutton.jsp"%>
</body>
</html>