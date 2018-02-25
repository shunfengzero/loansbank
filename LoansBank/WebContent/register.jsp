<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<!-- <script type="text/javascript" src="js/common.js"></script> -->
<!-- <script type="text/javascript" src="js/jquery-1.7.2.js"></script> -->
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<!-- <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script> -->

<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>



</head>
<body>
	<div id="header" class="wrap">
	<div id="logo">注册信息</div>
	<div id="navbar">
		<form method="get" name="search" action="">
			搜索：<input class="input-text" type="text" name="keywords" /><input class="input-btn" type="submit" name="submit" value="" />
		</form>
	</div>
</div>
<div id="register">
	<div class="title">
		<h2>欢迎注册</h2>
	</div>
	<div class="steps">
		<ul class="clearfix">
			<li class="current">1.填写注册信息</li>
			<li class="unpass">2.注册成功</li>
		</ul>
	</div>
	<form id="regForm" method="post" action="register_success.html" >
		<dl>
			<dt>用 户 名：</dt>
			<dd><input class="input-text" type="text" name="userName" /></dd>
			<dt>密　　码：</dt>
			<dd><input id="passWord" class="input-text" type="passWord" name="passWord" /></dd>
			<dt>确认密码：</dt>
			<dd><input id="rePassWord" class="input-text" type="passWord" name="rePassWord" /></dd>
			<dt>真实姓名：</dt>
			<dd><input class="input-text" type="text" name="realName" /></dd>
			<dt>性别：</dt>
			<dd><input class="input-text" type="radio" name="gender" value="男"/>男</dd>
			<dd><input class="input-text" type="radio" name="gender" value="女"/>女</dd>
			<dt>Email地址：</dt>
			<dd><input class="input-text" type="text" name="email" /></dd>
			<dt>电话：</dt>
			<dd><input class="input-text" type="text" name="telePhone" /></dd>
			<dt>地址：</dt>
			<dd><input class="input-text" type="text" name="address" /></dd>
			
			<dt>图片：</dt>
			<dd><input type="file" id="file1" name="file" /></dd>
			<dd><input id="upd" type="button" value="上传" /></dd>
			<dd><img id="img1"  src="" /></dd>
			<input id="url" type="hidden" value="" name="idImg"/>
			<dt></dt>
			<dd class="button2"><input class="input-reg" type="submit" name="register" /></dd>
		</dl>
	</form>
</div>
<div id="footer" class="wrap">
	XXXXXXXXX &copy; 版权所有

</div>

	<script type="text/javascript">

		$(function(){
			 
			$(":button").click(function () {
			
                ajaxFileUpload();
            })
            
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
		
		
		function ajaxFileUpload() {
            $.ajaxFileUpload
            (
                {
                    url: "upload.action", //用于文件上传的服务器端请求地址
                    secureuri: false, //是否需要安全协议，一般设置为false
                    fileElementId: 'file1', //文件上传域的ID
                    dataType: 'json', //返回值类型 一般设置为json
                    success: function (data)  //服务器成功响应处理函数
                    {
                    	alert(data);
                    	if (data.code == 0) {
                    		alert(data.msg);
                    	} else {
                    		
                    	var d = data.msg;
                    	alert(d);
                        $("#img1").attr("src", d);
                        $("#url").attr("value",d);
                    	}
                    },
                    error: function (data, status, e)//服务器响应失败处理函数
                    {
                        alert(e);
                    }
                }
            )
            return false;
        }
		
		
	</script>


</body>
</html>