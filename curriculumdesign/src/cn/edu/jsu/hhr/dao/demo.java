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
//		 while(true) { 
			username=getUsername1();
			password=getPassword1();
//			 String sql="select * from Tableuser where username="+username;
//			if(check(sql)) {
//				break;
//			}
//		 }
		 String sql1="insert into Tableuser1(username,password) values('"+username+"','"+password+"')";
		 input(sql1);
	   }
   }
   
   public  static String getUsername1() {
		String base = "abcdefghijklmnopqrstuvwxyz"; 
		int size = base.length();
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i=1;i<=5;i++){
			//����0��size-1�����ֵ
			int index = r.nextInt(size);
			//��base�ַ����л�ȡ�±�Ϊindex���ַ�
//			if(i==1&&index==0) {
//				continue;
//			}
			char c = base.charAt(index);
			//��c���뵽StringBuffer��ȥ
			sb.append(c);
		}
		System.out.println(sb);
		return sb.toString();
	}
   
   public  static String getPassword1() {
		String base = "0123456789abcdefghijklmnopqrstuvwxyz"; 
		int size = base.length();
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i=1;i<=5;i++){
			//����0��size-1�����ֵ
			int index = r.nextInt(size);
			//��base�ַ����л�ȡ�±�Ϊindex���ַ�
//			if(i==1&&index==0) {
//				continue;
//			}
			char c = base.charAt(index);
			//��c���뵽StringBuffer��ȥ
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
			stm.executeUpdate(sql);//ִ�����ݿ�������
		} catch (SQLException e1) { 
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}