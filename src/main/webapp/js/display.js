console.log("enter display");

var inn="";



$.ajax({  
	 type: "POST",  
	 url: "http://127.0.0.1:8080/wust4CoCo/servlet/AllFilmServlet",  
	 data: $('#form').serialize(),  
	 success: function(data){    	
	 var obj = JSON.parse(data); //由JSON字符串转换为JSON对象
	 inn+="<div class='addfilm'><span class='add_film'>添加视频</span></div>";
	 inn+="<table class='film_tab'><tr><th>影视名称</th><th>主演</th><th>发布时间</th></tr>";
	 for(var o in obj)
		 {
		 inn+="<tr>";
		 
		 inn+="<td>"+obj[o].moviename+"</td>";
		 inn+="<td>"+obj[o].actor+"</td>";
		 inn+="<td>2017年</td>";
		 inn+="<td><a href='javascript:detail("+obj[0].movieid+")'>详情</a></td>";
		 inn+="</tr>"; 
		 }
	 document.getElementById("showfilm").innerHTML=inn;
    }  
})  ;


function detail(movieid)
{
	document.getElementById("showfilm").style.display="none";
	document.getElementById("moviedetail").style.display="";
	
	$.ajax({  
		 type: "GET",  
		 url: "http://127.0.0.1:8080/wust4CoCo/servlet/DetailFilmServlet?movieid="+movieid,  
		 data: $('#form').serialize(),  
		 success: function(data){    	
		 var obj = JSON.parse(data); //由JSON字符串转换为JSON对象
		
		 var name=obj[0].moviename;
		 var classify=obj[0].classify;
		 var imgurl=obj[0].imgurl;
		 var actor=obj[0].actor;
		 
		 var info="";
			info+="<a href=''>返回</a><br>";
			info+="<div class=''><img src='"+imgurl+"'/></div>";
			info+="<div class=''>";
			info+="<span class=''>"+name+"</span>";
			info+="<span class=''>分类:"+classify+"</span>";
			info+="<span class=''>主演:"+actor+"</span>";
			info+="<span class=''>发布日期:2017</span></div>";
			info+="<div class=''><span>修改信息<span><span>删除记录</span></div>";
			document.getElementById("moviedetail").innerTHML=info;
		 }
	})  ;
	
	
	
}

