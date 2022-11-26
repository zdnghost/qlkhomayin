package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.sever;
import gui.chinhsua.manegerpanel;
import gui.quanlyphieu.quanlyphieupanel;
import gui.tonkho.tonkhopanel;
import moudel.user;
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
import java.awt.GridLayout;

public class menuframe extends JFrame {

    private JPanel contentPane;
    public static JPanel childPannel;
    public static JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
    /**
     * Launch the application.
     */
    public static user user=new user("",""); 
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
    

    public menuframe(user a) throws SQLException {
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
        user=a;
        homepanel main=new homepanel();
        manegerpanel man=new manegerpanel();
        quanlyphieupanel phieu=new quanlyphieupanel();
        tonkhopanel tonkho=new tonkhopanel();
        
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
        JLabel lbluser = new JLabel("Username : "+a.username);
        lbluser.setBounds(979, 0, 180, 14);
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
        
        //chuc vu
      	JLabel lblNewLabel = new JLabel(a.chucvu);
        lblNewLabel.setBounds(979, 25, 180, 14);
        info.add(lblNewLabel);
        //menu panel       
        
        tab.setEnabled(false);
        tab.setBounds(107, 11, 1157, 670);
        contentPane.add(tab);
        
        JPanel menu = new JPanel(); 
        show(menu,main);
        
        tab.addTab("New tab", null, menu, null);
        
        
        JPanel menu2 = new JPanel();
        show(menu2,man);
        tab.addTab("New tab", null, menu2, null);
        
        JLabel lblMenu = new JLabel("Quản lý mặt hàng");
        lblMenu.setBounds(542, 5, 32, 14);
        menu2.add(lblMenu);
        
        JPanel menu3 = new JPanel();
        tab.addTab("New tab", null, menu3, null);
        JLabel lblNewLabel_1 = new JLabel("Quản lý phiếu nhập xuất");
        menu3.add(lblNewLabel_1);
        
        JPanel bmenu = new JPanel();
        show(menu3,phieu);
        
        JPanel menu4 = new JPanel();
        show(menu4,tonkho);
        tab.addTab("New tab", null, menu4, null);
        bmenu.setBackground(Color.LIGHT_GRAY);
        bmenu.setBounds(0, 40, 108, 641);
        contentPane.add(bmenu);
        bmenu.setLayout(null);
        
        JPanel bmenu1 = new JPanel();
        
        bmenu1.setBackground(Color.cyan);
        bmenu1.setBounds(0, 11, 108, 43);
        bmenu.add(bmenu1);
        bmenu1.setLayout(new GridLayout(0, 1, 0, 0));
        
        JLabel lblmenu1 = new JLabel("Home");
        lblmenu1.setHorizontalAlignment(SwingConstants.CENTER);
        bmenu1.add(lblmenu1);
        
        JPanel bmenu2 = new JPanel();
        bmenu2.setBounds(0, 173, 108, 43);
        if(user.chucvu.trim().contains("ADMIN"))
        bmenu.add(bmenu2);
        bmenu2.setLayout(new GridLayout(0, 1, 0, 0));
        
        JLabel lblmenu2 = new JLabel("Quản lý mặt hàng ");
        lblmenu2.setHorizontalAlignment(SwingConstants.CENTER);
        bmenu2.add(lblmenu2);
        
        JPanel bmenu3 = new JPanel();
        
       
        bmenu3.setBounds(0, 119, 108, 43);
        bmenu.add(bmenu3);
        bmenu3.setLayout(new GridLayout(0, 1, 0, 0));
        
        JLabel lblmenu3 = new JLabel("Phiếu xuất nhập");
        lblmenu3.setHorizontalAlignment(SwingConstants.CENTER);
        bmenu3.add(lblmenu3);
        
        JPanel bmenu4 = new JPanel();
        bmenu1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {if(e.getButton()==MouseEvent.BUTTON1){
                tab.setSelectedIndex(0);
                bmenu1.setBackground(Color.cyan);
                bmenu2.setBackground(Color.white);
                bmenu3.setBackground(Color.white);
                bmenu4.setBackground(Color.white);
            }
        }});
        bmenu2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {if(e.getButton()==MouseEvent.BUTTON1){
                tab.setSelectedIndex(1);
                bmenu2.setBackground(Color.cyan);
                bmenu1.setBackground(Color.white);
                bmenu3.setBackground(Color.white);
                bmenu4.setBackground(Color.white);
            }
        }});
        bmenu3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {if(e.getButton()==MouseEvent.BUTTON1){
                tab.setSelectedIndex(2);
                bmenu3.setBackground(Color.cyan);
                bmenu2.setBackground(Color.white);
                bmenu1.setBackground(Color.white);
                bmenu4.setBackground(Color.white);
            }
        }});
        bmenu4.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
        		tab.setSelectedIndex(3);
        		tonkho.resettable();
                bmenu4.setBackground(Color.cyan);
                bmenu2.setBackground(Color.white);
                bmenu1.setBackground(Color.white);
                bmenu3.setBackground(Color.white);
        	}
        });
        bmenu4.setBounds(0, 65, 108, 43);
        bmenu.add(bmenu4);
        bmenu4.setLayout(new GridLayout(0, 1, 0, 0));
        
        JLabel lblQunLTn = new JLabel("Kho hàng");
        lblQunLTn.setHorizontalAlignment(SwingConstants.CENTER);
        bmenu4.add(lblQunLTn);
    }
}
