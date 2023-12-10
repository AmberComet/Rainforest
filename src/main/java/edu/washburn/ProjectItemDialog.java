package edu.washburn;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ProjectItemDialog extends JDialog {
	private JButton closeButton;
	private ProjectItemPanel[] panels;

	public ProjectItemDialog(JFrame parent, Boolean modal, Item[] items) {
		super(parent,modal);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(items.length+1,1));
		add(mainPanel);

		JPanel footer = new JPanel();
		closeButton = new JButton("Close");
		footer.add(closeButton);

		panels = new ProjectItemPanel[items.length];
		//returnedItems = getItems();
		for (int i=0; i<items.length; i++) {
			panels[i] = getPanelItemInfo(items[i]);
			mainPanel.add(panels[i]);
		}
		mainPanel.add(footer);

		ActionHandler ah = new ActionHandler();
		closeButton.addActionListener(ah);

		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setSize(500,50+50*items.length);
		setVisible(false);
	}
	public class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == closeButton) {
				ProjectItemDialog.this.setVisible(false);
			}
		}
	}

	/*
	 * Get info from the server and put in object
	 */
	public ProjectItemPanel getPanelItemInfo(Item itm) {
		ProjectItemPanel i = new ProjectItemPanel(itm);
		return i;
	}

}
