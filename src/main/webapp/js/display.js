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
		 var id=name=obj[0].movieid;
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
			info+="<span class='back_'><a href='javascript:deletemovie("+id+")'>[删除记录]</a></span></div>";
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

function adduser()
{

	
	$.ajax({  
		 type: "POST",  
		 url: "http://127.0.0.1:8080/wust4CoCo/servlet/AddFilmServlet",  
		 data: "newname="+$('#new_name').val()+"&newclassify="+$('#new_classify').val()+"&newactor="+$('#new_actor').val()+"&newaddress="+$('#new_address').val()+"&newurl="+$('#new_imgurl').val()+"&newintro="+$('#new_intro').val(),  
		 success: function(data){    
			 $('#addform')[0].reset();
		 var obj = JSON.parse(data); //由JSON字符串转换为JSON对象
		 if(obj[0].string=="success"&&obj[0].status==0)
			 {
			 document.getElementById("showaddresult").innerHTML="<font color='green'>添加成功!</font>";
			 }
		 else
			 document.getElementById("showaddresult").innerHTML="<font color='red'>添加失败!</font>";
			 
	    }  
	})  ;
}

/* -------------------自定义alert------------------------*/
window.alert = function(str)
{
    var shield = document.createElement("DIV");
    shield.id = "shield";
    shield.style.position = "absolute";
    shield.style.left = "50%";
    shield.style.top = "50%";
    shield.style.width = "280px";
    shield.style.height = "150px";
    shield.style.marginLeft = "-140px";
    shield.style.marginTop = "-110px";
    shield.style.zIndex = "25";
    var alertFram = document.createElement("DIV");
    alertFram.id="alertFram";
    alertFram.style.position = "absolute";
    alertFram.style.width = "280px";
    alertFram.style.height = "150px";
    alertFram.style.left = "50%";
    alertFram.style.top = "50%";
    alertFram.style.marginLeft = "-140px";
    alertFram.style.marginTop = "-110px";
    alertFram.style.textAlign = "center";
    alertFram.style.lineHeight = "150px";
    alertFram.style.zIndex = "300";
    strHtml = "<ul style=\"list-style:none;margin:0px;padding:0px;width:100%\">\n";
    strHtml += " <li style=\"background:#AAAAAA;text-align:left;padding-left:20px;font-size:14px;font-weight:bold;height:25px;line-height:25px;color:white\">[CoCo提示]</li>\n";
    strHtml += " <li style=\"background:#DDDDDD;text-align:center;font-size:18px;height:95px;line-height:95px;border-left:1px solid #F9CADE;border-right:1px solid #F9CADE;color:#666666\">"+str+"</li>\n";
    /*strHtml += " <li style=\"background:#DDDDDD;text-align:center;font-weight:bold;height:30px;line-height:25px; border:1px solid #F9CADE;\"><input type=\"button\" value=\"确 定\" onclick=\"doOk()\" style=\"width:80px;height:20px;background:#626262;color:white;border:1px solid white;font-size:14px;line-height:20px;outline:none;margin-top: 4px\"/></li>\n";*/
    strHtml += "</ul>\n";
    alertFram.innerHTML = strHtml;
    document.body.appendChild(alertFram);
    document.body.appendChild(shield);
    this.doOk = function(){
        alertFram.style.display = "none";
        shield.style.display = "none";
    }
    alertFram.focus();
    document.body.onselectstart = function(){return false;};
};
/* -------------------自定义alert------------------------*/


function deletemovie(id)
{
	$.ajax({  
		 type: "POST",  
		 url: "http://127.0.0.1:8080/wust4CoCo/servlet/DeleteFilmServlet",  
		 data:"movieid="+id,  
		 success: function(data){    
			 
		 var obj = JSON.parse(data); //由JSON字符串转换为JSON对象
		 if(obj[0].string=="success"&&obj[0].status==0)
			 {

			    alert("删除成功！");
			    
			    setTimeout("window.location='moviemanage.html'", 2000 );
			 }
		 else
			 alert("删除失败！");
			 
	    }  
	})  ;
}

