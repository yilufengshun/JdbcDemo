package com.mengxs.day34;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JdbcDemo2 {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		//为了执行静态代码块
				//2lianjei
				//url　　jdbc:mysql://localhost:3306/myschool;
		Connection conn=null;
		Statement stat=null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschool","root","root");
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from student");
			while(rs.next()){
			int no=	rs.getInt("studentNo");
			String loginPwd=rs.getString("loginPwd");
			String sex=rs.getString("sex");
			String address=rs.getString("adress");
			String name = rs.getString("studentName");
			System.out.println(no+"....."+name+sex+address+loginPwd);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		try {
			if(stat!=null)
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(conn!=null)
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		//关闭结果集，关闭命令，关闭连接
		
	
	}

}
