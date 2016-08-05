$(function() {
	$("#inputPassword2")
			.blur(
					function() {

						var psw2 = $("#inputPassword2").val();
						var psw = $("#inputPassword").val();
						// 判断email是否为空
						if (psw2 == null || psw2 == "") {
							$("#password_correct_again").html("");
							$("#password_error_again")
									.html(
											"<i class=\"glyphicon glyphicon-remove-circle\"></i>确认密码不能为空");
						} else {

							if (psw != psw2) {
								$("#password_correct_again").html("");
								$("#password_error_again")
										.html(
												"<i class=\"glyphicon glyphicon-remove-circle\"></i>确认密码错误");
								return false;
							} else {
								$("#password_error_again").html("");
								$("#password_correct_again")
										.html(
												"<i class=\"glyphicon glyphicon glyphicon-ok-circle\"></i> ");
							}

						}

					});
});