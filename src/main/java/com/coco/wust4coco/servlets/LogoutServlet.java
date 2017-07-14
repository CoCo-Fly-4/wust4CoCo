package com.coco.wust4coco.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.coco.wust4coco.beans.JsonResult;

public class LogoutServlet extends HttpServlet {

	/**
	 *         用户注销Servlet
	 */
	private static final long serialVersionUID = 1L;

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");   //设置字符编码
			
		request.getSession().setAttribute("username", "null");  //将session标志改为null
		System.out.println("Logout: session="+request.getSession().getAttribute("username"));	
        ArrayList<JsonResult> result=new ArrayList<JsonResult>();	
		JsonResult jr=new JsonResult();
		jr.setString("success");
		jr.setStatus(0);                     //返回结果集
		Gson gb = new Gson();
		result.add(jr);
		String info=gb.toJson(result);
		response.getWriter().append(info);
		
		
	}

}
