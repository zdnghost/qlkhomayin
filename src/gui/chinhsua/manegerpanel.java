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
public class manegerpanel extends JPanel {

 
    /**
     * Create the panel.
     */
    public static JTextField txtmasp;
    public static JTextField txttensp;
    public static JRadioButton rdbtVanphong;
    public static JRadioButton rdbtCongnghiep;
    public static JRadioButton rdbtlaser;
    public static JRadioButton rdbttn;
    public static JRadioButton rdbtuv;
    public static JRadioButton rdbtphun;
    public static JCheckBox ch_ribbon;
    public static JCheckBox ch_nhuom;
    public static JCheckBox ch_dac;
    public static JCheckBox ch_bot;
    public static JCheckBox ch_nuoc;
    public static JCheckBox ch_dau;
    public static JCheckBox ch_ivorny;
    public static JCheckBox ch_ford;
    public static JCheckBox ch_couche;
    public static JCheckBox ch_bristol;
    public static JCheckBox ch_duplex;
    public static JCheckBox ch_decal;
    public static JCheckBox ch_kraft;
    public static JCheckBox ch_usba;
    public static JCheckBox ch_usbb;
    public static JCheckBox ch_lan;
    public static JCheckBox ch_wireless;
    public static JCheckBox ch_window;
    public static JCheckBox ch_linux;
    public static JCheckBox ch_ios;
    public static JCheckBox ch_android;

    public static DefaultTableModel model;
    public static ButtonGroup rdbt_loai=new ButtonGroup();
    public static ButtonGroup rdbt_pp=new ButtonGroup();
    public static String key="";    
    
    public static JTable table=new JTable();
    public static ArrayList<JCheckBox> bmuc=new ArrayList<JCheckBox>();
    public static ArrayList<JCheckBox> bhdh=new ArrayList<JCheckBox>();
    public static ArrayList<JCheckBox> bcong=new  ArrayList<JCheckBox>();
    public static ArrayList<JCheckBox> bgiay=new ArrayList<JCheckBox>();
    public manegerpanel() throws SQLException {
        setLayout(null);
        JPanel themhang = new JPanel();
        themhang.setBackground(new Color(204, 255, 255));
        themhang.setBounds(0, 0,1152, 641);
        themhang.setLayout(null);
        this.add(themhang);
        JLabel lblmasp = new JLabel("Mã sản phẩm");
        lblmasp.setForeground(new Color(0, 255, 255));
        lblmasp.setBounds(10, 13, 115, 35);
        lblmasp.setFont(new Font("Dialog", Font.BOLD, 13));
        themhang.add(lblmasp);
        
        txtmasp = new JTextField();
        txtmasp.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblmasp.setLabelFor(txtmasp);
        txtmasp.setBounds(135, 15, 260, 33);
        txtmasp.setColumns(10);
        themhang.add(txtmasp);
        
        JLabel lblTenSanPham = new JLabel("Tên sản phẩm");
        lblTenSanPham.setForeground(new Color(0, 255, 255));
        lblTenSanPham.setBounds(10, 55, 101, 33);
        lblTenSanPham.setFont(new Font("Dialog", Font.BOLD, 13));
        themhang.add(lblTenSanPham);
        
        txttensp = new JTextField();
        txttensp.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblTenSanPham.setLabelFor(txttensp);
        txttensp.setBounds(121, 56, 302, 33);
        txttensp.setColumns(10);
        themhang.add(txttensp);
        
        JLabel lblLoai = new JLabel("Loại");
        lblLoai.setForeground(new Color(0, 255, 255));
        lblLoai.setBounds(506, 14, 42, 33);
        lblLoai.setFont(new Font("Dialog", Font.BOLD, 13));
        themhang.add(lblLoai);
        
        JLabel lblPhuongPhapIn = new JLabel("Phương pháp in");
        lblPhuongPhapIn.setForeground(new Color(0, 255, 255));
        lblPhuongPhapIn.setBounds(433, 55, 115, 33);
        lblPhuongPhapIn.setFont(new Font("Dialog", Font.BOLD, 13));
        themhang.add(lblPhuongPhapIn);
        
        JLabel lblmuc = new JLabel("Mực");
        lblmuc.setForeground(new Color(0, 255, 255));
        lblmuc.setBounds(10, 99, 42, 24);
        lblmuc.setFont(new Font("Dialog", Font.BOLD, 13));
        themhang.add(lblmuc);
        
        JLabel lblTenSanPham_2 = new JLabel("Cổng kết nối");
        lblTenSanPham_2.setForeground(new Color(0, 255, 255));
        lblTenSanPham_2.setBounds(10, 154, 101, 33);
        lblTenSanPham_2.setFont(new Font("Dialog", Font.BOLD, 13));
        themhang.add(lblTenSanPham_2);
        
        JLabel lblNewLabel_5 = new JLabel("Hệ điều hành");
        lblNewLabel_5.setForeground(new Color(0, 255, 255));
        lblNewLabel_5.setBounds(651, 154, 88, 33);
        lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 13));
        themhang.add(lblNewLabel_5);
        
        //loai may in
        JPanel chloaimayin = new JPanel();
        lblLoai.setLabelFor(chloaimayin);
        chloaimayin.setBounds(555, 13, 299, 39);
        chloaimayin.setBackground(new Color(204, 255, 255));
        themhang.add(chloaimayin);
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
        phuongphap.setBounds(558, 55, 553, 33);
        themhang.add(phuongphap);

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
        muc.setBounds(62, 97, 275, 44);
        muc.setOpaque(false);
        themhang.add(muc);
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
        giay.setBounds(457, 99, 376, 44);
        themhang.add(giay);
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
        cong.setBounds(135, 154, 449, 33);
        cong.setOpaque(false);
        themhang.add(cong);
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
        hdh.setBounds(749, 154, 338, 33);
        hdh.setOpaque(false);
        themhang.add(hdh);
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
        lblgiay.setBounds(405, 100, 42, 24);
        themhang.add(lblgiay);
        

        gui.chinhsua.manegercontrol.newtable();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 327, 1132, 303);
        themhang.add(scrollPane);
        //xu ly su kien click vao dong cua bang
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gui.chinhsua.manegercontrol.chonhang();
        }});
        scrollPane.setViewportView(table);
        
        JPanel add = new JPanel();
        add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
             mayin a=gui.chinhsua.manegercontrol.setobject();
             gui.chinhsua.manegercontrol.adddata(a);
            }
        });
        add.setBounds(999, 214, 88, 23);
        themhang.add(add);
        
        JLabel lblNewLabel_2 = new JLabel("Thêm");
        add.add(lblNewLabel_2);
        
        JPanel delete = new JPanel();
        delete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mayin a=gui.chinhsua.manegercontrol.setobject();
                gui.chinhsua.manegercontrol.deletedata(a);
            }
        });
        delete.setBounds(897, 214, 88, 23);
        themhang.add(delete);
        
        JLabel lblNewLabel_1 = new JLabel("Xóa");
        delete.add(lblNewLabel_1);
        
        JPanel update = new JPanel();
        update.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mayin a=gui.chinhsua.manegercontrol.setobject();
                if(key=="")
                    key=a.masp;
                gui.chinhsua.manegercontrol.updatedata(a);
            }
        });
        update.setBounds(799, 214, 88, 23);
        themhang.add(update);
        
        JLabel lblNewLabel = new JLabel("Sửa");
        update.add(lblNewLabel);
        
        JPanel refrest = new JPanel();
        refrest.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        refrest.setBounds(701, 214, 88, 23);
        themhang.add(refrest);
        
        JLabel lblrefresh = new JLabel("Đặt lại");
        refrest.add(lblrefresh);
        JLabel lblbackground = new JLabel("New label");
        lblbackground.setForeground(new Color(0, 255, 255));
        lblbackground.setBounds(0, 0, 1152, 642);
        themhang.add(lblbackground);
        lblbackground.setFont(new Font("Dialog", Font.BOLD, 13));
        lblbackground.setIcon(background);
        
    }
}
