<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/utilpage/styletop.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 样式文件 -->
<link rel="stylesheet" href="/umeditor/themes/default/css/umeditor.css">
<!-- 引用jquery -->
<script src="/umeditor/third-party/jquery.min.js"></script>
<!-- 引入 etpl -->
<script type="text/javascript" src="/umeditor/third-party/template.min.js"></script>
<!-- 配置文件 -->
<script type="text/javascript" src="/umeditor/umeditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="/umeditor/umeditor.js"></script>
<!-- 语言包文件 -->
<script type="text/javascript" src="/umeditor/lang/zh-cn/zh-cn.js"></script>
<title>后台管理页面</title>
</head>
<body>
<!-- 加载编辑器的容器 -->
<script id="container" name="content" type="text/plain" style="width:600px;height:200px;">
    这里写你的初始化内容
</script>

<script type="text/javascript">
    $(function(){
        window.um = UM.getEditor('container', {
        	/* 传入配置参数,可配参数列表看umeditor.config.js */
            toolbar: ['undo redo | bold italic underline']
        });
    });
</script>
<%@include file="/utilpage/stylebutton.jsp"%>
</body>
</html>