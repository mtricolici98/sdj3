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
	private static final long serialVersionUID = 1L;
	private T2Controller controller;
	protected RemoteServer() throws RemoteException {
		super();
		controller =  new T2Controller();
	}

	
	

	@Override
	public void addCarToDB(Car car) throws RemoteException {
		controller.addCarToDb(car);
		
	}

	@Override
	public void addPartToPalet(Part part) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Adding Part to pallet");
	}

}
