package com.mengxs.day34;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * @author meng
 *           1加载驱动
		//2建立连接
		//3创建命令
		//4执行命令返回结果
		//5处理结果
 */
public class JdbcDemo1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//1
		Class.forName("com.mysql.jdbc.Driver");
		//2lianjei
		//url　　jdbc:mysql://localhost:3306/myschool;
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/myschool","root","root");
		if(conn!=null){
			System.out.println("chengogn");
		}else {
			System.out.println("shibai");
		}
		//3关闭
		conn.close();
	}

}
