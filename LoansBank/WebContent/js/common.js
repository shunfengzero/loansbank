
//针对所有ajax请求的设置
//两个参数 第一个是XMlHttpRequest对象,
//第二个参数 textStatus 响应状态的文本表示
$.ajaxSetup({
	complete : function(xhr, textStatus) {
		//从http头信息取出 在filter定义的sessionstatus,判断是否是timeout
		if (xhr.getResponseHeader("sessionstatus")=="timeout") {
			//从http头信息取出登录的url = loginPath
			if (xhr.getResponseHeader("loginPath")) {
				//alert("会话过期，请重新登录!");
				//回到登录页面
				window.location.replace(xhr.getResponseHeader("loginPath"));
			}
			
		}
		
	}
	
});

//用户注销函数
function logout(){
	$.ajax({
		type:"post",
		url:"logout",
		dataType:"json",
		success:function(data){
			if (data.code == 1) {
				alert("退出成功！");
				window.location.href = "login.jsp";
			} else {
				alert("请先登录！");
			}
		}
	});
}




