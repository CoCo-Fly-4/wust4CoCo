
var i=0,l=5;
var cur;

function adduser()
{

	$.ajax({  
		 type: "POST",  
		 url: "/wust4CoCo/servlet/RegServlet",  
		 data: "username="+$('#newusername').val()+"&password="+$('#newpassword').val(),  
		 success: function(data){    	
		 var obj = JSON.parse(data); //由JSON字符串转换为JSON对象
		 if(obj[0].string=="success"&&obj[0].status==0)
			 document.getElementById("myresult").innerHTML="<font color='green'>添加成功！</font>";
	    else
			   document.getElementById("myresult").innerHTML="<font color='red'>添加失败！</font>";
         }  
 })  ;
}
var id;
function showinfo(num)
{
	
	if(num==2)
	 id=document.getElementById("delete_id").value;
	if(num==1)
	 id=document.getElementById("number").value;
	$.ajax({  
		 type: "POST",  
		 url: "/wust4CoCo/servlet/FindServlet",  
		 data: "id="+id,  
		 success: function(data){    	
		 var obj = JSON.parse(data); //由JSON字符串转换为JSON对象
		 if(num==2){
			 console.log("删除用户："+obj.length);
			 if(obj.length==0){
				 document.getElementById("myresult_").innerHTML="<font color='red'>用户不存在！</font>"; 
				 document.getElementById("delete_username").value="";
				document.getElementById("delete_password").value="";
			 }
			 else{
			document.getElementById("delete_username").value=obj[0].username;
			document.getElementById("delete_password").value=obj[0].password;
			 }
		 }
		 if(num==1){
			 if(obj.length==0)
				 {
				 document.getElementById("myresult__").innerHTML="<font color='red'>Not find</font>";
					document.getElementById("ddd").value="";
				 	 document.getElementById("ppp").value="";
					document.getElementById("dd").value="";
					document.getElementById("nn").value="";
					document.getElementById("pp").value="";
				 }
			 else{
			 document.getElementById("myresult__").innerHTML="";
			document.getElementById("ddd").value="";
			document.getElementById("nnn").value="";
		 	 document.getElementById("ppp").value="";
			document.getElementById("dd").value=obj[0].id;
			document.getElementById("nn").value=obj[0].username;
			document.getElementById("pp").value=obj[0].password;
			 }
		 }
	    
        }  
})  ;
	
}

function dish()
{
	document.getElementById("myresult_").innerHTML="";
}

function deleteuser()
{
	
	$.ajax({  
		 type: "POST",  
		 url: "/wust4CoCo/servlet/DeleteServlet",  
		 data: "id="+$('#delete_id').val(),  
		 success: function(data){    	
		 var obj = JSON.parse(data); //由JSON字符串转换为JSON对象
		 if(obj[0].string=="success"&&obj[0].status==0)
			 {
			 document.getElementById("myresult_").innerHTML="<font color='green'>删除成功</font>";
			 document.getElementById("delete_id").value="";
			 document.getElementById("delete_username").value="";
			 document.getElementById("delete_password").value="";
			 }
		 else
			 {
			 document.getElementById("myresult_").innerHTML="<font color='red'>删除失败</font>";
			 }
	    
       }  
})  ;
	
}

function updateuser()
{
	
	$.ajax({  
		 type: "POST",  
		 url: "/wust4CoCo/servlet/UpdateServlet",  
		 data: "id="+$('#number').val()+"&newid="+$('#ddd').val()+"&newname="+$('#nnn').val()+"&newpass="+$('#ppp').val(),  
		 success: function(data){    	
		 var obj = JSON.parse(data); //由JSON字符串转换为JSON对象
		 if(obj[0].string=="success"&&obj[0].status==0)
			 {
			 document.getElementById("myresult__").innerHTML="<font color='green'>成功</font>";
			 
			 }
		 else
			 {
			 document.getElementById("myresult__").innerHTML="<font color='red'>失败</font>";
			 }
	    
      }  
})  ;
	
}


function page(s) {
	var sto=document.getElementById("sto_num");
  	var d1=sto.innerHTML;
  	var pagenum=document.getElementById("page_num");
  	var page=pagenum.innerHTML;
  	console.log("总项数："+page);
	console.log("当前页面："+cur);
	if (s == -1) {
		console.log("点击上一页");
		
		if(cur==1)
		{
			i=0;
			l=5;
		}
		if(cur>1)
	{
			console.log("cur="+cur);
			console.log("parseInt((page-1)/5)="+parseInt((page-1)/5));
		 if(cur==parseInt((page-1)/5)+1)
			{
			 console.log("最后一页");
			 
			l=parseInt((page-1)/5)*5;
			
			i=l-5;
			console.log("i="+i+" l="+l);
			cur--;
			}
	   else
	   {
		l-= 5;
		i=l-5;
		cur--;
		console.log("当前页面："+cur);
	    }
     console.log("i="+i+" l="+l);
	} 
	}
	if (s == 1) {
		console.log("点击 下一页");
		if(cur==parseInt((page-1)/5))
			{
			console.log("倒数第二页");
			l=page;
			cur++;
			}
		if(cur<parseInt((page-1)/5))
			{
			console.log("cur="+cur);
			console.log("parseInt((page-1)/5)="+parseInt((page-1)/5));
			console.log("小于倒数第二页");
			l+=5;
			cur++;
			}
		if(cur==parseInt((page-1)/5+1))
			{
			console.log("最后一页");
			i=parseInt((page-1)/5)*5;
			}
     console.log("i="+i+" l="+l);
     console.log("当前页面："+cur);
     
	}
	
	$.ajax({  
        type: "POST",  
        url: "/wust4CoCo/servlet/SortServlet?word="+d1,  
        data: $('#form').serialize(),  
        success: function success(data){    	
        	var o = JSON.parse(data);
        	var string="";
    	 	string+="<table class='table_order'>";
    	 	string+="<tr><th>UserId</th><th>Username</th><th>Password</th></tr>";

    	 		for( i,l;i<l;i++)
    	 			{
    	 			console.log(o[i].id+" && "+o[i].username);
    	 			string+="<tr>";
    	  			string+="<td>"+o[i].id+"</td>"; 
    	  			string+="<td>"+o[i].username+"</td>"; 
    	  			string+="<td>"+o[i].password+"</td>"; 
    	  			string+="</tr>";
    	  			
    	 			}

    	  	string+="</table>";
    	  	var con=document.getElementById("order_result");
    	  	con.innerHTML=string;
        }
});
	}		
function wsort(d1)
{
	i=0;l=5;cur=1;
	$.ajax({  
        type: "POST",  
        url: "/wust4CoCo/servlet/SortServlet?word="+d1,  
        data: $('#form').serialize(),  
        success: function success(data){    	
        	var o = JSON.parse(data);
        	if(o.length<5)
        		{
        		var string="";
        	 	string+="<table class='table_order'>";
        	 	string+="<tr><th>UserId</th><th>Username</th><th>Password</th></tr>";
        		for(var obj in o)
        			{
        			string+="<tr>";
    	  			string+="<td>"+o[obj].id+"</td>"; 
    	  			string+="<td>"+o[obj].username+"</td>"; 
    	  			string+="<td>"+o[obj].password+"</td>"; 
    	  			string+="</tr>";
        			}
        		string+="</table>";
        		var con=document.getElementById("order_result");
        	  	con.innerHTML=string;
        	  	var sto=document.getElementById("sto_num");
        	  	sto.innerHTML=d1;
        	  	var sto=document.getElementById("page_num");
        	  	sto.innerHTML=o.length;
        		}
        	else{
        	var string="";
    	 	string+="<table class='table_order'>";
    	 	string+="<tr><th>UserId</th><th>Username</th><th>Password</th></tr>";

    	 		for( i,l;i<l;i++)
    	 			{
    	 			console.log(o[i].id+" && "+o[i].username);
    	 			string+="<tr>";
    	  			string+="<td>"+o[i].id+"</td>"; 
    	  			string+="<td>"+o[i].username+"</td>"; 
    	  			string+="<td>"+o[i].password+"</td>"; 
    	  			string+="</tr>";
    	  			
    	 			}

    	  	string+="</table>";
    	  	var con=document.getElementById("order_result");
    	  	con.innerHTML=string;
    	  	var sto=document.getElementById("sto_num");
    	  	sto.innerHTML=d1;
    	  	var sto=document.getElementById("page_num");
    	  	sto.innerHTML=o.length;
        	
        }
        }
        });	 
	  	
}     


function changesheet(sheet)
{
	var s1=document.getElementById("sheet1");
	var s2=document.getElementById("sheet2");
	var s3=document.getElementById("sheet3");
	var s4=document.getElementById("sheet4");
	if(sheet==1)
	{
		s1.style.display="";
		s2.style.display="none";
		s3.style.display="none";
		s4.style.display="none";
	}
	if(sheet==2)
	{
		s1.style.display="none";
		s2.style.display="";
		s3.style.display="none";
		s4.style.display="none";
	}
	if(sheet==3)
	{
		s1.style.display="none";
		s2.style.display="none";
		s3.style.display="";
		s4.style.display="none";
	}
	if(sheet==4)
	{
		s1.style.display="none";
		s2.style.display="none";
		s3.style.display="none";
		s4.style.display="";
	}
}


      
