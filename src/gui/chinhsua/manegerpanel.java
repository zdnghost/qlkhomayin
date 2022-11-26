    package gui.chinhsua;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import moudel.mayin;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
public class manegerpanel extends JPanel {

 
    /**
     * Create the panel.
     */
    static JTextField txtmasp;
    static JTextField txttensp;
    static JRadioButton rdbtVanphong;
    static JRadioButton rdbtCongnghiep;
    static JRadioButton rdbtlaser;
    static JRadioButton rdbttn;
    static JRadioButton rdbtuv;
    static JRadioButton rdbtphun;
    static JCheckBox ch_ribbon;
    static JCheckBox ch_nhuom;
    static JCheckBox ch_dac;
    static JCheckBox ch_bot;
    static JCheckBox ch_nuoc;
    static JCheckBox ch_dau;
    static JCheckBox ch_ivorny;
    static JCheckBox ch_ford;
    static JCheckBox ch_couche;
    static JCheckBox ch_bristol;
    static JCheckBox ch_duplex;
    static JCheckBox ch_decal;
    static JCheckBox ch_kraft;
    static JCheckBox ch_usba;
    static JCheckBox ch_usbb;
    static JCheckBox ch_lan;
    static JCheckBox ch_wireless;
    static JCheckBox ch_window;
    static JCheckBox ch_linux;
    static JCheckBox ch_ios;
    static JCheckBox ch_android;

    static DefaultTableModel model;
    static ButtonGroup rdbt_loai=new ButtonGroup();
    static ButtonGroup rdbt_pp=new ButtonGroup();
    static String key="";    
    
    static JTable table=new JTable();
    static ArrayList<JCheckBox> bmuc=new ArrayList<JCheckBox>();
    static ArrayList<JCheckBox> bhdh=new ArrayList<JCheckBox>();
    static ArrayList<JCheckBox> bcong=new  ArrayList<JCheckBox>();
    static ArrayList<JCheckBox> bgiay=new ArrayList<JCheckBox>();
    public manegerpanel() throws SQLException {
        setLayout(null);
        JPanel themhang = new JPanel();
        themhang.setBackground(new Color(204, 255, 255));
        themhang.setBounds(0, 0,1152, 641);
        this.add(themhang);
        JLabel lblmasp = new JLabel("Mã sản phẩm");
        lblmasp.setForeground(new Color(0, 255, 255));
        lblmasp.setFont(new Font("Dialog", Font.BOLD, 13));
        
        txtmasp = new JTextField();
        txtmasp.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblmasp.setLabelFor(txtmasp);
        txtmasp.setColumns(10);
        
        JLabel lblTenSanPham = new JLabel("Tên sản phẩm");
        lblTenSanPham.setForeground(new Color(0, 255, 255));
        lblTenSanPham.setFont(new Font("Dialog", Font.BOLD, 13));
        
        txttensp = new JTextField();
        txttensp.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblTenSanPham.setLabelFor(txttensp);
        txttensp.setColumns(10);
        
        JLabel lblLoai = new JLabel("Loại");
        lblLoai.setForeground(new Color(0, 255, 255));
        lblLoai.setFont(new Font("Dialog", Font.BOLD, 13));
        
        JLabel lblPhuongPhapIn = new JLabel("Phương pháp in");
        lblPhuongPhapIn.setForeground(new Color(0, 255, 255));
        lblPhuongPhapIn.setFont(new Font("Dialog", Font.BOLD, 13));
        
        JLabel lblmuc = new JLabel("Mực");
        lblmuc.setForeground(new Color(0, 255, 255));
        lblmuc.setFont(new Font("Dialog", Font.BOLD, 13));
        
        JLabel lblTenSanPham_2 = new JLabel("Cổng kết nối");
        lblTenSanPham_2.setForeground(new Color(0, 255, 255));
        lblTenSanPham_2.setFont(new Font("Dialog", Font.BOLD, 13));
        
        JLabel lblNewLabel_5 = new JLabel("Hệ điều hành");
        lblNewLabel_5.setForeground(new Color(0, 255, 255));
        lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 13));
        
        //loai may in
        JPanel chloaimayin = new JPanel();
        lblLoai.setLabelFor(chloaimayin);
        chloaimayin.setBackground(new Color(204, 255, 255));
        chloaimayin.setOpaque(false);
        chloaimayin.setLayout(new GridLayout(0, 2, 0, 0));
        
        rdbtVanphong = new JRadioButton("Văn Phòng");
        rdbtVanphong.setForeground(new Color(0, 255, 255));
        rdbtVanphong.setFont(new Font("Tahoma", Font.PLAIN, 11));
        rdbtVanphong.setOpaque(false);
        chloaimayin.add(rdbtVanphong);
        rdbtCongnghiep = new JRadioButton("Công Nghiệp");
        rdbtCongnghiep.setOpaque(false);
        rdbtCongnghiep.setForeground(Color.CYAN);
        rdbtCongnghiep.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chloaimayin.add(rdbtCongnghiep);;
 
        rdbt_loai.add(rdbtVanphong);
        rdbt_loai.add(rdbtCongnghiep);
        rdbtVanphong.setSelected(true);
        
        
        //phuong phap in
        JPanel phuongphap = new JPanel();
        lblPhuongPhapIn.setLabelFor(phuongphap);

        phuongphap.setOpaque(false);
        phuongphap.setLayout(new GridLayout(0, 4, 0, 0));
        
        rdbtlaser = new JRadioButton("in laser");
        rdbtlaser.setForeground(new Color(0, 255, 255));
        rdbtlaser.setFont(new Font("Tahoma", Font.PLAIN, 11));
        rdbtlaser.setOpaque(false);

        phuongphap.add(rdbtlaser);
        
        rdbttn = new JRadioButton("in truyền nhiệt");
        rdbttn.setForeground(new Color(0, 255, 255));
        rdbttn.setFont(new Font("Tahoma", Font.PLAIN, 11));
        rdbttn.setOpaque(false);
        phuongphap.add(rdbttn);
        
        rdbtuv = new JRadioButton("in UV");
        rdbtuv.setForeground(new Color(0, 255, 255));
        rdbtuv.setFont(new Font("Tahoma", Font.PLAIN, 11));
        rdbtuv.setOpaque(false);
        phuongphap.add(rdbtuv);
        
        rdbtphun = new JRadioButton("in phun");
        rdbtphun.setOpaque(false);
        rdbtphun.setForeground(Color.CYAN);
        rdbtphun.setFont(new Font("Tahoma", Font.PLAIN, 11));
        phuongphap.add(rdbtphun);

        rdbt_pp.add(rdbtlaser);
        rdbt_pp.add(rdbttn);
        rdbt_pp.add(rdbtuv);
        rdbt_pp.add(rdbtphun);
        rdbtlaser.setSelected(true);
        
        
        //muc
        JPanel muc = new JPanel();
        lblmuc.setLabelFor(muc);
        muc.setOpaque(false);
        muc.setLayout(new GridLayout(0, 3, 0, 0));

        ch_ribbon = new JCheckBox("Mực RIBBON");
        ch_ribbon.setForeground(new Color(0, 255, 255));
        ch_ribbon.setFont(new Font("Tahoma", Font.PLAIN, 11));
        ch_ribbon.setOpaque(false);
        muc.add(ch_ribbon);
        
        ch_nhuom = new JCheckBox("Mực nhuộm");
        ch_nhuom.setForeground(new Color(0, 255, 255));
        ch_nhuom.setFont(new Font("Tahoma", Font.PLAIN, 11));
        ch_nhuom.setOpaque(false);
        muc.add(ch_nhuom);
        
        ch_dac = new JCheckBox("Mực đặc");
        ch_dac.setForeground(new Color(0, 255, 255));
        ch_dac.setFont(new Font("Tahoma", Font.PLAIN, 11));
        ch_dac.setOpaque(false);
        muc.add(ch_dac);
        
        ch_bot = new JCheckBox("Mực bột");
        ch_bot.setForeground(new Color(0, 255, 255));
        ch_bot.setFont(new Font("Tahoma", Font.PLAIN, 11));
        ch_bot.setOpaque(false);
        muc.add(ch_bot);
        
        ch_nuoc = new JCheckBox("Mực nước");
        ch_nuoc.setForeground(new Color(0, 255, 255));
        ch_nuoc.setFont(new Font("Tahoma", Font.PLAIN, 11));
        ch_nuoc.setOpaque(false);
        muc.add(ch_nuoc);
        
        ch_dau = new JCheckBox("Mực dầu");
        ch_dau.setForeground(new Color(0, 255, 255));
        ch_dau.setFont(new Font("Tahoma", Font.PLAIN, 11));
        ch_dau.setOpaque(false);
        muc.add(ch_dau);
       
        bmuc.add(ch_ribbon);
        bmuc.add(ch_bot);
        bmuc.add(ch_nhuom);
        bmuc.add(ch_nuoc);
        bmuc.add(ch_dac);
        bmuc.add(ch_dau);
        
                
        JPanel giay = new JPanel();
        giay.setOpaque(false);
        giay.setLayout(new GridLayout(0, 4, 0, 0));
                
        ch_ivorny = new JCheckBox("Giấy IVORNY");
        ch_ivorny.setForeground(new Color(0, 255, 255));
        ch_ivorny.setOpaque(false);
        ch_ivorny.setFont(new Font("Tahoma", Font.PLAIN, 11));
        giay.add(ch_ivorny);
                
        ch_ford = new JCheckBox("Giấy FORD");
        ch_ford.setForeground(new Color(0, 255, 255));
        ch_ford.setOpaque(false);
        ch_ford.setFont(new Font("Tahoma", Font.PLAIN, 11));
        giay.add(ch_ford);
                
        ch_couche = new JCheckBox("Giấy COUCHE");
        ch_couche.setForeground(new Color(0, 255, 255));
        ch_couche.setOpaque(false);
        ch_couche.setFont(new Font("Tahoma", Font.PLAIN, 11));
        giay.add(ch_couche);
                
        ch_bristol = new JCheckBox("Giấy BRISTOL");
        ch_bristol.setForeground(new Color(0, 255, 255));
        ch_bristol.setOpaque(false);
        ch_bristol.setFont(new Font("Tahoma", Font.PLAIN, 11));
        giay.add(ch_bristol);
                
        ch_duplex = new JCheckBox("Giấy DUPLEX");
        ch_duplex.setForeground(new Color(0, 255, 255));
        ch_duplex.setOpaque(false);
        ch_duplex.setFont(new Font("Tahoma", Font.PLAIN, 11));
        giay.add(ch_duplex);
                
        ch_decal = new JCheckBox("Giấy DECAL");
        ch_decal.setForeground(new Color(0, 255, 255));
        ch_decal.setOpaque(false);
        ch_decal.setFont(new Font("Tahoma", Font.PLAIN, 11));
        giay.add(ch_decal);
                
        ch_kraft = new JCheckBox("Giấy KRAFT");
        ch_kraft.setForeground(new Color(0, 255, 255));
        ch_kraft.setOpaque(false);
        ch_kraft.setFont(new Font("Tahoma", Font.PLAIN, 11));
        giay.add(ch_kraft);
        

        bgiay.add(ch_ivorny);
        bgiay.add(ch_ford);
        bgiay.add(ch_couche);
        bgiay.add(ch_bristol);
        bgiay.add(ch_decal);
        bgiay.add(ch_duplex);
        bgiay.add(ch_kraft);
        
        JPanel cong = new JPanel();
        lblTenSanPham_2.setLabelFor(cong);
        cong.setOpaque(false);
        cong.setLayout(new GridLayout(0, 4, 0, 0));
        
        ch_usba = new JCheckBox("dây usb a");
        ch_usba.setForeground(new Color(0, 255, 255));
        ch_usba.setFont(new Font("Tahoma", Font.PLAIN, 11));
        ch_usba.setOpaque(false);
        cong.add(ch_usba);
        
        ch_usbb = new JCheckBox("dây usb b");
        ch_usbb.setForeground(new Color(0, 255, 255));
        ch_usbb.setFont(new Font("Tahoma", Font.PLAIN, 11));
        ch_usbb.setOpaque(false);
        cong.add(ch_usbb);
        
        ch_lan = new JCheckBox("dây ethernet");
        ch_lan.setRequestFocusEnabled(false);
        ch_lan.setForeground(new Color(0, 255, 255));
        ch_lan.setFont(new Font("Tahoma", Font.PLAIN, 11));
        ch_lan.setOpaque(false);
        cong.add(ch_lan);
        
        ch_wireless = new JCheckBox("kết nối không dây");
        ch_wireless.setForeground(new Color(0, 255, 255));
        ch_wireless.setFont(new Font("Tahoma", Font.PLAIN, 11));
        ch_wireless.setOpaque(false);
        cong.add(ch_wireless);
       
        bcong.add(ch_usba);
        bcong.add(ch_usbb);
        bcong.add(ch_wireless);
        bcong.add(ch_lan);

        
        JPanel hdh = new JPanel();
        lblNewLabel_5.setLabelFor(hdh);
        hdh.setOpaque(false);
        hdh.setLayout(new GridLayout(0, 4, 0, 0));
        
        ch_window = new JCheckBox("Windows");
        ch_window.setForeground(new Color(0, 255, 255));
        ch_window.setFont(new Font("Tahoma", Font.PLAIN, 11));
        ch_window.setOpaque(false);
        hdh.add(ch_window);
        
        ch_linux = new JCheckBox("Linux");
        ch_linux.setForeground(new Color(0, 255, 255));
        ch_linux.setFont(new Font("Tahoma", Font.PLAIN, 11));
        ch_linux.setOpaque(false);
        hdh.add(ch_linux);
        
        ch_ios = new JCheckBox("iOS");
        ch_ios.setForeground(new Color(0, 255, 255));
        ch_ios.setFont(new Font("Tahoma", Font.PLAIN, 11));
        ch_ios.setOpaque(false);
        hdh.add(ch_ios);
        
        ch_android = new JCheckBox("Android");
        ch_android.setForeground(new Color(0, 255, 255));
        ch_android.setFont(new Font("Tahoma", Font.PLAIN, 11));
        ch_android.setOpaque(false);
        hdh.add(ch_android);
        
        
        bhdh.add(ch_window);
        bhdh.add(ch_linux);
        bhdh.add(ch_ios);
        bhdh.add(ch_android);
         //background
        ImageIcon background=new
        ImageIcon("src\\gui\\icon\\bg.png");
        Image icon=background.getImage();
        Image newicon=icon.getScaledInstance(1280, 750, Image.SCALE_SMOOTH);
        background=new ImageIcon(newicon);
        
        JLabel lblgiay = new JLabel("Giấy ");
        lblgiay.setForeground(new Color(0, 255, 255));
        lblgiay.setFont(new Font("Dialog", Font.BOLD, 13));
        

        manegercontrol.newtable();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setOpaque(false);
        table.setOpaque(false);
        //xu ly su kien click vao dong cua bang
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {if(e.getButton()==MouseEvent.BUTTON1){
                manegercontrol.chonhang();
        }}});
        scrollPane.setViewportView(table);
        
        JPanel add = new JPanel();
        add.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
             mayin a=manegercontrol.setobject();
             manegercontrol.adddata(a);
            }
        });
        
        JLabel lblNewLabel_2 = new JLabel("Thêm");
        add.add(lblNewLabel_2);
        
        JPanel delete = new JPanel();
        delete.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {if(e.getButton()==MouseEvent.BUTTON1){
                mayin a=manegercontrol.setobject();
                manegercontrol.deletedata(a);
            }}});
        
        JLabel lblNewLabel_1 = new JLabel("Xóa");
        delete.add(lblNewLabel_1);
        
        JPanel update = new JPanel();
        update.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {if(e.getButton()==MouseEvent.BUTTON1){
                mayin a=manegercontrol.setobject();
                if(key=="")
                    key=a.masp;
                manegercontrol.updatedata(a);
            }}});
        
        JLabel lblNewLabel = new JLabel("Sửa");
        update.add(lblNewLabel);
        
        JPanel refrest = new JPanel();
        refrest.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {if(e.getButton()==MouseEvent.BUTTON1){
            	manegercontrol.refresh();
            }}});
        
        JLabel lblrefresh = new JLabel("Đặt lại");
        refrest.add(lblrefresh);
        JLabel lblbackground = new JLabel("New label");
        lblbackground.setForeground(new Color(0, 255, 255));
        lblbackground.setFont(new Font("Dialog", Font.BOLD, 13));
        lblbackground.setIcon(background);
        GroupLayout gl_themhang = new GroupLayout(themhang);
        gl_themhang.setHorizontalGroup(
        	gl_themhang.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(10)
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1132, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(999)
        			.addComponent(add, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(433)
        			.addComponent(lblPhuongPhapIn, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(457)
        			.addComponent(giay, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(10)
        			.addComponent(lblmasp, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(651)
        			.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(749)
        			.addComponent(hdh, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(897)
        			.addComponent(delete, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(62)
        			.addComponent(muc, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(555)
        			.addComponent(chloaimayin, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(701)
        			.addComponent(refrest, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(506)
        			.addComponent(lblLoai, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(121)
        			.addComponent(txttensp, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(135)
        			.addComponent(txtmasp, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(558)
        			.addComponent(phuongphap, GroupLayout.PREFERRED_SIZE, 553, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(10)
        			.addComponent(lblmuc, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(10)
        			.addComponent(lblTenSanPham, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(10)
        			.addComponent(lblTenSanPham_2, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(405)
        			.addComponent(lblgiay, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(135)
        			.addComponent(cong, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(799)
        			.addComponent(update, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
        		.addComponent(lblbackground, GroupLayout.PREFERRED_SIZE, 1152, GroupLayout.PREFERRED_SIZE)
        );
        gl_themhang.setVerticalGroup(
        	gl_themhang.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(327)
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(214)
        			.addComponent(add, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(55)
        			.addComponent(lblPhuongPhapIn, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(99)
        			.addComponent(giay, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(13)
        			.addComponent(lblmasp, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(154)
        			.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(154)
        			.addComponent(hdh, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(214)
        			.addComponent(delete, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(97)
        			.addComponent(muc, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(13)
        			.addComponent(chloaimayin, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(214)
        			.addComponent(refrest, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(14)
        			.addComponent(lblLoai, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(56)
        			.addComponent(txttensp, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(15)
        			.addComponent(txtmasp, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(55)
        			.addComponent(phuongphap, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(99)
        			.addComponent(lblmuc, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(55)
        			.addComponent(lblTenSanPham, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(154)
        			.addComponent(lblTenSanPham_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(100)
        			.addComponent(lblgiay, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(154)
        			.addComponent(cong, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_themhang.createSequentialGroup()
        			.addGap(214)
        			.addComponent(update, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        		.addComponent(lblbackground, GroupLayout.PREFERRED_SIZE, 642, GroupLayout.PREFERRED_SIZE)
        );
        themhang.setLayout(gl_themhang);
        
    }
}
