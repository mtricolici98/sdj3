package Main;
import java.net.SocketTimeoutException;
import java.rmi.RemoteException;
import java.util.Scanner;
import Model.*;
import RMIClient.*;
public class S1Client {
	
	public static void main(String[] args) {
		boolean running = true;
		Scanner input = new Scanner(System.in);
		int result ;
		while(running) {
			System.out.println("Choose option:");
			System.out.println("1 to add a vehicle");
			System.out.println("0 to exit");
			result = input.nextInt();
			switch(result){
			case 1 : { 
				Car tmp ;
				System.out.println("Insert VIN Code");
				input.nextLine();
				String vin = input.nextLine();
				System.out.println("Insert Name and model ");
				String name = input.nextLine();
				System.out.println("Insert wight ");
				double weight = input.nextDouble();
				tmp = new Car(vin,weight,name);
				input.nextLine();
				System.out.println("press y to confirm add");
				if(input.nextLine().equals("y")) {
					try {
						RMIClient.getInstance().getRemoteServer().addCarToDB(tmp);
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} 
			}
			break;
			
			case 0: { 
				running = false;
			}
			break;
			
			default : {running = false;
			System.out.println("Exiting program");}
			break;
			}
			}
			
			
			
		}
		
}


	


