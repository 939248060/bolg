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
<!-- 样式文件 -->
<link rel="stylesheet" href="./umeditor/themes/default/css/umeditor.css">
<!-- 引用jquery -->
<script src="${cxt }/umeditor/third-party/jquery.min.js"></script>
<!-- 引入 etpl -->
<script type="text/javascript" src="${cxt }/umeditor/third-party/template.min.js"></script>
<!-- 配置文件 -->
<script type="text/javascript" src="${cxt }/umeditor/umeditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="${cxt }/umeditor/umeditor.js"></script>
<!-- 语言包文件 -->
<script type="text/javascript" src="${cxt }/umeditor/lang/zh-cn/zh-cn.js"></script>
<!-- 实例化编辑器代码 -->
</head>
<body>
    <dir class="container">
       <table cellspacing="2" >
          <tr>
            <td>标题</td>
            <td><input type="text" name="tilie"></td>
          </tr>
          <tr>
            <td>类型</td>
            <td><input type="text" name="type"></td>
          </tr>
          <tr>
            <td>内容</td>
				<td>
					<!-- 加载编辑器的容器 --> 
					<div id="content" style="width:700px;height:300px;"></div>
				</td>
			</tr>
		 <tr>
		    <td></td>
		    <td><input id="submit" type="button" value="提交">&nbsp;&nbsp;&nbsp;<input type="button" value="返回" onclick="history.back()"></td>
		 </tr>
       </table>
    </dir>
    <!-- 实例化编辑器代码 -->
<script type="text/javascript">
    $(function(){
        window.um = UM.getEditor('content', {
        	/* 传入配置参数,可配参数列表看umeditor.config.js */
            toolbar: ['undo redo | bold italic underline']
        });
        
        $("#submit").click(function(){
        	var tilie = $("input[name='tilie']").val();
        	var type = $("input[name='type']").val();
        	var content = um.getContentTxt();
        	var date = {"tilie":tilie,"type":type,"content":content};
        	$.ajax({ 
        		url: "test.html", 
        		data: date,
        		type:"post",
        		async:false,
        		success: function(result){
                alert("成功");
              },
        	   error: function(error){
        		  alert("失败");
        	   }
        	
        	});
        	
        });
    });
</script>
    <%@include file="/WEB-INF/view/buttom.jsp" %>
	<%@include file="/utilpage/stylebutton.jsp"%>
</body>
</html>