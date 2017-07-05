<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="css/register-login.css">

 <script type="text/javascript">
	 function checkname(){  //失去焦点时执行的函数
	  if(user.value==""){
	   var inner=document.getElementById("in");
	   inner.innerHTML="<font color='red'>用户名为空</font>";
	  }
	  if(user.value!=""){
	    var yhm=document.getElementById("user").value;
        var reg=/^[a-zA-Z]\w{5,17}$/;
        if(reg.test(yhm)==false){
        var inner=document.getElementById("in");
	    inner.innerHTML="<font color='red'>以字母开头，长度在6-18之间，只能包含字符、数字和下划线</font>";
	    }
	    else{
	        var inner=document.getElementById("in");
	        inner.innerHTML="";
	    }
	  }
}

	  function checkpsw(){
	    if(!user.value==""){
		  	if(password.value==""){
		    var inner=document.getElementById("in");
		    inner.innerHTML="<font color='red'>密码为空</font>";
		    }
            if(password.value!=""){
	           var psd=document.getElementById("password").value;
               var reg1=/^[0-9A-Za-z]{6,}$/;
               if(reg1.test(psd)==false){
                   var inner=document.getElementById("in");
	               inner.innerHTML="<font color='red'>请输入密码长度不少于6位,并且由数字和字符组成的密码</font>";
	           }
	           else{
	               var inner=document.getElementById("in");
	               inner.innerHTML="";
	           }
	        }
         }		
}
	
		function checkrpsw(){
			if(!user.value==""&&!password.value==""){
			  if(password1.value==""){
				   var inner=document.getElementById("in");
				   inner.innerHTML="<font color='red'>确认密码为空</font>";
			  }
			  if(password.value!=password1.value){
			      var inner=document.getElementById("in");
				   inner.innerHTML="<font color='red'>密码不一致</font>";
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
  }%> 
  
  <body>
  
<div id="box"></div>
<form action="servlet/RegServlet">
<div class="cent-box register-box">
	<div class="cent-box-header">
		<h1 class="main-title hide">CoCo-Flyer</h1>
		<h2 class="sub-title">CoCo-Flyer - 爱生活爱电影</h2>
	</div>

	<div class="cont-main clearfix">
		<div class="index-tab">
			<div class="index-slide-nav">
				<a href="login.jsp">登录</a>
				<a href="register.jsp" class="active">注册</a>
				<div class="slide-bar slide-bar1"></div>				
			</div>
		</div>

		<div class="login form">
			<div class="group">
				<div class="group-ipt email">
					<input type="text"  name="username" id="user" class="ipt" placeholder="账号" onblur="checkname()" onfocus="test1()">
					
				</div>
				
				<div class="group-ipt password">
					<input type="password" name="password" id="password" class="ipt" placeholder="登录密码" onblur="checkpsw()">
				</div>
				<div class="group-ipt password1">
					<input type="password" name="password1" id="password1" class="ipt" placeholder="确认密码" onblur="checkrpsw()">
				</div>
				
			</div>
		</div>

<span id="in"></span>
		<div class="button">
	
			<button type="submit" class="login-btn register-btn" id="button" >注册</button>
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
