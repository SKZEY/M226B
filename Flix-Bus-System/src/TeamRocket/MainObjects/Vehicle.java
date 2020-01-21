package TeamRocket.MainObjects;

public class Vehicle {
	
	
	private int passengerCapacity;
	//0 Basic
	//1 First Class
	private int comfort;
	private int petrolTankCapacity;
		
	public Vehicle (int passengerCapacity, int comfort, int petrolTankCapacity) {
		this.passengerCapacity = passengerCapacity;
		this.comfort = comfort;
		this.petrolTankCapacity = petrolTankCapacity;
	}
	
	public int getPassengerCapacity() {
		return passengerCapacity;
	}
	
	public int getComfort() {
		return comfort;
	}
	
	public int getPetrolTankCapacity() {
		return petrolTankCapacity;
	}
}
