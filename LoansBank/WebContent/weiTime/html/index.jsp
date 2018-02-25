<!--<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>-->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>微时贷</title>
		<link rel="stylesheet" href="../css/style.css" />
		<link rel="shortcut icon" href="../img/title.png" />
		
		<script src="../js/jquery-3.2.1.min.js"></script>
	
		<script src="../js/jquery.validate.min.js"></script>
		<script src="../js/loginandregister.js"></script>
		<script src="../js/index.js"></script>
		<script src="../js/lunbo.js"></script>
		<script src="../js/animate.js"></script>
		<script src="../js/comman.js"></script>
	</head> 
	<body>
		<div id="boss">
<!---------------------------nav------------------------->
		<div id="nav_wrap">
			<nav>
				<div class="logo"><img src="../img/logo1.jpg"/></div>
	 			<ul>
					<li><a href="index.jsp" class="nav_active">首页</a></li>
					<li><a href="touzi.html">我要投资</a></li>
					<li><a href="jiekuan.html">我要借款</a></li>
					<li><a href="center.html">个人中心</a></li>
					<li><a href="about us.html">关于我们</a></li>
				</ul>
				<!-- 登录注册按钮DIV -->
				<div class="nav-right">
				
				</div>
			</nav>
		</div>	
<!---------------------------弹窗------------------------->
<!---------------注册----------->
		<div id="nav_mask">
			<!-- <form id="regForm">
				<h2>注册</h2>
				<img src="../img/enroll_close.png" class="enroll_close" />
				<h3>欢迎注册，如果您已有账户，可在此<span class="enroll_login">登录</span></h3>
				<p><span>用户名：</span><input id="userName" type="text" name="userName">*</p>
				<p><span>登录密码：</span><input id="passWord" type="password" name="passWord">*</p>
				<p><span>确认密码：</span><input id="rePassWord" type="password" name="rePassWord">*</p>
				<p><span>手机号码：</span><input id="telePhone" type="text" name="telePhone">*</p>
				<p><span>电子邮箱：</span><input id="email" type="text" name="email">*</p>
				<p><span>验证码：</span><input type="text" class="nav_enroll_p6"><img src="" />*</p>
				<input type="submit" value="同意协议并注册" class="nav_xieyi">
				<a href="#">《微时贷服务协议》</a>
			</form> -->
		</div>
<!---------------登录----------->		
		<div id="nav_mask_login">
			<!-- <form id="loginForm" onsubmit="return false;">
				<img src="../img/enroll_close.png" class="enroll_close" />
				<p class="nav_mask_login"><span>账号</span><input type="text" name="userName" /></p>
				<p><span>密码</span><input type="password" name="passWord"/></p>
				<p class="nav_mask_login_pw"><a href="#" class="nav_mask_login_pw_tel">手机登录</a><a href="#" class="nav_mask_login_pw_pw">忘记密码</a></p>
				<button class="nav_mask_login_button" onclick="login()">登录</button>
				<input  type="submit" value="登录" class="nav_mask_login_button" onclick="login()">
			</form> -->
		</div>
<!---------------注册成功----------->		
		<div id="nav_mask_libao">
			<div class="nav_libao" id="nav_libao">
				<img src="../img/enroll_close.png" class="enroll_close" />
				<b class="nav_b1">注</b>
				<b class="nav_b2">册</b>								
				<b class="nav_b3">成</b>				
				<b class="nav_b4">功</b>				
				<img src="../img/dlb.png" />
				<button class="nav_libao_btn">点击有礼</button>
			</div>
		</div>
<!----------------获得礼包---------->	
		<div id="nav_mask_huode">
			<div class="nav_huode">
				<img src="../img/enroll_close.png" class="enroll_close" />
				<p class="nav_mask_huode_p1">您已获得</p>
				<p class="nav_mask_huode_p2">现金提现资格</p>
				<p class="nav_mask_huode_p2">500元体验金</p>
				<p class="nav_mask_huode_p2">3个月10%利息券</p>
				<p class="nav_mask_huode_p5">邀请好友即可得 <span>500</span> 元优惠券呦</p>
				<input type="button" value="立即体验"  class="nav_mask_huode_btn"/>
				<img src="../img/huode_bg.png" class="huode_bg" />
				<img src="../img/huode_pic .png" class="huode_pic"/>
			</div>
		</div>
<!---------------扫码登录----------->
		<div id="nav_mask_app">
			<div class="nav_app">
				<h2>扫描二维码下载</h2>
				<img src="../img/enroll_close.png" class="enroll_close"/>
				<img src="../img/qr.png" />
			</div>
		</div>

<!---------------手机登录----------->
		<div id="nav_mask_tel">
			<div class="nav_login_tel">
				<img src="../img/enroll_close.png" class="enroll_close" />
				<p class="nav_login_tel_p1">手机号<input type="tel"></p>
				<p class="nav_login_tel_p2">点击获取验证码</p>
				<p class="nav_login_tel_p3">验证码<input type="text"><span><strong>59</strong>s后重新发送</span></p>
				<input type="button" value="登录" class="nav_login_tel_btn" />
			</div>
		</div>
<!---------------找回密码----------->		
		<div id="nav_mask_findpw">
			<div class="nav_findpw">
				<img src="../img/enroll_close.png" class="enroll_close" />
				<p  class="nav_findpw_p1"><span>账号</span><input type="text"></p>
				<p><span>电话</span><input type="text"></p>
				<p class="nav_findpw_p3"><span>验证码</span><input type="text"></p>
				<p><span>新密码</span><input type="text"></p>
				<p><span>确认密码</span><input type="text"></p>
				<input type="button" value="确认" class="nav_findpw_btn" />
			</div>
		</div>
		
		
		
		
		
		
<!---------------------------header------------------------->
			
			<header>
				<div class="box1">
					<ul class="item">
						<li >
							<img src="../img/banner.jpg" class="header_banner_img">
							<h2>The Development Of Versed</h2>
							<h3>发展路程</h3>
							<em></em>
							<p class="header_banner1_p1">微时贷平台于<span>2008</span>年成立于中国上海，成为中国首批网贷平台。
							 <br> <span>2010</span>年进入中原发展。
							 <br> <span>2015</span>年与银行P2P资金托管平台对接。
							 <br> <span>2016</span>年加入理财功能。
							 <br> 日渐完善的功能推动微时贷大步向前。</p>
							<i></i>
							<p class="header_banner1_p2">P2P(person-to-person或peer-to-peer)属于互联网金融(ITFIN)产品的一种，<br />
								称点对点网络借款，是一种将小额资金聚集起来借贷给有资金需求人群的<br>一种小额借贷模式。
							</p>
						</li>
						<li class="item_li2">
							<img src="../img/banner_2.jpg"  class="header_banner2_img"/>
							<p class="header_banner2_p1">The Seccessful Case</p>
							<p class="header_banner2_p2">1分钟申请  3分钟审核  10分钟到账</p>
							<p class="header_banner2_p3">已为超<span>1000万</span>客户提供贷款服务 贷款总额超过<span>1500亿</span>元</p>
							<p class="header_banner2_p4">已拥有超过4万人的线下销售和服务团队，分布于<br>全国超200个城市。线上近6000人的远程销售服务团队7x24小时为<br>
								个人及小微企业客户提供专业的贷款服务，并为客<br>户提供愉悦、简单的贷款互动体验。
							</p>
						</li>
						<li>
							<img src="../img/banner_3.jpg"  class="header_banner3_img" />
							<p class="header_banner3_p1">The Economic Data</p>
							<i class="header_banner3_i"></i>
							<p class="header_banner3_p2">公司先后获得<span>IDG 660万</span>美金A轮投资</p>
							<p class="header_banner3_p3"><span>SIG 2000万</span>美金B轮投资</p>
							<p class="header_banner3_p4">以及招商局、SIG、光远资本等领投的<span>8000万</span>美金C轮投资</p>
							<p class="header_banner3_p5">总融资金额过亿美元</p>
						</li>
					</ul>
					
					<button class="leftBtn">&lt;</button>
    				<button class="rightBtn">&gt;</button>

    				<ul class="page"><li></li><li></li><li></li></ul>
				</div>
				
				
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
										<h3>历史借出款项</h3>
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
									<figcaption class="figcaption1">
										<a href="#">
											注册即可提现现金
										</a>
									</figcaption>
								</figure>
								<figure>
									<img src="../img/index_pic2.jpg" />
									<figcaption class="figcaption2">
										<a href="#">轻松体验，现金收益全归您</a>
									</figcaption>
								</figure>
								<figure>
									<img src="../img/index_pic3.jpg" />
									<figcaption class="figcaption3">
										<a href="#">新人投资福利专享</a>
									</figcaption>
								</figure>
								<figure>
									<img src="../img/index_pic4.jpg" class="figure_img4" />
									<figcaption class="figcaption4">
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
						<a href="http://www.http://weibo.com/?c=spr_sinamkt_buy_hyww_weibo_p113#_loginLayer_1507548860476" class="bottom_p1"><img src="../img/bottom1.jpg"/></a>
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
						<p>备案号：豫ICP备17032686号-1</p>
						<p>2017吴实验室</p>
					</div>
					
				</footer>
				
			</div>
		</div>	
		</div>
		
	</body>
</html>
