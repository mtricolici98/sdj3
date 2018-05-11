package Model;

import java.io.Serializable;

public class Part implements Serializable{



private String type;
private Car car;
private long partNumber;
private long regNumber;
private double weight;


public Part(String type, Car car, long partNo, long regNo, double weight) {
	this.type = type;
	this.car =car;
	partNumber = partNo;
	regNumber = regNo;
	this.weight = weight;
	
}

public String getType() {
	return type;
}


public Car getCar() {
	return car;
}


public long getPartNumber() {
	return partNumber;
}


public long getRegNumber() {
	return regNumber;
}


public double getWeight() {
	return weight;
}

}
