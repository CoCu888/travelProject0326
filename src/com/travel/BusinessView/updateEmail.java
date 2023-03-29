package com.travel.BusinessView;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.travel.service.impl.IBusinessServiceImpl;
import com.travel.service.impl.UserServiceImpl;
import com.travel.utils.CheckByPattern;
import com.travel.view.TestJFrame;
import com.travel.view.userMainPage;

public class updateEmail extends JFrame {

	private JTextField newName;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateEmail frame = new updateEmail();
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
	public updateEmail() {
		setTitle("修改商户邮箱界面");
		setBounds(100, 100, 493, 388);
		getContentPane().setLayout(null);
		
		newName = new JTextField();
		newName.setFont(new Font("宋体", Font.PLAIN, 22));
		newName.setBounds(226, 114, 188, 26);
		getContentPane().add(newName);
		newName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("新邮箱");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel.setBounds(126, 114, 101, 26);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("提交");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IBusinessServiceImpl iBusinessService = new IBusinessServiceImpl();
		        try {
					if(CheckByPattern.checkEmail(newName.getText())){
						boolean b = iBusinessService.updateBusiness("business_email",login.business_table.getBusiness_id(),newName.getText());
						if (b){
							System.out.println("修改邮箱成功");
							login.business_table.setBusiness_email(newName.getText());
							JOptionPane.showMessageDialog(null,"修改邮箱成功");
						}else {
							System.out.println("修改邮箱失败");
							JOptionPane.showMessageDialog(null,"修改邮箱失败");
						}
					}else {
						System.out.println("修改邮箱失败");
						JOptionPane.showMessageDialog(null,"邮箱格式错误！");
					}
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 22));
		btnNewButton.setBounds(161, 194, 97, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BusinessMainPage view = new BusinessMainPage();
				view.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 10, 97, 23);
		getContentPane().add(btnNewButton_1);
	}

}
