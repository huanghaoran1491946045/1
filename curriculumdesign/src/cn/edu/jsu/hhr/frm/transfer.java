package cn.edu.jsu.hhr.frm;

import javax.swing.JFrame;
import javax.swing.JTextField;

import cn.edu.jsu.hhr.dbc.DatabaseConnectionSqlserver;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class transfer {
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextField textField_5;
	private static JTextField textField_6;
	private static JTextField textField_7;
	private static JTextField textField_8;
	public static void main(String[] args){
	JFrame frame=new JFrame("球员转会");
	frame.setTitle("\u7403\u5458\u7BA1\u7406\u7CFB\u7EDF");
	frame.getContentPane().setLayout(null);
	
	textField = new JTextField();
	textField.setBounds(197, 18, 182, 41);
	frame.getContentPane().add(textField);
	textField.setColumns(10);
	
	textField_1 = new JTextField();
	textField_1.setColumns(10);
	textField_1.setBounds(214, 89, 141, 32);
	frame.getContentPane().add(textField_1);
	
	textField_2 = new JTextField();
	textField_2.setColumns(10);
	textField_2.setBounds(214, 156, 141, 32);
	frame.getContentPane().add(textField_2);
	
	textField_3 = new JTextField();
	textField_3.setColumns(10);
	textField_3.setBounds(214, 233, 141, 32);
	frame.getContentPane().add(textField_3);
	
	textField_4 = new JTextField();
	textField_4.setColumns(10);
	textField_4.setBounds(214, 303, 141, 32);
	frame.getContentPane().add(textField_4);
	
	textField_5 = new JTextField();
	textField_5.setColumns(10);
	textField_5.setBounds(214, 380, 141, 32);
	frame.getContentPane().add(textField_5);
	
	textField_6 = new JTextField();
	textField_6.setColumns(10);
	textField_6.setBounds(214, 451, 141, 32);
	frame.getContentPane().add(textField_6);
	
	textField_7 = new JTextField();
	textField_7.setColumns(10);
	textField_7.setBounds(214, 521, 141, 32);
	frame.getContentPane().add(textField_7);
	
	JLabel lblNewLabel_1 = new JLabel("\u7403\u5458\u59D3\u540D\uFF1A");
	lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
	lblNewLabel_1.setBounds(61, 88, 87, 32);
	frame.getContentPane().add(lblNewLabel_1);
	
	JLabel lblNewLabel_1_1 = new JLabel("\u7403\u5458\u8EAB\u9AD8\uFF1A");
	lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
	lblNewLabel_1_1.setBounds(61, 156, 87, 32);
	frame.getContentPane().add(lblNewLabel_1_1);
	
	JLabel lblNewLabel_1_2 = new JLabel("\u573A\u5747\u5F97\u5206\uFF1A");
	lblNewLabel_1_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
	lblNewLabel_1_2.setBounds(61, 233, 87, 32);
	frame.getContentPane().add(lblNewLabel_1_2);
	
	JLabel lblNewLabel_1_3 = new JLabel("\u6240\u5C5E\u4F4D\u7F6E\uFF1A");
	lblNewLabel_1_3.setFont(new Font("微软雅黑", Font.BOLD, 15));
	lblNewLabel_1_3.setBounds(61, 303, 87, 32);
	frame.getContentPane().add(lblNewLabel_1_3);
	
	JLabel lblNewLabel_1_4 = new JLabel("\u7403\u5458\u53F7\u7801\uFF1A");
	lblNewLabel_1_4.setFont(new Font("微软雅黑", Font.BOLD, 15));
	lblNewLabel_1_4.setBounds(61, 380, 87, 32);
	frame.getContentPane().add(lblNewLabel_1_4);
	
	JLabel lblNewLabel_1_5 = new JLabel("\u6240\u5C5E\u961F\u4F0D\uFF1A");
	lblNewLabel_1_5.setFont(new Font("微软雅黑", Font.BOLD, 15));
	lblNewLabel_1_5.setBounds(61, 451, 87, 32);
	frame.getContentPane().add(lblNewLabel_1_5);
	
	JLabel lblNewLabel_1_6 = new JLabel("\u670D\u5F79\u60C5\u51B5\uFF1A");
	lblNewLabel_1_6.setFont(new Font("微软雅黑", Font.BOLD, 15));
	lblNewLabel_1_6.setBounds(61, 521, 87, 32);
	frame.getContentPane().add(lblNewLabel_1_6);
	
	JLabel lblNewLabel_1_5_1 = new JLabel("\u8F6C\u4F1A\u5230");
	lblNewLabel_1_5_1.setFont(new Font("微软雅黑", Font.BOLD, 20));
	lblNewLabel_1_5_1.setBounds(380, 451, 76, 32);
	frame.getContentPane().add(lblNewLabel_1_5_1);
	
	textField_8 = new JTextField();
	textField_8.setColumns(10);
	textField_8.setBounds(470, 451, 141, 32);
	frame.getContentPane().add(textField_8);
	
	JButton btnNewButton = new JButton("\u786E\u8BA4\u8F6C\u4F1A");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String a2=textField_2.getText().trim();
			String a3=textField_8.getText().trim();
			String sql1="update Tableplayer set team='"+a3+"'where height="+a2;
			
			DatabaseConnectionSqlserver dbcs=new DatabaseConnectionSqlserver();
			try(Connection conn=dbcs.getConnection();//获取数据库连接
		    		Statement stmt=conn.createStatement();){//实例化
					stmt.executeUpdate(sql1);
					textField_6.setText(a3);
					textField_8.setText(null);
		    		JOptionPane.showMessageDialog(null, "转会成功");
		    	}catch(SQLException e3) {
		    		JOptionPane.showMessageDialog(null, "转会失败");
		    		e3.printStackTrace();
		    	}
		}
	});
	btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
	btnNewButton.setBounds(625, 449, 133, 41);
	frame.getContentPane().add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("\u7403\u5458\u67E5\u8BE2");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String a1=textField.getText().trim();
			
			DatabaseConnectionSqlserver dbcs=new DatabaseConnectionSqlserver();
			try(Connection conn=dbcs.getConnection();//获取数据库连接
		    		Statement stmt=conn.createStatement();){//实例化
		    		String sql="select name,height,averagescore,location,playernumber,team,servicestatus from Tableplayer";
		  
		    		ResultSet rs=stmt.executeQuery(sql);//执行查询语句
		    		while(rs.next()){
		    		if((a1).equals(rs.getString(1))){   			
		    			textField_1.setText(rs.getString(1));//获取第一个字段姓名
		    			
		    			textField_2.setText(rs.getString(2));//获取第二个字段身高 
		    			
		    			textField_3.setText(rs.getString(3)); 
		    		
		    			textField_4.setText(rs.getString(4));
		    			
		    			textField_5.setText(rs.getString(5));
		    		
		    			textField_6.setText(rs.getString(6));
		    	
		    			textField_7.setText(rs.getString(7));
		    			
			    		}
		    		}
		    	}catch(SQLException e3) {
		    		e3.printStackTrace();
		    	}
		}
	});
	btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
	btnNewButton_1.setBounds(431, 18, 128, 41);
	frame.getContentPane().add(btnNewButton_1);
	
	JButton btnNewButton_1_1 = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
	btnNewButton_1_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new mainscreen().main(null);
			frame.dispose();
		}
	});
	btnNewButton_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
	btnNewButton_1_1.setBounds(611, 18, 147, 41);
	frame.getContentPane().add(btnNewButton_1_1);
	
	JLabel lblNewLabel = new JLabel("\u7403\u5458");
	lblNewLabel.setFont(new Font("楷体", Font.BOLD, 50));
	lblNewLabel.setBounds(510, 89, 147, 66);
	frame.getContentPane().add(lblNewLabel);
	
	JLabel lblNewLabel_2 = new JLabel("\u7BA1\u7406");
	lblNewLabel_2.setFont(new Font("楷体", Font.BOLD, 50));
	lblNewLabel_2.setBounds(510, 197, 147, 66);
	frame.getContentPane().add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("\u7CFB\u7EDF");
	lblNewLabel_3.setFont(new Font("楷体", Font.BOLD, 50));
	lblNewLabel_3.setBounds(510, 310, 147, 66);
	frame.getContentPane().add(lblNewLabel_3);
	
	frame.setVisible(true);
	frame.setSize(800, 600);
	frame.setLocationRelativeTo(null);
	
	}
}
