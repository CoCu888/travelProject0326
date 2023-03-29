package com.travel.view;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.travel.service.impl.UserServiceImpl;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class registration extends JFrame {

	private JPanel contentPane;
	private JTextField user_phonenum;
	private JTextField user_name;
	private JTextField user_pwd;
	private JTextField user_city;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registration frame = new registration();
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
	public registration() {
		setTitle("用户注册页面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("电话号码");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(84, 87, 93, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("用户姓名");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(84, 136, 79, 18);
		contentPane.add(lblNewLabel_1);
		
		user_phonenum = new JTextField();
		user_phonenum.setFont(new Font("宋体", Font.PLAIN, 18));
		user_phonenum.setBounds(207, 87, 119, 18);
		contentPane.add(user_phonenum);
		user_phonenum.setColumns(10);
		
		user_name = new JTextField();
		user_name.setFont(new Font("宋体", Font.PLAIN, 18));
		user_name.setColumns(10);
		user_name.setBounds(207, 136, 119, 18);
		contentPane.add(user_name);
		
		user_pwd = new JTextField();
		user_pwd.setFont(new Font("宋体", Font.PLAIN, 18));
		user_pwd.setColumns(10);
		user_pwd.setBounds(207, 190, 119, 18);
		contentPane.add(user_pwd);
		
		user_city = new JTextField();
		user_city.setFont(new Font("宋体", Font.PLAIN, 18));
		user_city.setColumns(10);
		user_city.setBounds(207, 246, 119, 18);
		contentPane.add(user_city);
		
		lblNewLabel_2 = new JLabel("用户密码");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(84, 190, 79, 18);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("城    市");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(84, 246, 79, 18);
		contentPane.add(lblNewLabel_3);
		
		btnNewButton = new JButton("注册");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String phonenum = user_phonenum.getText();
				String name = user_name.getText();
				String pwd = user_pwd.getText();
				String city = user_city.getText();
				UserServiceImpl userService = new UserServiceImpl();
				if (!(phonenum.equals("")&&name.equals("")&&pwd.equals("")&&city.equals(""))) {
					try {
						boolean b = userService.regUser(phonenum, name, pwd, city);
						if (b) {
							TestJFrame testJFrame = new TestJFrame();
							testJFrame.setVisible(true);
							dispose();
						} else {
							user_phonenum.setText("");
							user_name.setText("");
							user_pwd.setText("");
							user_city.setText("");
							JOptionPane.showMessageDialog(null, "注册失败，请输入新的注册信息");
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "注册失败，信息不允许为空");
				}
			}
		});
		btnNewButton.setBounds(84, 331, 97, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("取消");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user_phonenum.setText("");
				user_name.setText("");
				user_pwd.setText("");
				user_city.setText("");
			}
		});
		btnNewButton_1.setBounds(229, 331, 97, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("返回");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TestJFrame testJFrame = new TestJFrame();
				testJFrame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_2.setBounds(0, 0, 97, 23);
		contentPane.add(btnNewButton_2);
	}

}
