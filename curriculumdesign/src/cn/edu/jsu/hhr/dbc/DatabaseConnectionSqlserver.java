package cn.edu.jsu.hhr.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionSqlserver {
	//����SQLServer���ݿ���������
		private static final String DBRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		//����SQLServer���ݿ����ӵ�ַ
		private static final String DBURL="jdbc:sqlserver://localhost:1433;DatabaseName=testdb";
		private static final String DBUSER="sa"; //SQLServer���ݿ������û���
		private static final String PASSWORD="1491946045hhr"; //SQLServer���ݿ���������
		private Connection conn=null; //�������Ӷ���
		public DatabaseConnectionSqlserver() {//���췽���������ݿ�
			try {
				Class.forName(DBRIVER);
				this.conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
			} catch (Exception e) {e.printStackTrace();}
		}
		public Connection getConnection() {//�������ݿ����Ӷ���
			return this.conn;
		}
		public void close() {//�ر���������
			if(this.conn!=null) {
				try {
					this.conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
}
