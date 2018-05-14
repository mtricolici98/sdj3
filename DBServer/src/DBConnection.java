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
		String sql = "INSERT INTO facility.cars (vin, name, weight,timeadded) values (?,?,?,NOW())";
		
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
		String sql = "INSERT INTO facility.parts (partNumber, partType,weight,timeadded,instock) values (?,?,?,NOW(),true)";
		String sql1 = "Select a.* from facility.parts a "
				+ "INNER JOIN (SELECT regNumber, partnumber, MAX(timeadded) as last "
				+ "from facility.parts group by regnumber) b on "
				+ "a.partnumber = b.partnumber and "
				+ "a.timeadded = b.last and a.partnumber = ?";
		
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
	public long createNewPackage(String type) {
		ArrayList<Object[]> results;
		long regNo = 0;
		String sql = "INSERT INTO facility.package (type,timecreated) values (?,NOW())";
		String sql1 = "Select a.* from facility.package a "
				+ "INNER JOIN (SELECT packageid,type, MAX(timecreated) as last "
				+ "from facility.package group by packageid) b "
				+ "on a.packageid = b.packageid and "
				+ "a.timecreated = b.last and a.type = ?"
				+ "order by a.packageid asc";
		try {
			db.update(sql,type);
			results = db.query(sql1, type);
			if(results.size()==1) {
				regNo = Long.parseLong(results.get(0)[0].toString());
				
			} else if (results.size()>1){
				regNo = Long.parseLong(results.get(results.size()-1)[0].toString());
			}
			System.out.println("Part reg no is " + regNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("AddedPaletToDB");
		
		return regNo;
		
	}
	
	
	public String addToPackage(String partNo, String packageRegNo) {
		String sql = "Select * from facility.parts where partnumber = ? order by regnumber asc";
		String result = "ok";
		String regNo = "";
		double weight = 0;
		ArrayList<Object[]> results;
		try {
			results = db.query(sql, partNo);
			if(results.size()==0) {
				result = "noitem";
			} else if (results.size()>0) {
				regNo = results.get(0)[0].toString();
				weight = Double.parseDouble(results.get(0)[3].toString());
			}
			}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String palno = "";
		String sql1 = "INSERT INTO facility.package_part (packageid, partid) values (?,?)";
		ArrayList<Object[]> results1 = null;
		String sql2 =  " UPDATE facility.parts set instock= false where regnumber = ? ";
		String sql3 = "Select * from facility.part_palet a where a.partid = ? "; 
		String sql4 = "update facility.palet set weight = weight - ? where paletid= ? ";
			try {
				db.update(sql1, Long.parseLong(packageRegNo),Long.parseLong(regNo));
				db.update(sql2, Long.parseLong(regNo));
				results1 = db.query(sql3, Long.parseLong(regNo));
			
				if (results1.size()>0) {
				palno = results1.get(0)[0].toString();
				}
				db.update(sql4, weight,Long.parseLong(palno));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return result;
		
	}
	public String addToPackageByType(String type, int quantity, String packId) {
		String sql = "Select * from facility.parts where parttype=? and instock = true order by regnumber asc";
		String result = "ok";
		ArrayList<String> regNos= new ArrayList<String>();
		ArrayList<Object[]> results;
		try {
			results = db.query(sql, type);
			if(results.size()==0) {
				result = "noitems";
			} else if (results.size()>0) {
				if (results.size()>=quantity) {
					for(int l = 0;l<results.size() && l<quantity;l++) {
						regNos.add(results.get(l)[0].toString());
					}
					
				} else {
					result = "Not Enough Items, only " + results.size() + " items available";
				}
				
			}
			}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql1 = "INSERT INTO facility.package_part (packageid, partid) values (?,?)";
		
		String sql2 =  " UPDATE facility.parts set instock= false where regnumber = ? ";
		if(result.equals("ok")) { 
			for(int i=0; i<regNos.size();i++) {
				try {
					db.update(sql1, Long.parseLong(packId),Long.parseLong(regNos.get(i)));
					db.update(sql2, Long.parseLong(regNos.get(i)));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			result = "Added " + regNos.size() + " Items to Package";}
			
		return result;
		
	}
	
	public String getVehicleInfo(String vin){
		ArrayList<Object[]> results;
		ArrayList<Object[]> partsFromDB;
		ArrayList<Object[]> paletFromDB;
		ArrayList<Object[]> packageFromDB;
		String result = "";
		Car car = null;
		String sql = "select * from facility.cars where vin = ?";
		String sql1 = "select b.* from facility.car_part a, facility.parts b WHERE a.carvin = ? and a.regno = b.regnumber";
		String sql2 = "select c.* from facility.part_palet b , facility.palet c where  b.partid = ? and b.paletid = c.paletid";
		String sql3 = "select c.* from facility.package_part b , facility.package c where  b.partid = ? and b.packageid = c.packageid";
		try {
			results = db.query(sql, vin);
			result = "Car with vin: " + results.get(0)[0].toString() + " Name: " + results.get(0)[1].toString() + " Weight: " + results.get(0)[2].toString() + " Added on : " + results.get(0)[3].toString() +" \r\n"; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			try {
				partsFromDB = db.query(sql1, vin);
				for(int i = 0 ; i<partsFromDB.size(); i++) {
				paletFromDB=db.query(sql2, Long.parseLong(partsFromDB.get(i)[0].toString()));
				packageFromDB = db.query(sql3,Long.parseLong(partsFromDB.get(i)[0].toString()) );
				result += "Part Regno: "+ partsFromDB.get(i)[0].toString() + " with part no: " + partsFromDB.get(i)[1].toString() + " of type: " + partsFromDB.get(i)[2].toString() + " with weight: " +partsFromDB.get(i)[3].toString() + "kg, added on: " + partsFromDB.get(i)[4].toString() + " is in stock: " + partsFromDB.get(i)[5].toString() +"\r\n"; 
				if(paletFromDB!=null && paletFromDB.size()!=0) {
				result += "On Palet with id: " + paletFromDB.get(0)[0].toString() + "\n"; }
				if(packageFromDB!=null && packageFromDB.size()!=0) {
					result += "In package with id: " + packageFromDB.get(0)[0] + " created on: " + packageFromDB.get(0)[2].toString() + "\n";	
				}
				result +="\n";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return result;
		
	}
	

}
