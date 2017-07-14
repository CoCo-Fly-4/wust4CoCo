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

public class SortServlet extends HttpServlet {

	/**
	 *        用户字母排序Servlet
	 */
	private static final long serialVersionUID = 1L;

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                                                          //定义字母数组
		String[] words={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		
		String word=request.getParameter("word");  //获取参数 字母标号
		int num=Integer.parseInt(word);
		UserDAO userdao=new UserDAO();
		ArrayList<User> list=new ArrayList<User>();
		
		String s1=words[num-1];          //数据库查询 需要的两个字母        
		String s2=words[num];              
		
		ResultSet rs=userdao.findbyword(s1, s2);
		
		if(rs!=null)
		{
			
			try {
				while(rs.next())          //遍历结果集
				{
					System.out.println(Integer.parseInt(rs.getString("id"))+" "+rs.getString("username")+" "+rs.getString("password"));
					User user=new User();
					user.setId(Integer.parseInt(rs.getString("id")));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					
					list.add(user);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("That's all !");
				e.printStackTrace();
			} 
		
		}
		else{
			System.out.println("list user null");
		}
		
		Gson gb = new Gson();
		String info=gb.toJson(list);
		response.getWriter().append(info);
	}

}
