$(function(){
	
	myCount();
	myInvest();
	
	
	
	//左键点击事件
	$(".center_sec_div_1_left").click(function(){
		$(".center_sec_1_1").css({display:'block'});
		$(".center_sec_1_2").css({display:'none'});
		$(".center_sec_1_3").css({display:'none'});
		$(".center_sec_1_4").css({display:'none'});
	});
	
	$(".center_sec_div_2_left").click(function(){
		$(".center_sec_2_1").css({display:'block'});
		$(".center_sec_2_2").css({display:'none'});
		$(".center_sec_2_3").css({display:'none'});
	});
	
	$(".center_sec_div_3_left").click(function(){
		$(".center_sec_3_1").css({display:'block'});
		$(".center_sec_3_2").css({display:'none'});
		$(".center_sec_3_3").css({display:'none'});
	});
	
	$(".center_sec_div_4_left").click(function(){
		$(".center_sec_4_1").css({display:'block'});
		$(".center_sec_4_2").css({display:'none'});
		$(".center_sec_4_3").css({display:'none'});
		$(".center_sec_4_4").css({display:'none'});
		$(".center_sec_4_5").css({display:'none'});
	});
	
	//第一个div
	$(".center_sec_1_1_p1_btn1").click(function(){
		$(".center_sec_1_1").css({display:'none'});
		$(".center_sec_1_2").css({display:'block'});
	});	
	$(".center_sec_1_1_p2_btn1").click(function(){
		$(".center_sec_1_1").css({display:'none'});
		$(".center_sec_1_3").css({display:'block'});
	});
	$(".center_sec_1_1_p2_btn2").click(function(){
		$(".center_sec_1_1").css({display:'none'});
		$(".center_sec_1_4").css({display:'block'});
	});
	//第二个div
	$(".center_sec_2_1_p2_btn1").click(function(){
		$(".center_sec_2_1").css({display:'none'});
		$(".center_sec_2_2").css({display:'block'});
	});	
	$(".center_sec_2_1_p2_btn2").click(function(){
		$(".center_sec_2_1").css({display:'none'});
		$(".center_sec_2_3").css({display:'block'});
	});
	
	//第三个div
	$(".center_sec_3_1_p2_btn1").click(function(){
		$(".center_sec_3_1").css({display:'none'});
		$(".center_sec_3_2").css({display:'block'});
	});	
	$(".center_sec_3_1_p2_btn2").click(function(){
		$(".center_sec_3_1").css({display:'none'});
		$(".center_sec_3_3").css({display:'block'});
	});
	
	//第三个div
	$(".center_sec_4_1_p1_btn1").click(function(){
		$(".center_sec_4_1").css({display:'none'});
		$(".center_sec_4_2").css({display:'block'});
	});	
	$(".center_sec_4_1_p1_btn2").click(function(){
		$(".center_sec_4_1").css({display:'none'});
		$(".center_sec_4_3").css({display:'block'});
	});
	$(".center_sec_4_1_p2_btn1").click(function(){
		$(".center_sec_4_1").css({display:'none'});
		$(".center_sec_4_4").css({display:'block'});
	});	
	$(".center_sec_4_1_p2_btn2").click(function(){
		$(".center_sec_4_1").css({display:'none'});
		$(".center_sec_4_5").css({display:'block'});
	});
	
	//消息弹窗
	$(".center_sec_img1").hover(function(){
		$(".center_sec_img1_xiaoxi").css({display:"block"});
	},function(){
		$(".center_sec_img1_xiaoxi").css({display:"none"});
	});
	//设置
	$(".center_sec_img2").click(function(){
		$("#center_sec").css({display:'none'});
		$(".center_sec_img2_shezhi").css({display:'block'});
	})
	$(".center_sec_img2_shezhi_1_close").click(function(){
		$("#center_sec").css({display:'block'});
		$(".center_sec_img2_shezhi").css({display:'none'});
	})
	$(".center_sec_img2_shezhi_3").click(function(){
		$(".center_sec_img2_shezhi").css({display:'none'});
		$(".center_sec_img2_shezhi_renzheng").css({display:"block"});
	})
	$(".center_sec_p1 span").click(function(){
		$("#center_sec").css({display:'none'});
		$(".center_sec_img2_shezhi_renzheng").css({display:"block"});
		/*$(".center_sec_img2_shezhi_renzheng").attr("display","block");*/
	})
	
})

//我的账单
function myCount() {
	$.ajax({
		type:"post",
		url:"loginUserInfo",
		dataType:"json",
		success:function(data) {
			if (data.code == 1) {
				var info = data.msg;//数组
				var limitMoney = 0;
				$("#myCount").empty();
				var html = "";
				for (var i = 0; i < info.length; i ++) {
					limitMoney += info[i].limitMoney;
					html += "<p class='center_sec_1_3_p1'><span>" + info[i].applyTime + "</span><span>借款<strong>" + info[i].limitMoney + "</strong>元</span></p>";
				}
				$("#nickName1").text(info[0].userName);
				//手机号：155******54
				var phone = "";
				phone = info[0].phone.substring(0,3) + "******" + info[0].phone.substring(9);
				$("#myPhone").text("手机号：" + phone);
				$("#nickName2").text(info[0].userName);
				$("#myCount").append($(html));
				$("#waitMoney").val(limitMoney);
			}
		}
	});
}


//我的投资
function myInvest() {
	$.ajax({
		type:"post",
		url:"investmoney",
		dataType:"json",
		success:function(data) {
			if (data.code == 1) {
				var info = data.msg;//数组
				var investMoney = 0;
				$("#investHistory").empty();
				var html = "";
				for (var i = 0; i < info.length; i ++) {
					investMoney += parseInt(info[i].iMoney);
					html += "<p class='center_sec_3_3_p1'>" + info[i].investDate + "   投资 " + info[i].iMoney + "</strong>元</span></p>";
				}
				//盈利金额
				$("#earnMoney").val(investMoney / 100);
				$("#investHistory").append($(html));
				$("#investMoney").val(investMoney + "元");
			}
		}
	});
	
}











