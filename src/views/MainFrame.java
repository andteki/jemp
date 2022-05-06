package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MainFrame extends JFrame {

    JPanel mainPanel;
    public JButton goButton;
    public JScrollPane pane1;
    public JTable employeeTable;

    public MainFrame() {
        this.setComponent();
        this.setMainPanel();
        this.setFrame();
    }
   
    public void setComponent() {
        this.goButton = new JButton("Mehet");
       
        this.employeeTable = new JTable();
        this.pane1 = new JScrollPane(employeeTable);
        
        
    }

    public void setMainPanel() {
        this.mainPanel = new JPanel();
        this.mainPanel.setLayout(new BorderLayout());
        this.mainPanel.add(this.pane1, BorderLayout.CENTER);
        this.mainPanel.add(this.goButton, BorderLayout.SOUTH);
        
    }

    public void setFrame() {
        this.setLayout(new FlowLayout());
        this.add(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setVisible(true);
    }
    
}
