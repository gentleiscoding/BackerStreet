//判断注册
$(function() {
	$.ajax({
		type : 'POST',// 数据发送方式
		url : '/QA/qaser',
		data : 'state=judgelogin',
		dataType : 'text',
		error : function(XMLHttpRequest) {
			alert('错误信息:' + XMLHttpRequest);
		},
		success : function(data) {
			$("#judgelogin").html(data);
		}
	});
});
// 显示公告
$(function() {
	$.ajax({
		type : 'POST',// 数据发送方式
		url : '/QA/qaser',
		data : 'state=getnotice',
		dataType : 'text',
		error : function(XMLHttpRequest) {
			alert('错误信息:' + XMLHttpRequest);
		},
		success : function(data) {
			$("#notice").html(
					"<p class=\"title\">官方通知</p><br /><p class=\"passage\">"
							+ data + "</p>");
		}
	});
});

// 显示今日科普文
$(function() {
	$.ajax({
		type : 'POST',// 数据发送方式
		url : '/QA/qaser',
		data : 'state=getessay',
		dataType : 'text',
		error : function(XMLHttpRequest) {
			alert('错误信息:' + XMLHttpRequest);
		},
		success : function(data) {
			$("#eassy").html("<div id=\"kepuwen\"><p class=\"title\">今日科普文</p><br />" + data+"<div>");
		}
	});
});