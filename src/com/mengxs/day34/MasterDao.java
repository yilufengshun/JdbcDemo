package com.mengxs.day34;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MasterDao {
	public void add(Master master) {
		PreparedStatement pstmt=null;
		 Connection conn =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/petdb","root","root");
			pstmt=conn.prepareStatement("insert into master (id,name,password,money) values(?,?,?,?)");
			pstmt.setInt(1, master.getId());
			pstmt.setString(2, master.getName());
			pstmt.setString(3, master.getPassword());
			pstmt.setInt(4, master.getMoney());
			int res=pstmt.executeUpdate();
			if(res > 0 )
				System.out.println("成功");
			else 
				System.out.println("失败");
		}catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void updata(Master master){
		PreparedStatement pstmt=null;
		 Connection conn =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/petdb","root","root");
			pstmt=conn.prepareStatement("update master set  name=?,password=?,money=? where id = ?");
			pstmt.setInt(4, master.getId());
			pstmt.setString(1, master.getName());
			pstmt.setString(2, master.getPassword());
			pstmt.setInt(3, master.getMoney());
			int res=pstmt.executeUpdate();
			if(res > 0 )
				System.out.println("成功");
			else 
				System.out.println("失败");
		}catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void delete (int id){
		PreparedStatement pstmt=null;
		 Connection conn =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/petdb","root","root");
			pstmt=conn.prepareStatement("delete from master where id = ?");
			pstmt.setInt(1, id);
			
			int res=pstmt.executeUpdate();
			if(res > 0 )
				System.out.println("成功");
			else 
				System.out.println("失败");
		}catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public List<Master> findall(){
		PreparedStatement pstmt=null;
		 Connection conn =null;
		 List<Master> mas=new ArrayList<>();
		 ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/petdb","root","root");
			pstmt=conn.prepareStatement("select id,name,password,money from master ");
			
			rs=pstmt.executeQuery();
			while(rs.next()){
				mas.add(new Master(rs.getInt("id"),rs.getString("name"), rs.getString("password"), rs.getInt("money")));
			}
			if(rs != null )
				System.out.println("成功");
			else 
				System.out.println("失败");
		}catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mas;
	}
	public Master find(String name,String password){
		PreparedStatement pstmt=null;
		 Connection conn =null;
	Master re=null;
		 ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/petdb","root","root");
			pstmt=conn.prepareStatement("select id,name,password,money from master where name =? ,password=?");
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			while(rs.next()){
			re=	new Master(rs.getInt("id"),rs.getString("name"), rs.getString("password"), rs.getInt("money"));
			}
			if(rs != null )
				System.out.println("成功");
			else 
				System.out.println("失败");
		}catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
		
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		return re;
	}
}
