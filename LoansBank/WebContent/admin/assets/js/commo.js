function adminLogout(){
	$.ajax({
		type:"post",
		url:"/LoansBank/adminlogout",
		dataType:"json",
		success:function(data){
			if (data.code == 1) {
				alert("退出成功！");
				window.location.href = "/LoansBank/admin/login.jsp";
			} else {
				alert("请先登录！");
			}
		}
	});
}