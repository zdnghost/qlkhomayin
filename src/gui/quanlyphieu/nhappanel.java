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

public class nhappanel extends JPanel {
	static JTable table = new JTable();
	static JLabel lbldadtetime;
	static JTextField map;
	static JTextField us;
	static JTextField day;
	static DefaultTableModel model;
	/**
	 * Create the panel.
	 */
	public nhappanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1152, 642);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Phiếu nhập hàng");
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 1132, 60);
		panel.add(lblNewLabel);
		
		JLabel lblmaphieu = new JLabel("Mã phiếu : ");
		lblmaphieu.setForeground(new Color(0, 255, 255));
		lblmaphieu.setBounds(30, 83, 53, 33);
		panel.add(lblmaphieu);
		
		JLabel lbluser = new JLabel("User : ");
		lbluser.setForeground(new Color(0, 255, 255));
		lbluser.setBounds(30, 127, 53, 33);
		panel.add(lbluser);
		
		lbldadtetime = new JLabel("Thời gian : ");
		lbldadtetime.setForeground(new Color(0, 255, 255));
		lbldadtetime.setBounds(526, 82, 92, 33);
		panel.add(lbldadtetime);
		
		nhapcontrol.newtable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 171, 1092, 400);
		panel.add(scrollPane);
		scrollPane.setViewportView(table);
		
		JLabel bback = new JLabel("back");
		bback.setOpaque(true);
		bback.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON1)
				{
					quanlyphieupanel.tab.setSelectedIndex(0);
					quanlyphieucontrol.updatesl();
				}
			}
		});
		bback.setBorder(new LineBorder(new Color(0, 0, 0)));
		bback.setHorizontalAlignment(SwingConstants.CENTER);
		bback.setBounds(30, 582, 73, 24);
		panel.add(bback);
		
		map = new JTextField();
		map.setForeground(new Color(0, 255, 255));
		map.setOpaque(false);
		map.setEditable(false);
		map.setBounds(93, 89, 160, 20);
		panel.add(map);
		map.setColumns(10);
		
		us = new JTextField();
		us.setForeground(new Color(0, 255, 255));
		us.setOpaque(false);
		us.setEditable(false);
		us.setBounds(93, 127, 160, 20);
		panel.add(us);
		us.setColumns(10);
		
		day = new JTextField();
		day.setForeground(new Color(0, 255, 255));
		day.setOpaque(false);
		day.setEditable(false);
		day.setBounds(628, 89, 160, 20);
		panel.add(day);
		day.setColumns(10);
		
		JLabel badd = new JLabel("Thêm hàng");
		badd.setOpaque(true);
		badd.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON1)
				{
					quanlyphieucontrol.getvaule();
				}
			}
		});
		badd.setHorizontalAlignment(SwingConstants.CENTER);
		badd.setBorder(new LineBorder(new Color(0, 0, 0)));
		badd.setBounds(930, 587, 92, 24);
		panel.add(badd);
		
		JLabel bdone = new JLabel("Done");
		bdone.setOpaque(true);
		bdone.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON1)
				{
					if(nhapcontrol.nhap())
					{quanlyphieupanel.tab.setSelectedIndex(0);
					quanlyphieucontrol.newtable();
					quanlyphieucontrol.updatesl();
				}}
			}
		});
		bdone.setHorizontalAlignment(SwingConstants.CENTER);
		bdone.setBorder(new LineBorder(new Color(0, 0, 0)));
		bdone.setBounds(1030, 587, 92, 24);
		panel.add(bdone);
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
