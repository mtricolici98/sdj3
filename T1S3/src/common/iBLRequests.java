package common;


import java.rmi.Remote;
import java.rmi.RemoteException;
import Model.*;
public interface iBLRequests extends Remote {

	String addCarToDB(Car car) throws RemoteException;
	String addPartToPalet(Part part) throws RemoteException;
	long creteNewPackage(String type) throws RemoteException;
	String addPartToPack(String partNo,String packNo) throws RemoteException;
	String addToPackageByType(String type, int quantity, String packId) throws RemoteException;
}
