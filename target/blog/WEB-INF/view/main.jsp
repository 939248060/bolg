<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/utilpage/styletop.jsp"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>花开花落</title>
<meta name="keywords" content="个人博客模板,博客模板,响应式" />
<meta name="description" content="如影随形主题的个人博客模板，神秘、俏皮。" />
<link href="${cxt }/css/main.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
</head>
<body>
    <%@include file="top.jsp"%>
    <c:if test="${!empty user }">
	<div class="container userInfo">
	   <div class="col-sm-12 col-md-2">
	     <img class="img-responsive touxiang img-rounded" alt="头像" src="${user.headUrl }" height="200"/>
	   </div>
	   <div class="col-sm-12 col-md-10">
	      <ul>
	         <li><label>网名：</label>${user.inetName }</li>
	         <li><label>职业：</label>${user.job }</li>
	         <li><label>邮箱：</label>${user.mail }</li>
	         <li><label>电话：</label>${user.tel }</li>
	         <li><label>座右铭：</label>${user.motto }</li>
	      </ul>
	   </div>
	</div>
	</c:if>
	<div class="">
	   <iframe width="100%" height="100%" frameborder=0 scrolling="no"
							src="articleAction_selectArticle_content"></iframe>
	</div>
	<%@include file="/WEB-INF/view/buttom.jsp" %>
	<%@include file="/utilpage/stylebutton.jsp"%>
</body>
</html>
