<<<<<<< HEAD:Flix-Bus-System/src/TeamRocket/MainObjects/Travel.java
package TeamRocket.MainObjects;
import java.util.Comparator;
import java.util.Date;

public class Travel {
	
	private String destination;
	private Date  arrivalTime;
	private Date departureTime;
	private Bus bus;
	private int  travelNo; 
	
	
	public Travel (int travelNo, String destination, Date arrivalTime, Date departureTime, Bus bus) {
		this.destination = destination;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.bus = bus;
		this.travelNo = travelNo;
		
	}
	
	public static Comparator<Travel> travelAbfahrtComparator = new Comparator<Travel>() {
		
		public int compare(Travel t1, Travel t2) {
			String travelAbfahrt1 = t1.getDepartureTime().toString();
			String travelAbfahrt2 = t2.getDepartureTime().toString();
			return travelAbfahrt1.compareTo(travelAbfahrt2);
		}
	};
	
	public boolean isNationalTravle() {
		return bus.getBusType();
	}
	
	public Bus getBus() {
		return bus;
	}
	public Date getArrivalTime() {
		return arrivalTime;
		
	}
	public Date getDepartureTime() {
		return departureTime;
		
	}
	public String getDestination() {
		return destination;
		
	}
	
	public int getTravelNo() {
		return travelNo;
	}

}
=======
package MainObjects;

import java.util.Comparator;
import java.util.Date;

/*
 *  @author melvin 
 * */
/**
 * The Class Travel.
 */
public class Travel {

	/** The destination. */
	private String destination;

	/** The arrival time. */
	private Date arrivalTime;

	/** The departure time. */
	private Date departureTime;

	/** The bus. */
	private Bus bus;

	/** The travel no. */
	private int travelNo;

	/**
	 * Instantiates a new travel.
	 *
	 * @param travelNo      the travel no
	 * @param destination   the destination
	 * @param arrivalTime   the arrival time
	 * @param departureTime the departure time
	 * @param bus           the bus
	 */
	public Travel(int travelNo, String destination, Date arrivalTime,
			Date departureTime, Bus bus) {
		this.destination = destination;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.bus = bus;
		this.travelNo = travelNo;

	}

	/** The travel abfahrt comparator. */
	public static Comparator<Travel> travelAbfahrtComparator = new Comparator<Travel>() {

		public int compare(Travel t1, Travel t2) {
			String travelAbfahrt1 = t1.getDepartureTime().toString();
			String travelAbfahrt2 = t2.getDepartureTime().toString();
			return travelAbfahrt1.compareTo(travelAbfahrt2);
		}
	};

	/**
	 * Checks if is national travle.
	 *
	 * @return true, if is national travle
	 */
	public boolean isNationalTravle() {
		return bus.getBusType();
	}

	/**
	 * Gets the bus.
	 *
	 * @return the bus
	 */
	public Bus getBus() {
		return bus;
	}

	/**
	 * Gets the arrival time.
	 *
	 * @return the arrival time
	 */
	public Date getArrivalTime() {
		return arrivalTime;

	}

	/**
	 * Gets the departure time.
	 *
	 * @return the departure time
	 */
	public Date getDepartureTime() {
		return departureTime;

	}

	/**
	 * Gets the destination.
	 *
	 * @return the destination
	 */
	public String getDestination() {
		return destination;

	}

	/**
	 * Gets the travel no.
	 *
	 * @return the travel no
	 */
	public int getTravelNo() {
		return travelNo;
	}

}
>>>>>>> origin/master:Flix-Bus-System/src/MainObjects/Travel.java
