package MainObjects;

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
