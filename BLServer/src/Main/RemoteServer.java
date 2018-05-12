package Main;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Model.*;
import Controller.*;
import common.*;
public class RemoteServer extends UnicastRemoteObject implements iBLRequests{
	/**
	 * 
	 */
	private Checker check ;
	private static final long serialVersionUID = 1L;
	private T2Controller controller;
	protected RemoteServer() throws RemoteException {
		super();
		controller =  new T2Controller();
		check = new Checker();
	}

	
	

	@Override
	public String addCarToDB(Car car) throws RemoteException {
		controller.addCarToDb(car);
		return "Car Successfully added to db"; 
		
	}

	@Override
	public String addPartToPalet(Part part) throws RemoteException {
		String palid = check.findSuitablePallet(controller.findPallet(part.getType()), part);
		if(palid.equals("nopal")) {
			controller.addPaletToDB(part.getType(), 2000);
			palid = check.findSuitablePallet(controller.findPallet(part.getType()), part);
			controller.addPartToDb(part, palid);
		} else {
		controller.addPartToDb(part, palid);}
		System.out.println("Adding Part to pallet");
		return "Part Successfully added to Palet";
	}




	@Override
	public long creteNewPackage(String type) throws RemoteException {
		
		return controller.createNewPackage(type);
	}




	@Override
	public String addPartToPack(String partNo, String packNo) throws RemoteException {
		
		return controller.addPartToPack(partNo, packNo);
	}

}
