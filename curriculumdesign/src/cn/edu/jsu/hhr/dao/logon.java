package cn.edu.jsu.hhr.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import cn.edu.jsu.hhr.dbc.DatabaseConnectionSqlserver;

public class logon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseConnectionSqlserver dbconn = new DatabaseConnectionSqlserver();//ʵ�����Զ�����
		try (Connection conn = dbconn.getConnection();//�������ݿ����� 
		     Statement stmt = conn.createStatement();) {
		  String sql = "INSERT INTO Tableuser(username,password) VALUES ('124','75')";
		  stmt.executeUpdate(sql);//ִ�����ݿ�������
		  
		} catch (SQLException e) {
		  e.printStackTrace();
		}

}

}
