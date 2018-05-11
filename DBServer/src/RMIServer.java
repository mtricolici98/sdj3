import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry;
import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject; 
import Model.*;

public class RMIServer extends DBConnection {

	public RMIServer()  throws ClassNotFoundException {
	
	}

	public static void main(String args[]) { 
	      try { 
	    	  LocateRegistry.createRegistry(1099);
	    	  iDBRequests remote = new RemoteDB();
	    	  Naming.rebind("DBServer", remote);
	    	  System.out.println("Tier 3 server listening on " + InetAddress.getLocalHost().getHostAddress());
	      } catch (Exception e) { 
	         System.err.println("Server exception: " + e.toString()); 
	         e.printStackTrace(); 
	      } 
	   } 
}
