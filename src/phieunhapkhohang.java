import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class phieunhapkhohang extends JPanel {
	private JTable table;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public phieunhapkhohang() {
		setBackground(new Color(204, 204, 255));
		setLayout(null);
		
		JButton btnNewButton = new JButton("CREATE");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(255, 255, 128));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(0, 126, 85, 21);
		add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(85, 126, 754, 241);
		add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBackground(new Color(204, 255, 255));
		table.setForeground(new Color(0, 0, 0));
		table.setCellSelectionEnabled(true);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setFont(new Font("Times New Roman", Font.BOLD, 14));
		table.setBounds(0, 0, 754, 240);
		panel.add(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"STT", "T\u00EAn H\u00E0ng", "M\u00E3 H\u00E0ng", "Lo\u1EA1i", "S\u1ED1 L\u01B0\u1EE3ng", "Ghi Ch\u00FA"},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(26);
		table.getColumnModel().getColumn(1).setPreferredWidth(135);
		table.getColumnModel().getColumn(3).setPreferredWidth(81);
		table.getColumnModel().getColumn(4).setPreferredWidth(48);
		table.getColumnModel().getColumn(5).setPreferredWidth(116);
		
		JButton btnNewButton_1 = new JButton("ADD");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 255, 128));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_1.setBounds(0, 172, 85, 21);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBackground(new Color(255, 255, 128));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_2.setBounds(0, 220, 85, 21);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("EDIT");
		btnNewButton_3.setBackground(new Color(255, 255, 128));
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_3.setBounds(0, 269, 85, 21);
		add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("SEARCH ");
		btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_4.setForeground(new Color(0, 128, 255));
		btnNewButton_4.setBackground(new Color(255, 255, 128));
		btnNewButton_4.setBounds(746, 86, 93, 21);
		add(btnNewButton_4);
		
		textField = new JTextField();
		textField.setBounds(85, 85, 661, 21);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("DONE");
		btnNewButton_5.setForeground(new Color(0, 128, 255));
		btnNewButton_5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_5.setBackground(UIManager.getColor("Button.highlight"));
		btnNewButton_5.setBounds(733, 376, 106, 32);
		add(btnNewButton_5);
		
		JTextArea txtrPhiuNhpHng = new JTextArea();
		txtrPhiuNhpHng.setBackground(new Color(255, 255, 204));
		txtrPhiuNhpHng.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtrPhiuNhpHng.setText("\r\n\t\t     PHIẾU NHẬP HÀNG HÓA");
		txtrPhiuNhpHng.setBounds(0, 0, 839, 72);
		add(txtrPhiuNhpHng);
		
		JButton btnNewButton_6 = new JButton("REFESH");
		btnNewButton_6.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_6.setBackground(new Color(255, 255, 128));
		btnNewButton_6.setBounds(0, 316, 85, 21);
		add(btnNewButton_6);

	}
}
