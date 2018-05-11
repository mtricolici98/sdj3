package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import Model.*;


public interface iDBRequests extends Remote {

	void addCarToDB(Car car)  throws RemoteException; 
	
}
