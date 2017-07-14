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

public class DeleteServlet extends HttpServlet {

	/**
	 *             删除用户Servlet
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id=Integer.parseInt(request.getParameter("id"));
		UserDAO userdao=new UserDAO();
		ArrayList<JsonResult> result=new ArrayList<JsonResult>();
		JsonResult jr=new JsonResult();
		
		boolean flag=userdao.delete(id);   //删除用户
		if(flag){
			jr.setString("success");
			jr.setStatus(0);
		
		}                                 //对应结果封装Jsonresult
		else
		{
			jr.setString("fail");
	    	jr.setStatus(-1);
		}
		Gson gb = new Gson();
		result.add(jr);
		String info=gb.toJson(result);
		response.getWriter().append(info);
		
	}

}
