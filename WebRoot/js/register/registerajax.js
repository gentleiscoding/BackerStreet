$(function() {
	$("#registerbutton")
			.click(
					function() {

						if ($("#pnumber").val() == 0) {

							$("#error")
									.html(
											"<i class=\"glyphicon glyphicon-remove-circle\"></i>请选择头像");
							return false;
						}
						$
								.ajax({
									type : 'POST',// 数据发送方式
									url : '/QA/qaser',// 后台处理程序的页面路径
									data : $('#registerform').serialize(),
									dataType : 'text',// 返回的数据格式
									error : function(XMLHttpRequest) {
										alert('出错l ,错误信息:' + XMLHttpRequest);
									},
									success : function(data) {

										if (data == "注册成功") {
											location
													.replace("/QA/html/index.html");
										} else {
											$("#error")
													.html(
															"<i class=\"glyphicon glyphicon-remove-circle\"></i>注册失败");
										}										
									}
								});
						alert("(●'◡'●)");
					});
});