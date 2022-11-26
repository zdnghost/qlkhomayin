package moudel;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.sever;

public class user {
	public String username="";
	public String password="";
	public String chucvu="";
	public user(String username,String password,String chucvu) {
		this.username=username;
		this.password=password;
		this.chucvu=chucvu;
	}
	public user(String username,String password) {
		this.username=username;
		this.password=password;
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
	
	public static void main(String []args) {
		user n=new user("tuan","00000000");
		n.checkcv();
		System.out.println("1234\023");
	}
}
