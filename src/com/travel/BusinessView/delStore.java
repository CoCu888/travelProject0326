package com.travel.BusinessView;

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

import com.travel.domain.Store_table;
import com.travel.service.impl.IBusinessServiceImpl;

public class delStore extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Integer id;
	protected static final Integer Integer = null;
	private JTextField textField_type;
	private JTextField textField_name;
	private JTextField textField_city;
	private JTextArea textArea_introduce;
	private JTextField textField_address;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delStore frame = new delStore();
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
	public delStore() throws Exception {
		setTitle("商铺界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 701);
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
				System.out.println((Integer)table.getValueAt(row, 0));
				id = (Integer)table.getValueAt(row, 0);
				textField_city.setText((String) table.getValueAt(row, 1));
				textField_name.setText((String) table.getValueAt(row, 2));
				textField_type.setText((String) table.getValueAt(row, 3));
				textField_address.setText((String)table.getValueAt(row, 4));
				textArea_introduce.setText((String)table.getValueAt(row, 5));
			}
		});
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"店铺序号","店铺所在城市","店铺名字", "店铺类型", "店铺地址","店铺介绍"
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(35, 273, 500, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("类型");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(12, 28, 60, 24);
		panel.add(lblNewLabel);
		
		textField_type = new JTextField();
		textField_type.setEditable(false);
		textField_type.setBounds(56, 31, 65, 24);
		panel.add(textField_type);
		textField_type.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("店名");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(208, 32, 65, 22);
		panel.add(lblNewLabel_1);
		
		textField_name = new JTextField();
		textField_name.setEditable(false);
		textField_name.setBounds(254, 34, 221, 24);
		panel.add(textField_name);
		textField_name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("城市");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 83, 76, 22);
		panel.add(lblNewLabel_2);
		
		textField_city = new JTextField();
		textField_city.setEditable(false);
		textField_city.setBounds(56, 79, 117, 26);
		panel.add(textField_city);
		textField_city.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("商品介绍");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(12, 139, 92, 26);
		panel.add(lblNewLabel_3);
		
		textArea_introduce = new JTextArea();
		textArea_introduce.setEditable(false);
		textArea_introduce.setBounds(22, 175, 453, 76);
		panel.add(textArea_introduce);
		
		JLabel lblNewLabel_2_1 = new JLabel("地址");
		lblNewLabel_2_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(208, 83, 76, 22);
		panel.add(lblNewLabel_2_1);
		
		textField_address = new JTextField();
		textField_address.setEditable(false);
		textField_address.setColumns(10);
		textField_address.setBounds(254, 79, 221, 26);
		panel.add(textField_address);
		
		JButton btnNewButton_1 = new JButton("删除");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					IBusinessServiceImpl iBusinessService = new IBusinessServiceImpl();
					String s = iBusinessService.delStore(id);
					JOptionPane.showMessageDialog(null,s);
					if(s.equals("删除成功")) {
						fillDate();
					}
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(227, 564, 97, 23);
		contentPane.add(btnNewButton_1);
		
		fillDate();
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
			vector.add(obj.getStore_introduce());
			dtm.addRow(vector);
		}
	}
	

}
