package com.coco.wust4coco.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.coco.wust4coco.beans.JsonResult;
import com.coco.wust4coco.dao.UserDAO;

public class UpdateServlet extends HttpServlet {

	/**
	 *               更新用户Servlet
	 */
	private static final long serialVersionUID = 1L;

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int oldid=Integer.parseInt(request.getParameter("id"));   //需要更新的用户id
		int newid=Integer.parseInt(request.getParameter("newid")); //新的id
		String newname=request.getParameter("newname");      //新的用户名
		String newpass=request.getParameter("newpass");      //新的密码
		
		UserDAO userdao=new UserDAO();
		
		ArrayList<JsonResult> result=new ArrayList<JsonResult>();
		JsonResult jr=new JsonResult();
		
		boolean flag=userdao.updatebyid(oldid, newid, newname, newpass);
		if(flag){
			jr.setString("success");
			jr.setStatus(0);               //更新成功
		
		}
		else
		{
			jr.setString("fail");
	    	jr.setStatus(-1);               //更新失败
		}
		Gson gb = new Gson();
		result.add(jr);
		String info=gb.toJson(result);
		response.getWriter().append(info);
		
	}

}
