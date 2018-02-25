
$(function(){
	
	//-------------------------enroll
	$(".nav_enroll").click(function(){
		$("#nav_mask").css({display:"block"});
		$("#nav_mask_login").css({display:"none"});
		$("#nav_mask_app").css({display:"none"});
	});
	$(".enroll_login").click(function(){
		$("#nav_mask_login").css({display:"block"});
	});
	$(".enroll_close").click(function(){
		$("#nav_mask").css({display:"none"});
	});
	
	//------------------------login
	$(".enroll_close").click(function(){
		$("#nav_mask_login").css({display:"none"});
	});
	$(".nav_login").click(function(){
		$("#nav_mask_login").css({display:"block"});
		$("#nav_mask").css({display:"none"});
		$("#nav_mask_app").css({display:"none"});
	});
	
	//-------------------礼包
	$(".enroll_close").click(function(){
		$("#nav_mask_libao").css({display:"none"});
	});
	//-------------------获得礼包
	$(".nav_libao_btn").click(function(){
		$("#nav_mask_huode").css({display:"block"});
	})
	
	
	
	//计算器加法
	var numPlus = 10000;
	var jiekuan_s2_money_1_left_i1_width =  138;
	var jiekuan_s2_money_1_left_i2_width = 60;
	
	//--------------------50000
	$(".jiekuan_s2_money_1_left_plus1").click(function(){	
		jiekuan_s2_money_1_left_i1_width += 10;
		$(".jiekuan_s2_money_1_left_50000").text(Number($(".jiekuan_s2_money_1_left_50000").text())+numPlus);
		$("#loanMoney").text($(".jiekuan_s2_money_1_left_50000").text());
		$(".jiekuan_s2_money_1_left_i1").css({width:jiekuan_s2_money_1_left_i1_width});
		$(".jiekuan_s2_money_1_left_b1").css({left:jiekuan_s2_money_1_left_i1_width});
		if(jiekuan_s2_money_1_left_i1_width >= 288){
			jiekuan_s2_money_1_left_i1_width = 288;
			$(".jiekuan_s2_money_1_left_50000").text(210000);
		}		
	})	
	
	//新人大礼包弹窗
	$(".enroll_close").click(function(){
		$("#nav_mask_libao").css({display:"none"});
		window.location.href = "/LoansBank/weiTime/html/index.jsp";
	});
	
	//-------------------------3月	
	$(".jiekuan_s2_money_1_left_plus2").click(function(){
		jiekuan_s2_money_1_left_i2_width += 20;
		$(".jiekuan_s2_money_1_left_3").text(Number($(".jiekuan_s2_money_1_left_3").text())+1);
		$("#loanDate").text($(".jiekuan_s2_money_1_left_3").text());
		$(".jiekuan_s2_money_1_left_i2").css({width:jiekuan_s2_money_1_left_i2_width});
		$(".jiekuan_s2_money_1_left_b2").css({left:jiekuan_s2_money_1_left_i2_width});
		if(jiekuan_s2_money_1_left_i2_width >= 278){
			jiekuan_s2_money_1_left_i2_width = 278;
			$(".jiekuan_s2_money_1_left_3").text(15);
		}
	})
	
	//--------------------------借款协议
	$(".jiekuan_xieyi").click(function(){
		$(".jiekuan_s2").css({display:"none"});
		$(".jiekuan_s2_money_2_right_mask").css({display:"block"});
	});
	$(".jiekuan_xieyi_btn").click(function(){
		$(".jiekuan_s2").css({display:"block"});
		$(".jiekuan_s2_money_2_right_mask").css({display:"none"});
	})
	
	
	//--------------------------app
	$(".enroll_close").click(function(){
		$("#nav_mask_app").css({display:"none"});
	});
	$(".nav_login_app").click(function(){
		$("#nav_mask_app").css({display:"block"});
		$("#nav_mask_login").css({display:"none"});
		$("#nav_mask").css({display:"none"});
	})
	
	
	//--------------------------tel登录
	
	$(".nav_login_tel_p2").click(function(){
		var telNum = 59;
		var time1 = setInterval(function(){
			telNum--;
			console.log(telNum)
			$(".nav_login_tel .nav_login_tel_p3 span strong").text(telNum);
			if(telNum <= 0){
				$(".nav_login_tel .nav_login_tel_p3 span").text("重新获取验证码");	
				clearInterval(time1)
			}
		},1000)
	})
	
	$(".nav_mask_login_pw_tel").click(function(){
		$("#nav_mask_tel").css({display:"block"});
	})
	
		//--------------------------找回密码
		$(".enroll_close").click(function(){
			$("#nav_mask_findpw").css({display:"none"});
		});
		$(".nav_mask_login_pw_pw").click(function(){
			$("#nav_mask_findpw").css({display:"block"});
		})
	
	
	//-------------------确定投资
	$(".touzi_sec_s1_right_1_btn").click(function(){
		$("#touzi_mask").css({display:"block"});
		$("#touzi_mask form h2").text("新手专享");
	})
	$(".touzi_sec_s1_right_2_btn").click(function(){
		$("#touzi_mask").css({display:"block"});
		$("#touzi_mask form h2").text("自由赚");
	})
	$(".touzi_sec_s1_right_3_btn").click(function(){
		$("#touzi_mask").css({display:"block"});
		$("#touzi_mask form h2").text("稳定赚");
	})
	$(".touzi_sec_s1_right_4_btn").click(function(){
		$("#touzi_mask").css({display:"block"});
		$("#touzi_mask form h2").text("精英之选");
	})
	
////	$("#touzi_mask .enroll_close").click(function(){
////		$("#touzi_mask").css({display:"none"});
////	})
//	
//	$(".touzi_mask_btn").click(function(){
//		window.open("center.html");
//	})
	
	
	
	
	
})


