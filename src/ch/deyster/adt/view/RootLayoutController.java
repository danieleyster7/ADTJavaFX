package ch.deyster.adt.view;

import javafx.fxml.FXML;
import ch.deyster.adt.Main;

public class RootLayoutController 
{
	private Main main;
	
	public void setMainApp(Main main)
	{
		this.main = main;
	}
	
	@FXML
	public void handleClose()
	{
		System.exit(0);
	}
}
