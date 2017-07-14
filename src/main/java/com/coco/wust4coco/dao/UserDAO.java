package com.coco.wust4coco.dao;

import java.sql.*;

import com.coco.wust4coco.beans.User;

public class UserDAO {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/coco";
	public static final String DBURL2 = "jdbc:mysql://localhost:3306/mobiledb";
	public static final String DBUSER = "root";        //数据库用户名
	public static final String DBPASS = "admin";       //数据库密码
                  /*简单的JDBC模式下，上两项可能要作出更改*/
	
	
	private Connection conn = null;
	private PreparedStatement pStat = null;
	private ResultSet rs = null;

	public Connection getConnectionn() {       //连接数据库
		try {
			Class.forName(DRIVER).newInstance();
			return DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (Exception e) {
			System.out.println("连接错误！");
			e.printStackTrace();
			return null;
		}
	}
	
	public void close() {                      //关闭数据库
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
		                                         //指定用户是否存在
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
	public ResultSet findUserfromid(int id) {      //查找指定ID用户
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
		conn = getConnectionn();      // 通过用户名和密码查找用户
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

	public boolean addUser(User user) {     //添加用户

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
	
	public ResultSet alluser() {      //查询所有用户信息
		
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
	
	public boolean update(User user,String name){   //更新用户信息
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
		conn=getConnectionn();             //更新指定id用户
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
	
	public boolean delete(int id){           //删除指定id用户
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
	{                                     //查找用户id
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
	System.out.println(s1+" "+s2);             //用户名字母排序
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
	

} // end class

