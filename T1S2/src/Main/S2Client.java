package Main;
import java.net.SocketTimeoutException;
import java.rmi.RemoteException;
import java.util.Scanner;
import Model.*;
import RMIClient.*;
public class S2Client {
	
	public static void main(String[] args) {
		boolean running = true;
		Scanner input = new Scanner(System.in);
		int result ;
		while(running) {
			System.out.println("Choose option:");
			System.out.println("1 to add part to pallet");
			System.out.println("0 to exit");
			result = input.nextInt();
			switch(result){
			case 1 : { 
				Part tmp ;
				System.out.println("Insert the VIN of the car it belongs to:");
				input.nextLine();
				String vin = input.nextLine();
				System.out.println("Insert Type ");

				String type = input.nextLine();
				System.out.println("Insert Part Number");
				String partNo = input.nextLine();
				System.out.println("Insert wight ");
				double weight = input.nextDouble();
				input.nextLine();
				tmp = new Part(type,vin,partNo,weight);
				System.out.println("press y to confirm add");
				if(input.nextLine().equals("y")) {
					try {
						System.out.println(RMIClient.getInstance().getRemoteServer().addPartToPalet(tmp));
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


	


