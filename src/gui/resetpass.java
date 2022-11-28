package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import database.sever;
import moudel.user;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class resetpass extends JDialog {
	private JTextField txtUser;
	private JLabel login;
	menuframe a;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtcmnd;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public resetpass() {
		setResizable(false);
		setTitle("RESET");
		setBounds(100, 100, 451, 226);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(204, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Username :");
			lblNewLabel.setForeground(new Color(0, 255, 255));
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(85, 38, 109, 36);
			contentPanel.add(lblNewLabel);
		}
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUser.setBounds(204, 38, 181, 36);
		contentPanel.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblPassword = new JLabel("CMND :");
		lblPassword.setForeground(new Color(0, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(85, 92, 109, 36);
		contentPanel.add(lblPassword);
		
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
		        String username=txtUser.getText();
		        String cmnd=txtcmnd.getText();
		        user temp=new user(username,"1234");
		          try {
		        	 if(user.checkcmnd(username,cmnd))
		        	 	{
		        		 	user.resetpassword(username);
		        		 	JOptionPane.showMessageDialog(null, "Password được reset thành:1234");
		        		 	temp.checkcv();
		        	  		a=new menuframe(temp);
		        	  		a.setVisible(true);
		        	  		sever.disconect();
		        	  		dispose();
		        	 	}
		        	 else {
		        		 JOptionPane.showMessageDialog(null, "Username hoặc CMND nhập sai");
		        	 }
		          }
		          catch (SQLException e1) {
		          // TODO Auto-generated catch block
		          e1.printStackTrace();
		          }
		          
		          
		    }}});
		
		login.setHorizontalAlignment(SwingConstants.CENTER);
		login.setBounds(351, 153, 74, 23);
		contentPanel.add(login);
		
		JLabel lblReset = new JLabel("cancel");
		lblReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON1)
				{
					login a=new login();
					a.setVisible(true);
					dispose();
				}
			}
		});
		lblReset.setOpaque(true);
		lblReset.setHorizontalAlignment(SwingConstants.CENTER);
		lblReset.setBackground(new Color(240, 248, 255));
		lblReset.setBounds(267, 153, 74, 23);
		contentPanel.add(lblReset);
		
		txtcmnd = new JTextField();
		txtcmnd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtcmnd.setBounds(204, 92, 181, 36);
		contentPanel.add(txtcmnd);
		txtcmnd.setColumns(10);
		JLabel lblBackground = new JLabel("background");
		lblBackground.setBounds(0, 0, 435, 187);
		lblBackground.setIcon(background);
		contentPanel.add(lblBackground);
	}
}
