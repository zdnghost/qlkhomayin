package moudel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class mayin extends sanpham{
    public String loaimayin="";
    public String ppin="";
    public String muc="";
    public String giay="";
    public String cong="";
    public String tuongthich="";
    public mayin(){}
    public mayin(String masp,String tensp,int sl,String loai,String phuongphap,String muc,String giay,String port,String tt)
    {
        super(masp,tensp,sl);
        this.loaimayin=loai;
        this.ppin=phuongphap;
        this.muc=muc;
        this.giay=giay;
        this.cong=port;
        this.tuongthich=tt;
    }
    //set
    public void setLoaimayin(String loaimayin) {
        this.loaimayin = loaimayin;
    }
    public void setPpin(String ppin) {
        this.ppin = ppin;
    }
    public void setMuc(String muc) {
        this.muc = muc;
    }
    public void setGiay(String giay) {
        this.giay = giay;
    }
    public void setCong(String cong) {
        this.cong = cong;
    }
    public void setTuongthich(String tuongthich) {
        this.tuongthich = tuongthich;
    }
    //get
    public String getLoaimayin() {
        return loaimayin;
    }
    public String getPpin() {
        return ppin;
    }
    public String getMuc() {
        return muc;
    }
    public String getCong() {
        return cong;
    }
    public String getTuongthich() {
        return tuongthich;
    }
    //đưa dữ liệu thành đối tượng
    public void datatoobject(ResultSet a) throws SQLException
    {
        this.setMasp(a.getString("MASP"));
        this.setTensp(a.getString("TENSP"));
        this.setSl(a.getInt("SL"));
        if(a.getBoolean("LOAI")==true)
            this.setLoaimayin("Công Nghiệp");
        else this.setLoaimayin("Văn Phòng");
        this.setPpin(a.getString("PHUONGPHAP"));
        String muc="";
        if(a.getBoolean("MUC_RIBBON"))
            muc+="RIBBON ";
        if(a.getBoolean("MUC_NHUOM"))
            muc+="NHUOM ";
        if(a.getBoolean("MUC_NUOC"))
            muc+="NUOC ";
        if(a.getBoolean("MUC_BOT"))
            muc+="BOT ";
        if(a.getBoolean("MUC_DAU"))
            muc+="DAU ";
        if(a.getBoolean("MUC_DAC"))
            muc+="DAC ";
        this.setMuc(muc.trim());
        String giay="";
        if(a.getBoolean("GIAY_FORD"))
            giay+="FORD ";
        if(a.getBoolean("GIAY_COUCHE"))
            giay+="COUCHE ";
        if(a.getBoolean("GIAY_BRISTOL"))
            giay+="BRISTOL ";
        if(a.getBoolean("GIAY_DUPLEX"))
            giay+="DUPLEX ";
        if(a.getBoolean("GIAY_DECAL"))
            giay+="DECAL ";
        if(a.getBoolean("GIAY_KRAFT"))
            giay+="KRAFT ";
        if(a.getBoolean("GIAY_IVORNY"))
            giay+="IVORNY ";
        giay.replace(" "," Giấy ");
        this.setGiay(giay.trim());
        String ketnoi="";
        if(a.getBoolean("KETNOI_USBA"))
            ketnoi+="USBA ";
        if(a.getBoolean("KETNOI_USBB"))
            ketnoi+="USBB ";
        if(a.getBoolean("KETNOI_ENTERNET"))
            ketnoi+="ENTERNET ";
        if(a.getBoolean("KETNOI_WIRELESS"))
            ketnoi+="WIRELESS";
        this.setCong(ketnoi.trim());
        String hdh="";
        if(a.getBoolean("HDH_WIN"))
            hdh+="Windows ";
        if(a.getBoolean("HDH_IOS"))
            hdh+="iOS ";
        if(a.getBoolean("HDH_LINUX"))
            hdh+="Linux ";
        if(a.getBoolean("HDH_ANDROID"))
            hdh+="Android";
        this.setTuongthich(hdh.trim());
    }
    @Override
    public String toString() {
        return super.toString()+"#"+this.loaimayin+"#"+this.ppin+"#"+this.giay+"#"+this.muc+"#"+this.cong+"#"+this.tuongthich;
    };
   
}
