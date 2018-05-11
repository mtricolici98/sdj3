import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Model.Car;


public class RemoteDB extends UnicastRemoteObject implements iDBRequests {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3678040459231005954L;
	private DBController controller;
	public RemoteDB() throws RemoteException {
	
		controller = new DBController();

}
	@Override
	public void addCarToDB(Car car) throws RemoteException {
		controller.addCarToDB(car);
		
	}

}
