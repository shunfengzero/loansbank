<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>微时贷</title>
		<link rel="stylesheet" href="../css/style.css" />
		<link rel="shortcut icon" href="../img/title.png" />
		
		<script src="../js/jquery-3.2.1.min.js"></script>
		<script src="../js/jquery.validate.min.js"></script>
		<script src="../js/index.js"></script>
	</head>
	
	
	
	<body>
		<div id="boss">
<!---------------------------nav------------------------->
		<div id="nav_wrap">
			<nav>
				<div class="logo"><img src="../img/logo1.jpg"/></div>
				<ul>
					<li><a href="#">首页</a></li>
					<li><a href="#">我要投资</a></li>
					<li><a href="#">我要借款</a></li>
					<li><a href="#">个人中心</a></li>
					<li><a href="#">关于我们</a></li>
				</ul>
				<div class="nav-right">
					<span><a href="#">APP</a></span>
					<a href="#" class="nav_login">登录</a>
					<a href="#" class="nav_enroll">注册</a>
				</div>
			</nav>
		</div>	
<!---------------------------nav_login------------------------->
		<div id="nav_mask">
			<form id="regForm">
				<h2>注册</h2>
				<img src="../img/enroll_close.png" class="enroll_close" />
				<h3>欢迎注册，如果您已有账户，可在此<span class="enroll_login">登录</span></h3>
				<p><span>用户名：</span><input type="text" name="userName">*</p>
				<p><span>登录密码：</span><input id="passWord" type="password" name="passWord">*</p>
				<p><span>确认密码：</span><input id="rePassWord" type="password" name="rePassWord">*</p>
				<p><span>手机号码：</span><input type="tel" name="telePhone">*</p>
				<p><span>电子邮箱：</span><input type="text" name="email">*</p>
				<p><span>验证码：</span><input type="text" class="nav_enroll_p6"><img src="" />*</p>
				<input type="submit" value="注册" class="nav_xieyi">同意以下协议并注册
				<a href="#">《微时贷服务协议》</a>
			</form>
		</div>
		
		<div id="nav_mask_login">
			<form id="loginForm" method="post">
				<img src="../img/enroll_close.png" class="enroll_close" />
				<p class="nav_mask_login"><span>账号</span><input type="text" name="userName"  /></p>
				<p><span>密码</span><input type="password" name="passWord" /></p>
				<p class="nav_mask_login_pw"><a href="#">手机登录</a><a href="#">忘记密码</a></p>
				<button class="nav_mask_login_button" onclick="login()" >登录</button>
			</form>
		</div>
		<div id="nav_mask_libao">
			<div class="nav_libao" id="nav_libao">
				
			</div>
		</div>
		
				
<!---------------------------header------------------------->
			
			<header>
				<img src="../img/banner.jpg" class="header_img">
				<!--<img src="../img/banner_bg.jpg" class="header_img_bg" />-->
				<h2>The Development Of Versed</h2>
				<h3>发展路程</h3>
				<em></em>
				<p class="header_p1">微时贷平台于<span>2008</span>年成立于中国上海，成为中国首批网贷平台。
				 <br> <span>2010</span>年进入中原发展。
				 <br> <span>2015</span>年与银行P2P资金托管平台对接。
				 <br> <span>2016</span>年加入理财功能。
				 <br> 日渐完善的功能推动微时贷大步向前。</p>
				<i></i>
				<p class="header_p2">P2P(person-to-person或peer-to-peer)属于互联网金融(ITFIN)产品的一种，<br />
					称点对点网络借款，是一种将小额资金聚集起来借贷给有资金需求人群的<br>一种小额借贷模式。
				</p>
			</header> 
			 
					
<!---------------------------section------------------------->
			<div id="section-wrap">
				<section>
					<div class="sec">
						<p>平台成立至今，服务超过60000位客户。</p>
						<p>总借出额度超过300亿，成为客户最信赖的P2P平台。</p>
						<p>总投资35620人次，投资增长率达90%。</p>
						<p class="sec_p4">风险控制精准度100%，准确预估投资风险。</p>
					</div>
					<div class="s1-wrap">
						
						<div class="s1">
							<div class="s1-f">
								<div class="s1-1">
									<div class="s1-1-1">简单投</div>
									<ul>
										<h2>12%</h2>
										<h3>历史年化收益</h3>
										<li><span>100元起投</span></li>
										<li><span>限投一次</span></li>
										<li><span>限投5万</span></li>
									</ul>								
								</div>
								
								<div class="s1-2">
									<div class="s1-2-1">轻松贷</div>
									<ul>
										<h2>300亿</h2>
										<h3>历史借出款项金额</h3>
										<li><span>日均利息低至1元</span></li>
										<li><span>还款方式灵活</span></li>
										<li><span>借款周期自由</span></li>
									</ul>								
								</div>
							</div>
							
							<p>最近7日借出项目年化收益率值范围。历史不代表未来，实际数字可能高于或者低于所标示近7日历史年化收益率。</p>
						</div>
					</div>
					
					<div class="s2-wrap">
						<div class="s2">
							<h2>新人专享福利</h2>
							<div class="s2_img">
								<figure>
									<img src="../img/index_pic1.jpg" />
									<figcaption>
										<a href="#">
											注册即可提现现金
										</a>
									</figcaption>
								</figure>
								<figure>
									<img src="../img/index_pic2.jpg" />
									<figcaption>
										<a href="#">轻松体验，现金收益全归您</a>
									</figcaption>
								</figure>
								<figure>
									<img src="../img/index_pic3.jpg" />
									<figcaption>
										<a href="#">新人投资福利专享</a>
									</figcaption>
								</figure>
								<figure>
									<img src="../img/index_pic4.jpg" />
									<figcaption>
										<a href="#">邀请好友即可获得</a>
									</figcaption>
								</figure>
							</div>
						</div>
					</div>
				
				</section>
				
			</div>
			
			
			
			
			
<!---------------------------bottom------------------------->
		<div id="footer_bg">
			<div id="bottom-wrap">
				<div class="bottom">
					<h2>关注我们</h2>
					<p>
						<a href="#" class="bottom_p1"><img src="../img/bottom1.jpg"/></a>
						<a href="#"><img src="../img/bottom2.png"/></a>
					</p>
				</div>
			</div>
			
			
			
			
			
<!---------------------------footer------------------------->
			<div id="footer-wrap">
			
				<footer>
					<div class="f1">
						<p>郑州市金水区</p>
						<p>13689098767</p>
					</div>
					
					<div class="f1">
						<p>3C认证</p>
						<p>大平台实力保证</p>
					</div>
					
					<div class="f1">
						<p>备案号：豫ICP备15043749号-1</p>
						<p>2017微时贷人人行科技股份有限公司</p>
					</div>
					
				</footer>
				
			</div>
		</div>	
		
		
		</div>
		
		
		<script type="text/javascript">
		$(function(){
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
								
								$("#nav_libao").empty();
								var html = "";
								html += "<img src='../img/enroll_close.png' class='enroll_close' />";
								html += "<b class='nav_b1'>新</b>";
								html += "<b class='nav_b2'>人</b>";
								html += "<b class='nav_b3'>大</b>";
								html += "<b class='nav_b4'>礼</b>";
								html += "<b class='nav_b5'>包</b>";
								html += "<img src='../img/dlb.png'/>";
								html += "<button class='nav_libao_btn'>立即来拿</button>"
								
								$("#nav_libao").append(html);
								
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
					email:{
						required:true,
						email:true
					}		
			},
			messages:{
				userName:"当前用户已存在",
				passWord:{
					required:"请输入密码",
					minlength:"密码不能小于四个字符"
				},
				rePassWord:{
					required:"请输入密码",
					minlength:"密码不能小于四个字符",
					equalTo:"两次密码输入不一致"
				},
				email:"请输入一个正确的邮箱"
			}
				
				
			});
		});
		
		//登录函数
		function login() {
			alert("login");
    		$.ajax({
    			type:"post",
    			url:"login", //请求的资源是logAction
    			data:$("#loginForm").serialize(),
    			dataType:"json",
    			success:function(data) {
    				if (data.code == 0) {
    					alert(data.msg);
    				} else {
    					//登录成功跳转到首页
    					window.location.href = "index.jsp";
    				}
    			}
    		});
    	}
	</script>
	</body>
</html>
