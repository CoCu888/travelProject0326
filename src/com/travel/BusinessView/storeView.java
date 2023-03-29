package com.travel.BusinessView;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.travel.domain.Store_table;
import com.travel.service.impl.IBusinessServiceImpl;
import com.travel.service.impl.IStoreServiceImpl;
import com.travel.view.userMainPage;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class storeView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static Integer id;
	protected static final Integer Integer = null;
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
					storeView frame = new storeView();
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
	public storeView() throws Exception {
		setTitle("商铺界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 60, 467, 178);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row = table.getSelectedRow();
				id = (Integer)table.getValueAt(row, 0);
				try {
					goodsView view = new goodsView();
					view.setVisible(true);
					dispose();
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"店铺序号","店铺所在城市", "店铺名字", "商品类型","店铺地址"
				}
			));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("返回");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BusinessMainPage view = new BusinessMainPage();
				view.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 22));
		btnNewButton.setBounds(0, 10, 106, 29);
		contentPane.add(btnNewButton);
		
//		JPanel panel = new JPanel();
//		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
//		panel.setBounds(35, 273, 500, 261);
//		contentPane.add(panel);
//		panel.setLayout(null);
//		
//		JLabel lblNewLabel = new JLabel("编号");
//		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
//		lblNewLabel.setBounds(10, 31, 60, 24);
//		panel.add(lblNewLabel);
//		
//		textField_id = new JTextField();
//		textField_id.setEditable(false);
//		textField_id.setBounds(56, 31, 48, 24);
//		panel.add(textField_id);
//		textField_id.setColumns(10);
//		
//		JLabel lblNewLabel_1 = new JLabel("名字");
//		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
//		lblNewLabel_1.setBounds(124, 31, 65, 22);
//		panel.add(lblNewLabel_1);
//		
//		textField_name = new JTextField();
//		textField_name.setEditable(false);
//		textField_name.setBounds(173, 33, 186, 24);
//		panel.add(textField_name);
//		textField_name.setColumns(10);
//		
//		JLabel lblNewLabel_2 = new JLabel("价格");
//		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
//		lblNewLabel_2.setBounds(10, 83, 76, 22);
//		panel.add(lblNewLabel_2);
//		
//		textField_price = new JTextField();
//		textField_price.setEditable(false);
//		textField_price.setBounds(56, 79, 117, 26);
//		panel.add(textField_price);
//		textField_price.setColumns(10);
//		
//		JLabel lblNewLabel_3 = new JLabel("商品介绍");
//		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
//		lblNewLabel_3.setBounds(12, 139, 92, 26);
//		panel.add(lblNewLabel_3);
//		
//		textArea_introduce = new JTextArea();
//		textArea_introduce.setEditable(false);
//		textArea_introduce.setBounds(22, 175, 453, 76);
//		panel.add(textArea_introduce);
//		
//		JButton btnNewButton_1 = new JButton("删除");
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Integer store_id = Integer.parseInt(textField_id.getText());
//				try {
//					IBusinessServiceImpl iBusinessService = new IBusinessServiceImpl();
//					String s = iBusinessService.delStore(store_id);
//					JOptionPane.showMessageDialog(null,s);
//					if(s.equals("删除成功")) {
//						fillDate();
//					}
//				} catch (Exception e1) {
//					// TODO 自动生成的 catch 块
//					e1.printStackTrace();
//				}
//			}
//		});
//		btnNewButton_1.setBounds(227, 564, 97, 23);
//		contentPane.add(btnNewButton_1);
		fillDate();
	}
	
	public static Integer getid(){
		return id;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	void fillDate() throws Exception {
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
        IBusinessServiceImpl iBusinessService = new IBusinessServiceImpl();
        List<Store_table> myStore = iBusinessService.getMyStore(login.getBusiness().getBusiness_id());

		for (Store_table obj :myStore) {
			Vector vector = new Vector();
			vector.add(obj.getStore_id());
			vector.add(obj.getStore_city());
			vector.add(obj.getStore_name());
			vector.add(obj.getStore_type());
			vector.add(obj.getStore_address());
			dtm.addRow(vector);
		}
	}
	
}
