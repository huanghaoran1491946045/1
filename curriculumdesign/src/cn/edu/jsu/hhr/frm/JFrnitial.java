package cn.edu.jsu.hhr.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.hhr.dao.loginrecord;
import cn.edu.jsu.hhr.dbc.DatabaseConnectionSqlserver;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class JFrnitial  {

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		JFrame frame=new JFrame("球员管理系统");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 596, 364);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("用户名：");
		lblNewLabel.setBounds(60, 125, 72, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密码：");
		lblNewLabel_1.setBounds(60, 186, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		JTextField usernametextField = new JTextField();
		usernametextField.setBounds(193, 122, 141, 24);
		contentPane.add(usernametextField);
		usernametextField.setColumns(10);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(193, 183, 141, 24);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(290, 55, 115, 18);
		contentPane.add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_4 = new JLabel("球员管理系统");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(158, 43, 176, 30);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setBounds(382, 183, 132, 21);
		contentPane.add(lblNewLabel_5);
		
		JButton signinbtnNewButton = new JButton("登录");
		signinbtnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String a1=usernametextField.getText().trim();
				String a2=passwordField.getText().trim();
				DatabaseConnectionSqlserver dbcs=new DatabaseConnectionSqlserver();
				try(Connection conn=dbcs.getConnection();//获取数据库连接
			    		Statement stmt=conn.createStatement();){//实例化
			    		String sql="select * from Tableuser";
			    		ResultSet rs=stmt.executeQuery(sql);//执行查询语句
			    		
			    		while(rs.next()){
			    		if((a1).equals(rs.getString(1))&&(a2).equals(rs.getString(2))){ 
			    			new loginrecord().In(a1);
			    			JOptionPane.showMessageDialog(null, "登录成功");
			    			new mainscreen();
							mainscreen.main(null);
							frame.dispose();
			    		}
			    		}
			    		lblNewLabel_5.setText("用户名或密码输入错误");
			    	}catch(SQLException e3) {
			    		e3.printStackTrace();
			    	} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
		});
		signinbtnNewButton.setBounds(95, 241, 113, 27);
		contentPane.add(signinbtnNewButton);
		
		JButton registerbtnNewButton = new JButton("注册");
		registerbtnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JFrregister();
				JFrregister.main(null);
				frame.dispose();
			}
		});
		registerbtnNewButton.setBounds(292, 241, 113, 27);
		contentPane.add(registerbtnNewButton);
		
		JLabel lblNewLabe3 = new JLabel("");
		lblNewLabe3.setIcon(new ImageIcon("D:\\\u56FE\u7247\\jiaoben7634.jpg"));
		lblNewLabe3.setBounds(0, 0, 641, 439);
		frame.getContentPane().add(lblNewLabe3);

	
		frame.setLocationRelativeTo(null);//窗体居中
		frame.setVisible(true);
		
		}
}


