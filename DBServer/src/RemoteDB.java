import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Model.Car;


public class RemoteDB extends UnicastRemoteObject implements iDBRequests {

	/**
	 * 
	 */
	
	private DBController controller;
	public RemoteDB() throws RemoteException {
	
		controller = new DBController();

}
	@Override
	public void addCarToDB(Car car){
		controller.addCarToDB(car);
		
	}

}
