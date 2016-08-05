$(function() {
	$("#loginsubmit").click(function() {
		$('#loginform').ajaxSubmit({
			type : 'POST',// 数据发送方式
			url : '/QA/qaser',// 后台处理程序的页面路径
			data : $('#loginform').serialize(),
			dataType : 'text',// 返回的数据格式
			error : function(XMLHttpRequest) {
				alert('出错l ,错误信息:' + XMLHttpRequest);
			},
			success : function(data) {
				if (data == "登陆成功") {
					location.replace("/QA/html/index.html");
				} else if (data == "账号或密码错误") {
					$("#error").html("<i class=\"glyphicon glyphicon-remove-circle\"></i> 密码错误");
				} else if (data == "该用户名不存在") {
					$("#error").html("<i class=\"glyphicon glyphicon-remove-circle\"></i> 该用户名不存在");
				} else if(data=="请不要输入非法字符"){
					$("#error").html("<i class=\"glyphicon glyphicon-remove-circle\"></i> 请不要输入非法字符");
					
				}
			}

		});
	});
});