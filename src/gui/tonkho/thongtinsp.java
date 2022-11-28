package gui.tonkho;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;

import database.sever;
import moudel.mayin;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
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

public class thongtinsp extends JPanel {
	String masp="";
	private JTextField ma;
	private JTextField sl;
	private JTextField loai;
	private JTextField pp;
	private JTextField muc;
	private JTextField giay;
	private JTextField cong;
	private JTextField hdh;
	private JTextField ten;
	/**
	 * Create the panel.
	 */
	void load()
	{
		String Sql="select * from SANPHAM,MAYIN,PHUONGPHAPIN where SANPHAM.MASP=MAYIN.MASP AND PHUONGPHAPIN=PP AND SANPHAM.MASP='"+masp+"'";
        ResultSet data;
      try {
          data = sever.getquery(Sql);
          mayin a=new mayin();
        while(data.next())
        a.datatoobject(data);
        ma.setText(a.masp);
        ten.setText(a.tensp);
        sl.setText(a.sl+"");
        loai.setText(a.loaimayin);
        pp.setText(a.ppin.toLowerCase());
        muc.setText("Mực "+a.muc.replaceAll(" ",","));
        giay.setText("Giấy "+a.giay.replaceAll(" ",","));
        cong.setText(a.cong.replaceAll(" ",","));
        hdh.setText(a.tuongthich.replaceAll(" ",","));
      } 
      catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }
        
    }  	
	
	public thongtinsp() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông tin sản phẩm ");
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 11, 1132, 103);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã sản phẩm:");
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 150, 144, 38);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số lượng còn lại:");
		lblNewLabel_1_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 248, 154, 38);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Phương pháp in:");
		lblNewLabel_1_1_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(10, 297, 154, 38);
		add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Loại máy in:");
		lblNewLabel_1_2.setForeground(new Color(0, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(10, 346, 144, 38);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Loại mực in:");
		lblNewLabel_1_3.setForeground(new Color(0, 255, 255));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(458, 150, 236, 38);
		add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Loại giấy in:");
		lblNewLabel_1_1_2.setForeground(new Color(0, 255, 255));
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_2.setBounds(458, 199, 236, 38);
		add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Cổng kết nối:");
		lblNewLabel_1_2_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(458, 248, 236, 38);
		add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Hệ điều hành tương thích:");
		lblNewLabel_1_1_1_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(458, 297, 236, 38);
		add(lblNewLabel_1_1_1_1);
		
		ma = new JTextField();
		ma.setBorder(null);
		ma.setForeground(new Color(0, 255, 255));
		ma.setOpaque(false);
		ma.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ma.setEditable(false);
		ma.setBounds(174, 151, 274, 38);
		add(ma);
		ma.setColumns(10);
		
		sl = new JTextField();
		sl.setBorder(null);
		sl.setForeground(new Color(0, 255, 255));
		sl.setOpaque(false);
		sl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sl.setEditable(false);
		sl.setColumns(10);
		sl.setBounds(174, 249, 144, 38);
		add(sl);
		
		loai = new JTextField();
		loai.setBorder(null);
		loai.setForeground(new Color(0, 255, 255));
		loai.setOpaque(false);
		loai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		loai.setEditable(false);
		loai.setColumns(10);
		loai.setBounds(174, 347, 167, 38);
		add(loai);
		
		pp = new JTextField();
		pp.setBorder(null);
		pp.setForeground(new Color(0, 255, 255));
		pp.setOpaque(false);
		pp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pp.setEditable(false);
		pp.setColumns(10);
		pp.setBounds(174, 298, 274, 38);
		add(pp);
		
		muc = new JTextField();
		muc.setBorder(null);
		muc.setForeground(new Color(0, 255, 255));
		muc.setOpaque(false);
		muc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		muc.setEditable(false);
		muc.setColumns(10);
		muc.setBounds(704, 151, 438, 38);
		add(muc);
		
		giay = new JTextField();
		giay.setBorder(null);
		giay.setForeground(new Color(0, 255, 255));
		giay.setOpaque(false);
		giay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		giay.setEditable(false);
		giay.setColumns(10);
		giay.setBounds(704, 200, 438, 38);
		add(giay);
		
		cong = new JTextField();
		cong.setBorder(null);
		cong.setForeground(new Color(0, 255, 255));
		cong.setOpaque(false);
		cong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cong.setEditable(false);
		cong.setColumns(10);
		cong.setBounds(704, 249, 438, 38);
		add(cong);
		
		hdh = new JTextField();
		hdh.setBorder(null);
		hdh.setForeground(new Color(0, 255, 255));
		hdh.setOpaque(false);
		hdh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		hdh.setEditable(false);
		hdh.setColumns(10);
		hdh.setBounds(704, 298, 438, 38);
		add(hdh);
		
		ten = new JTextField();
		ten.setBorder(null);
		ten.setForeground(new Color(0, 255, 255));
		ten.setOpaque(false);
		ten.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ten.setEditable(false);
		ten.setColumns(10);
		ten.setBounds(174, 200, 274, 38);
		add(ten);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Tên sản phẩm:");
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
					tonkhopanel.tab.setSelectedIndex(0);
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
        JLabel lblbackground = new JLabel("New label");
        lblbackground.setBounds(0, 0, 1152, 642);
        add(lblbackground);
        lblbackground.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblbackground.setIcon(background);
	}
}
