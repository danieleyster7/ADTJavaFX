package ch.deyster.adt;

import java.io.IOException;

import ch.deyster.adt.model.ArrayList;
import ch.deyster.adt.model.TestObject;
import ch.deyster.adt.view.ADTDisplayController;
import ch.deyster.adt.view.AddItemController;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application 
{
	private Stage primaryStage;
	private BorderPane rootLayout;
	private ArrayList<TestObject> adtList;
	private ObservableList<TestObject> data = FXCollections.observableArrayList();
	
	public void start(Stage primaryStage) 
	{
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("ADT Testing App");
		this.primaryStage.setResizable(false);
		
		initRootLayout();
		
		showADTDisplay();
	}
	
	public void initRootLayout()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showADTDisplay()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/adtDisplay.fxml"));
			AnchorPane adtDisplay = (AnchorPane) loader.load();
			
			rootLayout.setCenter(adtDisplay);
			
			//TODO: set controller
			ADTDisplayController controller = loader.getController();
			controller.setMain(this);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showAddItemDialog()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/AddItem.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Add Item");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			
			AddItemController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			
			controller.setMain(this);
			
			dialogStage.showAndWait();
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public ObservableList<TestObject> getData()
	{
		return data;
	}
	
	public Main() {
		adtList = new ArrayList<TestObject>();
		adtList.add(new TestObject(100));
		adtList.add(new TestObject(200));
		updateData();
	}
	
	private void updateData()
	{
		data.clear();
		for(int i = 0; i < adtList.getLength(); i++)
			data.add(adtList.get(i));
	}

	public static void main(String[] args) 
	{
		launch(args);
	}
	
	public void clearData()
	{
		adtList.clear();
		data.clear();
	}
	
	public void removeAny()
	{
		adtList.remove();
		updateData();
		
	}
	
	public void add(int value)
	{
		adtList.add(new TestObject(value));
		updateData();
	}
	
	public void add(int value, int index)
	{
		adtList.add(index, new TestObject(value));
		updateData();
	}
}