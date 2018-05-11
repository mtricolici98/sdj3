package Model;
import java.io.Serializable;
public class Car implements Serializable{

	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1163250894677419290L;
	private String vin;
	private double weight;
	private String name;
	
	
	public Car(String vin, double weight, String name) {
		this.vin =vin ;
		this.weight = weight;
		this.name = name;
		
	}
	public String getVin() {
		return vin;
	}


	public double getWeight() {
		return weight;
	}


	public String getName() {
		return name;
	}

	
}
