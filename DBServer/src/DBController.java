import java.util.ArrayList;

import Model.*;

public class DBController {
private DBConnection db;	
	
public DBController() {
	db = new DBConnection();
}


public void addCarToDB(Car car) {
	db.addCarToDB(car);
	
}


public void addPalletToDB(String type, double maxWeight) {
	db.addNewPallet(type, maxWeight);
}

public void addPartToDB(Part part, String PaletID) {
	db.addPartToDB(part, PaletID);
}

public ArrayList<Palet> findPalet(String type){
	return db.findPalets(type);
}
}
