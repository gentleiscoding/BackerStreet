$(function() {
	$("#inputusername")
			.blur(
					function() {
						var username = $("#inputusername").val();
						// 判断用户名是否为空
						if (username == null || username == "") {
							$("#username_correct").html("");
							$("#username_error")
									.html(
											"<i class=\"glyphicon glyphicon-remove-circle\"></i> 用户名不能为空");
						} else {
							// 判断用户名长度
							if (username.length > 15 || username.length < 6) {
								$("#username_correct").html("");
								$("#username_error")
										.html(
												"<i class=\"glyphicon glyphicon-remove-circle\"></i> 用户名长度应小于15字符，大于6字符");
							} else {
								// 判断用户名是否重复
								$
										.ajax({
											type : 'POST',// 数据发送方式
											url : '/QA/qaser',
											data : 'username=' + username
													+ '&state=usernamejudge',
											dataType : 'text',// 返回的数据格式
											error : function(XMLHttpRequest) {
												alert('出错l ,错误信息:'
														+ XMLHttpRequest);
											},
											success : function(data) {
												if (data == "该用户名已被注册") {
													$("#username_correct")
															.html("");
													$("#username_error")
															.html(
																	"<i class=\"glyphicon glyphicon-remove-circle\"></i> 该用户名已被注册");

												} else {
													$("#username_error").html(
															"");
													$("#username_correct")
															.html(
																	"<i class=\"glyphicon glyphicon glyphicon-ok-circle\"></i> ");
												}
											}
										});

							}
						}

					});
});