package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Model.*;
public interface iDBRequests extends Remote {

	void addCarToDB(Car car)  throws RemoteException; 
	void addPaletToDB(String type, double maxWeight) throws RemoteException;
	void addPartToDB(Part part, String paletID) throws RemoteException;
	ArrayList<Palet> findPalet(String type) throws RemoteException;
	long createNewPackage(String type) throws RemoteException;
	String addPartToPack(String partNo, String packNo) throws RemoteException;
	String addToPackageByType(String type, int quantity, String packId) throws RemoteException;
}
