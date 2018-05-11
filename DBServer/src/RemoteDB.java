import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Model.Car;
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

}
