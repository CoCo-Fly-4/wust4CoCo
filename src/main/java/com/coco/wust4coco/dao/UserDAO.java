package com.coco.wust4coco.dao;

import java.sql.*;

import com.coco.wust4coco.beans.User;

public class UserDAO {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/coco";
	public static final String DBURL2 = "jdbc:mysql://localhost:3306/mobiledb";
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
	
	public Connection getConnectionn2() {
		try {
			Class.forName(DRIVER).newInstance();
			return DriverManager.getConnection(DBURL2, DBUSER, DBPASS);
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

	public boolean isUsernameExists(String username) {

		conn = getConnectionn();
		try {
			pStat = conn
					.prepareStatement("select * from user where username=?");
			pStat.setString(1, username);
			rs = pStat.executeQuery();
			if (rs.next())
				return true;
			else

				return false;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查重出错！");
			return false;
		} finally {
			close();

		} // end isUsernameExists
	}
	public ResultSet findUserfromid(int id) {
		conn = getConnectionn();
		try{
			pStat = conn.prepareStatement("select * from user where id=?");
			pStat.setInt(1, id);
			rs = pStat.executeQuery();
			if (rs!=null)
				return rs;
			else

				return null;
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("查id出错！");
			return null;
		} finally {
		      
		}
		
	}
	public boolean findUser(String username, String password) {
		conn = getConnectionn();
		try {
			pStat = conn
					.prepareStatement("select * from user where username=? and password=?");
			pStat.setString(1, username);
			pStat.setString(2, password);
			rs = pStat.executeQuery();
			if (rs.next())
				return true;
			else

				return false;
		} catch (Exception e) {
			System.out.println("登录查找错误！");
			return false;
		} finally {
			close();
		}
	} // end findUser

	public boolean addUser(User user) {

		conn = getConnectionn();
		try {
			pStat = conn.prepareStatement("insert into user values(null,?,?)");
			pStat.setString(1, user.getUsername());
			pStat.setString(2, user.getPassword());
			int cnt = pStat.executeUpdate();
			if (cnt > 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			System.out.println("插入错误！");
			return false;
		} finally {
			close();
		}
	} // end addUser
	
	public ResultSet alluser() {
		
		conn = getConnectionn();
		try {
		pStat = conn.prepareStatement("select * from user");
	//	int cnt = pStat.executeUpdate();
		ResultSet rs=pStat.executeQuery( );
		if (rs!=null)
			return rs;
		else
			return null;
		} catch (Exception e) {
			System.out.println("查询所有用户错误！");
			return null;
		} finally {
			
		}
	}
	
	public boolean update(User user,String name){
		conn=getConnectionn();
		try{
			pStat=conn.prepareStatement("update user set username=?,password=? where username=?");
		    pStat.setString(1,user.getUsername());
		    pStat.setString(2,user.getPassword());
		    pStat.setString(3,name);
		    int cnt=pStat.executeUpdate();
		    if(cnt>0)
		    	 return true;
		    else
		    	return false;
		}catch(Exception e) {
			System.out.println("更新错误！");
			return false;
		} finally {
			close();
		}
	}//end update
	
	public boolean updatebyid(int id,int id_,String name,String password){
		conn=getConnectionn();
		try{
			pStat=conn.prepareStatement("update user set id=?,username=?,password=? where id=?");
		    pStat.setInt(1,id_);
		    pStat.setString(2,name);
		    pStat.setString(3,password);
		    pStat.setInt(4,id);
		    int cnt=pStat.executeUpdate();
		    if(cnt>0)
		    	 return true;
		    else
		    	return false;
		}catch(Exception e) {
			System.out.println("更新错误！");
			return false;
		} finally {
			close();
		}
	}//end update
	
	public boolean delete(int id){
		conn=getConnectionn();
		try{
			pStat=conn.prepareStatement("delete from user where id=?");
		    pStat.setInt(1,id);
		    int cnt=pStat.executeUpdate();
		    if(cnt>0)
		    	 return true;
		    else
		    	return false;
		}catch(Exception e) {
			System.out.println("删除错误！");
			return false;
		} finally {
			close();
		}
	}
	public int findid(String username, String password)
	{
		conn = getConnectionn();
		try {
			pStat = conn
					.prepareStatement("select * from user where username=? and password=?");
			pStat.setString(1, username);
			pStat.setString(2, password);
			rs = pStat.executeQuery();
			if (rs.next())
				return rs.getInt("id");
			else

				return 0;
		} catch (Exception e) {
			System.out.println("查找id错误！");
			return 0;
		} finally {
			
		}
	}
	
public ResultSet findbyword(String s1,String s2) {
	System.out.println(s1+" "+s2);
		conn = getConnectionn();
		try {
		pStat = conn.prepareStatement("select * from user where username>=? and username<=?");
	//	int cnt = pStat.executeUpdate();
		pStat.setString(1, s1);
		pStat.setString(2, s2);
		ResultSet rs=pStat.executeQuery( );
		if (rs!=null)
		{
			System.out.println("rs!=null");
			return rs;
			
		}
		else
			return null;
		} catch (Exception e) {
			System.out.println("sort用户错误！");
			return null;
		} finally {
			
		}
	}
	
//	public ResultSet search(String singer,String song) {
//		conn=getConnectionn2();
//		try{
//			pStat=conn.prepareStatement("select * from music where singer=?");
//			pStat.setString(1, singer);
//			rs = pStat.executeQuery();
//			if (rs.next())
//			{
//				return rs;
//			}
//			else
//			{
//				System.out.println("Search for Singer null");
//				pStat=conn.prepareStatement("select * from music where song=?");
//			pStat.setString(1, song);
//			rs = pStat.executeQuery();
//			if(rs.next())
//			return rs;
//			else
//			{
//				System.out.println("Search for Song null");
//				return null;
//			}
//			}
//		}catch (Exception e) {
//			System.out.println("MUSIC错误！");
//			return null;
//		} finally {
//			
//		}
//			
//		}
} // end class

