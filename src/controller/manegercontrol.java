package controller;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.AbstractButton;
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
        int i=gui.manegerpanel.table.getSelectedRow();
        TableModel temp=gui.manegerpanel.table.getModel();
        gui.manegerpanel.key=temp.getValueAt(i,0).toString().trim();
        gui.manegerpanel.txtmasp.setText(gui.manegerpanel.key);
        gui.manegerpanel.txttensp.setText(temp.getValueAt(i,1).toString());
        //getdata loai
        if(temp.getValueAt(i,2).toString().equals("Công Nghiệp"))
        {
            gui.manegerpanel.rdbtCongnghiep.setSelected(true);
        }
        else
        {
            gui.manegerpanel.rdbtVanphong.setSelected(true);
        }
        //getdata ppin
        if(temp.getValueAt(i,3).toString().trim().equals("IN PHUN"))
            gui.manegerpanel.rdbtphun.setSelected(true);
        if(temp.getValueAt(i,3).toString().trim().equals("IN LASER"))
            gui.manegerpanel.rdbtlaser.setSelected(true);
        if(temp.getValueAt(i,3).toString().trim().equals("IN TRUYỀN NHIỆT"))
            gui.manegerpanel.rdbttn.setSelected(true);
        if(temp.getValueAt(i,3).toString().trim().equals("IN UV"))
            gui.manegerpanel.rdbtuv.setSelected(true);
        //check muc ribon
        if(temp.getValueAt(i, 4).toString().contains("RIBBON"))
            gui.manegerpanel.ch_ribbon.setSelected(true);
        else
            gui.manegerpanel.ch_ribbon.setSelected(false);
        //check muc nhuom
        if(temp.getValueAt(i, 4).toString().contains("NHUOM"))
            gui.manegerpanel.ch_nhuom.setSelected(true);
        else
            gui.manegerpanel.ch_nhuom.setSelected(false);
        //check muc nuoc
        if(temp.getValueAt(i, 4).toString().contains("NUOC"))
            gui.manegerpanel.ch_nuoc.setSelected(true);
        else
            gui.manegerpanel.ch_nuoc.setSelected(false);
        //check muc bot
        if(temp.getValueAt(i, 4).toString().contains("BOT"))
            gui.manegerpanel.ch_bot.setSelected(true);
        else
            gui.manegerpanel.ch_bot.setSelected(false);
        //check muc dau
        if(temp.getValueAt(i, 4).toString().contains("DAU"))
            gui.manegerpanel.ch_dau.setSelected(true);
        else
            gui.manegerpanel.ch_dau.setSelected(false);
        //check muc dac
        if(temp.getValueAt(i, 4).toString().contains("DAC"))
            gui.manegerpanel.ch_dac.setSelected(true);
        else
            gui.manegerpanel.ch_dac.setSelected(false);
        //check giay ford
        String giay=temp.getValueAt(i, 5).toString();
        if(giay.contains("FORD"))
            gui.manegerpanel.ch_ford.setSelected(true);
        else
            gui.manegerpanel.ch_ford.setSelected(false);
        //check giay couche
        if(giay.contains("COUCHE"))
            gui.manegerpanel.ch_couche.setSelected(true);
        else
            gui.manegerpanel.ch_couche.setSelected(false);
        //check giay bristol
        if(giay.contains("BRISTOL"))
            gui.manegerpanel.ch_bristol.setSelected(true);
        else
            gui.manegerpanel.ch_bristol.setSelected(false);
        //check giay duplex
        if(giay.contains("DUPLEX"))
            gui.manegerpanel.ch_duplex.setSelected(true);
        else
            gui.manegerpanel.ch_duplex.setSelected(false);
        //check giay decal
        if(giay.contains("DECAL"))
            gui.manegerpanel.ch_decal.setSelected(true);
        else
            gui.manegerpanel.ch_decal.setSelected(false);
        //check giay kraft
        if(giay.contains("KRAFT"))
            gui.manegerpanel.ch_kraft.setSelected(true);
        else
            gui.manegerpanel.ch_kraft.setSelected(false);
        //check giay ivorny
        if(giay.contains("IVORNY"))
            gui.manegerpanel.ch_ivorny.setSelected(true);
        else
            gui.manegerpanel.ch_ivorny.setSelected(false);
        //check ket noi usba
        String day=temp.getValueAt(i, 6).toString();
        if(day.contains("USBA"))
            gui.manegerpanel.ch_usba.setSelected(true);
        else
            gui.manegerpanel.ch_usba.setSelected(false);
        //check ket noi usbb
        
        if(day.contains("USBB"))
            gui.manegerpanel.ch_usbb.setSelected(true);
        else
            gui.manegerpanel.ch_usbb.setSelected(false);
        //check ket noi enternet
        if(day.contains("ENTERNET"))
        {
            gui.manegerpanel.ch_lan.setSelected(true);
        }
        else
            gui.manegerpanel.ch_lan.setSelected(false);
        //check ket noi khong day
        if(day.contains("WIRELESS"))
            gui.manegerpanel.ch_wireless.setSelected(true);
        else
            gui.manegerpanel.ch_wireless.setSelected(false);
        //check hdh window
        if(temp.getValueAt(i, 7).toString().contains("Windows"))
            gui.manegerpanel.ch_window.setSelected(true);
        else
            gui.manegerpanel.ch_window.setSelected(false);
        //check ket noi usbb 
        if(temp.getValueAt(i, 7).toString().contains("iOS"))
            gui.manegerpanel.ch_ios.setSelected(true);
        else
            gui.manegerpanel.ch_ios.setSelected(false);
        //check ket noi enternet
        if(temp.getValueAt(i, 7).toString().contains("Linux"))
            gui.manegerpanel.ch_linux.setSelected(true);
        else
            gui.manegerpanel.ch_linux.setSelected(false);
        //check ket noi khong day
        if(temp.getValueAt(i, 7).toString().contains("Android"))
            gui.manegerpanel.ch_android.setSelected(true);
        else
            gui.manegerpanel.ch_android.setSelected(false);
    }
    private static void newmodel()
    {
        
        gui.manegerpanel.model=new DefaultTableModel(
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
        gui.manegerpanel.model.addRow(new Object[]
        {a.masp,a.tensp,a.loaimayin,a.ppin,a.muc,a.giay,a.cong,a.tuongthich});
        }
      } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }
        
    }

    public static mayin setobject()
    {
        String masp=gui.manegerpanel.txtmasp.getText().trim();
        String tensp=gui.manegerpanel.txttensp.getText().trim();
        String loai="";
        Enumeration<AbstractButton> eloai=gui.manegerpanel.rdbt_loai.getElements();
        while(eloai.hasMoreElements())
        {
            AbstractButton temp=eloai.nextElement();
            if(temp.isSelected()) {
                loai=temp.getText();
            }
        }
        String ppin="";
        Enumeration<AbstractButton> eppin=gui.manegerpanel.rdbt_pp.getElements();
        while(eppin.hasMoreElements())
        {
            AbstractButton temp=eppin.nextElement();
            if(temp.isSelected()) {
                ppin=temp.getText().toUpperCase();
            }
        }
        
        String muc="";
        for(AbstractButton b : gui.manegerpanel.bmuc) {
            if(b.isSelected())
            {
                muc=muc+" "+b.getText().replace("Mực","").replace("dầu","DAU").replace("bột","BOT").replace("nước","NUOC").replace("nhuộm","NHUOM").replace("đặc","DAC");
            }
        }
        
        String giay="";
        for(AbstractButton b : gui.manegerpanel.bgiay) {
            if(b.isSelected())
            {
                giay=giay+" "+b.getText().replace("Giấy","");
            }
        } 
        
        String cong="";
        for(AbstractButton b : gui.manegerpanel.bcong) {
            if(b.isSelected())
            {
                cong=cong+" "+b.getText().replace("usb a", "USBA").replace("usb b", "USBB").replace("ethernet","ENTERNET").replace("kết nối không dây","WIRELESS").replace("dây","");
            }
        }
        
        String hdh="";
        for(AbstractButton b : gui.manegerpanel.bhdh) {
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
      gui.manegerpanel.table.setModel(gui.manegerpanel.model);
      gui.manegerpanel.table.setFont(new Font("Tahoma", Font.PLAIN, 10));
      gui.manegerpanel.table.getColumnModel().getColumn(0).setPreferredWidth(40);
      gui.manegerpanel.table.getColumnModel().getColumn(1).setPreferredWidth(151);
      gui.manegerpanel.table.getColumnModel().getColumn(2).setPreferredWidth(70);
      gui.manegerpanel.table.getColumnModel().getColumn(3).setPreferredWidth(100);
      gui.manegerpanel.table.getColumnModel().getColumn(4).setPreferredWidth(210);
      gui.manegerpanel.table.getColumnModel().getColumn(5).setPreferredWidth(290);
      gui.manegerpanel.table.getColumnModel().getColumn(6).setPreferredWidth(170);
      gui.manegerpanel.table.getColumnModel().getColumn(7).setPreferredWidth(140);
      gui.manegerpanel.table.getTableHeader().setResizingAllowed(false);
      TableRowSorter sort=new TableRowSorter(gui.manegerpanel.model);
      gui.manegerpanel.table.setRowSorter(sort);
      }
    public static void adddata(mayin a)
      {
        String sql1="INSERT INTO SANPHAM"
                + " VALUES (\'"+a.masp+"\',\'"+a.tensp+"\',"+a.sl+")";
         sever.update(sql1);
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
          String sql1="UPDATE SANPHAM "
              + "SET MASP=\'"+a.masp+"\',TENSP =\'"+a.tensp+"\' "
              + "WHERE MASP=\'"+gui.manegerpanel.key+"\'";
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
      public static void deletedata(mayin a)
      {
          String sql="DELETE FROM SANPHAM WHERE MASP=\'"+a.masp+"\'";
          sever.update(sql);
          newtable();
      }
      public static void refresh()
      {
          gui.manegerpanel.txtmasp.setText("");
          gui.manegerpanel.txttensp.setText("");
          gui.manegerpanel.rdbtVanphong.setSelected(true);
          gui.manegerpanel.rdbtlaser.setSelected(true);;
          gui.manegerpanel.ch_ribbon.setSelected(false);
          gui.manegerpanel.ch_nhuom.setSelected(false);
          gui.manegerpanel.ch_nuoc.setSelected(false);
          gui.manegerpanel.ch_bot.setSelected(false);
          gui.manegerpanel.ch_dau.setSelected(false);
          gui.manegerpanel.ch_dac.setSelected(false);
          gui.manegerpanel.ch_ford.setSelected(false);
          gui.manegerpanel.ch_couche.setSelected(false);
          gui.manegerpanel.ch_bristol.setSelected(false);
          gui.manegerpanel.ch_duplex.setSelected(false);
          gui.manegerpanel.ch_decal.setSelected(false);
          gui.manegerpanel.ch_kraft.setSelected(false);
          gui.manegerpanel.ch_ivorny.setSelected(false);
          gui.manegerpanel.ch_usba.setSelected(false);
          gui.manegerpanel.ch_usbb.setSelected(false);
          gui.manegerpanel.ch_lan.setSelected(false);
          gui.manegerpanel.ch_wireless.setSelected(false);
          gui.manegerpanel.ch_window.setSelected(false);
          gui.manegerpanel.ch_ios.setSelected(false);
          gui.manegerpanel.ch_linux.setSelected(false);
          gui.manegerpanel.ch_android.setSelected(false);
      }
}
