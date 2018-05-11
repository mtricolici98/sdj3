import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import Model.*;

public class DBConnection {
	private MyDatabase db;
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/DismantlingFacility";
	private static final String USER = "postgres";
	private static final String PASSWORD = "root";

	public DBConnection() {
		try {
			this.db = new MyDatabase(DRIVER, URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addCarToDB(Car car)  {
		String sql = "INSERT INTO facility.cars (vin, name, weight) values (?,?,?)";
		
		try {
			db.update(sql,car.getVin(),car.getName(),car.getWeight());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("AddedCarToDB");
	}
	

}
