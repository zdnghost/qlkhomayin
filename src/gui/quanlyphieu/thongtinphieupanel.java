package gui.quanlyphieu;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class thongtinphieupanel extends JPanel {
	static JTable table=new JTable();
	static JTextField ma;
	static JTextField us;
	static JTextField l;
	static JTextField day;
	static DefaultTableModel model;
	/**
	 * Create the panel.
	 */
	public thongtinphieupanel() {
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1152, 642);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông tin phiếu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 1132, 60);
		panel.add(lblNewLabel);
		
		JLabel lblmaphieu = new JLabel("Mã phiếu : ");
		lblmaphieu.setBounds(30, 83, 83, 33);
		panel.add(lblmaphieu);
		
		JLabel lbluser = new JLabel("User:");
		lbluser.setBounds(30, 127, 83, 33);
		panel.add(lbluser);
		
		JLabel lblday = new JLabel("Ngày");
		lblday.setBounds(526, 127, 83, 33);
		panel.add(lblday);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 171, 1092, 400);
		panel.add(scrollPane);
		scrollPane.setViewportView(table);
		
		JLabel bback = new JLabel("back");
		bback.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON1)
				{
					quanlyphieupanel.tab.setSelectedIndex(0);
				}
			}
		});
		bback.setBorder(new LineBorder(new Color(0, 0, 0)));
		bback.setHorizontalAlignment(SwingConstants.CENTER);
		bback.setBounds(30, 582, 73, 24);
		panel.add(bback);
		
		JLabel lblLoi = new JLabel("Loại :");
		lblLoi.setBounds(526, 83, 83, 33);
		panel.add(lblLoi);
		
		ma = new JTextField();
		ma.setEditable(false);
		ma.setBounds(123, 89, 185, 20);
		panel.add(ma);
		ma.setColumns(10);
		
		us = new JTextField();
		us.setEditable(false);
		us.setColumns(10);
		us.setBounds(123, 133, 185, 20);
		panel.add(us);
		
		l = new JTextField();
		l.setEditable(false);
		l.setColumns(10);
		l.setBounds(619, 89, 185, 20);
		panel.add(l);
		
		day = new JTextField();
		day.setEditable(false);
		day.setColumns(10);
		day.setBounds(619, 133, 185, 20);
		panel.add(day);

	}
}
