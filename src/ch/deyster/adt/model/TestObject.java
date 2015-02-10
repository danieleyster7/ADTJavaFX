package ch.deyster.adt.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TestObject 
{
	private int value;
	private final StringProperty valueProperty;
	private final StringProperty indexProperty;
	private static int count = 0;
	
	public TestObject(int value)
	{
		count++;
		this.value = value;
		valueProperty = new SimpleStringProperty(Integer.toString(value));
		this.indexProperty = new SimpleStringProperty(Integer.toString(count));
	}
	
	public StringProperty valueProperty()
	{
		return valueProperty;
	}
	
	public StringProperty indexProperty()
	{
		return indexProperty;
	}
	
	public boolean equals(TestObject t)
	{
		return (value == t.getValue());
	}
	
	public int getValue()
	{
		return value;
	}
	
	public void setValue(int value)
	{
		this.value = value;
		valueProperty.set(Integer.toString(value));
	}
}
