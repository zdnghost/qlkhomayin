package gui.quanlyphieu;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

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
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 1132, 60);
		panel.add(lblNewLabel);
		
		JLabel lblmaphieu = new JLabel("Mã phiếu : ");
		lblmaphieu.setForeground(new Color(0, 255, 255));
		lblmaphieu.setBounds(30, 83, 83, 33);
		panel.add(lblmaphieu);
		
		JLabel lbluser = new JLabel("User:");
		lbluser.setForeground(new Color(0, 255, 255));
		lbluser.setBounds(30, 127, 83, 33);
		panel.add(lbluser);
		
		JLabel lblday = new JLabel("Ngày");
		lblday.setForeground(new Color(0, 255, 255));
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
		lblLoi.setForeground(new Color(0, 255, 255));
		lblLoi.setBounds(526, 83, 83, 33);
		panel.add(lblLoi);
		
		ma = new JTextField();
		ma.setOpaque(false);
		ma.setForeground(new Color(0, 255, 255));
		ma.setEditable(false);
		ma.setBounds(123, 89, 185, 20);
		panel.add(ma);
		ma.setColumns(10);
		
		us = new JTextField();
		us.setOpaque(false);
		us.setForeground(new Color(0, 255, 255));
		us.setEditable(false);
		us.setColumns(10);
		us.setBounds(123, 133, 185, 20);
		panel.add(us);
		
		l = new JTextField();
		l.setOpaque(false);
		l.setForeground(new Color(0, 255, 255));
		l.setEditable(false);
		l.setColumns(10);
		l.setBounds(619, 89, 185, 20);
		panel.add(l);
		
		day = new JTextField();
		day.setOpaque(false);
		day.setForeground(new Color(0, 255, 255));
		day.setEditable(false);
		day.setColumns(10);
		day.setBounds(619, 133, 185, 20);
		panel.add(day);
		//background	
				ImageIcon background=new ImageIcon("src\\gui\\icon\\bg.png");
				Image icon=background.getImage();
				Image newicon=icon.getScaledInstance(1280, 750, Image.SCALE_SMOOTH);
		        background=new ImageIcon(newicon);
		        JLabel lblbackground = new JLabel("New label");
		        lblbackground.setBounds(0, 0, 1152, 642);
		        panel.add(lblbackground);
		        lblbackground.setFont(new Font("Tahoma", Font.PLAIN, 16));
		        lblbackground.setIcon(background);
	}
}
