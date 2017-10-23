/**
 * 用户修改信息
 */
$($("#xiugai").click(function(){
//	alert("修改表签被点击了");
	var job = $("#job").html();
	$("#job").html("<input type='text' name='user.job' value="+job+" />")
	var sex = $("#sex").html();
	alert(sex);
	if(sex == '男'){
		$("#sex").html("<input type='radio' name='user.sex' value='1' checked='checked' />男<input type='radio' name='user.sex' value='2'/>女")
	}else{
		$("#sex").html("<input type='radio' name='user.sex' value='1'/>男<input type='radio' name='user.sex' value='2' checked='checked'/>女")
	}
//	$("#sex").html("<input type='radio' name='user.sex' value='1'/>男<input type='radio' name='user.sex' value='2'/>女")
//	$("#job").html("<input type='text' name='user.job' value="+$("#job").html()+" />")
//	$("#job").html("<input type='text' name='user.job' value="+$("#job").html()+" />")
//	$("#job").html("<input type='text' name='user.job' value="+$("#job").html()+" />")
	$(this).attr({"type":"submit","value":"保存","id":" "});	
}))