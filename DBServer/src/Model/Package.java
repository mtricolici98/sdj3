package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Package implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = -2804808967750470319L;


private long id;


private ArrayList<Palet> origin;
private ArrayList<Part> parts;
private String type;


public Package(ArrayList<Part> parts, ArrayList<Palet> origin, String type,long id) {
	this.parts = parts;
	this.origin = origin;
	this.type=type;
	this.id= id;
}

public long getId() {
	return id;
}


public ArrayList<Palet> getOrigin() {
	return origin;
}


public ArrayList<Part> getParts() {
	return parts;
}


public String getType() {
	return type;
}


}
