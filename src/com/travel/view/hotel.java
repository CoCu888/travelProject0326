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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.travel.domain.Store_table;
import com.travel.service.impl.UserServiceImpl;
import javax.swing.JTable;

public class hotel extends JFrame {

	private JPanel contentPane;
	private JTable table;
	@SuppressWarnings("unused")
	private static Integer hotel_id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hotel frame = new hotel();
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
	public hotel() throws Exception {
		setTitle("酒店商铺列表");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(69, 66, 489, 228);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row = table.getSelectedRow();
				hotel_id = (Integer)table.getValueAt(row, 0);
//				JOptionPane.showMessageDialog(null,hotel_id);
				StoregoodsHetol view = null;
				try {
					view = new StoregoodsHetol();
					view.setVisible(true);
					dispose();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id","\u5E97\u540D", "\u7C7B\u578B", "\u5730\u5740", "\u4ECB\u7ECD"
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
		fillDate();
	}
	
	public static Integer getHotelId(){
		return hotel_id;
	}
	
	void fillDate() throws Exception {
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		UserServiceImpl userService = new UserServiceImpl();
		JTextField city = userMainPage.getCity();
		String text = city.getText();
		List<Store_table> storeByType = userService.getStoreByType(text,"酒店");
		for (Store_table obj :storeByType) {
			Vector vector = new Vector();
			vector.add(obj.getStore_id());
			vector.add(obj.getStore_name());
			vector.add(obj.getStore_type());
			vector.add(obj.getStore_address());
			vector.add(obj.getStore_introduce());
			dtm.addRow(vector);
		}
	}
}
