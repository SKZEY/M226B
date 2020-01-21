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
