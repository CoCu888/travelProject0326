package com.travel.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.travel.domain.Goods_table;
import com.travel.domain.Order_table;
import com.travel.domain.User_table;
import com.travel.service.impl.UserServiceImpl;

public class orderListView extends JFrame {
	
	private JPanel contentPane;
	private JTable table;
	private JTextField textField_id;
	private JTextField textField_name;
	private JTextField textField_price;
	private JTextArea textArea_introduce;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					orderListView frame = new orderListView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public orderListView() throws Exception {
		setTitle("订单列表");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 699);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(69, 66, 489, 203);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row = table.getSelectedRow();
				textField_id.setText(((Integer)table.getValueAt(row, 0)+""));
				textField_name.setText((String)table.getValueAt(row,1));
				textField_price.setText((Double)table.getValueAt(row,2)+"");
				textArea_introduce.setText((String) table.getValueAt(row,3));
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"订单序号","商品名字", "商品价格", "商品介绍"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("返回");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        userMainPage usermainpage = new userMainPage();
		        usermainpage.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 22));
		btnNewButton.setBounds(0, 10, 106, 29);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(69, 305, 489, 257);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("编号");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 31, 60, 24);
		panel.add(lblNewLabel);
		
		textField_id = new JTextField();
		textField_id.setEditable(false);
		textField_id.setBounds(56, 31, 48, 24);
		panel.add(textField_id);
		textField_id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("名字");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(124, 31, 65, 22);
		panel.add(lblNewLabel_1);
		
		textField_name = new JTextField();
		textField_name.setEditable(false);
		textField_name.setBounds(173, 33, 186, 24);
		panel.add(textField_name);
		textField_name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("价格");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 83, 76, 22);
		panel.add(lblNewLabel_2);
		
		textField_price = new JTextField();
		textField_price.setEditable(false);
		textField_price.setBounds(56, 79, 117, 26);
		panel.add(textField_price);
		textField_price.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("商品介绍");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(12, 139, 92, 26);
		panel.add(lblNewLabel_3);
		
		textArea_introduce = new JTextArea();
		textArea_introduce.setEditable(false);
		textArea_introduce.setBounds(22, 175, 453, 76);
		panel.add(textArea_introduce);
		
		JButton btnNewButton_1 = new JButton("删除");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserServiceImpl userService = new UserServiceImpl();
				boolean b = userService.delOrder(Integer.parseInt(textField_id.getText()));
				if(b){
					JOptionPane.showMessageDialog(null,"删除订单成功");
				}else {
					JOptionPane.showMessageDialog(null,"删除订单失败,请选择新的订单");
				}
				
				try {
					fillDate();
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(263, 600, 97, 23);
		contentPane.add(btnNewButton_1);
		fillDate();
	}
	
	void fillDate() throws Exception {
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
        UserServiceImpl userService = new UserServiceImpl();
        List<Order_table> orderList = (List<Order_table>) userService.getOrderList(TestJFrame.user.getUser_id());

		for (Order_table obj :orderList) {
			Vector vector = new Vector();
			vector.add(obj.getOrder_id());
			vector.add(obj.getOrder_name());
			vector.add(obj.getOrder_price());
			vector.add(obj.getOrder_introduce());
			dtm.addRow(vector);
		}
	}

}
