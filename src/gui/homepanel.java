package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class homepanel extends JPanel {

    /**
     * Create the panel.
     */
    
    public homepanel() {
        setLayout(null);
        JPanel themhang = new JPanel();
        themhang.setBackground(new Color(204, 255, 255));
        themhang.setBounds(0, 0,1152, 642);
        themhang.setLayout(null);
        this.add(themhang);
         //background
        ImageIcon background=new ImageIcon("src\\gui\\icon\\bg.png");
        Image icon=background.getImage();
        Image newicon=icon.getScaledInstance(1280, 750, Image.SCALE_SMOOTH);
        background=new ImageIcon(newicon);
        
        JLabel lblNewLabel = new JLabel("Phần mềm quản lý \r\nkho máy in\r\n");
        lblNewLabel.setForeground(new Color(51, 255, 255));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
        lblNewLabel.setBounds(73, 253, 963, 122);
        themhang.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("MADE BY : Nhóm 14");
        lblNewLabel_1.setForeground(new Color(0, 255, 255));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
        lblNewLabel_1.setBounds(0, 589, 382, 53);
        themhang.add(lblNewLabel_1);
        JLabel lblbackground = new JLabel("New label");
        lblbackground.setBounds(0, 0, 1152, 642);
        themhang.add(lblbackground);
        lblbackground.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblbackground.setIcon(background);
    }

}
