package com.coco.wust4coco.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.coco.wust4coco.beans.User;
import com.coco.wust4coco.dao.UserDAO;

public class FindServlet extends HttpServlet {

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

		int id=Integer.parseInt(request.getParameter("id"));
		UserDAO userdao=new UserDAO();
		ArrayList<User> list=new ArrayList<User>();
		ResultSet rs=userdao.findUserfromid(id);
		if(rs!=null)
		{
			try {
				if(rs.next())
				{
					User user=new User();
					user.setId(Integer.parseInt(rs.getString("id")));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					list.add(user);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Gson gb = new Gson();
		String info=gb.toJson(list);
		response.getWriter().append(info);
		
	}

}
