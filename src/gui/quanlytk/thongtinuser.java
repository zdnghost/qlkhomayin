package gui.quanlytk;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;

import database.sever;
import gui.menuframe;
import moudel.mayin;
import moudel.user;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JPasswordField;

public class thongtinuser extends JPanel {
	public String username="";
	private JTextField user;
	private JTextField hoten;
	private JTextField cmnd;
	private JTextField chucvu;
	private JPasswordField passnow;
	private JPasswordField passnew;
	private JPasswordField comf;
	private static user us;
	/**
	 * Create the panel.
	 */
	public void load()
	{
		String Sql="select * from USERDB,CHUCVU where USERDB.CHUCVU=CHUCVU.CHUCVU AND USERNAME='"+username+"'";
        ResultSet data;
      try {
          data = sever.getquery(Sql);
          user a=new user();
        while(data.next())
        a.datatoobject(data);
        user.setText(a.username);
        hoten.setText(a.hoten);
        cmnd.setText(a.cmnd);
        chucvu.setText(a.chucvu);
        us=a;
      } 
      catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }
        
    }  	
	void chpass()
	{
		String nowpass=new String(passnow.getPassword());
		String newpass=new String(passnew.getPassword());
		String comfpass=new String(comf.getPassword());
		if(nowpass.equals(us.password))
		{
			if(!newpass.equals(" ")||!nowpass.equals(" ")||!comfpass.equals(" "))
			{if(!newpass.equals(nowpass))
			{	if(newpass.equals(comfpass))
				{
					String sql="UPDATE USERDB SET PASSWORD ='"+newpass+"' WHERE USERNAME='"+username+"'";
					
					if(sever.update(sql))
					JOptionPane.showMessageDialog(null,"đã thay đổi password");
				}
				else
					JOptionPane.showMessageDialog(null,"password mới và xác nhận password không giống nhau");
			}	
			else
				JOptionPane.showMessageDialog(null,"password mới và password hiện tại giống nhau");	}
			else
				JOptionPane.showMessageDialog(null,"vui lòng nhập đầy đủ");
		}
		else
		{
			JOptionPane.showMessageDialog(null,"password hiện tại không đúng");	
		}
	}
	public thongtinuser() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông tin người dùng ");
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 11, 1132, 103);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 150, 144, 38);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Họ tên");
		lblNewLabel_1_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 248, 154, 38);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("CMND");
		lblNewLabel_1_1_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(10, 297, 154, 38);
		add(lblNewLabel_1_1_1);
		
		user = new JTextField();
		user.setBorder(null);
		user.setForeground(new Color(0, 255, 255));
		user.setOpaque(false);
		user.setFont(new Font("Tahoma", Font.PLAIN, 20));
		user.setEditable(false);
		user.setBounds(174, 151, 274, 38);
		add(user);
		user.setColumns(10);
		
		hoten = new JTextField();
		hoten.setBorder(null);
		hoten.setForeground(new Color(0, 255, 255));
		hoten.setOpaque(false);
		hoten.setFont(new Font("Tahoma", Font.PLAIN, 20));
		hoten.setEditable(false);
		hoten.setColumns(10);
		hoten.setBounds(174, 249, 274, 38);
		add(hoten);
		
		cmnd = new JTextField();
		cmnd.setBorder(null);
		cmnd.setForeground(new Color(0, 255, 255));
		cmnd.setOpaque(false);
		cmnd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmnd.setEditable(false);
		cmnd.setColumns(10);
		cmnd.setBounds(174, 298, 274, 38);
		add(cmnd);
		
		chucvu = new JTextField();
		chucvu.setBorder(null);
		chucvu.setForeground(new Color(0, 255, 255));
		chucvu.setOpaque(false);
		chucvu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chucvu.setEditable(false);
		chucvu.setColumns(10);
		chucvu.setBounds(174, 200, 274, 38);
		add(chucvu);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Chức vụ:");
		lblNewLabel_1_1_1_2.setForeground(new Color(0, 255, 255));
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_2.setBounds(10, 199, 144, 38);
		add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("BACK");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON1)
				{
					menuframe.tab.setSelectedIndex(menuframe.indextab);
					dsuserpanel.tab.setSelectedIndex(0);
					if(menuframe.indextab==0)
						menuframe.bmenu1.setBackground(Color.cyan);
					if(menuframe.indextab==1)
						menuframe.bmenu2.setBackground(Color.cyan);
					if(menuframe.indextab==2) 
						menuframe.bmenu3.setBackground(Color.cyan);
					if(menuframe.indextab==3) 
						menuframe.bmenu4.setBackground(Color.cyan);
					if(menuframe.indextab==4) 
						menuframe.bmenu5.setBackground(Color.cyan);
				}
			}
		});
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 593, 100, 38);
		add(lblNewLabel_2);
		ImageIcon background=new ImageIcon("src\\gui\\icon\\bg.png");
		Image icon=background.getImage();
		Image newicon=icon.getScaledInstance(1280, 750, Image.SCALE_SMOOTH);
        background=new ImageIcon(newicon);
        
        JPanel pass = new JPanel();
        pass.setOpaque(false);
        pass.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0110\u1ED5i m\u1EADt kh\u1EA9u", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 255, 255)));
        pass.setBounds(467, 125, 560, 210);
        add(pass);
        pass.setLayout(null);
        
        JLabel lblNewLabel_3 = new JLabel("Password hiện tại");
        lblNewLabel_3.setForeground(new Color(0, 255, 255));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_3.setBounds(10, 11, 167, 38);
        pass.add(lblNewLabel_3);
        
        JLabel lblNewLabel_3_1 = new JLabel("Password mới");
        lblNewLabel_3_1.setForeground(new Color(0, 255, 255));
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_3_1.setBounds(10, 60, 167, 38);
        pass.add(lblNewLabel_3_1);
        
        JLabel lblNewLabel_3_2 = new JLabel("Nhập lại Password");
        lblNewLabel_3_2.setForeground(new Color(0, 255, 255));
        lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_3_2.setBounds(10, 109, 167, 38);
        pass.add(lblNewLabel_3_2);
        
        passnow = new JPasswordField();
        passnow.setFont(new Font("Tahoma", Font.PLAIN, 20));
        passnow.setBounds(187, 11, 200, 38);
        pass.add(passnow);
        
        passnew = new JPasswordField();
        passnew.setFont(new Font("Tahoma", Font.PLAIN, 20));
        passnew.setBounds(187, 60, 200, 38);
        pass.add(passnew);
        
        comf = new JPasswordField();
        comf.setFont(new Font("Tahoma", Font.PLAIN, 20));
        comf.setBounds(187, 109, 200, 38);
        pass.add(comf);
        
        JLabel lblNewLabel_4 = new JLabel("DONE");
        lblNewLabel_4.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
        		if(e.getButton()==MouseEvent.BUTTON1)
        		{
        			chpass();
        		}
        	}
        });
        lblNewLabel_4.setOpaque(true);
        lblNewLabel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setBounds(432, 161, 118, 38);
        pass.add(lblNewLabel_4);
        JLabel lblbackground = new JLabel("New label");
        lblbackground.setBounds(0, 0, 1152, 642);
        add(lblbackground);
        lblbackground.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblbackground.setIcon(background);
	}
}
