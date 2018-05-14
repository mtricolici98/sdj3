package RMIClient;


import common.*;

import java.io.Serializable;
import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;

import Model.*;

public class RMIClient implements Serializable {
	private static final long serialVersionUID = 1L;
	private iDBRequests server;
	private static final RMIClient INSTANCE = new RMIClient();

	private RMIClient() {

		try {

			server = (iDBRequests) Naming.lookup("rmi://localhost:1099/t3server");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static RMIClient getInstance() {
		return INSTANCE;
	}

	public iDBRequests getRemoteServer() {
		return server;
	}
}
