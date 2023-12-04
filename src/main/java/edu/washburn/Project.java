import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project extends JFrame {
	private JLabel itemNameLabel;
	private JTextField itemNameField;
	private JComboBox<String> actionBox;
	private String[] actionBoxItems = {"Notify On Trigger", "Purchase On Trigger"};
	private JButton submitButton;
	private JButton exitButton;
	private JButton viewButton;
	private ProjectItemDialog dialog = null;
	private int itemCount = 10;
	

	public Project() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(3,1));
		add(mainPanel);

		JPanel namePanel = new JPanel();
		itemNameLabel = new JLabel("Item url: ");
		itemNameField = new JTextField(20);
		namePanel.add(itemNameLabel);
		namePanel.add(itemNameField);

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
			}

		}
	}

	public void submitItem() {
		/*
		 * Validate that the link is real; if not, display dialog saying so;
		 * submit it to the server application;
		 */
	}
	
	public void openItemDialog() {
		if(dialog==null) dialog=new ProjectItemDialog(Project.this, true, itemCount);
		dialog.setVisible(true);
	}

	public static void main(String [] args) {
		new Project();
	}
}
