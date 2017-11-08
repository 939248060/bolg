/**
 * 用户修改信息
 */
function edit(){
//	alert("修改表签被点击了");
	var job = $("#job").html();
	$("#job").html("<input type='text' name='user.job' value="+job+" />")
	var sex = $("#sex").html();
	if(sex == '男'){
		$("#sex").html("<input type='radio' name='user.sex' value='1' checked='checked' />男<input type='radio' name='user.sex' value='2'/>女")
	}else{
		$("#sex").html("<input type='radio' name='user.sex' value='1'/>男<input type='radio' name='user.sex' value='2' checked='checked'/>女")
	}
	var mail = $("#mail").html();
	$("#mail").html("<input type='text' name='user.mail' value='"+mail+"'/>")
	var tel = $("#tel").html();
//	alert(tel);
	$("#tel").html("<input type='text' name='user.tel' value="+tel+" />");
	var address = $("#address").html();
	$("#address").html("<input type='text' name='user.address' value="+address+" />")
	var motto = $("#motto").html();
	$("#motto").html("<textarea rows='5' cols='60' name='user.motto'>"+motto+"</textarea>")
//	$("#xiugai").attr({"type":"submit","value":"保存"}).removeAttr("onclick");	
	$("#xiugai").append("<button type='submit' class='btn btn-default'>保存</button>");
	$("button[onclick='edit();']").remove();	
	$("#headUrl").append("<input type='file' name='image'/>");
	$("#headUrl input[type='hidden']").remove();
}