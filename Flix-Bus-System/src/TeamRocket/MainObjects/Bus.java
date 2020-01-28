package TeamRocket.MainObjects;

/**
 * The Class Bus.
 * 
 * @author Severin Hasler, Melvin Tas, Jonas Tochtermann
 */
public class Bus extends Vehicle {

	/** The type. */
	private int type;

	/** The bus no. */
	private int busNo;

	/**
	 * Instantiates a new bus.
	 *
	 * @param busNo              the bus number
	 * @param type               the type
	 * @param comfort            the comfort type
	 * @param capacity           the capacity
	 * @param petrolTankCapacity the petrol tank capacity
	 *
	 * 
	 */
	public Bus(int busNo, int type, int comfort, int capacity,
			int petrolTankCapacity) {
		super(capacity, comfort, petrolTankCapacity);
		this.type = type;
		this.busNo = busNo;
	}

	/**
	 * Gets the bus number.
	 *
	 * @return the bus number
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
