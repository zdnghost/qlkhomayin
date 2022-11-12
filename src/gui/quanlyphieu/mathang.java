package gui.quanlyphieu;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import database.sever;
import gui.chinhsua.manegerpanel;
import moudel.mayin;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class mathang extends JFrame {

	private JPanel contentPane;
	private static JTable table=new JTable();
	private static DefaultTableModel model;
	private static JTextField ten;
	private static JTextField ma;
	
	static ArrayList<String> listma= new ArrayList<String>();
	static ArrayList<String> listten= new ArrayList<String>();
//	static ArrayList<Integer> listsl= new ArrayList<Integer>();
	/**
	 * Launch the application.
	 */
	private static void newmodel()
    {
        
        model=new DefaultTableModel(
                new Object[][] {},
                new String[] {"Mã sp", "Tên sản phẩm", "Số lượng", "Chọn"}) {
        	Class[] columnTypes = new Class[] {
            		Object.class, Object.class, Integer.class, Boolean.class
            	};
            	public Class getColumnClass(int columnIndex) {
            		return columnTypes[columnIndex];
            	}
            	boolean[] columnEditables = new boolean[] {
            		false, false, false, true
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
        {a.masp,a.tensp,a.sl,Boolean.FALSE});
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
    this.table.setModel(model);
    this.table.getColumnModel().getColumn(0).setPreferredWidth(100);
    this.table.getColumnModel().getColumn(1).setPreferredWidth(502);
    this.table.getColumnModel().getColumn(2).setPreferredWidth(80);
    this.table.getColumnModel().getColumn(3).setPreferredWidth(40);
    this.table.getColumnModel().getColumn(0).setResizable(false);
    this.table.getColumnModel().getColumn(1).setResizable(false);
    this.table.getColumnModel().getColumn(2).setResizable(false);
    this.table.getColumnModel().getColumn(3).setResizable(false);
    System.out.println("ok");
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
	static void done()
	{
		ma.setText("");
		ten.setText("");
		filter(ma.getText(),ten.getText());
		listten.clear();
		listma.clear();			
		for(int i=0;i<table.getRowCount();i++)
		{
			String matemp=table.getValueAt(i,0).toString();
			String tentemp=table.getValueAt(i,1).toString();
			Boolean check=Boolean.valueOf(table.getValueAt(i, 3).toString());
			if(check) {
				listma.add(matemp);
				listten.add(tentemp);
			}
		}
		if(quanlyphieupanel.tab.getSelectedIndex()==1)
		nhapcontrol.newtable();
		if(quanlyphieupanel.tab.getSelectedIndex()==2)
		xuatcontrol.newtable();
	}
	

	/**
	 * Create the frame.
	 */
	public mathang() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 758, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 722, 414);
		contentPane.add(scrollPane);
		
		resettable();
		scrollPane.setViewportView(table);
		
		JLabel breset = new JLabel("Refesh");
		breset.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON1) {
					resettable();
				}
			}
		});
		breset.setHorizontalAlignment(SwingConstants.CENTER);
		breset.setBorder(new LineBorder(new Color(0, 0, 0)));
		breset.setBounds(499, 499, 84, 35);
		contentPane.add(breset);
		
		JLabel bchose = new JLabel("Done");
		bchose.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON1)
				{
					done();
					setVisible(false); 
				}
			}
		});
		bchose.setHorizontalAlignment(SwingConstants.CENTER);
		bchose.setBorder(new LineBorder(new Color(0, 0, 0)));
		bchose.setBounds(593, 499, 84, 35);
		contentPane.add(bchose);
		
		ten = new JTextField();
		ten.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String querym=ma.getText();
				String queryt=ten.getText();
				filter(querym,queryt);
			}
		});
		ten.setBounds(177, 43, 555, 20);
		contentPane.add(ten);
		ten.setColumns(10);
		
		ma = new JTextField();
		ma.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String querym=ma.getText();
				String queryt=ten.getText();
				filter(querym,queryt);
			}
		});
		ma.setColumns(10);
		ma.setBounds(177, 12, 555, 20);
		contentPane.add(ma);
		
		JLabel lblNewLabel = new JLabel("Mã sản phẩm");
		lblNewLabel.setBounds(76, 15, 91, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên sản phẩm ");
		lblNewLabel_1.setBounds(76, 46, 91, 14);
		contentPane.add(lblNewLabel_1);
	}
}
