package gui.quanlytk;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import database.sever;
import gui.menuframe;
import moudel.mayin;
import moudel.user;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class dsuserpanel extends JPanel {
	private JTextField ten;
	private JTextField cmnd;
	private static JTable table=new JTable();
	private static DefaultTableModel model;
	public static JTabbedPane tab;
	public static thongtinuser a=new thongtinuser();
	public static taotk b=new taotk();
	private static void newmodel()
    {
        
        model=new DefaultTableModel(
                new Object[][] {},
                new String[] {"Username", "Chức vụ", "Họ tên người dùng","CMND"}) {
        	Class[] columnTypes = new Class[] {
            		String.class, String.class,String.class,String.class
            	};
            	public Class getColumnClass(int columnIndex) {
            		return columnTypes[columnIndex];
            	}
            	boolean[] columnEditables = new boolean[] {
            		false, false, false,false
            	};
            	public boolean isCellEditable(int row, int column) {
            		return columnEditables[column];
            	}

        };
        String Sql="select * from USERDB,CHUCVU where USERDB.CHUCVU=CHUCVU.CHUCVU";
        ResultSet data;
      try {
          data = sever.getquery(Sql);
          user a=new user();
        while(data.next())
        {
        a.datatoobject(data);
        model.addRow(new Object[]
        {a.username,a.chucvu,a.hoten,a.cmnd});
        }
      } 
      catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }
        
    }  
	public static void resettable() 
    {
    newmodel();
    dsuserpanel.table.setModel(model);
    dsuserpanel.table.getColumnModel().getColumn(0).setPreferredWidth(100);
    dsuserpanel.table.getColumnModel().getColumn(1).setPreferredWidth(300);
    dsuserpanel.table.getColumnModel().getColumn(3).setPreferredWidth(100);
    dsuserpanel.table.getColumnModel().getColumn(0).setResizable(false);
    dsuserpanel.table.getColumnModel().getColumn(1).setResizable(false);
    dsuserpanel.table.getColumnModel().getColumn(2).setResizable(false);
    dsuserpanel.table.getColumnModel().getColumn(3).setResizable(false);
    }
	private static void filter(String ma,String ten){
	    TableRowSorter<DefaultTableModel> fl=new  TableRowSorter<DefaultTableModel>(model);
	    table.setRowSorter(fl);

	    List<RowFilter<Object, Object>> filters = new  ArrayList<RowFilter<Object, Object>>(2);
	  //filtering based on Strings text and avail
	   filters.add(RowFilter.regexFilter(ma,2));
	   filters.add(RowFilter.regexFilter(ten,3));
	   RowFilter<Object, Object> rf = RowFilter.andFilter(filters);
	   fl.setRowFilter(rf);
	}
	/**
	 * Create the panel.
	 */
	public dsuserpanel() {
		setLayout(null);
        tab= new JTabbedPane(JTabbedPane.TOP);
        tab.setEnabled(false);
        tab.setBounds(-2, -25, 1152, 679);
        add(tab);
        
        JPanel menu = new JPanel();
        menu.setLayout(null);
        tab.addTab("New tab", null, menu, null);
        resettable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 80, 1113, 481);
		resettable();
		scrollPane.setViewportView(table);
		ten = new JTextField();
		ten.setBounds(125, 11, 555, 20);
		ten.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String querym=ten.getText();
				String queryt=cmnd.getText();
				filter(querym,queryt);
			}
		});
		ten.setColumns(10);
		
		cmnd = new JTextField();
		cmnd.setBounds(125, 42, 555, 20);
		cmnd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String querym=ten.getText();
				String queryt=cmnd.getText();
				filter(querym,queryt);
			}
		});
		cmnd.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Họ Tên");
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setBounds(24, 14, 91, 14);
		
		JLabel lblNewLabel_1 = new JLabel("CMND");
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1.setBounds(24, 45, 91, 14);
		setLayout(null);
		menu.add(scrollPane);
		menu.add(lblNewLabel);
		menu.add(ten);
		menu.add(lblNewLabel_1);
		menu.add(cmnd);
		//background	
		ImageIcon background=new ImageIcon("src\\gui\\icon\\bg.png");
		Image icon=background.getImage();
		Image newicon=icon.getScaledInstance(1280, 750, Image.SCALE_SMOOTH);
        background=new ImageIcon(newicon);
        
        JLabel lblNewLabel_2 = new JLabel("Tạo tài khoản");
        lblNewLabel_2.setBackground(new Color(255, 255, 255));
        lblNewLabel_2.setOpaque(true);
        lblNewLabel_2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
        		if(e.getButton()==MouseEvent.BUTTON1)
        		{	
        			taotk.reset();
        			tab.setSelectedIndex(2);
        		}
        	}
        });
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(997, 572, 140, 43);
        menu.add(lblNewLabel_2);
        JLabel lblbackground = new JLabel("New label");
        lblbackground.setBounds(0, 0, 1152, 642);
        menu.add(lblbackground);
        lblbackground.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblbackground.setIcon(background);
        JPanel thongtin = new JPanel();
        menuframe.show(thongtin,a);
        tab.addTab("New tab", null, thongtin, null);
        
        JPanel tao = new JPanel();
        tab.addTab("New tab", null, tao, null);
        menuframe.show(tao,b);
        table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
		 		if(e.getButton()==MouseEvent.BUTTON1) {
		 			int i=table.getSelectedRow();
		 			a.username=table.getValueAt(i, 0).toString();
		 			a.load();
		 			tab.setSelectedIndex(1);
		 		}
			}
		});
	}
}
