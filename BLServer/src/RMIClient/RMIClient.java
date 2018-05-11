package RMIClient;

import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;

import javax.swing.JOptionPane;


import Model.*;
public class RMIClient {
	public static void main(String[] args) {
		try {
		
		String ip = "10.10.20.216";
		String rmiName = "rmi://"+ip+"/DBServer";
		
			iDBRequests dataRemote = (iDBRequests)Naming.lookup(rmiName);
			
			System.out.println("Connection Established");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
