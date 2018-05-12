package Model;

import java.io.Serializable;

public class Part implements Serializable{



private String type;
private String car;
private String partNumber;
private long regNumber;
private double weight;


public Part(String type, String car, String partNo, long regNo, double weight) {
	this.type = type;
	this.car =car;
	partNumber = partNo;
	regNumber = regNo;
	this.weight = weight;
	
}

public Part(String type, String car, String partNo, double weight) {
	this.type = type;
	this.car =car;
	partNumber = partNo;
	this.weight = weight;
	
}

public String getType() {
	return type;
}


public String getCar() {
	return car;
}


public String getPartNumber() {
	return partNumber;
}


public long getRegNumber() {
	return regNumber;
}


public double getWeight() {
	return weight;
}

}
