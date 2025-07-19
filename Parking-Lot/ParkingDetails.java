import java.util.ArrayList;

class ParkingDetails {
	
	int availableSlots=1;
	double carParkingFee=100.00;
	double bikeParkingFee=50.00;
	
	ArrayList<Vehicle> vehicleList=new ArrayList<>();
	
	
	public void addVehicle(String vehicleNumber,String type) {
		if(availableSlots>0) {
		vehicleList.add(new Vehicle(vehicleNumber,type));
		availableSlots--;
	}else {
		System.out.println("Parking Slot is Full!.");
	}
	}
	
	public void showSlots() {
		System.out.println("Available Slots: "+availableSlots);
	}
	
	public void showParkedVehicles() {
		for(Vehicle v:vehicleList) {
			System.out.println( "Vehicle Number: "+v.getVehicleNumber()+", Type: "+v.type);
		}
	}
	
	
	public void removeVehicle(String vehicleNo) {
		boolean removed = false;
	    for (int i = 0; i < vehicleList.size(); i++) {
	        if (vehicleList.get(i).getVehicleNumber().equals(vehicleNo)) {
	        	vehicleList.remove(i);
	            removed = true;
	            System.out.println("Vehicle removed successfully!.");
	            availableSlots++;
	            break;
	        }
	    }
	    if (!removed) {
	        System.out.println("[ERROR] Vehicle with " + vehicleNo + " not found.");
	    }
	}
	}
	
