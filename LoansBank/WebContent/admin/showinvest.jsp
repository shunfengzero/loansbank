<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>微时贷管理平台</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="<s:property value="#session.loginuser"/>" />
<script src="assets/js/echarts.min.js"></script>
<link rel="stylesheet" href="assets/css/amazeui.min.css" />
<link rel="stylesheet" href="assets/css/amazeui.datatables.min.css" />
<link rel="stylesheet" href="assets/css/app.css">
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/commo.js"></script>

</head>

<body data-type="widgets">
	<script src="assets/js/theme.js"></script>
	<div class="am-g tpl-g">
		<!-- 头部 -->
		<header> <!-- logo -->
		<div class="am-fl tpl-header-logo">
			<a href="javascript:;"><img src="assets/img/logo.png" alt=""></a>
		</div>
		<!-- 右侧内容 -->
		<div class="tpl-header-fluid">
			<!-- 侧边切换 -->
			<div class="am-fl tpl-header-switch-button am-icon-list">
				<span> </span>
			</div>
			<!-- 搜索 -->
			<div class="am-fl tpl-header-search">
				<form class="tpl-header-search-form" action="javascript:;">
					<button class="tpl-header-search-btn am-icon-search"></button>
					<input class="tpl-header-search-box" type="text"
						placeholder="搜索内容...">
				</form>
			</div>
			<!-- 其它功能-->
			<div class="am-fr tpl-header-navbar">
				<ul>
					<!-- 欢迎语 -->
					<li class="am-text-sm tpl-header-navbar-welcome"><a
						href="javascript:;">欢迎你, <span><s:property value="#session.loginuser"/></span>
					</a></li>

					<!-- 新邮件 -->
					<li class="am-dropdown tpl-dropdown" data-am-dropdown><a
						href="javascript:;" class="am-dropdown-toggle tpl-dropdown-toggle"
						data-am-dropdown-toggle> <i class="am-icon-envelope"></i> <span
							class="am-badge am-badge-success am-round item-feed-badge">4</span>
					</a> <!-- 弹出列表 -->
						<ul class="am-dropdown-content tpl-dropdown-content">
							<li class="tpl-dropdown-menu-messages"><a
								href="javascript:;"
								class="tpl-dropdown-menu-messages-item am-cf">
									<div class="menu-messages-ico">
										<img src="assets/img/user04.png" alt="">
									</div>
									<div class="menu-messages-time">3小时前</div>
									<div class="menu-messages-content">
										<div class="menu-messages-content-title">
											<i class="am-icon-circle-o am-text-success"></i> <span>夕风色</span>
										</div>
										<div class="am-text-truncate"><s:property value="#session.loginuser"/> 的诞生，依托于 GitHub
											及其他技术社区上一些优秀的资源；<s:property value="#session.loginuser"/> 的成长，则离不开用户的支持。</div>
										<div class="menu-messages-content-time">2016-09-21 下午
											16:40</div>
									</div>
							</a></li>

							<li class="tpl-dropdown-menu-messages"><a
								href="javascript:;"
								class="tpl-dropdown-menu-messages-item am-cf">
									<div class="menu-messages-ico">
										<img src="assets/img/user02.png" alt="">
									</div>
									<div class="menu-messages-time">5天前</div>
									<div class="menu-messages-content">
										<div class="menu-messages-content-title">
											<i class="am-icon-circle-o am-text-warning"></i> <span><s:property value="#session.loginuser"/></span>
										</div>
										<div class="am-text-truncate">为了能最准确的传达所描述的问题，
											建议你在反馈时附上演示，方便我们理解。</div>
										<div class="menu-messages-content-time">2016-09-16 上午
											09:23</div>
									</div>
							</a></li>
							<li class="tpl-dropdown-menu-messages"><a
								href="javascript:;"
								class="tpl-dropdown-menu-messages-item am-cf"> <i
									class="am-icon-circle-o"></i> 进入列表…
							</a></li>
						</ul></li>

					<!-- 新提示 -->
					<li class="am-dropdown" data-am-dropdown><a
						href="javascript:;" class="am-dropdown-toggle"
						data-am-dropdown-toggle> <i class="am-icon-bell"></i> <span
							class="am-badge am-badge-warning am-round item-feed-badge">5</span>
					</a> <!-- 弹出列表 -->
						<ul class="am-dropdown-content tpl-dropdown-content">
							<li class="tpl-dropdown-menu-notifications"><a
								href="javascript:;"
								class="tpl-dropdown-menu-notifications-item am-cf">
									<div class="tpl-dropdown-menu-notifications-title">
										<i class="am-icon-line-chart"></i> <span> 有6笔新的销售订单</span>
									</div>
									<div class="tpl-dropdown-menu-notifications-time">12分钟前</div>
							</a></li>
							<li class="tpl-dropdown-menu-notifications"><a
								href="javascript:;"
								class="tpl-dropdown-menu-notifications-item am-cf">
									<div class="tpl-dropdown-menu-notifications-title">
										<i class="am-icon-star"></i> <span> 有3个来自人事部的消息</span>
									</div>
									<div class="tpl-dropdown-menu-notifications-time">30分钟前</div>
							</a></li>
							<li class="tpl-dropdown-menu-notifications"><a
								href="javascript:;"
								class="tpl-dropdown-menu-notifications-item am-cf">
									<div class="tpl-dropdown-menu-notifications-title">
										<i class="am-icon-folder-o"></i> <span> 上午开会记录存档</span>
									</div>
									<div class="tpl-dropdown-menu-notifications-time">1天前</div>
							</a></li>


							<li class="tpl-dropdown-menu-notifications"><a
								href="javascript:;"
								class="tpl-dropdown-menu-notifications-item am-cf"> <i
									class="am-icon-bell"></i> 进入列表…
							</a></li>
						</ul></li>

					<!-- 退出 -->
					<li class="am-text-sm"><a href="javascript:adminLogout();"> <span
							class="am-icon-sign-out"></span> 退出
					</a></li>
				</ul>
			</div>
		</div>

		</header>
		<!-- 风格切换 -->
		<div class="tpl-skiner">
			<div class="tpl-skiner-toggle am-icon-cog"></div>
			<div class="tpl-skiner-content">
				<div class="tpl-skiner-content-title">选择主题</div>
				<div class="tpl-skiner-content-bar">
					<span class="skiner-color skiner-white" data-color="theme-white"></span>
					<span class="skiner-color skiner-black" data-color="theme-black"></span>
				</div>
			</div>
		</div>
		<!-- 侧边导航栏 -->
		<div class="left-sidebar">
			<!-- 用户信息 -->
			<div class="tpl-sidebar-user-panel">
				<div class="tpl-user-panel-slide-toggleable">
					<div class="tpl-user-panel-profile-picture">
						<img src="assets/img/user04.png" alt="">
					</div>
					<span class="user-panel-logged-in-text"> <i
						class="am-icon-circle-o am-text-success tpl-user-panel-status-icon"></i>
						<s:property value="#session.loginuser"/>
					</span> <a href="javascript:;" class="tpl-user-panel-action-link"> <span
						class="am-icon-pencil"></span> 账号设置
					</a>
				</div>
			</div>

			<!-- 菜单 -->
			<ul class="sidebar-nav">


			<li class="sidebar-nav-heading">首页</li>
				<li class="sidebar-nav-link"><a href="javascript:;"
					class="sidebar-nav-sub-title active"> <i
						class="am-icon-table sidebar-nav-link-logo"></i> 数据列表 <span
						class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico sidebar-nav-sub-ico-rotate"></span>
				</a>
					<ul class="sidebar-nav sidebar-nav-sub" style="display: block;">
						<li class="sidebar-nav-link"><a href="table-list.jsp"
							class="sub-active"> <span
								class="am-icon-angle-right sidebar-nav-link-logo"></span> 用户信息列表
						</a></li>
						
						<li class="sidebar-nav-link"><a href="table-list-loan.jsp"
							class="sub-active"> <span
								class="am-icon-angle-right sidebar-nav-link-logo"></span> 贷款用户列表
						</a></li>
						
						<li class="sidebar-nav-link"><a href="table-list-invest.jsp"
							class="sub-active"> <span
								class="am-icon-angle-right sidebar-nav-link-logo"></span> 投资用户列表
						</a></li>
						

						<%-- <li class="sidebar-nav-link"><a href="table-list-img.html">
								<span class="am-icon-angle-right sidebar-nav-link-logo"></span>
								图文列表
						</a></li> --%>
					</ul></li>
				<li class="sidebar-nav-link"><a href="sign-up.jsp"> <i
						class="am-icon-clone sidebar-nav-link-logo"></i> 注册 <%-- <span
						class="am-badge am-badge-secondary sidebar-nav-link-logo-ico am-round am-fr am-margin-right-sm">6</span> --%>
				</a></li>
				<li class="sidebar-nav-link"><a href="login.jsp"> <i
						class="am-icon-key sidebar-nav-link-logo"></i> 登录
				</a></li>
				<li class="sidebar-nav-link"><a href="404.html"> <i
						class="am-icon-tv sidebar-nav-link-logo"></i> 404错误
				</a></li>

			</ul>
		</div>


		<!-- 内容区域 -->
		<div class="tpl-content-wrapper">
			<div class="row-content am-cf">
				<div class="row">
					<div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
						<div class="widget am-cf">
							<div class="widget-head am-cf">
								<div class="widget-title  am-cf">文章列表</div>


							</div>
							<div class="widget-body  am-fr">

								<div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
									<div class="am-form-group">
										<div class="am-btn-toolbar">
											<div class="am-btn-group am-btn-group-xs">
												<%-- <button type="button"
													class="am-btn am-btn-default am-btn-success">
													<span class="am-icon-plus"></span> 新增
												</button>
												<button type="button"
													class="am-btn am-btn-default am-btn-secondary">
													<span class="am-icon-save"></span> 保存
												</button>
												<button type="button"
													class="am-btn am-btn-default am-btn-warning">
													<span class="am-icon-archive"></span> 审核
												</button> --%>

											</div>
										</div>
									</div>
								</div>

								<div class="am-u-sm-12 am-u-md-12 am-u-lg-3">
									<div
										class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
										<input type="text" class="am-form-field "> <span
											class="am-input-group-btn">
											<button
												class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search"
												type="button"></button>
										</span>
									</div>
								</div>

								<div class="am-u-sm-12">
									<form id="investForm" action="#" onsubmit="return false;">
										<table width="100%"
											class="am-table am-table-compact am-table-striped tpl-table-black "
											id="example-r">

											<tbody id="tid">
												
												<tr>
													<td>用户名</td>
													<td><input type="hidden" name="nid" value="${param.id }"><input type="text"
														style="background: 0; border: 0px;" id="userName"
														name="userName" value=""></td>
												</tr>
												<tr>
													<td>投资金额</td>
													<td><input type="text"
														style="background: 0; border: 0px;" id="iMoney"
														name="iMoney" value=""></td>
												</tr>
												<tr>
													<td>投资时间</td>
													<td><input type="text"
														style="background: 0; border: 0px;" id="investDate"
														name="investDate"></td>
												</tr>
												<tr>
													<td>投资时长</td>
													<td><input type="text"
														style="background: 0; border: 0px;" id="investTime"
														name="investTime"></td>
												</tr>
												<tr>
													<td>投资方式</td>
													<td><input type="text"
														style="background: 0; border: 0px;" id="investMethod"
														name="investMethod"></td>
												</tr>
												<tr>
													<td>提现方式</td>
													<td><input type="text"
														style="background: 0; border: 0px;" id="withDrawMethod"
														name="withDrawMethod"></td>
												</tr>
												<tr>
													<td>申请状态</td>
													<td><input type="text"
														style="background: 0; border: 0px;" id="investstatus"
														name="investstatus"></td>
												</tr>

												<tr>
													<td></td>
													<td>
														<button type="button" onclick="acceptClick()"
															class="am-btn am-btn-default am-btn-success">
															<span class="am-icon-plus"></span> 批准申请
														</button>
														<button type="button" onclick="returnClick()"
															class="am-btn am-btn-default am-btn-success">
															<span class="am-icon-plus"></span> 返回
														</button>
													</td>

												</tr>
											</tbody>
										</table>
									</form>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="assets/js/amazeui.min.js"></script>
	<script src="assets/js/amazeui.datatables.min.js"></script>
	<script src="assets/js/dataTables.responsive.min.js"></script>
	<script src="assets/js/app.js"></script>

	<script>
		$(function() {
			$.ajax({
				type : "post",
				url : "/LoansBank/find_Invest?id=${param.id }",
				dataType : "json",
				success : function(backdata) {
					if (backdata.code == 0) {
						alert(backdata.code);
					} else {
						//设置属性
						$("#userName").val(backdata.msg.userName);
						$("#iMoney").val(backdata.msg.iMoney);
						$("#investTime").val(backdata.msg.investTime);
						$("#investDate").val(backdata.msg.investDate);
						$("#investMethod").val(backdata.msg.investMethod);
						$("#withDrawMethod").val(backdata.msg.withDrawMethod);
						$("#investstatus").val(backdata.msg.investstatus);
					}
				}
			});
		});
		
		function acceptClick(){
			$.ajax({
				type : "post",
				url : "/LoansBank/approve_Invest?id=${param.id }",
				dataType : "json",
				success : function(backdata) {
					if (backdata.code == 0) {
					} else {
						//设置属性
						$("#userName").val(backdata.msg.userName);
						$("#iMoney").val(backdata.msg.iMoney);
						$("#investTime").val(backdata.msg.investTime);
						$("#investMethod").val(backdata.msg.investMethod);
						$("#withDrawMethod").val(backdata.msg.withDrawMethod);
						$("#investstatus").val(backdata.msg.investstatus);
					}
				}
			});
		}
		
		function returnClick(){
			window.location.href="table-list-invest.jsp";
		}
		
	</script>
</body>

</html>