package com.travel.BusinessView;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.travel.domain.Business_table;
import com.travel.service.impl.IBusinessServiceImpl;


public class login extends JFrame {

	private JPanel contentPane;
	private JTextField uname;
	private JPasswordField passwordField;
	public static Business_table business_table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setTitle("商户登录界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("账 号");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(96, 96, 67, 26);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = uname.getText();
				String pwd = passwordField.getText();
				try {
			        IBusinessServiceImpl iBusinessService = new IBusinessServiceImpl();
					boolean login = iBusinessService.login(username,pwd);
					if(login) {
//						JOptionPane.showMessageDialog(null,"登录成功");
						business_table = iBusinessService.getBusiness(username, pwd);
						System.out.println(business_table);
						BusinessMainPage businessMainPage = new BusinessMainPage();
						businessMainPage.setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null,"登录失败");
					}
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace(); 
				}
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 22));
		btnNewButton.setBounds(96, 266, 97, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6 \u7801");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(96, 185, 74, 36);
		contentPane.add(lblNewLabel_2);
		
		uname = new JTextField();
		uname.setBounds(217, 96, 151, 26);
		contentPane.add(uname);
		uname.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uname.setText("");
				passwordField.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 22));
		btnNewButton_1.setBounds(271, 266, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(625, 315, -350, -245);
		contentPane.add(desktopPane);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(217, 185, 151, 26);
		contentPane.add(passwordField);
		
		JButton btnNewButton_2 = new JButton("注册");
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 22));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register view = new register();
				view.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(178, 344, 97, 23);
		contentPane.add(btnNewButton_2);
	}

	public static Business_table getBusiness(){
		return business_table;
	}
}
