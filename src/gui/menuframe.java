package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.sever;
import gui.chinhsua.manegerpanel;
import gui.quanlyphieu.quanlyphieupanel;
import gui.quanlytk.dsuserpanel;
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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class menuframe extends JFrame {

    private JPanel contentPane;
    public static JPanel childPannel;
    public static JTabbedPane tab;
    /**
     * Launch the application.
     */
    public static user user=new user("",""); 
    public static int indextab=0;
    manegerpanel man;
    quanlyphieupanel phieu;
    tonkhopanel tonkho;
    dsuserpanel dsuser;
    public static JPanel bmenu1 ;
    public static JPanel bmenu2 ;
    public static JPanel bmenu3 ;
    public static JPanel bmenu4 ;
    public static JPanel bmenu5 ;
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
    

    public menuframe(user a) {
    	tab= new JTabbedPane(JTabbedPane.TOP);
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
        man=new manegerpanel();
        phieu=new quanlyphieupanel();
        tonkho=new tonkhopanel();
        dsuser=new dsuserpanel();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1171,720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        //info panel        
        JPanel menutab = new JPanel();
        menutab.setBackground(Color.LIGHT_GRAY);
        menutab.setBounds(0, 0, 1155, 39);
        contentPane.add(menutab);
        menutab.setLayout(null);
        //log out
        JLabel logout = new JLabel("Log out");
        logout.setBorder(new LineBorder(new Color(0, 0, 0)));
        logout.setFont(new Font("Tahoma", Font.PLAIN, 11));
        logout.setHorizontalAlignment(SwingConstants.CENTER);
        logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {if(e.getButton()==MouseEvent.BUTTON1){
            	dispose();
            	login log=new login();
                log.setVisible(true);
                try {
                    sever.disconect();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                
            }
        }});
        logout.setBounds(1091, 11, 59, 17);
        menutab.add(logout);
        
        JPanel bmenu = new JPanel();
        
        menutab.add(bmenu);
        bmenu.setBackground(Color.LIGHT_GRAY);
        bmenu.setLayout(new GridLayout(1, 1, 0, 0));
        
        bmenu1 = new JPanel();
        bmenu.add(bmenu1);
        bmenu1.setLayout(new GridLayout(0, 1, 0, 0));
        
        JLabel lblmenu1 = new JLabel("Home");
        lblmenu1.setHorizontalAlignment(SwingConstants.CENTER);
        bmenu1.add(lblmenu1);
        
        bmenu4 = new JPanel();
       
        bmenu.add(bmenu4);
        bmenu4.setLayout(new GridLayout(0, 1, 0, 0));
        
        JLabel lblQunLTn = new JLabel("Kho hàng");
        lblQunLTn.setHorizontalAlignment(SwingConstants.CENTER);
        bmenu4.add(lblQunLTn);
        
        bmenu3 = new JPanel();
        bmenu.add(bmenu3);
        bmenu3.setLayout(new GridLayout(0, 1, 0, 0));
        
        JLabel lblmenu3 = new JLabel("Phiếu xuất nhập");
        lblmenu3.setHorizontalAlignment(SwingConstants.CENTER);
        bmenu3.add(lblmenu3);
        homepanel main=new homepanel();
        main.setLocation(0, 0);
        tab.setBounds(0, 15, 1157, 670);
        getContentPane().add(tab);
        //menu panel       
        
        tab.setEnabled(false);
        
        JPanel menu = new JPanel(); 
        show(menu,main);
        
        tab.addTab("New tab", null, menu, null);
        
        
        JPanel menu2 = new JPanel();
        show(menu2,man);
        tab.addTab("New tab", null, menu2, null);
        
        JPanel menu3 = new JPanel();
        tab.addTab("New tab", null, menu3, null);
        show(menu3,phieu);
        
        JPanel menu4 = new JPanel();
        show(menu4,tonkho);
        tab.addTab("New tab", null, menu4, null);
        JPanel menu5 = new JPanel();
        show(menu5,dsuser);
        tab.addTab("New tab", null, menu5, null);
        
        
        bmenu2 = new JPanel();
        bmenu2.setBounds(0, 173, 108, 43);
        bmenu5 = new JPanel();
        bmenu2.setLayout(new GridLayout(0, 1, 0, 0));
        
        JLabel lblmenu2 = new JLabel("Quản lý mặt hàng ");
        lblmenu2.setHorizontalAlignment(SwingConstants.CENTER);
        bmenu2.add(lblmenu2);
        //set event nut
        bmenu1.setBackground(Color.cyan);
        bmenu4.setBackground(Color.GRAY);
        bmenu3.setBackground(Color.GRAY);
        
        JPanel panel = new JPanel();
        
        panel.setOpaque(false);
        panel.setBounds(830, 0, 200, 39);
        menutab.add(panel);
      	panel.setLayout(new GridLayout(0, 1, 0, 0));
      	//user info
      	JLabel lbluser = new JLabel("Username : "+user.username);
      	panel.add(lbluser);
        
        //chuc vu
      	JLabel lblNewLabel = new JLabel(user.chucvu);
      	panel.add(lblNewLabel);
        bmenu2.setBackground(Color.GRAY);
        
        bmenu5.setBackground(Color.GRAY);
        bmenu5.setLayout(new GridLayout(0, 1, 0, 0));
        
        JLabel lblmenu3_1 = new JLabel("Danh sách người dùng");
        lblmenu3_1.setHorizontalAlignment(SwingConstants.CENTER);
        bmenu5.add(lblmenu3_1);
        if(user.chucvu.contains("ADMIN"))
        {	bmenu.add(bmenu2);
        	bmenu.add(bmenu5);
           }
        if(user.chucvu.contains("ADMIN"))
        	bmenu.setBounds(0, 0, 150*5, 39);
    	else
    		bmenu.setBounds(0, 0, 150*3, 39);
        tab.setSelectedIndex(0);
        
        
        
        
        bmenu1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {if(e.getButton()==MouseEvent.BUTTON1){
                tab.setSelectedIndex(0);
                indextab=0;
                bmenu1.setBackground(Color.cyan);
                bmenu2.setBackground(Color.GRAY);
                bmenu3.setBackground(Color.GRAY);
                bmenu4.setBackground(Color.GRAY);
                bmenu5.setBackground(Color.GRAY);
            }
        }});
        bmenu3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {if(e.getButton()==MouseEvent.BUTTON1){
                tab.setSelectedIndex(2);
                indextab=2;
                bmenu3.setBackground(Color.cyan);
                bmenu2.setBackground(Color.GRAY);
                bmenu1.setBackground(Color.GRAY);
                bmenu4.setBackground(Color.GRAY);
                bmenu5.setBackground(Color.GRAY);
            }
        }});
        bmenu2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {if(e.getButton()==MouseEvent.BUTTON1){
                tab.setSelectedIndex(1);
                indextab=1;
                bmenu2.setBackground(Color.cyan);
                bmenu1.setBackground(Color.GRAY);
                bmenu3.setBackground(Color.GRAY);
                bmenu4.setBackground(Color.GRAY);
                bmenu5.setBackground(Color.GRAY);
            }
        }});
        bmenu4.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
        		tab.setSelectedIndex(3);
        		indextab=3;
        		tonkho.resettable();
                bmenu4.setBackground(Color.cyan);
                bmenu2.setBackground(Color.GRAY);
                bmenu1.setBackground(Color.GRAY);
                bmenu3.setBackground(Color.GRAY);
                bmenu5.setBackground(Color.GRAY);
        	}
        });
        bmenu5.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
        		tab.setSelectedIndex(4);
        		indextab=4;
        		dsuserpanel.resettable();
                bmenu5.setBackground(Color.cyan);
                bmenu2.setBackground(Color.GRAY);
                bmenu1.setBackground(Color.GRAY);
                bmenu3.setBackground(Color.GRAY);
                bmenu4.setBackground(Color.GRAY);
        	}
        });
        panel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
        		tab.setSelectedIndex(4);
        		dsuserpanel.a.username=menuframe.user.username;
        		dsuserpanel.a.load();
        		dsuserpanel.tab.setSelectedIndex(1);
        		bmenu5.setBackground(Color.GRAY);
        		bmenu2.setBackground(Color.GRAY);
                bmenu1.setBackground(Color.GRAY);
                bmenu3.setBackground(Color.GRAY);
                bmenu4.setBackground(Color.GRAY);
        	}
        });
    }
}
