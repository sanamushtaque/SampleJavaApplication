package demo;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.bson.Document;

import javax.swing.BoxLayout;
import java.awt.Component;

public class pckg {

    JPanel panel = new JPanel();


	public pckg() {
		
		panel.setLayout((LayoutManager) new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Enter the entity you want to donate:");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);
        String[] choices = { "Male Clothes","Female Clothes", "Sweaters","Blankets","Socks","Tents"};
        JComboBox<String> comboBox = new JComboBox<String>(choices);
        comboBox.setVisible(true);
        comboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(comboBox);
        JLabel label2 = new JLabel("Enter the quantity you want to donate:");
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label2);
        JTextField quantity = new JTextField();
        quantity.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(quantity);
        JButton button = new JButton("Submit");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(button);

        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) { 
                check(comboBox.getSelectedItem().toString().toLowerCase(), quantity.getText());
            } 
        });
		
	}
	
	/*public void checkEntity(String ent) {
		if (ent.equals(null))
			JOptionPane.showMessageDialog(mgmt.frame, "Please enter the entity");
		else
			////
	}*/
	
	public void check(String entity, String quantity) {
		if (quantity.equals(null))
			JOptionPane.showMessageDialog(mgmt.frame, "Enter both values");
		else
			try {
			    submit(entity,Integer.parseInt(quantity));
			    JOptionPane.showMessageDialog(mgmt.frame, "You tracking ID is: "+db.generatedString);
			    mgmt.frame.dispose();
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(mgmt.frame, "The value is not a number");
			}
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public void submit(String ent, int quant) {
		db database = new db();
		
		Document seedData = new Document ("id", db.generatedString)
	            .append("type", "care package")
	            .append("entity", ent)
	            .append("amount", quant)
	            .append("status", "pending");
		
		database.insert(seedData);
    }

}