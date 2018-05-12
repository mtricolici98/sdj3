package common;


import java.rmi.Remote;
import java.rmi.RemoteException;
import Model.*;
public interface iBLRequests extends Remote {

	String addCarToDB(Car car) throws RemoteException;
	String addPartToPalet(Part part) throws RemoteException;
	
}
