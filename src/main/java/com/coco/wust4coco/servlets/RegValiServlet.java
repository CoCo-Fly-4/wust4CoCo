package com.coco.wust4coco.servlets;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.coco.wust4coco.beans.JsonResult;
import com.coco.wust4coco.dao.UserDAO;

public class RegValiServlet extends HttpServlet {

	/**
	 *           注册  用户名重复验证
	 */
	private static final long serialVersionUID = 1L;


	public RegValiServlet() {
	       super();
	   }

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
   
		
		response.setCharacterEncoding("UTF-8");
		String username=request.getParameter("username");

		UserDAO userdao=new UserDAO();

		ArrayList<JsonResult> result=new ArrayList<JsonResult>();
		
		JsonResult jr=new JsonResult();
	/*	StringBuilder sb = new StringBuilder();*/
		if( userdao.isUsernameExists(username) ){	//指定用户是否存在
	    	
	    	jr.setString("fail");
	    	jr.setStatus(-1);
	    	System.out.println("用户名不可用");
		}
		else if(username!=null)
			
		{
			jr.setString("success");
			jr.setStatus(0);
			
			
			System.out.println("用户名可用");
		}
		Gson gb = new Gson();
		result.add(jr);
		String info=gb.toJson(result);
		response.getWriter().append(info);
	}

}
