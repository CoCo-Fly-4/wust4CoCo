
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
	            url: "http://127.0.0.1:8080/wust4CoCo/servlet/LogoutServlet",  
	            data: $('#form').serialize(),  
	            success: function(data){    	
	            	var obj = JSON.parse(data);
	            	
	                   if(obj[0].string=="success"&&obj[0].status==0)
	                   {
	                	   console.log("注销成功");
	                	   window.location.href="index.html";
	                   }
	                 else
	                	   console.log("注销失败");
	                	 
	            }  
	        })  ;      
 
        }	  
   
   
   function autho1()
   {
	   var username=GetQueryString("username");
	     $.ajax({  
	            type: "POST",  
	            url: "http://127.0.0.1:8080/wust4CoCo/servlet/WelValiServlet?username="+username,  
	            data: $('#form').serialize(),  
	            success: function(data){    	
	            	var obj = JSON.parse(data);
	            	console.log("返回字符："+obj[0].string);
	            	console.log("返回状态："+obj[0].status);
	            	console.log("返回数据："+obj[0].Pdata);
	                   if(obj[0].string=="index"&&obj[0].status==0)
	                	   console.log("index---");
	                  else if(obj[0].string=="index?"&&obj[0].status==0)
	                      window.location.href="index.html?username="+obj[0].Pdata;
	                  else if(obj[0].string=="admin"&&obj[0].status==0)
	                      window.location.href="admincoco.html";
	                    else
	                	   window.location.href="err.html";
	                	 
	            }  
	        })  ;      
   }
   
   function autho2()
   {
	   var username=GetQueryString("username");
       $.ajax({  
          type: "POST",  
          url: "http://127.0.0.1:8080/wust4CoCo/servlet/WelValiServlet?username="+username,  
          data: $('#form').serialize(),  
          success: function(data){    	
          	var obj = JSON.parse(data);
          	
                 if(obj[0].string=="admin"&&obj[0].status==0)
              	   console.log("权限验证通过");
               else
               {    
                         
              	   window.location.href="err.html";
               }
              	 
          }  
      })  ;      
   }