package clinicalInformationSystem.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import clinicalInformationSystem.SpringUtilities;
import clinicalInformationSystem.THIScoreGrade;
import clinicalInformationSystem.model.PatientModel;

/**
 * Panel to allow user input for information about a visit to be added
 * @author Team 9
 *
 */
public class AddVisitPanel extends JPanel
{
	public static final String[] labelList = {"Patient Name", "Date (mm/dd/yyyy)", "Sequence Number"};
	private JTextField[] labelTextFields;
	private JButton addTHIAndTFI;
	private JButton exit;
	private String[] patientNames;
	private JComboBox<String> patientDropDown;
	
	/**
	 * Create a panel with form fields to enter about information of visit to be added
	 */
	public AddVisitPanel()
	{
		this.setLayout(new BorderLayout());
		//Create button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		addTHIAndTFI = new JButton("Add THI/TFI");
		exit = new JButton("Exit");
		buttonPanel.add(addTHIAndTFI);
		buttonPanel.add(exit);
		
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Set patient names to be displayed in drop down menu
	 * @param patientNames All patient names to be displayed
	 */
	public void setPatientNames(String[] patientNames)
	{
		this.patientNames = patientNames;
	}
	
	/**
	 * Add all elements in JPanel (call after patient names are set)
	 */
	public void displayPanel()
	{
		JPanel formPanel = new JPanel(new SpringLayout());
		labelTextFields = new JTextField[labelList.length];
		
		JLabel patientName = new JLabel(labelList[0], JLabel.TRAILING);
		formPanel.add(patientName);
		patientDropDown = new JComboBox<String>(patientNames);
		patientName.setLabelFor(patientDropDown);
		formPanel.add(patientDropDown);
		
		for (int i = 1; i < labelList.length; i++)
		{
			JLabel label = new JLabel(labelList[i], JLabel.TRAILING);
			formPanel.add(label);
			JTextField textField = new JTextField(20);
			label.setLabelFor(textField);
			formPanel.add(textField);
			labelTextFields[i] = textField;
		}
		
		SpringUtilities.makeCompactGrid(formPanel, 
				labelList.length, 2, 	// # of rows, # of columns
				5, 5,					// Initial x and y coordinates	
				5, 5);					// Padding between labels and textfield
		
		this.add(formPanel, BorderLayout.NORTH);
	}
	
	/**
	 * Add ActionListener on submit and exit buttons
	 * @param listener ActionListener to be added
	 */
	public void addVisitListener(ActionListener listener)
	{
		addTHIAndTFI.addActionListener(listener);
		exit.addActionListener(listener);
	}
	
	/**
	 * Get the patient selected
	 * @return Patient
	 */
	public String getPatient()
	{
		return (String) patientDropDown.getSelectedItem();
	}
	
	/**
	 * Get the date entered
	 * @return Date as String
	 */
	public String getDateText()
	{
		return labelTextFields[1].getText();
	}
	
	/**
	 * Get the sequence number entered
	 * @return Sequence number
	 */
	public String getSequenceNumberText()
	{
		return labelTextFields[2].getText();
	}
	
	/**
	 * Display error message on panel
	 * @param errorMessage Error message to be displayed
	 */
	public void displayErrorMessage(String errorMessage)
	{
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
