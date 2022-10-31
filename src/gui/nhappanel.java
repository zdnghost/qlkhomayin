package gui;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JSplitPane;
import javax.swing.JComboBox;
import java.awt.Choice;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import java.awt.Canvas;

public class nhappanel extends JPanel {

    /**
     * Create the panel.
     */
    public nhappanel() {
        setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1154, 643);
        add(panel);
        panel.setLayout(null);
        
        JToolBar toolBar = new JToolBar();
        toolBar.setBounds(115, 286, 87, 16);
        panel.add(toolBar);
        
        JSplitPane splitPane = new JSplitPane();
        splitPane.setBounds(542, 220, 245, 82);
        panel.add(splitPane);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(335, 423, 30, 22);
        panel.add(comboBox);
        
        Choice choice = new Choice();
        choice.setBounds(264, 137, 28, 20);
        panel.add(choice);
        
        JProgressBar progressBar = new JProgressBar();
        progressBar.setBounds(207, 365, 146, 14);
        panel.add(progressBar);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(396, 220, 46, 33);
        panel.add(separator);
        
        Canvas canvas = new Canvas();
        canvas.setBounds(650, 410, 100, 100);
        panel.add(canvas);

    }
}
