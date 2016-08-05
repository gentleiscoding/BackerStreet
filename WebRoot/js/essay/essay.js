function enteressay() {

	$.ajax({
		type : 'POST',// 数据发送方式
		url : '/QA/qaser',// 后台处理程序的页面路径
		data : 'state=enteressay',
		dataType : 'text',// 返回的数据格式
		error : function(XMLHttpRequest) {
			alert('出错l ,错误信息:' + XMLHttpRequest);
		},
		success : function(data) {
			$("#douzailimian").html(data);
		}

	});
}