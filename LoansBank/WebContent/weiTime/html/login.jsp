<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>登录界面</title>
    <style>
    	#nav_mask_login .login_nav_mask{
    		margin-top:50px;
    	}
    </style>
        <link rel="stylesheet" href="../css/style.css" />
        
    
		<script src="../js/jquery-3.2.1.min.js"></script>
		<script src="../js/jquery.validate.min.js"></script>
		<script src="../js/loginandregister.js"></script>
		<script src="../js/index.js"></script>
		<script src="../js/comman.js"></script>
		<style type="text/css">
			body{
				
				background:url(../img/22.jpg) no-repeat top left;
			}
		</style>
  </head>
  	
  	
  	
  <body>
  
  	
		<div id="nav_mask_login" class="login_nav_mask">
		</div>
  	
  		
     <script type="text/javascript">
     	$(function() {
     		indexLogin();
   			$("#nav_mask_login").css({"display":"block","margin-top":"40px"});
   			$(".enroll_close").click(function(){
   				window.location.href = "/LoansBank/weiTime/html/index.jsp";
   			});
     	});
     
     
     </script>
  </body>
</html>













































