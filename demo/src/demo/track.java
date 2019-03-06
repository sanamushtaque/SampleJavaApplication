package demo;

import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import org.bson.Document;

public class track {
	
	JPanel panel = new JPanel();

	public track() {
		
		panel.setLayout((LayoutManager) new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Enter your tracking number:");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);
        JTextField trackingNo = new JTextField();
        trackingNo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(trackingNo);
        JButton button = new JButton("Submit");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(button);

        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {  
                check(trackingNo.getText());
            } 
        });
	}
	
	public void check(String trackingNo) {
		if (trackingNo.equals(null))
			JOptionPane.showMessageDialog(mgmt.frame, "Enter a tracking number");
		else {
			String status = new db().fetch(trackingNo);
			JOptionPane.showMessageDialog(mgmt.frame, "Your donation is "+status);
		}
	}
	
	public JPanel getPanel() {
		return panel;
	}
}
