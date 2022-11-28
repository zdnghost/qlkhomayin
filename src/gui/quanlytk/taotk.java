package gui.quanlytk;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import database.sever;
import moudel.user;

import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class taotk extends JPanel {
	private static JTextField username;
	private static JTextField hoten;
	private static JTextField cmnd;
	private static JPasswordField pass;
	private static JPasswordField comf;
	private static final ButtonGroup cv = new ButtonGroup();
	private static JRadioButton nv;
	private static JRadioButton xuat;
	private static JRadioButton nhap;
	private static JRadioButton admin;
	

	/**
	 * Create the panel.
	 * @return 
	 */
	private static boolean tao()
	{
		String sql="insert into USERDB ";
		String pas=new String(pass.getPassword());
		String com=new String(comf.getPassword());
		if(user.check(username.getText().trim())) {
		if(username.getText().equals("")||hoten.getText().equals("")||cmnd.getText().equals("")||pas.equals("")||com.equals(""))
			{JOptionPane.showMessageDialog(null,"vui lòng nhập đầy đủ thông tin");
			return false;
			}
		else
		{
			if(pas.equals(com))
			{
				int i=0;
				if(nv.isSelected())
					i=0;
				if(xuat.isSelected())
					i=1;
				if(nhap.isSelected())
					i=2;
				if(admin.isSelected())
					i=3;
				sql+="values('"+username.getText()+"','"+pas+"','"+i+"','"+hoten.getText()+"','"+cmnd.getText()+"')";
				return sever.update(sql);
			}
			else
				{
				JOptionPane.showMessageDialog(null,"mật khẩu không trùng khớp ");	
				return false;
				}
			}
		}
		else
			{
			JOptionPane.showMessageDialog(null,"username này đã tồn tại ");
			return false;
		}
	}
	
	static void reset()
	{
		username.setText("");
		hoten.setText("");
		cmnd.setText("");
		comf.setText("");
		pass.setText("");
		nv.setSelected(true);
	}
	
	public taotk() {
		setForeground(new Color(0, 255, 255));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 1152, 642);
		add(panel);
		panel.setLayout(null);
		
		username = new JTextField();
		username.setForeground(new Color(0, 0, 0));
		username.setFont(new Font("Tahoma", Font.PLAIN, 20));
		username.setBounds(445, 125, 401, 44);
		panel.add(username);
		username.setColumns(10);
		
		hoten = new JTextField();
		hoten.setForeground(new Color(0, 0, 0));
		hoten.setFont(new Font("Tahoma", Font.PLAIN, 20));
		hoten.setColumns(10);
		hoten.setBounds(445, 180, 401, 44);
		panel.add(hoten);
		
		cmnd = new JTextField();
		cmnd.setForeground(new Color(0, 0, 0));
		cmnd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmnd.setColumns(10);
		cmnd.setBounds(445, 235, 401, 44);
		panel.add(cmnd);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setForeground(new Color(0, 255, 255));
		panel_1.setBounds(445, 290, 401, 72);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		nv = new JRadioButton("nhân viên");
		nv.setOpaque(false);
		nv.setForeground(new Color(0, 255, 255));
		nv.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cv.add(nv);
		panel_1.add(nv);
		
		xuat = new JRadioButton("quản lý xuất hàng");
		xuat.setOpaque(false);
		xuat.setForeground(new Color(0, 255, 255));
		xuat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cv.add(xuat);
		panel_1.add(xuat);
		
		nhap = new JRadioButton("quản lý nhập hàng");
		nhap.setOpaque(false);
		nhap.setForeground(new Color(0, 255, 255));
		nhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cv.add(nhap);
		panel_1.add(nhap);
		
		admin = new JRadioButton("ADMIN");
		admin.setOpaque(false);
		admin.setForeground(new Color(0, 255, 255));
		admin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cv.add(admin);
		panel_1.add(admin);
		
		pass = new JPasswordField();
		pass.setForeground(new Color(0, 0, 0));
		pass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pass.setBounds(445, 373, 401, 44);
		panel.add(pass);
		
		comf = new JPasswordField();
		comf.setForeground(new Color(0, 0, 0));
		comf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comf.setBounds(445, 428, 401, 44);
		panel.add(comf);
		
		JLabel lblNewLabel = new JLabel("Username :");
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(306, 125, 129, 44);
		panel.add(lblNewLabel);
		
		JLabel lblHTn = new JLabel("Họ tên :");
		lblHTn.setForeground(new Color(0, 255, 255));
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHTn.setBounds(306, 180, 129, 44);
		panel.add(lblHTn);
		
		JLabel lblCmnd = new JLabel("CMND :");
		lblCmnd.setForeground(new Color(0, 255, 255));
		lblCmnd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCmnd.setBounds(306, 235, 129, 44);
		panel.add(lblCmnd);
		
		JLabel lblChcV = new JLabel("Chức vụ :");
		lblChcV.setForeground(new Color(0, 255, 255));
		lblChcV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChcV.setBounds(306, 290, 129, 44);
		panel.add(lblChcV);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setForeground(new Color(0, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(306, 373, 129, 44);
		panel.add(lblPassword);
		
		JLabel lblComfrim = new JLabel("Comfrim :");
		lblComfrim.setForeground(new Color(0, 255, 255));
		lblComfrim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblComfrim.setBounds(306, 428, 129, 44);
		panel.add(lblComfrim);
		
		JLabel lblNewLabel_1 = new JLabel("Back");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON1)
				{
					dsuserpanel.tab.setSelectedIndex(0);
				}
			}
		});
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 596, 97, 35);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tạo ");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON1)
				{
					if(tao())
					dsuserpanel.tab.setSelectedIndex(0);
					dsuserpanel.resettable();
				}
			}
		});
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(1045, 596, 97, 35);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tạo tài khoản mới");
		lblNewLabel_2.setForeground(new Color(0, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 11, 1132, 90);
		panel.add(lblNewLabel_2);
		ImageIcon background=new ImageIcon("src\\gui\\icon\\bg.png");
		Image icon=background.getImage();
		Image newicon=icon.getScaledInstance(1280, 750, Image.SCALE_SMOOTH);
        background=new ImageIcon(newicon);
        JLabel lblbackground = new JLabel("New label");
        lblbackground.setBounds(0, 0, 1152, 642);
        lblbackground.setIcon(background);
        panel.add(lblbackground);
	}
}
