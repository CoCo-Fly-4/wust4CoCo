package com.coco.wust4coco.servlets;

import java.io.IOException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coco.wust4coco.beans.Film;
import com.coco.wust4coco.dao.FilmDAO;
import com.google.gson.Gson;


public class AllFilmServlet extends HttpServlet {

	/**
	 *             查询所有影视Servlet
	 */
	private static final long serialVersionUID = 1L;

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");    //设置字符编码为utf-8
		FilmDAO filmdao=new FilmDAO();
		ArrayList<Film> list=new ArrayList<Film>();
		ResultSet rs=filmdao.allfilm();
		
		if(rs!=null)
		{
			try {
				while(rs.next())        //对结果集进行遍历
				{
					Film film=new Film();
					film.setMovieid(Integer.parseInt(rs.getString("movieid")));
					film.setMoviename(rs.getString("moviename"));
					film.setClassify(rs.getString("classify"));
					film.setActor(rs.getString("actor"));
					film.setAddress(rs.getString("address"));
					film.setImgurl(rs.getString("imgurl"));
					film.setIntroduction(rs.getString("introduction"));
					System.out.println("moviename:"+rs.getString("moviename"));
					list.add(film);   //添加到list
					
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		Gson gb = new Gson();        
		String info=gb.toJson(list);         //将查询结果转化为Json集 并返回
		response.getWriter().append(info);
	}

}
