
package deliveyapp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About extends JFrame{
    private JLabel info, infoAM, infoDevelopment, emp, emp1;
    public About(){
       super();
       info=new JLabel("Developer: Πέτρος Δεσπολλάρι", SwingConstants.CENTER);
       infoAM=new JLabel("AM: 18390189", SwingConstants.CENTER);
       infoDevelopment=new JLabel("24/5/2020 εως 31/5/2020", SwingConstants.CENTER);
       emp=new JLabel("                                                           ");
       emp1=new JLabel("                                                           ");
    };
    public void Info(){
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(info).setForeground(Color.RED);
        this.add(emp);
        this.add(infoAM).setForeground(Color.RED);
        this.add(emp1);
        this.add(infoDevelopment).setForeground(Color.RED);
        this.setSize(515, 350);
        this.setTitle("About");
        this.setVisible(true);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.BLACK);
        this.add(new JLabel(new ImageIcon("screen.png")));
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
    }
    
}