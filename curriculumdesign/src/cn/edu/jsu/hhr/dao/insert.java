package cn.edu.jsu.hhr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.edu.jsu.hhr.dbc.DatabaseConnectionSqlserver;
import cn.edu.jsu.hhr.vo.user;

public class insert {
public void add(user user) {
		
		String sql="insert into Tableuser(username,password) values(?,?)";//ʹ��ռλ������������
		
		DatabaseConnectionSqlserver dbcs=new DatabaseConnectionSqlserver();
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����
    		pstmt.setString(1, user.getUsername());//�����1��ռλ��������
    		pstmt.setString(2, user.getPassword());//�����2��ռλ��������
    		pstmt.executeUpdate();//ִ�в������
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }

}
