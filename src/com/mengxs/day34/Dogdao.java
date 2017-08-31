package com.mengxs.day34;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dogdao {
	//dao   数据访问对象
		public void insert(Dog dog){
			
			Connection conn=null;
		
			PreparedStatement pstmt=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				//2lianjei
				//url　　jdbc:mysql://localhost:3306/myschool;
				 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/petdb","root","root");
				 //命令对象
				pstmt=conn.prepareStatement("insert into dog (name,health,love,strain) values(?,?,?,?)");
				pstmt.setString(1, dog.getName());
				pstmt.setInt(2, dog.getHealth());
				pstmt.setInt(3, dog.getLove());
				pstmt.setString(4, dog.getStrain());
				int res=pstmt.executeUpdate();
				 if(res>0){
					 System.out.println("添加成功");
				 }else {
				System.out.println("添加失败");
			}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}finally {
				if(pstmt!=null)
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if(conn!=null)
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		public void update(Dog dog){
			Connection conn=null;
			PreparedStatement pstmt=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				//2lianjei
				//url　　jdbc:mysql://localhost:3306/myschool;
				 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/petdb","root","root");
				 //命令对象
				pstmt=conn.prepareStatement("update dog set name =? , health=?,love=?,strain=? where id= ?");
				//int res= stat.executeUpdate("update dog set  name ='"+dog.getName()+"',health="+dog.getHealth()+",love="+dog.getLove()+",strain='"+dog.getStrain()+"'");
				pstmt.setString(1, dog.getName());
				pstmt.setInt(2, dog.getHealth());
				pstmt.setInt(3, dog.getLove());
				pstmt.setString(4, dog.getStrain());
				pstmt.setInt(5, dog.getId());
				int res = pstmt.executeUpdate();
				 if(res>0){
					 System.out.println("更新成功");
				 }else {
				System.out.println("更新失败");
			}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}finally {
				if(pstmt!=null)
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if(conn!=null)
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
		}
		public void delete(int id){
			Connection conn=null;
			PreparedStatement pstmt=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				//2lianjei
				//url　　jdbc:mysql://localhost:3306/myschool;
				 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/petdb","root","root");
				 //命令对象
				pstmt= conn.prepareStatement("delete from dog where id=?");
				pstmt.setInt(1, id);
				int res= pstmt.executeUpdate();
				 if(res>0){
					 System.out.println("删除成功");
				 }else {
				System.out.println("删除失败");
			}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}finally {
				if(pstmt!=null)
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if(conn!=null)
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		public  List<Dog>  find(){
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet re=null;
			List<Dog> dogs=new ArrayList<>();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				//2lianjei
				//url　　jdbc:mysql://localhost:3306/myschool;
				 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/petdb","root","root");
				 //命令对象
				 pstmt=conn.prepareStatement("select id,name,health,love,strain from dog");
				 re=pstmt.executeQuery();
				
				 while(re.next()){
					dogs.add(new Dog(re.getInt("id"),re.getString("name"), re.getInt("health"), re.getInt("love"), re.getString("strain")));
				}
				 
			
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}finally {
				if(pstmt!=null)
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if(conn!=null)
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			return dogs;
		}
}
