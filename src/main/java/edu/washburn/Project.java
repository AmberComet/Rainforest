package edu.washburn;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project extends JFrame {
	private JLabel itemNameLabel;
	private JTextField itemNameField;
	private JLabel itemCostLabel;
	private JTextField itemCostField;
	private JComboBox<String> actionBox;
	private String[] actionBoxItems = {"Notify On Trigger", "Purchase On Trigger"};
	private JButton submitButton;
	private JButton exitButton;
	private JButton viewButton;
	private ProjectItemDialog dialog = null;
	

	public Project() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(4,1));
		add(mainPanel);

		JPanel namePanel = new JPanel();
		itemNameLabel = new JLabel("Item url: ");
		itemNameField = new JTextField(20);
		namePanel.add(itemNameLabel);
		namePanel.add(itemNameField);

		JPanel costPanel = new JPanel();
		itemCostLabel = new JLabel("Desired price: ");
		itemCostField = new JTextField(20);
		costPanel.add(itemCostLabel);
		costPanel.add(itemCostField);


		JPanel actionPanel = new JPanel();
		submitButton = new JButton("Submit");
		actionBox = new JComboBox<String>();
		for (int i=0; i<actionBoxItems.length; i++) {
			actionBox.addItem(actionBoxItems[i]);
		}
		actionPanel.add(submitButton);
		actionPanel.add(actionBox);


		JPanel buttonPanel = new JPanel();
		exitButton = new JButton("Exit");
		viewButton = new JButton("View Items");
		buttonPanel.add(viewButton);
		buttonPanel.add(exitButton);

		mainPanel.add(namePanel);
		mainPanel.add(costPanel);
		mainPanel.add(actionPanel);
		mainPanel.add(buttonPanel);
		
		ActionHandler ah = new ActionHandler();
		exitButton.addActionListener(ah);
		viewButton.addActionListener(ah);
		submitButton.addActionListener(ah);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,250);
		setVisible(true);

	}

	public class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == exitButton) {
				      System.exit(0);
			} else if (e.getSource() == viewButton) {
				openItemDialog();
			} else if (e.getSource() == submitButton) {
				submitItem();
			}

		}
	}

	public void submitItem() {
		/*
		 * Validate that the link is real; if not, display dialog saying so;
		 * submit it to the server application;
		 */
		
		boolean isPercent = itemCostField.getText().startsWith("%");
		boolean notify = (actionBox.getSelectedIndex() > 0) ? false : true;
		Double dPrice = Double.parseDouble(itemCostField.getText().replaceAll("\\D", ""));
		Item itm = new Item(itemNameField.getText(),notify, isPercent, dPrice);
		//TODO send item to server
	}
	
	public void openItemDialog() {
		//Item[] itemsList = new Item[getItemCount()];
		Item[] itemsList = new Item[1];
		Item m = new Item("https://www.google.com", false, false, 45.0);
		itemsList[0] = m;
		if(dialog==null) dialog=new ProjectItemDialog(Project.this, true, itemsList);
		dialog.setVisible(true);
	}

	public static void main(String [] args) {
		new Project();
	}
}
