package database;


import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class sever {
    public static Connection con;
    public static ResultSet getquery(String Sql) throws SQLException
    {
            con = DriverManager.getConnection("jdbc:sqlserver://ZDNGHOST2\\SQLEXPRESS;databaseName=QLKMI","qlmayin","23122003");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Sql);
            return rs;
    }
    public static void update(String sql)
    {
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://ZDNGHOST2\\SQLEXPRESS;databaseName=QLKMI","qlmayin","23122003");
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        gui.chinhsua.manegerpanel.key="";
    }
    public static void disconect() throws SQLException
    {
        if(con!=null)
        con.close();
    }
}
