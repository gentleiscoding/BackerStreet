$(function() {
	$("#inputEmail")
			.blur(
					function() {
						var email = $("#inputEmail").val();
						// 判断email是否为空
						if (email == null || email == "") {
							$("#mail_correct").html("");
							$("#mail_error")
									.html(
											"<i class=\"glyphicon glyphicon-remove-circle\"></i>邮箱地址不能为空");
						} else {
							reg = /^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/gi;
							if (!reg.test(email)) {
								$("#mail_correct").html("");
								$("#mail_error")
										.html(
												"<i class=\"glyphicon glyphicon-remove-circle\"></i>邮箱格式不正确");
								return false;
							} else {
								$("#mail_error").html("");

								$("#mail_correct")
										.html(
												"<i class=\"glyphicon glyphicon glyphicon-ok-circle\"></i> ");
							}

						}

					});
});