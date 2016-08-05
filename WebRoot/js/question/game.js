function entergame(type) {

	$.ajax({
		type : 'POST',// 数据发送方式
		url : '/QA/qaser',// 后台处理程序的页面路径
		data : 'state=entergame&type=' + type,
		dataType : 'text',// 返回的数据格式
		error : function(XMLHttpRequest) {
			alert('出错l ,错误信息:' + XMLHttpRequest);
		},
		success : function(data) {
			if (data == "请先登陆") {
				alert(data);
			} else {
				$("#douzailimian").html(data);
			}
		}

	});
}

// 点击选项a
$("#optiona")
		.click(
				function() {

					var optiona = document.getElementById("optiona");
					var optionb = document.getElementById("optionb");
					var optionc = document.getElementById("optionc");
					var optiond = document.getElementById("optiond");
					var useroption = optiona.innerText;
					$
							.ajax({
								type : 'POST',// 数据发送方式
								url : '/QA/qaser',// 后台处理程序的页面路径
								data : 'state=judgequestion&useroption='
										+ useroption,
								dataType : 'text',// 返回的数据格式
								error : function(XMLHttpRequest) {
									alert('出错l ,错误信息:' + XMLHttpRequest);
								},
								success : function(data) {

									if (data == "right") {
										optiona.style.cssText = "color: #333; background-color: #47c111;";
										return false;
									}
									if (data == "userAcorrectB") {
										optionb.style.cssText = "color: #333; background-color: #47c111;";
										optiona.style.cssText = "color: #333; background-color: #db0000;";
									}
									if (data == "userAcorrectC") {
										optionc.style.cssText = "color: #333; background-color: #47c111;";
										optiona.style.cssText = "color: #333; background-color: #db0000;";
									}
									if (data == "userAcorrectD") {
										optiond.style.cssText = "color: #333; background-color: #47c111;";
										optiona.style.cssText = "color: #333; background-color: #db0000;";
									}
								}

							});
				});

// 点击选项b
$("#optionb")
		.click(
				function() {

					var optiona = document.getElementById("optiona");
					var optionb = document.getElementById("optionb");
					var optionc = document.getElementById("optionc");
					var optiond = document.getElementById("optiond");
					var useroption = optionb.innerText;
					$
							.ajax({
								type : 'POST',// 数据发送方式
								url : '/QA/qaser',// 后台处理程序的页面路径
								data : 'state=judgequestion&useroption='
										+ useroption,
								dataType : 'text',// 返回的数据格式
								error : function(XMLHttpRequest) {
									alert('出错l ,错误信息:' + XMLHttpRequest);
								},
								success : function(data) {

									if (data == "right") {
										optionb.style.cssText = "color: #333; background-color: #47c111;";
										return false;
									}
									if (data == "userBcorrectA") {
										optiona.style.cssText = "color: #333; background-color: #47c111;";
										optionb.style.cssText = "color: #333; background-color: #db0000;";
									}
									if (data == "userBcorrectC") {
										optionc.style.cssText = "color: #333; background-color: #47c111;";
										optionb.style.cssText = "color: #333; background-color: #db0000;";
									}
									if (data == "userBcorrectD") {
										optiond.style.cssText = "color: #333; background-color: #47c111;";
										optionb.style.cssText = "color: #333; background-color: #db0000;";
									}
								}

							});
				});

// 点击选项c
$("#optionc")
		.click(
				function() {

					var optiona = document.getElementById("optiona");
					var optionb = document.getElementById("optionb");
					var optionc = document.getElementById("optionc");
					var optiond = document.getElementById("optiond");
					var useroption = optionc.innerText;
					$
							.ajax({
								type : 'POST',// 数据发送方式
								url : '/QA/qaser',// 后台处理程序的页面路径
								data : 'state=judgequestion&useroption='
										+ useroption,
								dataType : 'text',// 返回的数据格式
								error : function(XMLHttpRequest) {
									alert('出错l ,错误信息:' + XMLHttpRequest);
								},
								success : function(data) {

									if (data == "right") {
										optionc.style.cssText = "color: #333; background-color: #47c111;";
										return false;
									}
									if (data == "userCcorrectA") {
										optiona.style.cssText = "color: #333; background-color: #47c111;";
										optionc.style.cssText = "color: #333; background-color: #db0000;";
									}
									if (data == "userCcorrectB") {
										optionb.style.cssText = "color: #333; background-color: #47c111;";
										optionc.style.cssText = "color: #333; background-color: #db0000;";
									}
									if (data == "userCcorrectD") {
										optiond.style.cssText = "color: #333; background-color: #47c111;";
										optionc.style.cssText = "color: #333; background-color: #db0000;";
									}
								}

							});
				});

// 点击选项d
$("#optiond")
		.click(
				function() {
					var optiona = document.getElementById("optiona");
					var optionb = document.getElementById("optionb");
					var optionc = document.getElementById("optionc");
					var optiond = document.getElementById("optiond");
					var useroption = optiond.innerText;
					$
							.ajax({
								type : 'POST',// 数据发送方式
								url : '/QA/qaser',// 后台处理程序的页面路径
								data : 'state=judgequestion&useroption='
										+ useroption,
								dataType : 'text',// 返回的数据格式
								error : function(XMLHttpRequest) {
									alert('出错l ,错误信息:' + XMLHttpRequest);
								},
								success : function(data) {

									if (data == "right") {
										optiond.style.cssText = "color: #333; background-color: #47c111;";
										return false;
									}
									if (data == "userDcorrectA") {
										optiona.style.cssText = "color: #333; background-color: #47c111;";
										optiond.style.cssText = "color: #333; background-color: #db0000;";
									}
									if (data == "userDcorrectB") {
										optionb.style.cssText = "color: #333; background-color: #47c111;";
										optiond.style.cssText = "color: #333; background-color: #db0000;";
									}

									if (data == "userDcorrectC") {
										optionc.style.cssText = "color: #333; background-color: #47c111;";
										optiond.style.cssText = "color: #333; background-color: #db0000;";
									}

								}
							});
				});

// 进入下一题
$("#next").click(function() {

	$.ajax({
		type : 'POST',// 数据发送方式
		url : '/QA/qaser',// 后台处理程序的页面路径
		data : 'state=nextquestion',
		dataType : 'text',// 返回的数据格式
		error : function(XMLHttpRequest) {
			alert('出错l ,错误信息:' + XMLHttpRequest);
		},
		success : function(data) {
			if (data == "gameover") {
				alert("HP没了，再来一次吧~");
				history.go(0);
			} else {
				$("#container_frame").html(data);
			}
		}
	});
});