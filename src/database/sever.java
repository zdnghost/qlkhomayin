package database;


import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
public class sever {
    public static Connection con;
    public static ResultSet getquery(String Sql)
    {
            try {
				con = DriverManager.getConnection("jdbc:sqlserver://ZDNGHOST2\\SQLEXPRESS:1433;databaseName=QLKMI","qlmayin","23122003");
				Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(Sql);
	            return rs;
            } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
            
    }
    public static boolean update(String sql)
    {
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://ZDNGHOST2\\SQLEXPRESS:1433;databaseName=QLKMI","qlmayin","23122003");
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
        	JOptionPane.showMessageDialog(null,"Cập nhật dữ liệu thất bại");
        	return false;
        }
    }
    public static void disconect() throws SQLException
    {
        if(con!=null)
        con.close();
    }	
}
