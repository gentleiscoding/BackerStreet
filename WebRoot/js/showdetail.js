$(function() {
	var reg = new RegExp("(^|&)" + "date" + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	var date = unescape(r[2]);
	$.ajax({
		type : 'POST',// 数据发送方式
		url : '/QA/qaser',
		data : 'state=showdetail&date=' + date,
		dataType : 'text',
		error : function(XMLHttpRequest) {
			alert('错误信息:' + XMLHttpRequest);
		},
		success : function(data) {
			$("#body").html(data);
		}
	});
});
