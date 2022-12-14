package gui.quanlyphieu;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import database.sever;
import gui.menuframe;
import moudel.mayin;
import moudel.phieu;

public class quanlyphieucontrol
{
	static mathang chonhang=new mathang();
	static void getvaule() {
		chonhang.setVisible(true);
		chonhang.setTitle("Xuathang");
	}
    private static void newmodel()
    {
        
        quanlyphieupanel.model=new DefaultTableModel(
                new Object[][] {},
                new String[] {
                    "Mã phiếu","Người tạo" ,"ngày", "loại"}
            ) {
            @Override
            public boolean isCellEditable(int row, int column) {
               //all cells false
               return false;
            }
        };
        String Sql="select * from PHIEUNHAPXUAT order by NGAY DESC";
        ResultSet data;
      try {
          data = sever.getquery(Sql);
          phieu a=new phieu();
        while(data.next())
        {
        a.datatoobject(data);
        String loai="";
        if(a.isLoai())
        	loai="Nhập";
        else
        	loai="Xuất";
        quanlyphieupanel.model.addRow(new Object[]
        {a.getMaphieu(),a.getUser(),(a.getNgay()+"n").replace(".0n",""),loai});
        }
      } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }
    }
    public static void newtable() 
    {
    newmodel();
    quanlyphieupanel.table.setModel(quanlyphieupanel.model);
    quanlyphieupanel.table.setFont(new Font("Tahoma", Font.PLAIN, 10));
    quanlyphieupanel.table.getTableHeader().setResizingAllowed(false);
    quanlyphieupanel.table.getColumnModel().getColumn(0).setResizable(false);
    quanlyphieupanel.table.getColumnModel().getColumn(1).setResizable(false);
    quanlyphieupanel.table.getColumnModel().getColumn(2).setResizable(false);
    quanlyphieupanel.table.getColumnModel().getColumn(3).setResizable(false);
    if(menuframe.user.chucvu.contains("ADMIN"))
    	quanlyphieupanel.button.setBounds(10, 42, 164, 46*2);
	else
		quanlyphieupanel.button.setBounds(10, 42, 164, 46);
    if(menuframe.user.chucvu.contains("nhập")||menuframe.user.chucvu.contains("ADMIN"))
    	quanlyphieupanel.button.add(quanlyphieupanel.bnhap);
	if(menuframe.user.chucvu.contains("xuất")||menuframe.user.chucvu.contains("ADMIN"))
		quanlyphieupanel.button.add(quanlyphieupanel.bxuat);
    }
    static void updatesl()
    {
    	String sql1="select MASP from sanpham";
    	try {
			ResultSet data=sever.getquery(sql1);
			String ma;
			while(data.next())
			{
				ma=data.getString("MASP");
				String sql2="update SANPHAM SET SL=(SELECT SUM(SL) FROM CHITIETPHIEU GROUP BY MASP HAVING MASP='"+ma+"') WHERE MASP='"+ma+"'";
				sever.update(sql2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
}
