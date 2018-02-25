/*
 * 针对ajax的设置,对所有ajax都生效
 * 参数：xhr : XMLHttpRequest的对象
 * 	   testStatus 响应状态的文本表示
 */
$.ajaxSetup({
		complete:function(xhr, textStatus){
			 //从http头信息取出 在filter定义的sessionstatus，判断是否是 timeout
			if (xhr.getResponseHeader("sessionStatus") == "timeout") {
				//从http头信息取出登录的url ＝ loginPath
				if (xhr.getResponseHeader("loginPath")) {
					window.location.replace(xhr.getResponseHeader("loginPath"));
				}
			}
		}
});