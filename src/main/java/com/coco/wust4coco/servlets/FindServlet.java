package com.coco.wust4coco.servlets;

import java.io.IOException;

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
	 *            查找指定ID的用户Servlet
	 */
	private static final long serialVersionUID = 1L;

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id=Integer.parseInt(request.getParameter("id"));
		UserDAO userdao=new UserDAO();
		ArrayList<User> list=new ArrayList<User>();
		ResultSet rs=userdao.findUserfromid(id);
		if(rs!=null)
		{
			try {
				if(rs.next())             //结果只有一个
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
