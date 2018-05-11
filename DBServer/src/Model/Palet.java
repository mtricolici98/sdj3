package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Palet implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = -3871097326414081199L;
private long id;
private String type;
private double weight;
private double maxWeight;
private ArrayList<Part> partList;


public Palet(long id, String type, double weight, double maxWeight) {
	this.id = id;
	this.type =type;
	this.weight = weight;
	this.maxWeight= maxWeight;
}

public long getId() {
	return id;
}


public String getType() {
	return type;
}


public double getWeight() {
	return weight;
}


public double getMaxWeight() {
	return maxWeight;
}


public ArrayList<Part> getPartList() {
	return partList;
}


public void addPart(Part part) {
	partList.add(part);
}
}
