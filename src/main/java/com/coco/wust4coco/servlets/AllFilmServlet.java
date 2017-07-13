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

import com.coco.wust4coco.beans.Film;
import com.coco.wust4coco.dao.FilmDAO;
import com.google.gson.Gson;


public class AllFilmServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		FilmDAO filmdao=new FilmDAO();
		ArrayList<Film> list=new ArrayList<Film>();
		ResultSet rs=filmdao.allfilm();
		
		if(rs!=null)
		{
			try {
				while(rs.next())
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
					list.add(film);
					
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
		String info=gb.toJson(list);
		response.getWriter().append(info);
	}

}
