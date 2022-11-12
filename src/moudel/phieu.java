package moudel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class phieu {
	String maphieu="";
	String user="";
	String ngay="";
	boolean loai;
	public String getMaphieu() {
		return maphieu;
	}
	public void setMaphieu(String maphieu) {
		this.maphieu = maphieu;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getNgay() {
		return ngay;
	}
	public void setNgay(String ngay) {
		this.ngay = ngay;
	}
	public boolean isLoai() {
		return loai;
	}
	public void setLoai(boolean loai) {
		this.loai = loai;
	}
	public phieu(String maphieu,String user,String ngay,boolean loai) {
		this.maphieu=maphieu;
		this.user=user;
		this.ngay=ngay;
		this.loai=loai;
	}
	public phieu() {
	}
	public void datatoobject(ResultSet a) throws SQLException
    {
		setMaphieu(a.getString("MAPHIEU"));
		setUser(a.getString("USERNAME"));
		setNgay(a.getString("NGAY"));
		setLoai(a.getBoolean("XUATNHAP"));
    }
}
