package cn.edu.jsu.hhr.frm;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class mainscreen {
	public static void main(String[]args){
		JFrame frame=new JFrame("��Ա����ϵͳ");
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u7403\u5458\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 62));
		lblNewLabel_1.setBounds(108, 64, 417, 96);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\\u56FE\u7247\\jiaoben7634.jpg"));
		lblNewLabel.setBounds(0, 0, 641, 439);
		frame.getContentPane().add(lblNewLabel);
		
		JMenu menu=new JMenu("��Ա����");
		JMenuBar menuBar=new JMenuBar();
		
		JMenuItem newItem=new JMenuItem("��Ա��ѯ����");
		newItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new querytable().main(null);
				frame.dispose();
			}
		});
		JMenuItem newItem1=new JMenuItem("�����µ���Ա");
		newItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new join().main(null);
				frame.dispose();			
			}
		});
		JMenuItem newItem2=new JMenuItem("��Աת���ѯ");
		newItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new transfer().main(null);
				frame.dispose();
			}
		});
		JMenuItem newItem4=new JMenuItem("��Ա��Ϣɾ��");
		newItem4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new del().main(null);
				frame.dispose();
			}
		});
		JMenuItem newItem3=new JMenuItem("��ȫ�˳�ϵͳ");
		newItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
						System.exit(1);		
			}
		});
		
		menu.add(newItem1);
		menu.add(newItem2);
		menu.add(newItem);
		menu.add(newItem4);
		menu.add(newItem3);
		menuBar.add(menu);
		frame.addWindowListener(new WindowAdapter(){
			public void widnowClosing(WindowEvent arg0){
				System.exit(1);
			}
		});
		
		frame.setJMenuBar(menuBar);
		frame.setVisible(true);
		frame.setSize(659, 512);
		frame.setLocationRelativeTo(null);

		

	}
}
