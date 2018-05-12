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
	
	
	public void addNewPallet(String type, double maxWeight) {
		String sql = "INSERT INTO facility.palet (weight, maxWeight,PaletType) values (?,?,?)";
		try {
			db.update(sql,0,maxWeight,type);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("AddedPaletToDB");
	}
	
	
	public void addPartToDB(Part part,String paletID) {
		ArrayList<Object[]> results;
		long regNo = 0;
		String sql = "INSERT INTO facility.parts (partNumber, partType,weight,timeadded) values (?,?,?,NOW())";
		String sql1 = "Select a.* from facility.parts a INNER JOIN (SELECT regNumber, partnumber, MAX(timeadded) as last from facility.parts group by regnumber) b on a.partnumber = b.partnumber and a.timeadded = b.last and a.partnumber = ?";
		
		String sql2 = "INSERT INTO facility.part_palet (partid, paletid) values (?,?)";
		String sql3 = "Insert into facility.car_part (carvin,regno) values (?,?)" ;
		String sql4 = "update facility.palet set weight = weight + ? where paletid = ? ";
		try {
			db.update(sql,part.getPartNumber(),part.getType(),part.getWeight());
			results = db.query(sql1, part.getPartNumber());
			if(results.size()==1) {
				regNo = Long.parseLong(results.get(0)[0].toString());
				
			} else if (results.size()>1){
				regNo = Long.parseLong(results.get(results.size()-1)[0].toString());
			}
			System.out.println("Part reg no is " + regNo);
			db.update(sql2, regNo, Integer.parseInt(paletID));
			db.update(sql3, part.getCar(),regNo);
			db.update(sql4, part.getWeight(), Integer.parseInt(paletID));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("AddedPartToDB");
		
	}
	
	
	public ArrayList<Palet> findPalets(String type){
		ArrayList<Object[]> results;
		ArrayList<Palet> palets  = new ArrayList<Palet>();
		String sql = "SELECT * FROM facility.palet a where a.PaletType = ?";
		try {
			results = db.query(sql, type);
			for (int i=0;i<results.size();i++) {
				Object[] row = results.get(i);
				Palet tmp = new Palet(Long.parseLong(row[0].toString()),row[3].toString(),Double.parseDouble(row[1].toString()),Double.parseDouble(row[2].toString()));
				palets.add(tmp);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return palets;
	}
	

}
