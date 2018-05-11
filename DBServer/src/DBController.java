import Model.*;

public class DBController {
private DBConnection db;	
	
public DBController() {
	db = new DBConnection();
}


public void addCarToDB(Car car) {
	db.addCarToDB(car);
}
}
