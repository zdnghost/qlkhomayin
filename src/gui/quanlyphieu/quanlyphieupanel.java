package gui.quanlyphieu;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import gui.menuframe;
import gui.chinhsua.manegerpanel;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Font;

public class quanlyphieupanel extends JPanel {
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
	static LocalDateTime now;
	static JTable table=new JTable();
    static DefaultTableModel model;
    static JTabbedPane tab;
    static JPanel bxuat = new JPanel();
    static JPanel bnhap = new JPanel();
    static JPanel button = new JPanel();
	/**
	 * Create the panel.
	 */
	public quanlyphieupanel() {
		setLayout(null);
		bxuat = new JPanel();
	    bnhap = new JPanel();
	    button = new JPanel();
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1152, 641);
		add(panel);
		panel.setLayout(null);
		
		tab = new JTabbedPane(JTabbedPane.TOP);
		tab.setBounds(-2, -25, 1152, 679);
		panel.add(tab);
		
		JPanel quanlyphieu = new JPanel();
		quanlyphieu.setBorder(new LineBorder(new Color(0, 0, 0)));
		tab.addTab("New tab", null, quanlyphieu, null);
		quanlyphieu.setLayout(null);
		
		
		bnhap.setBounds(10, 86, 132, 38);
		
		button.setOpaque(false);
        
		
        quanlyphieu.add(button);
        button.setLayout(new GridLayout(0, 1, 0, 0));
       
		bnhap.setLayout(new GridLayout(0, 1, 0, 0));
		//bnhap
		JLabel bphieunhap = new JLabel("Tạo phiếu nhập");
		bphieunhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON1){
					now= LocalDateTime.now(); 
					tab.setSelectedIndex(1);
					quanlyphieucontrol.chonhang.resettable();
					nhapcontrol.newtable();
					nhappanel.day.setText(dtf.format(now));
					nhappanel.us.setText(menuframe.user.username);
					nhappanel.map.setText(nhapcontrol.lastma());
				}
			}
		});
		bphieunhap.setBorder(new LineBorder(new Color(0, 0, 0)));
		bphieunhap.setHorizontalAlignment(SwingConstants.CENTER);
		
		bnhap.add(bphieunhap);
		
		
		bxuat.setBounds(10, 135, 132, 38);
		bxuat.setLayout(new GridLayout(1, 0, 0, 0));
		JLabel bphieuxuat = new JLabel("Tạo phiếu xuất");
		bphieuxuat.setBorder(new LineBorder(new Color(0, 0, 0)));
		bphieuxuat.setHorizontalAlignment(SwingConstants.CENTER);
		bxuat.add(bphieuxuat);
		//bxuat
		bphieuxuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON1){
					now= LocalDateTime.now(); 
					tab.setSelectedIndex(2);
					quanlyphieucontrol.chonhang.resettable();
					xuatcontrol.newtable();
					xuatpanel.day.setText(dtf.format(now));
					xuatpanel.us.setText(menuframe.user.username);
					xuatpanel.map.setText(xuatcontrol.lastma());
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(184, 11, 953, 611);
		quanlyphieucontrol.newtable();
		quanlyphieu.add(scrollPane);
		 table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 table.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mousePressed(MouseEvent e) {
		 		if(e.getButton()==MouseEvent.BUTTON1) {
		 			int i=table.getSelectedRow();
		 			String ma=table.getValueAt(i, 0).toString();
		 			thongtinphieucontrol.setphieu(ma);
		 			tab.setSelectedIndex(3);
		 		}
		 	}
		 });
		 scrollPane.setViewportView(table);
		nhappanel nhap=new nhappanel();
		nhap.setBounds(0, 0, 1152, 642);
		JPanel phieunhap = new JPanel();
		tab.addTab("New tab", null, phieunhap, null);
		phieunhap.setLayout(null);
		phieunhap.add(nhap);
		
		xuatpanel xuat=new xuatpanel();
		xuat.setBounds(0, 0, 1152, 642);
		xuat.setVisible(true);
		JPanel phieuxuat = new JPanel();
		tab.addTab("New tab", null, phieuxuat, null);
		phieuxuat.setLayout(null);
		phieuxuat.add(xuat);
		thongtinphieupanel phieut=new thongtinphieupanel();
		JPanel phieu = new JPanel();
		tab.addTab("New tab", null, phieu, null);
		phieu.setLayout(null);
		phieut.setBounds(0, 0, 1152, 642);
		phieu.add(phieut);
		//background	
				ImageIcon background=new ImageIcon("src\\gui\\icon\\bg.png");
				Image icon=background.getImage();
				Image newicon=icon.getScaledInstance(1280, 750, Image.SCALE_SMOOTH);
		        background=new ImageIcon(newicon);
		        JLabel lblbackground = new JLabel("New label");
		        lblbackground.setBounds(0, 0, 1152, 642);
		        quanlyphieu.add(lblbackground);
		        lblbackground.setFont(new Font("Tahoma", Font.PLAIN, 16));
		        lblbackground.setIcon(background);
		        
		        
		
	}
}
