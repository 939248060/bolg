/**
 * 用户修改信息
 */
$($("#xiugai").click(function(){
//	alert("修改表签被点击了");
	var job = $("#job").html();
	$("#job").html("<input type='text' name='user.job' value="+job+" />")
	var sex = $("#sex").html();
	alert(sex);
	$("#sex").html("<input type='radio' name='user.sex' />男")
//	$("#job").html("<input type='text' name='user.job' value="+$("#job").html()+" />")
//	$("#job").html("<input type='text' name='user.job' value="+$("#job").html()+" />")
//	$("#job").html("<input type='text' name='user.job' value="+$("#job").html()+" />")
	$(this).attr({"type":"submit","value":"保存"});	
}))