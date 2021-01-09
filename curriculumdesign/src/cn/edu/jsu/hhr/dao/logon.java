package cn.edu.jsu.hhr.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import cn.edu.jsu.hhr.dbc.DatabaseConnectionSqlserver;

public class logon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseConnectionSqlserver dbconn = new DatabaseConnectionSqlserver();//实例化自定义类
		try (Connection conn = dbconn.getConnection();//创建数据库连接 
		     Statement stmt = conn.createStatement();) {
		  String sql = "INSERT INTO Tableuser(username,password) VALUES ('124','75')";
		  stmt.executeUpdate(sql);//执行数据库插入操作
		  
		} catch (SQLException e) {
		  e.printStackTrace();
		}

}

}
