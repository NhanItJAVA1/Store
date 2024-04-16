package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JTable;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import GUI.custom.table.TableActionCellRenderSale;
import GUI.custom.table.TableActionCellEditorSale;
import GUI.custom.table.TableActionEvent;


import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Sale extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldMaSP;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Sale() {
		setBackground(new Color(128, 255, 255));
		setLayout(null);
		
		textFieldMaSP = new JTextField();
		textFieldMaSP.setForeground(new Color(153, 153, 153));
		textFieldMaSP.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textFieldMaSP.getText().equals("Nhập mã sản phẩm"));{
					textFieldMaSP.setText("");
					textFieldMaSP.setForeground(new Color(153,153,153));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textFieldMaSP.getText().equals("")) {
					textFieldMaSP.setText("Nhập mã sản phẩm");
					textFieldMaSP.setForeground(new Color(153,153,153));
				}
			}
		});
		textFieldMaSP.setText("Nhập mã sản phẩm");
		textFieldMaSP.setToolTipText("");
		textFieldMaSP.setBounds(557, 165, 137, 20);
		add(textFieldMaSP);
		textFieldMaSP.setColumns(10);
		
		JPanel panel_Table = new JPanel();
		panel_Table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_Table.setBounds(0, 0, 544, 369);
		add(panel_Table);
		panel_Table.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 544, 335);
		panel_Table.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(30);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setRowSelectionAllowed(false);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"STT", "M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "S\u1ED1 L\u01B0\u1EE3ng", "Th\u00E0nh Ti\u1EC1n ", "Action"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Integer.class, Double.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(2).setPreferredWidth(78);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		scrollPane.setViewportView(table);
		TableActionEvent evt = new TableActionEvent() {		
			@Override
			public void onDelete(int row) {
				if(table.isEditing()) {
					table.getCellEditor().stopCellEditing();
				}
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.removeRow(row);
				
			}

			@Override
			public void onView(int row) {				
			}
			
		};
		
		JLabel lblNewLabel_TotalMoney = new JLabel("Tổng Tiền:\r\n");
		lblNewLabel_TotalMoney.setForeground(new Color(64, 0, 64));
		lblNewLabel_TotalMoney.setBounds(10, 346, 81, 14);
		panel_Table.add(lblNewLabel_TotalMoney);
		
		JLabel lblNewLabel_Money = new JLabel("0");
		lblNewLabel_Money.setEnabled(false);
		lblNewLabel_Money.setForeground(new Color(255, 0, 0));
		lblNewLabel_Money.setBounds(81, 346, 127, 14);
		panel_Table.add(lblNewLabel_Money);
		
		JButton btnNewButton_Qty = new JButton("Số Lượng");
		btnNewButton_Qty.setBackground(new Color(255, 255, 0));
		btnNewButton_Qty.setForeground(new Color(0, 0, 0));
		btnNewButton_Qty.setBounds(564, 11, 60, 60);
		add(btnNewButton_Qty);
		
		JButton btnNewButton_DelAll = new JButton("");
		btnNewButton_DelAll.setIcon(new ImageIcon(Sale.class.getResource("/GUI/Image/delete-all-icon.png")));
		btnNewButton_DelAll.setForeground(new Color(0, 0, 0));
		btnNewButton_DelAll.setBackground(new Color(255, 0, 0));
		btnNewButton_DelAll.setBounds(634, 82, 60, 60);
		add(btnNewButton_DelAll);
		
		JButton btnNewButton_Del = new JButton("");
		btnNewButton_Del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_Del.setIcon(new ImageIcon(Sale.class.getResource("/GUI/Image/Trash-Delete-icon.png")));
		btnNewButton_Del.setForeground(new Color(0, 0, 0));
		btnNewButton_Del.setBackground(new Color(255, 128, 128));
		btnNewButton_Del.setBounds(634, 11, 60, 60);
		add(btnNewButton_Del);
		
		JButton btnNewButton_Pay = new JButton("");
		btnNewButton_Pay.setIcon(new ImageIcon(Sale.class.getResource("/GUI/Image/cash.png")));
		btnNewButton_Pay.setForeground(new Color(0, 0, 0));
		btnNewButton_Pay.setBackground(new Color(0, 255, 0));
		btnNewButton_Pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_Pay.setBounds(564, 82, 60, 60);
		add(btnNewButton_Pay);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(500, 350, 217, 260);
		add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_7 = new JButton("7");
		btnNewButton_7.setBackground(new Color(255, 255, 255));
		btnNewButton_7.setBounds(10, 12, 59, 51);
		panel.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("8");
		btnNewButton_8.setBackground(new Color(255, 255, 255));
		btnNewButton_8.setBounds(79, 12, 49, 51);
		panel.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("9");
		btnNewButton_9.setBackground(new Color(255, 255, 255));
		btnNewButton_9.setBounds(138, 12, 69, 51);
		panel.add(btnNewButton_9);
		
		JButton btnNewButton_4 = new JButton("4");
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setBounds(10, 74, 59, 51);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("5");
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		btnNewButton_5.setBounds(79, 74, 49, 51);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("6");
		btnNewButton_6.setBackground(new Color(255, 255, 255));
		btnNewButton_6.setBounds(138, 74, 69, 51);
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_3 = new JButton("1");
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setBounds(10, 136, 59, 51);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("2");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(79, 136, 49, 51);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("3");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(138, 136, 69, 51);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_DelAllNum = new JButton("");
		btnNewButton_DelAllNum.setBackground(new Color(255, 255, 255));
		btnNewButton_DelAllNum.setIcon(new ImageIcon(Sale.class.getResource("/GUI/Image/Editing-Delete-icon.png")));
		btnNewButton_DelAllNum.setBounds(10, 198, 83, 51);
		panel.add(btnNewButton_DelAllNum);
		
		JButton btnNewButton_0 = new JButton("0");
		btnNewButton_0.setBackground(new Color(255, 255, 255));
		btnNewButton_0.setBounds(162, 198, 49, 51);
		panel.add(btnNewButton_0);
		
		JButton btnNewButton_DelNum = new JButton("");
		btnNewButton_DelNum.setBackground(new Color(255, 255, 255));
		btnNewButton_DelNum.setIcon(new ImageIcon(Sale.class.getResource("/GUI/Image/delete-icon.png")));
		btnNewButton_DelNum.setBounds(103, 198, 49, 51);
		panel.add(btnNewButton_DelNum);
		
		JButton btnNewButton_Tick = new JButton("");
		btnNewButton_Tick.setIcon(new ImageIcon(Sale.class.getResource("/GUI/Image/icon_tick.png")));
		btnNewButton_Tick.setBounds(704, 159, 27, 23);
		add(btnNewButton_Tick);
		
		JLabel lblNewLabel_BienLai = new JLabel("Số Biên Lai:");
		lblNewLabel_BienLai.setBounds(10, 391, 69, 14);
		add(lblNewLabel_BienLai);
		
		JLabel lblNewLabel_SoBienLai = new JLabel("00000001A");
		lblNewLabel_SoBienLai.setBounds(89, 391, 166, 14);
		add(lblNewLabel_SoBienLai);
		
		
//		String header[] = "STT;Mã Sản Phẩm;Tên Sản Phẩm;Số Lượng;Giá".split(";");


	}
}
