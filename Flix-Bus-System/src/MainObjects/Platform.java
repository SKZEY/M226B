package MainObjects;

import java.util.ArrayList;

public class Platform {

	
	private int platformNo;
	private int platformSize;
	private ArrayList<Travel> travelList;
	private int occupied;
	
	public Platform(int platformNo, int platformSize, ArrayList<Travel> travelList) {
		this.platformNo = platformNo;
		this.platformSize = platformSize;
		this.travelList = travelList;
	}
	
	

	
	public void busArriveInPlatform() {
		this.occupied = 1;
	}
	public void busLeaveFromPlatform() {
		this.occupied = 0;
	}
	
	public int isPlatformOccupied() {
		return occupied;
	}
	
	public int getPlatformNo() {
		return platformNo;
	}
	
	public int getPlatformSize() {
		return platformSize;
	}
	
	public ArrayList<Travel> getTravelList() {
		return travelList;
	}
	
}
