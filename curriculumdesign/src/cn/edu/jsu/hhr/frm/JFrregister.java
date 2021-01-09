package cn.edu.jsu.hhr.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.hhr.dao.insert;
import cn.edu.jsu.hhr.vo.user;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class JFrregister extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrregister frame1 = new JFrregister();
					JLabel lblNewLabe3 = new JLabel("");
					lblNewLabe3.setIcon(new ImageIcon("D:\\\u56FE\u7247\\jiaoben7634.jpg"));
					lblNewLabe3.setBounds(0, 0, 641, 439);
					frame1.getContentPane().add(lblNewLabe3);
					frame1.setLocationRelativeTo(null);//窗体居中
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrregister() {
		setTitle("\u7403\u5458\u7BA1\u7406\u7CFB\u7EDF");
		JFrame frame1=new JFrame();
		user user=new user();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("用户名：");
		lblNewLabel.setBounds(40, 92, 72, 18);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(161, 89, 169, 24);
		contentPane.add(textField);
		textField.setColumns(10);
	
		JLabel lblNewLabel_1 = new JLabel("输入密码：");
		lblNewLabel_1.setBounds(40, 136, 81, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("确认密码：");
		lblNewLabel_2.setBounds(40, 183, 81, 18);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(161, 133, 169, 24);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setEchoChar('*');
		passwordField_1.setBounds(161, 180, 169, 24);
		contentPane.add(passwordField_1);
		
		JButton btnNewButton = new JButton("注册");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.setUsername(textField.getText().trim());
				user.setPassword(passwordField.getText().trim());
				new insert().add(user);
				JOptionPane.showMessageDialog(null, "注册成功");
				new JFrnitial().main(null);
				frame1.dispose();
			}
		});

		btnNewButton.setBounds(177, 231, 113, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("\u7403\u5458\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_3.setFont(new Font("楷体", Font.PLAIN, 31));
		lblNewLabel_3.setBounds(134, 25, 216, 35);
		contentPane.add(lblNewLabel_3);
		
		
	}
}

