<<<<<<< HEAD:Flix-Bus-System/src/TeamRocket/MainObjects/Vehicle.java
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
=======
package MainObjects;

/*
 *  @author melvin 
 * */
/**
 * The Class Vehicle.
 */
public class Vehicle {

	/** The passenger capacity. */
	private int passengerCapacity;
	// 0 Basic
	/** The comfort. */
	private int comfort;

	/** The petrol tank capacity. */
	private int petrolTankCapacity;

	/**
	 * Instantiates a new vehicle.
	 *
	 * @param passengerCapacity  the passenger capacity
	 * @param comfort            the comfort
	 * @param petrolTankCapacity the petrol tank capacity
	 */
	public Vehicle(int passengerCapacity, int comfort, int petrolTankCapacity) {
		this.passengerCapacity = passengerCapacity;
		this.comfort = comfort;
		this.petrolTankCapacity = petrolTankCapacity;
	}

	/**
	 * Gets the passenger capacity.
	 *
	 * @return the passenger capacity
	 */
	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	/**
	 * Gets the comfort.
	 *
	 * @return the comfort
	 */
	public int getComfort() {
		return comfort;
	}

	/**
	 * Gets the petrol tank capacity.
	 *
	 * @return the petrol tank capacity
	 */
	public int getPetrolTankCapacity() {
		return petrolTankCapacity;
	}
}
>>>>>>> origin/master:Flix-Bus-System/src/MainObjects/Vehicle.java
