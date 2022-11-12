package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.sever;
import gui.chinhsua.manegerpanel;
import gui.quanlyphieu.quanlyphieupanel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.border.LineBorder;

public class menuframe extends JFrame {

    private JPanel contentPane;
    public static JPanel childPannel;
    /**
     * Launch the application.
     */
    public static String user; 
    public static void show(JPanel a,JPanel b)
    {
        a.setLocation(0, 0);
        b.setLayout(null);
        b.setSize(1152,642);
        b.setVisible(true);
        a.removeAll();
        a.setLayout(null);
        a.add(b);
        a.validate();
    }
    private homepanel main=new homepanel();
    private manegerpanel man=new manegerpanel();
    private quanlyphieupanel phieu=new quanlyphieupanel();
    public menuframe(String user,boolean admin) throws SQLException {
        setResizable(false);
        setTitle("QLKMI");
        setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
               try {
                sever.disconect();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            }
        });
       
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1280,720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
//info panel        
        JPanel info = new JPanel();
        info.setBackground(Color.LIGHT_GRAY);
        info.setBounds(0, 0, 1264, 39);
        contentPane.add(info);
        info.setLayout(null);
        //user info
        JLabel lbluser = new JLabel("Username : "+user);
        lbluser.setBounds(1025, 0, 135, 14);
        info.add(lbluser);
        //log out
        JLabel logout = new JLabel("Log out");
        logout.setBorder(new LineBorder(new Color(0, 0, 0)));
        logout.setFont(new Font("Tahoma", Font.PLAIN, 11));
        logout.setHorizontalAlignment(SwingConstants.CENTER);
        logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {if(e.getButton()==MouseEvent.BUTTON1){
                login log=new login();
                log.setVisible(true);
                try {
                    sever.disconect();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                dispose();
            }
        }});
        logout.setBounds(1169, 11, 59, 17);
        info.add(logout);
        
        //admin
        if(admin==true)
        {
            JLabel lblNewLabel = new JLabel("ADMIN");
            lblNewLabel.setBounds(1027, 25, 46, 14);
            info.add(lblNewLabel);
        }
//menu panel       
        JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
        tab.setBounds(107, 11, 1157, 670);
        contentPane.add(tab);
        
        JPanel menu = new JPanel(); 
        show(menu,main);
        
        tab.addTab("New tab", null, menu, null);
        
        
        JPanel menu2 = new JPanel();
        show(menu2,man);
        tab.addTab("New tab", null, menu2, null);
        
        JLabel lblMenu = new JLabel("quản lý mặt hàng");
        lblMenu.setBounds(542, 5, 32, 14);
        menu2.add(lblMenu);
        
        JPanel menu3 = new JPanel();
        tab.addTab("New tab", null, menu3, null);
        JLabel lblNewLabel_1 = new JLabel("Quản lý phiếu nhập xuất");
        menu3.add(lblNewLabel_1);
        
        JPanel bmenu = new JPanel();
        show(menu3,phieu);
        bmenu.setBackground(Color.LIGHT_GRAY);
        bmenu.setBounds(0, 40, 108, 641);
        contentPane.add(bmenu);
        bmenu.setLayout(null);
        
        JPanel bmenu1 = new JPanel();
        
        bmenu1.setBackground(Color.cyan);
        bmenu1.setBounds(0, 11, 143, 43);
        bmenu.add(bmenu1);
        bmenu1.setLayout(null);
        
        JLabel lblmenu1 = new JLabel("Home");
        lblmenu1.setBounds(0, 0, 143, 43);
        bmenu1.add(lblmenu1);
        
        JPanel bmenu2 = new JPanel();
        bmenu2.setLayout(null);
        bmenu2.setBounds(0, 65, 143, 43);
        bmenu.add(bmenu2);
        
        JLabel lblmenu2 = new JLabel("Quản lý sản phẩm ");
        lblmenu2.setBounds(0, 0, 143, 43);
        bmenu2.add(lblmenu2);
        
        JPanel bmenu3 = new JPanel();
        
        bmenu1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {if(e.getButton()==MouseEvent.BUTTON1){
                tab.setSelectedIndex(0);
                bmenu1.setBackground(Color.cyan);
                bmenu2.setBackground(Color.white);
                bmenu3.setBackground(Color.white);
            }
        }});
        bmenu2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {if(e.getButton()==MouseEvent.BUTTON1){
                tab.setSelectedIndex(1);
                bmenu2.setBackground(Color.cyan);
                bmenu1.setBackground(Color.white);
                bmenu3.setBackground(Color.white);
            }
        }});
        bmenu3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {if(e.getButton()==MouseEvent.BUTTON1){
                tab.setSelectedIndex(2);
                bmenu3.setBackground(Color.cyan);
                bmenu2.setBackground(Color.white);
                bmenu1.setBackground(Color.white);
            }
        }});
        bmenu3.setLayout(null);
        bmenu3.setBounds(0, 119, 143, 43);
        bmenu.add(bmenu3);
        
        JLabel lblmenu3 = new JLabel("Quản lý phiếu");
        lblmenu3.setBounds(0, 0, 143, 43);
        bmenu3.add(lblmenu3);
    }
}
