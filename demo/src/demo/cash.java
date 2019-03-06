package demo;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.Component;
import org.bson.Document;
//import javax.swing.JPanel;

public class cash {

    JPanel panel = new JPanel();

    static int cash;

	public cash() {
		panel.setLayout((LayoutManager) new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Enter the amount you want to donate:");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);
        JTextField textField = new JTextField();
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(textField);
        JButton button = new JButton("Submit");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(button);

        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {  
                checkCash(textField.getText());
            } 
        });
	}
	
	public JPanel getPanel() {
		return panel;
	}

	public void checkCash(String quantity) {
		if (quantity.equals(null))
			JOptionPane.showMessageDialog(mgmt.frame, "Enter some amount!");
		else
			try {
			     cash = Integer.parseInt(quantity);
			     submit();
			     JOptionPane.showMessageDialog(mgmt.frame, "You tracking ID is: "+db.generatedString);
			     mgmt.frame.dispose();
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(mgmt.frame, "The value is not a number!");
			}
	}
	
	public static void submit() {
		db database = new db();
		Document seedData = new Document ("id", db.generatedString)
	            .append("type", "cash")
	            .append("amount", cash)
	            .append("status", "pending");
		database.insert(seedData);	
    }

}