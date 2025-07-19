class Vehicle {
	
	String vehicleNumber;
	String type;

	
	public Vehicle(String vehicleNumber,String type) {
		this.vehicleNumber=vehicleNumber;
		this.type=type;
	}
	
	public String getVehicleNumber() {
		return this.vehicleNumber;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String toString() {
		return "Vehicle Number: "+vehicleNumber+", Type: "+type;
	}
	
}
