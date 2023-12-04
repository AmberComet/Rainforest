package edu.washburn;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * For use in removing/viewing items.
 */

public class ProjectItemPanel extends JPanel {
	private JButton remove;
	private JLabel itemLabel;
	private JLabel triggerLabel;

	public ProjectItemPanel(String itemName, int triggerType) {
		JPanel mainPanel = new JPanel();
		add(mainPanel);
		mainPanel.setLayout(new GridLayout(1,1));
		
		remove = new JButton("Remove");
		itemLabel = new JLabel(" " + itemName);
		if (triggerType == 1) {
			triggerLabel = new JLabel("Notify On Trigger");
		} else {
			triggerLabel = new JLabel("Purchase On Trigger");
		}

		ActionHandler ah = new ActionHandler();
		remove.addActionListener(ah);

		mainPanel.add(remove);
		mainPanel.add(itemLabel);
		mainPanel.add(triggerLabel);
	}
	public class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == remove) {
				setDeleted();
			}
		}
	}

	public void setDeleted() {
		this.remove.setEnabled(false);
		this.itemLabel.setText("REMOVED");
	}
}
