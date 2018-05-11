package Controller;

import java.rmi.RemoteException;

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



}
