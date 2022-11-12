package gui;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.sever;
import moudel.user;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JLabel login;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			login dialog = new login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean check(String u,String p) throws SQLException {
	    String Sql="select * from USERDB";
	    ResultSet rs=sever.getquery(Sql);
	    boolean c=false;
	    while(rs.next())
	    {
	        if((rs.getString("USERNAME").trim().equals(u)))
	        {
	            if(rs.getString("PASSWORD").trim().equals(p))
	            {
	                c=true;
	                break;
	            }
	            else
	            {
	                break;
	            }
	            
	        }
	    }
        return c;
	}
	public boolean isadmin(String u)throws SQLException {
        String Sql="select * from USERDB";
        ResultSet rs=sever.getquery(Sql);
        int c;
        while(rs.next())
        {
            if((rs.getString("USERNAME").trim().equals(u)))
            {
                if(rs.getInt("CHUCVU")==3)
                break ;
                else return true;
            }
        }
        return false;
    }

	/**
	 * Create the dialog.
	 */
	public login() {
	    setResizable(false);
		setTitle("LOGIN");
		setBounds(100, 100, 451, 226);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(204, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Username");
			lblNewLabel.setForeground(new Color(0, 255, 255));
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(85, 38, 90, 36);
			contentPanel.add(lblNewLabel);
		}
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUser.setBounds(185, 39, 181, 36);
		contentPanel.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(85, 92, 90, 36);
		contentPanel.add(lblPassword);
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPass.setBounds(185, 93, 181, 36);
		contentPanel.add(txtPass);
		
		ImageIcon loginicon	=new ImageIcon("src\\gui\\icon\\login.png");
		Image icon=loginicon.getImage();
		Image newicon=icon.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		loginicon=new ImageIcon(newicon);
		JLabel lblicon = new JLabel("icon login");
		lblicon.setIcon(loginicon);
		lblicon.setBounds(10, 38, 90, 90);
		contentPanel.add(lblicon);
		
		ImageIcon background=new ImageIcon("src\\gui\\icon\\bg.png");
		icon=background.getImage();
		newicon=icon.getScaledInstance(451, 226, Image.SCALE_SMOOTH);
		background=new ImageIcon(newicon);
		
        
		login = new JLabel("login");
		login.setOpaque(true);
		login.setBackground(new Color(240, 248, 255));
		login.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {if(e.getButton()==MouseEvent.BUTTON1){
		        login.setBackground(new Color(220, 228, 235));
		        user temp=new user();
		        String username=txtUser.getText();
		          String password=new String(txtPass.getPassword());
		          try {
		          if(check(username,password))
		          {
		          boolean admin=isadmin(username);
		          menuframe.user=username;
		          menuframe a=new menuframe(username,admin);
		          a.setVisible(true);
		          sever.disconect();
		          dispose();
		          }
		          else {
		          System.out.println("opp, wrong");
		          }
		          } catch (SQLException e1) {
		          // TODO Auto-generated catch block
		          e1.printStackTrace();
		          }
		          
		          
		    }}
			@Override
			public void mouseReleased(MouseEvent e) {
				login.setBackground(new Color(240, 248, 255));
			}
		});
		
		login.setHorizontalAlignment(SwingConstants.CENTER);
		login.setBounds(351, 153, 74, 23);
		contentPanel.add(login);
		JLabel lblBackground = new JLabel("background");
		lblBackground.setBounds(0, 0, 435, 187);
		lblBackground.setIcon(background);
		contentPanel.add(lblBackground);
	}
}
