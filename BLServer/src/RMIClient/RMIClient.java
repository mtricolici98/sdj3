package RMIClient;

import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;



import Model.*;
public class RMIClient {
	public static void main(String[] args) {
		try {
			
		String ip = "10.10.20.216";
		//System.out.println(System.getProperty("java.security.policy"));
	//	System.out.println(InetAddress.getLocalHost().getHostAddress());
		String rmiName = "rmi://"+ip+"/t3server";
		
			iDBRequests dataRemote = (iDBRequests)Naming.lookup(rmiName);
			
			System.out.println("Connection Established");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
