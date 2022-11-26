package gui.quanlyphieu;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import database.sever;
import gui.menuframe;
import moudel.mayin;
import moudel.phieu;

public class nhapcontrol {
	static String lastma(){
		int max=0;
		String ma="N";
		String num;
		String Sql="select * from PHIEUNHAPXUAT where MAPHIEU like \'N%\'";
        ResultSet data;
        try {
            data = sever.getquery(Sql);
            while(data.next())
            {
            	if(Integer.parseInt(data.getString("MAPHIEU").replace("N",""))>max)
            		System.out.println(Integer.parseInt(data.getString("MAPHIEU").replace("N","")));
            	max=Integer.parseInt(data.getString("MAPHIEU").replace("N",""))+1;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        num=String.valueOf(max);
        for(int i=0;(8-num.length())!=0;i++)
        	num="0"+num;
        ma+=num;
        return ma;
	}
private static void newmodel()
{
			nhappanel.model=new DefaultTableModel(new Object[][] {},new String[] {"STT","Mã sp", "Tên sản phẩm", "Số lượng", "Ghi chú"}) {
	        	Class[] columnTypes = new Class[] {
	        			Integer.class,Object.class, Object.class, Integer.class, String.class
	            	};
	            	public Class getColumnClass(int columnIndex) {
	            		return columnTypes[columnIndex];
	            	}
	            	boolean[] columnEditables = new boolean[] {
	            		false, false, false, true,true
	            	};
	            	public boolean isCellEditable(int row, int column) {
	            		return columnEditables[column];
	            	}

	        };
	        for(int i=0;i<mathang.listma.size();i++)
	        	nhappanel.model.addRow(new Object[] {i+1,mathang.listma.get(i),mathang.listten.get(i),null,null});
}
static void newtable()
{
	newmodel();
	nhappanel.table.setModel(nhappanel.model);
	nhappanel.table.getColumnModel().getColumn(0).setPreferredWidth(30);
	nhappanel.table.getColumnModel().getColumn(1).setPreferredWidth(100);
	nhappanel.table.getColumnModel().getColumn(2).setPreferredWidth(300);
	nhappanel.table.getColumnModel().getColumn(3).setPreferredWidth(40);
	nhappanel.table.getColumnModel().getColumn(4).setPreferredWidth(502);
	nhappanel.table.getColumnModel().getColumn(0).setResizable(false);
	nhappanel.table.getColumnModel().getColumn(1).setResizable(false);
	nhappanel.table.getColumnModel().getColumn(2).setResizable(false);
	nhappanel.table.getColumnModel().getColumn(3).setResizable(false);
	nhappanel.table.getColumnModel().getColumn(4).setResizable(false);
	
}
static boolean nhap()
{
	String sql1="INSERT into PHIEUNHAPXUAT VALUEs (\'"+nhappanel.map.getText()+"\',1,convert(datetime,'"+nhappanel.day.getText()+"',20),'"+nhappanel.us.getText()+"')"; 
	String sql2="INSERT into CHITIETPHIEU VALUES ";
	for(int i=0;i<nhappanel.model.getRowCount();i++)
	{
		
		String ghichu;
		if(nhappanel.model.getValueAt(i,4)!=null)
		ghichu="'"+nhappanel.model.getValueAt(i,4)+"'";
		else ghichu="''";
		if(nhappanel.model.getValueAt(i,3)!=null&&Integer.parseInt(nhappanel.model.getValueAt(i,3).toString())>0)
		sql2+="('"+nhappanel.map.getText()+"',"+nhappanel.model.getValueAt(i,0)+",'"+nhappanel.model.getValueAt(i,1)+"',"+nhappanel.model.getValueAt(i,3)+","+ghichu+")";
		else
		{
			JOptionPane.showMessageDialog(null,"Số lượng không đúng quy định");
			return false;
		}
		if(i<nhappanel.model.getRowCount()-1)
		{
			sql2+=',';
		}
	}
	if(nhappanel.model.getRowCount()==0)
	return false;
	sever.update(sql1);
	sever.update(sql2);
	return true;
}
}
