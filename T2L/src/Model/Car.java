package Model;
import java.io.Serializable;
public class Car implements Serializable{

	
	

	private String vin;
	private double weight;
	private String name;
	private String timeadded;
	
	public Car(String vin, double weight, String name) {
		this.vin =vin ;
		this.weight = weight;
		this.name = name;
		
	}
	
	public Car(String vin, double weight, String name, String timeadded) {
		this.vin =vin ;
		this.weight = weight;
		this.name = name;
		this.timeadded= timeadded;
	}
	public String getVin() {
		return vin;
	}

public String getTimeAdded() {
	return timeadded;
}
	public double getWeight() {
		return weight;
	}


	public String getName() {
		return name;
	}

	
}
