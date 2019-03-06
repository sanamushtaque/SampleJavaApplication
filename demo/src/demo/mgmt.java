package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import javax.swing.JTextArea;
//import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.Component;

public class mgmt
{
   private static final int FRAME_WIDTH = 400;
   private static final int FRAME_HEIGHT = 200;
   
   static JFrame frame;
   static JPanel panel;

    public static void mainPage() {
        panel =  new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("What do you want to donate?\n");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);
        JButton button1 = new JButton("CASH");
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(button1);
        JButton button2 = new JButton("CARE PACKAGE");
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(button2);
        JButton button3 = new JButton("View status of your donation");
        button3.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(button3);

        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) { 
                frame.remove(panel);
                //frame.setContentPane(cash.panel);
                frame.add(new cash().getPanel());
                frame.invalidate();
                frame.validate();
                
            } 
        });
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) { 
            	frame.remove(panel);
                //frame.setContentPane(cash.panel);
                frame.add(new pckg().getPanel());
                frame.invalidate();
                frame.validate();
            } 
        });
        button3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) { 
            	frame.remove(panel);
                //frame.setContentPane(cash.panel);
                frame.add(new track().getPanel());
                frame.invalidate();
                frame.validate();
            } 
        });
        
    }
    
    public static void main(String[] args)
    {
        frame = new JFrame();
        mainPage();
        frame.add(panel);

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        
    }
}