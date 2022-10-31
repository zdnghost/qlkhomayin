package moudel;
public class sanpham
{
    public String masp="";
    public String tensp="";
    public int sl=0;
    sanpham(){}
    sanpham(String masp,String tensp,int sl){
        this.masp=masp;
        this.tensp=tensp;
        this.sl=sl;
    }
    //set
    public void setMasp(String masp) {
        this.masp = masp;
    }
    public void setTensp(String tensp) {
        this.tensp = tensp;
    }
    public void setSl(int sl) {
        this.sl = sl;
    }
    //get
    public String getMasp() {
        return masp;
    }
    public String getTensp() {
        return tensp;
    }
    public int getSl() {
        return sl;
    }
    public String toString() {
        return this.masp+"#"+this.tensp+"#"+this.sl;
    };
    
}