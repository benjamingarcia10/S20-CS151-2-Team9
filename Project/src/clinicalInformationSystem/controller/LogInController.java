package clinicalInformationSystem.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clinicalInformationSystem.model.AuthorizedUsers;
import clinicalInformationSystem.view.LogInPanel;
import clinicalInformationSystem.view.SystemFrame;

public class LogInController
{
	private SystemFrame frame;
	private AuthorizedUsers users;
	private LogInPanel logInPanel;
	
	public LogInController(SystemFrame frame, AuthorizedUsers users, LogInPanel logInPanel)
	{
		this.frame = frame;
		this.users = users;
		this.logInPanel = logInPanel;
		this.logInPanel.addLogInListener(new LogInListener());
	}
	
	private class LogInListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			if(command.equals("Log In"))
			{
				String username = "";
				String password = "";
				if(logInPanel.getUsername() != "" && logInPanel.getPassword() != "")
				{
					username = logInPanel.getUsername();
					password = logInPanel.getPassword();
				} else
					logInPanel.displayErrorMessage("Please fill in all fields.");
				if(users.isAuthorized(username, password))
				{
					frame.setAuthorized(true);
					frame.remove(logInPanel);
					frame.setSize(600, 400);;
				}
				else
					logInPanel.displayErrorMessage("Invalid User.");
			}
		}
		
	}
}