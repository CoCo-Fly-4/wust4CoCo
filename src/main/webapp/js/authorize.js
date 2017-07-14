
function GetQueryString(name)
            {
		     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		     var r = window.location.search.substr(1).match(reg);
		     if(r!=null)return  unescape(r[2]); return null;
		     }
		     
   function logout()
   {
	   
      $.ajax({  
	            type: "POST",  
	            url: "/wust4CoCo/servlet/LogoutServlet",  
	            data: $('#form').serialize(),  
	            success: function(data){    	
	            	var obj = JSON.parse(data);
	            	
	                   if(obj[0].string=="success"&&obj[0].status==0)
	                   {
	                	   console.log("注销成功");
	                	   window.location.href="login.html";
	                   }
	                 else
	                	   console.log("注销失败");
	                	 
	            }  
	        })  ;      
 
        }	  
   
   function getsession()
   {
	   
	    $.ajax({  
          type: "POST",  
          url: "/wust4CoCo/servlet/SessionServlet",  
          data: $('#form').serialize(),  
          success: function(data){    	
          	var obj = JSON.parse(data);
          	console.log("getsession:"+obj[0].Pdata);
             var real= obj[0].Pdata;
             if(real=="null"||real==undefined)
            	 document.getElementById("info").innerHTML="<font size='4' color='black'>未登录</font>";
             else if(real=="cocoadmin")
                  window.location="admincoco.html";
             else
            	 document.getElementById("info").innerHTML="<font size='3'>"+real+" ， 您已登录 <a href='javascript:logout()'>注销</a></font>";
             
          }  
      })  ;   
	    
	   
  }
   
  