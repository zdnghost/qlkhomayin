package gui.quanlyphieu;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import database.sever;
import gui.menuframe;
import moudel.mayin;
import moudel.phieu;

public class xuatcontrol {
	
	static String lastma(){
		int max=0;
		String ma="X";
		String num;
		String Sql="select * from PHIEUNHAPXUAT where MAPHIEU like \'X%\'";
        ResultSet data;
        try {
            data = sever.getquery(Sql);
            while(data.next())
            {
            	if(Integer.parseInt(data.getString("MAPHIEU").replace("X",""))>max)
            		System.out.println(Integer.parseInt(data.getString("MAPHIEU").replace("X","")));
            	max=Integer.parseInt(data.getString("MAPHIEU").replace("X",""))+1;
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
			xuatpanel.model=new DefaultTableModel(new Object[][] {},new String[] {"STT","Mã sp", "Tên sản phẩm", "Số lượng", "Ghi chú"}) {
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
	        	xuatpanel.model.addRow(new Object[] {i+1,quanlyphieucontrol.chonhang.listma.get(i),quanlyphieucontrol.chonhang.listten.get(i),null,null});
}
static void newtable()
{
	newmodel();
	xuatpanel.table.setModel(xuatpanel.model);
	xuatpanel.table.getColumnModel().getColumn(0).setPreferredWidth(30);
	xuatpanel.table.getColumnModel().getColumn(1).setPreferredWidth(100);
	xuatpanel.table.getColumnModel().getColumn(2).setPreferredWidth(300);
	xuatpanel.table.getColumnModel().getColumn(3).setPreferredWidth(40);
	xuatpanel.table.getColumnModel().getColumn(4).setPreferredWidth(502);
	xuatpanel.table.getColumnModel().getColumn(0).setResizable(false);
	xuatpanel.table.getColumnModel().getColumn(1).setResizable(false);
	xuatpanel.table.getColumnModel().getColumn(2).setResizable(false);
	xuatpanel.table.getColumnModel().getColumn(3).setResizable(false);
	xuatpanel.table.getColumnModel().getColumn(4).setResizable(false);
}

static void xuat()
{
	String sql1="INSERT into PHIEUNHAPXUAT VALUEs (\'"+xuatpanel.map.getText()+"\',0,convert(datetime,'"+xuatpanel.day.getText()+"',20),'"+xuatpanel.us.getText()+"')"; 
	sever.update(sql1);
	String sql2="INSERT into CHITIETPHIEU VALUES ";
	for(int i=0;i<xuatpanel.model.getRowCount();i++)
	{
		
		String ghichu;
		if(xuatpanel.model.getValueAt(i,4)!=null)
		ghichu="'"+xuatpanel.model.getValueAt(i,4)+"'";
		else ghichu="null";
		sql2+="('"+xuatpanel.map.getText()+"',"+xuatpanel.model.getValueAt(i,0)+",'"+xuatpanel.model.getValueAt(i,1)+"',-"+(xuatpanel.model.getValueAt(i,3))+","+ghichu+")";
		if(i!=xuatpanel.model.getRowCount()-1)
		{
			sql2+=',';
		}
	}
	sever.update(sql2);
}

}
