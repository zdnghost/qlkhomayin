package gui.chinhsua;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import database.sever;
import moudel.mayin;
public class manegercontrol {

    private static int pp = 1;
    private static int loai=0;
    private static int muc1=0,muc2=0,muc3=0,muc4=0,muc5=0,muc6=0;
    private static int cong1=0,cong2=0,cong3=0,cong4=0;
    private static int giay1=0,giay2=0,giay3=0,giay4=0,giay5=0,giay6=0,giay7=0;
    private static int hdh1=0,hdh2=0,hdh3=0,hdh4=0;
    private static void objecttodata(mayin a)
    {
        if(a.loaimayin.equals("Văn Phòng")) loai=1;
        else loai=0;
        //xet pp in
        if(a.ppin.equals("IN PHUN"))
            pp=1;
        if(a.ppin.equals("IN LASER"))
            pp=2;
        if(a.ppin.equals("IN TRUYỀN NHIỆT"))
            pp=3;
        if(a.ppin.equals("IN UV"))
            pp=4;
        //xet muc
        if(a.muc.contains("RIBBON"))
            muc1=1;
        if(a.muc.contains("NHUOM"))
            muc2=1;
        if(a.muc.contains("NUOC"))
            muc3=1;
        if(a.muc.contains("BOT"))
            muc4=1;
        if(a.muc.contains("DAU"))
            muc5=1;
        if(a.muc.contains("DAC"))
            muc6=1;
        if(a.giay.contains("FORD"))
            giay1=1;
        if(a.giay.contains("COUCHE"))
            giay2=1;
        if(a.giay.contains("BRISTOL"))
            giay3=1;
        if(a.giay.contains("DUPLEX"))
            giay4=1;
        if(a.giay.contains("DECAL"))
            giay5=1;
        if(a.giay.contains("KRAFT"))
            giay6=1;
        if(a.giay.contains("IVORNY"))
            giay7=1;
        if(a.cong.contains("USBA"))
            cong1=1;
        if(a.cong.contains("USBB"))
            cong2=1;
        if(a.cong.contains("ENTERNET"))
            cong3=1;
        if(a.cong.contains("WIRELESS"))
            cong4=1;
        if(a.tuongthich.contains("Windows"))
            hdh1=1;
        if(a.tuongthich.contains("iOS"))
            hdh2=1;
        if(a.tuongthich.contains("Linux"))
            hdh3=1;
        if(a.tuongthich.contains("Android"))
            hdh4=1;
    }
    public static void chonhang() {
        int i=manegerpanel.table.getSelectedRow();
        TableModel temp=manegerpanel.table.getModel();
        manegerpanel.key=temp.getValueAt(i,0).toString().trim();
        manegerpanel.txtmasp.setText(manegerpanel.key);
        manegerpanel.txttensp.setText(temp.getValueAt(i,1).toString());
        //getdata loai
        if(temp.getValueAt(i,2).toString().equals("Công Nghiệp"))
        {
            manegerpanel.rdbtCongnghiep.setSelected(true);
        }
        else
        {
            manegerpanel.rdbtVanphong.setSelected(true);
        }
        //getdata ppin
        if(temp.getValueAt(i,3).toString().trim().equals("IN PHUN"))
            manegerpanel.rdbtphun.setSelected(true);
        if(temp.getValueAt(i,3).toString().trim().equals("IN LASER"))
            manegerpanel.rdbtlaser.setSelected(true);
        if(temp.getValueAt(i,3).toString().trim().equals("IN TRUYỀN NHIỆT"))
            manegerpanel.rdbttn.setSelected(true);
        if(temp.getValueAt(i,3).toString().trim().equals("IN UV"))
            manegerpanel.rdbtuv.setSelected(true);
        //check muc ribon
        if(temp.getValueAt(i, 4).toString().contains("RIBBON"))
            manegerpanel.ch_ribbon.setSelected(true);
        else
            manegerpanel.ch_ribbon.setSelected(false);
        //check muc nhuom
        if(temp.getValueAt(i, 4).toString().contains("NHUOM"))
            manegerpanel.ch_nhuom.setSelected(true);
        else
            manegerpanel.ch_nhuom.setSelected(false);
        //check muc nuoc
        if(temp.getValueAt(i, 4).toString().contains("NUOC"))
            manegerpanel.ch_nuoc.setSelected(true);
        else
            manegerpanel.ch_nuoc.setSelected(false);
        //check muc bot
        if(temp.getValueAt(i, 4).toString().contains("BOT"))
            manegerpanel.ch_bot.setSelected(true);
        else
            manegerpanel.ch_bot.setSelected(false);
        //check muc dau
        if(temp.getValueAt(i, 4).toString().contains("DAU"))
            manegerpanel.ch_dau.setSelected(true);
        else
            manegerpanel.ch_dau.setSelected(false);
        //check muc dac
        if(temp.getValueAt(i, 4).toString().contains("DAC"))
            manegerpanel.ch_dac.setSelected(true);
        else
            manegerpanel.ch_dac.setSelected(false);
        //check giay ford
        String giay=temp.getValueAt(i, 5).toString();
        if(giay.contains("FORD"))
            manegerpanel.ch_ford.setSelected(true);
        else
            manegerpanel.ch_ford.setSelected(false);
        //check giay couche
        if(giay.contains("COUCHE"))
            manegerpanel.ch_couche.setSelected(true);
        else
            manegerpanel.ch_couche.setSelected(false);
        //check giay bristol
        if(giay.contains("BRISTOL"))
            manegerpanel.ch_bristol.setSelected(true);
        else
            manegerpanel.ch_bristol.setSelected(false);
        //check giay duplex
        if(giay.contains("DUPLEX"))
            manegerpanel.ch_duplex.setSelected(true);
        else
            manegerpanel.ch_duplex.setSelected(false);
        //check giay decal
        if(giay.contains("DECAL"))
            manegerpanel.ch_decal.setSelected(true);
        else
            manegerpanel.ch_decal.setSelected(false);
        //check giay kraft
        if(giay.contains("KRAFT"))
            manegerpanel.ch_kraft.setSelected(true);
        else
            manegerpanel.ch_kraft.setSelected(false);
        //check giay ivorny
        if(giay.contains("IVORNY"))
            manegerpanel.ch_ivorny.setSelected(true);
        else
            manegerpanel.ch_ivorny.setSelected(false);
        //check ket noi usba
        String day=temp.getValueAt(i, 6).toString();
        if(day.contains("USBA"))
            manegerpanel.ch_usba.setSelected(true);
        else
            manegerpanel.ch_usba.setSelected(false);
        //check ket noi usbb
        
        if(day.contains("USBB"))
            manegerpanel.ch_usbb.setSelected(true);
        else
            manegerpanel.ch_usbb.setSelected(false);
        //check ket noi enternet
        if(day.contains("ENTERNET"))
        {
            manegerpanel.ch_lan.setSelected(true);
        }
        else
            manegerpanel.ch_lan.setSelected(false);
        //check ket noi khong day
        if(day.contains("WIRELESS"))
            manegerpanel.ch_wireless.setSelected(true);
        else
            manegerpanel.ch_wireless.setSelected(false);
        //check hdh window
        if(temp.getValueAt(i, 7).toString().contains("Windows"))
            manegerpanel.ch_window.setSelected(true);
        else
            manegerpanel.ch_window.setSelected(false);
        //check ket noi usbb 
        if(temp.getValueAt(i, 7).toString().contains("iOS"))
            manegerpanel.ch_ios.setSelected(true);
        else
            manegerpanel.ch_ios.setSelected(false);
        //check ket noi enternet
        if(temp.getValueAt(i, 7).toString().contains("Linux"))
            manegerpanel.ch_linux.setSelected(true);
        else
            manegerpanel.ch_linux.setSelected(false);
        //check ket noi khong day
        if(temp.getValueAt(i, 7).toString().contains("Android"))
            manegerpanel.ch_android.setSelected(true);
        else
            manegerpanel.ch_android.setSelected(false);
    }
    private static void newmodel()
    {
        
        manegerpanel.model=new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "Mã sp", "Tên sản phẩm", "Loại máy in", "Phương pháp in", "Mực", "Giấy", "Cổng kết nối","Hệ điều hành"
                }
            ) {
            @Override
            public boolean isCellEditable(int row, int column) {
               //all cells false
               return false;
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
        manegerpanel.model.addRow(new Object[]
        {a.masp,a.tensp,a.loaimayin,a.ppin,a.muc,a.giay,a.cong,a.tuongthich});
        }
      } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }
        
    }

    public static mayin setobject()
    {
        String masp=manegerpanel.txtmasp.getText().trim();
        String tensp=manegerpanel.txttensp.getText().trim();
        String loai="";
        Enumeration<AbstractButton> eloai=manegerpanel.rdbt_loai.getElements();
        while(eloai.hasMoreElements())
        {
            AbstractButton temp=eloai.nextElement();
            if(temp.isSelected()) {
                loai=temp.getText();
            }
        }
        String ppin="";
        Enumeration<AbstractButton> eppin=manegerpanel.rdbt_pp.getElements();
        while(eppin.hasMoreElements())
        {
            AbstractButton temp=eppin.nextElement();
            if(temp.isSelected()) {
                ppin=temp.getText().toUpperCase();
            }
        }
        
        String muc="";
        for(AbstractButton b : manegerpanel.bmuc) {
            if(b.isSelected())
            {
                muc=muc+" "+b.getText().replace("Mực","").replace("dầu","DAU").replace("bột","BOT").replace("nước","NUOC").replace("nhuộm","NHUOM").replace("đặc","DAC");
            }
        }
        
        String giay="";
        for(AbstractButton b : manegerpanel.bgiay) {
            if(b.isSelected())
            {
                giay=giay+" "+b.getText().replace("Giấy","");
            }
        } 
        
        String cong="";
        for(AbstractButton b : manegerpanel.bcong) {
            if(b.isSelected())
            {
                cong=cong+" "+b.getText().replace("usb a", "USBA").replace("usb b", "USBB").replace("ethernet","ENTERNET").replace("kết nối không dây","WIRELESS").replace("dây","");
            }
        }
        
        String hdh="";
        for(AbstractButton b : manegerpanel.bhdh) {
            if(b.isSelected())
            {
                hdh=hdh+" "+b.getText();
            }
        }
      
        mayin a=new mayin(masp,tensp,0,loai,ppin,muc,giay,cong,hdh);
        
        return a;
    }
    public static void newtable() 
      {
      newmodel();
      manegerpanel.table.setModel(manegerpanel.model);
      manegerpanel.table.setFont(new Font("Tahoma", Font.PLAIN, 10));
      manegerpanel.table.getColumnModel().getColumn(0).setPreferredWidth(40);
      manegerpanel.table.getColumnModel().getColumn(1).setPreferredWidth(151);
      manegerpanel.table.getColumnModel().getColumn(2).setPreferredWidth(70);
      manegerpanel.table.getColumnModel().getColumn(3).setPreferredWidth(100);
      manegerpanel.table.getColumnModel().getColumn(4).setPreferredWidth(210);
      manegerpanel.table.getColumnModel().getColumn(5).setPreferredWidth(290);
      manegerpanel.table.getColumnModel().getColumn(6).setPreferredWidth(170);
      manegerpanel.table.getColumnModel().getColumn(7).setPreferredWidth(140);
      manegerpanel.table.getColumnModel().getColumn(0).setResizable(false);
      manegerpanel.table.getColumnModel().getColumn(1).setResizable(false);
      manegerpanel.table.getColumnModel().getColumn(2).setResizable(false);
      manegerpanel.table.getColumnModel().getColumn(3).setResizable(false);
      manegerpanel.table.getColumnModel().getColumn(4).setResizable(false);
      manegerpanel.table.getColumnModel().getColumn(5).setResizable(false);
      manegerpanel.table.getColumnModel().getColumn(6).setResizable(false);
      manegerpanel.table.getColumnModel().getColumn(7).setResizable(false);
      manegerpanel.table.getTableHeader().setResizingAllowed(false);
      TableRowSorter<DefaultTableModel> sort=new TableRowSorter<DefaultTableModel>(manegerpanel.model);
      manegerpanel.table.setRowSorter(sort);
      }
    public static void adddata(mayin a)
      {
        String sql1="INSERT INTO SANPHAM"
                + " VALUES (\'"+a.masp+"\',\'"+a.tensp+"\',"+a.sl+")";
         if(sever.update(sql1)==false)
         	{	
        	JOptionPane.showMessageDialog(null,"Mặt hàng này đã tồn tại");
        	return;
        	}
         objecttodata(a);
         String sql2="INSERT INTO MAYIN "
                 + "VALUES (\'"+a.masp+"\'"
                 + ","+loai+""
                 + ","+pp+""
                 + ","+muc1+","+muc2+","+muc3+","+muc4+","+muc5+","+muc6      //muc
                 + ","+giay1+ ","+giay2+ ","+giay3+ ","+giay4+ ","+giay5+ ","+giay6+ ","+giay7      //giay
                 + ","+cong1+ ","+cong2+ ","+cong3+ ","+cong4     //cong ket noi
                 +"," +hdh1+ ","+hdh2+ ","+hdh3+ ","+hdh4+")"       //he dieu hanh
                 ;      
         
         sever.update(sql2);
         newtable();
         }
      public static void updatedata(mayin a) 
      {
    	  int sure=JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn thay đổi thông tin mặt hàng này","Wanring",JOptionPane.YES_NO_OPTION);
    	  if(sure == JOptionPane.YES_OPTION){
          String sql1="UPDATE SANPHAM "
              + "SET MASP=\'"+a.masp+"\',TENSP =\'"+a.tensp+"\' "
              + "WHERE MASP=\'"+manegerpanel.key+"\'";
           sever.update(sql1);
         //loai
           objecttodata(a);
          //cap nhat du lieu vao bang MAYIN
           String sql2="UPDATE MAYIN "
                   + "SET LOAI ="+loai+",PHUONGPHAPIN="+pp
                       +",MUC_RIBBON="+muc1+",MUC_NHUOM="+muc2+",MUC_NUOC="+muc3+",MUC_BOT="+muc4+",MUC_DAU="+muc5+",MUC_DAC="+muc6
                           +",GIAY_FORD="+giay1+",GIAY_COUCHE="+giay2+",GIAY_BRISTOL="+giay3+",GIAY_DUPLEX="+giay4+",GIAY_DECAL="+giay5+",GIAY_KRAFT="+giay6+",GIAY_IVORNY="+giay7
                               +",KETNOI_USBA="+cong1+",KETNOI_USBB="+cong2+",KETNOI_ENTERNET="+cong3+",KETNOI_WIRELESS="+cong4
                                   +",HDH_WIN="+hdh1+",HDH_IOS="+hdh2+",HDH_LINUX="+hdh3+",HDH_ANDROID="+hdh4
                                       + " WHERE MASP=\'"+a.masp+"\'";
           sever.update(sql2);
           newtable();
    	  }
      }
      public static void deletedata(mayin a)
      {
    	  int sure=JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn xóa mặt hàng này","Wanring",JOptionPane.YES_NO_OPTION);
    	  if(sure == JOptionPane.YES_OPTION){
          String sql="DELETE FROM SANPHAM WHERE MASP=\'"+a.masp+"\'";
          if(sever.update(sql)==false)
        	  JOptionPane.showMessageDialog(null,"Không thể xóa mặt hàng\n Mặt hàng này có dữ liệu khác");
          newtable();}
      }
      static void refresh()
      {
          manegerpanel.txtmasp.setText("");
          manegerpanel.txttensp.setText("");
          manegerpanel.rdbtVanphong.setSelected(true);
          manegerpanel.rdbtlaser.setSelected(true);;
          manegerpanel.ch_ribbon.setSelected(false);
          manegerpanel.ch_nhuom.setSelected(false);
          manegerpanel.ch_nuoc.setSelected(false);
          manegerpanel.ch_bot.setSelected(false);
          manegerpanel.ch_dau.setSelected(false);
          manegerpanel.ch_dac.setSelected(false);
          manegerpanel.ch_ford.setSelected(false);
          manegerpanel.ch_couche.setSelected(false);
          manegerpanel.ch_bristol.setSelected(false);
          manegerpanel.ch_duplex.setSelected(false);
          manegerpanel.ch_decal.setSelected(false);
          manegerpanel.ch_kraft.setSelected(false);
          manegerpanel.ch_ivorny.setSelected(false);
          manegerpanel.ch_usba.setSelected(false);
          manegerpanel.ch_usbb.setSelected(false);
          manegerpanel.ch_lan.setSelected(false);
          manegerpanel.ch_wireless.setSelected(false);
          manegerpanel.ch_window.setSelected(false);
          manegerpanel.ch_ios.setSelected(false);
          manegerpanel.ch_linux.setSelected(false);
          manegerpanel.ch_android.setSelected(false);
      }
}
