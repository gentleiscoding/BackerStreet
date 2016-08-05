$(function() {
	$("#inputPassword")
			.blur(
					function() {
						var psw = $("#inputPassword").val();
						// 判断email是否为空
						if (psw == null || psw == "") {
							$("#password_correct").html("");
							$("#password_error")
									.html(
											"<i class=\"glyphicon glyphicon-remove-circle\"></i>密码不能为空");
						} else {
							if (psw.length > 15 || psw.length < 6) {
								$("#password_correct").html("");
								$("#password_error")
										.html(
												"<i class=\"glyphicon glyphicon-remove-circle\"></i>密码长度应小于15字符，大于6字符");
								return false;
							} else {
								$("#password_error").html("");
								$("#password_correct")
										.html(
												"<i class=\"glyphicon glyphicon glyphicon-ok-circle\"></i> ");
							}

						}

					});
});