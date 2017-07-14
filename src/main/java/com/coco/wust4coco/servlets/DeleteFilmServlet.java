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

public class DeleteFilmServlet extends HttpServlet {

	/**
	 *              删除影视Servlet
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                                                       //获得影视ID
		int movieid=Integer.parseInt(request.getParameter("movieid"));
		FilmDAO filmdao=new FilmDAO();
		ArrayList<JsonResult> result=new ArrayList<JsonResult>();
		JsonResult jr=new JsonResult();
		boolean flag=filmdao.deletemovie(movieid);  //删除影视
		if(flag)
		{                                       
			jr.setString("success");
			jr.setStatus(0);
		}                                      //对应结果封装Jsonresult
		else{
			jr.setString("fail");
			jr.setStatus(-1);
		}
		
		Gson gb = new Gson();
		result.add(jr);                      
		String info=gb.toJson(result);
		response.getWriter().append(info);
	}
	

}
