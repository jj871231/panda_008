<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="images/favicon.ico">

    <title>登陆页</title>
	<script src="js/jquery.min.js" type="text/javascript"></script>
	<script src="js/jquery.cookie.js" type="text/javascript"></script>
    <link href="js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    

<style type="text/css">
    body {
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #eee;
	}

.form-signin {
  max-width: 330px;
  padding: 15px;
  margin: 0 auto;
}
.form-signin .form-signin-heading,
.form-signin .checkbox {
  margin-bottom: 10px;
}
.form-signin .checkbox {
  font-weight: normal;
}
.form-signin .form-control {
  position: relative;
  height: auto;
  -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
          box-sizing: border-box;
  padding: 10px;
  font-size: 16px;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
  </style>
  
  <script type="text/javascript">
  	$(function(){
  		//回车后登录  
	    document.onkeydown = function(e){   
	        var ev = document.all ? window.event : e;   
	        if(ev.keyCode==13) {   
	            login();  
	        }   
	    };  
	      
	    //判断之前是否有设置cookie，如果有，则设置【记住我】选择框  
	    if($.cookie('ssh_account')!=undefined){  
	        $("#rememberMe").attr("checked", true);  
	    }else{  
	        $("#rememberMe").attr("checked", false);  
	    }  
	    
	    //读取cookie  
	    if($('#rememberMe:checked').length>0){  
	        $('#account').val($.cookie('ssh_account'));  
	        $('#password').val($.cookie('ssh_password'));  
	    }  
	      
	    //监听【记住我】事件  
	    $("#rememberMe").click(function(){  
	        setOrRemoveCookies();  
	    });  
  	
  	
  	})
  	
  	//登录  
function login() {  
    var account=$("#account").val();  
    if (account == "") {  
        $("#msg").html("账号不能为空！");  
        $('#account').focus();  
        return;  
    }  
      
    var password=$("#password").val();  
    if ($("#password").val() == "") {  
        $("#msg").html("密码不能为空！");  
        $('#password').focus();  
        return;  
    }  
      
    setOrRemoveCookies();  
      
    $.ajax({  
          type: "POST",  
          url: "${ctx}/loginController/login",  
          data: "name="+account+"&password="+password,
          dataType: "json",  
          success: function(data, textStatus){   
                var tip="登录不成功！";  
                switch(data.success){  
                case "false":  
                    tip="账号或密码错误！";  
                    break;  
                
                case "true":  
                    tip="正在进入演示平台，请稍候...";  
                    
                    window.location.href ="${ctx}/loginController/toIndex";
                    break;  
                }  
                 $("#msg").html(tip);  
           },  
          beforeSend: function(formData, jqForm, options) {  
               $("#msg").html("正在登录，请稍候...");  
           },  
          async: true  
        });  
}  
  
		//判断是否勾选了【记住我】选择框，进行设置或清除Cookie  
		function setOrRemoveCookies(){  
		    if($('#rememberMe:checked').length>0){//设置cookie  
		        $.cookie('ssh_account', $('#account').val());  
		        $.cookie('ssh_password', $('#password').val());  
		    }else{//清除cookie  
		        $.removeCookie('ssh_account');  
		        $.removeCookie('ssh_password');  
		    }  
		} 
    
    
  
  </script>
    
  </head>

  <body>

    <div class="container">

      <form class="form-signin">
        <h2 class="form-signin-heading">请登录</h2>
        <label for="account" class="sr-only">用户名</label>
        <input type="text" id=account class="form-control" placeholder="用户名" required autofocus>
        <label for="password" class="sr-only">密码</label>
        <input type="password" id="password" class="form-control" placeholder="密码" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" id="rememberMe"> 记住我
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="button" onclick="login();">登陆</button>
      </form>
      <span id="msg"></span>

    </div> <!-- /container -->

  </body>
</html>
