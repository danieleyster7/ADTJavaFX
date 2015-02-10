package ch.deyster.adt;

import java.io.IOException;

import ch.deyster.adt.model.TestObject;
import ch.deyster.adt.view.ADTDisplayController;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application 
{
	private Stage primaryStage;
	private BorderPane rootLayout;
	
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
	
	public ObservableList<TestObject> getData()
	{
		return data;
	}
	
	public Main() {
		data.add(new TestObject(1));
		data.add(new TestObject(2));
		
	}

	public static void main(String[] args) 
	{
		launch(args);
	}
}