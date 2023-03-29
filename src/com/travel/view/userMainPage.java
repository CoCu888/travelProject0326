package com.travel.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.travel.domain.*;

import com.travel.service.impl.UserServiceImpl;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

public class userMainPage<Order_table> extends JFrame {

	private JPanel contentPane;
	private static JTextField textField_search;
	private JTextField textField_name;
	private JTextField textField_phone;
	private JTextField textField_email;
	private static JTextField textField_city;
	private JDesktopPane desktopPane;
	private static JTextField textField_good;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userMainPage frame = new userMainPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public userMainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 885, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_search = new JTextField();
		textField_search.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_search.setBounds(319, 72, 144, 23);
		contentPane.add(textField_search);
		textField_search.setColumns(10);
		
		JButton btnNewButton = new JButton("搜索店铺");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Search search = new Search();
					search.setVisible(true);
					dispose();
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(192, 74, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("饭店");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					restaurant restaurant = new restaurant();
					restaurant.setVisible(true);
					dispose();
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(171, 133, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("酒店");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					hotel h = new hotel();
					h.setVisible(true);
					dispose();
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
					dispose();
				}
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_2.setBounds(319, 133, 97, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("景点");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					scenic scenic = new scenic();
				    scenic.setVisible(true);
				    dispose();
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
		   
			}
		});
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_3.setBounds(465, 135, 97, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("用户名");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel.setBounds(222, 189, 75, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("手机号");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(222, 229, 75, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("邮 箱");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(222, 267, 67, 35);
		contentPane.add(lblNewLabel_2);
		
		textField_name = new JTextField();
		textField_name.setEditable(false);
		textField_name.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_name.setBounds(290, 192, 128, 21);
		contentPane.add(textField_name);
		textField_name.setColumns(10);
		
		textField_phone = new JTextField();
		textField_phone.setEditable(false);
		textField_phone.setFont(new Font("宋体", Font.PLAIN, 22));
		textField_phone.setBounds(290, 232, 128, 21);
		contentPane.add(textField_phone);
		textField_phone.setColumns(10);
		
		textField_email = new JTextField();
		textField_email.setEditable(false);
		textField_email.setFont(new Font("宋体", Font.PLAIN, 22));
		textField_email.setBounds(290, 273, 128, 21);
		contentPane.add(textField_email);
		textField_email.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("修改");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        updateName updatename = new updateName();
		        updatename.setVisible(true);
		        dispose();
			}
		});
		btnNewButton_4.setBounds(428, 194, 97, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("修改");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePhone updatephone= new updatePhone();
				updatephone.setVisible(true);
				dispose();
			}
		});
		btnNewButton_5.setBounds(426, 234, 97, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("修改");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        updateEmail updateEmail = new updateEmail();
		        updateEmail.setVisible(true);
		        dispose();
			}
		});
		btnNewButton_6.setBounds(426, 275, 97, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("修改密码");
		btnNewButton_7.setFont(new Font("宋体", Font.PLAIN, 22));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePwd updatePassword = new updatePwd(TestJFrame.user);
		        updatePassword.setVisible(true);
		        dispose();
			}
		});
		btnNewButton_7.setBounds(140, 378, 128, 35);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("用户注销");
		btnNewButton_8.setFont(new Font("宋体", Font.PLAIN, 22));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        TestJFrame testJFrame = new TestJFrame();
		        testJFrame.setVisible(true);
		        dispose();
			}
		});
		btnNewButton_8.setBounds(305, 378, 134, 35);
		contentPane.add(btnNewButton_8);
		
		JLabel lblNewLabel_3 = new JLabel("城 市");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(222, 304, 56, 35);
		contentPane.add(lblNewLabel_3);
		
		textField_city = new JTextField();
		textField_city.setFont(new Font("宋体", Font.PLAIN, 22));
		textField_city.setEditable(false);
		textField_city.setBounds(290, 309, 126, 23);
		contentPane.add(textField_city);
		textField_city.setColumns(10);
		
		textField_name.setText(TestJFrame.user.getUser_name());
		textField_phone.setText(TestJFrame.user.getUser_phonenum());
		textField_email.setText(TestJFrame.user.getUser_email());
		textField_city.setText(TestJFrame.user.getUser_city());
		
		JButton btnNewButton_9 = new JButton("修改");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCity updatecity = new updateCity();
				updatecity.setVisible(true);
		        dispose();
			}
		});
		btnNewButton_9.setBounds(426, 312, 97, 23);
		contentPane.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("搜索商品");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Search02 search = new Search02();
					search.setVisible(true);
					dispose();
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_10.setBounds(192, 41, 97, 23);
		contentPane.add(btnNewButton_10);
		
		textField_good = new JTextField();
		textField_good.setBounds(319, 42, 144, 21);
		contentPane.add(textField_good);
		textField_good.setColumns(10);
		
		JButton btnNewButton_11 = new JButton("查询订单");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					orderListView view = new orderListView();
					view.setVisible(true);
					dispose();
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_11.setFont(new Font("宋体", Font.PLAIN, 22));
		btnNewButton_11.setBounds(465, 378, 126, 35);
		contentPane.add(btnNewButton_11);
		
	}

	public static JTextField getCity(){
		return textField_city;
	}
	
	public static JTextField getSearch(){
		return textField_search;
	}
	
	public static JTextField getGood(){
		return textField_good;
	}
}
