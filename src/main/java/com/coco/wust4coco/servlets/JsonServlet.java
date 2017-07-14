package com.coco.wust4coco.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JsonServlet extends HttpServlet {


   /**
	 *          测试Json的Servlet
	 */
	private static final long serialVersionUID = 1L;

/**
    * @see HttpServlet#HttpServlet()
    */
   public JsonServlet() {
       super();
   }

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
    	StringBuilder sb = new StringBuilder();
    	
    	response.setContentType("text/json");
    	
    	sb.append("Group: CoCo-Fly  |  Member: CoCo & jjj & kunkun & ruirui");    	
    	
		response.getWriter().append(sb.toString());
		//response.flushBuffer();

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
