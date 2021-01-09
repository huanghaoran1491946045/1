package cn.edu.jsu.hhr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.edu.jsu.hhr.dbc.DatabaseConnectionSqlserver;
import cn.edu.jsu.hhr.vo.user;

public class insert {
public void add(user user) {
		
		String sql="insert into Tableuser(username,password) values(?,?)";//使用占位符定义插入语句
		
		DatabaseConnectionSqlserver dbcs=new DatabaseConnectionSqlserver();
    	try(Connection conn=dbcs.getConnection();//获取数据库连接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化
    		pstmt.setString(1, user.getUsername());//定义第1个占位符的内容
    		pstmt.setString(2, user.getPassword());//定义第2个占位符的内容
    		pstmt.executeUpdate();//执行插入语句
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }

}
