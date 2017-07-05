<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录 - CoCo-Flyer Movie Factory</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<link rel="stylesheet" type="text/css" href="css/register-login.css">
	
	<script type="text/javascript" language="javascript">
	 function checkname(){  //失去焦点时执行的函数
	  if(user.value==""){
	   /* document.getElementById("show").style.visibility="visible";
	   show.value = "用户名不能为空" ; */
	   var inner=document.getElementById("in");
	   inner.innerHTML="<font color='red'>用户名为空</font>";
	  }
	  else{
	  var inner=document.getElementById("in");
	   inner.innerHTML="";
	  }
	  function test1(){  //获得焦点时执行的函数	 
	   show.value ="" ;
	 }
}

	  function checkpsw(){
	    if(!user.value==""){
		  	if(password.value==""){
		    var inner=document.getElementById("in");
		    inner.innerHTML="<font color='red'>密码为空</font>";
		  }
		  else{
		  var inner=document.getElementById("in");
		   inner.innerHTML="";
		  }
		}		
		else{
		}
	}
</script>
  </head>
  
     <%
String errMsg=(String)session.getAttribute("err");
if( errMsg!=null ) { %>
<div style="color:red;"><%=errMsg %></div>
<% session.removeAttribute("err");
} %>
  
  <body>
   

<div id="box"></div>
<form action="servlet/LoginServlet">
<div class="cent-box register-box">
	<div class="cent-box-header">
		<h1 class="main-title hide">CoCo-Flyer</h1>
		<h2 class="sub-title">CoCo-Flyer - 爱生活爱电影</h2>
	</div>

	<div class="cont-main clearfix">
		<div class="index-tab">
			<div class="index-slide-nav">
				<a href="login.jsp" class="active">登录</a>
				<a href="register.jsp">注册</a>
				<div class="slide-bar"></div>				
			</div>
		</div>

		<div class="login form">
			<div class="group">
				<div class="group-ipt email">
					<input type="text" name="username" id="user" class="ipt" placeholder="账号" onblur="checkname()" onfocus="test1()">
				</div>
				<div class="group-ipt password">
					<input type="password" name="password" id="password" class="ipt" placeholder="登录密码" onblur="checkpsw()">
				</div>
				
			</div>
		</div>
<span id="in"></span>
		<div class="button">
			<button type="submit" class="login-btn register-btn" id="button">登录</button>
		</div>

		<div class="remember clearfix">
			<label class="remember-me"><span class="icon"><span class="zt"></span></span><input type="checkbox" name="remember-me" id="remember-me" class="remember-mecheck" checked>记住我</label>
			<label class="forgot-password">
				<a href="#">忘记密码？</a>
			</label>
		</div>
	</div>
</div>
</form>
<div class="footer">
	<p>CoCo-Flyer - 爱生活爱电影</p>

</div>

<script src='js/particles.js' type="text/javascript"></script>
<script src='js/background.js' type="text/javascript"></script>
<script src='js/jquery.min.js' type="text/javascript"></script>
<script src='js/layer/layer.js' type="text/javascript"></script>
<script src='js/index.js' type="text/javascript"></script>



  </body>
</html>
