package Controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Model.*;
import RMI.RMIClient;

public class T2Controller {

public T2Controller() {

}



public void addCarToDb(Car car) {
	try {
		RMIClient.getInstance().getRemoteServer().addCarToDB(car);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


public ArrayList<Palet> findPallet(String type) {
	ArrayList<Palet> palets = null;
	try {
		palets = RMIClient.getInstance().getRemoteServer().findPalet(type);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return palets;
}

public void addPartToDb(Part part, String palID) {
	try {
		RMIClient.getInstance().getRemoteServer().addPartToDB(part, palID);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void addPaletToDB(String type, double MaxWeight) {
	try {
		RMIClient.getInstance().getRemoteServer().addPaletToDB(type, MaxWeight);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public long createNewPackage(String type) {
	long packid = 0;
	try {
		packid = RMIClient.getInstance().getRemoteServer().createNewPackage(type);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return packid;
}


public String addPartToPack(String partNo, String packNo) {
	String result = "";
	try {
		result = RMIClient.getInstance().getRemoteServer().addPartToPack(partNo, packNo);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Packing reuslt is" + result);
	return result;
}
}
