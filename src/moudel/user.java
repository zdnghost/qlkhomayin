package moudel;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.sever;

public class user {
	public String username="";
	public String password="";
	public String chucvu="";
	public String hoten="";
	public String cmnd="";
	public user(String username,String password,String chucvu,String hoten,String cmnd) {
		this.username=username;
		this.password=password;
		this.chucvu=chucvu;
		this.hoten=hoten;
		this.cmnd=cmnd;
	}
	public user(String username,String password) {
		this.username=username;
		this.password=password;
	}
	public user() {
		// TODO Auto-generated constructor stub
	}
	public boolean checktk() {
		try {
			String sql="select * from USERDB";
			ResultSet e=sever.getquery(sql);
			while(e.next()) {
				if(this.username.equals(e.getString("USERNAME").trim())&&this.password.equals(e.getString("PASSWORD").trim()))
				{	
					return true;
				}
			}
			return false;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}
	
	public static boolean check(String user){
		try {
			String sql="select * from USERDB where USERNAME='"+user+"'";
			ResultSet e=sever.getquery(sql);
			while(e.next()) {
				if(user.equals(e.getString("USERNAME").trim()))
					return false;
			}
			return true;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return true;
		}
		
	}
	public static void resetpassword(String user)
	{
			String sql="update USERDB set PASSWORD='1234' where USERNAME='"+user+"'";
			sever.update(sql);
	}
	public static boolean checkcmnd(String user,String cmnd){
		try {
			String sql="select * from USERDB where USERNAME='"+user+"'";
			ResultSet e=sever.getquery(sql);
			while(e.next()) {
				if(user.equals(e.getString("USERNAME").trim())&&cmnd.equals(e.getString("CMND")))
					return true;
			}
			return false;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		
	}
	public void datatoobject(ResultSet data) {
		try {
			this.username=data.getString("USERNAME").trim();
			this.password=data.getString("PASSWORD").trim();
			this.chucvu=data.getString("TENCV").trim();
			this.cmnd=data.getString("CMND").trim();
			this.hoten=data.getString("HOTEN").trim();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void checkcv() {
		try {
			String sql="select * from USERDB,CHUCVU where USERDB.CHUCVU=CHUCVU.CHUCVU and USERNAME='"+this.username+"'";
			ResultSet e=sever.getquery(sql);
			while(e.next()) {
				this.chucvu=e.getString("TENCV");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
