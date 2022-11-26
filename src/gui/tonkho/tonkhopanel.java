package gui.tonkho;

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
import moudel.mayin;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class tonkhopanel extends JPanel {
	private JTextField ma;
	private JTextField ten;
	private static JTable table=new JTable();
	private static DefaultTableModel model;
	
	private static void newmodel()
    {
        
        model=new DefaultTableModel(
                new Object[][] {},
                new String[] {"Mã sp", "Tên sản phẩm", "Số lượng","Loại","Phương pháp in"}) {
        	Class[] columnTypes = new Class[] {
            		String.class, String.class, Integer.class,String.class,String.class
            	};
            	public Class getColumnClass(int columnIndex) {
            		return columnTypes[columnIndex];
            	}
            	boolean[] columnEditables = new boolean[] {
            		false, false, false,false,false
            	};
            	public boolean isCellEditable(int row, int column) {
            		return columnEditables[column];
            	}

        };
        String Sql="select * from SANPHAM,MAYIN,PHUONGPHAPIN where SANPHAM.MASP=MAYIN.MASP AND PHUONGPHAPIN=PP";
        ResultSet data;
      try {
          data = sever.getquery(Sql);
          mayin a=new mayin();
        while(data.next())
        {
        a.datatoobject(data);
        model.addRow(new Object[]
        {a.masp,a.tensp,a.sl,a.loaimayin,a.ppin.toLowerCase()});
        }
      } 
      catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }
        
    }  
	public void resettable() 
    {
    newmodel();
    tonkhopanel.table.setModel(model);
    tonkhopanel.table.getColumnModel().getColumn(0).setPreferredWidth(100);
    tonkhopanel.table.getColumnModel().getColumn(1).setPreferredWidth(502);
    tonkhopanel.table.getColumnModel().getColumn(3).setPreferredWidth(100);
    tonkhopanel.table.getColumnModel().getColumn(0).setResizable(false);
    tonkhopanel.table.getColumnModel().getColumn(1).setResizable(false);
    tonkhopanel.table.getColumnModel().getColumn(2).setResizable(false);
    tonkhopanel.table.getColumnModel().getColumn(3).setResizable(false);
    }
	private static void filter(String ma,String ten){
	    TableRowSorter<DefaultTableModel> fl=new  TableRowSorter<DefaultTableModel>(model);
	    table.setRowSorter(fl);

	    List<RowFilter<Object, Object>> filters = new  ArrayList<RowFilter<Object, Object>>(2);
	  //filtering based on Strings text and avail
	   filters.add(RowFilter.regexFilter(ma,0));
	   filters.add(RowFilter.regexFilter(ten,1));
	   RowFilter<Object, Object> rf = RowFilter.andFilter(filters);
	   fl.setRowFilter(rf);
	}
	/**
	 * Create the panel.
	 */
	public tonkhopanel() {
		resettable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 80, 1064, 491);
		resettable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
		 		if(e.getButton()==MouseEvent.BUTTON1) {
		 			int i=table.getSelectedRow();
		 			String ma=table.getValueAt(i, 0).toString();
		 		}
			}
		});
		scrollPane.setViewportView(table);
		ma = new JTextField();
		ma.setBounds(125, 11, 555, 20);
		ma.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String querym=ma.getText();
				String queryt=ten.getText();
				filter(querym,queryt);
			}
		});
		ma.setColumns(10);
		
		ten = new JTextField();
		ten.setBounds(125, 42, 555, 20);
		ten.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String querym=ma.getText();
				String queryt=ten.getText();
				filter(querym,queryt);
			}
		});
		ten.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Mã sản phẩm");
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setBounds(24, 14, 91, 14);
		
		JLabel lblNewLabel_1 = new JLabel("Tên sản phẩm ");
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1.setBounds(24, 45, 91, 14);
		setLayout(null);
		add(scrollPane);
		add(lblNewLabel);
		add(ma);
		add(lblNewLabel_1);
		add(ten);
		//background	
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
