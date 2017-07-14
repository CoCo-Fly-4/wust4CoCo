package com.coco.wust4coco.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coco.wust4coco.beans.JsonResult;
import com.google.gson.Gson;

public class SessionServlet extends HttpServlet {

	/**
	 *         返回Session值和项目地址
	 */
	private static final long serialVersionUID = 1L;


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String session=(String)request.getSession().getAttribute("username");
		String Apath=request.getContextPath();
		ArrayList<JsonResult> result=new ArrayList<JsonResult>();
		JsonResult jr=new JsonResult();
		jr.setString(Apath);          //加入项目路径
		jr.setPdata(session);         //加入session中的用户标志
		jr.setStatus(0);              //设置状态字
		Gson gb = new Gson();
		result.add(jr);
		String info=gb.toJson(result);          //转化为Json 返回
		response.getWriter().append(info);
	}

}
