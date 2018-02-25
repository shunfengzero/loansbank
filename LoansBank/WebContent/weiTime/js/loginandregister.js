/**
 * 登录注册JS函数
 */
 $(function(){
	 isLogin();
	 indexRegister();
	 indexLogin();
	 
	 
	$("#regForm").validate({
		submitHandler : function(){
			
			$.ajax({
				type:"post",
				url:"register.action",
				data:$("#regForm").serialize(),
				dataType:"json",
				success:function(data){
					if (data.code == 0) {
						alert(data.msg);
					} else {
						
						alert("注册成功");	
						
						$("#nav_mask_libao").css({display:"block"});
					}
				}
			});
		},
		
		rules:{
			userName:"required",
			passWord:{
				required:true,
				minlength:4
			},
			rePassWord:{
				required:true,
				minlength:4,
				equalTo:"#passWord"
			},
			telePhone:{
				required:true,
				number:true,
				minlength:11,
				maxlength:11
			},
			email:{
				required:true,
				email:true
			}		
	},
	messages:{
		userName:"请输入用户名",
		passWord:{
			required:"请输入密码",
			minlength:"密码不能小于四个字符"
		},
		rePassWord:{
			required:"请输入密码",
			minlength:"密码不能小于四个字符",
			equalTo:"两次密码输入不一致"
		},
		telePhone:{
			required:"请输入电话号码",
			number:"请输入合法的电话号码",
			minlength:"输入号码不正确",
			maxlength:"输入号码不正确",
		},
		email:"请输入一个正确的邮箱"
	}
		
		
	});
});
 

//判断用户是否是登录状态
 function isLogin() {
	 $.ajax({
			type:"post",
			url:"isLogin", //请求的资源是logAction
			dataType:"json",
			success:function(data) {
				//如果用户已经登录
				if (data.code == 1) {
					$(".nav-right").empty();
					var html = "";
					html += "<span><a href='#' class='nav_login_app'>APP</a></span>";
					html += "<a href='#' onclick='logout()' class='nav_login'>注销</a>";
					html += "<a href='#' onclick='clickRegister()' class='nav_enroll'>注册</a>";
					$(".nav-right").append($(html));
				} else {
					$(".nav-right").empty();
					var html = "";
					html += "<span><a href='#' class='nav_login_app'>APP</a></span>";
					html += "<a href='#' onclick='clickLogin()' class='nav_login'>登录</a>";
					html += "<a href='#' onclick='clickRegister()' class='nav_enroll'>注册</a>";
					$(".nav-right").append($(html));
				}
			}
		});
	 
 }
 
//登录函数
function login() {
	$.ajax({
		type:"post",
		url:"ulogin", //请求的资源是logAction
		data:$("#loginForm").serialize(),
		dataType:"json",
		success:function(data) {
			if (data.code == 0) {
				alert(data.msg);
			} else {
				
				//登录成功跳转到首页
				window.location.href = "/LoansBank/weiTime/html/index.jsp";
			}
		}
	});
}

//注销函数
function logout() {
	$.ajax({
		type:"post",
		url:"logout", //请求的资源是logAction
		dataType:"json",
		success:function(data) {
			if (data.code == 0) {
				alert(data.msg);
			} else {
				window.location.href = "/LoansBank/weiTime/html/longin.jsp";
			}
		}
	});
}


//动态生成登录弹窗
function indexLogin() {
	$("#nav_mask_login").empty();
	var html = "";
	html += "<form id='loginForm' onsubmit='return false;'>";
	
	html += "<img src='../img/enroll_close.png' class='enroll_close' />";
	html += "<p class='nav_mask_login'><span>账号</span><input type='text' name='userName' /></p>";
	html += "<p><span>密码</span><input type='password' name='passWord'/></p>";
	html += "<p class='nav_mask_login_pw'><a href='#' class='nav_mask_login_pw_tel'>手机登录</a><a href='#' class='nav_mask_login_pw_pw'>忘记密码</a></p>";
	//<!-- <button class="nav_mask_login_button" onclick="login()">登录</button> -->
	html += "<input  type='submit' value='登录' class='nav_mask_login_button' onclick='login()'>";
	html += "</form>";
	
    $("#nav_mask_login").append($(html));
    
    //login
	$(".enroll_close").click(function(){
		$("#nav_mask_login").css({display:"none"});
	});
}

//点击登录，执行的函数
function clickLogin() {
	$("#nav_mask_login").css({display:"block"});
	$("#nav_mask").css({display:"none"});
}

//动态生成注册弹窗
function indexRegister() {
	$("#nav_mask").empty();
	
	var html = "";
	html += "<form id='regForm'>";
	html += "<h2>注册</h2>";
	html += "<img src='../img/enroll_close.png' class='enroll_close' />";
	html += "<h3>欢迎注册，如果您已有账户，可在此<span class='enroll_login'>登录</span></h3>";
	html += "<p><span>用户名：</span><input id='userName' type='text' name='userName'>*</p>";
	html += "<p><span>登录密码：</span><input id='passWord' type='password' name='passWord'>*</p>";
	html += "<p><span>确认密码：</span><input id='rePassWord' type='password' name='rePassWord'>*</p>";
	html += "<p><span>手机号码：</span><input id='telePhone' type='text' name='telePhone'>*</p>";
	html += "<p><span>电子邮箱：</span><input id='email' type='text' name='email'>*</p>";
	html += "<p><span>验证码：</span><input type='text' class='nav_enroll_p6'><img src='' />*</p>";
	html += "<input type='submit' value='同意以下协议并注册' class='nav_xieyi'>";
	html += "<a href='#'>《微时贷服务协议》</a>";
	html += "</form>";
	$("#nav_mask").append($(html));
	
	$(".enroll_login").click(function(){
		$("#nav_mask_login").css({display:"block"});
	});
	$(".enroll_close").click(function(){
		$("#nav_mask").css({display:"none"});
	});
	
	//dlb
	$(".enroll_close").click(function(){
		$("#nav_mask_libao").css({display:"none"});
	});
}
//点击注册执行的函数
function clickRegister() {
	//alert("注册");
	//存在的bug是center.html页面可以进来这个函数，但是注册弹框不会出现
	$("#nav_mask").css({display:"block"});
	$("#nav_mask_login").css({display:"none"});
}










