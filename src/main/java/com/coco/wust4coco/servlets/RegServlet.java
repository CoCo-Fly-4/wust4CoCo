package com.coco.wust4coco.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.coco.wust4coco.beans.JsonResult;
import com.coco.wust4coco.beans.User;
import com.coco.wust4coco.dao.UserDAO;

public class RegServlet extends HttpServlet{
	/**
	 *            用户注册Servlet         
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
			//response.setContentType("text/html");
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
		
			User user=new User();
			user.setUsername(username);  //对User进行封装
			user.setPassword(password);
			UserDAO userdao=new UserDAO();
			
			ArrayList<JsonResult> result=new ArrayList<JsonResult>();
			JsonResult jr=new JsonResult();
			
			boolean flag=userdao.addUser(user);
			
			if(flag){                           // 注册成功
				jr.setString("success");
				jr.setStatus(0);
			/*request.getSession().setAttribute("username", username);*/
			}
			else
			{                                  // 注册失败
				jr.setString("fail");
		    	jr.setStatus(-1);
			}
			Gson gb = new Gson();
			result.add(jr);
			String info=gb.toJson(result);
			response.getWriter().append(info);
			} // end service


	
}	