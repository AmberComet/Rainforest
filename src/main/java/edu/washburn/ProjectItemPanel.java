package edu.washburn;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * For use in removing/viewing items.
 */

public class ProjectItemPanel extends JPanel {
	private JButton remove;
	private JTextField itemName;
	private JTextField basePrice;
	private JTextField goalPrice;
	private JComboBox<String> triggerType;
	private String[] actionBoxItems = {"Notify On Trigger", "Purchase On Trigger"};

	public ProjectItemPanel(Item item) {
		Double base = item.getBaseprice();
		Double goal = item.getGoalPrice();
		boolean notif = item.isNotify();
		String name = item.getItemName();

		JPanel mainPanel = new JPanel();
		add(mainPanel);
		mainPanel.setLayout(new GridLayout(1,4));
		
		JPanel p1 = new JPanel();
		remove = new JButton("Remove");
		itemName = new JTextField(10);
		itemName.setText(name);

		basePrice = new JTextField(5);
		basePrice.setText(base.toString());

		goalPrice = new JTextField(5);
		goalPrice.setText(goal.toString());

		triggerType = new JComboBox<String>();
		for (int i=0; i<actionBoxItems.length; i++) {
			triggerType.addItem(actionBoxItems[i]);
		}
		if (notif) {
			triggerType.setSelectedIndex(0);
		} else {
			triggerType.setSelectedIndex(1);
		}


		ActionHandler ah = new ActionHandler();
		remove.addActionListener(ah);

		p1.add(remove);
		p1.add(itemName);
		p1.add(goalPrice);
		p1.add(triggerType);
		mainPanel.add(p1);
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
		this.triggerType.setEnabled(false);
		this.itemName.setEnabled(false);
		this.goalPrice.setEnabled(false);
		this.itemName.setText("REMOVED");
		//TODO remove the item from database
	}
}
