import java.util.Scanner;

public class ParkingLotManagementSystem {
	public static void main(String[] args) {
		ParkingDetails pd=new ParkingDetails();
		
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.println("\n----PARKING MANAGEMENT SYSTEM----");
			System.out.println("1. Add Vehicle");
			System.out.println("2. Remove Vehicle");
			System.out.println("3. Show Available Slots");
			System.out.println("4. Show Parked Vehicles");
			System.out.println("5. Calculate Parking Fee");
			System.out.println("6. Exit");
			System.out.print("Choose an option: ");
			int input=sc.nextInt();
			switch(input) {
			
			case 1: System.out.print("Enter Vehicle Number: ");
			String vehicleNo=sc.next();
			System.out.print("Enter Vehicle Type (Car/Bike): ");
			String vehicletype=sc.next();
			pd.addVehicle(vehicleNo, vehicletype);
			System.out.println("Vehicle parked successfully!");
			break;
			
			
			case 2:System.out.print("Enter vehicle number to remove:");
			String remove=sc.next();
			pd.removeVehicle(remove);
			break;
			case 3:
			pd.showSlots();
			break;
			case 4:
			pd.showParkedVehicles();
			break;
			case 5:
			String vno;
			System.out.print("Enter vehicle type to calculate fee: ");
			vno=sc.next();
			vno=vno.toLowerCase();
			if(vno.equals("car")) {
				System.out.println("Parking fee for vehicle type car is: "+pd.carParkingFee+"INR");
			}else if(vno.equals("bike")){
				System.out.println("Parking fee for vehicle type bike is: "+pd.bikeParkingFee+"INR");
			}else {
				System.out.println("Invalid Vehicle Type, Choose between Car & Bike.");
			}
			break;
			case 6:System.out.println("Exiting...Bye!");
			sc.close();
			System.exit(0);
			}
			
		}
	}

}
