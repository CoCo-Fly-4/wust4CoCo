package com.coco.wust4CoCo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FilmDAO {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/coco";
	
	public static final String DBUSER = "root";
	public static final String DBPASS = "admin";

	private Connection conn = null;
	private PreparedStatement pStat = null;
	private ResultSet rs = null;
	
	public Connection getConnectionn() {
		try {
			Class.forName(DRIVER).newInstance();
			return DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (Exception e) {
			System.out.println("连接错误！");
			e.printStackTrace();
			return null;
		}
	}
	
	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (pStat != null)
				pStat.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end close
	
	
public ResultSet allfilm() {
		
		conn = getConnectionn();
		try {
		pStat = conn.prepareStatement("select * from movie");
	//	int cnt = pStat.executeUpdate();
		ResultSet rs=pStat.executeQuery( );
		if (rs!=null)
			return rs;
		else
			return null;
		} catch (Exception e) {
			System.out.println("查询所有电影错误！");
			return null;
		} finally {
			
		}
	}  //end allfilm()

public ResultSet findmovie(int id){
	conn = getConnectionn();
	try{
	pStat = conn.prepareStatement("select * from movie where movieid=?");
	pStat.setInt(1,id);
	ResultSet rs=pStat.executeQuery( );
	if (rs!=null)
		return rs;
	else
		return null;
	}catch(Exception e){
		e.printStackTrace();
		return null;
	}
}



}



