package com.coco.wust4coco.servlets;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.coco.wust4coco.beans.JsonResult;
import com.coco.wust4coco.dao.FilmDAO;
import com.google.gson.Gson;

public class AddFilmServlet extends HttpServlet {

	/**
	 *              添加影视Servlet
	 */
	private static final long serialVersionUID = -5664298328837067410L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String moviename=request.getParameter("newname");     //新的影视名称
		String classify=request.getParameter("newclassify");   //新的影视分类
		String newactor=request.getParameter("newactor");     //新的影视主演
		String newaddress=request.getParameter("newaddress");  //新的影视播放地址
		String newurl=request.getParameter("newurl");         //新的影视图片链接
		String newintro=request.getParameter("newintro");    //新的影视简介
		
		FilmDAO filmdao=new FilmDAO();
		ArrayList<JsonResult> result=new ArrayList<JsonResult>();
		JsonResult jr=new JsonResult();
		boolean flag=filmdao.addmovie(moviename, classify, newactor, newaddress, newurl, newintro);
		
		if(flag)          //添加成功
		{
			jr.setString("success");
			jr.setStatus(0);
		}                                        /* 封装Jsonresult*/
		else{             //添加失败
			jr.setString("fail");
			jr.setStatus(-1);
		}
		
		Gson gb = new Gson();
		result.add(jr);
		String info=gb.toJson(result);         //转化为Json数据 并返回
		response.getWriter().append(info);
	}

}
