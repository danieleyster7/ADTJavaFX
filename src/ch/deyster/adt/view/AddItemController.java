package ch.deyster.adt.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ch.deyster.adt.Main;

public class AddItemController 
{
	@FXML
	private TextField value;
	@FXML
	private TextField index;
	private Main main;
	private Stage dialogStage;
	private boolean okClicked;
	
	public void setMain(Main main)
	{
		this.main = main;
	}
	
	public void setDialogStage(Stage dialogStage)
	{
		this.dialogStage = dialogStage;
	}
	
	@FXML
	public void handleOk()
	{
		//if both !null
		if(value.getText() != null && index.getText() != null)
		{
			main.add(Integer.parseInt(value.getText()), Integer.parseInt(index.getText()));
		}
		//if index null and value !null
		else if(value.getText() != null && index.getText() == null)
		{
			main.add(Integer.parseInt(value.getText()));
		}
		else
		{
			handleCancel();
		}
		dialogStage.close();
	}
	
	@FXML
	public void handleCancel()
	{
		dialogStage.close();
	}
	
	public boolean okClicked()
	{
		return okClicked;
	}
	
}
