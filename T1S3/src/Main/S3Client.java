package Main;
import java.net.SocketTimeoutException;
import java.rmi.RemoteException;
import java.util.Scanner;
import Model.*;
import RMIClient.*;
public class S3Client {
	
	public static void main(String[] args) {
		boolean running = true;
		Scanner input = new Scanner(System.in);
		int result ;
		while(running) {
			System.out.println("Choose option:");
			System.out.println("1 to create new package");
			System.out.println("0 to exit");
			result = input.nextInt();
			switch(result){
			case 1 : { 
				System.out.println("Declre the type of package");
				input.nextLine();
				long packID = 0;
				String type = input.nextLine();
				try {
					packID = RMIClient.getInstance().getRemoteServer().creteNewPackage(type);
					System.out.println("New package created with id " + packID);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				boolean packaging = true;
				int result1 ;
				while(packaging) {
					System.out.println("You are now adding itmes to package with id " + packID);
					System.out.println("Choose option");
					System.out.println("1 to add item to package");
					System.out.println("2 to add multiple items of same type");
					System.out.println("0 to exit");
					result1 = input.nextInt();
					switch(result1) {
					case 1 : {
						System.out.println("Input the part number for the part to be added");
						input.nextLine();
						String partNo = input.nextLine();
						try {
							System.out.println(RMIClient.getInstance().getRemoteServer().addPartToPack(partNo, ""+packID));
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}break;
					case 2 : {
					System.out.println("Input the part type for the part to be added");
					input.nextLine();
					String partType = input.nextLine();
					System.out.println("Input the quantity for the part to be added");
					int quantity = input.nextInt();
					input.nextLine();
					try {
						System.out.println(RMIClient.getInstance().getRemoteServer().addToPackageByType(partType, quantity, ""+packID));
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
					break;
					case 0: {
						packaging = false;
					} break;
					default : packaging = false;
					break;
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


	


