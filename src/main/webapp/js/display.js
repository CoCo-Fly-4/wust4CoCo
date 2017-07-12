console.log("enter display");


var i=0,j=5,cur=1;


$.ajax({  
	 type: "POST",  
	 url: "http://127.0.0.1:8080/wust4CoCo/servlet/AllFilmServlet",  
	 data: $('#form').serialize(),  
	 success: function(data){    	
	 var obj = JSON.parse(data); //由JSON字符串转换为JSON对象
	 length=obj.length;
	 var inn="";
	 
	 inn+="<table class='film_tab'><tr><th>影视名称</th><th>主演</th><th>发布时间</th></tr>";
	 for(i;i<=5;i++)
		 {
		 inn+="<tr>";
		 
		 inn+="<td><font color='#9955FF'>《"+obj[i].moviename+"》</font></td>";
		 inn+="<td>"+obj[i].actor+"</td>";
		 inn+="<td><font color='#9955FF'>2017年</font></td>";
		 inn+="<td><a href='javascript:detail("+obj[i].movieid+")'>详情></a></td>";
		 inn+="</tr>"; 
		 }
	 inn+="</table>";
	 document.getElementById("showfilm").innerHTML=inn;
    }  
})  ;

function pagedown(h)
{
	console.log("总项数："+length);
	console.log("当前页面："+cur);
	document.getElementById("showfilm").innerHTML="";
	var inn="";
	if(h==-1)
	{
		console.log("点击上一页");
		if(cur==1)
		{
			i=0;
			j=5;
		}
		else if(cur==parseInt((length-1)/6)+1)
		{
			console.log("最后一页");
			j=parseInt((length-1)/6)*6-1;
			i=j-5;
			console.log("i="+i+" j="+j);
			cur--;
		}
		else
		{
			j-=6;
			i=j-5;
			cur--;
			console.log("当前页面："+cur);
		}
		console.log("i="+i+" j="+j);
	}
	else if(h==1)
	{
		console.log("点击 下一页");
		if(cur==parseInt((length-1)/6))
		{
			console.log("倒数第二页");
			j=length-1;
		    cur++;
		    console.log("i="+i+" j="+j);
		}
		else if(cur<parseInt((length-1)/6))
		   {
			console.log("cur="+cur);
			console.log("parseInt((length-1)/6)="+parseInt((length-1)/6));
			console.log("小于倒数第二页");
		     j+=6;
		     cur++;
		   }
		else if(cur==parseInt((length-1)/6)+1)
		   {
			console.log("最后一页");
		   i=parseInt((length-1)/6)*6;
		   }
		console.log("i="+i+" j="+j);
	     console.log("当前页面："+cur);
	 }
	
	$.ajax({  
		 type: "POST",  
		 url: "http://127.0.0.1:8080/wust4CoCo/servlet/AllFilmServlet",  
		 data: $('#form').serialize(),  
		 success: function(data){    	
		 var obj = JSON.parse(data); //由JSON字符串转换为JSON对象
		 length=obj.length;
		 
		 inn+="<table class='film_tab'><tr><th>影视名称</th><th>主演</th><th>发布时间</th></tr>";
		 for( i,j;i<=j;i++)
			 {
			 inn+="<tr>";
			 
			 inn+="<td><font color='#9955FF'>《"+obj[i].moviename+"》</font></td>";
			 inn+="<td>"+obj[i].actor+"</td>";
			 inn+="<td><font color='#9955FF'>2017年</font></td>";
			 inn+="<td><a href='javascript:detail("+obj[i].movieid+")'>详情></a></td>";
			 inn+="</tr>"; 
			 }
		 inn+="</table>";
		 document.getElementById("showfilm").innerHTML=inn;
	    }  
	})  ;
	
}
function detail(movieid)
{
	document.getElementById("add_button").style.display="none";
	document.getElementById("showfilm").style.display="none";
	document.getElementById("pagebutton").style.display="none";
	document.getElementById("moviedetail").style.display="";
	
	
	$.ajax({  
		 type: "POST",  
		 url: "http://127.0.0.1:8080/wust4CoCo/servlet/DetailFilmServlet?movieid="+movieid,  
		 data: $('#form').serialize(),  
		 success: function(data){    	
		 var obj = JSON.parse(data); //由JSON字符串转换为JSON对象
		
		 var name=obj[0].moviename;
		 var classify=obj[0].classify;
		 var imgurl=obj[0].imgurl;
		 var actor=obj[0].actor;
		 var intr=obj[0].introduction;
		 
		 var info="";
			
			info+="<div class='movieimg'><img src='"+imgurl+"'/></div>";
			info+="<div class='information'>";
			info+="<span class='movie_name'>《"+name+"》</span><br><br>";
			info+="<span class='else'>分类 : "+classify+"</span><br>";
			info+="<span class='else'>主演 : "+actor+"</span><br>";
			info+="<span class='else'>语言 : 国语</span><br>";
			
			info+="<span class='else'>发布日期 : 2017年 7月</span><br><br>";
			info+="<span class='else'>简介 : </span><span class='content_intro'>"+intr+"</span><br><br>";
			info+="<span class='back_'><a href=''>[返回]</a></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
			info+="<span class='back_'><a href='javascript:deletemovie()'>[删除记录]</a></span></div>";
			document.getElementById("moviedetail").innerHTML=info;
		 }
	})  ;
	
}

function addmovie1()
{
	document.getElementById("add_button").style.display="none";
	document.getElementById("showfilm").style.display="none";
	document.getElementById("pagebutton").style.display="none";
	document.getElementById("moviedetail").style.display="none";
	document.getElementById("movieadd").style.display="";
}

