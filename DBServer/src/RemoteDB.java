import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Model.Car;
import Model.Palet;
import Model.Part;
import common.iDBRequests;


public class RemoteDB extends UnicastRemoteObject implements iDBRequests {

	/**
	 * 
	 */
	
	private DBController controller;
	public RemoteDB() throws RemoteException {
		super();
		controller = new DBController();

}
	@Override
	public void addCarToDB(Car car){
		controller.addCarToDB(car);
		
	}
	@Override
	public void addPaletToDB(String type, double maxWeight) throws RemoteException {
		controller.addPalletToDB(type, maxWeight);
		
	}
	@Override
	public void addPartToDB(Part part, String paletID) {
	controller.addPartToDB(part, paletID);
		
	}
	@Override
	public ArrayList<Palet> findPalet(String type) throws RemoteException {
		
		return controller.findPalet(type);
	}

}
