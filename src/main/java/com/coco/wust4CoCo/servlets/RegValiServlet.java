package com.coco.wust4CoCo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


import com.coco.wust4CoCo.beans.JsonResult;

import com.coco.wust4CoCo.dao.UserDAO;

public class RegValiServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	
	public RegValiServlet() {
	       super();
	   }

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
   
		
		response.setCharacterEncoding("UTF-8");
		String username=request.getParameter("username");
		
		System.out.println(username);
		
		
		UserDAO userdao=new UserDAO();
		
	
		
		ArrayList<JsonResult> result=new ArrayList<JsonResult>();
		
		JsonResult jr=new JsonResult();
	/*	StringBuilder sb = new StringBuilder();*/
		if( userdao.isUsernameExists(username) ){	
	    	
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
