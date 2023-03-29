package com.travel.BusinessView;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.travel.domain.Business_table;

public class BusinessMainPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField_name;
	private JTextField textField_phone;
	private JTextField textField_email;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusinessMainPage frame = new BusinessMainPage();
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
	public BusinessMainPage() {
		setTitle("商户主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("用户名");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel.setBounds(222, 75, 75, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("手机号");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(222, 113, 75, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("邮 箱");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(222, 151, 67, 35);
		contentPane.add(lblNewLabel_2);
		
		textField_name = new JTextField();
		textField_name.setEditable(false);
		textField_name.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_name.setBounds(290, 78, 128, 21);
		contentPane.add(textField_name);
		textField_name.setColumns(10);
		
		textField_phone = new JTextField();
		textField_phone.setEditable(false);
		textField_phone.setFont(new Font("宋体", Font.PLAIN, 22));
		textField_phone.setBounds(290, 113, 128, 21);
		contentPane.add(textField_phone);
		textField_phone.setColumns(10);
		
		textField_email = new JTextField();
		textField_email.setEditable(false);
		textField_email.setFont(new Font("宋体", Font.PLAIN, 22));
		textField_email.setBounds(290, 151, 128, 21);
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
		btnNewButton_4.setBounds(428, 80, 97, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("修改");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePhone updatephone= new updatePhone();
				updatephone.setVisible(true);
				dispose();
			}
		});
		btnNewButton_5.setBounds(428, 118, 97, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("修改");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        updateEmail updateEmail = new updateEmail();
		        updateEmail.setVisible(true);
		        dispose();
			}
		});
		btnNewButton_6.setBounds(428, 151, 97, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("修改密码");
		btnNewButton_7.setFont(new Font("宋体", Font.PLAIN, 22));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePwd updatePassword = new updatePwd(login.getBusiness());
		        updatePassword.setVisible(true);
		        dispose();
			}
		});
		btnNewButton_7.setBounds(57, 213, 128, 35);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("用户注销");
		btnNewButton_8.setFont(new Font("宋体", Font.PLAIN, 22));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login view = new login();
				view.setVisible(true);
		        dispose();
			}
		});
		btnNewButton_8.setBounds(220, 213, 134, 35);
		contentPane.add(btnNewButton_8);
		Business_table business_table = login.getBusiness();
		textField_name.setText(business_table.getBusiness_name());
		textField_phone.setText(business_table.getBusiness_phonenum());
		textField_email.setText(business_table.getBusiness_email());
		
		JButton btnNewButton_11 = new JButton("查看店铺");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					storeView view = new storeView();
					view.setVisible(true);
					dispose();
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_11.setFont(new Font("宋体", Font.PLAIN, 22));
		btnNewButton_11.setBounds(384, 213, 126, 35);
		contentPane.add(btnNewButton_11);
		
		JButton btnNewButton = new JButton("管理店铺");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					createStore view = new createStore();
					view.setVisible(true);
					dispose();
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 22));
		btnNewButton.setBounds(541, 213, 128, 35);
		contentPane.add(btnNewButton);
		
	}
}

