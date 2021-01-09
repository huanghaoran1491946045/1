package cn.edu.jsu.hhr.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.hhr.dbc.DatabaseConnectionSqlserver;
import cn.edu.jsu.hhr.vo.player;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class join extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					join frame = new join();
					JLabel lblNewLabel = new JLabel("");
					lblNewLabel.setIcon(new ImageIcon("D:\\\u56FE\u7247\\jiaoben7634.jpg"));
					lblNewLabel.setBounds(0, 0, 641, 439);
					frame.getContentPane().add(lblNewLabel);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public join() {
		setTitle("\u65B0\u7403\u5458\u7684\u52A0\u5165");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7403\u5458\u59D3\u540D");
		lblNewLabel.setBounds(69, 61, 103, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7403\u5458\u8EAB\u9AD8");
		lblNewLabel_1.setBounds(69, 105, 103, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u573A\u5747\u5F97\u5206");
		lblNewLabel_2.setBounds(69, 149, 103, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u6240\u5C5E\u4F4D\u7F6E");
		lblNewLabel_3.setBounds(69, 193, 103, 31);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u7403\u5458\u53F7\u7801");
		lblNewLabel_4.setBounds(69, 242, 103, 31);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(180, 64, 96, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(180, 108, 96, 24);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(180, 152, 96, 24);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(180, 196, 96, 24);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(180, 245, 96, 24);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_3_1 = new JLabel("\u6240\u5C5E\u7403\u961F");
		lblNewLabel_3_1.setBounds(332, 193, 103, 31);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("\u670D\u5F79\u60C5\u51B5");
		lblNewLabel_3_2.setBounds(332, 242, 103, 31);
		contentPane.add(lblNewLabel_3_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(429, 196, 96, 24);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(429, 245, 96, 24);
		contentPane.add(textField_6);
		
		JLabel lblNewLabel_5 = new JLabel("\u7403\u5458\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_5.setFont(new Font("仿宋", Font.BOLD, 31));
		lblNewLabel_5.setBounds(331, 61, 210, 73);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A\u52A0\u5165");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a1=textField.getText().trim();
				String a2=textField_1.getText().trim();
				String a3=textField_2.getText().trim();
				String a4=textField_3.getText().trim();
				String a5=textField_4.getText().trim();
				String a6=textField_5.getText().trim();
				String a7=textField_6.getText().trim();
				String sql="INSERT INTO Tableplayer(name,height,averagescore,location,playernumber,team,servicestatus)"+" VALUES('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"')";			
				DatabaseConnectionSqlserver dbcs=new DatabaseConnectionSqlserver();
		    	try(Connection conn=dbcs.getConnection();//获取数据库连接
		    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化		    		
		    		pstmt.executeUpdate();//执行插入语句
		    		
		    		JOptionPane.showMessageDialog(null, "新球员加入成功");
		    	}catch(SQLException e2) {
		    		JOptionPane.showMessageDialog(null, "球员已存在");
		    		e2.printStackTrace();
		    	}
			}
		});
		btnNewButton.setBounds(334, 305, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new mainscreen().main(null);
//				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(111, 305, 113, 27);
		contentPane.add(btnNewButton_1);
	}
}
