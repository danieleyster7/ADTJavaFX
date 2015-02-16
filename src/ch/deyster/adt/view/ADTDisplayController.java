package ch.deyster.adt.view;

import java.util.Observable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ch.deyster.adt.Main;
import ch.deyster.adt.model.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.*;
public class ADTDisplayController
{
	@FXML
	private TableView<TestObject> listTable;
	
	@FXML
	private TableColumn<TestObject, String> indexColumn;
	
	@FXML
	private TableColumn<TestObject, String> valueColumn;
	
	private Main main;
	
	public ADTDisplayController() {
	}
	
	@FXML
	private void initialize() {
		indexColumn.setCellValueFactory(
				cellData -> cellData.getValue().indexProperty());
		valueColumn.setCellValueFactory(
				cellData -> cellData.getValue().valueProperty());
		
	}
	
	public void setMain(Main mainApp)
	{
		this.main = mainApp;
		
		listTable.setItems(mainApp.getData());
	}
	
	@FXML
	public void handleAdd()
	{
		
	}
	
	@FXML
	public void handleRemove()
	{
		
	}
	
	@FXML
	public void handleRemoveAny() {
		main.removeAny();
	}
	
	@FXML
	public void handleClear(){
		main.clearData();
	}
	
	@FXML
	public void handleFrequency()
	{
		
	}
	
	@FXML
	public void handleReplace()
	{
		
	}
}




















