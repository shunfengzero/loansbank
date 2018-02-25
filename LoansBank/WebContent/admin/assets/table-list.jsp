<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Amaze UI Admin index Examples</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<script src="assets/js/echarts.min.js"></script>
<link rel="stylesheet" href="assets/css/amazeui.min.css" />
<link rel="stylesheet" href="assets/css/amazeui.datatables.min.css" />
<link rel="stylesheet" href="assets/css/app.css">
<script src="assets/js/jquery.min.js"></script>
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
						href="javascript:;">欢迎你, <span>Amaze UI</span>
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
										<div class="am-text-truncate">Amaze UI 的诞生，依托于 GitHub
											及其他技术社区上一些优秀的资源；Amaze UI 的成长，则离不开用户的支持。</div>
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
											<i class="am-icon-circle-o am-text-warning"></i> <span>禁言小张</span>
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
					<li class="am-text-sm"><a href="javascript:;"> <span
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
						禁言小张
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
						<li class="sidebar-nav-link"><a href="table-list.html"
							class="sub-active"> <span
								class="am-icon-angle-right sidebar-nav-link-logo"></span> 文字列表
						</a></li>

						<li class="sidebar-nav-link"><a href="table-list-img.html">
								<span class="am-icon-angle-right sidebar-nav-link-logo"></span>
								图文列表
						</a></li>
					</ul></li>
				<li class="sidebar-nav-link"><a href="sign-up.html"> <i
						class="am-icon-clone sidebar-nav-link-logo"></i> 注册 <span
						class="am-badge am-badge-secondary sidebar-nav-link-logo-ico am-round am-fr am-margin-right-sm">6</span>
				</a></li>
				<li class="sidebar-nav-link"><a href="login.html"> <i
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
												<button type="button"
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
												</button>
												<button type="button"
													class="am-btn am-btn-default am-btn-danger">
													<span class="am-icon-trash-o"></span> 删除
												</button>
											</div>
										</div>
									</div>
								</div>
								<div class="am-u-sm-12 am-u-md-6 am-u-lg-3">
									<div class="am-form-group tpl-table-list-select">
										<select data-am-selected="{btnSize: 'sm'}">
											<option value="option1">用户信息</option>
											<option value="option2">IT业界</option>
											<option value="option3">数码产品</option>
											<option value="option3">笔记本电脑</option>
											<option value="option3">平板电脑</option>
											<option value="option3">只能手机</option>
											<option value="option3">超极本</option>
										</select>
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
									<table width="100%"
										class="am-table am-table-compact am-table-striped tpl-table-black "
										id="example-r">
										<thead>
											<tr>
												<th>Id</th>
												<th>用户名</th>
												<th>密码</th>
												<th>真实姓名</th>
												<th>性别</th>
												<th>邮箱</th>
												<th>电话</th>
												<th>地址</th>
												<!-- 	<th>介绍</th>
												<th>激活码</th>
												<th>状态码</th>
												<th>权限</th> -->
												<th>注册时间</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody id="tid">
											<%-- <s:iterator value="user" status="vs">
											<tr class="gradeX">
												<td><s:property value="id"/></td>
												<td><s:property value="userName"/></td>
												<td><s:property value="password"/></td>
												<td><s:property value="realName"/></td>
												<td><s:property value="gender"/></td>
												<td><s:property value="email"/></td>
												<td><s:property value="phone"/></td>
												<td><s:property value="registTime"/></td>
					
												<td>
													<div class="tpl-table-black-operation">
														<a href="javascript:;"> <i class="am-icon-pencil"></i>
															编辑
														</a> <a href="javascript:;"
															class="tpl-table-black-operation-del"> <i
															class="am-icon-trash"></i> 删除
														</a>
													</div>
												</td>
											</tr>
										 </s:iterator> --%>

											<!-- 						<tr class="gradeX">
												<td>请问有没有amazeui 分享插件</td>
												<td>王宽师</td>
												<td>2016-09-26</td>
												<td>
													<div class="tpl-table-black-operation">
														<a href="javascript:;"> <i class="am-icon-pencil"></i>
															编辑
														</a> <a href="javascript:;"
															class="tpl-table-black-operation-del"> <i
															class="am-icon-trash"></i> 删除
														</a>
													</div>
												</td>
											</tr> -->

											<!-- more data -->
										</tbody>
									</table>
								</div>
								<div class="am-u-lg-12 am-cf">

									<div class="am-fr">

										<table width="100%"
											class="am-table am-table-compact am-table-striped tpl-table-black "
											id="example-r">

											<tbody id="tul">
												<!-- <ul class="am-pagination tpl-pagination">
											<li class="am-disabled"><a href="#">«</a></li>
											<li class="am-active"><a href="#">1</a></li>
											<li><a href="#">2</a></li>
											<li><a href="#">3</a></li>
											<li><a href="#">4</a></li>
											<li><a href="#">5</a></li>
											<li><a href="#">»</a></li>
										</ul> -->
											</tbody>
										</table>
									</div>
								</div>
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
				url : "/LoansBank/find_Users?cp=1&id=1",
				dataType : "json",
				success : function(data) {
					if (data.code == 1) {
						bindData(data.msg, data.page, data.currentPage);
					} else {
						alert(data.msg);
					}
				}
			})
		});
		
		function findUsers(cp,id) {
			alert("cp :" + cp);
			$.ajax({
				type : "post",
				url : "/LoansBank/find_Users?cp=" + cp+"&id" +id,
				dataType : "json",
				success : function(data) {
					if (data.code == 1) {
						bindData(data.msg, data.page, data.currentPage);
					} else {
						alert(data.msg);
					}
				}
			});
		}

		function editorUser(id) {
			$.ajax({
				type : "post",
				url : "/LoansBank/editor_User?id=" + id,
				dataType : "json",
				success : function(data) {
					if (data.code == 1) {
						bindData(data.msg, data.page);
					} else {
						alert(data.msg);
					}
				}
			});
		}

		function deleteUser(id,cp) {
			$.ajax({
				type : "post",
				url : "/LoansBank/delete_User?id=" + id+"&cp="+cp,
				dataType : "json",
				success : function(data) {
					if (data.code == 1) {
						bindData(data.msg, data.page, data.currentPage);
					} else {
						alert(data.msg);
					}
				}
			});
		}

		function serach() {

			$.ajax({
				type : "post",
				url : "/LoansBank/find_Users",
				data : $("#searchForm").serialize(),
				dataType : "json",
				success : function(data) {
					if (data.code == 1) {
						bindData(data.msg, date.page);
					} else {
						alert(data.msg);
					}
				}
			});
		}

		function bindData(info, page, cpage) {
			$("#tid").empty();
			$(info)
					.each(
							function() {
								var html = "<tr class='gradeX'>";
								html += "<td>" + this.id + "</td>";
								html += "<td>" + this.userName + "</td>";
								html += "<td>" + this.passWord + "</td>";
								html += "<td>" + this.realName + "</td>";
								html += "<td>" + this.gender + "</td>";
								html += "<td>" + this.email + "</td>";
								html += "<td>" + this.telePhone + "</td>";
								html += "<td>" + this.address + "</td>";
								/*<th>介绍</th>
								<th>激活码</th>
								<th>状态码</th>
								<th>权限</th> */
								html += "<td>" + this.registTime + "</td>";
								html += "<td>"
								html += "<div class='tpl-table-black-operation'>";
								html += "<a href='javascript:editorUser("
										+ this.id+","+cpage
										+ ")'> <i class='am-icon-pencil'></i>"
										+ "编辑" + "</a>";
								html += "<a href='javascript:deleteUser("
										+ this.id+","+cpage
										+ ")' class='tpl-table-black-operation-del'> <i class='am-icon-trash'></i>"
										+ "删除" + "</a>";
								html += "</div>";
								html += "</td>";
								html += "</tr>";
								$("#tid").append($(html));
							});

			$("#tul").empty();
			alert(info[1].id + "id");
			var ht = "<ul class='am-pagination tpl-pagination'>";
			ht += "<li class='am-disabled'><a href='#'>«</a></li>";

			//	ht += "<li class='am-active'><a href='#'>1</a></li>";

			alert(page + "page");

			if (page > 6) {
				alert("page > 6");
				if (cpage <= 3) {
					for (var cp = 1; cp < 6; cp++) {
						if (cp == cpage) {
							ht += "<li class='am-active'><a href='javascript:findUsers("
								+ cp +"," + info[1].id
								+ ")'>" + cp
									+ "</a></li>";
						} else {
							ht += "<li><a href='javascript:findUsers("
								+ cp +"," + info[1].id
								+ ")'>" + cp + "</a></li>";
						}
					}
				} else if (cpage == page) {
					alert("cpage == page");
					ht += "<li><a href='javascript:findUsers("+(cpage - 4)+","+info[1].id+")'>" + (cpage - 4) + "</a></li>";
					ht += "<li><a href='javascript:findUsers("+(cpage - 3)+","+info[1].id+")'>" + (cpage - 3) + "</a></li>";
					ht += "<li><a href='javascript:findUsers("+ (cpage - 2) +","+info[1].id+")'>" + (cpage - 2) + "</a></li>";
					ht += "<li><a href='javascript:findUsers("+ (cpage- 1) +","+info[1].id+")'>" + (cpage - 1) + "</a></li>";
					ht += "<li class='am-active'><a href='javascript:findUsers("+ cpage +","+info[1].id+")'>" + cpage + "</a></li>";
				} else if ((cpage + 1) == page) {
					alert("(cpage + 1) == page");
					ht += "<li><a href='javascript:findUsers("+(cpage - 3)+","+info[1].id+")'>" +( cpage - 3) + "</a></li>";
					ht += "<li><a href='javascript:findUsers("+(cpage - 2)+","+info[1].id+")'>" + (cpage - 2) + "</a></li>";
					ht += "<li><a href='javascript:findUsers("+(cpage - 1)+","+info[1].id+")'>" + (cpage - 1) + "</a></li>";
					ht += "<li class='am-active'><a href='javascript:findUsers("+ cpage +","+info[1].id+")'>" + cpage + "</a></li>";
					ht += "<li><a href='javascript:findUsers("+(cpage + 1)+","+info[1].id+")'>" + (cpage + 1) + "</a></li>";
				} else {
					alert("else");
					ht += "<li><a href='javascript:findUsers("+(cpage - 2)+","+info[1].id+")'>" + (cpage - 2) + "</a></li>";
					ht += "<li><a href='javascript:findUsers("+(cpage - 1)+","+info[1].id+")'>" + (cpage - 1) + "</a></li>";
					ht += "<li class='am-active'><a href='javascript:findUsers("+ cpage +","+info[1].id+")'>" + cpage + "</a></li>";
					ht += "<li><a href='javascript:findUsers("+(cpage + 1)+","+info[1].id+")'>" + (cpage + 1) + "</a></li>";
					ht += "<li><a href='javascript:findUsers("+(cpage + 2)+","+info[1].id+")'>" + (cpage + 2) + "</a></li>";
				}

			} else {
				//<6
				alert("else < 6");
				for (var c = 1; c < 6; c++) {
					if (c == cpage) {
						ht += "<li class='am-active'><a href='javascript:findUsers("+c+","+info[1].id+")'>" + c
								+ "</a></li>";
					} else {
						ht += "<li><a href='javascript:findUsers("+c+","+info[1].id+")'>" + c + "</a></li>";
					}
				}
			}

			/* 	if(page > 60) {
					ht += "<li><a href='#'>"+ info[9].id%10 +"</a></li>";
				} */
			ht += " <li><a href='#'>»</a></li> "
			ht += "</ul>"
			$("#tul").append($(ht));
		}
	</script>
</body>

</html>