package Main;


import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import Model.Car;
import RMI.RMIClient;
import common.*;
public class Tier2Main {
public static void main(String[] args) {
//	try {
//		RMIClient.getInstance().getRemoteServer().addCarToDB(new Car("12939891124",1299,"UU"));
//	} catch (RemoteException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
	try { 
  	 //LocateRegistry.createRegistry(1099);
  	  iBLRequests remote = new RemoteServer();
  	  Naming.rebind("t2server", remote);
  
  	  System.out.println("Tier 2 server listening on " + InetAddress.getLocalHost().getHostAddress());
    } catch (Exception e) { 
       System.err.println("Server exception: " + e.toString()); 
       e.printStackTrace(); 
    } 
}
}
