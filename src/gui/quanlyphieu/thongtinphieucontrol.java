package gui.quanlyphieu;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import database.sever;

public class thongtinphieucontrol {
	

	
	public static void setphieu(String ma) {

		
		try {		
			String sql1="Select * from PHIEUNHAPXUAT WHERE MAPHIEU='"+ma+"'";
			ResultSet tt = sever.getquery(sql1);
			tt.next();
			thongtinphieupanel.ma.setText(tt.getString("MAPHIEU"));
			String loai;
			if(tt.getBoolean("XUATNHAP"))
				loai="nhập";
			else
				loai="xuất";
			thongtinphieupanel.l.setText(loai);
			thongtinphieupanel.day.setText(tt.getString("NGAY"));
			thongtinphieupanel.us.setText(tt.getString("USERNAME"));
			newtable(ma);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void newmodel(String ma)
	{
				try {
					thongtinphieupanel.model=new DefaultTableModel(new Object[][] {},new String[] {"STT","Mã sp", "Tên sản phẩm", "Số lượng", "Ghi chú"}) {
						Class[] columnTypes = new Class[] {
								Integer.class,String.class, String.class, Integer.class, String.class
					    	};
					    	public Class getColumnClass(int columnIndex) {
					    		return columnTypes[columnIndex];
					    	}
					    	boolean[] columnEditables = new boolean[] {
					    		false, false, false, false,false
					    	};
					    	public boolean isCellEditable(int row, int column) {
					    		return columnEditables[column];
					    	}	    	
					};
			String sql2="Select STT,SANPHAM.MASP,TENSP,CHITIETPHIEU.SL,GHICHU from CHITIETPHIEU,SANPHAM WHERE MAPHIEU='"+ma+"' and SANPHAM.MASP=CHITIETPHIEU.MASP order by STT";
			ResultSet data=sever.getquery(sql2);
			int sl;
			while(data.next())
			{
				sl=data.getInt("SL");
				sl=Math.abs(sl);
				thongtinphieupanel.model.addRow(new Object[]{data.getInt("STT"),data.getString("MASP"),data.getString("TENSP"),sl,data.getString("GHICHU")});
			}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	static void newtable(String ma)
	{
		newmodel(ma);
		thongtinphieupanel.table.setModel(thongtinphieupanel.model);
		thongtinphieupanel.table.getColumnModel().getColumn(0).setPreferredWidth(30);
		thongtinphieupanel.table.getColumnModel().getColumn(1).setPreferredWidth(100);
		thongtinphieupanel.table.getColumnModel().getColumn(2).setPreferredWidth(300);
		thongtinphieupanel.table.getColumnModel().getColumn(3).setPreferredWidth(40);
		thongtinphieupanel.table.getColumnModel().getColumn(4).setPreferredWidth(502);
		thongtinphieupanel.table.getColumnModel().getColumn(0).setResizable(false);
		thongtinphieupanel.table.getColumnModel().getColumn(1).setResizable(false);
		thongtinphieupanel.table.getColumnModel().getColumn(2).setResizable(false);
		thongtinphieupanel.table.getColumnModel().getColumn(3).setResizable(false);
		thongtinphieupanel.table.getColumnModel().getColumn(4).setResizable(false);
	}
}
