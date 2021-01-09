package cn.edu.jsu.hhr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JOptionPane;

import cn.edu.jsu.hhr.dbc.DatabaseConnectionSqlserver;


public class demo {
   public static void main(String[] args) {
	   String username;
	   String password;
	   for(int i=1;i<=10000;i++) {
			username=getUsername1();
			password=getPassword1();
		 String sql="insert into Tableuser(username,password) values('"+username+"','"+password+"')";
		 input(sql);
	   }
   }
   
   public  static String getUsername1() {
		String base = "abcdefghijklmnopqrstuvwxyz"; 
		int size = base.length();
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i=1;i<=5;i++){
			//产生0到size-1的随机值
			int index = r.nextInt(size);
			char c = base.charAt(index);
			//将c放入到StringBuffer中去
			sb.append(c);
		}
		return sb.toString();
	}
   
   public  static String getPassword1() {
		String base = "0123456789abcdefghijklmnopqrstuvwxyz"; 
		int size = base.length();
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i=1;i<=9;i++){
			//产生0到size-1的随机值
			int index = r.nextInt(size);
			char c = base.charAt(index);
			//将c放入到StringBuffer中去
			sb.append(c);
		}
		return sb.toString();
	}
   
   public static boolean check(String sql) {
	   DatabaseConnectionSqlserver db=new DatabaseConnectionSqlserver();
		try(Connection conn=db.getConnection();Statement stm=conn.createStatement();) {
			ResultSet rs=stm.executeQuery(sql); 
			if(!rs.next()){			
	    			return true;
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();  
		}   
		return false;
   }
   
   public static void input(String sql) {
		DatabaseConnectionSqlserver db=new DatabaseConnectionSqlserver();
		try(Connection conn=db.getConnection();Statement stm=conn.createStatement();) {
			stm.executeUpdate(sql);//执行数据库插入操作
		} catch (SQLException e1) { 
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}