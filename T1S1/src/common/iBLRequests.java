package common;


import java.rmi.Remote;
import java.rmi.RemoteException;
import Model.*;
public interface iBLRequests extends Remote {

	void addCarToDB(Car car) throws RemoteException;
	void addPartToPalet(Part part) throws RemoteException;
	
}
