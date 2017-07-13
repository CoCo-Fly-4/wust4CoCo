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

public class LoginServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
			System.out.println("进入LoginServlet");
			System.out.println("in loginservlet:");
			System.out.println("username="+username);
			
			
			UserDAO userdao=new UserDAO();
			ArrayList<JsonResult> result=new ArrayList<JsonResult>();
			JsonResult jr=new JsonResult();
			
			boolean flag=userdao.findUser(username, password);
			if( flag ) {		
				   if(username.equals("cocoadmin"))
				   {
					   jr.setString("admin");
					    jr.setStatus(0);
					    System.out.println("jr=admin");
				   }
				   else{
					jr.setString("success");
				    jr.setStatus(0);
				    System.out.println("jr=success");
				   }
				    request.getSession().setAttribute("username", username);
				}
				else{
				jr.setString("fail");
				jr.setStatus(-1);
				System.out.println("jr=fail");
				request.getSession().setAttribute("username", "null");
				}
				
				
			Gson gb = new Gson();
			result.add(jr);
			String info=gb.toJson(result);
			response.getWriter().append(info);
			} 

}
