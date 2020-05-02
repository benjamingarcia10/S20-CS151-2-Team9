package clinicalInformationSystem;
import javax.swing.JFrame;

import clinicalInformationSystem.controller.*;
import clinicalInformationSystem.view.*;

public class SystemTester
{
	
	public static void main(String args[])
	{
		SystemFrame frame = new SystemFrame();
		
		MenuController menuController = new MenuController(frame);
		
		frame.registerListeners(menuController);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setVisible(true);
	}
}