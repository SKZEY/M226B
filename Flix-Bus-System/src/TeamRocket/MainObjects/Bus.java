<<<<<<< HEAD:Flix-Bus-System/src/TeamRocket/MainObjects/Bus.java
package TeamRocket.MainObjects;

public class Bus extends Vehicle {

	//0 single
	//1 double
	private int type;
	private int busNo;
	
	public Bus(int busNo, int type, int comfort , int capacity,int petrolTankCapacity) {
		super(capacity, comfort, petrolTankCapacity);
		this.type = type;
		this.busNo = busNo;
	}
	
	public int getBusNo () {
		return busNo;
	}

	public int getType () {
		return type;
	}
	public boolean getBusType() {
		if (type == 0) {
			return false;
		}
		else {
			return true;
		}
	}
}
=======
package MainObjects;

/*
 *  @author melvin 
 * */
/**
 * The Class Bus.
 */
public class Bus extends Vehicle {

	/** The type. */
	private int type;

	/** The bus no. */
	private int busNo;

	/**
	 * Instantiates a new bus.
	 *
	 * @param busNo              the bus no
	 * @param type               the type
	 * @param comfort            the comfort
	 * @param capacity           the capacity
	 * @param petrolTankCapacity the petrol tank capacity
	 * 
	 *                           Konstruktor für die Klasse Bus
	 */
	public Bus(int busNo, int type, int comfort, int capacity,
			int petrolTankCapacity) {
		super(capacity, comfort, petrolTankCapacity);
		this.type = type;
		this.busNo = busNo;
	}

	/**
	 * Gets the bus no.
	 *
	 * @return the bus no
	 */
	public int getBusNo() {
		return busNo;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * Gets the bus type.
	 *
	 * @return the bus type
	 */
	public boolean getBusType() {
		if (type == 0) {
			return false;
		} else {
			return true;
		}
	}
}
>>>>>>> origin/master:Flix-Bus-System/src/MainObjects/Bus.java
